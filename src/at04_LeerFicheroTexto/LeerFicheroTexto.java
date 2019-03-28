package at04_LeerFicheroTexto;

import java.io.DataInputStream;
import java.io.IOException;

public class LeerFicheroTexto {

    //Método main
    public static void main(String[] args) throws IOException {

        try {
            if(args.length !=1)
                throw new WrongArguments();

            else
            mostrarFichero(args[0]);

        } catch (WrongArguments error) {
            System.out.println("Los argumentos introducidos son erróneos");
            System.out.println("Sintaxis: java LeerFicheroTexto nombreFichero.extensión");
        }

    }
    public static mostrarFichero(String nombreFichero) {
        DataInputStream stream = null;

    }

}

//Creamos las excepciones
//Ojo si creamos varias clases dentro de un mismo fichero java no poner lo de public
////////////////////////////////////////////////////////////////////////////////

class WrongArguments extends Exception {
    public WrongArguments(){
        super();
    }
}
