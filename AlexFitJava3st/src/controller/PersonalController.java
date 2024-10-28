package controller;

import javax.swing.JOptionPane;
import model.ReservacionesModel;

//Clase encargado de gestionar el menú y las acciones relacionadas con el personal del restaurante.

public class PersonalController {

    // Referencia al controlador base para acceder a funcionalidades compartidas
    private BaseController baseController;

    /**
     * Constructor de la clase PersonalController.
     * @param baseController Controlador base para acceder al modelo de reservaciones.
     */
    public PersonalController(BaseController baseController) {
        this.baseController = baseController;
    }

    /**
     * Obtiene el modelo de reservaciones a través del controlador base.
     * @return ReservacionesModel El modelo de reservaciones.
     */
    private ReservacionesModel getModeloReservacion() {
        return baseController.getModeloReservacion();
    }

    //Muestra el menú de opciones para el personal y gestiona las acciones seleccionadas.

    public void menuPersonal() {
        // Solicita al usuario que seleccione una opción en el menú
        int option = Integer.parseInt(JOptionPane.showInputDialog(null, """
        Bienvenido al Menu del Servicio del personal
        1. Capacitacion de aprendizaje
        2. Diagnostico
        3. Salir
        Digite el numero correspondiente a la accion que desea realizar (1-3):"""));

        // Gestiona la acción seleccionada en función de la opción elegida
        switch (option) {
            case 1 -> capacitacioAprendizaje();
            case 2 -> servicio_personal();
            case 3 -> { JOptionPane.showMessageDialog(null, "Muchas Gracias, VUELVA PRONTO");
            return;
        } default -> JOptionPane.showMessageDialog(null, "La Contraseña es incorrecta...");
        }
    }

    //Metodos que solicita una contraseña y valida para  acceder al menú del personal.

    public void LoginInformacion() {
        String contraseña = JOptionPane.showInputDialog(null, "Ingrese Contraseña para acceder al Menu del Personal");

        // Valida la contraseña ingresada
        if ("personalonly".equals(contraseña)) {
            menuPersonal(); // Acceso autorizado al menú personal
        } else {
            JOptionPane.showMessageDialog(null, "Contraseña Incorrecta\n");
        }
    }

    
    //Muestra el menú de diagnóstico del personal y retorna las respuestas según el cargo seleccionado.
    
    private void servicio_personal() {
        // Solicita al usuario que seleccione un cargo para el diagnóstico
        int cargo = Integer.parseInt(JOptionPane.showInputDialog(null, """
        Escoja el Cargo para realizar el diagnostico:
        1. Vigilante
        2. Mesero
        3. Cocinero
        4. Cajero
        ¿Cuál es el número correspondiente al cargo (1-4):
        """));

        // Gestion de la respuesta según el cargo seleccionado
        switch (cargo) {
            case 1 -> {
                String respuesta_vigilante = JOptionPane.showInputDialog(null, "¿Cuál es la regla cuarentena de seguridad implementada en la inducción?: ");
                getModeloReservacion().setRespuesta_vigilante(respuesta_vigilante);
                JOptionPane.showMessageDialog(null, "SE HAN ENVIADO SU RESPUESTA");
            }
            case 2 -> {
                String respuesta_mesero = JOptionPane.showInputDialog(null, "¿Cómo realizar el proceso para llevar un plato a una mesa?: ");
                getModeloReservacion().setRespuesta_mesero(respuesta_mesero);
                String nombre_mesero = JOptionPane.showInputDialog(null, "¿Cuál fue el mesero que realizó la encuesta?: ");
                getModeloReservacion().setNombre_mesero(nombre_mesero);
                JOptionPane.showMessageDialog(null, "SE HAN ENVIADO SU RESPUESTA");
            }
            case 3 -> {
                String respuesta_cocinero = JOptionPane.showInputDialog(null, "¿Cómo son las medidas de bioseguridad?: ");
                getModeloReservacion().setRespuesta_cocinero(respuesta_cocinero);
                JOptionPane.showMessageDialog(null, "SE HAN ENVIADO SU RESPUESTA");
            }
            case 4 -> {
                String respuesta_cajero = JOptionPane.showInputDialog(null, "¿Cómo se hace para abrir la caja registradora?: ");
                getModeloReservacion().setRespuesta_cajero(respuesta_cajero);
                JOptionPane.showMessageDialog(null, "SE HAN ENVIADO SU RESPUESTA");
            }
            default -> JOptionPane.showMessageDialog(null, "Error: Ingresó un código incorrecto.");
        }
    }

    
      //Muestra el menú de capacitación según el cargo seleccionado.
    
