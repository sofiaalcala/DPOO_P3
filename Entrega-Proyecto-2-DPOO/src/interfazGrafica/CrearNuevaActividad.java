package interfazGrafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Logica.Actividad;
import Logica.LearningPath;
import Logica.Tarea;
import Logica.*;


public class CrearNuevaActividad extends JFrame{
	
	
	private JPanel PActividadNueva;
	private JLabel LidLP;
	private JTextField txtIDLP;
	private JLabel LTipoActividad;
	private JTextField txtTipoActividad;
	private JLabel LidActividad;
	private JTextField txtIdActividad;
	private JLabel LfechaLimite;
	private JTextField txtFechaLimite;
	private JLabel LnivelDificultad;
	private JTextField txtNivelDificultad;
	private JLabel LduracionEsperada;
	private JTextField txtDuracion;
	private JCheckBox chkCompletada;
	


	public static void main(String[] args) {
		CrearNuevaActividad actividad = new CrearNuevaActividad();
		actividad.setBounds(0, 0, 600, 600);
		actividad.setDefaultCloseOperation(EXIT_ON_CLOSE);
		actividad.setVisible(true);
	}


	public CrearNuevaActividad() {
	
		setTitle("Crear nueva actividad");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 475);
		PActividadNueva = new JPanel();
		//PActividadNueva.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(PActividadNueva);
		PActividadNueva.setLayout(null);
		Color aliciaAzul = new Color(216, 225, 233);
		PActividadNueva.setBackground(aliciaAzul);
		
		LidLP = new JLabel("Ingrese el id del Learning Path: ");
		LidLP.setFont(new Font("Tahoma", Font.BOLD, 14));
		LidLP.setBounds(31, 36, 221, 32);
		PActividadNueva.add(LidLP);
		
		LTipoActividad = new JLabel("Ingrese el tipo de actividad:");
		LTipoActividad.setFont(new Font("Tahoma", Font.BOLD, 14));
		LTipoActividad.setBounds(31, 145, 197, 31);
		PActividadNueva.add(LTipoActividad);
		
		LidActividad = new JLabel("Ingrese el id de la actividad:");
		LidActividad.setFont(new Font("Tahoma", Font.BOLD, 14));
		LidActividad.setBounds(31, 256, 197, 31);
		PActividadNueva.add(LidActividad);
		
		txtIDLP = new JTextField();
		txtIDLP.setBounds(41, 84, 173, 31);
		PActividadNueva.add(txtIDLP);
		txtIDLP.setColumns(10);
		
		txtTipoActividad = new JTextField();
		txtTipoActividad.setColumns(10);
		txtTipoActividad.setBounds(41, 187, 173, 31);
		PActividadNueva.add(txtTipoActividad);
		
		txtIdActividad = new JTextField();
		txtIdActividad.setColumns(10);
		txtIdActividad.setBounds(41, 307, 173, 31);
		PActividadNueva.add(txtIdActividad);
		
		LfechaLimite = new JLabel("Ingrese la fecha límite :");
		LfechaLimite.setFont(new Font("Tahoma", Font.BOLD, 14));
		LfechaLimite.setBounds(350, 36, 230, 31);
		PActividadNueva.add(LfechaLimite);
		
		txtFechaLimite = new JTextField();
		txtFechaLimite.setBounds(356, 84, 173, 31);
		PActividadNueva.add(txtFechaLimite);
		txtFechaLimite.setColumns(10);
		
		LnivelDificultad = new JLabel("Nivel dificultad:");
		LnivelDificultad.setFont(new Font("Tahoma", Font.BOLD, 14));
		LnivelDificultad.setBounds(349, 145, 197, 31);
		PActividadNueva.add(LnivelDificultad);
		
		txtNivelDificultad = new JTextField();
		txtNivelDificultad.setBounds(356, 192, 173, 31);
		PActividadNueva.add(txtNivelDificultad);
		txtNivelDificultad.setColumns(10);
		
		LduracionEsperada = new JLabel("Duración esperada:");
		LduracionEsperada.setFont(new Font("Tahoma", Font.BOLD, 14));
		LduracionEsperada.setBounds(349, 266, 197, 31);
		PActividadNueva.add(LduracionEsperada);
		
		txtDuracion = new JTextField();
		txtDuracion.setBounds(356, 312, 173, 31);
		PActividadNueva.add(txtDuracion);
		txtDuracion.setColumns(10);
		
		chkCompletada = new JCheckBox("Completada");
		chkCompletada.setBounds(57, 417, 128, 23);
		PActividadNueva.add(chkCompletada);
		
