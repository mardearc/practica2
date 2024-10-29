package view;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.CtrlEmpleado;

public class FrmPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	// CREACIÓN PANELES
	private JPanel panPrincipal, panInfo, panBotones, panVer, panAlta, panAcercaDe;
	// CREACIÓN CAMPOS DE TEXTO
	private JTextField tfNombre, tfFechaNacimiento, tfSalario;
	// CREACIÓN CONTROLLER
	private CtrlEmpleado ctrlEmpleado;
	// CREACIÓN BOTONES
	private JButton btnAnterior, btnSiguiente, btnAdd, btnLimpiar;
	// CREACIÓN ETIQUETAS
	private JLabel lblNombre, lblSalario, lblFechaNacimiento;
	//CREACION MENUITEM
	private JMenuItem mntmMenuVer, mntmMenuAlta, mntmMenuAcercaDe;

	// CREACIÓN E INICIALIZACIÓN PARA SABER SI ESTÁ ACTIVADA LA FUNCIONALIDAD DE
	// AÑADIR EMPLEADO
	private boolean addActivado = false;
	private JMenuBar menuBar;

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
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mntmMenuVer = new JMenuItem("Ver");
		menuBar.add(mntmMenuVer);
		
		mntmMenuAlta = new JMenuItem("Alta");
		menuBar.add(mntmMenuAlta);
		
		mntmMenuAcercaDe = new JMenuItem("Acerca De");
		menuBar.add(mntmMenuAcercaDe);
		panPrincipal = new JPanel();
		panPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panPrincipal);

		// LLAMADA AL MÉTODO PARA INICIALIZAR LOS COMPONENTES
		addComponents();

		// LLAMADA AL MÉTODO PARA AÑADIR EVENTOS A LOS COMPONENTES
		addListeners();

//		// LLAMADA AL MÉTODO PARA VISUALIZAR LOS DATOS DEL EMPLEADO
//		mostrarEmpleado();

	}

	private void addComponents() {
		panPrincipal.setLayout(new CardLayout(0, 0));
		//INCIALIZACION PANVER
		panVer = new PanVer(ctrlEmpleado);
		panPrincipal.add(panVer, "panVer");
		
		//INICIALIZACION PALTA
		panAlta = new PanAlta(ctrlEmpleado);
		panAlta.setVisible(false);
		panPrincipal.add(panAlta, "panAlta");
		
		//INCICIALIZACION PANACERCADE
		panAcercaDe = new PanAcercaDe();
		panAlta.setVisible(false);
		panPrincipal.add(panAcercaDe, "name_1702339033446700");
		
//		// INICIALIZACIÓN Y ATRIBUTOS PANEL CON DATOS DEL EMPLEADO
//		panInfo = new JPanel();
//		panPrincipal.add(panInfo, BorderLayout.CENTER);
//		panInfo.setLayout(null);
//
//		// INICIALIZACIÓN Y ATRIBUTOS ETIQUETA CON NOMBRE DEL EMPLEADO
//		lblNombre = new JLabel("Nombre");
//		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNombre.setBounds(0, 0, 213, 74);
//		panInfo.add(lblNombre);
//
//		// INICIALIZACIÓN Y ATRIBUTOS CAMPO DE TEXTO CON NOMBRE DEL EMPLEADO
//		tfNombre = new JTextField();
//		tfNombre.setBounds(181, 19, 213, 37);
//		tfNombre.setEditable(false);
//		tfNombre.setColumns(10);
//		panInfo.add(tfNombre);
//		
//
//		// INICIALIZACIÓN Y ATRIBUTOS ETIQUETA CON FECHA NACIMIENTO DEL EMPLEADO
//		lblFechaNacimiento = new JLabel("Fecha Nacimiento");
//		lblFechaNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
//		lblFechaNacimiento.setBounds(0, 66, 213, 74);
//		panInfo.add(lblFechaNacimiento);
//
//		// INICIALIZACIÓN Y ATRIBUTOS CAMPO DE TEXTO CON FECHA NACIMIENTO DEL EMPLEADO
//		tfFechaNacimiento = new JTextField();
//		tfFechaNacimiento.setBounds(181, 85, 213, 37);
//		tfFechaNacimiento.setColumns(10);
//		tfFechaNacimiento.setEditable(false);
//		panInfo.add(tfFechaNacimiento);
//
//		// INICIALIZACIÓN Y ATRIBUTOS ETIQUETA CON SALARIO DEL EMPLEADO
//		lblSalario = new JLabel("Salario");
//		lblSalario.setHorizontalAlignment(SwingConstants.CENTER);
//		lblSalario.setBounds(0, 130, 213, 74);
//		panInfo.add(lblSalario);
//
//		// INICIALIZACIÓN Y ATRIBUTOS CAMPO DE TEXTO CON SALARIO DEL EMPLEADO
//		tfSalario = new JTextField();
//		tfSalario.setBounds(181, 149, 213, 37);
//		tfSalario.setColumns(10);
//		tfSalario.setEditable(false);
//		panInfo.add(tfSalario);
//
//		// INICIALIZACIÓN PANEL DE BOTONES
//		panBotones = new JPanel();
//
//		// ADICIÓN AL PANEL PRINCIPAL
//		panPrincipal.add(panBotones, BorderLayout.SOUTH);
//
//		// INICIALIZACIÓN BOTÓN PARA RETROCEDER EL EMPLEADO
//		btnAnterior = new JButton("Anterior");
//		btnAnterior.setEnabled(false);
//
//		// INICIALIZACIÓN BOTÓN PARA PASAR AL SIGUIENTE EMPLEADO
//		btnSiguiente = new JButton("Siguiente");
//
//		// INICIALIZACIÓN BOTÓN PARA AÑADIR NUEVO EMPLEADO
//		btnAdd = new JButton("Alta");
//		btnAdd.setEnabled(false);
//		btnAdd.setVisible(false);
//
//		// INICIALIZACIÓN BOTÓN PARA LIMPIAR CAMPOS NUEVO EMPLEADO
//		btnLimpiar = new JButton("Cancelar");
//		btnLimpiar.setEnabled(false);
//		btnLimpiar.setVisible(false);
//
//		// ADICIÓN DE BOTONES AL PANEL DE BOTONES
//		panBotones.add(btnAnterior);
//		panBotones.add(btnSiguiente);
//		panBotones.add(btnAdd);
//		panBotones.add(btnLimpiar);
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
		
//		
//
//		btnAdd.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				// SI HAY CONTENIDO EN LOS CAMPOS, AÑADIR EL NUEVO EMPLEADO
//				if (tfNombre.getText().length() > 0 && tfFechaNacimiento.getText().length() > 0
//						&& tfSalario.getText().length() > 0) {
//					ctrlEmpleado.addEmpleado(new Empleado(tfNombre.getText(), tfFechaNacimiento.getText(),
//							Double.parseDouble(tfSalario.getText())));
//					desactivarAdd();
//				}
//
//			}
//		});
//		
//		btnLimpiar.addActionListener(new ActionListener() {
//			// LIMPIAR EL CONTENIDO DE LOS CAMPOS
//			public void actionPerformed(ActionEvent e) {
//				tfNombre.setText("");
//				tfFechaNacimiento.setText("");
//				tfSalario.setText("");
//
//			}
//		});
//	}
//

}
