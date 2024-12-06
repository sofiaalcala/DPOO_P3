package interfazGrafica;

import javax.swing.*;

import java.awt.*;

public class Grafica extends JFrame {

    private int[] contadores = {5, 4, 2, 5, 3, 2};
    private String[] actividades = {"Quiz", "QuizVoF", "Encuesta", "Tarea", "Examen", "Recurso"};

    public Grafica() {
        setTitle("Progreso Anual");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new PanelGrafica());
    }


    class PanelGrafica extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2d.setColor(Color.BLACK);
            int ancho = getWidth();
            int alto = getHeight();

            // eje X
            g2d.drawLine(50, alto - 50, ancho - 50, alto - 50);
            g2d.drawString("Tipos de Actividad", ancho / 2 - 50, alto - 10);

            // eje Y
            g2d.drawLine(50, 50, 50, alto - 50);
            g2d.drawString("Cantidad", 10, 30);


            int maxValor = 5; 
            int alturaEjeY = alto - 100; 
            int anchoBarra = (ancho - 100) / contadores.length; 
            for (int i = 0; i < contadores.length; i++) {
                int alturaBarra = (contadores[i] * alturaEjeY) / maxValor;
                int xBarra = 50 + (i * anchoBarra) + 10; 
                int yBarra = alto - 50 - alturaBarra;

                g2d.setColor(new Color(255, 0, 0)); 
                g2d.fillRect(xBarra, yBarra, anchoBarra - 20, alturaBarra);

                g2d.setColor(Color.BLACK);
                g2d.drawRect(xBarra, yBarra, anchoBarra - 20, alturaBarra);

                g2d.drawString(actividades[i], xBarra + (anchoBarra - 20) / 4, alto - 30);
                g2d.drawString(String.valueOf(contadores[i]), xBarra + (anchoBarra - 20) / 4, yBarra - 5);
            }


            g2d.setColor(Color.GRAY);
            for (int i = 1; i <= maxValor; i++) {
                int y = alto - 50 - (i * alturaEjeY) / maxValor;
                g2d.drawLine(45, y, 50, y); 
                g2d.drawString(String.valueOf(i), 25, y + 5);
            }
        }
    }

    public static void main(String[] args) {
		Grafica ventana = new Grafica();
		
		ventana.setVisible(true);
	}
}















