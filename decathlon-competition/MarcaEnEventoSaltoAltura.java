/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.etsetb.poo.decathlon1.dominio;

/**
 *
 * @author jonar
 */
public class MarcaEnEventoSaltoAltura extends MarcaEnEventoDeCampo{
    
    public static double A = 0.8465;
    public static double B = 75;
    public static double C = 1.42;
    
    public MarcaEnEventoSaltoAltura (double marca){
        super(marca);
        super.calcularPuntosEvento(this.A, this.B, this.C, marca);
    }
    
    @Override
    public String toString(){
        String s = "";
        s+= "Salto de altura: ";
        s+="marca="+marca+" centimetros";
        if(puntos>0){
            s+=", puntos="+puntos;
        }
        return s+"\n";
    }
    
}
