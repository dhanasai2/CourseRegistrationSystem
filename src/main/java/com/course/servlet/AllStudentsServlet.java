package com.course.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AllStudentsServlet")
public class AllStudentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        List<Student> students = StudentDatabase.getAllStudents();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>All Students</title>");
        out.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() + "/styles.css'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<div class='header'>");
        out.println("<h2>All Registered Students</h2>");
        out.println("<p>Total Students: " + students.size() + "</p>");
        out.println("</div>");
        
        out.println("<div class='form-content'>");
        if (students.isEmpty()) {
            out.println("<div class='error-message'>");
            out.println("<p>No students registered yet.</p>");
            out.println("</div>");
        } else {
            out.println("<table class='data-table'>");
            out.println("<tr>");
            out.println("<th>Name</th><th>Email</th><th>Phone</th><th>Gender</th>");
            out.println("<th>Education</th><th>Courses</th><th>Learning Mode</th>");
            out.println("</tr>");
            
            for (Student student : students) {
                out.println("<tr>");
                out.println("<td>" + student.getFirstName() + " " + student.getLastName() + "</td>");
                out.println("<td>" + student.getEmail() + "</td>");
                out.println("<td>" + student.getPhone() + "</td>");
                out.println("<td>" + student.getGender() + "</td>");
                out.println("<td>" + student.getEducation() + "</td>");
                
                out.println("<td>");
                if (student.getCourses() != null) {
                    for (int i = 0; i < student.getCourses().length; i++) {
                        out.println(student.getCourses()[i]);
                        if (i < student.getCourses().length - 1) {
                            out.println("<br>");
                        }
                    }
                } else {
                    out.println("None");
                }
                out.println("</td>");
                
                out.println("<td>" + student.getLearningMode() + "</td>");
                out.println("</tr>");
            }
            
            out.println("</table>");
        }
        
        out.println("<div class='btn-group'>");
        out.println("<a href='registration.html' class='btn btn-primary'>Register New Student</a>");
        out.println("<a href='login.html' class='btn btn-secondary'>Login</a>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}
