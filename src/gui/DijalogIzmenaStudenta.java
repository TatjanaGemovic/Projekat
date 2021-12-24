package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import controller.PredmetKontroler;
import controller.StudentKontroler;
import model.Adresa;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;
import model.Predmet;
import model.Profesor;
import model.Semestar;
import model.Status_Studenta;
import model.Student;

public class DijalogIzmenaStudenta extends JDialog {

	public DijalogIzmenaStudenta(Frame parent, String title, boolean modal) {
			super(parent, "Izmena Studenta", modal);
			
			Dimension parentSize = parent.getSize();
			int diaWidth = parentSize.width;
			int diaHeight = parentSize.height;
			setSize(diaWidth*3/5, diaHeight*16/20);
			setLocationRelativeTo(parent);
			
			JTabbedPane tabbedPane = new JTabbedPane();
			
			JPanel infoPanel = new JPanel();
			JButton potvrda=new JButton("Potvrdi");
			GridBagConstraints gbcPotvrda = new GridBagConstraints();
			gbcPotvrda.fill = GridBagConstraints.HORIZONTAL;
			gbcPotvrda.gridx = 0;
			gbcPotvrda.gridy = 11;
			gbcPotvrda.insets = new Insets(30, 190, 0,0);
			
			JButton odustanak=new JButton("Odustani");
			GridBagConstraints gbcOdustanak = new GridBagConstraints();
			gbcOdustanak.fill = GridBagConstraints.HORIZONTAL;
			gbcOdustanak.gridx = 1;
			gbcOdustanak.gridy = 11;
			gbcOdustanak.insets = new Insets(30, 130, 0,0);
			
		    JPanel panelCenter = new JPanel();
		    panelCenter.setLayout(new GridBagLayout());
		    
		    panelCenter.add(potvrda, gbcPotvrda);
		    panelCenter.add(odustanak, gbcOdustanak);
		    
		    JLabel lblIme = new JLabel("Ime:");
		    JLabel lblPrezime = new JLabel("Prezime:");
		    JLabel lblDatumRodjenja = new JLabel("Datum rodjenja:");
		    JLabel lblAdresa = new JLabel("Adresa stanovanja:");
		    JLabel lblTelefon = new JLabel("Broj telefona:");
		    JLabel lblEmailAdresa = new JLabel("Email adresa:");
		    JLabel lblBrojIndeksa = new JLabel("Broj indeksa:");
		    JLabel lblGodinaUpisa = new JLabel("Godina upisa:");
		    JLabel lblTrenutnaGodinaStudija = new JLabel("Trenutna godina studija:");
		    JLabel lblNacinFinansiranja = new JLabel("Nacin finansiranja:");


		    final JTextField txtIme = new JTextField();
		    final JTextField txtPrezime = new JTextField();
		    final JTextField txtDatumRodjenja = new JTextField();
		    final JTextField txtAdresa = new JTextField();
		    final JTextField txtTelefon = new JTextField();
		    final JTextField txtEmailAdresa = new JTextField();
		    final JTextField txtBrojIndeksa = new JTextField();
		    final JTextField txtTrenutnaGodinaStudija = new JTextField();
		    final JTextField txtGodinaUpisa = new JTextField();
		    final JTextField txtNacinFinansiranja = new JTextField();
		    
		    GridBagConstraints gbcLblIme = new GridBagConstraints();
		    gbcLblIme.gridx = 0;
		    gbcLblIme.gridy = 0;
		    gbcLblIme.insets = new Insets(10, 30, 0,64);
		    panelCenter.add(lblIme, gbcLblIme);


		    GridBagConstraints gbcLblPrezime = new GridBagConstraints();
		    gbcLblPrezime.gridx = 0;
		    gbcLblPrezime.gridy = 1;
		    gbcLblPrezime.insets = new Insets(10, 30, 0,40);
		    panelCenter.add(lblPrezime, gbcLblPrezime);


		    GridBagConstraints gbcLbDatumRodjennja = new GridBagConstraints();
		    gbcLbDatumRodjennja.gridx = 0;
		    gbcLbDatumRodjennja.gridy = 2;
		    gbcLbDatumRodjennja.insets = new Insets(10, 40, 0,2);
		    panelCenter.add(lblDatumRodjenja, gbcLbDatumRodjennja);


		    GridBagConstraints gbcLbAdresa = new GridBagConstraints();
		    gbcLbAdresa.gridx = 0;
		    gbcLbAdresa.gridy = 3;
		    gbcLbAdresa.insets = new Insets(10, 56, 0,0);
		    panelCenter.add(lblAdresa, gbcLbAdresa);


		    GridBagConstraints gbcLbTelefon = new GridBagConstraints();
		    gbcLbTelefon.gridx = 0;
		    gbcLbTelefon.gridy = 4;
		    gbcLbTelefon.insets = new Insets(10, 40, 0,20);
		    panelCenter.add(lblTelefon, gbcLbTelefon);
		    
		    GridBagConstraints gbcLblEmailAdresa = new GridBagConstraints();
		    gbcLblEmailAdresa.gridx = 0;
		    gbcLblEmailAdresa.gridy = 6;
		    gbcLblEmailAdresa.insets = new Insets(10, 40, 0,20);
		    panelCenter.add(lblEmailAdresa, gbcLblEmailAdresa);

		    GridBagConstraints gbcLbBrojIndeksa = new GridBagConstraints();
		    gbcLbBrojIndeksa.gridx = 0;
		    gbcLbBrojIndeksa.gridy = 5;
		    gbcLbBrojIndeksa.insets = new Insets(10, 38, 0,20);
		    panelCenter.add(lblBrojIndeksa, gbcLbBrojIndeksa);
		    
		    GridBagConstraints gbcLblGodinaUpisa = new GridBagConstraints();
		    gbcLblGodinaUpisa.gridx = 0;
		    gbcLblGodinaUpisa.gridy = 7;
		    gbcLblGodinaUpisa.insets = new Insets(10, 40, 0,20);
		    panelCenter.add(lblGodinaUpisa, gbcLblGodinaUpisa);
		    
		    GridBagConstraints gbcLbTrenutnaGodinaStudija = new GridBagConstraints();
		    gbcLbTrenutnaGodinaStudija.gridx = 0;
		    gbcLbTrenutnaGodinaStudija.gridy = 9;
		    gbcLbTrenutnaGodinaStudija.insets = new Insets(10, 88, 0,0);
		    panelCenter.add(lblTrenutnaGodinaStudija, gbcLbTrenutnaGodinaStudija);
		    
		    GridBagConstraints gbcLbNacinFinansiranja = new GridBagConstraints();
		    gbcLbNacinFinansiranja.gridx = 0;
		    gbcLbNacinFinansiranja.gridy = 10;
		    gbcLbNacinFinansiranja.insets = new Insets(10, 53, 0,0);
		    panelCenter.add(lblNacinFinansiranja, gbcLbNacinFinansiranja);


		    GridBagConstraints gbcTxtIme = new GridBagConstraints();
		    gbcTxtIme .gridx = 1;
		    gbcTxtIme .gridy = 0;
		    gbcTxtIme .weightx = 100;
		    gbcTxtIme .fill = GridBagConstraints.HORIZONTAL;
		    gbcTxtIme .insets = new Insets(10, 120, 0, 70);
		    panelCenter.add(txtIme, gbcTxtIme );


		    GridBagConstraints gbcTxtPrezime = new GridBagConstraints();
		    gbcTxtPrezime .gridx = 1;
		    gbcTxtPrezime .gridy = 1;
		    gbcTxtPrezime .weightx = 100;
		    gbcTxtPrezime .fill = GridBagConstraints.HORIZONTAL;
		    gbcTxtPrezime .insets = new Insets(10, 120, 0, 70);
		    panelCenter.add(txtPrezime, gbcTxtPrezime );


		    GridBagConstraints gbcTxtDatum = new GridBagConstraints();
		    gbcTxtDatum .gridx = 1;
		    gbcTxtDatum .gridy = 2;
		    gbcTxtDatum .weightx = 100;
		    gbcTxtDatum.fill = GridBagConstraints.HORIZONTAL;
		    gbcTxtDatum.insets = new Insets(10, 120, 0, 70);
		    panelCenter.add(txtDatumRodjenja, gbcTxtDatum );
		    
		    GridBagConstraints gbcTxtAdresa = new GridBagConstraints();
		    gbcTxtAdresa .gridx = 1;
		    gbcTxtAdresa .gridy = 3;
		    gbcTxtAdresa .weightx = 100;
		    gbcTxtAdresa.fill = GridBagConstraints.HORIZONTAL;
		    gbcTxtAdresa.insets = new Insets(10, 120, 0, 70);
		    panelCenter.add(txtAdresa, gbcTxtAdresa );
		    
		    GridBagConstraints gbcTxtEmailAdresa = new GridBagConstraints();
		    gbcTxtEmailAdresa .gridx = 1;
		    gbcTxtEmailAdresa .gridy = 6;
		    gbcTxtEmailAdresa .weightx = 100;
		    gbcTxtEmailAdresa .fill = GridBagConstraints.HORIZONTAL;
		    gbcTxtEmailAdresa .insets = new Insets(10, 120, 0, 70);
		    panelCenter.add(txtEmailAdresa, gbcTxtEmailAdresa );
		    
		    GridBagConstraints gbcTxtTelefon = new GridBagConstraints();
		    gbcTxtTelefon .gridx = 1;
		    gbcTxtTelefon .gridy = 4;
		    gbcTxtTelefon .weightx = 100;
		    gbcTxtTelefon.fill = GridBagConstraints.HORIZONTAL;
		    gbcTxtTelefon.insets = new Insets(10, 120, 0, 70);
		    panelCenter.add(txtTelefon, gbcTxtTelefon );
		    
		    GridBagConstraints gbcTxtBrojIndeksa = new GridBagConstraints();
		    gbcTxtBrojIndeksa .gridx = 1;
		    gbcTxtBrojIndeksa .gridy = 5;
		    gbcTxtBrojIndeksa .weightx = 100;
		    gbcTxtBrojIndeksa.fill = GridBagConstraints.HORIZONTAL;
		    gbcTxtBrojIndeksa.insets = new Insets(10, 120, 0, 70);
		    panelCenter.add(txtBrojIndeksa, gbcTxtBrojIndeksa );
		    
		    GridBagConstraints gbcTxtGodinaUpisa = new GridBagConstraints();
		    gbcTxtGodinaUpisa .gridx = 1;
		    gbcTxtGodinaUpisa .gridy = 7;
		    gbcTxtGodinaUpisa .weightx = 100;
		    gbcTxtGodinaUpisa .fill = GridBagConstraints.HORIZONTAL;
		    gbcTxtGodinaUpisa .insets = new Insets(10, 120, 0, 70);
		    panelCenter.add(txtGodinaUpisa, gbcTxtGodinaUpisa );
		    
		    String godinaStudija[]= {"I (Prva)","II (Druga)","III (Treca)","IV (Cetvrta)"};
		    JComboBox<String> godStud=new JComboBox<>(godinaStudija);
		    
		    GridBagConstraints grd1 = new GridBagConstraints();
		    grd1.gridx = 1;
		    grd1.gridy = 9;
		    grd1.weightx = 100;
		    grd1.fill = GridBagConstraints.HORIZONTAL;
		    grd1.insets = new Insets(10, 120, 0, 70);
		    
		    panelCenter.add(godStud,grd1);
		    
		    String status[]= {"Budzet","Samofinansiranje"};
		    JComboBox<String> NacinFinansiranja=new JComboBox<>(status);
		    
		    GridBagConstraints grd2 = new GridBagConstraints();
		    grd2.gridx = 1;
		    grd2.gridy = 10;
		    grd2.weightx = 100;
		    grd2.fill = GridBagConstraints.HORIZONTAL;
		    grd2.insets = new Insets(10, 120, 0, 70);
		    
		    panelCenter.add(NacinFinansiranja, grd2);
		    
		    infoPanel.add(panelCenter, BorderLayout.CENTER);
		    
		  //ispis podataka za selektovani predmet
			List<Student> studenti = BazaStudenata.getInstance().getStudenti();
	    	Student student = BazaStudenata.getInstance().getRow(StudentiJTable.rowSelectedIndex);
	    	txtIme.setText(student.getIme());
		    txtPrezime.setText(student.getPrezime());
		    txtDatumRodjenja.setText(student.getDatum_rodjenja().toString());
		    String adresa_string = student.getAdresa().getUlica() + ", " + student.getAdresa().getBroj() + ", "  + student.getAdresa().getGrad() + ", " + student.getAdresa().getDrava(); 
		    txtAdresa.setText(adresa_string);;
		    txtTelefon.setText(student.getKontakt_tel());
		    txtEmailAdresa.setText(student.getEmail());;
		    txtBrojIndeksa.setText(student.getBroj_indeksa());;
		    txtGodinaUpisa.setText(Integer.toString(student.getGod_upisa()));
		    godStud.setSelectedIndex(student.getTrenutna_god()-1);
			int k=1;
			if(student.getStatus().equals(Status_Studenta.S)) {
				k=2;
			}
			NacinFinansiranja.setSelectedIndex(k-1);
	    	
			potvrda.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					int dialogButton = JOptionPane.YES_NO_OPTION;
				    int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da postavite nove parametre?", "Potvrda izmene", dialogButton);
				    
				    

				    if (dialogResult == JOptionPane.YES_OPTION) {
				    	
				    	if(txtIme.getText().isEmpty() || txtPrezime.getText().isEmpty() || txtDatumRodjenja.getText().isEmpty() || txtAdresa.getText().isEmpty() || txtTelefon.getText().isEmpty() || txtEmailAdresa.getText().isEmpty() || txtBrojIndeksa.getText().isEmpty() || txtGodinaUpisa.getText().isEmpty()) {
				    		
				    		JOptionPane.showMessageDialog(MainFrame.getInstance(), "Sva polja moraju biti popunjena", "Greska", JOptionPane.ERROR_MESSAGE);
				    		return;
				    	}
				    		
				    	String broj_index = txtBrojIndeksa.getText();
				    	for(Student s : BazaStudenata.getInstance().getStudenti()) {
				    		if(broj_index.equals(s.getBroj_indeksa()) && s!=student) {
				    			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Vec postoji student sa tim indeksom");
				    			return;
				    		}
				    	}
				    	String ime = txtIme.getText();
				    	String prezime = txtPrezime.getText();
				    	SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
				    	Date datumRodjenja = new Date();
				    	try {
							datumRodjenja =  formatter.parse(txtDatumRodjenja.getText());
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
				    	String adresaStr = txtAdresa.getText();
				    	String[] adresa_split = adresaStr.split(",");
				    	Adresa adresa = new Adresa(adresa_split[0], adresa_split[2], adresa_split[2], adresa_split[3]);
				    	String telefon = txtTelefon.getText();
				    	String mail = txtEmailAdresa.getText();
				    	String br_indexa = txtBrojIndeksa.getText();
				    	int god_upisa = Integer.parseInt(txtGodinaUpisa.getText());
				    	int tren_god = godStud.getSelectedIndex()+1;
				    	int status_pom = NacinFinansiranja.getSelectedIndex()+1;
				    	Status_Studenta status = null;
				    	if(status_pom == 2) {
				    		status = Status_Studenta.S;
				    	} else if (status_pom == 1){
				    		status = Status_Studenta.B;
				    	}
				    	StudentKontroler.getInstance().izmeniStudenta(StudentiJTable.rowSelectedIndex, student, ime, prezime, datumRodjenja, adresa, telefon, mail, br_indexa, god_upisa, tren_god, status);
				    	dispose();
				    	
				    }
					
				}
				
			});
		    
		    tabbedPane.add("Informacije", panelCenter);
		    tabbedPane.add("Polozeni", new JPanel());
		    tabbedPane.add("Nepolozeni", new JPanel());
		    this.add(tabbedPane);
		}
}
