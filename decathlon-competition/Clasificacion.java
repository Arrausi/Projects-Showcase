package edu.upc.etsetb.poo.decathlon1.dominio;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Clase para gestionar la clasificación; solo mostrará, ordenados, un número 
 * determinado de atletas (que puede ser diferente al número de participantes) pasado 
 * como argumento al constructor.
 */
public class Clasificacion {

    private final int numAtletas;
    private final LinkedList<Atleta> atletas;

    /**
     * Método constructor de la clase. Se le pasa el número de atletas que
     * tendrá la clasificación y crea la lista , de momento vacia, de atletas.
     *
     * @param numAtletas El número de atletas que se incluirán en el String 
     * que devolverá el método toString().
     */
    public Clasificacion(int numAtletas) {
        this.numAtletas = numAtletas;
        this.atletas = new LinkedList <>();
    }

    /**
     * Añade ordenadamente el atleta a a la clasificación (de acuerdo a los
     * puntos totales dek atleta) y, si el número de atletas en la
     * clasificación ya supera el guardado en el atributo numAtletas, elimina
     * el atleta con menos puntos. De este modo, si se crea una clasificación y
     * se van añadiendo todos los atletas utilizando este método, al final
     * quedarán los numAtletas con mejor puntuación ordenados por dicha
     * puntuación.
     *
     * @param a El atleta añadir a la clasificación
     */
    public void anyadirAClasificacion(Atleta a) {
        /*
        atletas.add((int) a.getPuntos(), a);
        */
        int k=0;
                
        Iterator <Atleta> it = atletas.iterator();
        while (it.hasNext() && a.getPuntos() < it.next().getPuntos()){
            k++;
        }
        
        this.atletas.add (k, a);
        
        if (this.atletas.size()>numAtletas){
                this.atletas.remove (this.atletas.size()-1);
        }
        
        //throw new UnsupportedOperationException("Clasificacion::anyadirAClasificacion(...) NO se ha implementado");
    }

    /**
     * Método toString() de la clase.
     *
     * @return Devuelve la clasificación con, para cada atleta, número de
     * clasificación, nacionalidad y nombre; a continuación se muestra un 
     * ejemplo si el valor del atributo numAtletas es 5:<br>
     * 1 ALG Larbi Bourrada<br>
     * 2 KAZ Dmitriy Karpov<br>
     * 3 FRA Kevin Mayer<br>
     * 4 USA Ashton Eaton<br>
     * 5 AUS Ashley Moloney<br>
     */
    @Override
    public String toString() {
        /*
        StringBuilder sb = new StringBuilder();
        int pos = 1;
        for (Atleta atleta : atletas) {
            sb.append(pos++)
              .append(" ")
              .append(atleta.getNacionalidad())
              .append(" ")
              .append(atleta.getNombre())
              .append("\n");
        }
        return sb.toString();
        */
        
        String s = "";
        int num = 1;
        
        if (this.numAtletas<=0){
            return "NO HAY ATLETAS";
        }
        
        Iterator <Atleta> it = this.atletas.iterator();
        
        while (it.hasNext() && num<=numAtletas){
            Atleta aux = it.next();
            if (num == numAtletas){
                s+= num+ " " + aux.getNacionalidad()+ " " + aux.getNombre();
                //evitamos el \n en caso de que sea el ultimo atleta
            }
            else{
                s+= num+ " " + aux.getNacionalidad()+ " " + aux.getNombre()+"\n";
                num++;
            }
        }
        
        //throw new UnsupportedOperationException("Clasificacion::toString(...) NO se ha implementado");
        return s;
    }

}
