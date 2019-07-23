import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;


//  Student.java creates an object for each student within the students.csv file.

public class Student{
    // Private Variables
    private int id;
    private String studentName;
    private ArrayList<Test> marks;
    private double gradeAverage;

    // Public Variables
    public PriorityQueue<Course> courseList;
    public HashMap<Integer, Double> courseGrades;
    public HashSet<Integer> set;

    // Constructor
    public Student(int id, String name){
        this.id = id;
        this.studentName = name;

        // Create CourseList as a priority queue.
        // This will make printing the courses much easier when attempting to extract information for the output.
        this.courseList = new PriorityQueue<Course>(new Comparator<Course>(){
            @Override
            public int compare(Course c1, Course c2){
                if (c1.getID() < c2.getID()) return -1;
                else if (c1.getID() > c2.getID()) return 1;
                return 0;
            }
        });

        this.courseGrades = new HashMap<Integer, Double>();
        this.marks = new ArrayList<Test>();
        this.gradeAverage = 0.0;
        this.set = new HashSet<>();
    }

    // Getters
    public int getID() { return this.id; }
    public String getStudentName() { return this.studentName; }
    public double getGrade() { return this.gradeAverage; }

    // Setters
    public void setID(int id) { this.id = id; }
    public void setStudentName(String name) { this.studentName = name; }

    // Helper Functions
    public void calculateGrade() {
        double total = 0.0;
        double count = 0.0;
        for (double d : courseGrades.values()){
            total += d;
            count++;
        }
        this.gradeAverage = total / count;
    }

    public void addTest(Test test){
        this.marks.add(test);
    }

    public void addCourse(Course course, double gradeToAdd){
        if (!courseGrades.containsKey(course.getID())){
            courseGrades.put(course.getID(), gradeToAdd);
        }
        else{
            double grade = courseGrades.get(course.getID()) + gradeToAdd;
            courseGrades.put(course.getID(), grade);
        }
    }

    public String toString() {
        return "Student Id: " + this.id + ", name: " + this.studentName;
    }


    
}