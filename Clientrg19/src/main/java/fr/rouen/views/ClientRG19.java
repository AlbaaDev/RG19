package fr.rouen.views;

import java.awt.Color; 
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import fr.rouen.models.ResumeEntries;

public class ClientRG19  {
	
	private JFrame frame;
	private JButton btnGestionArticle;
	private JOptionPane jOptionErrorUrl;

	/** 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientRG19 window = new ClientRG19();
					window.frame.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClientRG19() {
		initialize();
	
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Rg19");
		frame.setBounds(100, 100, 801, 236);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
		
        JLabel lblServerLink = new JLabel("Veuillez entrer l'adresse du serveur : ");
        lblServerLink.setBounds(39, 63, 300, 30);
        frame.getContentPane().add(lblServerLink);
//        panel.add(lblServerLink);
        
        JTextField txtServerLink = new JTextField();
        txtServerLink.setBounds(309, 63, 300, 30);
        frame.getContentPane().add(txtServerLink);
//        panel.add(txtServerLink);
        
        JButton btnSendLink = new JButton("Valider");
        btnSendLink.setBounds(614, 63, 100, 30);
        frame.getContentPane().add(btnSendLink);
        
        JTextPane textPane = new JTextPane();
        textPane.setContentType("text/html"); 
        textPane.setText("<html>Exemple : https://rg19-gil.herokuapp.com/</html>");
        textPane.setEditable(false); 
        textPane.setBackground(null);
        textPane.setBorder(null);
        textPane.setBounds(311, 117, 300, 15);
        frame.getContentPane().add(textPane);

        
        JLabel lblExemple = new JLabel("Exemple : https://rg19-gil.herokuapp.com/");
        lblExemple.setBounds(311, 117, 300, 15);
        frame.getContentPane().add(lblExemple);
//        panel.add(btnSendLink);
		
		btnSendLink.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		    	try {
		    		String url = txtServerLink.getText();
		    	    RestTemplate restTemplate = new RestTemplate();
					ResponseEntity<String> response = 
							restTemplate.getForEntity(url , String.class);
					if(response.getStatusCodeValue() == 200) {
						UrlData.setUrl(txtServerLink.getText());	
						ListFeed listFeed = new ListFeed();
						frame.setSize(780, 344);
						frame.getContentPane().removeAll();
						frame.getContentPane().add(listFeed);
					}
				} catch (IllegalArgumentException errURL) {
					jOptionErrorUrl = new JOptionPane();
					jOptionErrorUrl.showMessageDialog(null, "L'url fourni n'est pas valide.", 
							"Erreur: url", JOptionPane.WARNING_MESSAGE);
				} catch (HttpClientErrorException errClient) {
					jOptionErrorUrl = new JOptionPane();
					jOptionErrorUrl.showMessageDialog(null, "L'url fourni n'est pas valide.", 
							"Erreur: url", JOptionPane.WARNING_MESSAGE);
				} catch (ResourceAccessException r) {
					jOptionErrorUrl = new JOptionPane();
					jOptionErrorUrl.showMessageDialog(null, "L'url fourni n'est pas valide.", 
							"Erreur: url", JOptionPane.WARNING_MESSAGE);
				} catch (HttpServerErrorException s) {
					jOptionErrorUrl = new JOptionPane();
					jOptionErrorUrl.showMessageDialog(null, "L'url fourni n'est pas valide.", 
							"Erreur: url", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
}
