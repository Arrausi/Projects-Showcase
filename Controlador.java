package edu.upc.etsetb.poo.decathlon1.casosdeuso;

import edu.upc.etsetb.poo.decathlon1.dominio.Atleta;
import edu.upc.etsetb.poo.decathlon1.dominio.Clasificacion;
import edu.upc.etsetb.poo.decathlon1.dominio.Competicion;
import edu.upc.etsetb.poo.decathlon1.dominio.MarcaEnEvento;
import edu.upc.etsetb.poo.decathlon1.dominio.MarcaNegativaException;
import edu.upc.etsetb.poo.decathlon1.dominio.NoAtletasInscritosException;
import edu.upc.etsetb.poo.decathlon1.dominio.NumInscripcionException;
import edu.upc.etsetb.poo.decathlon1.dominio.NumeroDeAtletasException;
import edu.upc.etsetb.poo.decathlon1.dominio.TipoEventoException;
import edu.upc.etsetb.poo.decathlon1.iu.InterficieUsuario;

import java.util.HashMap;

/**
 * El controlador del programa.
 */
public class Controlador {

    private static final int RESULTADO_OK = 0;

    private final HashMap<Integer, Atleta> atletas;
    private final Competicion competicion;
    private Clasificacion clasificacion;
    private InterficieUsuario iu;

    public Controlador(String nombre, String fecha,
                       String lugar, InterficieUsuario iu, boolean inicializa)
            throws NoAtletasInscritosException, NumInscripcionException,
            TipoEventoException, MarcaNegativaException {

        this.atletas = new HashMap<>();
        this.competicion = new Competicion(nombre, fecha, lugar);
        this.iu = iu;

        if (inicializa) {
            this.inicializaConAtletasYMarcasIniciales();
        }
    }

    public void inscribirAtleta(String nombre, String nacionalidad) {
        int numInscripcion = this.competicion.obtenerSiguienteNumInscripcion();
        Atleta atleta = new Atleta(nombre, nacionalidad, numInscripcion);
        this.atletas.put(numInscripcion, atleta);
    }

    public String getInfoCompeticion() {
        return this.competicion.toString();
    }

    public int getNumInscritosEnCompeticion() {
        return this.competicion.getNumInscritos();
    }

    public String getInfoAtleta(int numInscripcion) throws NumInscripcionException {
        if (!this.atletas.containsKey(numInscripcion)) {
            throw new NumInscripcionException("Número de inscripción erróneo");
        }
        return this.atletas.get(numInscripcion).toString();
    }

    public int anyadirMarcaEnEventoDeUnAtleta(int numInscripcion, int evento, double marca)
            throws NoAtletasInscritosException, NumInscripcionException,
            TipoEventoException, MarcaNegativaException {

        int numInscritos = this.getNumInscritosEnCompeticion();
        if (numInscritos == 0) {
            throw new NoAtletasInscritosException("ERROR: No hay atletas inscritos");
        }

        if (numInscripcion < 1 || numInscripcion > numInscritos) {
            throw new NumInscripcionException("ERROR: El número de inscripción es erróneo");
        }

        if (evento < 0 || evento >= MarcaEnEvento.NUM_EVENTOS) {
            throw new TipoEventoException("ERROR: El evento es erróneo");
        }

        Atleta atleta = this.atletas.get(numInscripcion);
        atleta.anyadirMarcaEnEvento(evento, marca);

        return RESULTADO_OK;
    }

    public String getClasificacion(int numAtletas)
            throws NoAtletasInscritosException, NumeroDeAtletasException {

        int numInscritos = this.getNumInscritosEnCompeticion();

        if (numInscritos == 0) {
            throw new NoAtletasInscritosException("ERROR: No hay atletas inscritos aún");
        }

        if (numAtletas <= 0 || numAtletas > numInscritos) {
            throw new NumeroDeAtletasException("ERROR: El número de atletas es erróneo");
        }

        this.clasificacion = new Clasificacion(numAtletas);
        for (Atleta a : this.atletas.values()) {
            this.clasificacion.anyadirAClasificacion(a);
        }

        return this.clasificacion.toString();
    }

    public void inicializaConAtletasYMarcasIniciales()
            throws NoAtletasInscritosException, NumInscripcionException,
            TipoEventoException, MarcaNegativaException {

        inscribirAtleta("Kevin Mayer", "FRA");      // 800 pts por prueba
        inscribirAtleta("Larbi Bourrada", "ALG");   // 1000 pts por prueba
        inscribirAtleta("Dimitriy Karpov", "KAZ");  // 900 pts por prueba
        inscribirAtleta("Ashton Eaton", "USA");     // 700 pts por prueba
        inscribirAtleta("Ashley Moloney", "AUS");   // Se lesionó y no compitió

        int i = 1;

        // Kevin Mayer - 800 pts
        anyadirMarcaEnEventoDeUnAtleta(i, 0, 11.278);
        anyadirMarcaEnEventoDeUnAtleta(i, 1, 694);
        anyadirMarcaEnEventoDeUnAtleta(i, 2, 15.16);
        anyadirMarcaEnEventoDeUnAtleta(i, 3, 199);
        anyadirMarcaEnEventoDeUnAtleta(i, 4, 50.32);
        i++;

        // Larbi Bourrada - 1000 pts
        anyadirMarcaEnEventoDeUnAtleta(i, 0, 10.395);
        anyadirMarcaEnEventoDeUnAtleta(i, 1, 776);
        anyadirMarcaEnEventoDeUnAtleta(i, 2, 18.40);
        anyadirMarcaEnEventoDeUnAtleta(i, 3, 221);
        anyadirMarcaEnEventoDeUnAtleta(i, 4, 46.17);
        i++;

        // Dimitriy Karpov - 900 pts
        anyadirMarcaEnEventoDeUnAtleta(i, 0, 10.827);
        anyadirMarcaEnEventoDeUnAtleta(i, 1, 736);
        anyadirMarcaEnEventoDeUnAtleta(i, 2, 16.79);
        anyadirMarcaEnEventoDeUnAtleta(i, 3, 210);
        anyadirMarcaEnEventoDeUnAtleta(i, 4, 48.19);
        i++;

        // Ashton Eaton - 700 pts
        anyadirMarcaEnEventoDeUnAtleta(i, 0, 11.756);
        anyadirMarcaEnEventoDeUnAtleta(i, 1, 651);
        anyadirMarcaEnEventoDeUnAtleta(i, 2, 13.53);
        anyadirMarcaEnEventoDeUnAtleta(i, 3, 188);
        anyadirMarcaEnEventoDeUnAtleta(i, 4, 52.58);

        // Ashley Moloney no compite
    }
}