		JButton BCrear = new JButton("Crear");
		BCrear.setFont(new Font("Tahoma", Font.BOLD, 16));
		BCrear.setBounds(236, 379, 89, 23);
		PActividadNueva.add(BCrear);
		
		//BCrear.addActionListener(this);
		BCrear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				llamarLogica();
			}
		});
	}
	
	
	
	public void llamarLogica() {
		
		String fechaLimite = LfechaLimite.getText();
		String nivelDificultad = LnivelDificultad.getText();
		String duracionEsperada = LduracionEsperada.getText();
		boolean actividadCompleta = chkCompletada.isSelected();
		String idActividad = LidActividad.getText();
		String tipoActividad = LTipoActividad.getText();
		String idLearningPath = LidLP.getText();
		
		//Actividad logica = new Actividad(fechaLimite, nivelDificultad, duracionEsperada, actividadCompleta, idActividad, tipoActividad, idLearningPath);
		LearningPath lp = new LearningPath(null, null, null, null, null, idLearningPath, false);
		
		if (tipoActividad == "Tarea") {
			Tarea tarea = new Tarea(fechaLimite, nivelDificultad, duracionEsperada, actividadCompleta, idActividad, tipoActividad, idLearningPath);
			boolean creada = tarea.crearActividad(tipoActividad, tarea, lp, idLearningPath, idActividad);
			if (creada == true) {
				JOptionPane.showMessageDialog(this, "Actividad creada con éxito");
			} else {
				JOptionPane.showMessageDialog(this, "No se pudo crear la actividad", idActividad, JOptionPane.ERROR_MESSAGE);;
			}
		}
		
		else if (tipoActividad == "Encuesta") {
			Encuesta encuesta = new Encuesta(fechaLimite, nivelDificultad, duracionEsperada, actividadCompleta, idActividad, tipoActividad, idLearningPath);
			boolean creada = encuesta.crearActividad(tipoActividad, encuesta, lp, idLearningPath, idActividad);
			if (creada == true) {
				JOptionPane.showMessageDialog(this, "Actividad creada con éxito");
			} else {
				JOptionPane.showMessageDialog(this, "No se pudo crear la actividad", idActividad, JOptionPane.ERROR_MESSAGE);;
			}
		}
		
		else if (tipoActividad == "Examen") {
			Examen examen = new Examen(fechaLimite, nivelDificultad, duracionEsperada, actividadCompleta, idActividad, tipoActividad, idLearningPath);
			boolean creada = examen.crearActividad(tipoActividad, examen, lp, idLearningPath, idActividad);
			if (creada == true) {
				JOptionPane.showMessageDialog(this, "Actividad creada con éxito");
			} else {
				JOptionPane.showMessageDialog(this, "No se pudo crear la actividad", idActividad, JOptionPane.ERROR_MESSAGE);;
			}
		}
		
		else if (tipoActividad == "Quiz") {
			Quiz quiz = new Quiz(fechaLimite, nivelDificultad, duracionEsperada, actividadCompleta, idActividad, tipoActividad, idLearningPath);
			boolean creada = quiz.crearActividad(tipoActividad, quiz, lp, idLearningPath, idActividad);
			if (creada == true) {
				JOptionPane.showMessageDialog(this, "Actividad creada con éxito");
			} else {
				JOptionPane.showMessageDialog(this, "No se pudo crear la actividad", idActividad, JOptionPane.ERROR_MESSAGE);;
			}
		}
		
		else if (tipoActividad == "Quiz verdadero o falso") {
			QuizVoF quizVoF = new QuizVoF(fechaLimite, nivelDificultad, duracionEsperada, actividadCompleta, idActividad, tipoActividad, idLearningPath);
			boolean creada = quizVoF.crearActividad(tipoActividad, quizVoF, lp, idLearningPath, idActividad);
			if (creada == true) {
				JOptionPane.showMessageDialog(this, "Actividad creada con éxito");
			} else {
				JOptionPane.showMessageDialog(this, "No se pudo crear la actividad", idActividad, JOptionPane.ERROR_MESSAGE);;
			}
		}
		
		else {
			RecursoEducativo recurso = new RecursoEducativo(fechaLimite, nivelDificultad, duracionEsperada, actividadCompleta, idActividad, tipoActividad, idLearningPath);
			boolean creada = recurso.crearActividad(tipoActividad, recurso, lp, idLearningPath, idActividad);
			if (creada == true) {
				JOptionPane.showMessageDialog(this, "Actividad creada con éxito");
			} else {
				JOptionPane.showMessageDialog(this, "No se pudo crear la actividad", idActividad, JOptionPane.ERROR_MESSAGE);;
			}
		}
		

	
	}


}
