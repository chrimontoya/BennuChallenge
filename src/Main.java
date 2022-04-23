
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import view.WindowMenu;
import model.Number;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Christian
 *//**
 *
 * @author Christian
 */
public class Main {
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Instancia de la clase number
        Number number = new Number();
        Scanner scanner = new Scanner(System.in);
        
        boolean end = true;
        String path="";
        int result=JOptionPane.showConfirmDialog(null, "¿Desea utilizar interfaz gráfica?");
        
            if(JOptionPane.OK_OPTION==result){
                WindowMenu vn = new WindowMenu();
                vn.setVisible(true);
            }else{
                do {            
                System.out.println("-------- Bienvenido al challenge --------");
                System.out.println("1 - Generar archivo");
                System.out.println("2 - Leer archivo actual");
                System.out.println("3 - Ordenar números actuales y almacenar en nuevo archivo");
                System.out.println("4 - Buscar número en archivo actual");
                System.out.println("5 - Salir");
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
                        String nameFile = scanner.nextLine();
                        path =number.createFile(nameFile);
                        number.writeFile(path, currentList);
                        System.out.println("Se ha creado el archivo "+nameFile+" en la ruta: "+path);
                        System.out.println("------ Escritura completada ------");
                        break;
                    case 2:
                        System.out.println("El archivo actual contiene: "+number.readFile(path));;
                        break;
                    case 3:
                        number.orderNumbers();
                        System.out.println("------ Ingrese el nombre del archivo a crear ------");
                        //String name = scanner.nextLine();
                        path=number.createFile(scanner.nextLine());
                        number.writeFile(path, number.getListNumber());
                        System.out.println("Lista ordenada");
                        break;
                    case 4:
                        System.out.println("------ Ingrese el número a buscar -------");
                        String find=scanner.nextLine();
                        System.out.println("Valor encontrado: "+number.searchNumber(Integer.parseInt(find),path));
                        break;
                    case 5:
                        end=false;
                        System.out.println("------ finalizado -------");
                        break;  
                    }
                } while (end);
            }
        
        
    }
    
}
