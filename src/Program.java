import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

  // Declaring the Input and Output Stream here
  PrintStream out = System.out;
  Scanner scanner = new Scanner(System.in);

  // Declaring an array list to store list of students
  ArrayList<Student> students = new ArrayList<Student>();

  public void Run() {
    int choice = 0;
    do {
      choice = menu();
      switch (choice) {
        case 1:
          setList();
          break;
        case 2:
          showList(students.size(), students);
          break;
        case 3:
          out.println("Enter id of student: ");
          int id = scanner.nextInt();
          Student student = findStudent(id);
          if (student != null) {
            out.printf("\n\n|%10s|%25s|%15s|%10s|%10s|\n", "ID", "NAME", "CLASS", "GRADE", "GENDER");
            getStudent(student);
          }
          break;
        case 4:
          out.println("Enter the grade you want to ");
          float grade = scanner.nextFloat();
          ArrayList<Student> result = filterStudents(grade);
          showList(result.size(), result);
          break;
        case 5:
          out.println("Enter the ID student: ");
          int idStudent = scanner.nextInt();
          students.remove(idStudent);
          break;
        case 6:
          out.println("[System Notice]: Shutdown");
          break;
      }
    } while (choice >= -1 && choice < 6);
  }

  private int menu() {
    out.println();
    out.println("| Which feature you want to choose ? |");
    out.println("[1]. Add student(s) into system");
    out.println("[2]. Show all of students");
    out.println("[3]. Search student");
    out.println("[4]. Filter list following grade");
    out.println("[5]. Remove student");
    out.println("[6]. Close");
    out.println("__________[Enter your choice]________");
    int choice = scanner.nextInt();
    return choice;
  }

  private void setList() {
    int nextPoint = students.size();
    out.println("Please enter number of student: ");
    int amount = scanner.nextInt();
    for (int index = nextPoint; index < nextPoint + amount; index++) {
      Student student = setStudent(index);
      students.add(student);
    }
  }

  private Student setStudent(int index) {
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

  private void showList(int amount, ArrayList<Student> students) {
    out.printf("\n\n|%10s|%25s|%15s|%10s|%10s|\n", "ID", "NAME", "CLASS", "GRADE", "GENDER");
    if (amount != 0) {
      for (int index = 0; index < amount; index++) {
        getStudent(students.get(index));
      }
    } else {
      out.println("There is no result !");
    }
  }

  private void getStudent(Student student) {
    int id = student.getID();
    String name = student.getName();
    String className = student.getClassName();
    float grade = student.getGrade();
    String sex = student.getSex();
    out.printf("|%-10d|%-25s|%-15s|%-10.1f|%-10s|\n", id, name, className, grade, sex);
  }

  private ArrayList<Student> filterStudents(float grade) {
    ArrayList<Student> filtered = new ArrayList<>();
    for (Student student : students) {
      if (student.getGrade() >= grade) {
        filtered.add(student);
      }
    }
    return filtered;
  }

  private Student findStudent(int id) {
    for (Student student : students) {
      if (student.getID() == id) {
        return student;
      }
    }
    return null;
  }

}
