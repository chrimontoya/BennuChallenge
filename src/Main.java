
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Christian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<Integer> listNumber = new ArrayList<Integer>();
        Number number = new Number();
        Scanner scanner = new Scanner(System.in);
       
        boolean end = true;
        do {            
            System.out.println("-------- Bienvenido al challenge --------");
            System.out.println("1 - Generar números aleatorios");
            System.out.println("2 - Ordenar números");
            System.out.println("3 - Buscar números");
            System.out.println("4 - Mostrar números");
            System.out.println("5 - Salir");
            System.out.println(" Ingrese una opción: ");
            String op = scanner.nextLine();
            System.out.println("opcion: "+op);

            switch (op) {
                case "1":
                    System.out.println("------ Ingrese la cantidad de números a generar ------");
                    String sizeNumber = scanner.nextLine();
                    List currentList =number.randomNumber(Integer.parseInt(sizeNumber));
                    //Se guarda la lista actual en la instancia Number, recibiendo la lista como parámetro
                    number.setListNumber(currentList);
                    break;
                case "2":
                    number.orderNumbers();
                    break;
                case "3":
                    System.out.println("Ingrese el número a buscar");
                    String find=scanner.nextLine();
                    number.searchNumber(Integer.parseInt(find));
                    break;
                case "4":
                    number.showNumbers();
                    break;
                case "5":
                    end=false;
                    System.out.println("------ finalizado -------");
                    break;        
                default:
                    throw new AssertionError();
                }
        } while (end);
        
    }
    
}
