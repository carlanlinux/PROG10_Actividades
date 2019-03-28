package at03_CrearFicheroLinea;

import java.io.*;

public class CrearFicheroTextoLineas {

    public static void main(String[] args) throws IOException {

        try {
            if(args.length != 1)
                throw new ArgumentosNoCorrectos();

            else {
                crearFichero(args[0]);
            }

        } catch (ArgumentosNoCorrectos error) {
            System.out.println("El número de argumentos es incorrecto");
            System.out.println("Sintaxis java CrearFicheroTextoLineas nombreFichero ");
        }

    }

    //Métodos
    public static char getRespuesta() {
        char respuesta = 's';
        boolean respuestaValida;

        try {
            do {
                respuesta = (char)System.in.read();
                respuesta = Character.toLowerCase(respuesta);
                respuestaValida = (respuesta == 's' || respuesta == 'n');
                if(!respuestaValida)
                    System.out.println("La respuesta no es válida");
            } while (!respuestaValida);
        } catch (IOException error) {
            System.out.println("Error de entrada y/o salida");
        }
        return respuesta;
    }


    public static void crearFichero(String nomFichero) throws IOException {
        File fichero = new File(nomFichero);
        FileWriter flujoSalida = null;
        char respuesta = 's';

        try{
            if(fichero.exists()){
                System.out.println("El fichero ya existe. Desea sobrescribirlo (s/n)");
                respuesta = getRespuesta();
            }
            if(respuesta == 's') {

                //Creamos el flujo de salida
                BufferedReader flujoLector = new BufferedReader(new InputStreamReader(System.in));
                //Decimos que el flujo de salida tiene que ir al fichero
                flujoSalida = new FileWriter(fichero);
                String linea = null;
                String eof = "!";
                System.out.println("Escribe un texto. Pulsa control + Z para finalizar");
                while ((linea = flujoLector.readLine()) != eof)
                    flujoSalida.write(linea + "\n");

            }
        } catch (IOException error) {
            System.out.println("Error entrada y salida");
        }
    }

}

//Creamos las excepciones
//Ojo si creamos varias clases dentro de un mismo fichero java no poner lo de public
////////////////////////////////////////////////////////////////////////////////

class ArgumentosNoCorrectos extends Exception {
    public ArgumentosNoCorrectos() {
        super();
    }
}