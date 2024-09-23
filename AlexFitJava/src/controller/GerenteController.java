package controller;

import javax.swing.JOptionPane;
import model.ReservacionesModel;

public class GerenteController {

    private BaseController baseController;

    public GerenteController(BaseController baseController) {
        this.baseController = baseController;
    }

    private ReservacionesModel getModeloReservacion() {
        return baseController.getModeloReservacion();
    }

    //Metodos que solicita una contraseña y valida para  acceder al menú del Gerente.
    
    public void LoginInformacionGerente() {
        String contraseña = JOptionPane.showInputDialog(null, "Ingrese Contraseña para acceder al Menu del Gerente");

        if ("gerenteonly".equals(contraseña)) {
            menuGerente();
        } else {
            JOptionPane.showMessageDialog(null, "Contraseña Incorrecta\n");
        }
    }

    public void menuGerente() {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(null, """
                        1. Disponibilidad de Mesas
                        2. Usuarios Registrados
                        3. Visualizar Reseñas
                        4. Salir
                        Ingrese una opción (1-4):""");

                int opcion = Integer.parseInt(input);

                switch (opcion) {
                    case 1 ->
                        mostrarDatos();
                    case 2 ->
                        getUsuariosRegistrados();
                    case 3 ->
                        muestra_informacion();
                    case 4 -> {
                        JOptionPane.showMessageDialog(null, "Muchas Gracias, VUELVA PRONTO");
                        return;
                    }
                    default ->
                        JOptionPane.showMessageDialog(null, "ERROR, LA OPCION INGRESADA NO EXISTE");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Por favor, ingrese un número entero válido.\n");
            }
        }
    }

    public void mostrarDatos() {
        JOptionPane.showMessageDialog(null, "====MENU INFORMACION====");
        JOptionPane.showMessageDialog(null, "Mesas Disponibles: " + getModeloReservacion().getNumeroTotalMesasDisponibles());
        JOptionPane.showMessageDialog(null, "Mesas Reservadas: " + getModeloReservacion().getMesasReservadas());
        JOptionPane.showMessageDialog(null, "Sillas Adicionales: " + getModeloReservacion().getSillasAdicionales() + "\n");

    }

    private void getUsuariosRegistrados() {
        JOptionPane.showMessageDialog(null, "Usuario: " + getModeloReservacion().getUsuario());
        JOptionPane.showMessageDialog(null, "Contraseña: " + getModeloReservacion().getContraseña() + "\n");
    }

    private void muestra_informacion() {

        int info = Integer.parseInt(JOptionPane.showInputDialog(null,"""
        1. Evaluaciones realizadas
        2. Peticiones
        3. Reclamos
        4. Quejas
        5. Respuestas de los diagnósticos
        ¿Qué información deseas saber (1-5)?: """));
            
        switch (info) {
            case 1 -> {
                JOptionPane.showMessageDialog(null, "Evaluaciones realizadas:");
                for (String evaluacion : getModeloReservacion().getLiEvaluaciones()) {
                    JOptionPane.showMessageDialog(null,"- " + evaluacion);
                }
            }
            case 2 -> {
                JOptionPane.showMessageDialog(null, "Peticiones:");
                for (String peticion : getModeloReservacion().getLiPeticion()) {
                    JOptionPane.showMessageDialog(null, "- " + peticion);
                }
            }
            case 3 -> {
                JOptionPane.showMessageDialog(null, "Reclamos:");
                for (String reclamo : getModeloReservacion().getLiReclamos()) {
                    JOptionPane.showMessageDialog(null, "- " + reclamo);
                }
            }
            case 4 -> {
                JOptionPane.showMessageDialog(null, "Quejas:");
                for (String queja : getModeloReservacion().getLiQuejas()) {
                    JOptionPane.showMessageDialog(null,"- " + queja);
                }
            }
            case 5 -> {
                muestra_inf_diag();
                // Aquí puedes implementar la lógica para mostrar información de los diagnósticos si es necesario
            }
            default ->
                JOptionPane.showMessageDialog(null,"Opción no válida");
        }

    }

    public void muestra_inf_diag() {

        try {
            int inf = Integer.parseInt(JOptionPane.showInputDialog(null, """
                1. Respuesta que ingresó el Vigilante.
                2. Respuesta que ingresó el Mesero.
                3. Respuesta que ingresó el Cocinero.
                4. Respuesta que ingresó el Cajero.
                ¿Cuál respuesta desea saber su información?
                """));
    
            if (inf == 1) {
                // Respuesta del vigilante
                JOptionPane.showMessageDialog(null, "La respuesta es: " + getModeloReservacion().getRespuesta_vigilante());
            } else if (inf == 2) {
                // Respuesta del mesero
                String nombreMesero = getModeloReservacion().getNombre_mesero();
                String respuestaMesero = getModeloReservacion().getRespuesta_mesero();
                JOptionPane.showMessageDialog(null, "La respuesta es: " + respuestaMesero + ", esta fue ingresada por el mesero: " + nombreMesero);
            } else if (inf == 3) {
                // Respuesta del cocinero
                String respuestaCocinero = getModeloReservacion().getRespuesta_cocinero();
                JOptionPane.showMessageDialog(null, "La respuesta es: " + respuestaCocinero);
            } else if (inf == 4) {
                // Respuesta del cajero
                String respuestaCajero = getModeloReservacion().getRespuesta_cajero();
                JOptionPane.showMessageDialog(null, "La respuesta es: " + respuestaCajero);
            } else {
                JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija una opción entre 1 y 4.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Por favor, ingrese un número válido.");
        }
    }
    
}
