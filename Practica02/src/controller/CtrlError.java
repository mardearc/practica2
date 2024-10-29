package controller;

import java.util.Calendar;

import model.Empleado;

public class CtrlError {

	public CtrlError() {
		
	}
	
	public boolean controlFecha(Calendar fecha) {
		return fecha.get(Calendar.YEAR) < 2015 && fecha.get(Calendar.YEAR) > 1900 ? true : false;
	}

	public boolean controlSalario(Double salario) {
		return salario < Empleado.salMax ? true : false;
	}
}
