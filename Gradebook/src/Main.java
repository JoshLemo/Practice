/*********************************************************
 *                                                       *
 * Josh Lemonakis COP 2006 Spring 2018 Main.java    *
 *                                                       *
 *                                                       *
 *********************************************************/
// GradeBookTest creates GradeBook object using a two-dimensional array
// of grades, then invokes method processGrades to analyze them.
public class Main {
  // main method execution
  public static void main(String[] args) {
    // two-dimensional array of random student grades that I populated manually
    int[][] gradesArray = {{87, 96, 70}, {68, 87, 61}, {94, 100, 90}, {100, 81, 82}, {37, 65, 85},
        {78, 87, 55}, {85, 75, 63}, {48, 94, 100}, {76, 72, 84}, {87, 93, 73}, {58, 93, 73}};

    // create GradeBook object
    GradeBook myGradeBook = new GradeBook("COP 2006 Introduction to Java Programming", gradesArray);
    // print welcome message for the class
    System.out.printf("Welcome to the grade book for%n%s%n%n", myGradeBook.getCourseName());
    // process grades in Gradebook.java
    myGradeBook.processGrades();
  }
} // end class GradeBookTest
