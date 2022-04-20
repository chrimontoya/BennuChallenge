/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


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
    public void searchNumber(int number) {

        int size = getListNumber().size();
        boolean find = false;
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if(getListNumber().get(i)==number){
                counter++;
            };
        }
        System.out.println("Existe: "+getListNumber().contains(number));
        System.out.println("Ocurrencias: "+counter);
    }

    @Override
    public void showNumbers() {
        System.out.println("Lista de números: "+getListNumber());
    }
    
}
