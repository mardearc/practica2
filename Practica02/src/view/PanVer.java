package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanVer extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNombre;
	private JTextField tfFechaNacimiento;
	private JTextField tfSalario;

	/**
	 * Create the panel.
	 */
	public PanVer() {
		setLayout(null);
		
		tfFechaNacimiento = new JTextField();
		tfFechaNacimiento.setBounds(181, 85, 213, 37);
		tfFechaNacimiento.setText("05-04-2005");
		tfFechaNacimiento.setEditable(false);
		tfFechaNacimiento.setColumns(10);
		add(tfFechaNacimiento);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setBounds(0, 66, 213, 74);
		lblFechaNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblFechaNacimiento);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(181, 19, 213, 37);
		tfNombre.setText("Emanuel E.");
		tfNombre.setEditable(false);
		tfNombre.setColumns(10);
		add(tfNombre);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(0, 0, 213, 74);
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNombre);
		
		JLabel lblSalario = new JLabel("Salario");
		lblSalario.setBounds(0, 130, 213, 74);
		lblSalario.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblSalario);
		
		tfSalario = new JTextField();
		tfSalario.setBounds(181, 149, 213, 37);
		tfSalario.setText("9999.99");
		tfSalario.setEditable(false);
		tfSalario.setColumns(10);
		add(tfSalario);
		
		JButton btnPrimero = new JButton("Primero");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPrimero.setBounds(30, 196, 85, 21);
		add(btnPrimero);
		
		JButton btnAvanzar = new JButton("Avanzar");
		btnAvanzar.setBounds(125, 197, 85, 21);
		add(btnAvanzar);
		
		JButton btnRetroceder = new JButton("Retroceder");
		btnRetroceder.setBounds(220, 197, 127, 21);
		add(btnRetroceder);
		
		JButton btnUltimo = new JButton("Último");
		btnUltimo.setBounds(357, 196, 85, 21);
		add(btnUltimo);
		

	}
}
