package view;

import controller.BaseController;
import controller.ClienteController;
import controller.GerenteController;
import controller.PersonalController;
import javax.swing.JOptionPane;


 //Clase encargada de gestionar el menú Inicio Sesion y menu General y las acciones relacionadas con el restaurante.
public class MainView {
    public static void main(String[] args) {

        // Creación de controladores
        BaseController controller = new BaseController();
        ClienteController clienteController = new ClienteController(controller);
        PersonalController personalController = new PersonalController(controller);
        GerenteController gerenteController = new GerenteController(controller);
        
        // Configuración de controladores en BaseController
        controller.setGerenteController(gerenteController);
        controller.setClienteController(clienteController);
        controller.setPersonalController(personalController);
        
        // Bucle de la muestra del Menu Iniciar Sesion y menu Principal
        while (true) {
            try {
                int opcion = imprimirMenu();
                
                switch (opcion) {
                    case 1 -> controller.registro();  // Opción para registro
                    case 2 -> controller.iniciarSesion();  // Opción para iniciar sesión
                    case 3 -> {  // Opción para salir
                        controller.finalizarprograma();
                        JOptionPane.showMessageDialog(null, "El programa se ha cerrado exitosamente.");
                        return;  // Salir del bucle y terminar el programa
                    }
                    default -> JOptionPane.showMessageDialog(null, "INGRESE UNA OPCIÓN VÁLIDA", "MENSAJE DEL SISTEMA", JOptionPane.ERROR_MESSAGE);
                }
                // Captura de error al introducir un valor no numérico
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Por favor, ingrese un número entero válido.", "Error de entrada", JOptionPane.WARNING_MESSAGE);
                // Captura de cualquier otro error inesperado
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Muestra el menú principal y devuelve la opción seleccionada
    
    public static int imprimirMenu() {
        String menu = """
                ===Menu Principal===
                1. Registrarse
                2. Iniciar Sesión
                3. Salir
                """;
        // Solicitar opción al usuario y manejar posibles errores
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Menu", JOptionPane.INFORMATION_MESSAGE));
        return opcion;
    }
}
