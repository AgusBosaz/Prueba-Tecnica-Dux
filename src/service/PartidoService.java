package service;

import entities.PartidoEntity;
import java.util.Random;
import java.util.Scanner;
import static service.PartidoService.partido;

public class PartidoService {

    Scanner sc = new Scanner(System.in);

    public PartidoEntity nombres() {

        //instanciamos el objeto
        PartidoEntity nombres = new PartidoEntity();

        //llenamos los atributos
        System.out.println("Ingrese el nombre del primer tenista.");
        nombres.setPlayer1(sc.next());
        System.out.println("Ingrese el nombre del segundo tenista.");
        nombres.setPlayer2(sc.next());
        sc.nextLine();
        System.out.println("Ingrese el nombre del torneo.");
        nombres.setNombreTorneo(sc.nextLine());
        
        // Validamos que ingrese 3 o 5 solamente
        do {
            System.out.println("Ingrese la cantidad de Sets. Indicar si son 3 o 5 sets.");
            nombres.setCantidadSets(sc.nextInt());

        } while (!nombres.getCantidadSets().equals(3) && !nombres.getCantidadSets().equals(5));

        System.out.println("Ingrese las posibilidades de ganar del primer tenista.");
        nombres.setProbabilidadPlayer1(sc.nextDouble());
        System.out.println("Ingrese las posibilidades de ganar del segundo tenista.");
        nombres.setProbabilidadPlayer2(sc.nextDouble());

        // retornamos el objeto
        return nombres;
    }

    public static boolean partido(PartidoEntity nombres) {
        Random random = new Random();
        int saque = random.nextInt(2);

        int marcadorJug1 = 0;
        int marcadorJug2 = 0;
        String puntosJug1 = "0";
        String puntosJug2 = "0";

        boolean ganador = true;
        boolean finJuego = false;

        while (finJuego != true) {

            // Con el random vamos a saber quien gana el punto
            int golpe = random.nextInt(2);

            String marcadorPuntos = "";

            
            if (golpe == 0) {
                marcadorJug1 = marcadorJug1 + 1;
                System.out.println(nombres.getPlayer1() + " gana el punto ");

                if ((marcadorJug1 > 3) && (Math.abs(marcadorJug1 - marcadorJug2) > 1)) {
                    System.out.println("");
                    System.out.println(nombres.getPlayer1() + " gana el game");
                    System.out.println("");
                    marcadorJug1 = 0;
                    marcadorJug2 = 0;
                    ganador = true;
                    finJuego = true;

                }
            }
            
            if (golpe == 1) {
                marcadorJug2 = marcadorJug2 + 1;
                System.out.println(nombres.getPlayer2() + " gana el punto ");
                if ((marcadorJug2 > 3) && (Math.abs(marcadorJug2 - marcadorJug1) > 1)) {
                    System.out.println("");
                    System.out.println(nombres.getPlayer2() + " gana el game");
                    System.out.println("");
                    marcadorJug1 = 0;
                    marcadorJug2 = 0;
                    ganador = false;
                    finJuego = true;

                }
            }
            
            // Dependiendo de la variable imprimimos el numero de punto
            if (marcadorJug1 == 1) {
                puntosJug1 = "15";

                marcadorPuntos = puntosJug1 + " - " + puntosJug2;

            }
            if (marcadorJug1 == 2) {
                puntosJug1 = "30";

                marcadorPuntos = puntosJug1 + " - " + puntosJug2;

            }
            if (marcadorJug1 == 3) {
                puntosJug1 = "40";

                marcadorPuntos = puntosJug1 + " - " + puntosJug2;

            }
            if (marcadorJug2 == 1) {
                puntosJug2 = "15";

                marcadorPuntos = puntosJug2 + " - " + puntosJug1;

            }
            if (marcadorJug2 == 2) {
                puntosJug2 = "30";

                marcadorPuntos = puntosJug2 + " - " + puntosJug1;

            }
            if (marcadorJug2 == 3) {
                puntosJug2 = "40";

                marcadorPuntos = puntosJug2 + " - " + puntosJug1;

            }
            if (marcadorJug1 == 3 && marcadorJug2 == 3 && marcadorJug1 == marcadorJug2) {
                marcadorPuntos = "Deuce";

            }
            if (marcadorJug1 > 3 && marcadorJug1 > marcadorJug2) {
                puntosJug1 = "";
                puntosJug2 = "";
                marcadorPuntos = "Ventaja " + nombres.getPlayer1();
            }
            if (marcadorJug2 > 3 && marcadorJug2 > marcadorJug1) {
                puntosJug1 = "";
                puntosJug2 = "";
                marcadorPuntos = "Ventaja " + nombres.getPlayer2();
            }
            System.out.println(marcadorPuntos);
        }
        return ganador;
    }

    public static void sets(PartidoEntity nombres) {

        int juegosJug1 = 0;
        int juegosJug2 = 0;
        int setJug1 = 0;
        int setJug2 = 0;
        float sets = nombres.getCantidadSets();
        float set1 = (sets / 2);
        double set = set1 + 0.5;
        boolean finPartido = false;

        System.out.println(set);

        while (!finPartido) {

            boolean resultadoJuego = partido(nombres);

            if (resultadoJuego) {
                juegosJug1 = juegosJug1 + 1;
                System.out.println("Resultado Parcial del game");
                System.out.println(nombres.getPlayer1() + " " + "'" + juegosJug1 + "'");
                System.out.println(nombres.getPlayer2() + " " + "'" + juegosJug2 + "'");
                System.out.println("");
            } else {
                juegosJug2 = juegosJug2 + 1;
                System.out.println("Resultado Parcial del game");
                System.out.println(nombres.getPlayer1() + " " + "'" + juegosJug1 + "'");
                System.out.println(nombres.getPlayer2() + " " + "'" + juegosJug2 + "'");
                System.out.println("");
            }

            if (juegosJug1 == 6 && juegosJug2 == 6) {
                System.out.println("Tie Break");
            }

            if (juegosJug1 >= 6 && (Math.abs(juegosJug1 - juegosJug2) > 1) || juegosJug1 == 7 && juegosJug2 == 6) {
                setJug1 = setJug1 + 1;

                System.out.println("");
                System.out.println(nombres.getPlayer1() + " gana el set por " + "'" + juegosJug1 + " a " + "'" + juegosJug2);
                juegosJug1 = 0;
                juegosJug2 = 0;
                if (setJug1 == set && setJug1 > setJug2) {
                    System.out.println("El ganador del torneo " + nombres.getNombreTorneo() + " es " + nombres.getPlayer1() + " por " + "'" + setJug1 + "'" + " a " + "'" +setJug2 + "'");
                    System.out.println();
                    finPartido = true;
                }

            }
            if (juegosJug2 >= 6 && (Math.abs(juegosJug2 - juegosJug1) > 1) || juegosJug2 == 7 && juegosJug1 == 6) {
                setJug2 = setJug2 + 1;

                System.out.println("");
                System.out.println(nombres.getPlayer2() + " gana el set por " + "'" + juegosJug2 + "'" + " a " + "'" + juegosJug1 + "'");
                juegosJug1 = 0;
                juegosJug2 = 0;

                if (setJug2 == set && setJug2 > setJug1) {
                    System.out.println("El ganador del torneo " + nombres.getNombreTorneo() + " es " + nombres.getPlayer2() + " por " + "'" + setJug2 + "'" + " a " + "'" + setJug1 + "'");
                    System.out.println("");
                    finPartido = true;
                }

            }

        }

    }

}
