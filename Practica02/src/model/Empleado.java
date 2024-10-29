package model;

import java.util.GregorianCalendar;

public class Empleado {
	private static int numEmple;
    private String nombre;
    private String dni;
    private GregorianCalendar fechaNacimiento;
    private double salario;
    private double salMax;
   

    // Constructor
    public Empleado(String nombre, String dni, GregorianCalendar fechaNacimiento, double salario ) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.salario = salario;
        numEmple++;
        this.salMax = 10000;
        this.dni = dni;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public GregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

	public int getNumEmple() {
		return numEmple;
	}

	public double getSalMax() {
		return salMax;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", salario=" + salario + "]";
	}
	
	
    
    
}
