/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.etsetb.poo.decathlon1.dominio;

/**
 *
 * @author jonar
 */
public class MarcaEnEvento400m extends MarcaEnEventoDePista{
    
    public static double A = 1.53775;
    public static double B = 82;
    public static double C = 1.81;

    /**
     *
     * @param marca
     */
    public MarcaEnEvento400m (double marca){
        super(marca);
        super.calcularPuntosEvento(this.A, this.B, this.C, marca);

        //throw new UnsupportedOperationException("MarcaEnEvento::Constructor(...) NO se ha implementado");
        //NUEVO
    }
    
    @Override
    public String toString(){
        String s = "";
        s+="400 metros lisos: ";
        s+="marca="+marca+" segundos";
        if (puntos>0){
            s+="puntos="+puntos;
        }
        return s+"\n";
        //NUEVO
    }

    
}
