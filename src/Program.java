import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

  // Declaring the Input and Output Stream here
  PrintStream out = System.out;
  Scanner scanner = new Scanner(System.in);

  // Declaring an array list to store list of students
  ArrayList<Student> students = new ArrayList<Student>();

  public Program() {
    // Constructor
  }

  public void Run() {
    int choice = 0;
    do {
      choice = Menu();
      switch (choice) {
        case 1:
          SetList();
          break;
        case 2:
          ShowList(students.size(), students);
          break;
        case 3:
          break;
        case 4:
          break;
        case 5:
          out.println("[System Notice]: Shutdown");
          break;
      }
    } while (choice >= -1 && choice < 5);
  }

  private int Menu() {
    out.print("\033[H\033[2J");
    out.flush();
    out.println("| Which feature you want to choose ? |");
    out.println("[1]. Add student(s) into system");
    out.println("[2]. Show all of students");
    out.println("[3]. Search student");
    out.println("[4]. Sort by grade");
    out.println("[5]. Close");
    int choice = scanner.nextInt();
    return choice;
  }

  private void SetList() {
    int nextPoint = students.size();
    out.println("Please enter number of student: ");
    int amount = scanner.nextInt();
    for (int index = nextPoint; index < nextPoint + amount; index++) {
      Student student = SetStudent(index);
      students.add(student);
    }
  }

  private Student SetStudent(int index) {
    String name = "";
    String className = "";
    float grade = 0;
    boolean sex = false;
    scanner.nextLine();
    out.printf("Enter the name of student [%d]:", index);
    name = scanner.nextLine();
    out.printf("Enter the class of student [%d]:", index);
    className = scanner.nextLine();
    out.printf("Enter the grade of student [%d]:", index);
    grade = scanner.nextFloat();
    out.printf("Enter the gender of student [%d] (female [0] - male [1]):", index);
    int gender = scanner.nextInt();
    sex = gender == 1 ? true : false;
    Student student = new Student(index, name, className, grade, sex);
    return student;
  }

  private void ShowList(int amount, ArrayList<Student> students) {
    out.printf("\n\n|%10s|%25s|%15s|%10s|%10s|\n", "ID", "NAME", "CLASS", "GRADE", "GENDER");
    for (int index = 0; index < amount; index++) {
      GetStudent(students.get(index));
    }
  }

  private void GetStudent(Student student) {
    int id = student.getID();
    String name = student.getName();
    String className = student.getClassName();
    float grade = student.getGrade();
    String sex = student.getSex();
    out.printf("|%-10d|%-25s|%-15s|%-10.1f|%-10s|\n", id, name, className, grade, sex);
  }

}
