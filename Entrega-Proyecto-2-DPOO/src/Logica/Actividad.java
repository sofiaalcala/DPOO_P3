package Logica;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Actividad implements Serializable{

	protected String descripcion;
	protected String objetivo;
	protected String nivelDificultad;
	protected String duracionEsperada;
	protected String fechaLimite;
	protected ArrayList<Actividad> listaActividadPrevia;
	protected boolean actividadCompletada;
	protected boolean profesor;
	protected LearningPath learningPath;
	protected String tipoActividad;
	protected String idLP;
	protected ArrayList<Actividad> todasActividades;
	protected ArrayList<Actividad> actividadesCompletadas;
	protected String idActividad;
	

	
	
	public Actividad(String fechaLimite, String nivelDificultad, String duracionEsperada, boolean actividadCompletada, String idActividad, String tipoActividad, String idLP) {
		this.descripcion = descripcion;
		this.objetivo = objetivo;
		this.fechaLimite = fechaLimite;
		this.nivelDificultad = nivelDificultad;
		this.duracionEsperada = duracionEsperada;
		listaActividadPrevia = new ArrayList<>();
		this.actividadCompletada = actividadCompletada;
		this.profesor = profesor;
		this.tipoActividad = tipoActividad;
		this.idLP = idLP;
		this.todasActividades = todasActividades;
		this.actividadesCompletadas = actividadesCompletadas;
		this.idActividad = idActividad;
		}

	
	
	public ArrayList<Actividad> getTodasActividades() {
		return todasActividades;
	}



	public void setTodasActividades(ArrayList<Actividad> todasActividades) {
		this.todasActividades = todasActividades;
	}



	public ArrayList<Actividad> getActividadesCompletadas() {
		return actividadesCompletadas;
	}



	public void setActividadesCompletadas(ArrayList<Actividad> actividadesCompletadas) {
		this.actividadesCompletadas = actividadesCompletadas;
	}



	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getObjetivo() {
		return objetivo;
	}


	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
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


	public String getFechaLimite() {
		return fechaLimite;
	}


	public void setFechaLimite(String fechaLimite) {
		this.fechaLimite = fechaLimite;
	}


	public ArrayList<Actividad> getListaActividadPrevia() {
		return listaActividadPrevia;
	}


	public void setListaActividadPrevia(ArrayList<Actividad> listaActividadPrevia) {
		this.listaActividadPrevia = listaActividadPrevia;
	}


	public boolean isActividadCompletada() {
		return actividadCompletada;
	}


	public void setActividadCompletada(boolean actividadCompletada) {
		this.actividadCompletada = actividadCompletada;
	}
	
	
	public boolean isProfesor() {
		return profesor;
	}


	public void setProfesor(boolean profesor) {
		this.profesor = profesor;
	}

	

	public LearningPath getLearningPath() {
		return learningPath;
	}


	public void setLearningPath(LearningPath learningPath) {
		this.learningPath = learningPath;
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
	

	public String getIdActividad() {
		return idActividad;
	}



	public void setIdActividad(String idActividad) {
		this.idActividad = idActividad;
	}



	public boolean crearActividad(String tipoActividad, Actividad actividad, LearningPath learningPath, String idLP, String idActividad) {
		this.todasActividades.add(actividad);
			if(learningPath.getId()==idLP) {
				learningPath.addActividad(actividad);
				
			
		}
		ArrayList<Actividad> respuesta = learningPath.getListaActividades();
		
		if (respuesta.contains(actividad) == true) {
			return true;
			
		}
		else {
			return false;
		}}

	public void addActividadCompletada(Actividad actividad, ArrayList<Actividad> todasActividades) {
		for (int i = 0; i < this.todasActividades.size(); i++) {
			Actividad actividadC  = this.todasActividades.get(i);
			if (actividadC.isActividadCompletada()==true) {
				this.actividadesCompletadas.add(actividadC);
			}
		
		}
	}
	
	public ArrayList<Integer> contadorActividades(ArrayList<Actividad> listaActividadesCompletadas) {
		
		int contadorQuiz = 0;
		int contadorQuizVoF = 0;
		int contadorTarea = 0;
		int contadorEncuesta = 0;
		int contadorRecurso = 0;
		int contadorExamen = 0;
		ArrayList<Integer> contadores = new ArrayList<>();

		
		for (int i = 0; i < this.actividadesCompletadas.size(); i++) {
			Actividad actividad = this.actividadesCompletadas.get(i);
			if (actividad.getTipoActividad()=="Quiz") {
				contadorQuiz+=1;
			} else if (actividad.getTipoActividad()=="QuizVoF") {
				contadorQuizVoF+=1; 
			}else if (actividad.getTipoActividad()=="Tarea") {
				contadorTarea+=1;  
			} else if (actividad.getTipoActividad()=="Encuesta") {
				contadorEncuesta+=1; 
			} else if (actividad.getTipoActividad()=="Recurso") {
				contadorRecurso+=1; 
			} else if (actividad.getTipoActividad()=="Examen") {
				contadorExamen+=1;
		contadores.add(contadorQuiz);
		contadores.add(contadorQuizVoF);
		contadores.add(contadorTarea);
		contadores.add(contadorEncuesta);
		contadores.add(contadorRecurso);
		contadores.add(contadorExamen);
		}
		}
		return contadores;
		}}





