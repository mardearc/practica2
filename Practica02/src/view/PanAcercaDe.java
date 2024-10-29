package view;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Font;

public class PanAcercaDe extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanAcercaDe() {
		setLayout(new BorderLayout(0, 0));
		
		JTextPane txtpnJe = new JTextPane();
		txtpnJe.setText("Autores: Emanuel Esteban Fernández Trejos, Jesús Martín de Arcos y Jesús Recacha Freire \n"
				+ "\nLa aplicación consta de un menu con 3 opciones: Ver, Alta y Acerca De. \n"
				+ "   Ver: Abre un panel con los empleados disponibles \n"
				+ "   Alta: Abre un panel con la opción de cargar un nuevo empleado\n"
				+ "   AcercaDe: Abre un panel informativo con las funcionalidades de la aplicación");
		txtpnJe.setFont(new Font("Microsoft Tai Le", Font.ITALIC, 12));
		add(txtpnJe, BorderLayout.CENTER);

	}

}
