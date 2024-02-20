import java.util.Arrays;
import java.util.Comparator;

public class BusquedaPersona {

	static class Persona{
		  String nombre;
	        int documento;

	        Persona(String nombre, int documento) {
	        	  this.nombre = nombre;
	              this.documento = documento;
	        }
	}
	
	public static void main(String[] args) {
		 Persona[] personas = {
	                new Persona("Juan", 123),
	                new Persona("Maria", 456),
	                new Persona("Pedro", 789),
	                new Persona("Luisa", 234),
	                new Persona("Ana", 567)
	};
	
		 ordenarBurbuja(personas);
		 System.out.println("Lista de personas ordenada por documento de identidad:");
	        for (Persona persona : personas) {
	        	
	        	System.out.println(persona.nombre + ": " + persona.documento);
	        }
	        int documentoBuscado = 789;
	        int indice = busquedaBinaria(personas, documentoBuscado);
	        if (indice != -1) {
	        	 System.out.println("Persona encontrada:");
	             System.out.println(personas[indice].nombre + ": " + personas[indice].documento);
	        }else {
	        	 System.out.println("Persona no encontrada.");
	        }

}
	
	
	  // Método de ordenamiento burbuja
    static void ordenarBurbuja(Persona[] arr) {
    	 int n = arr.length;
         for (int i = 0; i < n-1; i++) {
        	 for (int j = 0; j < n-i-1; j++) {
        		 if (arr[j].documento > arr[j+1].documento) {
        			   // intercambiar arr[j] y arr[j+1]
                     Persona temp = arr[j];
                     arr[j] = arr[j+1];
                     arr[j+1] = temp;
        		 }
        	 }
         }
    }
    // Método de búsqueda binaria
    static int busquedaBinaria(Persona[] arr, int documentoBuscado) {
        int izquierda = 0, derecha = arr.length - 1;
        while (izquierda <= derecha) {
        	  int medio = izquierda + (derecha - izquierda) / 2;
        	  // Comprueba si el documento buscado está presente en el medio
              if (arr[medio].documento == documentoBuscado)
                  return medio;

              // Si el documento buscado es mayor, ignora la mitad izquierda
              if (arr[medio].documento < documentoBuscado)
                  izquierda = medio + 1;

              // Si el documento buscado es menor, ignora la mitad derecha
              else
                  derecha = medio - 1;
        
       
        }
        
        // Si el documento buscado no está presente en el array
        return -1;
    }
}