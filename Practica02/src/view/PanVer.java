package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.CtrlEmpleado;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanVer extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNombre, tfFechaNacimiento, tfSalario;
	private JLabel lblNombre, lblFechaNacimiento, lblSalario;
	private JButton btnPrimero, btnSiguiente, btnAnterior, btnUltimo;
	
	private CtrlEmpleado ctrlEmpleado;

	/**
	 * Create the panel.
	 */
	public PanVer(CtrlEmpleado ctrl) {
		ctrlEmpleado = ctrl;
		
		setLayout(null);

		addComponents();
		
		addListeners();

	}

	private void addComponents() {
		tfFechaNacimiento = new JTextField();
		tfFechaNacimiento.setBounds(181, 85, 213, 37);
		tfFechaNacimiento.setText("05-04-2005");
		tfFechaNacimiento.setEditable(false);
		tfFechaNacimiento.setColumns(10);
		add(tfFechaNacimiento);

		lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setBounds(0, 66, 213, 74);
		lblFechaNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblFechaNacimiento);

		tfNombre = new JTextField();
		tfNombre.setBounds(181, 19, 213, 37);
		tfNombre.setText("Emanuel E.");
		tfNombre.setEditable(false);
		tfNombre.setColumns(10);
		add(tfNombre);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(0, 0, 213, 74);
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNombre);

		lblSalario = new JLabel("Salario");
		lblSalario.setBounds(0, 130, 213, 74);
		lblSalario.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblSalario);

		tfSalario = new JTextField();
		tfSalario.setBounds(181, 149, 213, 37);
		tfSalario.setText("9999.99");
		tfSalario.setEditable(false);
		tfSalario.setColumns(10);
		add(tfSalario);

		btnPrimero = new JButton("Primero");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPrimero.setBounds(30, 196, 85, 21);
		add(btnPrimero);

		btnSiguiente = new JButton("Avanzar");
		btnSiguiente.setBounds(125, 197, 85, 21);
		add(btnSiguiente);
		
		btnAnterior = new JButton("Retroceder");
		btnAnterior.setBounds(220, 197, 127, 21);
		add(btnAnterior);

		btnUltimo = new JButton("Último");
		btnUltimo.setBounds(357, 196, 85, 21);
		add(btnUltimo);

		
		
		

		
		
		
		
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

					
				}

			}
		});

		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (ctrlEmpleado.getIndex() + 1 == ctrlEmpleado.getListadoEmpleado().size()) {
					// SI LA SIGUIENTE VEZ QUE AVANCES ES IGUAL EL ÍNDICE AL TAMAÑO DE LA LISTA
					// SIGNIFICA QUE NO HAY MÁS EMPLEADOS PARA AVANZAR
					btnSiguiente.setEnabled(false);
					
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
		
	
	}
	
	private void mostrarEmpleado() {
		tfNombre.setText(ctrlEmpleado.getListadoEmpleado().get(ctrlEmpleado.getIndex()).getNombre());
		tfFechaNacimiento.setText(ctrlEmpleado.getListadoEmpleado().get(ctrlEmpleado.getIndex()).getFechaNacimiento());
		tfSalario.setText(ctrlEmpleado.getListadoEmpleado().get(ctrlEmpleado.getIndex()).getSalario() + "");
	}
}
