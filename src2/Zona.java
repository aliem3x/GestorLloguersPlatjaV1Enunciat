
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
    public Zona(String codi) {
        this.codi = codi;
        lloguers = new Lloguer[300];
        velomars = new Velomar[5];
        ombrelles = new Ombrella[20];
        encarregats = new Encarregat[3];
        
    }

    /*
     Mètodes accessors. No han de ser estàtics.
     */
    
   public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public Lloguer[] getLloguers() {
        return lloguers;
    }

    public void setLloguers(Lloguer[] lloguers) {
        this.lloguers = lloguers;
    }

    public static int getIndexLloguers() {
        return indexLloguers;
    }

    public static void setIndexLloguers(int indexLloguers) {
        Zona.indexLloguers = indexLloguers;
    }

    public Velomar[] getVelomars() {
        return velomars;
    }

    public void setVelomars(Velomar[] velomars) {
        this.velomars = velomars;
    }

    public Ombrella[] getOmbrelles() {
        return ombrelles;
    }

    public void setOmbrelles(Ombrella[] ombrelles) {
        this.ombrelles = ombrelles;
    }

    public Encarregat[] getEncarregats() {
        return encarregats;
    }

    public void setEncarregats(Encarregat[] encarregats) {
        this.encarregats = encarregats;
    }
    
    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear una nova zona. Les dades
       a demanar són les que passem per paràmetre en el constructor.
     Retorn: La nova zona creada.
     */
    public static Zona novaZona() {
        Scanner kb = new Scanner(System.in);
        String Icodi;
        System.out.print("Insertar codi zona: ");
        Icodi=kb.nextLine();
        
        return new Zona(Icodi);
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
    public void afegirLloguer(Lloguer llog) {
            if(indexLloguers<lloguers.length){
                lloguers[indexLloguers] = llog;
                indexLloguers++;
            }
            else{
                System.out.println("el vector està ple");
            }
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
    public void tancarLloguer(Lloguer llog) {
        int index = seleccionarLloguer();
        if(index!=-1) {
           int idelement = lloguers[index].getIdElementLloguer();
           int i=0;
           int comprobador = -1;
           boolean trobat=false;
           do{
               if(i<ombrelles.length){
                    if(ombrelles[i].getCodi()== idelement){
                        ombrelles[i].setLlogat(false);
                        trobat=true;
                        comprobador=0;
                    }
                    else i++; 
               }
               else trobat=true;
           }while(!trobat);
           if(comprobador==-1){
            do{
                if(i<velomars.length){
                     if(velomars[i].getCodi()== idelement){
                         velomars[i].setLlogat(false);
                         trobat=true;
                         comprobador=0;
                     }
                     else i++; 
                }
                else trobat=true;
            }while(!trobat);
           }
        }
        else System.out.println("El lloguer no està assignat a la zona.");
    }

    public int seleccionarLloguer() {
        Scanner dades = new Scanner(System.in);
        System.out.println("\nCodi del lloguer?:");
        int codi = dades.nextInt();

        int pos = -1;

        for (int i = 0; i < indexLloguers; i++) {
            if (lloguers[i]!=null && lloguers[i].getCodi() == codi) {
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
    public void afegirVelomar(Velomar vel) {
        int i=0;
        boolean sortir=false;
        do{
            if(i<velomars.length){
                if(velomars[i]==null){
                    velomars[i] = vel;
                    sortir=true;
                }
                else i++;
            }
            else{
                System.out.println("el vector està ple");
                sortir=true;
            }
        }while(!sortir);
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
    public void treureVelomar(int codi) {
        int index=seleccionarVelomar(codi);
        encarregats[index] = null;
    }

    public int seleccionarVelomar(int codi) {
        int pos = -1;

        if (codi == -1) {
            Scanner dades = new Scanner(System.in);
            System.out.println("\nCodi del velomar?:");
            codi = dades.nextInt();
        }

        for (int i = 0; i < velomars.length; i++) {
            if (velomars[i]!=null && velomars[i].getCodi() == codi) {
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
    public void afegirEncarregat(Encarregat enc) {
        int i=0;
        boolean sortir=false;
        do{
            if(i<encarregats.length){
                if(encarregats[i]==null){
                    encarregats[i] = enc;
                    sortir=true;
                }
                else i++;
            }
            else{
                System.out.println("el vector està ple");
                sortir=true;
            }
        }while(!sortir);
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
    public void treureEncarregat(String dni) {
        int index=seleccionarEncarregat(dni);
        encarregats[index] = null;
        
    }

    public int seleccionarEncarregat(String dni) {
        int pos = -1;

        if (dni == null) {
            Scanner dades = new Scanner(System.in);
            System.out.println("\nDni de l'encarregat?:");
            dni = dades.next();
        }

        for (int i = 0; i < encarregats.length; i++) {
            if (encarregats[i]!=null && encarregats[i].getDni().equals(dni)) {
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
    public void afegirOmbrella(Ombrella omb) {
        int i=0;
        boolean sortir=false;
        do{
            if(i<ombrelles.length){
                if(ombrelles[i]==null){
                    ombrelles[i] = omb;
                    sortir=true;
                }
                else i++;
            }
            else{
                System.out.println("el vector està ple");
                sortir=true;
            }
        }while(!sortir);
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
    public void treureOmbrella(int  codi) {
        int index=seleccionarOmbrella(codi);
        encarregats[index] = null;
    }

    public int seleccionarOmbrella(int codi) {
        int pos = -1;

        if (codi == -1) {
            Scanner dades = new Scanner(System.in);
            System.out.println("\nCodi de l'ombrel.la?:");
            codi = dades.nextInt();
        }

        for (int i = 0; i < ombrelles.length; i++) {
            if (ombrelles[i]!=null && ombrelles[i].getCodi() == codi) {
                pos = i;
                return pos;
            }
        }

        return pos;
    }

}