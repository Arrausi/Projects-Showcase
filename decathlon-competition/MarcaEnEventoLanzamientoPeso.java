package edu.upc.etsetb.poo.decathlon1.dominio;

/**
 *
 */
public class MarcaEnEventoLanzamientoPeso extends MarcaEnEventoDeCampo{
    
    public static double A = 51.39;
    public static double B = 1.5;
    public static double C = 1.05;
    
    /**
     *
     * @param marca
     */
    public MarcaEnEventoLanzamientoPeso (double marca){
        super(marca);
        super.calcularPuntosEvento(this.A, this.B, this.C, marca);
        //throw new UnsupportedOperationException("MarcaEnEventoLanzamientoPeso::Constructor(...) NO se ha implementado");
    }
    
    @Override
    public String toString(){
        String s = "";
        s+= "Lanzamiento de peso: ";
        s+="marca="+marca+" centimetros";
        if(puntos>0){
            s+=", puntos="+puntos;
        }
        return s+"\n";

        //throw new UnsupportedOperationException("MarcaEnEventoLanzamientoPeso::toString(...) NO se ha implementado");
    }
    
}


