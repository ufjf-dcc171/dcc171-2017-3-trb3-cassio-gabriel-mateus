package controlBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BdConnection {

    public static Connection instancia = null;

    public static Connection getConnection () throws Exception
    {
        if (instancia == null)
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String driverUrl = "jdbc:derby://localhost:1527/trabalho-lab3";
            instancia = DriverManager.getConnection(driverUrl, "USUARIO", "SENHA");
            return instancia;
        }
        else
        {
            return instancia;
        }
    }
}
