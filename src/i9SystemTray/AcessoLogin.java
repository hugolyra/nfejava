package i9SystemTray;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class AcessoLogin {
	
	public boolean acesso;
	
	public ArrayList Acesso(String email, String senha) throws NoSuchAlgorithmException {
		Connection conn = null;
		Statement consulta = null;
		ResultSet tabela = null;
		String result = "";
		ArrayList arrayUsuario = new ArrayList();
		senha = 
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(StandardCharsets.UTF_8.encode(senha));
		senha =  String.format("%032x", new BigInteger(1, md5.digest()));

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("");
			consulta = (Statement) conn.createStatement();
			tabela = consulta.executeQuery("SELECT id, usuarioCriptografado "
					+ "						FROM 02_usuarios "
					+ "						WHERE email='"+email+"' "
							+ "				AND senha='"+senha+"'");

			if(tabela.next()){
				JOptionPane.showMessageDialog(null, "Usuário e senha corretos!"/*+tabela.getString("id")*/);
				 arrayUsuario.add(tabela.getString("id"));
				 arrayUsuario.add(tabela.getString("usuarioCriptografado"));
				 
				 return arrayUsuario;
			}else { 
				JOptionPane.showMessageDialog(null, "Usuário e/ou senha incorretos!");
				return arrayUsuario;
			}
			
		}catch(ClassNotFoundException |SQLException e) {
			System.out.println(e);
		}
		return arrayUsuario;
		
		
	}
}
