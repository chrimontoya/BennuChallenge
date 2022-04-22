/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import java.util.Arrays;


public class Number implements Menu{
    
    private int number;
    private List<Integer> listNumber;
    
    public Number(){
        this.number=0;
        this.listNumber=new ArrayList<Integer>();
    }
    
    public Number(int number, List<Integer> listNumber) {
        this.number = number;
        this.listNumber = listNumber;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Integer> getListNumber() {
        return listNumber;
    }

    public void setListNumber(List<Integer> listNumber) {
        this.listNumber = listNumber;
    }

    @Override
    public String toString() {
        return "Number{" + "number=" + number + ", listNumber=" + listNumber + '}';
    }

    @Override
    public List<Integer> randomNumber(int number) {
        Random random = new Random();
        
        List<Integer> randomList = new ArrayList<Integer>();
        
        //Ciclo for se encarga de rellenar la lista con números aleatorios del 0 al número ingresado
        for (int i = 0; i < number; i++) {
            randomList.add(random.nextInt(number));
        }
        
        return randomList;
    }

    @Override
    public void saveNumbers() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void orderNumbers() {
        getListNumber().sort(Comparator.naturalOrder());
        System.out.println("Lista ordenada");
    }

    @Override
    public void searchNumber(int number,String path) {

        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine().replace(" ", "").replace("[", "").replace("]", "");
            
            for (int i = 0; i < line.length(); i++) {
                System.out.println("ACTUAL : "+line.charAt(i)+"   "+"es igual: "+line.charAt(i)=="2");
            }
            
            System.out.println("Resultado : "+line);
            
            
        } catch (Exception err) {
            System.out.println("Error al leer el archivo "+err); 
        }        
        
    }

    @Override
    public void showNumbers() {
        System.out.println("Lista de números: "+getListNumber());
    }
    
    @Override
    public String createFile(String name){
        
        File file = new File(name+".txt");
        String path="";
        try {
            if(file.createNewFile()){
                path=file.getCanonicalPath();
                System.out.println("Se ha creado el archivo "+name+" en la ruta: "+path);
            }
        } catch (Exception err) {
            System.out.println("Error al crear el archivo "+err); 
        };
        return path;
        
    };
    
    @Override
    public void readFile(String path){
        
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            
            String line = br.readLine();
            System.out.println("El archivo contiene: "+line);
        } catch (Exception err) {
            System.out.println("Error al leer el archivo "+err); 
        }
    };
    
    @Override
    public void writeFile(String path,List list){
        
        try{
            FileWriter fw = new FileWriter(path);
            fw.write(list.toString());
            fw.close();
            System.out.println("------ Escritura completada ------");
        }catch(Exception err){
            System.out.println("Error al escribir en el archivo "+err); 
        }
    };
    
}
