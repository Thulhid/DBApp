
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBApp{

    public static void main(String[] args) {

        try {
            

            String qry = "SELECT * FROM student";

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mca_school","root" ,"90896262");

            Statement stm = conn.createStatement();

            ResultSet rslt = stm.executeQuery(qry);

           
          while (rslt.next()) {

            int id = rslt.getInt("id");
            String name = rslt.getString("name");
            String nic = rslt.getString("nic");

            System.out.println(id + "\t" + name + "\t" + nic);
            
          }
          conn.close();


        } catch (SQLException e) {
            System.out.println("Can't Connect as " + e.getMessage());
        }
        
       


    }
}