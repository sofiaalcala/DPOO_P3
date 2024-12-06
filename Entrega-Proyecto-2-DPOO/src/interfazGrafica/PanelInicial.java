package interfazGrafica;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;


import interfazGrafica.MenuProfesorEditor;
import interfazGrafica.MenuEstudiante;


import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelInicial extends JFrame implements ActionListener{
	
	private JPanel panelSesion;
	private JLabel LTipoUsuario;
	private JTextField txtxTipoUsuario;
	private JLabel LUsuario;
	private JTextField txtUsuario;
	private JLabel LContraseña;
	private JTextField txtContraseña;
	private JButton BIniciarSesion;
	private JButton BCerrarSesion;
	
	
	public PanelInicial() {
        setLayout(null);
		
		panelSesion = new JPanel();
		panelSesion.setBounds(145, 11, 307, 520);
		Color azulPalido = new Color(179, 197, 215);
		panelSesion.setBackground(azulPalido);
		add(panelSesion);
		panelSesion.setLayout(null);
		
		LTipoUsuario = new JLabel("Tipo Usuario: ");
		LTipoUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		LTipoUsuario.setBounds(99, 50, 114, 19);
		panelSesion.add(LTipoUsuario);
		
		txtxTipoUsuario = new JTextField();
		txtxTipoUsuario.setBounds(82, 80, 155, 32);
		panelSesion.add(txtxTipoUsuario);
		txtxTipoUsuario.setColumns(10);
		
		LUsuario = new JLabel("Usuario: ");
		LUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		LUsuario.setBounds(99, 150, 114, 19);
		panelSesion.add(LUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(82, 180, 155, 32);
		panelSesion.add(txtUsuario);
		
		LContraseña = new JLabel("Contraseña: ");
		LContraseña.setFont(new Font("Tahoma", Font.BOLD, 14));
		LContraseña.setBounds(99, 250, 114, 19);
		panelSesion.add(LContraseña);
		
		txtContraseña = new JTextField();
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(82, 280, 155, 32);
		panelSesion.add(txtContraseña);
		
		BIniciarSesion = new JButton("Iniciar Sesión");
		BIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 15));
		BIniciarSesion.setBounds(89, 384, 146, 45);
		panelSesion.add(BIniciarSesion);
		
		BCerrarSesion = new JButton("Cerrar Sesión");
		BCerrarSesion.setFont(new Font("Tahoma", Font.BOLD, 15));
		BCerrarSesion.setBounds(89, 456, 146, 45);
		panelSesion.add(BCerrarSesion);
		
		BIniciarSesion.addActionListener(this);
		BCerrarSesion.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BIniciarSesion) {
			String tipoUsuario = txtxTipoUsuario.getText();
			String usuario = txtUsuario.getText();
			String password = txtContraseña.getText();
			
			if (tipoUsuario.equals("Profesor")) {
				if (!usuario.isEmpty() && !password.isEmpty()) {
					MenuProfesorEditor menuProfe = new MenuProfesorEditor();
					menuProfe.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(this, "Ingrese un usuario y/o contraseña para continuar");
				}
				
			}
			else if (tipoUsuario.equals("Estudiante")){
				if (!usuario.isEmpty() && !password.isEmpty()) {
					MenuEstudiante menuEst = new MenuEstudiante();
					menuEst.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(this, "Ingrese un usuario y/o contraseña para continuar");
				}
			}
			
			else {
				JOptionPane.showMessageDialog(this, "Ingrese un tipo de usuario válido", tipoUsuario, JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == BCerrarSesion){
			JOptionPane.showMessageDialog(this, "Sesión cerrada con éxito");
		}
	}
	
	public static void main(String[] args) {
		PanelInicial Pinicial = new PanelInicial();
		Pinicial.setSize(600, 600);
		Pinicial.setLocationRelativeTo(null);
		Pinicial.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Pinicial.setVisible(true);
	}	
		
	
	

}
