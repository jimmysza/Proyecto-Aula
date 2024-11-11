package model;

//main class
public class ReservacionesModel {
    
    private static ReservacionesModel instance;
    private String lastUsuario;
    private int numeroTotalMesasDisponibles;
    
    
    
    //Contrusctor Vacio -> definiendo Valores Predeterminado
    public ReservacionesModel() {
        this.numeroTotalMesasDisponibles = 10;
        
    }

    //Constructor Con Parametros
    public ReservacionesModel(int numeroTotalMesasDisponibles,  String lastUsuario ) {
        this.numeroTotalMesasDisponibles = numeroTotalMesasDisponibles; 
        this.lastUsuario = lastUsuario;
    }
    
    public static ReservacionesModel getInstance() {
        if (instance == null) {
            instance = new ReservacionesModel();
        }
        return instance;
    }
    
    public String getLastUsuario() {
        return lastUsuario;
    }
    
    public void setLastUsuario(String lastUsuario) {
        this.lastUsuario = lastUsuario;
    }
    
    //Todos los Metodos getter and setter
    public int getNumeroTotalMesasDisponibles() {
        return numeroTotalMesasDisponibles;
    }

    public void setNumeroTotalMesasDisponibles(int numeroTotalMesasDisponibles) {
        this.numeroTotalMesasDisponibles = numeroTotalMesasDisponibles;
    }

    @Override
    public String toString() {
        return "ReservacionesModel{" + "lastUsuario=" + lastUsuario + ", numeroTotalMesasDisponibles=" + numeroTotalMesasDisponibles + '}';
    }
    
    
 }