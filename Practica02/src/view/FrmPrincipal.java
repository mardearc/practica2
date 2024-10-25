package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.CtrlEmpleado;
import model.Empleado;

public class FrmPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	// CREACIÓN PANELES
	private JPanel panPrincipal, panInfo, panBotones;
	// CREACIÓN CAMPOS DE TEXTO
	private JTextField tfNombre, tfFechaNacimiento, tfSalario;
	// CREACIÓN CONTROLLER
	private CtrlEmpleado ctrlEmpleado;
	// CREACIÓN BOTONES
	private JButton btnAnterior, btnSiguiente, btnAdd, btnLimpiar;
	// CREACIÓN ETIQUETAS
	private JLabel lblNombre, lblSalario, lblFechaNacimiento;

	// CREACIÓN E INICIALIZACIÓN PARA SABER SI ESTÁ ACTIVADA LA FUNCIONALIDAD DE
	// AÑADIR EMPLEADO
	private boolean addActivado = false;

	/**
	 * CREACIÓN FRAME PRINCIPAL
	 */
	public FrmPrincipal() {
		// INICIALIZACIÓN CONTROLLER EMPLEADO
		ctrlEmpleado = new CtrlEmpleado();

		// ATRIBUTOS FRAME PRINCIPAL
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Practica 1 - efertre");
		setLocationRelativeTo(null);
		panPrincipal = new JPanel();
		panPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panPrincipal);
		panPrincipal.setLayout(new BorderLayout(0, 0));

		// LLAMADA AL MÉTODO PARA INICIALIZAR LOS COMPONENTES
		addComponents();

		// LLAMADA AL MÉTODO PARA AÑADIR EVENTOS A LOS COMPONENTES
		addListeners();

		// LLAMADA AL MÉTODO PARA VISUALIZAR LOS DATOS DEL EMPLEADO
		mostrarEmpleado();

	}

	private void addComponents() {
		// INICIALIZACIÓN Y ATRIBUTOS PANEL CON DATOS DEL EMPLEADO
		panInfo = new JPanel();
		panPrincipal.add(panInfo, BorderLayout.CENTER);
		panInfo.setLayout(null);

		// INICIALIZACIÓN Y ATRIBUTOS ETIQUETA CON NOMBRE DEL EMPLEADO
		lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(0, 0, 213, 74);
		panInfo.add(lblNombre);

		// INICIALIZACIÓN Y ATRIBUTOS CAMPO DE TEXTO CON NOMBRE DEL EMPLEADO
		tfNombre = new JTextField();
		tfNombre.setBounds(181, 19, 213, 37);
		tfNombre.setEditable(false);
		tfNombre.setColumns(10);
		panInfo.add(tfNombre);
		

		// INICIALIZACIÓN Y ATRIBUTOS ETIQUETA CON FECHA NACIMIENTO DEL EMPLEADO
		lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaNacimiento.setBounds(0, 74, 213, 74);
		panInfo.add(lblFechaNacimiento);

		// INICIALIZACIÓN Y ATRIBUTOS CAMPO DE TEXTO CON FECHA NACIMIENTO DEL EMPLEADO
		tfFechaNacimiento = new JTextField();
		tfFechaNacimiento.setBounds(181, 93, 213, 37);
		tfFechaNacimiento.setColumns(10);
		tfFechaNacimiento.setEditable(false);
		panInfo.add(tfFechaNacimiento);

		// INICIALIZACIÓN Y ATRIBUTOS ETIQUETA CON SALARIO DEL EMPLEADO
		lblSalario = new JLabel("Salario");
		lblSalario.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalario.setBounds(0, 148, 213, 74);
		panInfo.add(lblSalario);

		// INICIALIZACIÓN Y ATRIBUTOS CAMPO DE TEXTO CON SALARIO DEL EMPLEADO
		tfSalario = new JTextField();
		tfSalario.setBounds(181, 167, 213, 37);
		tfSalario.setColumns(10);
		tfSalario.setEditable(false);
		panInfo.add(tfSalario);

		// INICIALIZACIÓN PANEL DE BOTONES
		panBotones = new JPanel();

		// ADICIÓN AL PANEL PRINCIPAL
		panPrincipal.add(panBotones, BorderLayout.SOUTH);

		// INICIALIZACIÓN BOTÓN PARA RETROCEDER EL EMPLEADO
		btnAnterior = new JButton("Anterior");
		btnAnterior.setEnabled(false);

		// INICIALIZACIÓN BOTÓN PARA PASAR AL SIGUIENTE EMPLEADO
		btnSiguiente = new JButton("Siguiente");

		// INICIALIZACIÓN BOTÓN PARA AÑADIR NUEVO EMPLEADO
		btnAdd = new JButton("Alta");
		btnAdd.setEnabled(false);
		btnAdd.setVisible(false);

		// INICIALIZACIÓN BOTÓN PARA LIMPIAR CAMPOS NUEVO EMPLEADO
		btnLimpiar = new JButton("Cancelar");
		btnLimpiar.setEnabled(false);
		btnLimpiar.setVisible(false);

		// ADICIÓN DE BOTONES AL PANEL DE BOTONES
		panBotones.add(btnAnterior);
		panBotones.add(btnSiguiente);
		panBotones.add(btnAdd);
		panBotones.add(btnLimpiar);
	}

	private void addListeners() {
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarAnteriorEmpleado();
			}

			private void mostrarAnteriorEmpleado() {
				// SI SE PUEDE RETROCEDER, RETROCEDE Y MUESTRA EL EMPLEADO ANTERIOR
				if (ctrlEmpleado.anteriorEmpleado()) {
					mostrarEmpleado();
					// SI AL RETROCEDER EL ÍNDICE ES MENOR QUE 0 (NO HAY MÁS EMPLEADOS) DESACTIVA EL
					// BOTÓN RETROCEDER
					if (ctrlEmpleado.getIndex() - 1 < 0) {
						btnAnterior.setEnabled(false);
					}

					// SI AL RETROCEDER EL ÍNDICE ES MENOR QUE EL TAMAÑO (HAY MÁS EMPLEADOS
					// DESPUÉS) ACTIVA EL BOTÓN SIGUIENTE

					if (ctrlEmpleado.getIndex() < ctrlEmpleado.getListadoEmpleado().size()) {
						btnSiguiente.setEnabled(true);
					}

					// SI ESTÁ ACTIVADA LA FUNCIONALIDAD DE AÑADIR QUE SE DESACTIVE
					if (addActivado) {
						desactivarAdd();
					}
				}

			}
		});

		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (ctrlEmpleado.getIndex() + 1 == ctrlEmpleado.getListadoEmpleado().size()) {
					// SI LA SIGUIENTE VEZ QUE AVANCES ES IGUAL EL ÍNDICE AL TAMAÑO DE LA LISTA
					// SIGNIFICA QUE NO HAY MÁS EMPLEADOS PARA AVANZAR
					// SE ACTIVA UNA NUEVA FUNCIONALIDAD (BOTÓN PARA AÑADIR)
					activarAdd();
				} else {
					// DE LO CONTRARIO QUE *INTENTE* AVANZAR CON NORMALIDAD
					mostrarSiguienteEmpleado();
				}

			}

			private void mostrarSiguienteEmpleado() {
				// SI HAY SIGUIENTE EMPLEADO, VISUALIZA EL SIGUIENTE
				if (ctrlEmpleado.siguienteEmpleado()) {
					mostrarEmpleado();
					
					// AVANZAS UN EMPLEADO POR ENDE EXISTE UN EMPLEADO AL QUE RETROCEDER
					btnAnterior.setEnabled(true);

				}

			}

		});

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// SI HAY CONTENIDO EN LOS CAMPOS, AÑADIR EL NUEVO EMPLEADO
				if (tfNombre.getText().length() > 0 && tfFechaNacimiento.getText().length() > 0
						&& tfSalario.getText().length() > 0) {
					ctrlEmpleado.addEmpleado(new Empleado(tfNombre.getText(), tfFechaNacimiento.getText(),
							Double.parseDouble(tfSalario.getText())));
					desactivarAdd();
				}

			}
		});
		
		btnLimpiar.addActionListener(new ActionListener() {
			// LIMPIAR EL CONTENIDO DE LOS CAMPOS
			public void actionPerformed(ActionEvent e) {
				tfNombre.setText("");
				tfFechaNacimiento.setText("");
				tfSalario	.setText("");

			}
		});
	}

	private void mostrarEmpleado() {
		tfNombre.setText(ctrlEmpleado.getListadoEmpleado().get(ctrlEmpleado.getIndex()).getNombre());
		tfFechaNacimiento.setText(ctrlEmpleado.getListadoEmpleado().get(ctrlEmpleado.getIndex()).getFechaNacimiento());
		tfSalario.setText(ctrlEmpleado.getListadoEmpleado().get(ctrlEmpleado.getIndex()).getSalario() + "");
	}

	private void activarAdd() {
		btnSiguiente.setVisible(false);

		// AÑADIMOS UN NUEVO ÍNDICE PARA EL POSIBLE NUEVO EMPLEADO
		ctrlEmpleado.setIndex(ctrlEmpleado.getListadoEmpleado().size());

		// PREPARAMOS LOS CAMPOS PARA QUE SEAN MANIPULADOS
		tfFechaNacimiento.setEditable(true);
		tfFechaNacimiento.setText("");
		tfNombre.setEditable(true);
		tfNombre.setText("");
		tfSalario.setEditable(true);
		tfSalario.setText("");
		btnAdd.setVisible(true);
		btnAdd.setEnabled(true);
		btnLimpiar.setVisible(true);
		btnLimpiar.setEnabled(true);
		
		addActivado = true;

	}

	private void desactivarAdd() {
		btnSiguiente.setVisible(true);

		// PREPARAMOS LOS CAMPOS PARA QUE DEJEN DE SER MANIPULADOS
		tfFechaNacimiento.setEditable(false);
		tfNombre.setEditable(false);
		tfSalario.setEditable(false);
		btnAdd.setVisible(false);
		btnAdd.setEnabled(false);
		btnLimpiar.setVisible(false);
		btnLimpiar.setEnabled(false);
		addActivado = false;

	}

}
