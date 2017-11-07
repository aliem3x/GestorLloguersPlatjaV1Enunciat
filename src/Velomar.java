
import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Velomar {

    private int codi;
    private static int properCodi=0;
    private String dataAlta;
    private boolean tobogan;
    private boolean llogat;

    /*
     CONSTRUCTOR
     Paràmetres: valor per la data d'alta i pel tobogan
     Accions:
     - Assignar als atributs els valors passats com a paràmetres
     - Assignar a codi el valor de l'atribut properCodi.
     - Actualitzem properCodi assignant-li el valor del següent codi que serà 
       l'increment del valor actual en 1.
     - Heu de tenir en compte que quan es crea un velomar, l'atribut llogat 
       sempre és fals.
     */

    public Velomar(String dataAlta, boolean tobogan) {
        this.dataAlta = dataAlta;
        this.tobogan = tobogan;
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

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public static int getProperCodi() {
        return properCodi;
    }

    public static void setProperCodi() {
        Velomar.properCodi++;
    }

    public String getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(String dataAlta) {
        this.dataAlta = dataAlta;
    }

    public boolean isTobogan() {
        return tobogan;
    }

    public void setTobogan(boolean tobogan) {
        this.tobogan = tobogan;
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
    - Demanar a l'usuari les dades per consola per crear un nou velomar. Les dades
    a demanar són les que passem per paràmetre en el constructor.
    - Quan demaneu si té tobogan o no, li heu de demanar a l'usuari que introdueixi
    1 si té i 0 si no té. En cas de no introduir cap dels dos valors se li
    mostrarà un missatge avisant-lo de què el valor introduït no és correcte i
    se li tornarà a demanar el valor.
    Retorn: El nou velomar creat.
     */
    public static Velomar nouVelomar() {
        Scanner kb = new Scanner(System.in);
        String IdataAlta;
        int comprovador;
        boolean Itobogan,error=true;
        System.out.print("Data d'alta: ");
        IdataAlta=kb.nextLine();
        do{
        System.out.println("Té tobogan?");
        System.out.println("   Fica el número 0 si és que no");
        System.out.println("   Fica el número 1 si és que sí");
        System.out.print("OPCIÓ: ");
        comprovador=kb.nextInt();
        kb.nextLine();
        if(comprovador==0 || comprovador==1){
            error=false; 
        }
        else System.out.println("Error, volver a introducir valor de tobogan");
        }while(error);
        
        Itobogan = comprovador != 0;
        
        return new Velomar(IdataAlta,Itobogan);
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
       i modificar els atributs corresponents d'aquest objecte.
     - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte
       actual, abans de modificar-los.
     - Per mostrar si té tobogan o no, li heu de mostrar a l'usuari el missatge
       "Té tobogan", si en té, i "No té tobogan", si no en té.
     - Quan vulgueu modificar si té o no velomar, li heu de demanar a l'usuari que
       introdueixi 1 si té i 0 si no té. En cas de no introduir cap dels dos valors 
       se li mostrarà un missatge avisant-lo de què el valor introduït no és correcte i
       se li tornarà a demanar el valor.
     - Per modificar l'estat de lloguer del velomar, heu de fer servir el
       mètode modificarEstatLloguer() d'aquesta mateixa classe.
     - Tingueu en compte que el codi no es pot modificar.
     Retorn: cap
     */
    public void modificarVelomar() {
        Scanner kb = new Scanner(System.in);
        String IdataAlta;
        int comprovador;
        boolean Itobogan,error=true;
        System.out.println("\n\n----Dades a canviar----");
        mostrarVelomar();
        System.out.println("\n\n----Inserisión de les noves dades----");
        System.out.print("Nova data d'alta: ");
        IdataAlta=kb.nextLine();
        do{
        System.out.println("Té tobogan?");
        System.out.println("   Fica el número 0 si és que no");
        System.out.println("   Fica el número 1 si és que sí");
        System.out.print("OPCIÓ: ");
        comprovador=kb.nextInt();
        kb.nextLine();
        if(comprovador==0 || comprovador==1){
            error=false; 
        }
        else System.out.println("Error, volver a introducir valor de tobogan");
        }while(error); //en funcion a parte
        
        Itobogan = comprovador != 0;
        
        dataAlta = IdataAlta;
        tobogan = Itobogan;
        
        modificarEstatLloguer();
        
        System.out.println("\n\n----Noves dades----");
        mostrarVelomar();
    }

    public void mostrarVelomar() {
        System.out.println("\nLes dades del velomar amb codi " + codi + " són:");
        System.out.println("\nData d'alta: " + dataAlta);
        
        System.out.println("\nEl velomar ");
        if (tobogan) {
            System.out.print("té tobogan");
        } else {
            System.out.print("no té tobogan");
        }
        
        System.out.println("\nEstat de lloguer: ");
        if (llogat) {
            System.out.print("Llogat");
        } else {
            System.out.print("No llogat");
        }
    }

    public void modificarEstatLloguer() {
        Scanner dades = new Scanner(System.in);
        int opcio;

        System.out.println("\nL'estat actual de lloguer és: ");
        if (llogat) {
            System.out.print("Llogat");
        } else {
            System.out.print("No llogat");
        }

        do {
            System.out.println("\nEntra el nou estat de lloguer: (0 si no està llogat o 1 si està llogat)");
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
//           Velomar vel = nouVelomar();
//           vel.mostrarVelomar();
//           vel.modificarVelomar();
//    }
}
