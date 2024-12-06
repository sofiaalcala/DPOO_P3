package Logica;

import java.util.ArrayList;

public class Respuestas {
	
	private Estudiante estudiante;
	private ArrayList<String> listaPreg;
	private ArrayList<String> listaResp;
	private int calificacion;
	private Actividad act;
	
	public Respuestas(Estudiante estudiante,  Actividad act) {
		this.estudiante = estudiante;
		this.act =act;
		listaResp = new ArrayList<String>();
		calificacion = 0;
		listaPreg = new ArrayList<String>();		
	}
	
	
	public void actualizarListaRes(String respuesta ) {
		listaResp.add(respuesta);
		return;
	}
	
	public void actualizarCalif(int cal) {
		calificacion = cal;
		return;
	}
	public Estudiante getEst() {
		return estudiante;
	}
	
	public Actividad getAct() {
		return act;
	}
	
	public ArrayList<String> getListaR(){
		return listaResp;
	}
	public void actualizarListaPreg(String preg ) {
		listaPreg.add(preg);
		return;
	}
	public ArrayList<String> getListaP(){
		return listaPreg;
	}
}
