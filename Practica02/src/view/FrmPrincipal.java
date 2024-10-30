package view;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import view.JMenuBarRefactor;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CtrlEmpleado;

public class FrmPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	// CREACIÓN PANELES
	private JPanel panPrincipal, panVer, panAlta, panAcercaDe;

	// CREACION MENUITEM
	private JMenuItem mntmMenuVer, mntmMenuAlta, mntmMenuAcercaDe;

	// CREACIÓN CONTROLLER
	private CtrlEmpleado ctrlEmpleado;

	private JMenuBarRefactor menuBar;

	/**
	 * CREACIÓN FRAME PRINCIPAL
	 */
	public FrmPrincipal() {

		// INICIALIZACIÓN CONTROLLER EMPLEADO
		ctrlEmpleado = new CtrlEmpleado();

		// ATRIBUTOS FRAME PRINCIPAL
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 323);
		setTitle("Practica 2 - Ema, Recacha y Jesus");
		setResizable(false);
		setLocationRelativeTo(null);

		panPrincipal = new JPanel();
		panPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panPrincipal);

		// LLAMADA AL MÉTODO PARA INICIALIZAR LOS COMPONENTES
		addComponents();

	}

	private void addComponents() {
		panPrincipal.setLayout(new CardLayout(0, 0));
		// INCIALIZACION PANVER
		panVer = new PanVer(ctrlEmpleado);
		panPrincipal.add(panVer, "panVer");

		// INICIALIZACION PALTA
		panAlta = new PanAlta(ctrlEmpleado);
		panAlta.setVisible(false);
		panPrincipal.add(panAlta, "panAlta");

		// INCICIALIZACION PANACERCADE
		panAcercaDe = new PanAcercaDe();
		panAlta.setVisible(false);
		panPrincipal.add(panAcercaDe, "name_1702339033446700");

		menuBar = new JMenuBarRefactor(panVer, panAlta, panAcercaDe);

		setJMenuBar(menuBar.crearMenuBar());

	}

}
