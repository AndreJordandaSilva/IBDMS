/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.drone_web_server;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connect1{ 
    public java.sql.Connection con=null;
public Connect1() throws ClassNotFoundException, SQLException{  
Class.forName("com.mysql.jdbc.Driver"); 
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ibdms_server","root","");
}}