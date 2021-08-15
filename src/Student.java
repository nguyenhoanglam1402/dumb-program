public class Student {
  private int id;
  private String name;
  private String className;
  private float grade;
  private boolean sex;

  public Student(int id, String name, String className, float grade, boolean sex) {
    this.id = id;
    this.name = name;
    this.className = className;
    this.grade = grade;
    this.sex = sex;
  }

  public int getID() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public float getGrade() {
    return this.grade;
  }

  public String getSex() {
    return (this.sex) ? "Male" : "Female";
  }

  public String getClassName() {
    return this.className;
  }
}
