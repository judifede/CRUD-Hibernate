package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.hibernate.ObjectNotFoundException;

import model.Alumnos;
import model.AlumnosConsultas;
import view.WindowView;

/**
 *
 * @author JDFD
 */
public class Events implements ActionListener, DocumentListener {

	JTextField[] cajas;
	JButton[] botones;
	WindowView windowView = new WindowView(this);

	AlumnosConsultas consultas = new AlumnosConsultas();
	Alumnos alumno;
	int registroAlumno;
	String nombreAlumno;

	public Events() {
		windowView.setVisible(true);
		cajas = windowView.getCajas();
		botones = windowView.getBotones();
	}

	public void gestionBotones() {
		for (int j = 0; j < botones.length; j++) {
			botones[j].setVisible(false);
		}
	}

	public void construirAlumno() {
		try {
			alumno = new Alumnos();
			registroAlumno = Integer.parseInt(windowView.getCajaRegistro()
					.getText().trim());
			alumno.setRegistro(registroAlumno);
			alumno.setDni(windowView.getCajaDni().getText().trim());
			alumno.setNombre(windowView.getCajaNombre().getText().trim());
			alumno.setApellido1(windowView.getCajaApellido1().getText().trim());
			alumno.setApellido2(windowView.getCajaApellido2().getText().trim());
		} catch (NumberFormatException numberFormatexc) {

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		construirAlumno();
		switch (e.getActionCommand()) {
		case "Insert":
			consultas.insertAlumno(alumno);
			System.out.println(alumno.getNombre() + " se ha añadido");
			break;
		case "Update":
			consultas.updateAlumno(alumno);
			System.out.println("El alumno con registro " + alumno.getRegistro()
					+ " se ha modificado");
			break;
		case "Delete":
			consultas.deleteAlumno(registroAlumno);
			break;
		case "SelectAll":
			for (Alumnos alumno : consultas.getAllAlumnos()) {
				System.out.println(alumno.getNombre());
			}
			break;
		case "SelectByRegistro":
			try{
				System.out.println(consultas.getAlumnoByRegistro(registroAlumno).getNombre());
			}catch (NullPointerException ex){
				System.out.println("registro no encontrado");
			}
			break;
		default:
			break;
		}

	}

	public int recorrerCajas() {
		int numeroCajasVacias = 0;
		for (int i = 0; i < cajas.length; i++) {
			if (cajas[i].getText().trim().equals("")) {
				numeroCajasVacias++;
			} else {
				numeroCajasVacias = 0;
			}
		}
		return numeroCajasVacias;
	}

	public void manejarBotones() {
		int numeroCajasVacias = recorrerCajas();

		if (numeroCajasVacias > 0) {
			for (int j = 0; j < botones.length; j++) {
				botones[j].setEnabled(false);
			}
		} else {
			for (int j = 0; j < botones.length; j++) {
				botones[j].setEnabled(true);
			}
		}
		if (!cajas[0].getText().trim().equals("")) {
			botones[2].setEnabled(true);
			botones[4].setEnabled(true);
		}
		botones[3].setEnabled(true);
		numeroCajasVacias = 0;
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		manejarBotones();
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		manejarBotones();
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		manejarBotones();
	}

}
