package interfazGrafica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuProfesorEditor extends JFrame implements ActionListener{
	
	public JButton BcrearLP;
	public JButton BcrearActividad;
	public JButton BeliminarActividad;
	//public JButton Bcalificar;
	
	
	public MenuProfesorEditor() {
	
		
		setTitle("Menu Profesor Editor");
		setLayout(null);
		setBounds(100, 100, 400, 400);
		Color aliciaAzul = new Color(216, 225, 233);
		getContentPane().setBackground(aliciaAzul);
		//setBackground(aliciaAzul);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		BcrearLP = new JButton("Crear Learning Path");
		BcrearLP.setBounds(90, 50, 200, 80);
		Color azulColumbia = new Color(197, 213, 234);
		BcrearLP.setBackground(azulColumbia);
		BcrearLP.addActionListener(this);

		
		BcrearActividad = new JButton("Crear nueva actividad");
		BcrearActividad.setBounds(90, 150, 200, 80);
		BcrearActividad.setBackground(azulColumbia);
		BcrearActividad.addActionListener(this);
		
		BeliminarActividad = new JButton("Eliminar actividad");
		BeliminarActividad.setBounds(90, 250, 200, 80);
		BeliminarActividad.setBackground(azulColumbia);
		BeliminarActividad.addActionListener(this);
		
		
		
		//Bcalificar = new JButton("Crear Learning Path");
		//Bcalificar.setBounds(50, 250, 200, 80);
		//Bcalificar.setBackground(Color.GRAY);
		
		add(BcrearLP);
		add(BcrearActividad);
		add(BeliminarActividad);
		//add(Bcalificar);
		
				
		//Bcalificar.addActionListener(null);

		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == BcrearLP) {
			CrearLP nuevoLP = new CrearLP();
			//nuevoLP.setBounds(100, 100, 600, 600);
			nuevoLP.setLocationRelativeTo(null);
			//nuevoLP.setDefaultCloseOperation(EXIT_ON_CLOSE);
			nuevoLP.setVisible(true);
		}else if (e.getSource() == BcrearActividad) {
			CrearNuevaActividad nuevaActividad = new CrearNuevaActividad();
			nuevaActividad.setLocationRelativeTo(null);
			nuevaActividad.setVisible(true);
		}else if (e.getSource() == BeliminarActividad) {
			EliminarActividad eliminarActividad = new EliminarActividad();
			eliminarActividad.setLocationRelativeTo(null);
			eliminarActividad.setVisible(true);
		}
	}
	
	

}
