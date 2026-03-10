/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.etsetb.poo.decathlon1.dominio;

/**
 *
 */
public class MarcaEnEvento100m extends MarcaEnEventoDePista{
    public static double A = 25.4347;
    public static double B = 18;
    public static double C = 1.81;
    
    /**
     *
     * @param marca
     */
    public MarcaEnEvento100m (double marca){
        super(marca);
        super.calcularPuntosEvento(this.A, this.B, this.C, marca);
        //throw new UnsupportedOperationException("MarcaEnEvento100m::Constructor(...) NO se ha implementado");
    }
    
    @Override
    public String toString(){
        String s = "";
        s+="100 metros lisos: ";
        s+="marca="+marca+" segundos";
        if (puntos>0){
            s+="puntos="+puntos;
        }
        return s+"\n";
    }
    
}

