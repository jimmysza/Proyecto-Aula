package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//main class
public class ReservacionesModel {
    //Atributos Privados
    private int numeroTotalMesasDisponibles;
    private int mesasReservadas;
    private int sillasAdicionales;
    private String usuario;
    private String contraseña;
    private String cargoEva;

    //listas
    private List<String> liEvaluaciones = new ArrayList<>();
    private List<String> liPeticion = new ArrayList<>();
    private List<String> liReclamos = new ArrayList<>();
    private List<String> liQuejas = new ArrayList<>();

    //respuestas personal
    private String respuesta_vigilante;
    private String respuesta_mesero;
    private String nombre_mesero;
    private String respuesta_cocinero;
    private String respuesta_cajero;

    //Contrusctor Vacio -> definiendo Valores Predeterminado
    public ReservacionesModel() {
        this.numeroTotalMesasDisponibles = 10;
        this.mesasReservadas = 0;
        this.sillasAdicionales = 0;
        this.usuario = "1";
        this.contraseña = "1";
    }

    //Constructor Con Parametros
    public ReservacionesModel(int numeroTotalMesasDisponibles, int mesasReservadas, int sillasAdicionales, String usuario, String contraseña, String cargoEva, List<String> liEvaluaciones, List<String> liPeticion, List<String> liReclamos, List<String> liQuejas, Map<String, String> personal, String respuesta_vigilante, String respuesta_mesero, String respuesta_cocinero, String respuesta_cajero, String nombre_mesero ) {
        this.numeroTotalMesasDisponibles = numeroTotalMesasDisponibles;
        this.mesasReservadas = mesasReservadas;
        this.sillasAdicionales = sillasAdicionales;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.cargoEva = cargoEva;

        //listas
        this.liEvaluaciones = liEvaluaciones;
        this.liPeticion = liPeticion;
        this.liReclamos = liReclamos;
        this.liQuejas = liQuejas;
        this.nombre_mesero = nombre_mesero;

        this.respuesta_vigilante = respuesta_vigilante;
        this.respuesta_mesero = respuesta_mesero;
        this.respuesta_cocinero = respuesta_cocinero;
        this.respuesta_cajero = respuesta_cajero;
    }


    //Todos los Metodos getter and setter
    public int getNumeroTotalMesasDisponibles() {
        return numeroTotalMesasDisponibles;
    }

    public void setNumeroTotalMesasDisponibles(int numeroTotalMesasDisponibles) {
        this.numeroTotalMesasDisponibles = numeroTotalMesasDisponibles;
    }

    public int getMesasReservadas() {
        return mesasReservadas;
    }

    public void setMesasReservadas(int mesasReservadas) {
        this.mesasReservadas = mesasReservadas;
    }

    public int getSillasAdicionales() {
        return sillasAdicionales;
    }

    public void setSillasAdicionales(int sillasAdicionales) {
        this.sillasAdicionales = sillasAdicionales;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCargoEva() {
        return cargoEva;
    }

    public void setCargoEva(String cargoEva) {
        this.cargoEva = cargoEva;
    }

    // Metodos getter and setters Listas

    public List<String> getLiEvaluaciones() {
        return liEvaluaciones;
    }

    public void setLiEvaluaciones(List<String> liEvaluaciones) {
        this.liEvaluaciones = liEvaluaciones;
    }

    public List<String> getLiPeticion() {
        return liPeticion;
    }

    public void setLiPeticion(List<String> liPeticion) {
        this.liPeticion = liPeticion;
    }

    public List<String> getLiReclamos() {
        return liReclamos;
    }

    public void setLiReclamos(List<String> liReclamos) {
        this.liReclamos = liReclamos;
    }

    public List<String> getLiQuejas() {
        return liQuejas;
    }

    public void setLiQuejas(List<String> liQuejas) {
        this.liQuejas = liQuejas;
    }

    // Metodos getter and setters respuestasa

    public String getNombre_mesero(){
        return nombre_mesero;
    }

    public void setNombre_mesero(String nombre_mesero){
        this.nombre_mesero = nombre_mesero;
    }
    
    public String getRespuesta_vigilante() {
        return respuesta_vigilante;
    }

    public void setRespuesta_vigilante(String respuesta_vigilante) {
        this.respuesta_vigilante = respuesta_vigilante;
    }

    
    public String getRespuesta_mesero() {
        return respuesta_mesero;
    }

    public void setRespuesta_mesero(String respuesta_mesero) {
        this.respuesta_mesero = respuesta_mesero;
    }

    
    public String getRespuesta_cocinero() {
        return respuesta_cocinero;
    }

    public void setRespuesta_cocinero(String respuesta_cocinero) {
        this.respuesta_cocinero = respuesta_cocinero;
    }

    
    public String getRespuesta_cajero() {
        return respuesta_cajero;
    }

    public void setRespuesta_cajero(String respuesta_cajero) {
        this.respuesta_cajero = respuesta_cajero;
    }

}