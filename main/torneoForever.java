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
        m = longArrJug();// misma idea,pero para jugadores

        equipo[] arrTeams = new equipo[n];
        ;
        jugador[] arrJugadores = new jugador[m];

        cargarEquipos(arrTeams);
        cargarJugadores(arrJugadores);

        System.out.println();
        System.out.println("TORNEO FOREVER");
        System.out.println();
        System.out.println("los encuentros son los siguientes: ");
        System.out.println("___________________________________");
        generateFixture(arrTeams);

        // for (int i = 0; i < arrJugadores.length; i++) {
        //     System.out.println("jugador: " + (i + 1));
        //     System.out.println("nombre: " + arrJugadores[i].getNombreJugador() + " " + arrJugadores[i].getApellido()
        //             + " Numero de camiseta: " + arrJugadores[i].getCamiseta());
        //     System.out.println("dni: " + arrJugadores[i].getDni() + " edad: " + arrJugadores[i].getEdad());
        //     System.out.println("Equipo: " + arrJugadores[i].getEquipo());
        //     System.out.println("---------------------------------------------------------------------");
        // }
        // for (int j = 0; j < arrTeams.length; j++) {
        //     System.out.println(arrTeams[j].getNombre());
        //     System.out.println("---------------------------------------------------------------------");
        // }

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
            opc = sc.nextInt();
            switch (opc) {
                case 1:
                    generateFixture(arrTeams);
                    break;
                // case 2:
                // resultadosFecha;
                // break;
                // case 3:
                // addJug;
                // break;
                // case 4:
                // posEquipos;
                // break;
                // case 5:
                // resFecha;
                // break;
                // case 6:
                // goleadores;
                // break;
                // case 7:
                // stats;
                // break;
                // case 8:
                // listJug;
                // break;
            }
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

    public static void generateFixture(equipo[] teams) {
        int cantEquipos = teams.length;

        /* Calculo cantidad de Fechas y cantidad de partidos por fecha */
        int cantFechas = cantEquipos - 1;
        int partidosPorFecha = cantEquipos / 2;

        /* Creo una matriz */
        String[][] rounds = new String[cantFechas][partidosPorFecha];

        for (int fecha = 0; fecha < cantFechas; fecha++) {
            for (int partido = 0; partido < partidosPorFecha; partido++) {
                int local = (fecha + partido) % (cantEquipos - 1);
                int visitante = (cantEquipos - 1 - partido + fecha) % (cantEquipos - 1);

                if (partido == 0) {
                    visitante = cantEquipos - 1;
                }
                String loc = teams[local].getNombre();
                String vis = teams[visitante].getNombre();
                rounds[fecha][partido] = loc + " : " + vis;
            }
        }

        // imprimo la matriz
        printRounds(rounds);
    }

    public static void printRounds(String[][] rounds) {
        for (int i = 0; i < rounds.length; i++) {
            System.out.println("Jornada " + (i + 1));
            for (int j = 0; j < rounds[i].length; j++) {
                System.out.println(rounds[i][j]);
            }
            System.out.println("-----------------------------");
        }
    }

    public static void cargarJugadores(jugador[] arrJug) {
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
            lector.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + " No existe el archivo");
        } catch (IOException ex) {
            System.out.println("Error de lectura del archivo");
        }
    }

    public static jugador cargJug(String linea) {
        jugador jug = new jugador("", "", 0, 0, 0, "");
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
            jug = new jugador(nombre, apellido, edad, dni, camiseta, suEquipo);
        }
        return jug;
    }

    public static boolean veriEquipo(String Team, String Jug) {
        boolean b1 = false;
        if (Team.compareTo(Jug) == 0) {
            b1 = true;
        } else {
            b1 = false;
        }
        return b1;
    }
}