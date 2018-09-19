package i9SystemTray;  

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;


public class TrayIconDemo {
	
	public static TelaDeLogin tela;
	public static Configuracaoi9 config;
	
    public static void main(String[] args) {
    	
    	
        /* Use an appropriate Look and Feel */
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        //Schedule a job for the event-dispatching thread:
        //adding TrayIcon.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    private static void createAndShowGUI() {
        //Check the SystemTray support
    	
    	
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray não é suportável");
            return;
        }
        final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon =
                new TrayIcon(createImage("i916x16.gif", "tray icon"));
        final SystemTray tray = SystemTray.getSystemTray();
        trayIcon.setToolTip("System i9 RODANDO");
        
        // cria os menus pra serem adicionados aos popups
        MenuItem aboutItem = new MenuItem("Sobre o i9");
        MenuItem login = new MenuItem("Login");
        MenuItem exitItem = new MenuItem("Sair");
        
        //aqui adiciona os campos no menu do system tray
        popup.add(aboutItem);
        popup.addSeparator();
        popup.add(login);
        popup.addSeparator();
        popup.add(exitItem);
        
        trayIcon.setPopupMenu(popup);
            
        tela = new TelaDeLogin();
		tela.setVisible(false);
		tela.setExtendedState(TelaDeLogin.NORMAL);
		
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
            return;
        }
        
        //dois clicks no icon, gera esse action
        /*trayIcon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(){
            		config.setVisible(true);
            	}
            }
        });*/
        
        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Sobre a i9");
            }
        });
        
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
            		if(tela.INTERRUPTOR_LOGIN) {
            			tela.config.setVisible(true);
            		}else {
            			tela.setVisible(true);
            		}
            	}catch(Exception erro){
            		erro.printStackTrace();
            	}
            }
        });
 
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tray.remove(trayIcon);
                System.exit(0);
            }
        });
    }
    
    //Obtain the image URL
    protected static Image createImage(String path, String description) {
        URL imageURL = TrayIconDemo.class.getResource(path);
        
        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }
}