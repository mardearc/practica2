package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class JMenuBarRefactor extends JMenuBar  {

	// CREACION MENUITEM
	private JMenuItem mntmMenuVer, mntmMenuAlta, mntmMenuAcercaDe;

	// CREACIÓN PANELES
	private JPanel panVer, panAlta, panAcercaDe;
	
	private JMenuBar menuBar;

	public JMenuBarRefactor(JPanel panVer, JPanel panAlta, JPanel panAcercaDe) {
		menuBar = new JMenuBar();
		
		this.panVer = panVer;
		this.panAlta = panAlta;
		this.panAcercaDe = panAcercaDe;
		
		mntmMenuVer = new JMenuItem("Ver");
		menuBar.add(mntmMenuVer);

		mntmMenuAlta = new JMenuItem("Alta");
		menuBar.add(mntmMenuAlta);

		mntmMenuAcercaDe = new JMenuItem("Acerca De");
		menuBar.add(mntmMenuAcercaDe);

		// LLAMADA AL MÉTODO PARA AÑADIR EVENTOS A LOS COMPONENTES
		addListeners();
	}

	private void addListeners() {
		mntmMenuVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panVer.setVisible(true);
				panAcercaDe.setVisible(false);
				panAlta.setVisible(false);
			}
		});

		mntmMenuAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panVer.setVisible(false);
				panAcercaDe.setVisible(false);
				panAlta.setVisible(true);
			}
		});

		mntmMenuAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panVer.setVisible(false);
				panAlta.setVisible(false);
				panAcercaDe.setVisible(true);
			}
		});
	}
	
	public JMenuBar crearMenuBar() {
		
		return menuBar;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

}
