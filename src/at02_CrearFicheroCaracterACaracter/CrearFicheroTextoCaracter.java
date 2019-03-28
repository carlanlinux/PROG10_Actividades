package at02_CrearFicheroCaracterACaracter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CrearFicheroTextoCaracter {

    //Método Main
    public static void main(String[] args) throws IOException {
        try {
            if (args.length != 1)
                throw new ArgumentosIncorrectos();
            else
                crearFichero(args[0]);

        } catch (ArgumentosIncorrectos error) {
            System.out.println("El número de argumentos es incorrecto");
            System.out.println("Sintaxis: java CrearFicheroTextoCaracter nomFichero");
        }

    }

    //Métodos
    public static char getRespuesta(){
        char respuesta = 's';
        boolean respuestaValida;

        try{
            do {
                respuesta = (char)System.in.read();
                respuesta = Character.toLowerCase(respuesta);
                respuestaValida = ( respuesta == 's' || respuesta == 'n');
                if(!respuestaValida)
                    System.out.println("La respuesta no es válida");
            } while (!respuestaValida);


        } catch (IOException error) {
            System.out.println("La respuesta no es válida");
        }

        return respuesta;
    }

    public static void crearFichero(String nomFichero) throws IOException {

        File fichero = new File(nomFichero);
        FileWriter flujoSalida = null;
        char respuesta = 's';

        try {
            if(fichero.exists()){
                System.out.println("El fichero ya existe. Desea sobrescribir (s/n)");
                respuesta = getRespuesta();
            }
            if(respuesta == 's'){

                //creamos el Flujo de Salida
                flujoSalida = new FileWriter(fichero);
                char caracter;
                char eof = (char)-1;
                System.out.println("Escribe un texto. Pulsa control + Z para Finalizar ");
                while ((caracter = (char)System.in.read()) != eof)
                    flujoSalida.write(caracter);
            }
        } catch (IOException error) {
            System.out.println("Error de Entrada y salida");
        } finally {
            if(flujoSalida != null)
                flujoSalida.close();
        }
    }

}


//Creamos las excepciones
//Ojo si creamos varias clases dentro de un mismo fichero java no poner lo de public
////////////////////////////////////////////////////////////////////////////////
class ArgumentosIncorrectos extends Exception{
    public ArgumentosIncorrectos() {
        super();
    }
}