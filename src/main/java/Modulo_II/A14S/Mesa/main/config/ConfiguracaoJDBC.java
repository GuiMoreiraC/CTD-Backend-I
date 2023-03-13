package Modulo_II.A14S.Mesa.main.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConfiguracaoJDBC {
    private  String jdbcDriver;
    private  String dbURL;
    private  String nomeUsuario;
    private  String senha;

    public ConfiguracaoJDBC() {
        this.jdbcDriver = "org.h2.Driver";
        this.dbURL = "jdbc:h2:~/medicamentos2;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'src/main/java/Modulo_II/A14S/Mesa/query/create_A14S.sql'";
        this.nomeUsuario = "sa";
        this.senha = "";
    }

    public Connection conectarComCancoDeDados() {

        Connection connection = null;

        try{
            connection = DriverManager.getConnection(dbURL,nomeUsuario, senha);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

}
