public class jugador {
    private String nombreJugador;
    private String apellido;
    private int edad;
    private int dni;
    private int camiseta;
    private int goles;
    private String suEquipo;

    //contructores-------------------------
    public jugador(String apellido, String nombreJugador, int edad, int dni, int camiseta, String suEquipo,int goles){
        this.nombreJugador=nombreJugador;
        this.apellido=apellido;
        this.edad=edad;
        this.dni=dni;
        this.camiseta=camiseta;
        this.suEquipo=suEquipo;
        this.goles=goles;
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
    public int getGoles(){
        return goles;
    }

    //mod----------------------------------
    public void setNombreJugador(String nombreJugador){
        this.nombreJugador=nombreJugador;
    }
    public void setApellido(String apellido){
        this.apellido=apellido;
    }
    public void setEquipo(String suEquipo){
        this.suEquipo=suEquipo;
    }
    public void setEdad(int edad){
        this.edad=edad;
    }
    public void setDni(int dni){
        this.dni=dni;
    }
    public void setCamiseta(int camiseta){
        this.camiseta=camiseta;
    }
    public void setGoles(int goles){
        this.goles+=goles;
    }

}

