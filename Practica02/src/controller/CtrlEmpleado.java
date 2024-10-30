package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import model.Empleado;

public class CtrlEmpleado {

	private static List<Empleado> listado = new ArrayList<>();
	private static int index;

	public CtrlEmpleado() {
		index = 0;

		listado.add(new Empleado("Emanuel E.", "12131415K", parseCadenatoFecha("05-04-2005"), 9999.99));
		listado.add(new Empleado("Paula S.", "21222324J", parseCadenatoFecha("16-06-2003"), 9999.99));
		listado.add(new Empleado("Jesús M.", "31323334L", parseCadenatoFecha("05-12-2001"), 5656.99));
		listado.add(new Empleado("Jesús R.", "41424344P", parseCadenatoFecha("25-05-2003"), 2345.99));
		listado.add(new Empleado("Abel G.", "51525354G", parseCadenatoFecha("26-10-2002"), 1847.99));

	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void addEmpleado(Empleado c) {
		listado.add(c);

	}

	public List<Empleado> getListadoEmpleado() {
		return listado;
	}

	// MÉTODO PARA COMPROBAR SI HAY UN SIGUIENTE EMPLEADO
	public boolean siguienteEmpleado() {
		boolean haySiguienteEmpleado = false;

		// SI AL SUMARLE UNO AL ÍNDICE SIGUE SIENDO MENOR QUE EL TAMAÑO DE LA LISTA
		// SIGNIFICA QUE PUEDES AVANZAR
		if (index + 1 < listado.size()) {
			index++;
			haySiguienteEmpleado = true;
		}

		return haySiguienteEmpleado;

	}

	// MÉTODO PARA COMPROBAR SI HAY UN ANTERIOR EMPLEADO
	public boolean anteriorEmpleado() {
		boolean hayAnteriorEmpleado = false;

		// MIENTRAS EL ÍNDICE RESTÁNDOLE UNO SEA MAYOR O IGUAL QUE CERO SIGNIFICA QUE
		// AÚN HAY VALORES QUE PODER RECORRER HACIA ATRÁS
		if (index - 1 >= 0) {
			index--;
			hayAnteriorEmpleado = true;
		}

		return hayAnteriorEmpleado;

	}

	// MÉTODO PARA SELECCIONAR EL PRIMER EMPLEADO
	public void primerEmpleado() {
		setIndex(0);
	}

	// MÉTODO PARA SELECCIONAR EL PRIMER EMPLEADO
	public void ultimoEmpleado() {
		
		setIndex(listado.size() - 1);
	}

	public GregorianCalendar parseCadenatoFecha(String dateStr) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		GregorianCalendar calendar = new GregorianCalendar();

		
		try {
			Date date = dateFormat.parse(dateStr);
			calendar.setTime(date);
		} catch (ParseException e) {
			System.out.println("Formato de fecha incorrecto. Debe ser dd-MM-yyyy.");
			e.printStackTrace();
		}

		return calendar;
	}

	public String parseFechatoCadena(GregorianCalendar calendar) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		return dateFormat.format(calendar.getTime());
	}
}