package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.CtrlEmpleado;

public class PanAlta extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNombre, tfFechaNacimiento, tfSalario;
	private JButton btnAlta, btnBorrar;
	private JLabel lblFechaNacimiento, lblNombre, lblSalario;

	/**
	 * Create the panel.
	 */
	public PanAlta(CtrlEmpleado ctrlEmpleado) {
		setLayout(null);

		addComponents();

	}

	private void addComponents() {
		tfFechaNacimiento = new JTextField();
		tfFechaNacimiento.setBounds(181, 85, 213, 37);
		tfFechaNacimiento.setText("");
		tfFechaNacimiento.setEditable(true);
		tfFechaNacimiento.setColumns(10);
		add(tfFechaNacimiento);

		lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setBounds(0, 66, 213, 74);
		lblFechaNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblFechaNacimiento);

		tfNombre = new JTextField();
		tfNombre.setBounds(181, 19, 213, 37);
		tfNombre.setText("");
		tfNombre.setEditable(true);
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
		tfSalario.setText("");
		tfSalario.setEditable(true);
		tfSalario.setColumns(10);
		add(tfSalario);

		btnAlta = new JButton("Aceptar");
		btnAlta.setBounds(142, 197, 85, 21);
		add(btnAlta);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(247, 196, 85, 21);
		add(btnBorrar);
	}
}
