package controlBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BdConection {

    private Connection conexao = null;
    private PreparedStatement newProject = null;
    

    public BdConection() throws Exception {
        if (conexao == null) {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String driverUrl = "jdbc:derby://localhost:1527/task";
            conexao = DriverManager.getConnection(driverUrl, "user", "pass");
            newProject = conexao.prepareStatement("INSERT INTO PROJETO(pronome,prodescricao,prodatainicio) VALUES(?,?,?)");
        }
    }
    
    public void newProject(String nomeProjeto, String descricao,Date data ) throws Exception {
       newProject.clearParameters();
        newProject.setString(1, nomeProjeto);
        newProject.setString(2, descricao);
        newProject.setDate(3, (java.sql.Date) data);
        newProject.executeUpdate();
    }

}
