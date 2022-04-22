
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
        //Instancia de la clase number
        Number number = new Number();
        Scanner scanner = new Scanner(System.in);
        
        boolean end = true;
        String path="";
        do {            
            System.out.println("-------- Bienvenido al challenge --------");
            System.out.println("1 - Crear archivo");
            System.out.println("2 - Leer archivo actual");
            System.out.println("3 - Ordenar números actuales y almacenar");
            System.out.println("4 - Buscar número en archivo");
            System.out.println("5 - Salir");
            System.out.println("7 - Ordenar números");
            String op = scanner.nextLine();
            System.out.println("opcion: "+op);

            switch (Integer.parseInt(op)) {
                case 1:
                    System.out.println("------ Ingrese la cantidad de números a generar ------");
                    String sizeNumber = scanner.nextLine();
                    List currentList=number.randomNumber(Integer.parseInt(sizeNumber));
                    //Se guarda la lista actual en la instancia number, recibiendo la lista como parámetro
                    number.setListNumber(currentList);
                    System.out.println("------ Ingrese el nombre del archivo a crear ------");
                    path =number.createFile(scanner.nextLine());
                    number.writeFile(path, currentList);
                    break;
                case 2:
                    number.readFile(path);
                    break;
                case 3:
                    number.orderNumbers();
                    System.out.println("------ Ingrese el nombre del archivo a crear ------");
                    //String name = scanner.nextLine();
                    path =number.createFile(scanner.nextLine());
                    number.writeFile(path, number.getListNumber());
                    break;
                case 4:
                    System.out.println("------ Ingrese el número a buscar -------");
                    String find=scanner.nextLine();
                    number.searchNumber(Integer.parseInt(find),path);
                    break;
                case 5:
                    end=false;
                    System.out.println("------ finalizado -------");
                    break;       
                case 6:
                    break;
                //case 6:
                //    System.out.println("------ Ingrese el nombre del archivo a crear ------");
                //    String name = scanner.nextLine();
                //   path =number.createFile(name);
                //    break;
                case 7:
                    number.showNumbers();
                    break;
                case 8:
                    
                    break;
                default:
                    throw new AssertionError();
                }
        } while (end);
        
    }
    
}
