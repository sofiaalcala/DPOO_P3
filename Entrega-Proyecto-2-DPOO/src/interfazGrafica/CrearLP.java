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

public class CrearLP extends JFrame{
	
	private JPanel PCrearLP;
	private JLabel LTitulo;
	private JTextField txtTitulo;
	private JLabel LFechaInicio;
	private JTextField txtFechaInicio;
	private JLabel LFechaFinal;
	private JTextField txtFechaFinal;
	private JLabel LCompletado;
	private JCheckBox chkCompletado;
	private JLabel LDuracion;
	private JTextField txtDuracion;
	private JLabel LNivelDificultad;
	private JTextField txtNivelDificultad;
	private JLabel Lid;
	private JTextField txtId;
	private JButton BCrear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		CrearLP crearLP = new CrearLP();
		crearLP.setBounds(0, 0, 600, 600);
		//Pinicial.setLocation(null);
		crearLP.setDefaultCloseOperation(EXIT_ON_CLOSE);
		crearLP.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
		public CrearLP() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 620);
		PCrearLP = new JPanel();
		PCrearLP.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(PCrearLP);
		PCrearLP.setLayout(null);
		Color aliciaAzul = new Color(216, 225, 233);
		PCrearLP.setBackground(aliciaAzul);
		
		LTitulo = new JLabel("Ingrese el título:");
		LTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		LTitulo.setBounds(31, 40, 129, 29);
		PCrearLP.add(LTitulo);
		
		LFechaInicio = new JLabel("Fecha de inicio:");
		LFechaInicio.setFont(new Font("Tahoma", Font.BOLD, 14));
		LFechaInicio.setBounds(31, 149, 129, 29);
		PCrearLP.add(LFechaInicio);
		
		LFechaFinal = new JLabel("Fecha de final:");
		LFechaFinal.setFont(new Font("Tahoma", Font.BOLD, 14));
		LFechaFinal.setBounds(31, 262, 129, 29);
		PCrearLP.add(LFechaFinal);
		
		LDuracion = new JLabel("Duración en minutos:");
		LDuracion.setFont(new Font("Tahoma", Font.BOLD, 14));
		LDuracion.setBounds(324, 40, 149, 29);
		PCrearLP.add(LDuracion);
		
		LNivelDificultad = new JLabel("Nivel de dificultad:");
		LNivelDificultad.setFont(new Font("Tahoma", Font.BOLD, 14));
		LNivelDificultad.setBounds(324, 149, 149, 29);
		PCrearLP.add(LNivelDificultad);
		
		Lid = new JLabel("id:");
		Lid.setFont(new Font("Tahoma", Font.BOLD, 14));
		Lid.setBounds(324, 262, 149, 29);
		PCrearLP.add(Lid);
		
		LCompletado = new JLabel("Completado:");
		LCompletado.setFont(new Font("Tahoma", Font.BOLD, 14));
		LCompletado.setBounds(31, 393, 149, 29);
		PCrearLP.add(LCompletado);
		
		BCrear = new JButton("Crear");
		BCrear.setFont(new Font("Tahoma", Font.BOLD, 16));
		BCrear.setBounds(360, 431, 113, 38);
		PCrearLP.add(BCrear);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(37, 80, 196, 35);
		PCrearLP.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtFechaInicio = new JTextField();
		txtFechaInicio.setColumns(10);
		txtFechaInicio.setBounds(31, 189, 196, 35);
		PCrearLP.add(txtFechaInicio);
		
		txtFechaFinal = new JTextField();
		txtFechaFinal.setColumns(10);
		txtFechaFinal.setBounds(31, 318, 196, 35);
		PCrearLP.add(txtFechaFinal);
		
		txtDuracion = new JTextField();
		txtDuracion.setColumns(10);
		txtDuracion.setBounds(324, 80, 196, 35);
		PCrearLP.add(txtDuracion);
		
		txtNivelDificultad = new JTextField();
		txtNivelDificultad.setColumns(10);
		txtNivelDificultad.setBounds(324, 189, 196, 35);
		PCrearLP.add(txtNivelDificultad);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(324, 318, 196, 35);
		PCrearLP.add(txtId);
		
		chkCompletado = new JCheckBox("");
		chkCompletado.setBounds(31, 431, 51, 29);
		PCrearLP.add(chkCompletado);
		
		BCrear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				llamarLogica();
			}
		});
	}
	
	public void llamarLogica() {
		String titulo = LTitulo.getText();
		String fechaInicio = LFechaInicio.getText();
		String fechaFinal = LFechaFinal.getText();
		String duracionMinutos = LDuracion.getText();
		String nivelDificultad = LNivelDificultad.getText();
		String id = Lid.getText();
		boolean completado = chkCompletado.isSelected();
		
		//Se crea el Learning Path
		LearningPath logica = new LearningPath(titulo, fechaInicio, fechaFinal, nivelDificultad, duracionMinutos, id, completado);
		ArrayList<LearningPath> lista = logica.addLPLista(logica);
		boolean creado = logica.addLP(logica);
		
		if (creado == true) {
			JOptionPane.showMessageDialog(this, "Learning Path creado con éxito");
		} else {
			JOptionPane.showMessageDialog(this, "No se pudo crear el Learning Path", id, JOptionPane.ERROR_MESSAGE);;
		}
	}

}
