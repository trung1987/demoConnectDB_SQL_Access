package demo.connectSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testConnectAccess {

	public static void main(String[] args) {
		Connection con = null;
		// TODO Auto-generated method stub
		try {
			String database = System.getProperty("user.dir")+ "/db_access/" +"csdl.accdb";
			String url = "jdbc:ucanaccess://" + database;
			con = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM monhoc");

			while (rs.next()) {
				String id = rs.getString("MaMonHoc");
				String Name = rs.getString("TenMonHoc");
				String des = rs.getString("MoTa");

				// print the results
				System.out.format("%s, %s, %s\n", id, Name, des);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
