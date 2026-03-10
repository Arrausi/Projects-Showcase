/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.etsetb.poo.decathlon1.dominio;

/**
 *
 */
public abstract class MarcaEnEventoDeCampo extends MarcaEnEvento{
    
    public MarcaEnEventoDeCampo (double marca){
        super (marca);
    }
    
    
    @Override
    public void calcularPuntosEvento (double A, double B, double C, double marca){
        if (marca<0){
            puntos = CALCULO_EVENTO_KO_MARCA_NEGATIVA;
            return;
        }
        
        puntos = (int) (A*Math.pow(marca-B,C));
        
    }
    
}

