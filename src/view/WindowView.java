package view;

import controller.Events;

import javax.swing.*;

/**
 *
 * @author JDFD
 */
@SuppressWarnings("serial")
public class WindowView extends JFrame {

    JLabel textoRegistro = new JLabel();
    JTextField cajaRegistro = new JTextField();

    JLabel textoDni = new JLabel();
    JTextField cajaDni = new JTextField();

    JLabel textoNombre = new JLabel();
    JTextField cajaNombre = new JTextField();

    JLabel textoApellido1 = new JLabel();
    JTextField cajaApellido1 = new JTextField();

    JLabel textoApellido2 = new JLabel();
    JTextField cajaApellido2 = new JTextField();

    JButton botonInsert = new JButton();
    JButton botonUpdate = new JButton();
    JButton botonDelete = new JButton();
    JButton botonSelectAll = new JButton();
    JButton botonSelectByRegistro = new JButton();
    
    JTextField[] cajas = {cajaRegistro, cajaDni, cajaNombre, 
    		cajaApellido1, cajaApellido2};
    JButton[] botones = {botonInsert, botonUpdate, botonDelete,
    		botonSelectAll, botonSelectByRegistro};

    
    

	public WindowView(Events events) {
        configuracionVentana();
        configuracionCampos();
        configuracionBotones();
        botonInsert.addActionListener(events);
        botonUpdate.addActionListener(events);
        botonDelete.addActionListener(events);
        botonSelectAll.addActionListener(events);
        botonSelectByRegistro.addActionListener(events);
        cajaRegistro.getDocument().addDocumentListener(events);
        cajaDni.getDocument().addDocumentListener(events);
        cajaNombre.getDocument().addDocumentListener(events);
        cajaApellido1.getDocument().addDocumentListener(events);
        cajaApellido2.getDocument().addDocumentListener(events);

    }

    private void configuracionVentana() {
        this.setTitle("Práctica DAD - Darse de Alta");
        this.setSize(380, 410);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
    }

    private void configuracionCampos(){
    	textoRegistro.setText("Registro: ");
        textoRegistro.setBounds(40, 20, 200, 30);
        cajaRegistro.setBounds(100, 20, 240, 30);

        textoDni.setText("Dni: ");
        textoDni.setBounds(40, 55, 200, 30);
        cajaDni.setBounds(100, 55, 240, 30);

        textoNombre.setText("Nombre: ");
        textoNombre.setBounds(40, 90, 200, 30);
        cajaNombre.setBounds(100, 90, 240, 30);

        textoApellido1.setText("Apellido1: ");
        textoApellido1.setBounds(40, 125, 200, 30);
        cajaApellido1.setBounds(100, 125, 240, 30);

        textoApellido2.setText("Apellido2: ");
        textoApellido2.setBounds(40, 160, 200, 30);
        cajaApellido2.setBounds(100, 160, 240, 30);
        
        this.add(textoRegistro);
        this.add(cajaRegistro);
        this.add(textoDni);
        this.add(cajaDni);
        this.add(textoNombre);
        this.add(cajaNombre);
        this.add(textoApellido1);
        this.add(cajaApellido1);
        this.add(textoApellido2);
        this.add(cajaApellido2);
    }
    
    private void configuracionBotones() {
    	botonInsert.setText("Añadir (Con todo)");
    	botonInsert.setBounds(40, 200, 300, 30);
    	botonInsert.setActionCommand("Insert");
    	botonInsert.setEnabled(false);

        botonUpdate.setText("Modificar (Con todo)");
        botonUpdate.setBounds(40, 235, 300, 30);
        botonUpdate.setActionCommand("Update");
        botonUpdate.setEnabled(false);
    	
        botonDelete.setText("Borrar (Con Registro)");
        botonDelete.setBounds(40, 270, 300, 30);
        botonDelete.setActionCommand("Delete");
        botonDelete.setEnabled(false);
        
        botonSelectAll.setText("Seleccionar todos (Por consola)");
        botonSelectAll.setBounds(40, 305, 300, 30);
        botonSelectAll.setActionCommand("SelectAll");
    	
        botonSelectByRegistro.setText("Seleccionar por registro (Con registro)");
        botonSelectByRegistro.setBounds(40, 340, 300, 30);
        botonSelectByRegistro.setActionCommand("SelectByRegistro");
        botonSelectByRegistro.setEnabled(false);

        this.add(botonUpdate);
        this.add(botonInsert);
        this.add(botonDelete);
        this.add(botonSelectAll);
        this.add(botonSelectByRegistro);
        
    }
    
    
	public JTextField getCajaRegistro() {
        return cajaRegistro;
    }

    public JTextField getCajaDni() {
        return cajaDni;
    }

    public JTextField getCajaNombre() {
        return cajaNombre;
    }

    public JTextField getCajaApellido1() {
        return cajaApellido1;
    }

    public JTextField getCajaApellido2() {
        return cajaApellido2;
    }
    public JTextField[] getCajas() {
		return cajas;
	}

	public void setCajas(JTextField[] cajas) {
		this.cajas = cajas;
	}

	public JButton[] getBotones() {
		return botones;
	}

	public void setBotones(JButton[] botones) {
		this.botones = botones;
	}

}
