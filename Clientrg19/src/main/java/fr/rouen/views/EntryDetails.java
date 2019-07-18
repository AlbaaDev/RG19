package fr.rouen.views;

import java.awt.EventQueue;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import fr.rouen.models.Category;
import fr.rouen.models.Entry;
import fr.rouen.models.Person;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class EntryDetails extends JFrame {
	
	private JLabel lblImage;
	public EntryDetails(Entry entry) {
		setBounds(100, 100, 544, 609);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setTitle("Détails Article");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id :");
		lblNewLabel.setBounds(12, 33, 36, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Title  :");
		lblNewLabel_1.setBounds(12, 60, 66, 15);
		getContentPane().add(lblNewLabel_1);
		
		if(entry.getPublished() == null) {
			JLabel lblNewLabel_3 = new JLabel("Updated");
			lblNewLabel_3.setBounds(12, 215, 155, 15);
			getContentPane().add(lblNewLabel_3);
		} else if (entry.getUpdated() == null) {
			JLabel lblNewLabel_3 = new JLabel("Published");
			lblNewLabel_3.setBounds(12, 215, 155, 15);
			getContentPane().add(lblNewLabel_3);
		}
		
		JLabel lblContent = new JLabel("Content :");
		lblContent.setBounds(12, 378, 66, 15);
		getContentPane().add(lblContent);
		
		JLabel lblNewLabel_5 = new JLabel(entry.getId());
		lblNewLabel_5.setBounds(72, 33, lblNewLabel_5.getPreferredSize().width, 15);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(entry.getTitle());
		lblNewLabel_6.setBounds(72, 60, lblNewLabel_6.getPreferredSize().width, 15);
		getContentPane().add(lblNewLabel_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(114, 87, 187, 116);
		getContentPane().add(scrollPane);
		
//		
//		CATEGORIES
//
		
		DefaultListModel modelCategories;
		JLabel lblNewLabel_2 = new JLabel("Categorie(s) :");
		lblNewLabel_2.setBounds(12, 87, 108, 15);
		getContentPane().add(lblNewLabel_2);

		JList listCategories = new JList();
		scrollPane.setViewportView(listCategories);
		
		if(entry.getCategories() != null) {
			modelCategories = new DefaultListModel();
			for (String category : entry.getCategories()) {
				modelCategories.addElement(category);
				listCategories.setModel(modelCategories);
			}
		} else {
			modelCategories = new DefaultListModel();
			modelCategories.addElement("No Categories");
			listCategories.setModel(modelCategories);

		}
		
//		
//						AUTHORS
//		
		JLabel Authors = new JLabel("Authors :");
		Authors.setBounds(12, 493, 78, 15);
		getContentPane().add(Authors);
		
		JScrollPane scrollPaneAuthorsList = new JScrollPane();
		scrollPaneAuthorsList.setBounds(94, 489, 143, 83);
		getContentPane().add(scrollPaneAuthorsList);
		
		JList list_authors = new JList();
		scrollPaneAuthorsList.setViewportView(list_authors);
		
		DefaultListModel modelAutors;
		if(entry.getAuthors() != null) {
			modelAutors = new DefaultListModel();
			for (Person person : entry.getAuthors()) {
				modelAutors.addElement(person.getName());
				list_authors.setModel(modelAutors);
			}
		} else {
			modelAutors = new DefaultListModel();
			modelAutors.addElement("No Authors");
			list_authors.setModel(modelAutors);
		}
		
//		
//		CONTRIBUTORS
//
		
		JLabel lblContributors = new JLabel("Contributors :");
		lblContributors.setBounds(254, 493, 108, 15);
		getContentPane().add(lblContributors);
		
		JScrollPane scrollPaneContribList = new JScrollPane();
		scrollPaneContribList.setBounds(368, 493, 143, 79);
		getContentPane().add(scrollPaneContribList);
		
		JList list_contributors = new JList();
		scrollPaneContribList.setViewportView(list_contributors);
		scrollPaneContribList.setViewportView(list_contributors); 
		
		DefaultListModel modelContributors;
		if(entry.getContributors() != null) {
			modelContributors = new DefaultListModel();
			for (Person person : entry.getContributors()) {
				modelContributors.addElement(person.getName());
				list_contributors.setModel(modelContributors);
			}
		} else {
			modelContributors = new DefaultListModel();
			modelContributors.addElement("No Contributors");
			list_contributors.setModel(modelContributors);
		}
		
//		
//		IMAGE
//
//		JLabel lblImage = new JLabel("New label");
//		getContentPane().add(lblImage);
		
		lblImage = new JLabel();
		lblImage.setBounds(202, 205, 328, 180);
		getContentPane().add(lblImage);
		if(entry.getImage() != null) {
			Image image = null;
			try {
                String path = entry.getImage().getHref();
                URL url = new URL(path);
                image = ImageIO.read(url);
                ImageIcon imgIcone = new ImageIcon(image);
                lblImage.setIcon(imgIcone);
        	
                
            } catch (Exception exp) {
                exp.printStackTrace();
            }
		} else {
			lblImage.setText("No image");
			
		}
		
//		
//		CONTENT
//
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(114, 389, 284, 89);
		getContentPane().add(scrollPane_3);
		
		JTextArea textArea = new JTextArea();
		scrollPane_3.setViewportView(textArea);
		if(entry.getContent() != null) {
			if(entry.getContent().getType().equals("text")) {
				textArea.setText(entry.getContent().getText());
			} else {
				textArea.setText(entry.getContent().getHref());
			}
			textArea.setEditable(false);
		}
	}
}
