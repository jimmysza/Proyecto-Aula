package controller;

import java.util.InputMismatchException;

import javax.swing.JOptionPane;
import model.ReservacionesModel;


public class BaseController {
    private ReservacionesModel modeloReservacion;
    private ClienteController clienteController;
    private PersonalController personalController;
    private GerenteController gerenteController;

    public BaseController() {
        modeloReservacion = new ReservacionesModel();
    }

    public ReservacionesModel getModeloReservacion() {
        return modeloReservacion;
    }

    public void setClienteController(ClienteController clienteController) {
        this.clienteController = clienteController;
    }

    public void setPersonalController(PersonalController personalController) {
        this.personalController = personalController;
    }

    public void setGerenteController(GerenteController gerenteController) {
        this.gerenteController = gerenteController;
    }
    
    public GerenteController getGerenteController() {
        return gerenteController;
    }

    public void iniciarSesion(){
        String usuario = JOptionPane.showInputDialog(null, "Ingrese su Usuario: ");
        String contraseña = JOptionPane.showInputDialog(null, "Ingrese su Contraseña: ");

        if (usuario.equals(modeloReservacion.getUsuario()) && contraseña.equals(modeloReservacion.getContraseña())) {
            menuPrincipal();
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrectas\n");
        }
    }

    public void menuPrincipal() {
        while (true) {
            try {
                int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                    1. Menu Cliente
                    2. Menu Personal
                    3. Menu Gerente
                    4. Salir
                    Ingrese una opcion del (1-4): """));

                switch (opcion) {
                    case 1 -> clienteController.menuCLiente();
                    case 2 -> personalController.LoginInformacion();
                    case 3 -> gerenteController.LoginInformacionGerente();
                    case 4 -> {
                        JOptionPane.showMessageDialog(null, "Muchas Gracias, Vuelva Pronto"); System.exit(0);
                    }
                        default -> JOptionPane.showMessageDialog(null, "ERROR, LA OPCION INGRESADA NO EXISTE");
                }
            } catch (InputMismatchException e) {
                JOptionPane.showMessageDialog(null, "Error: Por favor, ingrese un número entero válido.\n");
            }
        }
    }
    

    public void finalizarprograma(){
        JOptionPane.showMessageDialog(null, "Muchas Gracias, Vuelva Pronto");
    }

    public void registro(){
        String usuario = JOptionPane.showInputDialog(null, "Cree un Usuario: ");
        String contraseña = JOptionPane.showInputDialog(null, "Cree una Contraseña: ");

        modeloReservacion.setUsuario(usuario);
        modeloReservacion.setContraseña(contraseña);
    }

    

}
