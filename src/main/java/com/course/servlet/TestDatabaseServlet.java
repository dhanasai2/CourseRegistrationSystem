package com.course.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestDatabaseServlet")
public class TestDatabaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
            Connection conn = DatabaseConnection.getConnection();
            if (conn != null) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset='UTF-8'>");
                out.println("<title>Database Test</title>");
                out.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() + "/styles.css'>");
                out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class='container' style='max-width: 600px; margin-top: 100px;'>");
                out.println("<div class='success-message'>");
                out.println("<h2>✅ Database Connection Successful!</h2>");
                out.println("<p>MySQL database is connected and ready to use.</p>");
                out.println("</div>");
                out.println("<div class='btn-group'>");
                out.println("<a href='registration.html' class='btn btn-primary'>Test Registration Form</a>");
                out.println("<a href='login.html' class='btn btn-secondary'>Test Login Form</a>");
                out.println("</div>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
                DatabaseConnection.closeConnection(conn);
            }
        } catch (Exception e) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>Database Error</title>");
            out.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() + "/styles.css'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container' style='max-width: 600px; margin-top: 100px;'>");
            out.println("<div class='error-message'>");
            out.println("<h2>❌ Database Connection Failed!</h2>");
            out.println("<p><strong>Error:</strong> " + e.getMessage() + "</p>");
            out.println("<p><strong>Check:</strong></p>");
            out.println("<ul>");
            out.println("<li>MySQL server is running</li>");
            out.println("<li>Database password is correct in DatabaseConnection.java</li>");
            out.println("<li>MySQL JDBC driver is added to project</li>");
            out.println("</ul>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
