package interfazGrafica;

import java.awt.Color;
import java.awt.EventQueue;

import Logica.LearningPath;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import Logica.Estudiante;

public class InscribirLP extends JFrame implements ActionListener{
	
	private JPanel PInscribirLP;
	private JLabel LidLP;
	
	private JComboBox<LearningPath> LPInscritos;
	private LearningPath learningPath;
	


	public static void main(String[] args) {
		
		CompletarLP completar = new CompletarLP();
		completar.setBounds(0, 0, 600, 600);
		completar.setDefaultCloseOperation(EXIT_ON_CLOSE);
		completar.setVisible(true);

	}


	public InscribirLP() {

		
		LearningPath lp = new LearningPath(null, null, null, null, null, null, false);
		LearningPath lp2 = new LearningPath(null, null, null, null, null, null, false);
		lp.learningPathListaCompleta.add(lp);
		lp.learningPathListaCompleta.add(lp2);
		
		ArrayList<LearningPath> learningPaths = lp.getLearningPathListaCompleta();
	
		setTitle("Inscribir Learning Path");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 449);
		PInscribirLP = new JPanel();
		PInscribirLP.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(PInscribirLP);
		PInscribirLP.setLayout(null);
		Color aliciaAzul = new Color(216, 225, 233);
		PInscribirLP.setBackground(aliciaAzul);
		
		
		LidLP = new JLabel("Seleccione el Learing Path:");
		LidLP.setFont(new Font("Tahoma", Font.BOLD, 14));
		LidLP.setBounds(135, 50, 232, 25);
		PInscribirLP.add(LidLP);
		
		LPInscritos = new JComboBox<>(learningPaths.toArray(new LearningPath[0]));
		LPInscritos.setBounds(134, 100, 200, 90);
		LPInscritos.addActionListener(this);
		PInscribirLP.add(LPInscritos);
		

	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		LearningPath seleccionado =  (LearningPath) LPInscritos.getSelectedItem();
		ArrayList<LearningPath> listaLPcompletados = new ArrayList<>();
		ArrayList<LearningPath> listaLPinscritos = new ArrayList<>();
		Estudiante estudiante = new Estudiante(null, null, null, null, null);
		
		
		boolean creado =estudiante.inscribirLP(seleccionado);
		

		if (creado == true) {
			JOptionPane.showMessageDialog(this, "Learning Path inscrito con éxito");
		}
		


}}
