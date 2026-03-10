package edu.upc.etsetb.poo.decathlon1.dominio;

/**
 *
 */
public abstract class MarcaEnEventoDePista extends MarcaEnEvento{
    
    /**
     *
     * @param marca
     */
    public MarcaEnEventoDePista (double marca){
        super(marca);
        //throw new UnsupportedOperationException("MarcaEnEventoDePista::Constructor(...) NO se ha implementado");
    }
    
    @Override
    public void calcularPuntosEvento (double A, double B, double C, double marca){
       if (marca<0){
           puntos = 0;
           return;
       }
        
        puntos = (int) (A*Math.pow (B-marca,C));
        //throw new UnsupportedOperationException("MarcaEnEventoDePista::calcularPuntosEvento(...) NO se ha implementado");
    }
}


