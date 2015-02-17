package ba.bitcamp.view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ba.bitcamp.controller.ApplicationController;
import ba.bitcamp.model.Contact;

public class ApplicationView extends Main {
	
	/**
	 * Shows the apps start / home page.
	 */
	public static void home() {
		JPanel content = new JPanel();
		
		JLabel greeting = new JLabel("Welcome to BitBook");
		Font greetingFont = new Font("SansSerif", Font.BOLD, 30);
		greeting.setFont(greetingFont);
		content.add(greeting);
		
		JButton showContacts = new JButton("Show Contacts");
		showContacts.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ContactController.list();
			}

		});

		JButton addContact = new JButton("Add Contact");
		addContact.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 ApplicationController.addContact();
			}
		});
		
		content.add(addContact);
		content.add(showContacts);
		replaceContent(content);
	}
	
	/**
	 * Shows the form for adding a new contact
	 */
	public static void addContact() {

		JPanel content = new JPanel();
		content.setLayout(new FlowLayout());
		JLabel nameL = new JLabel("Name: ");
		JTextField nameF = new JTextField(25);
		content.add(nameL);
		content.add(nameF);

		JLabel surnameL = new JLabel("Surname: ");
		JTextField surnameF = new JTextField(25);
		content.add(surnameL);
		content.add(surnameF);

		JLabel numberL = new JLabel("Number: ");
		JTextField numberF = new JTextField(25);
		content.add(numberL);
		content.add(numberF);

		JButton submit = new JButton("Add");
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/* get the data from the input
				 * and send it to the create method
				 */
				String cName = nameF.getText();
				String cSurname = surnameF.getText();
				String cNumber = numberF.getText();
				ApplicationController.create(cName, cSurname, cNumber);
			}

		});

		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ApplicationController.home();
			}

		});

		JPanel buttons = new JPanel();
		buttons.add(submit);
		buttons.add(back);
		content.add(buttons);
		replaceContent(content);
	}


}
