# GenerateReportCards
Given four .csv files: Students, Courses, Tests, and Marks, generate a personalized report card given all of the data points provided.

Requirements:
-Java 8
    -Java must be added to the System's environmental path/settings. 
-Terminal or Windows Shell


How to run the application:
After downloading the zip file and extracting it, open a terminal. Navigate to the folder where the program was installed. Open the folder to access the ".java" files within the terminal. Now type the following without the quotes: "javac *.java". This will compile all of the java code together. Now type "java Main" without the quotes to run the file. The program will now run and produce the "output.txt" file within the folder.

Users can add custom .csv files for Courses, Marks, Students and Tests, or update the currently provided .csv files for specific cases. These can be found in the "csv" folder provided.

If there are errors, your computer may not have Java 8 installed. If the computer does have Java 8 installed, then please add Java to the system's environmental path. More about this can be learned in the following link:
https://www.mkyong.com/java/how-to-set-java_home-on-windows-10/



Brief Description:
This program takes in four ".csv" files: courses, students, tests, and marks. Using these spreadsheets, the program will parse through all of the data, build unique profiles for each student based on the courses the student is currently taking and calculate the grade for each student's respective courses as well as the grade point average. All of this information is then neatly printed onto the "output.txt" file after running the program.
