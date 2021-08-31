package gui;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private static Student studentData;
	private JTextField textField_LU;
	private JTextField textField_Apellido;
	private JTextField textField_Nombre;
	private JTextField textField_Email;
	private JTextField textField_GitH;
	
	public SimplePresentationScreen(Student studentData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		SimplePresentationScreen.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(625, 250));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 187);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 205));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		tabInformation.setLayout(null);
		
		textField_LU = new JTextField();
		textField_LU.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField_LU.setBounds(88, 10, 327, 19);
		tabInformation.add(textField_LU);
		textField_LU.setColumns(10);
		textField_LU.setText(String.valueOf(studentData.getId()));
		
		textField_Apellido = new JTextField();
		textField_Apellido.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField_Apellido.setColumns(10);
		textField_Apellido.setBounds(88, 39, 327, 19);
		tabInformation.add(textField_Apellido);
		textField_Apellido.setText(studentData.getLastName());
		
		textField_Nombre = new JTextField();
		textField_Nombre.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField_Nombre.setColumns(10);
		textField_Nombre.setBounds(88, 68, 327, 19);
		tabInformation.add(textField_Nombre);
		textField_Nombre.setText(studentData.getFirstName());
		
		textField_Email = new JTextField();
		textField_Email.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField_Email.setColumns(10);
		textField_Email.setBounds(88, 97, 327, 19);
		tabInformation.add(textField_Email);
		textField_Email.setText(studentData.getMail());
		
		textField_GitH = new JTextField();
		textField_GitH.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField_GitH.setColumns(10);
		textField_GitH.setBounds(88, 126, 327, 19);
		tabInformation.add(textField_GitH);
		textField_GitH.setText(studentData.getGithubURL());
		
		JLabel lbl_LU = new JLabel("LU");
		lbl_LU.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_LU.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_LU.setBounds(10, 13, 45, 13);
		tabInformation.add(lbl_LU);
		
		JLabel lbl_Apellido = new JLabel("Apellido");
		lbl_Apellido.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_Apellido.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_Apellido.setBounds(10, 42, 56, 13);
		tabInformation.add(lbl_Apellido);
		
		JLabel lbl_Nombre = new JLabel("Nombre");
		lbl_Nombre.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_Nombre.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_Nombre.setBounds(10, 71, 56, 13);
		tabInformation.add(lbl_Nombre);
		
		JLabel lbl_Email = new JLabel("E-mail");
		lbl_Email.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_Email.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_Email.setBounds(10, 100, 56, 13);
		tabInformation.add(lbl_Email);
		
		JLabel lbl_GitHub = new JLabel("Github URL");
		lbl_GitHub.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_GitHub.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_GitHub.setBounds(10, 129, 68, 13);
		tabInformation.add(lbl_GitHub);
		contentPane.add(tabbedPane);
		
		JLabel lbl_img = new JLabel();
		lbl_img.setBounds(445, 29, 155, 156);
		ImageIcon foto = new ImageIcon(SimplePresentationScreen.class.getResource(studentData.getPathPhoto()));
		Icon foto1 = new ImageIcon(foto.getImage().getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(), Image.SCALE_DEFAULT));
		contentPane.add(lbl_img);
		lbl_img.setIcon(foto1);


		//Fecha
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss");
		

		JLabel footer_pantalla = new JLabel("Esta ventana fue generada el "+ dtf1.format(LocalDateTime.now()) + " a las: "+dtf2.format(LocalDateTime.now()));
		footer_pantalla.setBounds(5, 188, 420, 24);
		contentPane.add(footer_pantalla);
		footer_pantalla.setFont(new Font("SansSerif", Font.BOLD, 12));
		
	}
}
