package com.course.servlet;

public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String gender;
    private String education;
    private String[] courses;
    private String learningMode;
    private String comments;
    
    // Default constructor
    public Student() {}
    
    // Parameterized constructor
    public Student(String firstName, String lastName, String email, String password, 
                  String phone, String gender, String education, String[] courses, 
                  String learningMode, String comments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.gender = gender;
        this.education = education;
        this.courses = courses;
        this.learningMode = learningMode;
        this.comments = comments;
    }
    
    // Getters and Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    
    public String getEducation() { return education; }
    public void setEducation(String education) { this.education = education; }
    
    public String[] getCourses() { return courses; }
    public void setCourses(String[] courses) { this.courses = courses; }
    
    public String getLearningMode() { return learningMode; }
    public void setLearningMode(String learningMode) { this.learningMode = learningMode; }
    
    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }
}
