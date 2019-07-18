package fr.rouen.views;

import java.awt.EventQueue;
import java.awt.ItemSelectable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import fr.rouen.models.Entry;
import fr.rouen.models.Feed;
import fr.rouen.models.Link;
import fr.rouen.models.ResumeEntries;
import fr.rouen.models.ResumeEntry;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

public class NewFeed extends JFrame{
	private Feed feed;
	private int state;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JOptionPane jOptionMessageDialog;
	private JTextField textField_5;
	private JTextArea txtDialogMessage;
	private JScrollPane scrollPaneMessage;
	private JOptionPane jOptionErrorUrl;
    private DynamicModelResume dynamicModelResume;
	
	public NewFeed(DynamicModelResume dynamicModelResume) {
		setTitle("New Feed");
		this.feed = new Feed();
		this.setBounds(100, 100, 461, 319);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblTitre = new JLabel("Titre :");
		lblTitre.setBounds(23, 14, 66, 15);
		this.getContentPane().add(lblTitre);
		
		textField = new JTextField();
		textField.setBounds(233, 12, 134, 19);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDateDePublication = new JLabel("Date de publication :");
		lblDateDePublication.setBounds(23, 41, 169, 19);
		this.getContentPane().add(lblDateDePublication);
		
		textField_1 = new JTextField();
		textField_1.setBounds(233, 43, 134, 19);
		this.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblId = new JLabel("id :");
		lblId.setBounds(23, 72, 66, 15);
		this.getContentPane().add(lblId);
		
		textField_2 = new JTextField();
		textField_2.setBounds(233, 74, 134, 19);
		this.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Entry  :");
		lblNewLabel.setBounds(23, 255, 76, 20);
		this.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feed.setTitle(textField.getText());
				NewEntry entryNewEntryWindow = new NewEntry(feed);
				entryNewEntryWindow.setVisible(true);
			}
		});
		btnNewButton.setBounds(81, 253, 52, 25);
		this.getContentPane().add(btnNewButton);
		
		JButton btnValider = new JButton("Valider");
		
		btnValider.setBounds(304, 247, 134, 36);
		getContentPane().add(btnValider);
		
		JLabel lblRel = new JLabel("Rel :");
		lblRel.setBounds(60, 170, 66, 15);
		getContentPane().add(lblRel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"self", "alternate"}));
		comboBox.setBounds(23, 197, 88, 24);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("type :");
		lblNewLabel_1.setBounds(164, 170, 66, 15);
		getContentPane().add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(164, 200, 95, 19);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblHref = new JLabel("href :");
		lblHref.setBounds(328, 170, 66, 15);
		getContentPane().add(lblHref);
		
		textField_4 = new JTextField();
		textField_4.setBounds(297, 200, 141, 19);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JCheckBox chckbxLink = new JCheckBox("Link");
		chckbxLink.setBounds(22, 141, 126, 23);
		getContentPane().add(chckbxLink);
		
		JLabel lblLangue = new JLabel("Langue :");
		lblLangue.setBounds(23, 99, 66, 15);
		getContentPane().add(lblLangue);
		
		textField_5 = new JTextField();
		textField_5.setBounds(233, 97, 134, 19);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);

		
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feed.setPubDate(textField_1.getText());
				feed.setId(textField_2.getText());
				feed.setLang(textField_5.getText());
				if(chckbxLink.isSelected()) {
					Link link = new Link(comboBox.getSelectedItem().toString(), 
					textField_3.getText(), textField_4.getText());
					feed.addLink(link);
				}
				String url = UrlData.getUrl() + "/insert";
				RestTemplate restTemplate = new RestTemplate();
				try {
					MultiValueMap<String, String> header = new LinkedMultiValueMap<String, String>();
			        Map map = new HashMap<String, String>();
			        map.put("Content-Type", "application/xml");
			        header.setAll(map);
				    HttpEntity<Feed> request = new HttpEntity<Feed>(feed, header);
				    ResponseEntity<XMLResponseDTO> response = restTemplate.postForEntity(url , request, XMLResponseDTO.class);
				    refresh(dynamicModelResume);
				    jOptionMessageDialog = new JOptionPane();
				    txtDialogMessage = new JTextArea(response.getBody().getMessage());
				    scrollPaneMessage = new JScrollPane(txtDialogMessage);
				    scrollPaneMessage.setPreferredSize(new Dimension(800,  scrollPaneMessage.getPreferredSize().height));
				    
				   if (response.getBody().getCode() == 200)
				    	jOptionMessageDialog.showMessageDialog(null, scrollPaneMessage, 
					    		"Code : " + Integer.toString(response.getBody().getCode()), 
					    		JOptionPane.INFORMATION_MESSAGE);
				   else if(response.getBody().getCode() == 500)
					    jOptionMessageDialog.showMessageDialog(null, scrollPaneMessage, 
					    		"Code : " + Integer.toString(response.getBody().getCode()), 
					    		JOptionPane.WARNING_MESSAGE);
				} catch (IllegalArgumentException err) {
					err.printStackTrace();
				} catch (NullPointerException errNlp) {
					errNlp.printStackTrace();
				}
			}
		});
	}
	  private void refresh(DynamicModelResume dynamicModelResume) {
	    	String url = UrlData.getUrl() + "/resume/xml";
	    	try {
	    		dynamicModelResume.clearModel();
	    	    RestTemplate restTemplate = new RestTemplate();
				ResponseEntity<ResumeEntries> response = restTemplate.getForEntity(url , ResumeEntries.class);
				List<ResumeEntry> listResumeEntries = response.getBody().getResumes();
				for (ResumeEntry resumeEntry : listResumeEntries) {
					dynamicModelResume.addEntry(resumeEntry);
				}
			} catch (IllegalArgumentException err) {
				jOptionErrorUrl = new JOptionPane();
				jOptionErrorUrl.showMessageDialog(null, "L'url fourni n'est pas valide.", 
						"Erreur: url", JOptionPane.WARNING_MESSAGE);
			} catch (NullPointerException errNlp) {
				errNlp.printStackTrace();
			}
		}
}
