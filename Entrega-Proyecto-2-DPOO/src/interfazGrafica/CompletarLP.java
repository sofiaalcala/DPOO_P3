package interfazGrafica;

import java.awt.Color;
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

import Logica.LearningPath;
import Logica.Estudiante;
import interfazGrafica.CrearLP;


public class CompletarLP extends JFrame implements ActionListener{
	
	
	private JPanel PCompletarLP;
	private JLabel LidLP;
	private JTextField txtidLP;
	private JButton BGuardar;
	private JComboBox<LearningPath> LPcompletados;
	private LearningPath learningPath;
	private JCheckBox completado;


	public static void main(String[] args) {
		
		CompletarLP completar = new CompletarLP();
		completar.setBounds(0, 0, 600, 600);
		completar.setDefaultCloseOperation(EXIT_ON_CLOSE);
		completar.setVisible(true);

	}


	public CompletarLP() {
		
		LearningPath lp = new LearningPath(null, null, null, null, null, null, false);
		LearningPath lp2 = new LearningPath(null, null, null, null, null, null, false);
		Estudiante estudiante = new Estudiante(null, null, null, null, null);
		//lp.learningPathListaCompleta.add(lp);
		//lp.learningPathListaCompleta.add(lp2);
		estudiante.inscribirLPLista(lp);
		estudiante.inscribirLPLista(lp2);
		
		
		ArrayList<LearningPath> learningPaths = estudiante.getListaLearningPathInscritos();
	
		setTitle("Completar Learning Path");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 449);
		PCompletarLP = new JPanel();
		PCompletarLP.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(PCompletarLP);
		PCompletarLP.setLayout(null);
		Color aliciaAzul = new Color(216, 225, 233);
		PCompletarLP.setBackground(aliciaAzul);
		
		
		LidLP = new JLabel("Seleccione el Learning Path:");
		LidLP.setFont(new Font("Tahoma", Font.BOLD, 14));
		LidLP.setBounds(135, 50, 232, 25);
		PCompletarLP.add(LidLP);
		
		LPcompletados = new JComboBox<>(learningPaths.toArray(new LearningPath[0]));
		LPcompletados.setBounds(134, 100, 200, 90);
		LPcompletados.addActionListener(this);
		PCompletarLP.add(LPcompletados);
		
		completado = new JCheckBox("Completado");
		completado.setFont(new Font("Tahoma", Font.BOLD, 13));
		completado.setBounds(134, 200, 118, 23);
		actualizarEstado();
		PCompletarLP.add(completado);
		
		BGuardar = new JButton("Guardar");
		BGuardar.setFont(new Font("Tahoma", Font.BOLD, 16));
		BGuardar.setBounds(134, 250, 100, 80);
		BGuardar.addActionListener(this);
		PCompletarLP.add(BGuardar);
		

	}


	private void actualizarEstado() {
		LearningPath lpCompletado = (LearningPath) LPcompletados.getSelectedItem();
		if (lpCompletado != null) {
			completado.setSelected(lpCompletado.isCompletado());
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == LPcompletados){
			actualizarEstado();
		} else if (e.getSource() == BGuardar) {
			LearningPath lpCompletado = (LearningPath) LPcompletados.getSelectedItem();
			
			if (lpCompletado != null) {
				lpCompletado.setCompletado(completado.isSelected());
				JOptionPane.showMessageDialog(this, "Selección guardada correctamente");
			}
		}
		
	}

	
}



