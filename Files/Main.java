import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

// Main function to run the program.
public class Main{
    public static void main(String[] args) {
        try{
            // Create a FileWriter/PrintWriter object to stream the output to output.txt
            FileWriter fw = new FileWriter("output.txt");
            PrintWriter pw = new PrintWriter(fw);
    
            // Decimal formatter for pretty looking decimals.
            DecimalFormat df2 = new DecimalFormat("#.##");

            // Initialize the builder and read all of the .csv files to update the data structures.
            Builder builder = new Builder();
            builder.buildCourses();
            builder.buildStudents();
            builder.buildTests();
            builder.readMarks();
    
            // Sort students by student ID
            builder.buildQueueOfStudents();

            // Iterate through each student and stream the information to output.txt
            while (builder.queue.size() != 0){
                
                // Get current student
                Student s = builder.queue.poll();
    
                // Print student information
                pw.print(s.toString() + "\n");
                
                // Sort courses by course ID to prepare for output.
                builder.sortCourses();

                // Calculate current grade point average over all courses and print.
                s.calculateGrade();
                pw.print("Total Average:      " + df2.format(s.getGrade()) + "%" + "\n");

                // Iterate through each course and stream the information to output.txt
                for (Course c : s.courseList){
                    pw.print("\n");
                    pw.print("        " + c.toString() + "\n");
                    pw.print("        Final Grade:      " + df2.format(s.courseGrades.get(c.getID())) + "%\n");
    
                }
                pw.print("\n\n\n");

            }

            // Close the printer.
            pw.close();
        } catch(IOException e){
            e.printStackTrace();

        }
    }
}