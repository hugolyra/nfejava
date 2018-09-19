package i9SystemTray;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Conexao {

    private static final String USUARIO = "maicon";
    private static final String SENHA = "1q2w3e!Q@W#E";
    private static final String URL = "jdbc:mysql://safe.acenecontabilidade.com.br:3306/i9";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    // Conectar ao banco
    public static Connection abrir() throws Exception {
        // Registrar o driver
        Class.forName(DRIVER);
        // Capturar a conexão
        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
        // Retorna a conexao aberta
        return conn;

    } 
}
