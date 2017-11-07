
import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Hamaca {

    private int codi;
    private static int properCodi=0;
    private String dataAlta;
    private boolean llogat;

    /*
     CONSTRUCTOR
     Paràmetres: valor per la data d'alta
     Accions:
     - Assignar als atributs els valors passats com a paràmetres
     - Assignar a codi el valor de l'atribut properCodi.
     - Actualitzem properCodi assignant-li el valor del següent codi que serà 
       l'increment del valor actual en 1.
     - Heu de tenir en compte que quan es crea una ombrella, l'atribut llogat 
       sempre és fals.
     */

    public Hamaca(String dataAlta) {
        this.dataAlta = dataAlta;
        llogat = false;
        codi = properCodi;
        properCodi++;
    }
    
    /*
    Mètodes accessors. No poden ser estàtics. Penseu com serà setProperCodi().    
     */
    
    public int getCodi() {
        return codi;
    }

    public void setCodi() {
        codi = properCodi;
        properCodi++;
    }

    public static int getProperCodi() {
        return properCodi;
    }

    public static void setProperCodi(int properCodi) {
        Hamaca.properCodi++;
    }

    public String getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(String dataAlta) {
        this.dataAlta = dataAlta;
    }

    public boolean isLlogat() {
        return llogat;
    }

    public void setLlogat(boolean llogat) {  
        this.llogat = llogat;
    }

    /*
    Paràmetres: cap
    Accions:
    - Demanar a l'usuari les dades per consola per crear una nova hamaca. Les dades
    a demanar són les que passem per paràmetre en el constructor.
    Retorn: La nova hamaca creada.
     */
    public static Hamaca novaHamaca() {
        Scanner kb = new Scanner(System.in);
        String IdataAlta;
        System.out.print("Data d'alta: ");
        IdataAlta=kb.nextLine();
        
        return new Hamaca(IdataAlta);        
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
       i modificar els atributs corresponents d'aquest objecte.
     - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte
       actual, abans de modificar-los.
     - Per modificar l'estat de lloguer de l'hamaca, heu de fer servir el
       mètode modificarEstatLloguer() d'aquesta mateixa classe.
     - Tingueu en compte que el codi no es pot modificar.
     Retorn: cap
     */
    public void modificarHamaca() {
        Scanner kb = new Scanner(System.in);
        String IdataAlta;
        System.out.println("\n\n----Dades a canviar----");
        mostrarHamaca();
        System.out.println("\n\n----Inserisión de les noves dades----");
        System.out.print("Nova data d'alta: ");
        IdataAlta=kb.nextLine();
        
        dataAlta = IdataAlta;
        
        modificarEstatLloguer();
        
        System.out.println("\n\n----Noves dades----");
        mostrarHamaca();

    }

    public void mostrarHamaca() {
        System.out.println("\nLes dades de l'hamaca amb codi " + codi + " són:");
        System.out.println("\nData d'alta:" + dataAlta);
        System.out.println("\nEstat de lloguer:");
        if (llogat) {
            System.out.print("Llogada");
        } else {
            System.out.print("No llogada");
        }
    }

    public void modificarEstatLloguer() {
        Scanner dades = new Scanner(System.in);
        int opcio;

        System.out.println("\nL'estat actual de lloguer és: ");
        if (llogat) {
            System.out.print("Llogada");
        } else {
            System.out.print("No llogada");
        }

        do {
            System.out.println("\nEntra el nou estat de lloguer: (0 si no està llogada o 1 si està llogada)");
            opcio = dades.nextInt();

            switch (opcio) {
                case 0:
                    llogat = false;
                    break;
                case 1:
                    llogat = true;
                    break;
                default:
                    System.out.println("\nEl valor introduit no és correcte");
                    break;
            }
        } while (opcio != 0 && opcio != 1);
    }
//       public static void main(String [ ] args){
//           Hamaca ham = novaHamaca();
//           ham.mostrarHamaca();
//           ham.modificarHamaca();
//           Hamaca ham2 = novaHamaca();
//           ham2.mostrarHamaca();
//    }
}
