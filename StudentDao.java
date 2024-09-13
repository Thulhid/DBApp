import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
    
    public String[][] getAll(){

        String studentArray[][] = null;

    try {
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mca_school", "root", "90896262");
    Statement stm = con.createStatement(1004,1007);
    ResultSet resultSet = stm.executeQuery("select * from student");

        resultSet.last();

        int totalRows = resultSet.getRow();

        studentArray = new String[totalRows][3];

        resultSet.first();

        do{
            int currentIdenx = resultSet.getRow() -1;
            studentArray [currentIdenx][0] = resultSet.getString("id");
            studentArray [currentIdenx][1] = resultSet.getString("name");
            studentArray [currentIdenx][2] = resultSet.getString("nic");


        } while(resultSet.next());


        } catch (Exception e) {

            System.out.println("Data Base Error:" + e.getMessage());
        }
        return studentArray;

    }
}
