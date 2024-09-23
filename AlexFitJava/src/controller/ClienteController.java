package controller;

import java.awt.HeadlessException;

import javax.swing.JOptionPane;

import model.ReservacionesModel;

//ClienteController gestiona las interacciones del cliente en el sistema de reservas, incluyendo la evaluación del personal, la gestión de PQRs, y la realización de reservaciones.
public class ClienteController {

    private BaseController baseController;

    //Constructor que inicializa el controlador de cliente con el controlador base.
    public ClienteController(BaseController baseController) {
        this.baseController = baseController;
    }

    //obtener el modelo de reservacion para acceder al controlador base
    private ReservacionesModel getModeloReservacion() {
        return baseController.getModeloReservacion();
    }

    //Metodo que contiene un bucle en el cual muestra el Menu del Cliente y solicita al Usuario escoger una funcionalidad
    public void menuCLiente(){
        while (true) {
            try {
                //Solicita al usuario, escoger una opcion
                int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                    1. Evaluacion y P.Q.R
                    2. Reservar Mesa
                    3. Ver Menu
                    4. salir
                    Ingresa una opcion del (1-4)
                    """));

            //Gestiona la accion seleccionada por la opcion elegida
            switch (opcion) {
                case 1 -> {
                    int subOption = Integer.parseInt(JOptionPane.showInputDialog(null,"""
                    1. Realizar una Evaluación de Satisfacción
                    2. P.Q.R
                    Elija (1) para Realizar una Evaluación de Satisfacción o (2) para ingresar un P.Q.R:"""));
                    switch (subOption) {
                        case 1 -> evaluacionSatisfaccion();
                        case 2 -> pqr();
                        default -> JOptionPane.showMessageDialog(null, "ERROR, LA OPCION INGRESADA NO EXISTE");
                    }
                    break;
                } case 2 -> {
                    RealizarReservacion();
                    break;
                } case 3 -> {
                    MenuRestaurante();
                    break;
                } case 4 -> {
                    JOptionPane.showMessageDialog(null, "Muchas Gracias, VUELVA PRONTO");
                    return;
                }
                default -> JOptionPane.showMessageDialog(null, "ERROR, LA OPCION INGRESADA NO EXISTE");
                }
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Por favor, ingrese un número entero válido.\n");
            }
        }
    }

    //Metodo que le permite al usuario realizar las reservacion de las mesas del restaurante
    public void RealizarReservacion() {
        int numeroTotalPersonas = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad de personas para la mesa: "));
        
        if (numeroTotalPersonas <= 0) {
            JOptionPane.showMessageDialog(null, "Ingresaste una opción incorrecta\n");
        } else if (numeroTotalPersonas > 40) {
            JOptionPane.showMessageDialog(null, "El Numero de personas excede el aforo del restaurante\n");
        } else if (numeroTotalPersonas == 1) {
            JOptionPane.showMessageDialog(null, "No es Necesario Reservacion\n");
        } else if (numeroTotalPersonas > 1 && numeroTotalPersonas <= 4) {
            // Mostrar confirmación reservación
            reservacion(numeroTotalPersonas, 1);
            // Actualizar mesas
            actualizarMesas(1, 1);
        } else if (numeroTotalPersonas > 4) {
            int mesasOcupadas = numeroTotalPersonas / 4; // Redondear hacia abajo
            double resto = (numeroTotalPersonas % 4) / 4.0; // Calcular el resto como decimal
    
            if (getModeloReservacion().getNumeroTotalMesasDisponibles() == 0) {
                MesasNoDisponibles();
            } else if (mesasOcupadas <= getModeloReservacion().getNumeroTotalMesasDisponibles()) {
                // Actualiza las mesas disponibles
                actualizarMesas(mesasOcupadas, mesasOcupadas);
    
                // Mostrar la reservación si hay persona addicionales a las cantidad minima de 4 cuatro personas por mesa que permite agregar sillas
                if (resto == 0) {
                    reservacion(numeroTotalPersonas, mesasOcupadas);
                } else if (resto == 0.25) {
                    //Agrega una silla a la mesa y actualiza el contandor de sillas prestadas
                    actualizarSillas(numeroTotalPersonas, 1, mesasOcupadas);
                } else if (resto == 0.50) {
                    //Agrega 2 silla a la mesa y actualiza el contandor de sillas prestadas
                    actualizarSillas(numeroTotalPersonas, 2, mesasOcupadas);
                } else if (resto == 0.75) {
                    //Agrega 3 silla a la mesa y actualiza el contandor de sillas prestadas
                    actualizarSillas(numeroTotalPersonas, 3, mesasOcupadas);
                }
            }
        } else {
            //Metodo que imprime un mensaje haciendo entender que no hay mesas disponibles
            MesasNoDisponibles();
        }
    }

    //metodo que permite realizar una evaluacion de sastifaccion del personal, escogiendo un cargo y proporcionado puntuacion y comentario
    public void evaluacionSatisfaccion() {

        int cargo = Integer.parseInt(JOptionPane.showInputDialog(null,"""
        1. Vigilante
        2. Mesero Juan
        3. Mesero Andres
        4. Cocinero
        5. Cajero
        Ingrese el número correspondiente al cargo (1-5):
        """));

    
        if (1 <= cargo && cargo <= 5) {

            int puntuacion = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la puntuación del servicio (1-5): "));

            if (puntuacion >= 1 && puntuacion <= 5) {

                String comentario = JOptionPane.showInputDialog(null,"Ingrese su Comentario: ");
    
                String cargoEva;
                switch (cargo) {
                    case 1 -> cargoEva = "vigilante";
                    case 2 -> cargoEva = "Mesero Juan";
                    case 3 -> cargoEva = "Mesero Andres";
                    case 4 -> cargoEva = "Cocinero";
                    case 5 -> cargoEva = "Cajero";
                    default -> {
                        JOptionPane.showMessageDialog(null, "Te has equivocado");
                        return;
                    }
                }
    
                getModeloReservacion().setCargoEva(cargoEva);
    
                String evaluacion = String.format("Se realizó una evaluación al cargo de %s, tuvo una puntuación de %d, y colocó este comentario: %s",  cargoEva, puntuacion, comentario);
                getModeloReservacion().getLiEvaluaciones().add(evaluacion);
                JOptionPane.showMessageDialog(null, "Evaluación registrada con éxito.");
            } else {
                //JOptionPane.showMessageDialog(null, "");
                JOptionPane.showMessageDialog(null, "La puntuación no está dentro del rango de 1 a 5");
            
            }
        } else {
            JOptionPane.showMessageDialog(null, "Opción incorrecta, vuelva a intentarlo...");
        }
    }
    
    //Metodo que permite realizar una peticion, queja o reclamo de los servicios prestados en el restaurante
    public void pqr(){
        int pqr = Integer.parseInt(JOptionPane.showInputDialog(null,"""
        1. Peticiones
        2. Quejas
        3. Reclamos
        Ingrese el numero correspondiente a la accion que desea realizar (1-3):
        """));
        switch (pqr) {
            case 1: // Petición
                String peticion = JOptionPane.showInputDialog(null, "Ingrese su Petición:");
                if (peticion != null && !peticion.trim().isEmpty()) {
                    getModeloReservacion().getLiPeticion().add(peticion);
                    JOptionPane.showMessageDialog(null, "Petición registrada con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se ingresó ninguna petición.");
                }
                break;
    
            case 2: // Quejas
                String quejas = JOptionPane.showInputDialog(null, "Ingrese sus Quejas:");
                if (quejas != null && !quejas.trim().isEmpty()) {
                    getModeloReservacion().getLiQuejas().add(quejas);
                    JOptionPane.showMessageDialog(null, "Queja registrada con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se ingresó ninguna queja.");
                }
                break;
    
            case 3: // Reclamos
                String reclamos = JOptionPane.showInputDialog(null, "Ingrese su Reclamo:");
                if (reclamos != null && !reclamos.trim().isEmpty()) {
                    getModeloReservacion().getLiReclamos().add(reclamos);
                    JOptionPane.showMessageDialog(null, "Reclamo registrado con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se ingresó ningún reclamo.");
                }
                break;
    
            default:
                JOptionPane.showMessageDialog(null, "Ingreso un número incorrecto.");
                break;
        }

    }


    //Meto que imprime una mensaje de confirmacion de haber realizado al reserva
    public static void reservacion(int numeroTotalPersonas, int mesasOcupadas) {
        if (mesasOcupadas > 1) {
            JOptionPane.showMessageDialog(null, "Se ha realizado su reservación para " + numeroTotalPersonas + " personas, en " + mesasOcupadas + " Mesas.\n");
        } else {
            JOptionPane.showMessageDialog(null, "Se ha realizado su reservación para " + numeroTotalPersonas + " personas, en " + mesasOcupadas + " Mesa.\n");
        }
    }

    //Metodo que actualiza las sillas prestadas y prepara el metodo reservacionYSillas en el sistema de reservacion
    protected void actualizarSillas(int numeroTotalPersonas, int sillasAdicionales, int mesasOcupadas) {
        getModeloReservacion().setSillasAdicionales(getModeloReservacion().getSillasAdicionales() + sillasAdicionales);
        reservacionYSillas(numeroTotalPersonas, sillasAdicionales, mesasOcupadas);
    }

    public void MesasNoDisponibles() {
        JOptionPane.showMessageDialog(null, "No hay mesas disponibles.\n");
    }


    //Metodo que imprime una mensaje de confirmacion de haber realizado la reserva con cuantas mesas, el numero de personas y la cantidad des sillas addicionales
    public static void reservacionYSillas(int numeroTotalPersonas, int sillasAdicionales, int mesasOcupadas) {
        JOptionPane.showMessageDialog(null, "Se ha realizado su reservación para " + numeroTotalPersonas + " personas, en " + mesasOcupadas + " Mesas. Número de sillas adicionales necesarias: " + sillasAdicionales + ".");

    }


    //Metodo que actualiza las mesas reservadas y las mesas disponibles en el sistema de reservacion
    protected void actualizarMesas(int mesasOcupadas, int mesasReservadas) {
        getModeloReservacion().setNumeroTotalMesasDisponibles(getModeloReservacion().getNumeroTotalMesasDisponibles() - mesasOcupadas);
        getModeloReservacion().setMesasReservadas(getModeloReservacion().getMesasReservadas() + mesasReservadas);
    }

    private void MenuRestaurante() {
        // Solicita al usuario que seleccione una opción del menú del restaurante
        int menuOpcion = Integer.parseInt(JOptionPane.showInputDialog(null,"""
                ===MENU ALEX FIT===
                1. Entradas
                2. Platos Fuertes
                3. Bebidas
                4. Postres
                5. Salir
                Escoge una de las opciones (1-5):
                        """));
        
        // Gestiona la opción seleccionada
        switch (menuOpcion) {
            case 1 -> menuEntradas();
            case 2 -> menuPlatosFuertes();
            case 3 -> menuBebidas();
            case 4 -> menuPostres();
            case 5 -> {
                return;
            }
            default -> JOptionPane.showMessageDialog(null, "Te has equivocado");
        }
    }

    // Métodos de capacitación, impresión de menú y otras funcionalidades relacionadas.

    //este metodo se utiliza para imprimir el menu de postres

    public static void menuPostres() {
        JOptionPane.showMessageDialog(null, """
            Postres :

            1. Mousse de Aguacate y Cacao
                - Carbohidratos: 18g | Proteínas: 3g | Grasas: 16g
            2. Tarta de Manzana con Base de Avena
                - Carbohidratos: 30g | Proteínas: 4g | Grasas: 9g
            3. Brownies de Batata y Almendras
                - Carbohidratos: 22g | Proteínas: 5g | Grasas: 10g
            4. Helado de Plátano y Fresas (Sin Azúcar)
                - Carbohidratos: 28g | Proteínas: 3g | Grasas: 1g
            5. Cheesecake Vegano de Frutos Rojos
                - Carbohidratos: 30g | Proteínas: 6g | Grasas: 15g
            6. Pudding de Chía y Leche de Coco
                - Carbohidratos: 14g | Proteínas: 5g | Grasas: 12g
            7. Tarta de Zanahoria con Harina de Almendra
                - Carbohidratos: 20g | Proteínas: 6g | Grasas: 12g
            8. Galletas de Avena y Mantequilla de Maní
                - Carbohidratos: 25g | Proteínas: 8g | Grasas: 12g
            9. Barritas de Granola Caseras
                - Carbohidratos: 30g | Proteínas: 7g | Grasas: 10g
            10. Fruta Asada con Yogurt Griego y Miel
                - Carbohidratos: 28g | Proteínas: 7g | Grasas: 5g
            """);
    }

    //este metodo se utiliza para imprimir el menu de los platos fuertes

    public static void menuPlatosFuertes() {
        JOptionPane.showMessageDialog(null, """
            Platos Fuertes :

            1. Salmón a la Parrilla con Quinoa y Espárragos
                - Carbohidratos: 28g | Proteínas: 38g | Grasas: 18g
            2. Pollo al Curry con Leche de Coco y Arroz Integral
                - Carbohidratos: 40g | Proteínas: 32g | Grasas: 22g
            3. Bowl de Lentejas, Espinacas y Batata Asada
                - Carbohidratos: 55g | Proteínas: 18g | Grasas: 8g
            4. Hamburguesa Vegana de Garbanzos y Aguacate
                - Carbohidratos: 45g | Proteínas: 20g | Grasas: 15g
            5. Tofu a la Plancha con Vegetales Salteados
                - Carbohidratos: 15g | Proteínas: 20g | Grasas: 10g
            6. Pechuga de Pavo Asada con Ensalada de Espinacas
                - Carbohidratos: 10g | Proteínas: 36g | Grasas: 7g
            7. Risotto de Coliflor y Champiñones
                - Carbohidratos: 25g | Proteínas: 10g | Grasas: 8g
            8. Ensalada de Quinoa con Pollo a la Parrilla y Aguacate
                - Carbohidratos: 30g | Proteínas: 32g | Grasas: 15g
            9. Fajitas de Verduras con Tortilla Integral
                - Carbohidratos: 42g | Proteínas: 12g | Grasas: 10g
            10. Pasta Integral con Pesto de Kale y Tomates Cherry
                - Carbohidratos: 50g | Proteínas: 12g | Grasas: 15g
            """);
    }

    //este metodo se utiliza para imprimir el menu de entradas

    public static void menuEntradas() {
        JOptionPane.showMessageDialog(null, """
            Entradas :

            1. Guacamole con Tostadas Integrales
                - Carbohidratos: 24g | Proteínas: 5g | Grasas: 18g
            2. Sopa de Verduras
                - Carbohidratos: 18g | Proteínas: 4g | Grasas: 3g
            3. Ensalada Caprese con Pesto de Albahaca
                - Carbohidratos: 6g | Proteínas: 8g | Grasas: 12g
            4. Brócoli al Vapor con Limón y Aceite de Oliva
                - Carbohidratos: 10g | Proteínas: 4g | Grasas: 7g
            5. Hummus con Bastones de Zanahoria y Pepino
                - Carbohidratos: 12g | Proteínas: 6g | Grasas: 8g
            6. Ceviche de Tofu
                - Carbohidratos: 7g | Proteínas: 10g | Grasas: 4g
            7. Rollitos de Calabacín Rellenos de Ricota
                - Carbohidratos: 5g | Proteínas: 9g | Grasas: 11g
            8. Tartar de Aguacate y Salmón Ahumado
                - Carbohidratos: 3g | Proteínas: 13g | Grasas: 15g
            9. Dip de Yogurt con Hierbas y Crudités
                - Carbohidratos: 7g | Proteínas: 5g | Grasas: 2g
            10. Mini Tortillas de Espinacas con Queso de Cabra
                - Carbohidratos: 14g | Proteínas: 9g | Grasas: 10g
            """);
    }

    //este metodo se utiliza para imprimir el menu de las Bebidas

    public static void menuBebidas() {
        JOptionPane.showMessageDialog(null, """
            Bebidas :
            1. Smoothie Verde de Espinacas y Piña
                - Carbohidratos: 22g | Proteínas: 3g | Grasas: 1g
            2. Agua de Coco Natural
                - Carbohidratos: 9g | Proteínas: 1g | Grasas: 0g
            3. Jugo de Naranja y Zanahoria
                - Carbohidratos: 25g | Proteínas: 2g | Grasas: 0g
            4. Batido de Proteína de Chocolate y Plátano
                - Carbohidratos: 40g | Proteínas: 20g | Grasas: 5g
            5. Té Verde con Jengibre y Limón
                - Carbohidratos: 0g | Proteínas: 0g | Grasas: 0g
            6. Infusión de Menta y Pepino
                - Carbohidratos: 0g | Proteínas: 0g | Grasas: 0g
            7. Smoothie de Avena, Plátano y Mantequilla de Almendra
                - Carbohidratos: 35g | Proteínas: 8g | Grasas: 10g
            8. Limonada con Chía
                - Carbohidratos: 12g | Proteínas: 1g | Grasas: 2g
            9. Agua Fresca de Sandía
                - Carbohidratos: 20g | Proteínas: 1g | Grasas: 0g
            10. Café con Leche de Almendra
                - Carbohidratos: 2g | Proteínas: 2g | Grasas: 3g
            """);
    }
}
