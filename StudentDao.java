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
            ResultSet rs = stm.executeQuery("select * from student");

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String nic = rs.getString("nic");
                Gender gender = GenderDao.getById(rs.getInt("gender_id"));

                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setNic(nic);
                student.setGender(gender);

                students.add(student);

            }

        } catch (Exception e) {
            System.out.println("Data Base Error:" + e.getMessage());
        }

        return students;
    }
}
