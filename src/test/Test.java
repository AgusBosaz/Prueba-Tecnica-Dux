package test;

import entities.PartidoEntity;

import java.util.Scanner;
import service.PartidoService;

public class Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String salir = "";

        PartidoService partidoService = new PartidoService();

        PartidoEntity p1 = partidoService.nombres();
        
        
        // con el bucle while podemos hacer la pregunta si quiere revancha o no
        // asi ejecutamos solamente la parte del paritdo, sin tener que llenar los campos de nuevo
        while (!salir.equalsIgnoreCase("n")) {

            partidoService.partido(p1);
            partidoService.sets(p1);

            System.out.println("Desea jugar la revancha? S/N");
            salir = sc.next();
        }
    }

}
