package fr.rouen.views;

import java.awt.EventQueue; 

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fr.rouen.models.Category;
import fr.rouen.models.Content;
import fr.rouen.models.Entry;
import fr.rouen.models.Feed;
import fr.rouen.models.Image;
import fr.rouen.models.Person;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.Component;
import javax.swing.Box;

public class NewEntry extends JFrame{

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private Entry entry;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private Feed feed;
	
	public NewEntry(Feed feed) {
		this.feed = feed;
		entry = new Entry();
		setTitle("New Entry");
		setBounds(100, 100, 540, 618);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("id :");
		lblNewLabel.setBounds(22, 41, 66, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Title :");
		lblNewLabel_1.setBounds(22, 12, 66, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Published  :");
		lblNewLabel_3.setBounds(22, 68, 97, 15);
		getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(177, 39, 124, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(177, 12, 124, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblContent = new JLabel("Content :");
		lblContent.setBounds(22, 385, 66, 15);
		getContentPane().add(lblContent);
		
		textField_2 = new JTextField();
		textField_2.setBounds(177, 66, 124, 19);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		
		btnValider.setBounds(412, 559, 114, 25);
		getContentPane().add(btnValider);
		
		textField_3 = new JTextField();
		textField_3.setBounds(47, 147, 124, 19);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblTerm = new JLabel("term ");
		lblTerm.setBounds(79, 122, 66, 15);
		getContentPane().add(lblTerm);
		
		JLabel lblNewLabel_5 = new JLabel("type ");
		lblNewLabel_5.setBounds(79, 189, 66, 15);
		getContentPane().add(lblNewLabel_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"gif", "jpeg", "png"}));
		comboBox.setBounds(47, 216, 81, 24);
		getContentPane().add(comboBox);
		
		JLabel lblHref = new JLabel("href ");
		lblHref.setBounds(195, 189, 66, 15);
		getContentPane().add(lblHref);
		
		textField_4 = new JTextField();
		textField_4.setBounds(152, 219, 124, 19);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblAlt = new JLabel("alt");
		lblAlt.setBounds(320, 189, 66, 15);
		getContentPane().add(lblAlt);
		
		textField_5 = new JTextField();
		textField_5.setBounds(302, 219, 124, 19);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblLength = new JLabel("length ");
		lblLength.setBounds(460, 189, 66, 15);
		getContentPane().add(lblLength);
		
		textField_6 = new JTextField();
		textField_6.setBounds(453, 219, 73, 19);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Name\n");
		lblNewLabel_6.setBounds(47, 327, 66, 15);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Email\n");
		lblNewLabel_7.setBounds(195, 327, 66, 15);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Uri\n");
		lblNewLabel_8.setBounds(359, 327, 66, 15);
		getContentPane().add(lblNewLabel_8);
		
		textField_7 = new JTextField();
		textField_7.setBounds(47, 354, 124, 19);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(195, 354, 124, 19);
		getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(362, 354, 124, 19);
		getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		JCheckBox chckbxCategories = new JCheckBox("Categories :");
		chckbxCategories.setBounds(11, 91, 126, 23);
		getContentPane().add(chckbxCategories);
		
		JCheckBox chckbxImage = new JCheckBox("Image :");
		chckbxImage.setBounds(11, 169, 81, 23);
		getContentPane().add(chckbxImage);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItem("Author");
		comboBox_1.addItem("Contributor");
//		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"None", "Author", "Contributor"}));
		comboBox_1.setBounds(94, 279, 131, 25);
		getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(106, 475, -73, -17);
		getContentPane().add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(42, 442, 107, 25);
//		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"src", "txt"}));
		comboBox_3.addItem("src");
		comboBox_3.addItem("text");
		getContentPane().add(comboBox_3);
		textField_10 = new JTextField();
		textField_10.setBounds(177, 445, 124, 19);
		textField_10.setColumns(10);
		getContentPane().add(textField_10);
		comboBox_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboBox_3.getSelectedIndex() == 0) {
					textField_10.setEditable(true);
				} else {
					textField_10.setEditable(false);
				}
			}
		});
		
		JLabel lblType = new JLabel("type");
		lblType.setBounds(42, 412, 66, 15);
		getContentPane().add(lblType);
		
		JLabel lblNewLabel_2 = new JLabel("href");
		lblNewLabel_2.setBounds(183, 412, 66, 15);
		getContentPane().add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 502, 325, 79);
		getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblContent_1 = new JLabel("content ");
		lblContent_1.setBounds(47, 475, 66, 15);
		getContentPane().add(lblContent_1);
		
		JCheckBox checkbxAuthorsContrib = new JCheckBox("Author or Contributor :");
		checkbxAuthorsContrib.setBounds(11, 248, 203, 23);
		getContentPane().add(checkbxAuthorsContrib);
		
		JLabel lblType_1 = new JLabel("Type");
		lblType_1.setBounds(47, 279, 66, 15);
		getContentPane().add(lblType_1);
		
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxCategories.isSelected()) {
					List<Category> categories = new ArrayList<Category>();
					Category category = new Category();
					category.setTerm(textField_3.getText());
					entry.setCategories(categories);
				} 
				if(checkbxAuthorsContrib.isSelected()) {
					if(comboBox_1.getSelectedIndex() == 0) {
						List<Person> persons = new ArrayList<Person>();
						Person author = new Person(textField_7.getText(), textField_8.getText(), textField_9.getText());
						persons.add(author);
						entry.setAuthors(persons);
					} else if (comboBox_1.getSelectedIndex() == 1) {
						List<Person> persons = new ArrayList<Person>();
						Person contributor = new Person(textField_7.getText(), textField_8.getText(), textField_9.getText());
						persons.add(contributor);
						entry.addContributor(contributor);
					} 
				}
				if (chckbxImage.isSelected()) {
					Image image;
					if(!textField_6.getText().isEmpty()) {
						image = new Image(comboBox.getSelectedItem().toString(), 
											textField_4.getText(), 
											textField_5.getText(), 
											Integer.parseInt(textField_6.getText()));
					} else {
						image = new Image();
						image.setType(comboBox.getSelectedItem().toString());
						image.setHref(textField_4.getText());
						image.setAlt(textField_5.getText());
					}
					entry.setImage(image);
				}
				Content content = new Content(comboBox_3.getSelectedItem().toString());
				if(! textField_10.getText().isEmpty()) {
					content.setHref(textField_10.getText());
				}
				if(! textArea.getText().isEmpty()) {
					content.setText(textArea.getText());
				}
				entry.setContent(content);
				entry.setId(textField.getText());
				entry.setTitle(textField_1.getText());
				entry.setPublished(textField_2.getText());
				feed.addEntry(entry);
				JOptionPane jOptPaneMessage = new JOptionPane();
				jOptPaneMessage.showMessageDialog(null, "Article ajouté au feed : " + feed.getTitle() + ". Cliquez sur Valider dans l'interface New feed pour envoyer.", "Message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
}
