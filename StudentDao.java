import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public List<Student> getAll() {

        List<Student> students = new ArrayList();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mca_school", "root", "90896262");
            Statement stm = con.createStatement();
            ResultSet resultSet = stm.executeQuery("select * from student");

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String nic = resultSet.getString("nic");

                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setNic(nic);

                students.add(student);

            }

        } catch (Exception e) {
            System.out.println("Data Base Error:" + e.getMessage());
        }

        return students;
    }
}
