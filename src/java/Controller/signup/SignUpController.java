/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.signup;

import Dao.SignUpDAO;
import Model.signup.SgnUpModel;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ABHINOOR
 */
@WebServlet(name = "SignUpController", urlPatterns = {"/SignUpController"})
public class SignUpController extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Step1- Get information from model class
        
        //Here I am getting the user inputs from request parameters
             
    }
      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        SgnUpModel user = new SgnUpModel(name,username,password);
//        user.setName(name);
//        user.setUsername(username);
//        user.setPassword(password);
        
        SignUpDAO dao = new SignUpDAO();
        int result = dao.registerUser(user);
        
        // step 2- redirect to next webpage
            if (result > 0) {
            response.sendRedirect("dashboard.html");
        } else {
            // Handle registration failure
            // You can forward to an error page or display a message
            // Example: request.getRequestDispatcher("error.jsp").forward(request, response);
            // Or: response.sendRedirect("error.html");
                RequestDispatcher dispatcher = request.getRequestDispatcher("Login.html");
                dispatcher.forward(request, response);
//            response.sendRedirect("Login.html");
        }
    }
}