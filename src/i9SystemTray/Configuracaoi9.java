package i9SystemTray;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import java.util.Timer;

public class Configuracaoi9 extends JFrame {
	
	private JPanel contentPane;
	public JComboBox comboBox;
	public JCheckBox chckbxNfce;
	public JCheckBox chckbxNfe;
	public File diretorio;
	public File arquivo;
	public String diretorioArquivo;
	public JTextField textField;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArrayList resultado = null;
					Configuracaoi9 frame = new Configuracaoi9(resultado);
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Configuracaoi9(ArrayList resultado) throws Exception {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Configuracaoi9.class.getResource("/i9SystemTray/i916x16.gif")));
		setTitle("i9 Corp - LIFE CONSULTORIA E TECNOLOGIA 81 2125-0315");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 508, 304);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelecioneOGrupo = new JLabel("Selecione o grupo, do i9 CORP, ao qual as importa\u00E7\u00F5es ser\u00E3o realizadas:");
		lblSelecioneOGrupo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSelecioneOGrupo.setBounds(40, 61, 402, 27);
		contentPane.add(lblSelecioneOGrupo);
		
		JLabel lblRobDoI = new JLabel("Rob\u00F4 do i9 CORP - Importador/Interpretador autom\u00E1tico de XML");
		lblRobDoI.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRobDoI.setBounds(40, 23, 438, 27);
		contentPane.add(lblRobDoI);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox.setBounds(40, 89, 186, 23);
		contentPane.add(comboBox);
		
		chckbxNfe = new JCheckBox("NFE");
		chckbxNfe.setBackground(Color.WHITE);
		chckbxNfe.setBounds(40, 173, 97, 23);
		contentPane.add(chckbxNfe);
		
		chckbxNfce = new JCheckBox("NFCE");
		chckbxNfce.setBackground(Color.WHITE);
		chckbxNfce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxNfe.setSelected(true);	
			}
		});
		chckbxNfce.setBounds(139, 173, 97, 23);
		contentPane.add(chckbxNfce);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object item = comboBox.getSelectedItem();
				String value = ((ComboItem)item).getValue();
				
				//pegar status do Checkbox NFe e NFCe
					boolean nfe = false;
					boolean nfce = false;
				
					nfe = chckbxNfe.isSelected();
					nfce = chckbxNfce.isSelected();
					
				//cria o diretório
			        try {
			            File diretorio = new File("C:\\i9");
			            diretorio.mkdir(); //cria a pasta no diretório pedido
			        } catch (Exception ex) {
			            JOptionPane.showMessageDialog(null, "Erro ao criar o diretorio");
			            System.out.println(ex);
			        }
		        
			        /*if(diretorio == null) {
			        	JOptionPane.showMessageDialog(null, "Selecione uma pasta");
			        }else {
			        	System.out.println("Não é pra fazer nada, nothing");
			        }*/
			        
			        //cria o txt, dentro da pasta criada
	
			        File arquivo = new File("C:\\i9\\CONFIGURACAO_i9.txt");
					try {
						if(!arquivo.exists()) { //se o arquivo não existir, ele cria
							arquivo.createNewFile();
						}
							FileWriter fw = new FileWriter(arquivo);
							BufferedWriter bw = new BufferedWriter(fw);
							bw.write(value);
							bw.newLine();
							bw.write(nfe + "");
							bw.newLine();
							bw.write(nfce + "");
							bw.newLine();
							bw.write(""+resultado.get(1));
							bw.newLine();
							bw.write(diretorioArquivo);
							bw.newLine();
							bw.close();
							fw.close();
							
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
		});
		btnSalvar.setBounds(40, 222, 97, 25);
		contentPane.add(btnSalvar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog(null,"Deseja sair")==JOptionPane.YES_NO_OPTION){
					setVisible(false);	
				}
			}
		});
		btnSair.setBounds(192, 223, 97, 23);
		contentPane.add(btnSair);
			
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				if (JOptionPane.showConfirmDialog(null,"Deseja sair")==JOptionPane.YES_NO_OPTION){
					setVisible(false);	
				}
			}
		});
		
		JLabel imgLife = new JLabel("");
		imgLife.setBounds(353, 194, 125, 70);
		
		ImageIcon imagem = new ImageIcon(Configuracaoi9.class.getResource("LIFECTI.png"));
		Image img = imagem.getImage().getScaledInstance(imgLife.getWidth(), imgLife.getHeight(), Image.SCALE_SMOOTH);
		
		imgLife.setIcon(new ImageIcon(img));
		
		contentPane.add(imgLife);

		//verifica se arquivo c:/i9/CONFIGURACAO_i9.txt existe
		
		File arquivo = new File("C:\\i9\\CONFIGURACAO_i9.txt");
			if(arquivo.exists()) {
				System.out.println("Existe arquivo");
			}else {
				System.out.println("Não existe arquivo");
			}
		
		//verifica se o diretório c:/i9/ existe
		
		File diretorio = new File("C:\\i9\\");
			if(diretorio.exists()) {
				System.out.println("Existe diretório");
			}else {
				System.out.println("Não existe diretório");
			}
		
		//ler do arquivo.
		//resgatar primeira linha grupocript 
		// segunda linha nfe se estiver TRUE, você vai usar CAMPOCHECKCOBX.setSelected(true)
		//terceira vai ser nfce 
		
		String GRUPO_CRIPT_ARQUIVO = null;
		String USUARIO_CRIPT_ARQUIVO = null;
		boolean NFE_ARQUIVO = false;
		boolean NFCE_ARQUIVO = false;
		String diretorioArquivo_ARQUIVO = "";
		
		FileReader ler = new FileReader("C:\\i9\\CONFIGURACAO_i9.txt");
        BufferedReader reader = new BufferedReader(ler);  
        String linha;
        int contador = 1;
        while((linha = reader.readLine()) != null){
            System.out.println(linha);
            if(contador == 1) {
            	GRUPO_CRIPT_ARQUIVO = linha;
            }else if(contador == 2){
            	NFE_ARQUIVO = Boolean.parseBoolean(linha);
            }else if(contador == 3) {
            	NFCE_ARQUIVO = Boolean.parseBoolean(linha);
            }else if(contador == 4) {
            	USUARIO_CRIPT_ARQUIVO = linha;
            }else if(contador == 5) {
            	diretorioArquivo_ARQUIVO = linha;
            }
            contador++;
        }

		//colocar os dados lidos em variáveis por exemplo GRUPO_CRIPT_ARQUIVO, NFE_ARQUIVO
		
		Conexao conn = new Conexao();
		
		Connection con = conn.abrir();
    	Statement stmt = con.createStatement();
    	 
    	// * Entras de dados no campo codigo do formulário.

    	ResultSet RS = null;   	 
   
    	RS = stmt.executeQuery("SELECT gp.nome, gp.grupocript " + 
    						   "FROM `03_grupousuario` gpu, 01_grupos gp, 09_permissoesmodulos pm " + 
    						   "WHERE gpu.idUsuario="+resultado.get(0)+" " + 
    						   "AND gpu.status='A' " + 
    						   "AND gp.id=gpu.idgrupo " + 
    						   "AND pm.idGrupo=gpu.idgrupo "
    						   + "AND pm.idUsuario="+resultado.get(0)+" "
    						   + "AND pm.idModulo=12 "
    						   + "AND pm.tipoAcesso=3 "
    						   + "AND pm.ativo='S' ");
    	 
    	String[] groupsStrings = {};
    	
    	while (RS.next()) {
    	// * Exibe os valore retornados na consulta.	
	    	String NOME_GRUPO_i9 = RS.getString("nome");
	    	String GRUPO_CRIPT_i9 = RS.getString("grupocript"); 
	    	ComboItem itemSelecionado = new ComboItem(NOME_GRUPO_i9,GRUPO_CRIPT_i9);
	    	comboBox.addItem(itemSelecionado);
				if (GRUPO_CRIPT_i9.equals(GRUPO_CRIPT_ARQUIVO) && USUARIO_CRIPT_ARQUIVO.equals(resultado.get(1))) {
					comboBox.setSelectedItem(itemSelecionado);
				}
    	}
    	
    	chckbxNfce.setSelected(NFCE_ARQUIVO);
    	chckbxNfe.setSelected(NFE_ARQUIVO);
    	
    	
    	JLabel lblNewLabel = new JLabel("Adicionar diret\u00F3rio:");
    	lblNewLabel.setBounds(40, 123, 121, 14);
    	contentPane.add(lblNewLabel);
    	
    	textField = new JTextField();
    	textField.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    		}
    	});
    	textField.setEnabled(false);
    	
    	textField.setBounds(40, 146, 266, 20);
    	contentPane.add(textField);
    	textField.setColumns(10);
    	
    	textField.setText(diretorioArquivo_ARQUIVO);
    	
    	JButton btnAdicionarDiretorio = new JButton("Adicionar");
		btnAdicionarDiretorio.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	//adicionar as funções necessárias para o funcionamento correto
	            JFileChooser fc = new JFileChooser();        
	            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	            int res = fc.showOpenDialog(null);
	            if(res == JFileChooser.APPROVE_OPTION){
	                File diretorio = fc.getSelectedFile();
	                JOptionPane.showMessageDialog(null, "Você escolheu o diretório: " + diretorio.getName());
	                diretorioArquivo = diretorio.getPath();
	                textField.setText(diretorioArquivo);
	            }else {
	            	JOptionPane.showMessageDialog(null, "Você não selecionou nenhum diretório.");
	        	}
	          }	        
			});
		
    	btnAdicionarDiretorio.setBounds(316, 145, 89, 23);
    	contentPane.add(btnAdicionarDiretorio);
    	
    	JComboBox horario = new JComboBox();
    		horario.addItem("5 minutos");
    		horario.addItem("15 minutos");
    		horario.addItem("30 minutos");
    		horario.addItem("45 minutos");
    		horario.addItem("60 minutos");
    	
    	horario.setBounds(261, 90, 97, 20);
    	contentPane.add(horario);
		}
		//5,15,30,45,60
	}
