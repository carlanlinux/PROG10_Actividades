package at02_aMiManera;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CrearFicheroTexto {

    //Método main
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        char prompt = 'z';

        try {
            //Comprobamos los argumentos, solo aceptamos un argumento
            if (args.length != 1)
                throw new ArgumentosIncorrectos();
            else {
                File archivo = new File(args[0]);
                //comprobamos que el fichero exista
                if (archivo.exists()) {
                    while (prompt != 's' && prompt != 'n') {
                        System.out.print("El fichero ya existe. Desea sobreescribirlo? (s/n)");
                        prompt = teclado.next().charAt(0);

                        if (prompt == 's')
                            crearFichero(args[0]);
                        else if(prompt == 'n')
                            System.out.println("El fichero no ha sido creado");
                        else
                            System.out.println("Ha marcado una opción incorrecta, recuerde s o n");
                    }
                }else
                    crearFichero(args[0]);
            }
        } catch (ArgumentosIncorrectos e) {
            System.out.println("Los argumentos introducidos no son correctos");
            System.out.println("La sintaxis correcta es:  java CrearFicheroTexto nombrefichero.extensión");
        }
    }


//Métodos

    public static void crearFichero(String name) {

        try {
            FileWriter out = new FileWriter(name);
            System.out.println("El fichero " + name + " ha sido creado.");


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}

//Creamos las excepciones
//Ojo si creamos varias clases dentro de un mismo fichero java no poner lo de public
////////////////////////////////////////////////////////////////////////////////
class ArgumentosIncorrectos extends IOException {
    public ArgumentosIncorrectos(){
        super();
    }
}

class FicheroExistente extends IOException{
    public FicheroExistente() {
        super();
    }
}