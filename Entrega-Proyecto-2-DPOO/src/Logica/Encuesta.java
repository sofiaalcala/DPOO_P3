package Logica;

import java.util.ArrayList;

public class Encuesta extends Actividad{

	private String fechaLimite;
	private String nivelDificultad;
	private String duracionEsperada;
	private boolean actividadCompletada;
	private String idActividad;
	private String tipoActividad;
	private String idLP;
	
	
	
	public Encuesta(String fechaLimite, String nivelDificultad, String duracionEsperada, boolean actividadCompletada, String idActividad, String tipoActividad, String idLP) {
		super(fechaLimite, nivelDificultad, duracionEsperada, actividadCompletada, idActividad, tipoActividad, idLP);

		this.fechaLimite = fechaLimite;
		this.nivelDificultad = nivelDificultad;
		this.duracionEsperada = duracionEsperada;
		todasActividades = new ArrayList<>();
		this.actividadCompletada = actividadCompletada;
		this.tipoActividad = tipoActividad;
		this.idLP = idLP;

	}



	public String getFechaLimite() {
		return fechaLimite;
	}



	public void setFechaLimite(String fechaLimite) {
		this.fechaLimite = fechaLimite;
	}



	public String getNivelDificultad() {
		return nivelDificultad;
	}



	public void setNivelDificultad(String nivelDificultad) {
		this.nivelDificultad = nivelDificultad;
	}



	public String getDuracionEsperada() {
		return duracionEsperada;
	}



	public void setDuracionEsperada(String duracionEsperada) {
		this.duracionEsperada = duracionEsperada;
	}



	public boolean isActividadCompletada() {
		return actividadCompletada;
	}



	public void setActividadCompletada(boolean actividadCompletada) {
		this.actividadCompletada = actividadCompletada;
	}



	public String getIdActividad() {
		return idActividad;
	}



	public void setIdActividad(String idActividad) {
		this.idActividad = idActividad;
	}



	public String getTipoActividad() {
		return tipoActividad;
	}



	public void setTipoActividad(String tipoActividad) {
		this.tipoActividad = tipoActividad;
	}



	public String getIdLP() {
		return idLP;
	}



	public void setIdLP(String idLP) {
		this.idLP = idLP;
	}
	
	public boolean crearActividad( Encuesta encuesta, LearningPath learningPath, String idLP, String idActividad) {
		this.todasActividades.add(encuesta);
			if(learningPath.getId()==idLP) {
				learningPath.addActividad(encuesta);
				
			
		}
		ArrayList<Actividad> respuesta = learningPath.getListaActividades();
		
		if (respuesta.contains(encuesta) == true) {
			return true;
			
		}
		else {
			return false;
		}}
}
