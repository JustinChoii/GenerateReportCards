//  Test.java creates an object for each test within the tests.csv file.

public class Test{
    // Private Variables
    private int id;
    private int courseID;
    private double weight;
    private double grade;

    // Constructor
    public Test(Test test){
        this.id = test.id;
        this.courseID = test.courseID;
        this.weight = test.weight;
    }
    public Test(int id, int courseID, double weight){
        this.id = id;
        this.courseID = courseID;
        this.weight = weight;
    }

    // Getters
    public int getID() { return this.id; }
    public int getCourseID() { return this.courseID; }
    public double getWeight() { return this.weight; }
    public double getGrade() { return this.grade; }

    // Setters
    public void setID(int id) { this.id = id; }
    public void setCourseID(int id) { this.courseID = id; }
    public void setWeight(double weight) { this.weight = weight; }
    public void setGrade(double grade) { this.grade = grade; }
}