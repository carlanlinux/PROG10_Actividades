package at01_verPropiedadesFicheros;

import java.io.File;


public class PropiedadesFichero {

    //Método main
    public static void main(String[] args) {

        try {
            //Comprobamos que hay algún argumento (viendo el tamaño del array args)

            if (args.length < 1)
                //Si no, lanzamos excepción
                throw new ArgumentosIncorrectos();

            else {
                for (int i = 0; i < args.length; i++) {
                    File fichero = new File(args[i]);
                    if (!fichero.exists())
                        throw new FicheroInexistente();

                    else {
                        propiedades(fichero);
                    }
                }

            }

        }

        //Ponemos todos los catch
        catch ( ArgumentosIncorrectos error) {

            System.out.println("Los argumentos introducidos son incorrectos");
        }

        catch (FicheroInexistente error) {
            System.out.println("El fichero introducido no existe");
        }

    }

//Mérodos fuera del main, se pone static porque de otra forma no se podrá usar en el método esático
////////////////////////////////////////////////////////////////////////////////

    public static void propiedades(File fichero){

        //Comprobamos si el fichero es un archivo y sacamos detalles
        if (fichero.isFile()) {
            System.out.println("El nombre del fichero es " + fichero.getName());
            System.out.println("La ruta absoluta del fichero es " + fichero.getAbsolutePath());
            System.out.println("La ruta relativa del fichero es " + fichero.getPath());

        //Comprobamos lectura
        if (fichero.canRead())
            System.out.println("El fichero se puede leer");
            else
            System.out.println("El fichero no se puede leer");

            //Comprobamos escritura
            if (fichero.canWrite())
                System.out.println("El fichero se puede escribir");
            else
                System.out.println("El fichero no se puede escribir");
        } else {
            if(fichero.isDirectory()) {
                String nomFicheros[] = fichero.list();
            for (int i = 0; i < nomFicheros.length; i++)
            System.out.println(nomFicheros[i]);
            }
        }



        }

    }




//Creamos las excepciones
//Ojo si creamos varias clases dentro de un mismo fichero java no poner lo de public
////////////////////////////////////////////////////////////////////////////////

class ArgumentosIncorrectos extends Exception {
    //Constructor
    public ArgumentosIncorrectos() {
        super();
    }

}

class FicheroInexistente extends Exception {
    //Constructor
    public FicheroInexistente(){
        super();
    }

    }

