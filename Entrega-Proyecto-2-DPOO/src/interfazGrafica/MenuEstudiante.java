package interfazGrafica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class MenuEstudiante extends JFrame implements ActionListener{
	
	public JButton BInscribirLP;
	public JButton BCompletarLP;
	public JButton BRealizarActividad;
	public JButton BConsultarProgreso;
	
	public MenuEstudiante() {
		
		setTitle("Menu Estudiante");
		setLayout(null);
		setBounds(100, 100, 450, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		
		BInscribirLP = new JButton("Inscribir Learning Path");
		BInscribirLP.setBounds(120, 50, 200, 50);
		Color azulColumbia = new Color(197, 213, 234);
		BInscribirLP.setBackground(azulColumbia);
		
		BCompletarLP = new JButton("Completar Learning Path");
		BCompletarLP.setBounds(120, 110, 200, 50);
		BCompletarLP.setBackground(azulColumbia);
		
		BRealizarActividad = new JButton("Realizar actividad");
		BRealizarActividad.setBounds(120, 170, 200, 50);
		BRealizarActividad.setBackground(azulColumbia);
		
		BConsultarProgreso = new JButton("Consultar progreso anual");
		BConsultarProgreso.setBounds(120, 230, 200, 50);
		BConsultarProgreso.setBackground(azulColumbia);
		
		add(BInscribirLP);
		add(BCompletarLP);
		add(BRealizarActividad);
		add(BConsultarProgreso);
		
		
		BInscribirLP.addActionListener(this);
		BCompletarLP.addActionListener(this);
		BRealizarActividad.addActionListener(this);
		BConsultarProgreso.addActionListener(this);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BCompletarLP) {
			CompletarLP completar = new CompletarLP();
			completar.setLocationRelativeTo(null);
			completar.setVisible(true);
		} else if (e.getSource() == BInscribirLP){
			InscribirLP inscribir = new InscribirLP();
			inscribir.setLocationRelativeTo(null);
			inscribir.setVisible(true);
		}
		
	}
	

}
