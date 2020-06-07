package demo.connectSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class testConnection {
	public static void main(String[] args) {
		Connection con = null;
		try {
			//khai bao dung mysql jdbc driver
			Class.forName("com.mysql.jdbc.Driver");
			/*
			 *  tao connection : "jdbc:mysql://localhost/<ten co so du lieu>", "<account>", "<mat khau>"
			 */
			con = DriverManager.getConnection("jdbc:mysql://localhost/csdl", "root", "");
			System.out.print("Database is connected !");
			//tao query truy van
			String query = "SELECT * FROM monhoc";
			//----------thuc thi truy van va lay ket qua tra ve resultset
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			//----------
			System.out.println("\n");
			// doc result set
			while (rs.next()) {
				String id = rs.getString("MaMonHoc");
				String Name = rs.getString("TenMonHoc");
				String des = rs.getString("MoTa");

				// print the results
				System.out.format("%s, %s, %s\n", id, Name, des);
			}
			con.close(); //dong connection
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// System.out.println("Cannot connect the db " + e.getStackTrace());
		}
	}

}
