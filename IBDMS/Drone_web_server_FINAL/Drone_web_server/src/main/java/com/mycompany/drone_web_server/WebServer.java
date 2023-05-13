/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.drone_web_server;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
 
@Path("/WebServerTruck")
public class WebServer {
 
    @GET
    @Produces(MediaType.TEXT_PLAIN)
     public void sendTruck(){
        Connection cn=null;
        try
        {
            ResultSet rs1;
            Statement stmt=cn.createStatement();
            rs1=stmt.executeQuery("select * from fire where isActive='1'");
            if(rs1.next()){ 
                
                ResultSet rs,rslt,rsltAr;
                rs = stmt.executeQuery("select id from fire where isActive='1'");
                while(rs.next()){
                      rslt=stmt.executeQuery("select * from truck where designatedFireId='0'");
                      if(rslt.next()){ 
                          rsltAr = stmt.executeQuery("select id from truck where designatedFireId='0' limit 0,1 ");
                           while(rsltAr.next()){
                               Statement stmtnew=cn.createStatement();
                               stmtnew.executeUpdate("update truck set cat='"+rs.getString(1)+"' where id='"+rsltAr.getString(1)+"'" );

                           }
                      }
                }
            }
            cn.close();
        
        }
        catch(Exception e){
            System.out.println(e);

        }

    }
}




