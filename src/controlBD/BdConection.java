package controlBD;



import java.sql.Connection;
import java.sql.DriverManager;



public class BdConection {


    private Connection conexao = null;
   
    public BdConection() throws Exception {
        if (conexao == null) {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String driverUrl = "jdbc:derby://localhost:1527/task";
            conexao = DriverManager.getConnection(driverUrl, "user", "pass");
        }
        
        
   }

}
