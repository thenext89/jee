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
 * Servlet implementation class EditProductServlet
 */
@WebServlet("/editProduct")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = MyUtils.getStoredConnection(request);
		String code = request.getParameter("code");
		Product pd = null;
		String errorString = null;
		try {
			pd = DBUtils.findProduct(con, code);
		}catch(SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
			System.out.println("loi o editproduct ne");
		}
		if(errorString!=null&&pd==null) {
			response.sendRedirect(request.getContextPath()+"/productList");
			return;
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("product", pd);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/editProductView.jsp");
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
		try{
			price = Float.parseFloat(priceStr);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		Product pd = new Product(code,name,price);
		try {
			DBUtils.updateProduct(con, pd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorString = e.getMessage();
			System.out.println("sai o phan nay");
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("product", pd);
		if(errorString!=null) {
			RequestDispatcher dispatcher = request.getServletContext().getNamedDispatcher("/WEB-INF/views/editProductView.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/productList");
		}
	}

}
