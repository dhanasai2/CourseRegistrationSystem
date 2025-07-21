package com.course.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        if (StudentDatabase.validateLogin(email, password)) {
            HttpSession session = request.getSession();
            Student student = StudentDatabase.findByEmail(email);
            session.setAttribute("student", student);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>Welcome Dashboard</title>");
            out.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() + "/styles.css'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<div class='header'>");
            out.println("<h2>Welcome, " + student.getFirstName() + "!</h2>");
            out.println("<p>Login successful. Here's your profile information:</p>");
            out.println("</div>");
            
            out.println("<div class='form-content'>");
            out.println("<div class='success-message'>");
            out.println("<h3>Profile Details</h3>");
            out.println("</div>");
            
            out.println("<table class='data-table'>");
            out.println("<tr><th>Field</th><th>Value</th></tr>");
            out.println("<tr><td>Full Name</td><td>" + student.getFirstName() + " " + student.getLastName() + "</td></tr>");
            out.println("<tr><td>Email</td><td>" + student.getEmail() + "</td></tr>");
            out.println("<tr><td>Phone</td><td>" + student.getPhone() + "</td></tr>");
            out.println("<tr><td>Gender</td><td>" + student.getGender() + "</td></tr>");
            out.println("<tr><td>Education Level</td><td>" + student.getEducation() + "</td></tr>");
            
            out.println("<tr><td>Enrolled Courses</td><td>");
            if (student.getCourses() != null) {
                for (String course : student.getCourses()) {
                    out.println("• " + course + "<br>");
                }
            } else {
                out.println("No courses enrolled");
            }
            out.println("</td></tr>");
            
            out.println("<tr><td>Learning Mode</td><td>" + student.getLearningMode() + "</td></tr>");
            out.println("<tr><td>Comments</td><td>" + (student.getComments() != null ? student.getComments() : "None") + "</td></tr>");
            out.println("</table>");
            
            out.println("<div class='btn-group'>");
            out.println("<a href='AllStudentsServlet' class='btn btn-primary'>View All Students</a>");
            out.println("<a href='login.html' class='btn btn-secondary'>Logout</a>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            
        } else {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>Login Failed</title>");
            out.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() + "/styles.css'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container' style='max-width: 600px; margin-top: 100px;'>");
            out.println("<div class='error-message'>");
            out.println("<h2>Login Failed</h2>");
            out.println("<p>Invalid email or password!</p>");
            out.println("</div>");
            out.println("<div class='btn-group'>");
            out.println("<a href='login.html' class='btn btn-primary'>Try Again</a>");
            out.println("<a href='registration.html' class='btn btn-secondary'>Register New Account</a>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
