package utils;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import beans.*;
import connect.ConnectionUtils;
public class DBUtils {
	public static List<Product> queryProduct(Connection con) throws SQLException{
		String sqlgetAll = "select * from product";
		PreparedStatement pr = con.prepareStatement(sqlgetAll);
		ResultSet rs = pr.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while(rs.next()) {
			Product pd = new Product(rs.getString(1), rs.getString(2), rs.getFloat(3));
			list.add(pd);
		}
		return list;
	}
	public static Product findProduct(Connection con, String code) throws SQLException{
		String sqlfind = "select * from product where code=?";
		PreparedStatement pr = con.prepareStatement(sqlfind);
		pr.setString(1, code);
		ResultSet rs = pr.executeQuery();
		while(rs.next()) {
			Product pd = new Product(rs.getString(1),rs.getString(2),rs.getFloat(3));
			return pd;
		}
		return null;
		
	}
	public static void updateProduct(Connection con, Product pd) throws SQLException {
		String sqlUpdate = "update product set name=?,price=? where code=?";
		PreparedStatement pr = con.prepareStatement(sqlUpdate);
		pr.setString(1, pd.getName());
		pr.setFloat(2, pd.getPrice());
		pr.setString(3, pd.getCode());
		pr.executeUpdate();
		System.out.println("update tahnh cong");
	}
	public static void deleteProduct(Connection con, String code) throws SQLException{
		String sqlDelete = "delete from product where code =?";
		PreparedStatement pr = con.prepareStatement(sqlDelete);
		pr.setString(1, code);
		pr.execute();
	}
	public static void insertProduct(Connection con,Product pd) throws SQLException{
		
		String sqlInsert = "insert into product set code = ?,name = ?, price = ?";
		PreparedStatement pr = con.prepareStatement(sqlInsert);
		pr.setString(1, pd.getCode());
		pr.setString(2, pd.getName());
		pr.setFloat(3, pd.getPrice());
		pr.executeUpdate();
		System.out.println("them thanh cong");
		
	}
	public static void PrintListProduct(Connection con) throws SQLException,ClassNotFoundException{
		List list = queryProduct(con);
		for(int i = 0;i<list.size();i++) {
			Product p = (Product) list.get(i);
			p.printlnInfor();
		}
	}
	public static void main(String args[]) throws Exception {
		try {

			Connection con=ConnectionUtils.getConnection();
//			PrintListProduct(con) ;
			Product pd=new Product("2","Quan dui 123",2000);
			updateProduct(con,pd);
//			deleteProduct(con, "ggg");
//			insertProduct(con, pd);
//			System.out.println("sau khi update: ");
			PrintListProduct(con) ;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
