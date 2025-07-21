package com.course.servlet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDatabase {
    
    public static boolean addStudent(Student student) {
        String sql = "INSERT INTO students (first_name, last_name, email, password, phone, gender, education, courses, learning_mode, comments) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, student.getFirstName());
            stmt.setString(2, student.getLastName());
            stmt.setString(3, student.getEmail());
            stmt.setString(4, student.getPassword());
            stmt.setString(5, student.getPhone());
            stmt.setString(6, student.getGender());
            stmt.setString(7, student.getEducation());
            
            // Convert courses array to comma-separated string
            String coursesStr = "";
            if (student.getCourses() != null) {
                coursesStr = String.join(", ", student.getCourses());
            }
            stmt.setString(8, coursesStr);
            
            stmt.setString(9, student.getLearningMode());
            stmt.setString(10, student.getComments());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static Student findByEmail(String email) {
        String sql = "SELECT * FROM students WHERE email = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Student student = new Student();
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setEmail(rs.getString("email"));
                student.setPassword(rs.getString("password"));
                student.setPhone(rs.getString("phone"));
                student.setGender(rs.getString("gender"));
                student.setEducation(rs.getString("education"));
                
                // Convert comma-separated courses back to array
                String coursesStr = rs.getString("courses");
                if (coursesStr != null && !coursesStr.isEmpty()) {
                    student.setCourses(coursesStr.split(", "));
                }
                
                student.setLearningMode(rs.getString("learning_mode"));
                student.setComments(rs.getString("comments"));
                
                return student;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public static boolean validateLogin(String email, String password) {
        Student student = findByEmail(email);
        return student != null && student.getPassword().equals(password);
    }
    
    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students ORDER BY registration_date DESC";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Student student = new Student();
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setEmail(rs.getString("email"));
                student.setPassword(rs.getString("password"));
                student.setPhone(rs.getString("phone"));
                student.setGender(rs.getString("gender"));
                student.setEducation(rs.getString("education"));
                
                // Convert comma-separated courses back to array
                String coursesStr = rs.getString("courses");
                if (coursesStr != null && !coursesStr.isEmpty()) {
                    student.setCourses(coursesStr.split(", "));
                }
                
                student.setLearningMode(rs.getString("learning_mode"));
                student.setComments(rs.getString("comments"));
                
                students.add(student);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return students;
    }
    
    public static boolean emailExists(String email) {
        return findByEmail(email) != null;
    }
}
