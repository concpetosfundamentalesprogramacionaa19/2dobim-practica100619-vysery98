package practica;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author vysery98
 */
public class LeerArchivoTxt {

    /*
        Las cabeceras de cada columna son:
            Numero|FIFADisplayName|Country|LastName|FirstName|ShirtName|DOB|POS|
            Club|Height|Caps|Goals
     */
    public static void leerTabla() {

        // 1. Se abre el archivo
        try // lee registros del archivo, usando el objeto Scanner
        {
            Scanner sc = new Scanner(new File("tabula-FWC_2018_Squadlists_4.csv"
                    + ""));
            double sumaGoals = 0;
            double sumaHeight = 0;
            double contador = 0;
            double promedioGoals = 0;
            double promedioHeight = 0;

            while (sc.hasNext()) {

                String linea = sc.nextLine();
                ArrayList<String> linea_partes = new ArrayList<>(
                        Arrays.asList(linea.split("\\|")));
                double goals = Double.parseDouble(linea_partes.get(11));
                double height = Double.parseDouble(linea_partes.get(9));
                sumaGoals = sumaGoals + goals;
                sumaHeight = sumaHeight + height;
                contador++;

            } // fin de while
            promedioGoals = sumaGoals / contador;
            promedioHeight = sumaHeight / contador;
            sc.close();
            System.out.printf("El promedio de \"Goals\" es: %.2f\nEl promedio d"
                    + "e \"Height\" es: %.2f\n", promedioGoals, promedioHeight);
        } // fin de try
        catch (Exception e) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método
    // cierra el archivo y termina la aplicación

}
