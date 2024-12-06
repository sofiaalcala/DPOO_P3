package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import Logica.Respuestas;
import Logica.LearningPath;
import Logica.Tarea;
import Logica.Quiz;
import Logica.Actividad;
import Logica.Estudiante;

public class realizarTarea extends JFrame implements ActionListener{
	
	private JList<String> listaActividad;
    private JTextArea areaRespuesta;
    private JButton subirBoton;
    private boolean subido = false;
    private static String SUBIR = "subir";
    private static String SELEC = "selec";
    
    private ArrayList<Actividad> actividades;
    private LearningPath lp = new LearningPath("lp2", "01/01/2024", "24/12/2025", "8", "100", "01", false);
    private Tarea tarea1 = new Tarea("06/06/2025", "6", "5 semanas", false, "011", "Tarea", "01");
    private Tarea tarea2 = new Tarea("01/01/2025", "4", "2 semanas", false, "012", "Tarea", "01");
    private Quiz quiz1 = new Quiz("02/03/2025", "8", "2 horas", false, "013", "Quiz", "01");
    private Estudiante est = new Estudiante("est1", "clave", "correo@direccion", "Mario", "Laserna");
    private Respuestas resp1;
    private Respuestas resp2;
    private Respuestas resp3;
    
    public realizarTarea(){
    	
    	resp1 = new Respuestas(est, tarea1);
    	resp2 = new Respuestas(est, tarea2);
    	resp3 = new Respuestas(est, quiz1);
    	
    	resp1.actualizarListaPreg("1. Cual es el sentido de la vida?    ->");
    	resp1.actualizarListaPreg(" ");
    	resp1.actualizarListaPreg("2. Alguna vez has pensado...?    ->");
    	
    	resp2.actualizarListaPreg("1. Cuanto es 2 +2?           ->");
    	resp2.actualizarListaPreg(" ");
    	resp2.actualizarListaPreg("2. Encuentre la derivada de cos(x)           ->");
    	resp2.actualizarListaPreg(" ");
    	resp2.actualizarListaPreg("3. Que tanto te gusta el algebra lineal?         ->");
    	
    	resp3.actualizarListaPreg("1. Para donde va la gravedad?         ->");
    	resp3.actualizarListaPreg(" ");
    	resp3.actualizarListaPreg("2. The mitochondria is the powerhouse of the cell?        ->");
    	resp3.actualizarListaPreg(" ");
    	resp3.actualizarListaPreg("3. El neutron es neutro?        ->");
    	resp3.actualizarListaPreg(" ");
    	resp3.actualizarListaPreg("4. Vf = _ + _ * t?        ->");


    	lp.addActividad(tarea1);
    	lp.addActividad(tarea2);
    	lp.addActividad(quiz1);
    	est.inscribirLP(lp);
    	
    	
    	setLayout(new BorderLayout());
    	setTitle("Menu Hacer Actividad");
		setBounds(145, 11, 900, 520);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		DefaultListModel<String> modeloListaAct = new DefaultListModel<>();
		modeloListaAct.add(0, "Tarea 1");
		modeloListaAct.add(1, "Tarea 2");
		modeloListaAct.add(2, "Quiz 1");
		
		listaActividad = new JList<String>(modeloListaAct);
		listaActividad.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaActividad.addListSelectionListener(e -> seleccionada());
		
		JScrollPane listaScroller = new JScrollPane(listaActividad);
		listaScroller.setPreferredSize(new Dimension(250, 80));
		add(listaScroller, BorderLayout.WEST);
		
		areaRespuesta = new JTextArea();
		areaRespuesta.setEditable(true);
		JScrollPane respuestaScroller = new JScrollPane(areaRespuesta);
		add(respuestaScroller, BorderLayout.CENTER);
		
		subirBoton = new JButton("Subir");
		subirBoton.setActionCommand(SUBIR);
		subirBoton.addActionListener(this);
		add(subirBoton, BorderLayout.SOUTH);
		setVisible(true);

    }
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals(SUBIR)) {
			if(subido) {
				JOptionPane.showMessageDialog(this, "Se esta procesando su anterior respuesta");
				return;
			}
			String[] respuestas = areaRespuesta.getText().split("\n");
			String seleccionadoNombre = listaActividad.getSelectedValue();
			
			 if ("Tarea 1".equals(seleccionadoNombre)) {
		            
		            ArrayList<String> listaRespuestas = resp1.getListaR();
		            for (int i = 0; i < respuestas.length && i < resp1.getListaP().size(); i++) {
		                listaRespuestas.add(respuestas[i]); 
		            }
		        } else if ("Tarea 2".equals(seleccionadoNombre)) {
		           
		            ArrayList<String> listaRespuestas = resp2.getListaR();
		            for (int i = 0; i < respuestas.length && i < resp2.getListaP().size(); i++) {
		                listaRespuestas.add(respuestas[i]);
		            }
		        } else if ("Quiz 1".equals(seleccionadoNombre)) {
		            ArrayList<String> listaRespuestas = resp3.getListaR();
		            for (int i = 0; i < respuestas.length && i < resp3.getListaP().size(); i++) {
		                listaRespuestas.add(respuestas[i]); 
		            }
		        }
		        subido = true;
		        JOptionPane.showMessageDialog(this, "Subido con éxito");
				
			}
		}
	
	
	private void seleccionada() {
		String seleccionadoNombre = listaActividad.getSelectedValue();
		if("Tarea 1".equals(seleccionadoNombre)) {
			StringBuilder textoPregunta= new StringBuilder();
			for(String preg : resp1.getListaP()) {
				textoPregunta.append(preg).append("\n");
			}
			areaRespuesta.setText(textoPregunta.toString());
		} else if("Tarea 2".equals(seleccionadoNombre)) {
			StringBuilder textoPregunta= new StringBuilder();
			for(String preg : resp2.getListaP()) {
				textoPregunta.append(preg).append("\n");
			}
			areaRespuesta.setText(textoPregunta.toString());
		}else if("Quiz 1".equals(seleccionadoNombre)) {
			StringBuilder textoPregunta= new StringBuilder();
			for(String preg : resp3.getListaP()) {
				textoPregunta.append(preg).append("\n");
			}
			areaRespuesta.setText(textoPregunta.toString());
		}
	}

}
