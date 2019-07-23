//  Course.java creates an object for each course within the courses.csv file.


public class Course{
    // Private Variables
    private int id;
    private String courseName;
    private String teacher;
    private double grade;

    // Constructor
    public Course(int id, String name, String teacher){
        this.id = id;
        this.courseName = name;
        this.teacher = teacher;
        this.grade = 0.0;
    }

    // Getters
    public int getID() { return this.id; }
    public String getCourseName() { return this.courseName; }
    public String getTeacher() { return this.teacher; }
    public Double getGrade() { return this.grade; }


    // Setters
    public void setID(int id) { this.id = id; }
    public void setCourseName(String name) { this.courseName = name; }
    public void setTeacher(String teacher) { this.teacher = teacher; }
    public void setGrade(double grade) { this.grade = grade; }

    // Helper Functions
    public String toString() {
        return "Course: " + this.courseName + ", Teacher: " + this.teacher;
    }
}