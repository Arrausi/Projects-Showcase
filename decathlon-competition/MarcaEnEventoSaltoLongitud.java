package edu.upc.etsetb.poo.decathlon1.dominio;

/**
 *
 */
public class MarcaEnEventoSaltoLongitud extends MarcaEnEventoDeCampo{
    
    public static double A = 0.14354;
    public static double B = 220;
    public static double C = 1.40;
    
    /**
     *
     * @param marca
     */
    public MarcaEnEventoSaltoLongitud (double marca){
        super(marca);
        super.calcularPuntosEvento(this.A, this.B, this.C, marca);

        //throw new UnsupportedOperationException("MarcaEnEventoSaltoLongitud::Constructor(...) NO se ha implementado");
    }
    
    @Override
    public String toString(){
        String s = "";
        s+= "Salto de longitud: ";
        s+="marca="+marca+" centimetros";
        if(puntos>0){
            s+=", puntos="+puntos;
        }
        return s+"\n";
        //throw new UnsupportedOperationException("MarcaEnEventoSaltoLongitud::toString(...) NO se ha implementado");
    }
    
}


