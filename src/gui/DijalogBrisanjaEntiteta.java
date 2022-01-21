package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.PredmetKontroler;
import controller.ProfesorKontroler;
import controller.StudentKontroler;
import model.BazaKatedri;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;
import model.Katedra;
import model.OcenaNaIspitu;
import model.Predmet;
import model.Profesor;
import model.Student;

public class DijalogBrisanjaEntiteta extends JDialog{

	private static final long serialVersionUID = -4141971147148640617L;

	public DijalogBrisanjaEntiteta(Frame parent, String title, boolean modal) {
		super(parent, MainFrame.getInstance().getResourceBundle().getString("brisanje_entiteta") + " " + TabbedPane.tabIndex, modal);
		
		Dimension parentSize = parent.getSize();
		int diaWidth = parentSize.width;
		int diaHeight = parentSize.height;
		setSize(diaWidth*2/5, diaHeight*4/20);
		setLocationRelativeTo(parent);
	    
	    JPanel panelCenter = new JPanel();
	    JLabel brisanje = new JLabel();
	    switch (TabbedPane.tabIndex) {
		case Profesor:
			brisanje = new JLabel(MainFrame.getInstance().getResourceBundle().getString("siguran_profesor"));
			break;
		case Predmet:
			brisanje = new JLabel(MainFrame.getInstance().getResourceBundle().getString("siguran_predmet"));
			break;
		default:
			brisanje = new JLabel(MainFrame.getInstance().getResourceBundle().getString("siguran_student"));
	   }
		
		panelCenter.add(brisanje, BorderLayout.CENTER);
	    this.add(panelCenter, BorderLayout.CENTER);
	    
	    JPanel panelBottom = new JPanel();
		JButton potvrda=new JButton(MainFrame.getInstance().getResourceBundle().getString("potvrda"));
		JButton odustanak=new JButton(MainFrame.getInstance().getResourceBundle().getString("cancel"));
		odustanak.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			int dialogButton = JOptionPane.YES_NO_OPTION;
			           int dialogResult = JOptionPane.showConfirmDialog(null, "siguran", "potvrda", dialogButton);

			           if (dialogResult == JOptionPane.YES_OPTION) {
			        	   dispose();
			           }
			             
				}
			});
		
		panelBottom.add(potvrda);
	    panelBottom.add(odustanak);
	    
	    this.add(panelBottom, BorderLayout.SOUTH);
	    
	    potvrda.addActionListener((ActionListener) new ActionListener() {
	    	@Override
			public void actionPerformed(ActionEvent arg0) {
	    		
	    		int dialogButton = JOptionPane.YES_NO_OPTION;
		           int dialogResult = JOptionPane.showConfirmDialog(null, MainFrame.getInstance().getResourceBundle().getString("siguran"), MainFrame.getInstance().getResourceBundle().getString("potvrda"), dialogButton);

		           if (dialogResult == JOptionPane.YES_OPTION) {
		        	   switch (TabbedPane.tabIndex) {
						case Profesor:
							for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
								if(p.getPredmetni_profesor()!=null && (p.getPredmetni_profesor().getImeIPrezime().equals(BazaProfesora.getInstance().getRow(ProfesoriJTable.rowSelectedIndex).getImeIPrezime()) || p.getPredmetni_profesor().getBroj_licne_karte().equals(BazaProfesora.getInstance().getRow(ProfesoriJTable.rowSelectedIndex).getBroj_licne_karte()))) {
									p.setPredmetni_profesor(null);
								}
							}
							for(Katedra k : BazaKatedri.getInstance().getKatedre()) {
								if(k.getSef_katedre()!= null && k.getSef_katedre().getBroj_licne_karte().equals(BazaProfesora.getInstance().getRow(ProfesoriJTable.rowSelectedIndex).getBroj_licne_karte())) {
									k.setSef_katedre(null);
								}
							}
							ProfesorKontroler.getInstance().izbrisiProfesora(ProfesoriJTable.rowSelectedIndex);
							ProfesoriJTable.rowSelectedIndex=-1;
							break;
						case Predmet:
							for(Student s : BazaStudenata.getInstance().getStudenti()) {
								ArrayList<OcenaNaIspitu> nep_ispiti = s.getNepolozeni_ispiti();
								for(OcenaNaIspitu o : nep_ispiti) {
									if(o.getPredmet().getSifra_predmeta().equals(BazaPredmeta.getInstance().getRow(PredmetiJTable.rowSelectedIndex).getSifra_predmeta())) {
										s.getNepolozeni_ispiti().remove(o);
										break;
									}
								}
							}
							for(Profesor p : BazaProfesora.getInstance().getProfesori()) {
								ArrayList<Predmet> predmeti = p.getProfesor_na_predmetu();
								for(Predmet pred : predmeti) {
									if(pred.getSifra_predmeta().equals(BazaPredmeta.getInstance().getRow(PredmetiJTable.rowSelectedIndex).getSifra_predmeta())) {
										p.getProfesor_na_predmetu().remove(pred);
										break;
									}
								}
							}
							PredmetKontroler.getInstance().izbrisiPredmet(PredmetiJTable.rowSelectedIndex);
							PredmetiJTable.rowSelectedIndex=-1;
							break;
						default:
							StudentKontroler.getInstance().izbrisiStudenta(StudentiJTable.rowSelectedIndex);
							StudentiJTable.rowSelectedIndex=-1;
		        	   }
		        	   dispose();
		           }
	    	}
	    });
	}
	
}
