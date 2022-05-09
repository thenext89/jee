package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Product;
import connect.MyUtils;
import utils.DBUtils;

/**
 * Servlet implementation class CreateProductServlet
 */
@WebServlet("/createProduct")
public class CreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = MyUtils.getStoredConnection(request);
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String priceStr = request.getParameter("price");
		String errorString = null;
		float price = 0;
		try {
			price = Float.parseFloat(priceStr);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		Product pd = new Product(code,name,price);
		if(code==null) {
			errorString = "Product is invlaid";
//			pd.printlnInfor();
		}
		if(errorString == null) {
			try {
				DBUtils.insertProduct(con, pd);
			} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("product", pd);
		if(errorString!=null) {
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/productList");
		}
		
	}

}
