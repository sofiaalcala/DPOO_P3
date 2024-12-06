package Logica;

import java.util.ArrayList;
import java.io.Serializable;

public class Estudiante extends Usuario{

	private ArrayList<LearningPath> listaLearningPathCompletados;
	private ArrayList<LearningPath> listaLearningPathInscritos;
	
	public Estudiante(String login, String password, String correo, String nombre, String apellido) {
		super(login, password, correo, nombre, apellido);
		this.listaLearningPathCompletados = new ArrayList<>();
		this.listaLearningPathInscritos = new ArrayList<>();
	}
	
		
	public ArrayList<LearningPath> getListaLearningPathCompletados() {
		return listaLearningPathCompletados;
	}


	public void setListaLearningPathCompletados(ArrayList<LearningPath> listaLearningPathCompletados) {
		this.listaLearningPathCompletados = listaLearningPathCompletados;
	}


	public ArrayList<LearningPath> getListaLearningPathInscritos() {
		return listaLearningPathInscritos;
	}


	public void setListaLearningPathInscritos(ArrayList<LearningPath> listaLearningPathInscritos) {
		this.listaLearningPathInscritos = listaLearningPathInscritos;
	}


	public boolean inscribirLP(LearningPath learningPath) {
		listaLearningPathInscritos.add(learningPath);
		if (listaLearningPathInscritos.contains(learningPath) == true){
			return true;
			}
		else { 
			return false;
			}
			
		
	}
	
	public ArrayList<LearningPath> inscribirLPLista(LearningPath learningPath) {
		listaLearningPathInscritos.add(learningPath);
		return listaLearningPathInscritos;
		}
	
	 public boolean completarLearningPath(LearningPath learningPath) {
		 if (learningPath.isCompletado()==true) {
			 listaLearningPathCompletados.add(learningPath);
			 listaLearningPathInscritos.remove(learningPath);
			 
	    }
		 if (listaLearningPathCompletados.contains(learningPath) == true){
				return true;
				}
			else { 
				return false;
				}
		 
		 }
	 }
	
	

