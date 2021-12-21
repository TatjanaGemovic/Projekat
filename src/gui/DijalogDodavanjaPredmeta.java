package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.PredmetKontroler;
import model.BazaProfesora;
import model.Profesor;
import model.Semestar;

public class DijalogDodavanjaPredmeta extends JDialog{

	public DijalogDodavanjaPredmeta(Frame parent, String title, boolean modal) {
		super(parent, "Dodavanje Predmeta", modal);
		
		Dimension parentSize = parent.getSize();
		int diaWidth = parentSize.width;
		int diaHeight = parentSize.height;
		setSize(diaWidth*3/5, diaHeight*15/20);
		setLocationRelativeTo(parent);
		
		JPanel panelBottom = new JPanel();
		JButton potvrda=new JButton("Potvrdi");
		JButton odustanak=new JButton("Odustani");
		odustanak.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

					int dialogButton = JOptionPane.YES_NO_OPTION;
				    int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Potvrda odustanka", dialogButton);
	
				    if (dialogResult == JOptionPane.YES_OPTION) {
				    	dispose();
				    }
			             
				}
			});
		
		panelBottom.add(potvrda);
	    panelBottom.add(odustanak);
	    
	    this.add(panelBottom, BorderLayout.SOUTH);
		
	    JPanel panelCenter = new JPanel();
	    panelCenter.setLayout(new GridBagLayout());
	    this.add(panelCenter, BorderLayout.CENTER);
	    
	    
	    JLabel lblSifra = new JLabel("Sifra predmeta:");
		JLabel lblNaziv = new JLabel("Naziv predmeta:");
		JLabel lblBrojESPB = new JLabel("Broj ESPB bodova:");
		JLabel lblGodina = new JLabel("Godina na kojoj se izvodi:");
		JLabel lblSemestar = new JLabel("Semestar:");
		JLabel lblProfesor = new JLabel("Profesor (ime i prezime):");
		 
		 
		final JTextField txtSifra = new JTextField();
		final JTextField txtNaziv = new JTextField();
		final JTextField txtBrojESPB = new JTextField();
		final JTextField txtProfesor = new JTextField();
		
		GridBagConstraints gbcLSifra = new GridBagConstraints();
		gbcLSifra.gridx = 0;
		gbcLSifra.gridy = 0;
		gbcLSifra.insets = new Insets(20, 40, 0,0);
		panelCenter.add(lblSifra, gbcLSifra);
		 
		GridBagConstraints gbcLNaziv = new GridBagConstraints();
		gbcLNaziv.gridx = 0;
		gbcLNaziv.gridy = 1;
		gbcLNaziv.insets = new Insets(20, 40, 0,0);
		panelCenter.add(lblNaziv, gbcLNaziv);
		
		GridBagConstraints gbcLBrojESPB = new GridBagConstraints();
		gbcLBrojESPB.gridx = 0;
		gbcLBrojESPB.gridy = 2;
		gbcLBrojESPB.insets = new Insets(20, 40, 0,0);
		panelCenter.add(lblBrojESPB, gbcLBrojESPB);
		
		GridBagConstraints gbcLGodina = new GridBagConstraints();
		gbcLGodina.gridx = 0;
		gbcLGodina.gridy = 3;
		gbcLGodina.insets = new Insets(20, 40, 0,0);
		panelCenter.add(lblGodina, gbcLGodina);
		
		GridBagConstraints gbcLSemestar = new GridBagConstraints();
		gbcLSemestar.gridx = 0;
		gbcLSemestar.gridy = 4;
		gbcLSemestar.insets = new Insets(20, 40, 0,0);
		panelCenter.add(lblSemestar, gbcLSemestar);
		
		GridBagConstraints gbcLProfesor = new GridBagConstraints();
		gbcLProfesor.gridx = 0;
		gbcLProfesor.gridy = 5;
		gbcLProfesor.insets = new Insets(20, 40, 0,0);
		panelCenter.add(lblProfesor, gbcLProfesor);
			
		GridBagConstraints gbcTxtSifra = new GridBagConstraints();
		gbcTxtSifra .gridx = 1;
		gbcTxtSifra .gridy = 0;
		gbcTxtSifra .weightx = 100;
		gbcTxtSifra .fill = GridBagConstraints.HORIZONTAL;
		gbcTxtSifra .insets = new Insets(20,120, 0, 70);
		panelCenter.add(txtSifra, gbcTxtSifra );
		
		GridBagConstraints gbcTxtNaziv = new GridBagConstraints();
		gbcTxtNaziv .gridx = 1;
		gbcTxtNaziv.gridy = 1;
		gbcTxtNaziv .weightx = 100;
		gbcTxtNaziv.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtNaziv .insets = new Insets(20, 120, 0, 70);
		panelCenter.add(txtNaziv, gbcTxtNaziv );
		
		GridBagConstraints gbcTxtBrojESPB = new GridBagConstraints();
		gbcTxtBrojESPB .gridx = 1;
		gbcTxtBrojESPB.gridy = 2;
		gbcTxtBrojESPB .weightx = 100;
		gbcTxtBrojESPB.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtBrojESPB .insets = new Insets(20, 120, 0, 70);
		panelCenter.add(txtBrojESPB, gbcTxtBrojESPB );
		
		
		String godinaStudija[]= {"I (Prva)","II (Druga)","III (Treca)","IV (Cetvrta)"};
		JComboBox<String> godStud=new JComboBox<>(godinaStudija);
		   
		GridBagConstraints grdGodina = new GridBagConstraints();
		grdGodina.gridx = 1;
		grdGodina.gridy = 3;
		grdGodina.weightx = 100;
		grdGodina.fill = GridBagConstraints.HORIZONTAL;
		grdGodina.insets = new Insets(20, 120, 0, 70);
		panelCenter.add(godStud,grdGodina);
		
			
		
		String semestar[]= {"I (Prvi)","II (Drugi)","III (Treci)","IV (Cetvrti)","V (Peti)","VI (Sesti)","VII (Sedmi)","VIII (Osmi)"};
		JComboBox<String> semestarStud=new JComboBox<>(semestar);
		   
		GridBagConstraints grdSemestar= new GridBagConstraints();
		grdSemestar.gridx = 1;
		grdSemestar.gridy = 4;
	    grdSemestar.weightx = 100;
		grdSemestar.fill = GridBagConstraints.HORIZONTAL;
		grdSemestar.insets = new Insets(20, 120, 0, 70);
		panelCenter.add(semestarStud,grdSemestar);
		
		
		GridBagConstraints gbcTxtProfesor = new GridBagConstraints();
		gbcTxtProfesor .gridx = 1;
		gbcTxtProfesor.gridy = 5;
		gbcTxtProfesor .weightx = 100;
		gbcTxtProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtProfesor .insets = new Insets(20, 120, 0, 70);
		panelCenter.add(txtProfesor, gbcTxtProfesor );
		
		potvrda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
			    int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Potvrda odustanka", dialogButton);

			    if (dialogResult == JOptionPane.YES_OPTION) {
			    	
			    	if(txtSifra.getText().isEmpty() || txtNaziv.getText().isEmpty() || txtBrojESPB.getText().isEmpty() || txtProfesor.getText().isEmpty()) {
			    		
			    		JOptionPane.showMessageDialog(MainFrame.getInstance(), "Sva polja moraju biti popunjena", "Greska", JOptionPane.ERROR_MESSAGE);
			    	}
			    	
			    	String sifra = txtSifra.getText();
			    	String naziv = txtNaziv.getText();
			    	int brojEspb = Integer.parseInt(txtBrojESPB.getText());
			    	int semestar_pom = semestarStud.getSelectedIndex()+1;
			    	int god_izvodjenja = godStud.getSelectedIndex()+1;
			    	Semestar semestar = null;
			    	if(semestar_pom == 1 || semestar_pom == 3 || semestar_pom == 5 || semestar_pom == 7) {
			    		semestar = Semestar.zimski;
			    	} else if (semestar_pom == 2 || semestar_pom == 4 || semestar_pom == 6 || semestar_pom == 8){
			    		semestar = Semestar.letnji;
			    	}
		
			    	String profesor = txtProfesor.getText(); //provera jel postoji taj profesor?
			    	List<Profesor> profesori = BazaProfesora.getInstance().getProfesori();
			    	Profesor p = new Profesor();
			    	for (Profesor i : BazaProfesora.getInstance().getProfesori()) {
						if(i.getImeIPrezime().equals(profesor)) {
							p = i;
							continue;
						} else {
							JOptionPane.showMessageDialog(MainFrame.getInstance(), "Greska! Profesor ne postoji u Bazi Profesora");
						}
					}
			    	
			    	
			    	PredmetKontroler.getInstance().dodajPredmet(sifra, naziv, semestar, god_izvodjenja, p, brojEspb);
			    	dispose();
			    	
			    }
				
			}
			
		});
		setVisible(true);
	}
	
}
