package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.CtrlEmpleado;
import controller.CtrlError;
import model.Empleado;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class PanAlta extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNombre, tfFechaNacimiento, tfSalario;
	private JButton btnAdd, btnLimpiar;
	private JLabel lblFechaNacimiento, lblNombre, lblSalario;
	private JTextField tfDni;
	static CtrlError ctrlError = new CtrlError();

	/**
	 * Create the panel.
	 */
	public PanAlta(CtrlEmpleado ctrlEmpleado) {
		setLayout(null);

		addComponents();

		addListeners(ctrlEmpleado);
	}

	private void addComponents() {
		tfFechaNacimiento = new JTextField();
		tfFechaNacimiento.setBounds(181, 144, 213, 37);
		tfFechaNacimiento.setText("");
		tfFechaNacimiento.setEditable(true);
		tfFechaNacimiento.setColumns(10);
		add(tfFechaNacimiento);

		lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setBounds(0, 125, 213, 74);
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
		lblSalario.setBounds(0, 84, 213, 74);
		lblSalario.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblSalario);

		tfSalario = new JTextField();
		tfSalario.setBounds(181, 103, 213, 37);
		tfSalario.setText("");
		tfSalario.setEditable(true);
		tfSalario.setColumns(10);
		add(tfSalario);

		btnAdd = new JButton("Aceptar");

		btnAdd.setBounds(142, 197, 85, 21);
		add(btnAdd);

		btnLimpiar = new JButton("Borrar");

		btnLimpiar.setBounds(247, 196, 85, 21);
		add(btnLimpiar);

		JLabel lblDni = new JLabel("DNI");
		lblDni.setHorizontalAlignment(SwingConstants.CENTER);
		lblDni.setBounds(0, 41, 213, 74);
		add(lblDni);

		tfDni = new JTextField();
		tfDni.setText("");
		tfDni.setEditable(true);
		tfDni.setColumns(10);
		tfDni.setBounds(181, 60, 213, 37);
		add(tfDni);
	}

	private void addListeners(CtrlEmpleado ctrlEmpleado) {

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfNombre.getText().length() > 0 && tfFechaNacimiento.getText().length() > 0
						&& tfSalario.getText().length() > 0 && ctrlError.controlFecha(tfFechaNacimiento.getText())
						&& ctrlError.controlSalario(Double.parseDouble(tfSalario.getText()))) {
					ctrlEmpleado.addEmpleado((new Empleado(tfNombre.getText(), tfDni.getText(),
							ctrlEmpleado.parseCadenatoFecha(tfFechaNacimiento.getText()),
							Double.parseDouble(tfSalario.getText()))));

					System.out.println(tfFechaNacimiento.getText());
					tfFechaNacimiento.setBackground(Color.WHITE);
					tfSalario.setBackground(Color.WHITE);
					tfNombre.setText("");
					tfFechaNacimiento.setText("");
					tfDni.setText("");
					tfSalario.setText("");
				
				} else {
					if (!ctrlError.controlFecha(tfFechaNacimiento.getText())) {
						tfFechaNacimiento.setBackground(Color.RED);
					}
					if (!ctrlError.controlSalario(Double.parseDouble(tfSalario.getText()))) {
						tfSalario.setBackground(Color.RED);
					}
				} 
				
			}
		});

		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfNombre.setText("");
				tfFechaNacimiento.setText("");
				tfDni.setText("");
				tfSalario.setText("");

				tfFechaNacimiento.setBackground(Color.WHITE);
				tfSalario.setBackground(Color.WHITE);
			}
		});

	}
}
