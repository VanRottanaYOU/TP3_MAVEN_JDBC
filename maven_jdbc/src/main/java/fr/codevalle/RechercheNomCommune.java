package fr.codevalle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RechercheNomCommune {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/formation","root","root");
			Statement stmt = conn.createStatement();
			String strSelect = "select nom from mairie";
			ResultSet rset = stmt.executeQuery(strSelect);
			int rowCount = 0;
			while (rset.next()) {
				++rowCount;
			}
			System.out.println("Nombre de mairie = " + rowCount);

		} catch (SQLException e) {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			e.printStackTrace();
		}

	}

}
