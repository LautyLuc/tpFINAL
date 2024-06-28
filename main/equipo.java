public class equipo {
    private String nombre;
    private String categoria;
    private int golesMarcados;
    private int golesEncajados;
    private int difGoles;
    private int partGanados;
    private int partPerdidos;
    private int partEmp;
    private int puntos;
    private jugador [] jugadores = new jugador[14];
    
    
    
    //contructores ------------------------
    public equipo(String suNombre,String cat){
        nombre=suNombre;
        categoria=cat;
    }
    public equipo (String suNombre, String cat, int golesF, int golesC, int partG , int partP , int partE ){
        nombre=suNombre;
        categoria=cat;
        golesF=0;
        golesC=0;
        partP=0;
        partG=0;
        partE=0;
    }

    //obs----------------------------------
    public String getNombre(){
        return nombre;
    }
    public String getCategoria(){
        return categoria;
    }
    public int getDif(){
        return difGoles;
    }
    public int getPuntos(){
        return puntos;
    }
    public int getGolesFavor(){
        return golesMarcados;
    }
    public int getGolesContra(){
        return golesEncajados;
    }
    public int getPartGanados(){
        return partGanados;
    }
    public int getPartPer(){
        return partPerdidos;
    }
    public int getPartEmp(){
        return partEmp;       
    }
    public jugador[] getJugadores() {
    return jugadores;
    }

    //mod----------------------------------
    public void setNombre(String suNombre){
        nombre=suNombre;
    }  
    public void setCat (String cat){
        categoria=cat;
    }
    public void setGolesEncajados(int golesEncajados){
        this.golesEncajados+=golesEncajados;
    }
    public void setGolesMarcados(int golesMarcados){
        this.golesMarcados+=golesMarcados;
    }
    public void setGanados(){
        partGanados++;
    }
    public void setPerdidos(){
        partPerdidos++;
    }
    public void setEmpates(){
        partEmp++;
    }
    public void setJugador(jugador jug) {
        int i=0;
        boolean b1=false;
        while (b1==false && i < this.jugadores.length) {
            if (this.jugadores[i]==null) {
                this.jugadores[i]=jug;
                b1=true;
            }
            i++;
        }
    }
    public void setPuntos(){
        puntos=puntosFinales(partGanados,partEmp);
    }
    public void setDif(){
        difGoles=difG(golesMarcados, golesEncajados);
    }
    //prop tipo----------------------------
    public int difG ( int gF , int gC ) {
        int goles = gF - gC ;
    return goles ;
    }
    public int puntosFinales ( int partGanados, int partEmp ) {
        int points=partGanados*3+partEmp;
        return points;
    }
}