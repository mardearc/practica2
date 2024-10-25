package controller;

import java.util.ArrayList;
import java.util.List;

import model.Empleado;

public class CtrlEmpleado {


  private static List<Empleado> listado = new ArrayList<>();
  private static int index;

  public CtrlEmpleado() {
	  index = 0;
	  
	  listado.add(new Empleado("Emanuel E.", "05-04-2005", 9999.99));
	  listado.add(new Empleado("Paula S.", "16-06-2003", 9999.99));
	  listado.add(new Empleado("Jesús M.", "05-12-2001", 5656.99));
	  listado.add(new Empleado("Jesús R.", "25-05-2003", 2345.99));
	  listado.add(new Empleado("Abel G.", "26-10-2002", 1847.99));
	  
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
	  
	  // SI AL SUMARLE UNO AL ÍNDICE SIGUE SIENDO MENOR QUE EL TAMAÑO DE LA LISTA SIGNIFICA QUE PUEDES AVANZAR
	  if(index + 1 < listado.size()) {
		  index++;
		  haySiguienteEmpleado = true;
	  }
	  
	return haySiguienteEmpleado;
	  
  }
  
  // MÉTODO PARA COMPROBAR SI HAY UN ANTERIOR EMPLEADO
  public boolean anteriorEmpleado() {
	  boolean hayAnteriorEmpleado = false;
	  
	// MIENTRAS EL ÍNDICE RESTÁNDOLE UNO SEA MAYOR O IGUAL QUE CERO SIGNIFICA QUE AÚN HAY VALORES QUE PODER RECORRER HACIA ATRÁS
	  if(index - 1 >= 0) {
		  index--;
		  hayAnteriorEmpleado = true;
	  }
	  
	return hayAnteriorEmpleado;
	  
  }

}