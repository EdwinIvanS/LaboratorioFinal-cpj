package mx.com.gm.peliculas.presentacion;

import java.util.Scanner;
import mx.com.gm.peliculas.negocio.*;

public class CatalogoPeliculasPresentacion {

    public static void main(String[] args) {
        var opcion = -1;
        var scanner = new Scanner(System.in);
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImp();
        
        while (opcion != 0) {            
            System.out.println("""
                               Elige una opcion : 
                               1. Iniciar catalogo de peliculas 
                               2. Agregar peliculas 
                               3. Listar peliculas 
                               4. Buscar pelicula 
                               0. Salir 
                               """);
            opcion = Integer.parseInt(scanner.nextLine());
            
            switch (opcion) {
                case 1 -> catalogo.iniciarCatalogoPeliculas();
                case 2 -> {
                    System.out.println("Introduce el nombre de la pelicula");
                    var nombrePelicula = scanner.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                    System.out.println("");
                }
                case 3 -> {
                    catalogo.listarPeliculas();
                    System.out.println("");
                }
                case 4 -> {
                    System.out.println("Introduce el nombre de la pelicula a buscar");
                    var buscar = scanner.nextLine();
                    catalogo.buscarPelicula(buscar);
                    System.out.println("");
                }
                case 0 -> System.out.println("Hasta pronto");
                default -> System.out.println("Opcion incorrecta");                
            }
        }        
    }
    
}
