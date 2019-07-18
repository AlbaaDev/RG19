package fr.rouen.views;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import fr.rouen.models.Entry;
import fr.rouen.models.Feed;
import fr.rouen.models.ResumeEntries;
import fr.rouen.models.ResumeEntry;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ListFeed extends JPanel {

    private JButton btnNewFeed;
    private JOptionPane jOption;
    private JTable table;
    private JScrollPane jScrollPane;
    private JLabel lblAffichageResume;
    private JTextField jTxtTitreArticle;
    private JButton lblValiderId;
    private JButton lblAffichageDetails;
    private JButton lblSupprimerArticle;
    private ButtonGroup btnRadioGroup;
    private RestTemplate restTemplate;
    private DynamicModelResume dynamicModelResume;
    private JLabel lblListDesResumes;
    private JButton btnFichierXml;
    private JLabel lblCrerUnNouveau;
    private JTextArea txtDialogMessage;
	private JScrollPane scrollPaneMessage;
	private JOptionPane jOptionMessageDialog;
	private JOptionPane jOptionErrorUrl;
	
    public ListFeed() {
        setLayout(null);
        setSize(780, 270);
        
        lblAffichageDetails = new JButton("Détail");
        lblSupprimerArticle = new JButton("Supprimer");
        btnNewFeed = new JButton("Formulaire");
        lblAffichageDetails.setBounds(80, 209, 100, 40);
        lblSupprimerArticle.setBounds(212, 209, 114, 40);

        btnNewFeed.setBounds(212, 48, 150, 25);
        
        add(btnNewFeed);
        add(lblAffichageDetails);
        add(lblSupprimerArticle);

        loadResume();
        btnNewFeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  NewFeed windowNewFeed = new NewFeed(dynamicModelResume);
                  windowNewFeed.setVisible(true);
            }
        });
        
        lblAffichageDetails.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RestTemplate restTemplate = new RestTemplate();
				String url = UrlData.getUrl();
				int row = table.getSelectedRow();
				if(row > -1) {
					ResumeEntry selectedEntry = dynamicModelResume.getEntryAtRow(table.convertRowIndexToModel(row));
					int idArticle = selectedEntry.getNum();
					try {
						ResponseEntity<Entry> response = 
								restTemplate.getForEntity(url + "/resume/xml/" + idArticle, Entry.class);
						EntryDetails windowEntryDetails = new EntryDetails(response.getBody());
						windowEntryDetails.setVisible(true);
					} catch (IllegalArgumentException err) {
						err.printStackTrace();
					}
				}
			}
		});
      //SUPPRESSION
        lblSupprimerArticle.addActionListener(new ActionListener() {
        	String url = UrlData.getUrl() + "/delete/";
			@Override
			public void actionPerformed(ActionEvent e) {
			    	    RestTemplate restTemplate = new RestTemplate();
						int row = table.getSelectedRow();
						if(row > -1) {
							try {
								ResumeEntry selectedEntry = dynamicModelResume.getEntryAtRow(table.convertRowIndexToModel(row));
						        dynamicModelResume.removeEntry(row);
						        restTemplate.delete(url + selectedEntry.getNum(), Entry.class);
							} catch (IllegalArgumentException err) {
									err.printStackTrace();
							}
						}
			}
		});

    
    
 //AJOUT DEPUIS FICHIER XML
    btnFichierXml = new JButton("Fichier XML");
    btnFichierXml.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		int retour;
        	JFileChooser jfileChooser = new JFileChooser();
        	retour = jfileChooser.showOpenDialog(btnFichierXml);
        	jfileChooser.setBounds(100, 100, 200, 299);
        	add(jfileChooser);
        	if(retour == JFileChooser.APPROVE_OPTION){
        		String fileName = jfileChooser.getSelectedFile().getName();
        		String path = jfileChooser.getSelectedFile().getAbsolutePath();
        		String format = fileName.substring(fileName.lastIndexOf("."), fileName.length());
        		if(format.equals(".xml")) {
        			String url = UrlData.getUrl() + "/insert";
    				RestTemplate restTemplate = new RestTemplate();
        			try {
        				MultiValueMap<String, String> header = new LinkedMultiValueMap<String, String>();
    			        Map map = new HashMap<String, String>();
    			        map.put("Content-Type", "application/xml");
    			        header.setAll(map);
    			        
    			        JAXBContext context = JAXBContext.newInstance(Feed.class);
                        Unmarshaller unmarshaller = context.createUnmarshaller();
                        Feed feed = (Feed) unmarshaller.unmarshal(new File(path));
    			        HttpEntity<Feed> request = new HttpEntity<Feed>(feed, header);
    				    ResponseEntity<XMLResponseDTO> response = restTemplate.postForEntity(url , request, XMLResponseDTO.class);
//    				    if(feed.getEntries() != null) {
//	    				    for (Entry entry : feed.getEntries()) {
//	    				    	dynamicModelResume.addEntry(new ResumeEntry(entry));
//							}
//    				    }
    				    refresh(dynamicModelResume);
    				    jOptionMessageDialog = new JOptionPane();
    				    txtDialogMessage = new JTextArea(response.getBody().getMessage());
    				    txtDialogMessage.setEditable(false);
    				    scrollPaneMessage = new JScrollPane(txtDialogMessage);
    				    scrollPaneMessage.setPreferredSize(new Dimension(scrollPaneMessage.getPreferredSize().width,
    				    		scrollPaneMessage.getPreferredSize().height));
    				    
    				   if (response.getBody().getCode() == 200)
    				    	jOptionMessageDialog.showMessageDialog(null, scrollPaneMessage, 
    					    		"Code : " + Integer.toString(response.getBody().getCode()), 
    					    		JOptionPane.INFORMATION_MESSAGE);
    				   else if(response.getBody().getCode() == 500)
    					    jOptionMessageDialog.showMessageDialog(null, scrollPaneMessage, 
    					    		"Code : " + Integer.toString(response.getBody().getCode()), 
    					    		JOptionPane.WARNING_MESSAGE);
                    
                    } catch (JAXBException jxbException){
                    	jxbException.printStackTrace();
                    } catch (IllegalArgumentException err) {
                    	err.printStackTrace();
                    } catch (NullPointerException errNlp) {
                    	errNlp.printStackTrace();
				
                    }
        		} else {
        			JOptionPane.showMessageDialog(null, "Format fichier invalide, XML Uniquement.");
        		}
        	} 
        	remove(jfileChooser);
    	}

		
    });
    btnFichierXml.setBounds(80, 46, 114, 25);
    add(btnFichierXml);
    
    lblCrerUnNouveau = new JLabel("Créer un nouveau flux :");
    lblCrerUnNouveau.setBounds(80, 21, 177, 15);
    add(lblCrerUnNouveau);
    
    lblListDesResumes = new JLabel("List des resumées :");
    lblListDesResumes.setBounds(525, 51, 150, 15);
    add(lblListDesResumes);
 }
    
    //Chargement du tableau 
    private void loadResume() {
    	String url = UrlData.getUrl() + "/resume/xml";
    	try {
    	    RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<ResumeEntries> response = 
					restTemplate.getForEntity(url , ResumeEntries.class);
			List<ResumeEntry> listResumeEntries = response.getBody().getResumes();
			dynamicModelResume = new DynamicModelResume(listResumeEntries);
	    	table = new JTable(dynamicModelResume);
	        jScrollPane = new JScrollPane(table);
	        jScrollPane.setBounds(80, 85, 650, 112);
	        this.add(jScrollPane);
	    	
		} catch (IllegalArgumentException err) {
			jOptionErrorUrl = new JOptionPane();
			jOptionErrorUrl.showMessageDialog(null, "L'url fourni n'est pas valide.", 
					"Erreur: url", JOptionPane.WARNING_MESSAGE);
		} catch (NullPointerException errNlp) {
			errNlp.printStackTrace();
		}
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
