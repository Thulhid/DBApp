import java.util.List;

public class DBApp {

  public static void main(String[] args) {

    StudentDao stDao = new StudentDao();

    List<Student> students = stDao.getAll();

    for (Student student : students) {

      System.out.print(student.getId() + "\t\t");
      System.out.print(student.getName() + "\t\t");
      System.out.print(student.getNic() + "\t\t");
      System.out.println(student.getGender().getName() + "\t\t");
      System.out.println(" ");
    }

  }
}