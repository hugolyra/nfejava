package i9SystemTray;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaDeLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textLogin;
	private JPasswordField textSenha;
	public static boolean INTERRUPTOR_LOGIN;
	public Configuracaoi9 config;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeLogin frame = new TelaDeLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaDeLogin() {
		INTERRUPTOR_LOGIN = false;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(163, 109, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(163, 134, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textLogin = new JTextField();
		textLogin.setBounds(200, 106, 95, 20);
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		
		textSenha = new JPasswordField();
		textSenha.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_ENTER ) {
					AcessoLogin cl = new AcessoLogin();
					ArrayList resultado = null;
					try {
						resultado = cl.Acesso(textLogin.getText(), textSenha.getText());
					} catch (NoSuchAlgorithmException e) {
						e.printStackTrace();
					}
					try {
						resultado.get(0);
						config = null;
						INTERRUPTOR_LOGIN = true;
						try {
							config = new Configuracaoi9(resultado);
							config.show();
							config.setExtendedState(new Configuracaoi9(resultado).NORMAL);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
							config.setVisible(false);
						}
					}catch(Exception e)
					
					{
						textLogin.setText("");
						textSenha.setText("");
						textLogin.requestFocus();
						e.printStackTrace();
					}
					
					cl.acesso = false;
				}
			}
		});
		textSenha.setBounds(200, 134, 95, 20);
		contentPane.add(textSenha);
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AcessoLogin cl = new AcessoLogin();
				ArrayList resultado = null;
				try {
					resultado = cl.Acesso(textLogin.getText(), textSenha.getText());
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
				try {
					resultado.get(0);
					Configuracaoi9 config = null;
					try {
						config = new Configuracaoi9(resultado);
						config.show();
						config.setExtendedState(new Configuracaoi9(resultado).NORMAL);
						dispose();
					} catch (Exception e) {
						e.printStackTrace();
						config.setVisible(false);
					}
				}catch(Exception e)
				
				{
					textLogin.setText("");
					textSenha.setText("");
					textLogin.requestFocus();
					e.printStackTrace();
				}
				
				cl.acesso = false;
			}
		});
		btnAcessar.setBounds(102, 176, 89, 23);
		contentPane.add(btnAcessar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnSair.setBounds(257, 176, 89, 23);
		contentPane.add(btnSair);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(153, 11, 127, 87);
		
		ImageIcon imagem = new ImageIcon(TelaDeLogin.class.getResource("LIFECTI.png"));
		Image img = imagem.getImage().getScaledInstance(lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight(), Image.SCALE_SMOOTH);
		
		lblNewLabel_2.setIcon(new ImageIcon(img));
		
		contentPane.add(lblNewLabel_2);
		
	}
}
