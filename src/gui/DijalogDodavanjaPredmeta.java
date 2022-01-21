package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.PredmetKontroler;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.Predmet;
import model.Profesor;
import model.Semestar;

public class DijalogDodavanjaPredmeta extends JDialog{
	
	private static final long serialVersionUID = -4081368010887320976L;
	private boolean dobarbroj = false;
	private boolean dobarnaziv = false;
	private boolean dobrasifra = false;
	static int k = 2;
	static JTextField profesorLista = new JTextField();
	static JButton btnRemoveProfesor=new JButton("-");
	static JButton btnAddProfesor=new JButton("+");

	public DijalogDodavanjaPredmeta(Frame parent, String title, boolean modal) {
		super(parent, MainFrame.getInstance().getResourceBundle().getString("dodavanje_predmeta"), modal);
		
		Dimension parentSize = parent.getSize();
		int diaWidth = parentSize.width;
		int diaHeight = parentSize.height;
		setSize(diaWidth*3/5, diaHeight*13/20);
		setLocationRelativeTo(parent);
		
		JButton potvrda=new JButton(MainFrame.getInstance().getResourceBundle().getString("potvrda"));
		potvrda.setEnabled(false);
		JButton odustanak=new JButton(MainFrame.getInstance().getResourceBundle().getString("cancel"));

		odustanak.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

					int dialogButton = JOptionPane.YES_NO_OPTION;
				    int dialogResult = JOptionPane.showConfirmDialog(null, MainFrame.getInstance().getResourceBundle().getString("siguran"), MainFrame.getInstance().getResourceBundle().getString("potvrda"), dialogButton);
	
				    if (dialogResult == JOptionPane.YES_OPTION) {
				    	dispose();
				    }
			             
				}
			});
		
		JPanel panelButton = new JPanel();
		panelButton.add(potvrda);
		panelButton.add(odustanak);
	    
	    this.add(panelButton, BorderLayout.SOUTH);
		
	    JPanel panelCenter = new JPanel();
	    panelCenter.setLayout(new GridBagLayout());
	    this.add(panelCenter, BorderLayout.CENTER);

	    
	    
	    JLabel lblSifra = new JLabel(MainFrame.getInstance().getResourceBundle().getString("sifra_predmeta"));
		JLabel lblNaziv = new JLabel(MainFrame.getInstance().getResourceBundle().getString("naziv_predmeta"));
		JLabel lblBrojESPB = new JLabel(MainFrame.getInstance().getResourceBundle().getString("br_espb"));
		JLabel lblGodina = new JLabel(MainFrame.getInstance().getResourceBundle().getString("god_izvodjenja"));
		JLabel lblSemestar = new JLabel(MainFrame.getInstance().getResourceBundle().getString("semestar"));
		JLabel lblProfesor = new JLabel(MainFrame.getInstance().getResourceBundle().getString("prof_ime_prez"));
		 
		 
		final JTextField txtSifra = new JTextField();
		final JTextField txtNaziv = new JTextField();
		final JTextField txtBrojESPB = new JTextField();
		
		GridBagConstraints gbcLSifra = new GridBagConstraints();
		gbcLSifra.fill = GridBagConstraints.HORIZONTAL;
		gbcLSifra.gridx = 0;
		gbcLSifra.gridy = 0;
		gbcLSifra.insets = new Insets(20,40, 0,0);
		panelCenter.add(lblSifra, gbcLSifra);
		 
		GridBagConstraints gbcLNaziv = new GridBagConstraints();
		gbcLNaziv.fill = GridBagConstraints.HORIZONTAL;
		gbcLNaziv.gridx = 0;
		gbcLNaziv.gridy = 1;
		gbcLNaziv.insets = new Insets(20,40, 0,0);
		panelCenter.add(lblNaziv, gbcLNaziv);
		
		GridBagConstraints gbcLBrojESPB = new GridBagConstraints();
		gbcLBrojESPB.fill = GridBagConstraints.HORIZONTAL;
		gbcLBrojESPB.gridx = 0;
		gbcLBrojESPB.gridy = 2;
		gbcLBrojESPB.insets = new Insets(20,40, 0,0);
		panelCenter.add(lblBrojESPB, gbcLBrojESPB);
		
		GridBagConstraints gbcLGodina = new GridBagConstraints();
		gbcLGodina.fill = GridBagConstraints.HORIZONTAL;
		gbcLGodina.gridx = 0;
		gbcLGodina.gridy = 3;
		gbcLGodina.insets = new Insets(20,40, 0,0);
		panelCenter.add(lblGodina, gbcLGodina);
		
		GridBagConstraints gbcLSemestar = new GridBagConstraints();
		gbcLSemestar.fill = GridBagConstraints.HORIZONTAL;
		gbcLSemestar.gridx = 0;
		gbcLSemestar.gridy = 4;
		gbcLSemestar.insets = new Insets(20,40, 0,0);
		panelCenter.add(lblSemestar, gbcLSemestar);
		
		GridBagConstraints gbcLProfesor = new GridBagConstraints();
		gbcLProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbcLProfesor.gridx = 0;
		gbcLProfesor.gridy = 5;
		gbcLProfesor.insets = new Insets(20,40, 0,0);
		panelCenter.add(lblProfesor, gbcLProfesor);
			
		GridBagConstraints gbcTxtSifra = new GridBagConstraints();
		gbcTxtSifra .gridx = 1;
		gbcTxtSifra .gridy = 0;
		gbcTxtSifra .weightx = 100;
		gbcTxtSifra .fill = GridBagConstraints.HORIZONTAL;
		gbcTxtSifra .insets = new Insets(20,120, 0, 70);
		panelCenter.add(txtSifra, gbcTxtSifra );
		txtSifra.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {
				if((txtSifra.getText()).matches("[A-ZČĆŠĐŽa-zčćšđž0-9 ]+")) {
	                dobrasifra = true;
	                if(dobarbroj && dobarnaziv && dobrasifra)
	                    potvrda.setEnabled(true);
	            }
	            else {
	                dobrasifra = false;
	                potvrda.setEnabled(false);
	            }
			}
				
        } );
		
		GridBagConstraints gbcTxtNaziv = new GridBagConstraints();
		gbcTxtNaziv .gridx = 1;
		gbcTxtNaziv.gridy = 1;
		gbcTxtNaziv .weightx = 100;
		gbcTxtNaziv.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtNaziv .insets = new Insets(20, 120, 0, 70);
		panelCenter.add(txtNaziv, gbcTxtNaziv );
		txtNaziv.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {
				if((txtNaziv.getText()).matches("([A-ZČĆŠĐŽ][a-zčćšđž0-9 ]+)+")) {
	                dobarnaziv = true;
	                if(dobarbroj && dobarnaziv && dobrasifra)
	                    potvrda.setEnabled(true);
	            }
	            else {
	                dobarnaziv = false;
	                potvrda.setEnabled(false);
	            }
			}
				
        } );
		
		GridBagConstraints gbcTxtBrojESPB = new GridBagConstraints();
		gbcTxtBrojESPB .gridx = 1;
		gbcTxtBrojESPB.gridy = 2;
		gbcTxtBrojESPB .weightx = 100;
		gbcTxtBrojESPB.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtBrojESPB .insets = new Insets(20, 120, 0, 70);
		panelCenter.add(txtBrojESPB, gbcTxtBrojESPB );
		txtBrojESPB.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {
				if((txtBrojESPB.getText()).matches("[0-9]+")) {
	                dobarbroj = true;
	                if(dobarbroj && dobarnaziv && dobrasifra)
	                    potvrda.setEnabled(true);
	            }
	            else {
	                dobarbroj = false;
	                potvrda.setEnabled(false);
	            }
			}
				
        } );
		
		
		String godinaStudija[]= {"I "+MainFrame.getInstance().getResourceBundle().getString("prva_god"),"II "+MainFrame.getInstance().getResourceBundle().getString("druga_god"),"III "+MainFrame.getInstance().getResourceBundle().getString("treca_god"),"IV "+MainFrame.getInstance().getResourceBundle().getString("cetvrta_god")};
		JComboBox<String> godStud=new JComboBox<>(godinaStudija);
		   
		GridBagConstraints grdGodina = new GridBagConstraints();
		grdGodina.gridx = 1;
		grdGodina.gridy = 3;
		grdGodina.weightx = 100;
		grdGodina.fill = GridBagConstraints.HORIZONTAL;
		grdGodina.insets = new Insets(20, 120, 0, 70);
		panelCenter.add(godStud,grdGodina);
		
			
		
		String semestar[]= {MainFrame.getInstance().getResourceBundle().getString("letnji"), MainFrame.getInstance().getResourceBundle().getString("zimski")};
		JComboBox<String> semestarStud=new JComboBox<>(semestar);
		   
		GridBagConstraints grdSemestar= new GridBagConstraints();
		grdSemestar.gridx = 1;
		grdSemestar.gridy = 4;
	    grdSemestar.weightx = 100;
		grdSemestar.fill = GridBagConstraints.HORIZONTAL;
		grdSemestar.insets = new Insets(20, 120, 0, 70);
		panelCenter.add(semestarStud,grdSemestar);
		
		profesorLista.setEditable(false);
		profesorLista.setPreferredSize(new Dimension(178,25));
		profesorLista.setText("");
		
		btnAddProfesor.setPreferredSize(new Dimension(30,20));
		btnRemoveProfesor.setPreferredSize(new Dimension(30,20));
		btnRemoveProfesor.setEnabled(false);
		btnAddProfesor.setEnabled(true);
		JPanel panelButton2 = new JPanel();
		panelButton2.setLayout(new FlowLayout());
		panelButton2.add(btnRemoveProfesor, FlowLayout.LEFT);
		panelButton2.add(btnAddProfesor, FlowLayout.LEFT);
		panelButton2.add(profesorLista, FlowLayout.LEFT);
		
		GridBagConstraints gbcTxtProfesor = new GridBagConstraints();
		gbcTxtProfesor .gridx = 1;
		gbcTxtProfesor.gridy = 5;
		gbcTxtProfesor .weightx = 100;
		gbcTxtProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtProfesor .insets = new Insets(20, 120, 0, 70);
		panelCenter.add(panelButton2, gbcTxtProfesor);
		
		btnAddProfesor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				k = 1;
				DijalogDodavanjeProfesoraNaPredmet OdabirProfesora = new DijalogDodavanjeProfesoraNaPredmet(parent, MainFrame.getInstance().getResourceBundle().getString("odabir_profesora"), true, k);
				OdabirProfesora.setVisible(true);
			}
			
		});
		
		btnRemoveProfesor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DijalogDodavanjaPredmeta.profesorLista.setText(null);
			    DijalogDodavanjaPredmeta.btnRemoveProfesor.setEnabled(false);
			    DijalogDodavanjaPredmeta.btnAddProfesor.setEnabled(true);
			}
			
		});
		
		potvrda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
			    int dialogResult = JOptionPane.showConfirmDialog(null, MainFrame.getInstance().getResourceBundle().getString("siguran"), MainFrame.getInstance().getResourceBundle().getString("potvrda"), dialogButton);

			    if (dialogResult == JOptionPane.YES_OPTION) {

			    	if(txtSifra.getText().isEmpty() || txtNaziv.getText().isEmpty() || txtBrojESPB.getText().isEmpty()) {
			    		
			    		JOptionPane.showMessageDialog(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("mora_popunjeno"), MainFrame.getInstance().getResourceBundle().getString("greska"), JOptionPane.ERROR_MESSAGE);
			    		return;
			    	}
			    	
			    	String sifra = txtSifra.getText();
			    	for(Predmet i : BazaPredmeta.getInstance().getPredmeti()) {
			    		if(i.getSifra_predmeta().equals(sifra)) {
			    			JOptionPane.showMessageDialog(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("postoji_sa_sifrom"));
			    			return;
			    		}
			    	}
			    	String naziv = txtNaziv.getText();
			    	int brojEspb = Integer.parseInt(txtBrojESPB.getText());
			    	int semestar_pom = semestarStud.getSelectedIndex()+1;
			    	int god_izvodjenja = godStud.getSelectedIndex()+1;
			    	Semestar semestar = null;
			    	if(semestar_pom == 2) {
			    		semestar = Semestar.zimski;
			    	} else if (semestar_pom == 1){
			    		semestar = Semestar.letnji;
			    	}
		
			    	String profesor = profesorLista.getText();
			    	
			    	Profesor p = null;
			    	for (Profesor i : BazaProfesora.getInstance().getProfesori()) {
						if(i.getImeIPrezime().equals(profesor)) {
							p = i;
							break;
						}
					}

			    	PredmetKontroler.getInstance().dodajPredmet(sifra, naziv, semestar, god_izvodjenja, p, brojEspb);
			    	dispose();
			    	
			    }
				
			}
			
		});

	}
	
}
