
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class torneoForever {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = 0, m = 0, opc = 1;
        n = longArrEquipos();// me toma la cantidad de equipos y me retorna la cantidad-1
        m = longArrJug()+24;// misma idea,pero para jugadores, +24 (cada equipo puede sumar maximo 3 suplentes,3*8=24)

        equipo[] arrTeams = new equipo[n];

        jugador[] arrJugadores = new jugador[m];

        cargarEquipos(arrTeams);
        cargarJugadores(arrJugadores, arrTeams);
        equipo[][] encuentros;
        String[][] partidosJugados;

        encuentros = generateFixture(arrTeams);
        partidosJugados = new String[7][4];

        System.out.println();
        System.out.println("TORNEO FOREVER");
        System.out.println();

        for (int j = 0; j < arrTeams.length; j++) {
            System.out.println(arrTeams[j].getNombre());
            System.out.println("---------------------------------------------------------------------");
        }

        while (opc != 0) {
            System.out.println("ingrese la opcion que desee:");
            System.out.println("1. para ingresar los resultados de las fechas");
            System.out.println("2. para agregar un Jugador, si este ya esta inscripto no será valido");
            System.out.println("3. para ver la posicion de los equipos");
            System.out.println("4. para ver los resultados de una fecha especifica");
            System.out.println("5. para ver la tabla de goleadores");
            System.out.println("6. para ver las estadisticas basicas del torneo");
            System.out.println("7. para ver la lista completa de los jugadores");
            System.out.println("0. para salir");
            System.out.println();
            opc = sc.nextInt();
            System.out.println();
            switch (opc) {
                case 1:
                    cargarFecha(encuentros, arrTeams, partidosJugados);
                break;
                case 2:
                    addJug(arrTeams, arrJugadores);
                break;
                case 3:
                    //tablaEquipos;
                break;
                case 4:
                    resFecha(partidosJugados);
                break;
                case 5:
                    //goleadores;
                break;
                case 6:
                    //stats;
                break;
                case 7:
                    jugPorEquipo(arrTeams);
                    break;
            }
        }
    }

    public static void jugPorEquipo(equipo[] equipos) {
        jugador[] jug = new jugador[15];
        int j = 0;
        for (int i = 0; i < equipos.length; i++) {
            System.out.println("jugadores de: " + equipos[i].getNombre());
            jug = equipos[i].getJugadores();
            while (j < jug.length && jug[j] != null && jug[j].getEquipo().equals(equipos[i].getNombre())) {
                System.out.println(jug[j].getApellido() + " " + jug[j].getCamiseta());
                j++;
            }
            System.out.println("-----------------------------------");
            j = 0;

        }
    }

    public static void resFecha(String[][] jornadas) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese la fecha que quiere ver: ");
        int n = sc.nextInt();
        if (n < 8) {
            for (int j = 0; j < jornadas[0].length; j++) {
                if (jornadas[n][j] != null) {
                    System.out.println();
                    System.out.println(jornadas[n][j]);
                    System.out.println("-------------------------------");
                } else {
                    System.out.println("Jornada " + (n + 1) + ", partido " + (j + 1) + " por definir");
                }
            }
        } else {
            System.out.println("fecha invalida");
        }
        System.out.println("-----------------------------------");

    }

    public static void mostrarJug(jugador[] arrJug) {
        jugador jug = new jugador(null, null, 0, 0, 0, null, 0);
        for (int i = 0; i < arrJug.length; i++) {
            jug = arrJug[i];
            System.out.println("jugador: " + (i + 1));
            System.out.println("nombre: " + jug.getNombreJugador() + " " + jug.getApellido() + " Numero de camiseta: "
                    + jug.getCamiseta());
            System.out.println("dni: " + jug.getDni() + " edad: " + jug.getEdad());
            System.out.println("Equipo: " + jug.getEquipo());
            System.out.println("---------------------------------------------------------------------");
        }
    }

    public static void cargarEquipos(equipo[] Teams) {
        FileReader equipos;
        BufferedReader lector;
        String cad;
        int i = 0;
        try {
            equipos = new FileReader("C:/tpFinalDesarrollo/main/Equipos.txt");
            lector = new BufferedReader(equipos);
            while ((cad = lector.readLine()) != null && i < Teams.length) {
                Teams[i] = cargEquipo(cad);
                i++;
            }
            lector.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + " No existe el archivo");
        } catch (IOException ex) {
            System.out.println("Error de lectura del archivo");
        }
    }

    public static equipo cargEquipo(String linea) {
        String[] separador = linea.split(";");
        String nombre = "", cat = "";
        if (separador.length == 2) {
            nombre = separador[0];
            cat = separador[1];
        }
        equipo team = new equipo(nombre, cat);
        return team;
    }

    public static int longArrEquipos() {
        int num = 0;
        FileReader equipos;
        BufferedReader lector;

        try {
            equipos = new FileReader("C:/tpFinalDesarrollo/main/Equipos.txt");
            if (equipos.ready()) {
                lector = new BufferedReader(equipos);
                while ((lector.readLine()) != null) {
                    num++;
                }
            } else {
                System.out.println("arch no esta listo");
            }
        } catch (Exception e) {
            System.out.println("err");
        }

        return num;
    }

    public static int longArrJug() {
        int num = 0;
        FileReader jugadores;
        BufferedReader lector;

        try {
            jugadores = new FileReader("C:/tpFinalDesarrollo/main/Jugadores.txt");
            if (jugadores.ready()) {
                lector = new BufferedReader(jugadores);
                while ((lector.readLine()) != null) {
                    num++;
                }
            } else {
                System.out.println("arch no esta listo");
            }
        } catch (Exception e) {
            System.out.println("err");
        }

        return num;
    }

    public static equipo[][] generateFixture(equipo[] teams) {
        int cantEquipos = teams.length;
        int cantFechas = cantEquipos - 1;
        equipo[][] encuentros = new equipo[cantFechas][8];
        for (int fecha = 0; fecha < cantFechas; fecha++) {
            for (int j = 0; j < 8; j = j + 2) {
                int local = (fecha + j) % (cantEquipos - 1);
                int visitante = (cantEquipos - 1 - j + fecha) % (cantEquipos - 1);
                if (j == 0) {
                    visitante = cantEquipos - 1;
                }
                encuentros[fecha][j] = teams[local];
                encuentros[fecha][j + 1] = teams[visitante];
            }
        }

        return encuentros;
    }

    public static void partidos(equipo[][] encuentros) {
        for (int i = 0; i < encuentros.length; i++) {
            System.out.println("Encuentro " + (i + 1));
            for (int j = 0; j < encuentros[i].length - 1; j = j + 2) {
                System.out
                        .println(encuentros[i][j].getNombre() + " : " + encuentros[i][j + 1].getNombre());
            }
            System.out.println();
            System.out.println("---------------------------------------------------------------------");
        }
    }

    public static void cargarJugadores(jugador[] arrJug, equipo[] Teams) {
        FileReader jugador;
        BufferedReader lector;
        String cad;
        int i = 0;
        try {
            jugador = new FileReader("C:/tpFinalDesarrollo/main/Jugadores.txt");
            lector = new BufferedReader(jugador);
            while ((cad = lector.readLine()) != null && i < arrJug.length) {
                arrJug[i] = cargJug(cad);
                i++;
            }
            for (int j = 0; j < Teams.length; j++) {
                for (int j2 = 0; j2 < arrJug.length && arrJug[j2]!=null ; j2++) {
                    if (Teams[j].getNombre().equals(arrJug[j2].getEquipo())) {
                        Teams[j].setJugador(arrJug[j2]);

                    }
                }
            }

            lector.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + " No existe el archivo");
        } catch (IOException ex) {
            System.out.println("Error de lectura del archivo");
        }
    }

    public static jugador cargJug(String linea) {
        jugador jug = new jugador("", "", 0, 0, 0, "", 0);
        String[] separador = linea.split(";");
        String nombre = "", apellido = "", suEquipo = "";
        int edad = 0, dni = 0, camiseta = 0;
        if (separador.length == 6) {
            nombre = separador[0];
            apellido = separador[1];
            edad = Integer.parseInt(separador[2]);
            dni = Integer.parseInt(separador[3]);
            camiseta = Integer.parseInt(separador[4]);
            suEquipo = separador[5];

        }
        jug = new jugador(nombre, apellido, edad, dni, camiseta, suEquipo, 0);
        return jug;
    }

    public static boolean veriCamiseta(jugador[] jugadores, int numero) {
        boolean b1 = false;
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i] != null && jugadores[i].getCamiseta() == numero) {
                b1 = true; // Encontró al jugador con el número de camiseta correcto
                break; // Sale del bucle porque ya encontró al jugador
            }
        }
        return b1;
    }

    public static void cargarFecha(equipo[][] jornadas, equipo[] arrEquipos, String[][] partidosCompletados) {
        Scanner sc = new Scanner(System.in);
        equipo local, visita;
        int g1 = 0, g2 = 0, fecha = 0, partido = 0, n = 0, k = 0, goles = 0, aux1 = 0, aux2 = 0;
        jugador[] jLocal, jVisita;
        System.out.println("ingrese fecha a cargar: ");

        fecha = sc.nextInt() - 1;
        System.out.println("Fecha: " + (fecha + 1));
        for (int i = 0; i < partidosCompletados.length; i++) {
            if (partido < jornadas[0].length) {
                local = jornadas[fecha][partido];
                visita = jornadas[fecha][partido + 1];
                jLocal = local.getJugadores();
                jVisita = visita.getJugadores();
                System.out.println(local.getNombre() + " : " + visita.getNombre());
                System.out.println();
                System.out.println("goles de " + local.getNombre() + ":");
                g1 = sc.nextInt();
                aux1 = g1;
                while (g1 > 0) {
                    System.out.println("camiseta del jugador: ");
                    n = sc.nextInt();
                    if (veriCamiseta(jLocal, n)) {
                        while (k < jLocal.length && jLocal[k] != null) {
                            if (jLocal[k].getCamiseta() == n) {
                                System.out.println(
                                        "ingrese la cantidad de goles que convirtio " + jLocal[k].getNombreJugador());
                                goles = sc.nextInt();
                                jLocal[k].setGoles(goles);
                                g1 = g1 - goles;
                            }
                            k++;
                        }
                    } else {
                        System.out.println("el jugador no existe en " + local.getNombre());
                    }
                }
                k = 0;
                n = 0;
                goles = 0;
                System.out.println("ingrese goles de " + visita.getNombre() + ":");
                g2 = sc.nextInt();
                aux2 = g2;
                while (g2 > 0) {
                    System.out.println("camiseta del jugador: ");
                    n = sc.nextInt();
                    if (veriCamiseta(jVisita, n)) {
                        while (k < jVisita.length && jVisita[k] != null) {
                            if (jVisita[k].getCamiseta() == n) {
                                System.out.println(
                                        "ingrese la cantidad de goles que convirtio " + jVisita[k].getNombreJugador());
                                goles = sc.nextInt();
                                jVisita[k].setGoles(goles);
                                g2 = g2 - goles;
                            }
                            k++;
                        }
                    } else {
                        System.out.println("el jugador no existe en " + visita.getNombre());
                    }
                }
                k = 0;
                n = 0;
                goles = 0;
                partidosCompletados[fecha][i] = local.getNombre() + " " + aux1 + " " + " : " + aux2 + " "
                        + visita.getNombre();
                partido += 2;
                System.out.println();
            }
        }

    }

    public static void addJug(equipo[] arrEquipo, jugador[] arrJug){
        Scanner sc=new Scanner(System.in);
        String equipo="";
        equipo unEquipo=new equipo("", "");
        jugador jug =new jugador("", "", 0, 0, 0, "", 0);
        jugador[] equipoJug= new jugador[15];
        boolean b1=false;
        int i=0;
        while (b1==false) {
            System.out.println("Ingrese el equipo al que desea añadir el jugador: ");
            System.out.println("Pikadura FC, Los Pildoritas, Golden Club FC, Manzana Mecanica, Dream Team, El Perla Negra, Armando Lio, Desactivados");
            equipo=sc.nextLine();
            if (veriEquipo(equipo, arrEquipo)) {
                while (!b1) {
                    if (equipo.equalsIgnoreCase(arrEquipo[i].getNombre())) {
                        b1=true;
                        unEquipo=arrEquipo[i];
                        equipoJug=arrEquipo[i].getJugadores();
                    }else{
                        i++;
                    }
                }
            }else{
                System.out.println("el equipo ingresado no es valido, pruebe otra vez");
            }
        }if (b1==true) {
            jug=nuevoJugador(arrJug,unEquipo,arrJug);
        }
        System.out.println("jugador cargado =D");
    }
    
    public static jugador nuevoJugador(jugador[] arrJug,equipo unEquipo,jugador[] eqJug){
        Scanner sc=new Scanner(System.in);
        jugador unJugador=new jugador(null, null, 0, 0, 0, null, 0);
        int cam=0,dni=0,edad=0;
        String apellido="",nombre="";
        String suEquipo=unEquipo.getNombre();
        boolean b1=false,b2=false;
        while (!b1) {
            System.out.println("ingrese el DNI");
            dni=sc.nextInt();
                if (veriDni(dni,arrJug)) {
                    b1=true;
                    System.out.println("Ingrese nombre");
                    nombre=sc.nextLine();
                    sc.next();
                    System.out.println("Ingrese apellido");
                    apellido=sc.nextLine();
                    sc.next();
                    System.out.println("ingrese edad");
                    edad=sc.nextInt();
                }else{
                    System.out.println("El DNI ya pertenece a otro jugador");
                }
        }
        while (!b2) {
            System.out.println("Ingrese el numero de camiseta deseado");
            cam=sc.nextInt();
            if (veriCamiseta(eqJug, cam)) {
                    System.out.println("la camiseta ya existe, ingrese otra");
                } else {
                    b2=true;
                }
        }
        unJugador=new jugador(apellido, nombre, edad, dni, cam, suEquipo, 0);
        return unJugador;
    } 
    
    public static boolean veriDni(int dni, jugador[] arrJug){
        int i=0;
        boolean b1=true;
        while (b1 && arrJug[i]!=null) {
            if (dni==arrJug[i].getDni()) {
                b1=false;
            }else{
                i++;
            }
        }
        return b1;
    }

    public static boolean veriEquipo(String team,equipo[] arrEquipos){
        boolean b1=false;
        int i=0;
        while (!b1 && i<arrEquipos.length) {
            b1=team.equalsIgnoreCase(arrEquipos[i].getNombre());
            i++;
            }
        
        return b1;
    }


}