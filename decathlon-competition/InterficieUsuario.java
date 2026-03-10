package edu.upc.etsetb.poo.decathlon1.iu;


import edu.upc.etsetb.poo.decathlon1.casosdeuso.Controlador;
import edu.upc.etsetb.poo.decathlon1.dominio.MarcaNegativaException;
import edu.upc.etsetb.poo.decathlon1.dominio.MarcaEnEvento;
import edu.upc.etsetb.poo.decathlon1.dominio.NoAtletasInscritosException;
import edu.upc.etsetb.poo.decathlon1.dominio.NumInscripcionException;
import edu.upc.etsetb.poo.decathlon1.dominio.NumeroDeAtletasException;
import edu.upc.etsetb.poo.decathlon1.dominio.TipoEventoException;
import java.io.PrintStream;
import java.util.Scanner;


/**
 * La interficie de usuario del programa
 */
/*
 * https://en.wikipedia.org/wiki/Decathlon
 * https://es.wikipedia.org/wiki/Decatl%C3%B3n
 */
public class InterficieUsuario {


    /**
     * Lector utilizado para leer los comandos introducidos por el usuario.
     */
    private Scanner lector;


    /**
     * El controlador.
     */
    private final Controlador controlador;


    /**
     * La consola del sistema. Siempre debe usarse para mostrar la información
     * al usuario.
     */
    private final PrintStream console = System.out;


    /**
     * Separador utilizado en los comandos de entrada.
     */
    public static final String SEPARADOR = ":";


    /**
     * Mensaje de error que notifica que no hay atletas inscritos.
     */
    public static final String NO_ATLETAS_INSCRITOS_STR
            = "ERROR: Aún no hay ningún atleta inscrito.";
    /**
     * Mensaje de error que notifica que el número de atletas es erróneo
     */
    public static final String NUM_ATLETAS_ERRONEO_STR
            = "ERROR: Número de atletas erróneo.";
    /**
     * Mensaje de error que notifica que el número de inscripción es erróneo.
     */
    public static final String NUM_INSCRIPCION_ERRONEO_STR
            = "ERROR: El número de inscripción es erróneo.";


    /**
     * Mensaje de error que notifica que el tipo de evento es erróneo.
     */
    public static final String TIPO_DE_EVENTO_ERRONEO_STR
            = "ERROR: Número de tipo de evento erróneo.";


    /**
     * Mensaje de error que notifica que el comando de entrada es erróneo.
     */
    public static final String CMD_ERRONEO_STR
            = "ERROR: Comando erróneo!";


    /**
     * Mensaje que notifica que la marca se ha añadido correctamente.
     */
    public static final String MARCA_ANYADIDA_STR = "Marca añadida";


    /**
     * Constructor; recibe un string con el nombre de la competición, su fecha y
     * su lugar, y una indicación de si el controlador debe inicializar el grupo
     * de atletas y marcas invocando al método
     * inicializaConAtletasYMarcasIniciales() o no; con esta información crea el
     * objeto Controlador y hace que el atributo 'controlador' lo referencie.
     *
     * @param detallesCompeticion String con nombre, fecha y lugar separados por
     * el caracter ':'
     * @param contrInitAtletasYMarcas true si se desea que el controlador debe
     * inicializar el grupo de atletas y marcas o no.
     * @throws NoAtletasInscritosException si no hay atletas inscritos
     * @throws NumInscripcionException si el número de inscripción es erróneo
     * @throws TipoEventoException si el tipo de evento es erróneo
     * @throws MarcaNegativaException si la marca es negativa
     */
    public InterficieUsuario(String detallesCompeticion, boolean contrInitAtletasYMarcas)
            throws NoAtletasInscritosException, NumInscripcionException, TipoEventoException, MarcaNegativaException {
        String[] partes = detallesCompeticion.split(SEPARADOR);
        String nombre = partes[0];
        String fecha = partes[1];
        String lugar = partes[2];
        this.lector = new Scanner(System.in);
        this.controlador = new Controlador(nombre, fecha, lugar, this, contrInitAtletasYMarcas);
    }


