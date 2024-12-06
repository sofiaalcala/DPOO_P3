package Logica;

import java.util.ArrayList;

public class Profesor extends Usuario {

	private ArrayList<LearningPath> listaLearningPath;
	private ArrayList<Actividad> listaActividadesCreadas;
	//private Estudiante estudiante;
	
	public Profesor(String login, String password, String correo, String nombre, String apellido) {
		super(login, password, correo, nombre, apellido);
		this.listaLearningPath = new ArrayList<>();
		this.listaActividadesCreadas = new ArrayList<>();
	}
		
	public boolean addLP(LearningPath learningPath) {
		listaLearningPath.add(learningPath);
		if (listaLearningPath.contains(learningPath) == true) {
			return true;
			
		}
		else {
			return false;
		}
		}
	
	public void addActividadCreada(Actividad actividad) {
		listaActividadesCreadas.add(actividad);
		}
	
	public void calificarEstudiante(Estudiante estudiante) {
		; //Se tomará en cuenta mas adelante
	}
	
	
}
