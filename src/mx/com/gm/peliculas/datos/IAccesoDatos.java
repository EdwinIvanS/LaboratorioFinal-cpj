
package mx.com.gm.peliculas.datos;

import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;

public interface IAccesoDatos {
    boolean exite(String nombreArchivo);
    List<Pelicula> listar(String nombrePelicula);
    void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar);
    String buscar(String nombreArchivo, String buscar);
    void crear(String nombreArchivo);
    void borrar(String nombreArchivo);    
}
