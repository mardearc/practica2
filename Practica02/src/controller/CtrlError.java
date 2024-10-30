package controller;

import model.Empleado;

public class CtrlError {

	public CtrlError() {

	}

	public boolean controlFecha(String fecha) {

		int fechaNumero = Integer.parseInt((fecha).substring(fecha.length() - 4));

		return (fechaNumero <= 2015 && fechaNumero >= 1900) ? true : false;
	}

	public boolean controlSalario(Double salario) {
		return salario < Empleado.salMax ? true : false;
	}

	public boolean esDouble(String cadena) {
		try {
			Double.parseDouble(cadena);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
