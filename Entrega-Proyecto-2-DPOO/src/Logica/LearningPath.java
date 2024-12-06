package Logica;

import java.util.ArrayList;
import java.io.Serializable;

public class LearningPath implements Serializable{

	private String titulo;
	private String fechaInicio;
	private String fechaFinal;
	private String nivelDificultad;
	private String duracionMinutos;
	private Actividad actividad;
	private ArrayList<Actividad> listaActividades;
	private ArrayList<Actividad> listaActividadesCompletadas;
	private String id;
	private boolean profesor;
	private boolean completado;
	private ArrayList<LearningPath> learningPathLista;
	public ArrayList<LearningPath> learningPathListaCompleta;
	
	public  LearningPath(String titulo,String fechaInicio, String fechaFinal, String nivelDificultad, String duracionMinutos, String id, boolean completado) { //Actividad actividad
		
		this.titulo = titulo;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.nivelDificultad = nivelDificultad;
		this.duracionMinutos = duracionMinutos;
		this.listaActividades = new ArrayList<>();
		this.id= id;
		this.completado = completado;
		this.listaActividadesCompletadas = new ArrayList<>();
		this.learningPathLista = new ArrayList<>();
		this.learningPathListaCompleta = new ArrayList<>();
	}
	
	
	
	public Actividad getActividad() {
		return actividad;
	}



	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}



	public boolean isProfesor() {
		return profesor;
	}


	public void setProfesor(boolean profesor) {
		this.profesor = profesor;
	}


	public boolean isCompletado() {
		return completado;
	}


	public void setCompletado(boolean completado) {
		this.completado = completado;
	}


	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getFechaInicio() {
		return fechaInicio;
	}



	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}



	public String getFechaFinal() {
		return fechaFinal;
	}



	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}



	public String getNivelDificultad() {
		return nivelDificultad;
	}



	public void setNivelDificultad(String nivelDificultad) {
		this.nivelDificultad = nivelDificultad;
	}



	public String getDuracionMinutos() {
		return duracionMinutos;
	}



	public void setDuracionMinutos(String duracionMinutos) {
		this.duracionMinutos = duracionMinutos;
	}


	///public Actividad getActividad() {
	///	return actividad;
	///}
	


	//public void setActividad(Actividad actividad) {
		//this.actividad = actividad;}



	public ArrayList<Actividad> getListaActividades() {
		return listaActividades;
	}



	public void setListaActividades(ArrayList<Actividad> listaActividades) {
		this.listaActividades = listaActividades;
	}

	
	

	public ArrayList<Actividad> getListaActividadesCompletadas() {
		return listaActividadesCompletadas;
	}


	public void setListaActividadesCompletadas(ArrayList<Actividad> listaActividadesCompletadas) {
		this.listaActividadesCompletadas = listaActividadesCompletadas;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public ArrayList<LearningPath> getLearningPathLista() {
		return learningPathLista;
	}



	public void setLearningPathLista(ArrayList<LearningPath> learningPathLista) {
		this.learningPathLista = learningPathLista;
	}



	public ArrayList<LearningPath> getLearningPathListaCompleta() {
		return learningPathListaCompleta;
	}



	public void setLearningPathListaCompleta(ArrayList<LearningPath> learningPathListaCompleta) {
		this.learningPathListaCompleta = learningPathListaCompleta;
	}



	public boolean addActividad(Actividad actividad) {
		this.listaActividades.add(actividad);
		if (listaActividades.contains(actividad) == true) {
			return true;
			
		}
		else {
			return false;
		}
	}
	
	public boolean eliminarActividad(Actividad actividad) {
		listaActividades.remove(actividad);
		if (listaActividades.contains(actividad) == false) {
			return true;
			
		}
		else {
			return false;
		}
	}

	public void addActividadCompletada(Actividad actividad) {
		if (actividad.actividadCompletada==true) {
			this.listaActividadesCompletadas.add(actividad);
		
		}
		
		
	}
	
	public boolean addLP(LearningPath learningPath) {
		learningPath.learningPathLista.add(learningPath);
		if (learningPath.learningPathLista.contains(learningPath) == true) {
			return true;
			
		}
		else {
			return false;
		}
	}
		
	public ArrayList<LearningPath> addLPLista(LearningPath learningPath) {
		learningPath.learningPathListaCompleta.add(learningPath);
		return learningPathListaCompleta;
	}
	
	public static void main (String[] args) {
		LearningPath lp = new LearningPath(null, null, null, null, null, null, false);
		LearningPath lp2 = new LearningPath(null, null, null, null, null, null, false);
		lp.learningPathListaCompleta.add(lp);
		lp.learningPathListaCompleta.add(lp2);
		System.out.println(lp.getLearningPathListaCompleta());
	}
	
}




	
	
			
