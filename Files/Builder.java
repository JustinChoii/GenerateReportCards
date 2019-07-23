import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Builder{
    // Public Variables
    public static HashMap<Integer, Student> students;
    public static HashMap<Integer, Course> courses;
    public static HashMap<Integer, Test> tests;
    public static PriorityQueue<Student> queue;
    public static HashSet<Integer> set;

    // Constructor
    public Builder(){
        students = new HashMap<Integer, Student>();
        courses = new HashMap<Integer, Course>();
        tests = new HashMap<Integer, Test>();
        //this.queue = new PriorityQueue<Student>();
        this.queue = new PriorityQueue<Student>(new Comparator<Student>(){
            @Override
            public int compare(Student s1, Student s2){
                if (s1.getID() < s2.getID()) return -1;
                else if (s1.getID() > s2.getID()) return 1;
                return 0;
            }
        });
        this.set = new HashSet<>();
    }

    // Helper Functions

    // Read the courses.csv file and update the data structures with the provided data points.
    public static void buildCourses(){
        Path pathToFile = Paths.get("./csv/courses.csv");

        // Create an instance of BufferedReader
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
            String line = br.readLine();
            
            // Read the next line because the first contains titles of columns. We need values
            line = br.readLine();

            // Read each line and update the data structures with the new information.
            while (line != null){
                String[] data = line.split(",");
                Course course = createCourse(data);
                
                courses.put(course.getID(), course);

                line = br.readLine();
            }
        
            br.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    // Read the students.csv file and update the data structures with the provided data points.
    public static void buildStudents(){
        Path pathToFile = Paths.get("./csv/students.csv");
        // Create an instance of BufferedReader
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
            String line = br.readLine();
            
            // Read the next line because the first contains titles of columns. We need values
            line = br.readLine();

            // Read each line and update the data structures with the new information.
            while (line != null){
                String[] data = line.split(",");
                Student student = createStudent(data);
                
                students.put(student.getID(), student);

                line = br.readLine();
            }

            br.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    // Read the tests.csv file and update the data structures with the provided data points.
    public static void buildTests(){
        Path pathToFile = Paths.get("./csv/tests.csv");
        // Create an instance of BufferedReader
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
            String line = br.readLine();
            
            // Read the next line because the first contains titles of columns. We need values
            line = br.readLine();

            // Read each line and update the data structures with the new information.
            while (line != null){
                String[] data = line.split(",");
                Test test = createTest(data);
                
                tests.put(test.getID(), test);

                line = br.readLine();
            }

            br.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    // Read the marks.csv file and update the grades for each course respective to the student.
    public static void readMarks(){
        Path pathToFile = Paths.get("./csv/marks.csv");
        // Create an instance of BufferedReader
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
            String line = br.readLine();
            
            // Read the next line because the first contains titles of columns. We need values
            line = br.readLine();


            // Read each line and update the data structures with the new information.
            while (line != null){
                String[] data = line.split(",");
                int testID = Integer.parseInt(data[0]);
                int studentID = Integer.parseInt(data[1]);
                double grade = Double.parseDouble(data[2]);
                

                Test test = new Test(tests.get(testID));
                Student student = students.get(studentID);

                test.setGrade(grade);
                student.addTest(test);
                Course course = courses.get(test.getCourseID());

                double gradeToAdd = grade * (test.getWeight() / 100);

                student.addCourse(course, gradeToAdd);


                line = br.readLine();
            }


            br.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    // Sort courses based on course ID using a priority queue.
    public void sortCourses(){
        for (Student s : students.values()){
            for (int i : s.courseGrades.keySet()){
                if (!s.set.contains(i)){
                    s.courseList.add(courses.get(i));
                    s.set.add(i);
                }
            }
        }
    }

    // Create the course object based on the data from courses.csv
    private static Course createCourse(String[] data){
        int id = Integer.parseInt(data[0]);
        String name = data[1];
        String teacher = data[2];

        return new Course(id, name, teacher);
    }


    // Create the student object based on the data from students.csv
    private static Student createStudent(String[] data){
        int id = Integer.parseInt(data[0]);
        String name = data[1];

        return new Student(id, name);
    }

    // Create the test object based on the data from tests.csv
    private static Test createTest(String[] data){
        int testID = Integer.parseInt(data[0]);
        int studentID = Integer.parseInt(data[1]);
        double mark = Double.parseDouble(data[2]);

        return new Test(testID, studentID, mark);
    }

    // Sort students based on student ID using a priority queue.
    public static void buildQueueOfStudents(){
        for (Student s : students.values()){
            if (!set.contains(s.getID())){
                set.add(s.getID());
                queue.add(s);
            }
        }
    }
}