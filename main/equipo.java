public class equipo {
    private String nombre;
    private String categoria;
    private int golesMarcados;
    private int golesEncajados;
    private int difGoles=difG(golesMarcados, golesEncajados);
    private int partGanados;
    private int partPerdidos;
    private int partEmp;
    private int puntos=puntosFinales(partGanados, partEmp);

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

    //mod----------------------------------
    public void setNombre(String suNombre){
        nombre=suNombre;
    }  
    public void setCat (String cat){
        categoria=cat;
    }
    public void setGolesEncajados(int golesEncajados){
        golesEncajados=this.golesEncajados;
    }
    public void setGolesMarcados(int golesMarcados){
        golesMarcados=this.golesMarcados;
    }
    public void setGanados(int partGanados){
        partGanados=this.partGanados;
    }
    public void setPerdidos(int partPerdidos){
        partPerdidos=this.partPerdidos;
    }
    public void setEmpates(int partEmp){
        partEmp=this.partEmp;
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