/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.login.LoginModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author ABHINOOR
 */
public class LoginDao {
    String url_db = "jdbc:mysql://localhost:3306/notes_organization_system";
    String username_db = "root";
    String password_db = "Biotechnology08";
    
    public int authenticateUser(LoginModel user) throws ClassNotFoundException, SQLException{
        String select_sql = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";
        boolean isAuthenticated = false;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url_db, username_db, password_db);
            PreparedStatement stm = con.prepareStatement(select_sql);
            
            stm.setString(1, user.getUsername());
            stm.setString(2, user.getPassword());
        
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                int count = rs.getInt(1);
                if(count>0){
                    isAuthenticated = true;
                }
            }
            con.close();
        }
        catch(Exception e){
            e.printStackTrace(); 
        }
        return isAuthenticated ? 1:0;
    }
    
}