    /**
     * Inscribe un atleta con el nombre y la nacionalidad pasados en la segunda
     * y tercera posición del argumento args (que es un array de Strings).
     *
     * @param args Un array de Strings que en su segunda y tercera posición
     * tiene el nombre y la nacionalidad de un atleta respectivamente.
     */
    public void inscribirAtleta(String[] args) {
        String nombre = args[1];
        String nacionalidad = args[2];
        controlador.inscribirAtleta(nombre, nacionalidad);
    }


    /**
     * Obtiene los datos de la competición y los presenta por pantalla.
     */
    public void mostrarCompeticion() {
        String info = controlador.getInfoCompeticion();
        console.println(info);
    }


    /**
     * A este método se le pasa la representación textual de un número de
     * inscripción en la segunda posición de args (que es un array de Strings) y
     * muestra por consola la información del atleta con ese número de
     * inscripción.
     *
     * @param args Un array de Strings que en su segunda posición
     * tiene la representación textual del número de inscripción.
     */
    public void mostrarAtleta(String[] args) {
        int numInscripcion = Integer.parseInt(args[1]);
       
        try {
            String info = controlador.getInfoAtleta(numInscripcion);
            this.console.println(info);
        } catch(NumInscripcionException ex) {
            this.console.println(ex.getMessage());
        }
    }


    /**
     * A este método se le pasan las representaciones textuales de un número de
     * inscripción, del identificador de un evento y de una marca; con esta
     * información el método añade una marca para un evento en el atleta con ese
     * número de inscripción; si todo va bien, muestra un mensaje que así lo
     * indica por consola; por el contrario, si se da alguna de las situaciones
     * que siguen:<br>
     * no hay ningún atleta inscrito,<br>
     * el número de inscripción es erróneo,<br>
     * el identificador del evento es erróneo.<br>
     * El método muestra por consola un mensaje indicativo del error encontrado.
     * Debéis utilizar las constantes de tipo String de la clase
     * InterficieUsuario para ello.
     *
     * @param args Las representaciones textuales: del número de inscripción,
     * del identificador de un evento y de una marca, en la segunda, tercera y
     * cuarta posición del array args, respectivamente.
     */
    public void anyadirMarcaEnEventoDeUnAtleta(String[] args) {
        int numInscripcion = Integer.parseInt(args[1]);
        int evento = Integer.parseInt(args[2]);
        double marca = Double.parseDouble(args[3]);
       
        try {
            controlador.anyadirMarcaEnEventoDeUnAtleta(numInscripcion, evento, marca);
            this.console.println("Marca añadida");
        } catch (NoAtletasInscritosException | NumInscripcionException | TipoEventoException | MarcaNegativaException ex) {
            this.console.println(ex.getMessage());
        }
    }


    /**
     * A este argumento se le pasa la representación textual de un número entero
     * en la segunda posición de args (que es un array de Strings); con ese
     * valor, el método muestra la clasificación de N atletas por consola,
     * siendo N el número representado en args; por el contrario, muestra un
     * mensaje de error si:<br>
     * Aún no hay ningún atleta inscrito,<br>
     * El número de atletas que se quiere que aparezca en la clasificación es
     * erróneo (menor que 1 o mayor que el número de atletas compitiendo).
     *
     * @param args Los argumentos del comando.
     */
    public void mostrarClasificacion(String[] args) {
        int numAtletas = Integer.parseInt(args[1]);
        try{
            
            String clasificacion = controlador.getClasificacion(numAtletas);
            this.console.println(clasificacion);
        }
       
        catch (NoAtletasInscritosException ex){
            this.console.println(NO_ATLETAS_INSCRITOS_STR);
        }
        catch (NumeroDeAtletasException ex){
            this.console.println(NUM_ATLETAS_ERRONEO_STR);
        }
    }
   
