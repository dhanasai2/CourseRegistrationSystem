package com.course.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        String education = request.getParameter("education");
        String[] courses = request.getParameterValues("courses");
        String learningMode = request.getParameter("learningMode");
        String comments = request.getParameter("comments");
        
        if (StudentDatabase.emailExists(email)) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>Registration Failed</title>");
            out.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() + "/styles.css'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container' style='max-width: 600px; margin-top: 100px;'>");
            out.println("<div class='error-message'>");
            out.println("<h2>Registration Failed</h2>");
            out.println("<p>User with this email already exists!</p>");
            out.println("</div>");
            out.println("<div class='btn-group'>");
            out.println("<a href='registration.html' class='btn btn-primary'>Try Again</a>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            return;
        }
        
        Student student = new Student(firstName, lastName, email, password, phone, 
                                    gender, education, courses, learningMode, comments);
        
        boolean success = StudentDatabase.addStudent(student);
        
        if (success) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>Registration Successful</title>");
            out.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() + "/styles.css'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<div class='header'>");
            out.println("<h2>Registration Successful!</h2>");
            out.println("<p>Your account has been created and saved to the database.</p>");
            out.println("</div>");
            out.println("<div class='form-content'>");
            out.println("<div class='success-message'>");
            out.println("<h3>Student Details</h3>");
            out.println("</div>");
            out.println("<table class='data-table'>");
            out.println("<tr><th>Field</th><th>Value</th></tr>");
            out.println("<tr><td>Name</td><td>" + firstName + " " + lastName + "</td></tr>");
            out.println("<tr><td>Email</td><td>" + email + "</td></tr>");
            out.println("<tr><td>Phone</td><td>" + phone + "</td></tr>");
            out.println("<tr><td>Gender</td><td>" + gender + "</td></tr>");
            out.println("<tr><td>Education</td><td>" + education + "</td></tr>");
            
            out.println("<tr><td>Selected Courses</td><td>");
            if (courses != null) {
                for (String course : courses) {
                    out.println("• " + course + "<br>");
                }
            } else {
                out.println("No courses selected");
            }
            out.println("</td></tr>");
            
            out.println("<tr><td>Learning Mode</td><td>" + learningMode + "</td></tr>");
            out.println("<tr><td>Comments</td><td>" + (comments != null ? comments : "None") + "</td></tr>");
            out.println("</table>");
            
            out.println("<div class='btn-group'>");
            out.println("<a href='login.html' class='btn btn-primary'>Login Now</a>");
            out.println("<a href='registration.html' class='btn btn-secondary'>Register Another</a>");
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
            out.println("<title>Registration Failed</title>");
            out.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() + "/styles.css'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container' style='max-width: 600px; margin-top: 100px;'>");
            out.println("<div class='error-message'>");
            out.println("<h2>Registration Failed</h2>");
            out.println("<p>Database error occurred. Please try again.</p>");
            out.println("</div>");
            out.println("<div class='btn-group'>");
            out.println("<a href='registration.html' class='btn btn-primary'>Try Again</a>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
