import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class GenderDao {

    public static Gender getById(int id) {

        Gender gender = new Gender();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mca_school", "root", "90896262");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from gender where id =" + id);

            rs.next();

            gender.setId(rs.getInt("id"));
            gender.setName(rs.getString("name"));

        } catch (Exception e) {

            System.out.println("can't connect as :" + e.getMessage());
        }

        return gender;
    }

}
