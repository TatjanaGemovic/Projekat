package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class DijalogIzmenaTabbedPane extends JTabbedPane{
	
	public DijalogIzmenaTabbedPane() {
		JPanel panelWithForm = new JPanel();
		panelWithForm.setLayout(new GridLayout(0,2));
		
		JLabel imeLabel = new JLabel();  
        imeLabel.setText("Ime*: ");
        JTextField textFieldIme = new JTextField(15);    
        panelWithForm.add(imeLabel);
        panelWithForm.add(textFieldIme); 
        
        
        JLabel prezimeLabel = new JLabel();  
        prezimeLabel.setText("Prezime*: ");     
        JTextField textFieldPrezime = new JTextField(15);   
        panelWithForm.add(prezimeLabel);
        panelWithForm.add(textFieldPrezime);    
        
        JLabel datumLabel = new JLabel();  
        datumLabel.setText("Datum rodjenja*: ");     
        JTextField textFieldDatum = new JTextField(15);   
        panelWithForm.add(datumLabel);
        panelWithForm.add(textFieldDatum);    
        
        JLabel adresaLabel = new JLabel();  
        prezimeLabel.setText("Adresa stanovanja*: ");     
        JTextField textFieldAdresa = new JTextField(15);   
        panelWithForm.add(adresaLabel);
        panelWithForm.add(textFieldAdresa);    
        
        JLabel brojLabel = new JLabel();  
        brojLabel.setText("Broj telefona*: ");     
        JTextField textFieldBroj = new JTextField(15);   
        panelWithForm.add(brojLabel);
        panelWithForm.add(textFieldBroj);    
        
        JLabel mailLabel = new JLabel();  
        mailLabel.setText("E-mail adresa*: ");     
        JTextField textFieldMail = new JTextField(15);   
        panelWithForm.add(mailLabel);
        panelWithForm.add(textFieldMail);    
        
        JLabel indexLabel = new JLabel();  
        prezimeLabel.setText("Broj indeksa*: ");     
        JTextField textFieldIndex = new JTextField(15);   
        panelWithForm.add(indexLabel);
        panelWithForm.add(textFieldIndex);
        
        JLabel godinaLabel = new JLabel();  
        prezimeLabel.setText("Godina upisa*: ");     
        JTextField textFieldGodina = new JTextField(15);   
        panelWithForm.add(godinaLabel);
        panelWithForm.add(textFieldGodina);    
        
        JLabel trenutnaLabel = new JLabel();  
        prezimeLabel.setText("Trenutna godina studiranja*: ");     
        JTextField textFieldTrenutna = new JTextField(15);   
        panelWithForm.add(trenutnaLabel);
        panelWithForm.add(textFieldTrenutna);    
        
        JLabel finansLabel = new JLabel();  
        prezimeLabel.setText("Nacin finansiranja*: ");     
        JTextField textFieldFinans = new JTextField(15);   
        panelWithForm.add(finansLabel);
        panelWithForm.add(textFieldFinans);    
        
        
		this.addTab("Informacije", panelWithForm);
		
		this.addTab("Polozeni", new JLabel(""));
		this.addTab("Nepolozeni", new JLabel(""));
		
		
		
		/*JScrollPane infoPane = new JScrollPane();
		
		JTextField field_ime = new JTextField();
		field_ime.setBounds(128, 28, 86, 20);
        infoPane.add(field_ime);
        field_ime.setColumns(10);
         
        JLabel label_ime = new JLabel("Ime*: ");
        label_ime.setBounds(65, 31, 46, 14);
        infoPane.add(label_ime);
        
        JTextField field_prezime = new JTextField();
		field_prezime.setBounds(128, 28, 86, 20);
        infoPane.add(field_prezime);
        field_prezime.setColumns(10);
         
        JLabel label_prezime = new JLabel("Prezime*: ");
        label_prezime.setBounds(65, 31, 46, 14);
        infoPane.add(label_prezime);

		JScrollPane polozeniPane = new JScrollPane();
		JScrollPane nepolozeniPane = new JScrollPane();
		this.add("Informacije", infoPane);
		this.add("Polozeni", polozeniPane);
		this.add("Nepolozeni", nepolozeniPane);*/
	}

}
