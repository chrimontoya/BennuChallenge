/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */


import java.util.List;

public interface Menu {
    
    //Metodo que genera números aleatorios recibiendo el largo por parámetro
    public List<Integer> randomNumber(int number);
    
    //Método que guarda la lista de números en un archivo
    public void saveNumbers();
    
    //Método que ordena los números de una lista
    public void orderNumbers();
    
    //Método que busca un número dentro de un archivo
    public void searchNumber(int number);
    
    //Método que muestra los números de un archivo
    public void showNumbers();
}
