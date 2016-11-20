/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package STC_Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Marcus
 */
public class SQLConnectivity {
    
    Connection con;
    
    public void openConnection() throws ClassNotFoundException, SQLException{    
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        System.out.println("SQL Driver loaded");
        
//CONNECTION VIA INTERNET TO SQL SERVER       
// String url = "jdbc:sqlserver://213.114.154.252:52392;databaseName=db_STC;user=sa;password=pass";

//CONNECTION VIA LOCALHOST
        String url = "jdbc:sqlserver://localhost:52392;databaseName=db_STC;user=sa;password=pass";
        con = DriverManager.getConnection(url);
        System.out.println("Connection to sql server established");
    }
    
    public int getNewID() throws ClassNotFoundException, SQLException { 
        
        openConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT MAX(id) FROM Client");
        rs.next();
        int id = rs.getInt(1);
        id++;             
        con.close();        
        return id+1000;
    }


    public ArrayList<Client> getClients() throws ClassNotFoundException, SQLException {
        openConnection();
        ArrayList<Client> clients = new ArrayList<>();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("Select * from Client");
        while (rs.next()) {
            Client c = new Client(rs.getInt(1), rs.getString(2));
            clients.add(c);
        }
        con.close();
        return clients;
    }

}
