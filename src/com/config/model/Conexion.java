package com.config.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	Connection con;
	String url="jdbc:mysql://localhost::3306/bd_ventas";
	String user="root";
	String pass="Luissante18";
	public Connection Conexion(){
		try {/*realizar una conexion*/
			Class.forName("com.mysql.jdbc.Driver");//direccion
			con = DriverManager.getConnection(url,user,pass);
		} catch (Exception e) {
			
		}
		return con;
	}
}
