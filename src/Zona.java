
import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Zona {

    private String codi;
    private Lloguer lloguers[];
    private static int indexLloguers = 0;
    private Velomar velomars[];
    private Ombrella ombrelles[];
    private Encarregat encarregats[];

    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys els vectors
     Accions:
     - Assignar als atributs els valors passats com a paràmetres
     - L'atribut lloguers s'ha d'inicialtizar buit i amb una capacitat per 300 lloguers.
     - L'atribut velomars s'ha d'inicialtizar buit i amb una capacitat per 5 velomars.
     - L'atribut ombrelles s'ha d'inicialtizar buit i amb una capacitat per 20 ombrel.les.
     - L'atribut encarregats s'ha d'inicialtizar buit i amb una capacitat per 3 encarregats.
     */
    public Zona() {
        
    }

    /*
     Mètodes accessors. No han de ser estàtics.
     */
   
    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear una nova zona. Les dades
       a demanar són les que passem per paràmetre en el constructor.
     Retorn: La nova zona creada.
     */
    public static Zona novaZona() {
       
    }

    public void mostrarZona() {
        System.out.println("\nLes dades de la zona amb codi " + codi + " són:");

        System.out.println("\nLloguers:");
        for (int i = 0; i < lloguers.length && lloguers[i] != null; i++) {
            lloguers[i].mostrarLloguer();
        }

        System.out.println("\nOmbrel.les:");
        for (int i = 0; i < ombrelles.length && ombrelles[i] != null; i++) {
            ombrelles[i].mostrarOmbrella();
        }

        System.out.println("\nVelomars:");
        for (int i = 0; i < velomars.length && velomars[i] != null; i++) {
            velomars[i].mostrarVelomar();
        }

        System.out.println("\nEncarregats:");
        for (int i = 0; i < encarregats.length && encarregats[i] != null; i++) {
            encarregats[i].mostrarEncarregat();
        }
    }

    /*
     LLOGUERS
     */
 /*
     Paràmetres:lloguer
     Accions:
     - afegeix el lloguer passat per paràmetre a la primera posició buida del vector 
       de lloguers de la zona actual.
     Retorn: cap
     */
    public void afegirLloguer() {

    }

    /*
     Paràmetres: Lloguer
     Accions:
     - Modifica l'estat dels elements llogats a no llogats del lloguer passat per
       paràmetre de la zona actual. 
     - Si el lloguer no existeix se li mostrarà a l'usuari el missatge "El lloguer
       no existeix"
     Retorn: cap
     */
    public void tancarLloguer() {
       
    }

    public int seleccionarLloguer() {
        Scanner dades = new Scanner(System.in);
        System.out.println("\nCodi del lloguer?:");
        int codi = dades.nextInt();

        int pos = -1;

        for (int i = 0; i < indexLloguers; i++) {
            if (lloguers[i].getCodi() == codi) {
                pos = i;
                return pos;
            }
        }

        return pos;
    }

    /*
     VELOMAR
     */
 /*
     Paràmetres:Velomar
     Accions:
     - afegeix el velomar passat per paràmetre al primer espai buit del vector de 
       velomars de la zona actual.
     Retorn: cap
     */
    public void afegirVelomar() {
       
    }

    /*
     Paràmetres:codi del velomar
     Accions:
     - treu el velomar del codi passat per paràmetre del vector de velomars de la zona 
       actual.
     - a la posició que ocupa aquest velomar se li ha d'assignar el valor null,
       què és la manera de treure el velomar del vector de velomars.
     Retorn: cap
     */
    public void treureVelomar() {
    
    }

    public int seleccionarVelomar(int codi) {
        int pos = -1;

        if (codi == -1) {
            Scanner dades = new Scanner(System.in);
            System.out.println("\nCodi del velomar?:");
            codi = dades.nextInt();
        }

        for (int i = 0; i < velomars.length; i++) {
            if (velomars[i].getCodi() == codi) {
                pos = i;
                return pos;
            }
        }

        return pos;
    }

    /*
     ENCARREGAT
     */
 /*
     Paràmetres:Encarregat
     Accions:
     - afegeix l'encarregat passat per paràmetre al primer espai buit del vector 
       d'encarregats de la zona actual.
     Retorn: cap
     */
    public void afegirEncarregat() {
   
    }

    /*
     Paràmetres:dni de l'encarregat
     Accions:
     - treu l'encarregat del DNI passat per paràmetre del vector de velomars de la zona 
       actual.
     - a la posició que ocupa aquest encarregat se li ha d'assignar el valor null,
       què és la manera de treure l'encarregat del vector d'encarregats.
     Retorn: cap
     */
    public void treureEncarregat() {
     
    }

    public int seleccionarEncarregat(String dni) {
        int pos = -1;

        if (dni == null) {
            Scanner dades = new Scanner(System.in);
            System.out.println("\nDni de l'encarregat?:");
            dni = dades.next();
        }

        for (int i = 0; i < encarregats.length; i++) {
            if (encarregats[i].getDni().equals(dni)) {
                pos = i;
                return pos;
            }
        }

        return pos;
    }

    /*
     OMBRELLA
     */
 /*
     Paràmetres:Ombrella
     Accions:
     - afegeix l'ombrel.la passada per paràmetre al primer espai buit del vector 
       d'ombrel.les de la zona actual.
     Retorn: cap
     */
    public void afegirOmbrella() {
    
    }

    /*
     Paràmetres:codi de l'ombrel.la
     Accions:
     - treu l'omrel.la del codi passat per paràmetre del vector d'ombrel.les de la zona 
       actual.
     - a la posició que ocupa aquesta ombrel.la se li ha d'assignar el valor null,
       què és la manera de treure l'ombrel.la del vector d'ombrel.les.
     Retorn: cap
     */
    public void treureOmbrella() {
      
    }

    public int seleccionarOmbrella(int codi) {
        int pos = -1;

        if (codi == -1) {
            Scanner dades = new Scanner(System.in);
            System.out.println("\nCodi de l'ombrel.la?:");
            codi = dades.nextInt();
        }

        for (int i = 0; i < ombrelles.length; i++) {
            if (ombrelles[i].getCodi() == codi) {
                pos = i;
                return pos;
            }
        }

        return pos;
    }

}
