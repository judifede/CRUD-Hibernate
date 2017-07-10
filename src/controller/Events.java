package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Alumnos;
import model.AlumnosConsultas;
import view.WindowView;

/**
 *
 * @author JDFD
 */
public class Events implements ActionListener {

	WindowView windowView = new WindowView(this);
	AlumnosConsultas consultas = new AlumnosConsultas();
	Alumnos alumno;
	int registroAlumno;
	String nombreAlumno;

    public Events() {
    	windowView.setVisible(true);
    }
    
    public void construirAlumno() {
        alumno = new Alumnos();
        registroAlumno = Integer.parseInt(windowView.getCajaRegistro().getText().trim());
        alumno.setRegistro(registroAlumno);
        alumno.setDni(windowView.getCajaDni().getText());
        alumno.setNombre(windowView.getCajaNombre().getText());
        alumno.setApellido1(windowView.getCajaApellido1().getText());
        alumno.setApellido2(windowView.getCajaApellido2().getText());
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
			System.out.println("El alumno con registro " + alumno.getRegistro() + " se ha modificado");
			break;
		
		case "Delete":
			consultas.deleteAlumno(registroAlumno);
			System.out.println(alumno.getNombre() + " se ha borrado");
			break;
			
		case "SelectAll":
			for (Alumnos alumno : consultas.getAllAlumnos()) {
				System.out.println(alumno.getNombre());
			}
			break;
			
		case "SelectByRegistro":
			System.out.println(consultas.getAlumnoByRegistro(registroAlumno).getNombre());
			break;

		default:
			break;
		}

    }

}
