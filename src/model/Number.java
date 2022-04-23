package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;



public class Number{
    
    private List<Integer> listNumber;
    
    public Number(){
        this.listNumber=new ArrayList<Integer>();
    }
    
    public Number(List<Integer> listNumber) {
        this.listNumber = listNumber;
    }

    public List<Integer> getListNumber() {
        return listNumber;
    }

    public void setListNumber(List<Integer> listNumber) {
        this.listNumber = listNumber;
    }
    
    public List<Integer> randomNumber(int number) {
        Random random = new Random();
        
        List<Integer> randomList = new ArrayList<Integer>();
        
        //Ciclo for se encarga de rellenar la lista con números aleatorios del 0 al número ingresado
        for (int i = 0; i < number; i++) {
            randomList.add(random.nextInt(number));
        }
        
        return randomList;
    }

    public void orderNumbers() {
        getListNumber().sort(Comparator.naturalOrder());
        
    }

    public boolean searchNumber(int number,String path) {
        
        boolean result=false;
        
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            List<Integer> listNumber = new ArrayList<Integer>();
            //Leer archivo
            String line=br.readLine();
            
            //Arreglo de string eliminando espacios y []
            String[] arrString = line.replaceAll("\\[", "").replaceAll("]", "").replace(" ", "").split(",");
            
            //Parsear string a entero y pasarlo a la lista
            for (int i = 0; i < arrString.length; i++) {
                listNumber.add(Integer.parseInt(arrString[i]));
            }
            
            result=listNumber.contains(number);
        } catch (Exception err) {
            System.out.println("Error al leer el archivo "+err); 
        }        
        
        return result;
    }
    
    public String createFile(String name){
        
        File file = new File(name+".txt");
        String path="";
        try {
            if(file.createNewFile()){
                path=file.getCanonicalPath();
            }
        } catch (Exception err) {
            System.out.println("Error al crear el archivo "+err); 
        };
        return path;
        
    };
    
    public String readFile(String path){
        
        String result="";
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            
            String line = br.readLine();    
            result=line;
        } catch (Exception err) {
            System.out.println("Error al leer el archivo "+err); 
        }
        
        return result;
    };
    
    public void writeFile(String path,List list){
        
        try{
            FileWriter fw = new FileWriter(path);
            fw.write(list.toString());
            fw.close();
        }catch(Exception err){
            System.out.println("Error al escribir en el archivo "+err); 
        }
    };
    
}