    /**
     * Inicializa atletas y sus marcas a partir del archivo de nombre
     * atletasymarcas.txt que deberéis depositar dentro del directorio del
     * proyecto NetBeans; el método crea un objeto Scanner para leer desde
     * el archivo, lee los datos pertinentes y va invocando a los métodos
     * Controlador::inscribirAtleta(...) y Controlador::anyadirMarcaEnEventoDeUnAtleta(...)
     *
     * @throws FileNotFoundException si no se encuentra el archivo
     * @throws NoAtletasInscritosException si no hay atletas inscritos
     * @throws NumInscripcionException si el número de inscripción es erróneo
     * @throws TipoEventoException si el tipo de evento es erróneo
     * @throws MarcaNegativaException si la marca es negativa
     */


    /**
     * Presenta por consola el menú del programa.
     */
    public void mostrarOpciones() {
        console.println("Opciones:\n");
        console.println("    ay                             Ayuda\n");
        console.println("    ia:nombre:nacionalidad         Inscribir atleta\n");
        console.println("    mc                             Mostrar datos de la competición\n");
        console.println("    ma:num_atleta                  Mostrar datos de un atleta\n");
        console.println("    am:num_atleta:num_evento:marca Añadir marca de un evento a un atleta\n");
        console.println("    cl:num_atletas                 Mostrar clasificación\n");
        console.println("    fi                             Fin\n");
        console.println(MarcaEnEvento.getListaEventos());
    }


    /**
     * Este método recibe un comando y lo ejecuta. Si el comando pasado como
     * parámetro es erróneo, el método debe indicarlo mediante un mensaje.
     * Utilizad la constante de tipo String definida en la clase para ello.
     *
     * @param comando String con el comando.
     * @throws NoAtletasInscritosException si no hay atletas inscritos
     * @throws NumeroDeAtletasException si el número de atletas es erróneo
     */
    public void ejecutaComando(String comando)
            throws NoAtletasInscritosException, NumeroDeAtletasException {
        String[] args = comando.split(SEPARADOR);
       
        if (args.length == 0 || args[0].isEmpty()) {
            console.println(CMD_ERRONEO_STR);
            return;
        }
       
        String cmd = args[0].toLowerCase();
       
        switch (cmd) {
            case "ay":
                if (args.length == 1) {
                    mostrarOpciones();
                    return;
                }
                break;
            case "ia":
                if (args.length == 3) {
                    inscribirAtleta(args);
                    return;
                }
                break;
            case "mc":
                if (args.length == 1) {
                    mostrarCompeticion();
                    return;
                }
                break;
            case "ma":
                if (args.length == 2) {
                    mostrarAtleta(args);
                    return;
                }
                break;
            case "am":
                if (args.length == 4) {
                    anyadirMarcaEnEventoDeUnAtleta(args);
                    return;
                }
                break;
            case "cl":
                if (args.length == 2) {
                    mostrarClasificacion(args);
                    return;
                }
                break;
            case "fi":
                if (args.length == 1) {
                    return;
                }
                break;
        }
       
        console.println(CMD_ERRONEO_STR);
    }


    /**
     * Muestra el menú y va pidiendo y ejecutando los comandos que el usuario va
     * introduciendo hasta que se introduce el comando de acabar la ejecución
     * del programa.
     *
     * @throws NoAtletasInscritosException si no hay atletas inscritos
     * @throws NumeroDeAtletasException si el número de atletas es erróneo
     */
    public void start() throws NoAtletasInscritosException, NumeroDeAtletasException {
        this.lector = new Scanner(System.in);
        boolean continuar = true;


        while (continuar) {
            console.println("Entra un comando: ");
            String comando = lector.nextLine();


            if (comando.equalsIgnoreCase("fi")) {
                continuar = false;
            } else {
                ejecutaComando(comando);
            }
        }
    }
}

