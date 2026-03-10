package edu.upc.etsetb.poo.decathlon1.dominio;


/**
 * Clase para gestionar la información de un atleta
 * 
 */
public class Atleta {

    private final int numInscripcion;
    private final String nombre;
    private final String nacionalidad;
    private int puntos;
    private final MarcaEnEvento[] marcas;

    /**
     * Método constructor de la clase
     *
     * @param nombre Nombre cel atleta
     * @param nacionalidad Nacionalidad
     * @param numInscripcion Número de inscripción.
     */
    public Atleta(String nombre, String nacionalidad, int numInscripcion) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.numInscripcion = numInscripcion;
        this.puntos = 0; //imicialmente hay 0 puntos en cada atleta
        this.marcas = new MarcaEnEvento[5]; //hay 5 eventos en los que participa el atleta
    }

    /**
     * Método getter. Devuelve el número de inscripción.
     *
     * @return Devuelve el número de inscripción.
     */
    public int getNumInscripcion() {
        return this.numInscripcion;
    }

    /**
     * Método getter. Devuelve el nombre del atleta.
     *
     * @return Devuelve el nombre del atleta.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Método getter. Devuelve la nacionalidad del atleta.
     *
     * @return Devuelve la nacionalidad del atleta.
     */
    public String getNacionalidad() {
        return this.nacionalidad;
    }

    /**
     * Método getter. Devuelve la suma de los puntos obtenidos por el atleta en
     * las diferentes pruebas en las que ha participado.
     *
     * @return Devuelve la suma de los puntos obtenidos por el atleta (el valor 
     * del atributo puntos).
     */
    public int getPuntos() {
        return this.puntos;
    }

    /**
     * Crea una nueva MarcaEnEvento, la añade en la posición evento del vector
     * marcas, calcula los puntos correspondientes a ese evento para este atleta
     * y recalcula los puntos totales del atleta.
     *
     * @param evento el evento en el que el atleta ha conseguido la marca
     * @param marca la marca conseguida por el atleta
     */
    public void anyadirMarcaEnEvento(int evento, double marca) throws MarcaNegativaException {
        // https://en.wikipedia.org/wiki/Decathlon#Benchmarks
        
        
        
        /*MarcaEnEvento aux = new MarcaEnEvento(evento, marca);
        //pasamos los parámetros al constructor de MarcaEnEvento para poder usar
        //las variables this.marcas en las funciones calcularPuntosEvento()
        //y en la funcion calcularPuntos()
        this.marcas[evento] = aux;
        aux.calcularPuntosEvento();
        calcularPuntos();*/
        
        //throw new UnsupportedOperationException("Atleta::anyadirMarcaEnEvento(...) NO se ha implementado");
        
        if (marca<0){
            throw new MarcaNegativaException ("ERROR: marca negativa");
        }
        
        switch (evento){
            case MarcaEnEvento.CIEN_METROS:
                marcas[evento] = new MarcaEnEvento100m (marca);
                break;
            case MarcaEnEvento.SALTO_DE_LONGITUD:
                marcas[evento] = new MarcaEnEventoSaltoLongitud (marca);
                break;
            case MarcaEnEvento.LAZAMIENTO_DE_PESO:
                marcas[evento] = new MarcaEnEventoLanzamientoPeso (marca);
                break;
            case MarcaEnEvento.SALTO_DE_ALTURA:
                marcas[evento] = new MarcaEnEventoSaltoAltura (marca);
                break;
            case MarcaEnEvento.CUATROCIENTOS_METROS:
                marcas[evento] = new MarcaEnEvento400m (marca);
                break;
        }
        calcularPuntos();
    }

    /**
     * Recalcula los puntos totales obtendos por el atleta hasta el momento.
     */
    public void calcularPuntos() {
        /*this.puntos = 0;
        
        for (MarcaEnEvento marca: marcas){
            int res = marca.calcularPuntosEvento();
            if (res == MarcaEnEvento.CALCULO_EVENTO_OK){
                this.puntos += marca.getPuntos();
            }
            else{
                System.out.println ("ERROR");
            } 
        }*/
        this.puntos = 0;
        
        for (MarcaEnEvento marca: marcas){
            if (marca != null){
                this.puntos += marca.getPuntos();
            }
            else{
                System.out.println ("ERROR");
            } 
        }
        
    }

    /**
     * Método toString() de la clase.
     *
     * @return String con la información del atleta. A continuación se muestra
     * un ejemplo de su contenido:<br><br>
     * Número de inscripción: 1<br>
     * Nombre: Pepe Pérez<br>
     * Nacionalidad:ES<br>
     * 100 metros lisos:     marca=11.278 segundos, puntos=800<br>
     * Salto de longitud:    marca=694.0 centimetros, puntos=799<br>
     * Lanzamiento de peso:  marca=15.16 metros, puntos=800<br>
     * Salto de altura:      marca=199.0 centimetros, puntos=794<br>
     * 400 metros lisos:     marca=50.32 segundos, puntos=800<br>
     * <br>
     * Puntos totales: 3993<br>
     * 
     */
    @Override
    public String toString() {
        String texto = "Numero de inscripcion: "+ this.numInscripcion + "\nNombre: " + this.nombre + "\nNacionalidad: " + this.nacionalidad + "\n";
        for (MarcaEnEvento marca: marcas){
            texto+= marca.toString();
        }
        
        this.calcularPuntos(); //calculamos los puntos de este atleta
        //por como es el método, se asignan en this.puntos que la
        //usaremos a continuación
        
        texto += "\nPuntos totales: " + this.puntos + "\n";
        return texto;
    }
}