    public void capacitacioAprendizaje() {
        // Solicita al usuario que seleccione un cargo para la capacitación
        int cargo = Integer.parseInt(JOptionPane.showInputDialog(null, """
        Escoja el cargo para realizar la Capacitacion :
        1. Vigilante
        2. Mesero
        3. Cocinero
        4. Cajero
        Ingrese el numero correspondiente al cargo: """));

        // Llama al método de capacitación correspondiente según el cargo
        switch (cargo) {
            case 1 -> vigilante_capacitacion();
            case 2 -> mesero_capacitacion();
            case 3 -> cocinero_capacitacion();
            case 4 -> cajero_capacitacion();
            default -> JOptionPane.showMessageDialog(null, "Error Ingreso el codigo incorrecto");
        }
    }


    //Metodo que Muestra el menú del restaurante y gestiona las opciones seleccionadas.

    


    public static void vigilante_capacitacion() {

        JOptionPane.showMessageDialog(null, """
                
        Vigilante:
        Presentación de la empresa: Introduce la historia, valores y misión de la empresa.
        Roles y responsabilidades: Explica las funciones específicas del vigilante, incluyendo seguridad, monitoreo de cámaras, control de accesos, y protocolos de emergencia.
        Procedimientos de seguridad: Detalla los protocolos de seguridad, manejo de situaciones de emergencia, procedimientos de evacuación y manejo de equipos de seguridad.
        Normativas internas: Informa sobre políticas de la empresa, reglamentos internos y procedimientos para reportar incidentes.
        """);
    }

    public static void mesero_capacitacion() {
        JOptionPane.showMessageDialog(null, """

            Mesero:
            Conocimiento del restaurante: Presenta el restaurante, su historia, menú, filosofía de servicio y público objetivo.
            Roles y responsabilidades: Describe las tareas del mesero, incluyendo atención al cliente, toma de pedidos, manejo de bandejas, servicio de alimentos y bebidas, y procedimientos de limpieza.
            Entrenamiento en servicio al cliente: Enseña técnicas de atención al cliente, manejo de situaciones difíciles, y cómo garantizar una experiencia positiva para los comensales.
            Normativas de higiene y seguridad: Detalla las regulaciones de seguridad alimentaria, normas de higiene, manejo de alimentos y procedimientos de limpieza""");
    }

    public static void cocinero_capacitacion() {
        JOptionPane.showMessageDialog(null, """

            Cajero:
            Presentación del área: Introduce el área de caja, sistemas de pago, y procedimientos de facturación.
            Roles y responsabilidades: Describe las funciones del cajero, incluyendo manejo de efectivo, cobro a clientes, cierre y apertura de caja, y registro de transacciones.
            Manejo de sistemas y tecnología: Entrena en el uso de sistemas de punto de venta (POS), manejo de tarjetas de crédito/débito, y procesos de devolución y cambios.
            Políticas financieras: Informa sobre políticas de devolución, descuentos, manejo de errores y procedimientos para evitar fraudes.  
        """);
    }

    public static void cajero_capacitacion() {
        JOptionPane.showMessageDialog(null, """

            Cocinero:
            Introducción a la cocina: Presenta la cocina, sus áreas, equipos, y cómo se organiza el trabajo.
            Roles y responsabilidades: Explica las responsabilidades del cocinero, desde la preparación de ingredientes hasta la elaboración de platos, siguiendo recetas y estándares de calidad.
            Higiene y seguridad alimentaria: Enseña normativas de manipulación de alimentos, procedimientos de limpieza, seguridad en el manejo de equipos y protocolos de emergencia en la cocina.
            Conocimiento de menú y calidad: Introduce el menú, la presentación de platos y la importancia de mantener altos estándares de calidad en la cocina.   
        """);
    }
}
