
package mx.com.gm.peliculas.negocio;

import mx.com.gm.peliculas.datos.*;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

public class CatalogoPeliculasImp implements ICatalogoPeliculas{

    private final IAccesoDatos datos;

    public CatalogoPeliculasImp() {
        this.datos = new AccesoDatosImp();
    }  
    
    @Override
    public void agregarPelicula(String nombrePelicula) {
       Pelicula pelicula = new Pelicula(nombrePelicula);
       boolean anexar = false;
        try {
            anexar = datos.exite(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error de acceso a datos");
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO);
            
            for (var pelicula : peliculas) {
                System.out.println("Peliculas ==> " + pelicula);
            }
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error de acceso a listar peliculas");
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error de acceso a buscar peliculas");
        }
        System.out.println("Resultado de la busqueda : " + resultado);
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if(this.datos.exite(NOMBRE_RECURSO)){
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            }else {
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error de acceso a iniciar el catalogo");
        }
    }
    
}
