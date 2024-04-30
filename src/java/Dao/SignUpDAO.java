/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.signup.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ABHINOOR
 */
public class SignUpDAO {
    
    String url_db = "jdbc:mysql://localhost:3306/notes_organization_system";
    String username_db = "root";
    String password_db = "Biotechnology08";
    
    /**
     *
     * @param user
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int registerUser(SgnUpModel user) {
        String insert_sql = "insert into `users`(`name`,`username`,`password`)values(?,?,?)";
        int result = 0;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url_db, username_db, password_db);
                PreparedStatement stm = con.prepareStatement(insert_sql);
            stm.setString(1,user.getName());
            stm.setString(2,user.getUsername());
            stm.setString(3,user.getPassword());
            
            result = stm.executeUpdate();
            con.close();
        }catch(Exception e){
            e.printStackTrace(); 
        }
        return result;
    }
}
