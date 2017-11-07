
import java.util.Scanner;

/*
 * Classe Aplicacio per interactuar amb l'usuari, contenir les platges i cridar
 * a la resta de classes i mètodes mitjançant uns menús.
 */
/**
 *
 * @author fta
 */
public class Aplicacio {

    //Afegir elements zona si aquets no estan afegits. Mètodes seleccionar de la classe
    //zona.
    private static Platja[] platges = new Platja[4];//Platges d'illa Tortuga
    private static int indexPlatges = 0; //La propera posició buida del vector platges
    private static Platja platjaActual = null; //PlatjaSeleccionada

    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        int opcio = 0;
        Scanner dades = new Scanner(System.in);
        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Gestió de platges");
            System.out.println("\n2. Gestió de zones");
            System.out.println("\n3. Gestió de velomars");
            System.out.println("\n4. Gestió d'ombrel.les");
            System.out.println("\n5. Gestió d'hamaques");
            System.out.println("\n6. Gestió d'encarregats");
            opcio = dades.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    menuPlatges();
                    break;
                case 2:
                    if (platjaActual != null) {
                        menuZones();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la platja del menú de platges");
                    }
                    break;
                case 3:
                    if (platjaActual != null) {
                        menuVelomars();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la platja del menú de platges");
                    }
                    break;
                case 4:
                    if (platjaActual != null) {
                        menuOmbrelles();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la platja del menú de platges");
                    }
                    break;
                case 5:
                    if (platjaActual != null) {
                        menuHamaques();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la platja del menú de platges");
                    }
                    break;
                case 6:
                    if (platjaActual != null) {
                        menuEncarregats();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la platja del menú de platges");
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuPlatges() {
        int opcio = 0;
        Scanner dades = new Scanner(System.in);
        do {
            int pos = -1;
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Seleccionar");
            System.out.println("\n3. Modificar");
            System.out.println("\n4. LListar platges");
            opcio = dades.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    platges[indexPlatges] = Platja.novaPlatja();
                    indexPlatges++;
                    break;
                case 2:
                    pos = seleccionarPlatja();
                    if (pos >= 0) {
                        platjaActual = platges[pos];
                    } else {
                        System.out.println("\nNo existeix aquesta platja");
                    }
                    break;
                case 3:
                    pos = seleccionarPlatja();
                    if (pos >= 0) {
                        platges[pos].modificarPlatja();
                    } else {
                        System.out.println("\nNo existeix aquesta platja");
                    }
                    break;
                case 4:
                    for (int i = 0; i < indexPlatges; i++) {
                        platges[i].mostrarPlatja();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuZones() {
        int opcio = 0;
        int posZona, posElement, posElementZona;
        Scanner dades = new Scanner(System.in);
        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Afegir encarregat");
            System.out.println("\n3. Afegir ombrel.la");
            System.out.println("\n4. Afegir velomar");
            System.out.println("\n5. Treure encarregat");
            System.out.println("\n6. Treure ombrel.la");
            System.out.println("\n7. Treure velomar");
            System.out.println("\n8. Gestionar lloguers");
            System.out.println("\n9. Llistar zones");
            opcio = dades.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    platjaActual.afegirZona();
                    break;
                case 2:
                    posZona = platjaActual.seleccionarZona();
                    posElement = platjaActual.seleccionarEncarregat();
                    if (posZona >= 0 && posElement >= 0) {
                        posElementZona = platjaActual.getZones()[posZona].seleccionarEncarregat(platjaActual.getEncarregats()[posElement].getDni());
                        if (posElementZona == -1) {
                            platjaActual.getZones()[posZona].afegirEncarregat(platjaActual.getEncarregats()[posElement]);
                        } else {
                            System.out.println("\nL'encarregat ja està afegit a la zona.");
                        }
                    } else if (posZona == -1) {
                        System.out.println("\nNo existeix la zona.");
                    } else if (posElement == -1) {
                        System.out.println("\nNo existeix l'encarregat.");
                    }
                    break;
                case 3:
                    posZona = platjaActual.seleccionarZona();
                    posElement = platjaActual.seleccionarOmbrella();
                    if (posZona >= 0 && posElement >= 0) {
                        posElementZona = platjaActual.getZones()[posZona].seleccionarOmbrella(platjaActual.getOmbrelles()[posElement].getCodi());
                        if (posElementZona == -1) {
                            platjaActual.getZones()[posZona].afegirOmbrella(platjaActual.getOmbrelles()[posElement]);
                        } else {
                            System.out.println("\nL'ombrel.la ja està afegit a la zona.");
                        }
                    } else if (posZona == -1) {
                        System.out.println("\nNo existeix la zona.");
                    } else if (posElement == -1) {
                        System.out.println("\nNo existeix l'ombrel.la.");
                    }
                    break;
                case 4:
                    posZona = platjaActual.seleccionarZona();
                    posElement = platjaActual.seleccionarVelomar();
                    if (posZona >= 0 && posElement >= 0) {
                        posElementZona = platjaActual.getZones()[posZona].seleccionarVelomar(platjaActual.getVelomars()[posElement].getCodi());
                        if (posElementZona == -1) {
                            platjaActual.getZones()[posZona].afegirVelomar(platjaActual.getVelomars()[posElement]);
                        } else {
                            System.out.println("\nEl velomar ja està afegit a la zona.");
                        }
                    } else if (posZona == -1) {
                        System.out.println("\nNo existeix la zona.");
                    } else if (posElement == -1) {
                        System.out.println("\nNo existeix el velomar.");
                    }
                    break;
                case 5:
                    posZona = platjaActual.seleccionarZona();
                    if (posZona >= 0) {
                        posElementZona = platjaActual.getZones()[posZona].seleccionarEncarregat(null);
                        if (posElementZona >= 0) {
                            platjaActual.getZones()[posZona].treureEncarregat(platjaActual.getZones()[posZona].getEncarregats()[posElementZona].getDni());
                        } else {
                            System.out.println("\nL'encarregat no està assignat a la zona.");
                        }
                    } else {
                        System.out.println("\nNo existeix la zona.");
                    }
                    break;
                case 6:
                    posZona = platjaActual.seleccionarZona();
                    if (posZona >= 0) {
                        posElementZona = platjaActual.getZones()[posZona].seleccionarOmbrella(-1);
                        if (posElementZona >= 0) {
                            platjaActual.getZones()[posZona].treureOmbrella(platjaActual.getZones()[posZona].getOmbrelles()[posElementZona].getCodi());
                        } else {
                            System.out.println("\nL'ombrel.la no està assignada a la zona.");
                        }
                    } else {
                        System.out.println("\nNo existeix la zona.");
                    }
                    break;
                case 7:
                    posZona = platjaActual.seleccionarZona();
                    if (posZona >= 0) {
                        posElementZona = platjaActual.getZones()[posZona].seleccionarVelomar(-1);
                        if (posElementZona >= 0) {
                            platjaActual.getZones()[posZona].treureVelomar(platjaActual.getZones()[posZona].getVelomars()[posElementZona].getCodi());
                        } else {
                            System.out.println("\nEl velomar no està assignat a la zona.");
                        }
                    } else {
                        System.out.println("\nNo existeix la zona.");
                    }
                    break;
                case 8:
                    menuLloguers();
                    break;
                case 9:
                    for (int i = 0; i < platjaActual.getZones().length; i++) {
                        platjaActual.getZones()[i].mostrarZona();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuLloguers() {
        int opcio = 0;
        int posZona;
        Scanner dades = new Scanner(System.in);
        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Crear");
            System.out.println("\n2. Tancar");
            System.out.println("\n3. Llistar lloguers");
            opcio = dades.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    posZona = platjaActual.seleccionarZona();
                    if (posZona >= 0) {
                        platjaActual.getZones()[posZona].afegirLloguer(Lloguer.nouLloguer(platjaActual));
                    } else {
                        System.out.println("\nNo existeix la zona.");
                    }
                    break;
                case 2:
                    posZona = platjaActual.seleccionarZona();
                    if (posZona >= 0) {
                        platjaActual.getZones()[posZona].tancarLloguer(Lloguer.nouLloguer(platjaActual));
                    } else {
                        System.out.println("\nNo existeix la zona.");
                    }
                    break;
                case 3:
                    posZona = platjaActual.seleccionarZona();
                    for (int i = 0; i < platjaActual.getZones()[posZona].getLloguers().length; i++) {
                        platjaActual.getZones()[posZona].getLloguers()[i].mostrarLloguer();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

     /*
     Heu de desenvolupar el menú de velomars amb les opcions que podeu veure.
        
     Opció 0. Sortir -> Surt del menú i torna al menú principal.
     Opció 1. alta -> Permet crear un nou velomar i afegir-lo al vector de velomars
     de la platja actual. Heu de fer servir el mètode escaient de la classe Platja.
     Opció 2. baixa -> Permet treure un velomar del vector de velomars de la 
     platja actual. Heu de fer servir el mètode escaient de la classe Platja.
     Opció 3. Modificar -> Permet modificar un velomar de la platja actual. Per 
     seleccionar el velomar heu de fer servir el mètode escaient de la classe Platja.
     Opció 4. Llistar velomars -> Imprimeix les dades dels velomars de la platja 
     actual.
        
     A més, heu de fer un bucle per tornar a mostrar el menú sempre que no es premi 
     l'opció 0 de sortida. Si no s'ha introduït cap opció de les de la llista, s'ha 
     de mostrar el missatge "S'ha de seleccionar una opció correcta del menú."
     
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, això ho controlarem
     més endavant.
     */
    public static void menuVelomars() {
        
    }

    /*
     Heu de desenvolupar el menú de ombrel.les amb les opcions que podeu veure.
        
     Opció 0. Sortir -> Surt del menú i torna al menú principal.
     Opció 1. alta -> Permet crear una nova ombrel.la i afegir-la al vector 
     d'ombrel.les de la platja actual. Heu de fer servir el mètode escaient de la
     classe Platja.
     Opció 2. baixa -> Permet treure una ombrel.la del vector d'ombrel.les de la 
     platja actual. Heu de fer servir el mètode escaient de la classe Platja.
     Opció 3. Modificar -> Permet modificar una ombrel.la de la platja actual. Per 
     seleccionar l'ombrel.la heu de fer servir el mètode escaient de la classe Platja.
     Opció 4. Llistar ombrel.les -> Imprimeix les dades del les ombrel.les de la platja 
     actual.
        
     A més, heu de fer un bucle per tornar a mostrar el menú sempre que no es premi 
     l'opció 0 de sortida. Si no s'ha introduït cap opció de les de la llista, s'ha 
     de mostrar el missatge "S'ha de seleccionar una opció correcta del menú."
     
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, això ho controlarem
     més endavant.
     */
    public static void menuOmbrelles() {
        
    }

    /*
     Heu de desenvolupar el menú d'hamaques amb les opcions que podeu veure.
        
     Opció 0. Sortir -> Surt del menú i torna al menú principal.
     Opció 1. alta -> Permet crear una nova hamaca i afegir-la al vector d'hamaques 
     de la platja actual. Heu de fer servir el mètode escaient de la classe Platja.
     Opció 2. baixa -> Permet treure una hamaca del vector d'hamaques de la 
     platja actual. Heu de fer servir el mètode escaient de la classe Platja.
     Opció 3. Modificar -> Permet modificar una hamaca de la platja actual. Per 
     seleccionar l'hamaca heu de fer servir el mètode escaient de la classe Platja.
     Opció 4. Llistar hamaques -> Imprimeix les dades del les hamaques de la platja 
     actual.
        
     A més, heu de fer un bucle per tornar a mostrar el menú sempre que no es premi 
     l'opció 0 de sortida. Si no s'ha introduït cap opció de les de la llista, s'ha 
     de mostrar el missatge "S'ha de seleccionar una opció correcta del menú."
     
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, això ho controlarem
     més endavant.
     */
    public static void menuHamaques() {
        
    }
    
     /*
     Heu de desenvolupar el menú d'encarregats amb les opcions que podeu veure.
        
     Opció 0. Sortir -> Surt del menú i torna al menú principal.
     Opció 1. alta -> Permet crear un nou encarregat i afegir-lo al vector d'encarregats
     de la platja actual. Heu de fer servir el mètode escaient de la classe Platja.
     Opció 2. baixa -> Permet treure un encarregat del vector d'encarregats de la 
     platja actual. Heu de fer servir el mètode escaient de la classe Platja.
     Opció 3. Modificar -> Permet modificar un encarregat de la platja actual. Per 
     seleccionar l'encarregat heu de fer servir el mètode escaient de la classe Platja.
     Opció 4. Llistar encarregats -> Imprimeix les dades dels encarregats de la platja 
     actual.
        
     A més, heu de fer un bucle per tornar a mostrar el menú sempre que no es premi 
     l'opció 0 de sortida. Si no s'ha introduït cap opció de les de la llista, s'ha 
     de mostrar el missatge "S'ha de seleccionar una opció correcta del menú."
     
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, això ho controlarem
     més endavant.
     */
    public static void menuEncarregats() {
       
    }
    
    public static int seleccionarPlatja() {
        Scanner dades = new Scanner(System.in);
        System.out.println("\nCoordenades de la platja?:");
        String coordenades = dades.next();
        int pos = -1;
        for (int i = 0; i < indexPlatges; i++) {
            if (platges[i].getCoordenades().equals(coordenades)) {
                pos = i;
                return pos;
            }
        }
        return pos;
    }
}
