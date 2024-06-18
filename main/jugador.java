public class jugador {
    private String nombreJugador;
    private String apellido;
    private int edad;
    private int dni;
    private int camiseta;
    private int goles;
    private String suEquipo;

    //contructores-------------------------
    public jugador(String nombreJugador, String apellido, int edad, int dni, int camiseta, String suEquipo){
        nombreJugador=this.nombreJugador;
        apellido=this.apellido;
        edad=this.edad;
        dni=this.dni;
        camiseta=this.camiseta;
        suEquipo=this.suEquipo;
    }

    //obs----------------------------------
    public String getNombreJugador(){
        return nombreJugador;
    }
    public String getApellido(){
        return apellido;
    }
    public String getEquipo(){
        return suEquipo;
    }
    public int getEdad(){
        return edad;
    }
    public int getDni(){
        return dni;
    }
    public int getCamiseta(){
        return camiseta;
    }
    public int goles(){
        return goles;
    }

    //mod----------------------------------
    public void setNombreJugador(String nombreJugador){
        nombreJugador=this.nombreJugador;
    }
    public void setApellido(String apellido){
        apellido=this.apellido;
    }
    public void setEquipo(String suEquipo){
        suEquipo=this.suEquipo;
    }
    public void setEdad(int edad){
        edad=this.edad;
    }
    public void setDni(int dni){
        dni=this.dni;
    }
    public void setCamiseta(int camiseta){
        camiseta=this.camiseta;
    }
    public void setGoles(int goles){
        goles=this.goles;
    }

}

