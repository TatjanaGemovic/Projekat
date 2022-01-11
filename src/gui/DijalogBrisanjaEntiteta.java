package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.PredmetKontroler;
import controller.ProfesorKontroler;
import controller.StudentKontroler;

public class DijalogBrisanjaEntiteta extends JDialog{

	private static final long serialVersionUID = -4141971147148640617L;

	public DijalogBrisanjaEntiteta(Frame parent, String title, boolean modal) {
		super(parent, "Brisanje " + TabbedPane.tabIndex + "a", modal);
		
		Dimension parentSize = parent.getSize();
		int diaWidth = parentSize.width;
		int diaHeight = parentSize.height;
		setSize(diaWidth*2/5, diaHeight*4/20);
		setLocationRelativeTo(parent);
	    
	    JPanel panelCenter = new JPanel();
	    JLabel brisanje = new JLabel();
	    switch (TabbedPane.tabIndex) {
		case Profesor:
			brisanje = new JLabel("Da li ste sigurni da zelite da obrisete profesora?");
			break;
		case Predmet:
			brisanje = new JLabel("Da li ste sigurni da zelite da obrisete predmet?");
			break;
		default:
			brisanje = new JLabel("Da li ste sigurni da zelite da obrisete studenta?");
	   }
		
		panelCenter.add(brisanje, BorderLayout.CENTER);
	    this.add(panelCenter, BorderLayout.CENTER);
	    
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
	    
	    potvrda.addActionListener((ActionListener) new ActionListener() {
	    	@Override
			public void actionPerformed(ActionEvent arg0) {
	    		
	    		int dialogButton = JOptionPane.YES_NO_OPTION;
		           int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Potvrda brisanja", dialogButton);

		           if (dialogResult == JOptionPane.YES_OPTION) {
		        	   switch (TabbedPane.tabIndex) {
						case Profesor:
							ProfesorKontroler.getInstance().izbrisiProfesora(ProfesoriJTable.rowSelectedIndex);
							ProfesoriJTable.rowSelectedIndex=-1;
							break;
						case Predmet:
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
