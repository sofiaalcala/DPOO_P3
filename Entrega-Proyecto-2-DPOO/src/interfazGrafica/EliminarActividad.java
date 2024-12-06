package interfazGrafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Logica.Actividad;
import Logica.LearningPath;
import Logica.*;


public class EliminarActividad extends JFrame implements ActionListener{
	
	private JPanel PEliminar;
	private JLabel LidLP;
	private JComboBox<Actividad> actividades;


	public static void main(String[] args) {
		
		EliminarActividad eliminar = new EliminarActividad();
		eliminar.setBounds(0, 0, 600, 600);
		eliminar.setDefaultCloseOperation(EXIT_ON_CLOSE);
		eliminar.setVisible(true);

	}


	public EliminarActividad() {
		
		
		Tarea tarea = new Tarea(null, null, null, false, null, null, null);
		Examen examen = new Examen(null, null, null, false, null, null, null);
		
		LearningPath lp = new LearningPath(null, null, null, null, null, null, false);
		lp.addActividad(tarea);
		lp.addActividad(examen);
		
		ArrayList<Actividad> listaActividades = lp.getListaActividades();
		
		setTitle("Eliminar Actividad");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 475);
		PEliminar = new JPanel();
		
		setContentPane(PEliminar);
		PEliminar.setLayout(null);
		Color aliciaAzul = new Color(216, 225, 233);
		PEliminar.setBackground(aliciaAzul);
		
		LidLP = new JLabel("Ingrese el id del Learning Path donde se encuentra la actividad:");
		LidLP.setFont(new Font("Tahoma", Font.BOLD, 14));
		LidLP.setBounds(41, 63, 442, 37);
		PEliminar.add(LidLP);
		
		actividades = new JComboBox<>(listaActividades.toArray(new Actividad[0]));
		actividades.setBounds(134, 100, 200, 90);
		actividades.addActionListener(this);
		PEliminar.add(actividades);

	}

	
	/////FALTA AGREGAR EL ACTION LISTENER DEL BOTON
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Actividad seleccionada = (Actividad) actividades.getSelectedItem();
		LearningPath otroLP = new LearningPath(null, null, null, null, null, null, false);
		
		boolean eliminado = otroLP.eliminarActividad(seleccionada);
		
		if (eliminado == true) {
			JOptionPane.showMessageDialog(this, "Actividad eliminada con éxito");
		}
		
		
	}

}
