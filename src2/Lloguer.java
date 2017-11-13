
import java.time.LocalTime;
import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Lloguer {

    private static final double VALOR = 8.0;
    private int codi;
    private static int properCodi=0;
    private String codiZona;
    private String dniEncarregat;
    private int idElementLloguer;
    private String dniClient;
    private LocalTime horaLloguer;
    private LocalTime tempsLloguer;
    private double totalPagar;
    private boolean pagat;

    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els seus atributs, menys el codi i l'hora de lloguer
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     - Assignar a codi el valor de l'atribut properCodi.
     - Actualitzem properCodi assignant-li el valor del següent codi que serà 
       l'increment del valor actual en 1.
     - A l'atribut horaLloguer, se li ha d'assignar l'hora actual del sistema.
     */
    
    public Lloguer(String codiZona, String dniEncarregat, int idElementLloguer, String dniClient, LocalTime tempsLloguer, double totalPagar, boolean pagat) {
        this.codiZona = codiZona;
        this.dniEncarregat = dniEncarregat;
        this.idElementLloguer = idElementLloguer;
        this.dniClient = dniClient;
        this.tempsLloguer = tempsLloguer;
        this.totalPagar = totalPagar;
        this.pagat = pagat;
        codi = properCodi;
        properCodi++;
        horaLloguer = LocalTime.now();
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
        Lloguer.properCodi++;
    }
    
    public String getCodiZona() {
        return codiZona;
    }

    public void setCodiZona(String codiZona) {
        this.codiZona = codiZona;
    }

    public String getDniEncarregat() {
        return dniEncarregat;
    }

    public void setDniEncarregat(String dniEncarregat) {
        this.dniEncarregat = dniEncarregat;
    }

    public int getIdElementLloguer() {
        return idElementLloguer;
    }

    public void setIdElementLloguer(int idElementLloguer) {
        this.idElementLloguer = idElementLloguer;
    }

    public String getDniClient() {
        return dniClient;
    }

    public void setDniClient(String dniClient) {
        this.dniClient = dniClient;
    }

    public LocalTime getHoraLloguer() {
        return horaLloguer;
    }

    public void setHoraLloguer(LocalTime horaLloguer) {
        this.horaLloguer = horaLloguer;
    }

    public LocalTime getTempsLloguer() {
        return tempsLloguer;
    }

    public void setTempsLloguer(LocalTime tempsLloguer) {
        this.tempsLloguer = tempsLloguer;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public boolean isPagat() {
        return pagat;
    }

    public void setPagat(boolean pagat) {
        this.pagat = pagat;
    }
   
    /*
     Paràmetres: platja de la zona on es crea el lloguer
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou lloguer. Les dades
       a demanar són les que passem per paràmetre en el constructor.
     - Quan demaneu si està pagat o no, li heu de demanar a l'usuari que introdueixi
       1 si està pagat i 0 si no ho està. En cas de no introduir cap dels dos valors 
       se li mostrarà un missatge avisant-lo de què el valor introduït no és correcte i
       se li tornarà a demanar el valor.
     - El total a pagar s'ha de calcular tenint en compte que una hora de lloguer 
       de qualsevol element de lloguer és el valor que indica l'atribut VALOR.
       (les ombrel.les amb les seves hamaques les considrarem un únic element de
        lloguer)
    
    NOTA: Heu de tenir en compte que:
     - Els elements es poden llogar per només mitja hora, per hores o per hores i mitja.
       Per exemple, un lloguer de 30 minuts, un de 4 hores o un lloguer de 2 hores i 30 minuts.
     - L'horari de lloguer ha de ser l'hora del sistema en el moment de crear el lloguer.????????????????????????????????
     - Penseu com demanareu a l'usuari el temps de lloguer, tenint en compte que
       es tracta d'un LocalTime.
     - Abans d'assignar el codi de la zona o el dni de l'encarregat hem de comprovar 
       que existeixen mitjançant els mètodes seleccionarZona() de la classe Platja 
       i seleccionarEncarregat() de la classe Zona respectivament. Si no existeixen,
       hem de mostrar un missatge a l'usuari avisant que no existeixen i tornar 
       a demanar que introdueixi el codi o dni segons sigui zona o encarregat.
     - Per assignar el codi de l'element de lloguer, heu de seleccionar l'element
       de lloguer mitjançant el mètode seleccionarElementLloguer() d'aquesta classe. 
     Retorn: El nou lloguer creat.
     */
    
    public static Lloguer nouLloguer(Platja plj) {
        Scanner kb = new Scanner(System.in);
        String IcodiZona="",IdniClient,IdniEncarregat="";
        int indexZona,indexEncarregat,IidElementLloguer,comprovador;
        LocalTime ItempsLloguer;
        double ItotalPagar;
        boolean trobat,Ipagat,error=true;
        do{
            trobat=false;
            indexZona=plj.seleccionarZona();
            if(indexZona!=-1){
            IcodiZona=plj.getZones()[indexZona].getCodi();
            trobat=true;
            }
            else {
                System.out.println("Error, no s'ha trobat cap Zona amb el codi introduit");
                trobat=true;
            }
        }while(!trobat);
        do{
            trobat=false;
            indexEncarregat=plj.seleccionarEncarregat();
            if(indexEncarregat!=-1){
            IcodiZona=plj.getEncarregats()[indexEncarregat].getDni();
            trobat=true;
            }
            else {
                System.out.println("Error, no s'ha trobat cap Encarregat amb el DNI introduit");
                trobat=true;
            }
        }while(!trobat);
        IidElementLloguer=seleccionarElementLloguer(indexZona,plj);
        kb.nextLine();        
        System.out.print("DNI Client: ");
        IdniClient=kb.nextLine();
        
        int mitjaHora, horesLloguer;
        System.out.println("Indica cuantes hores senceres vols llogar");
        horesLloguer = kb.nextInt();
        
        do{
           System.out.println("Indica si vols tenir un periode de 30 min (1 = SI, 0 = NO)");
            mitjaHora = kb.nextInt(); 
        }while(mitjaHora != 0 ||mitjaHora != 1);
        
        
        if (mitjaHora == 1){
            ItempsLloguer = LocalTime.of(horesLloguer, 30);
        }else{
            ItempsLloguer = LocalTime.of(horesLloguer, 0);
        }
        
        
        ItotalPagar=VALOR;
        do{
        System.out.println("S'ha pagat?");
        System.out.println("   Fica el número 0 si és que no");
        System.out.println("   Fica el número 1 si és que sí");
        System.out.print("OPCIÓ: ");
        comprovador=kb.nextInt();
        kb.nextLine();
        if(comprovador==0 || comprovador==1){
            error=false; 
        }
        else System.out.println("Error, el valor introduït no és correcte");
        }while(error);        
        
        Ipagat = comprovador != 0;
        
        return new Lloguer(IcodiZona,IdniEncarregat,IidElementLloguer,IdniClient,ItempsLloguer,ItotalPagar,Ipagat);   
    }


    public static int seleccionarElementLloguer(int posZona, Platja platja) {
        Scanner dades = new Scanner(System.in);
        int opcio = 0;
        int pos;
        int codi = 0;

        do {

            switch (opcio) {
                case 0:
                    System.out.println("Selecciona un element:");
                    System.out.println("1. Velomar.");
                    System.out.println("2. Ombrel.la.");
                    break;

                case 1:
                    do {
                        pos = platja.getZones()[posZona].seleccionarVelomar(-1);
                        if (pos == -1) {
                            System.out.println("\nEl velomar no existeix.");
                        } else {
                            platja.getZones()[posZona].getVelomars()[pos].setLlogat(true);
                            codi = platja.getZones()[posZona].getVelomars()[pos].getCodi();
                        }
                    } while (pos == -1);
                    break;

                case 2:
                    do {
                        pos = platja.getZones()[posZona].seleccionarOmbrella(-1);
                        if (pos == -1) {
                            System.out.println("\nL'ombrel.la no existeix.");
                        } else {
                            platja.getZones()[posZona].getOmbrelles()[pos].setLlogat(true);
                            codi = platja.getZones()[posZona].getOmbrelles()[pos].getCodi();
                        }
                    } while (pos == -1);

                    int hamaques = 0;
                    do {
                        System.out.println("Quantes hamaques vols?");
                        hamaques = dades.nextInt();
                    } while (hamaques < 0 && hamaques > 4);

                    for (int i = 0; i < hamaques; i++) {
                        do {
                            pos = platja.seleccionarHamaca();
                            if (pos == -1) {
                                System.out.println("\nL'hamaca no existeix.");
                            } else {
                                platja.getZones()[posZona].getOmbrelles()[pos].afegirHamaca(platja.getHamaques()[pos]);
                            }
                        } while (pos == -1);
                    }
                    break;

                default:
                    System.out.println("Selecciona una opció correcta");
                    break;
            }

        } while (opcio != 0);

        return codi;
    }

    public void mostrarLloguer() {
        System.out.println("\nLes dades del lloguer amb codi " + codi + " són:");
        System.out.println("\nEncarregat: " + dniEncarregat);
        System.out.println("\nElement lloguer: " + idElementLloguer);
        System.out.println("\nClient: " + dniClient);
        System.out.println("\nHora lloguer: " + horaLloguer.getHour() + ":" + horaLloguer.getMinute() + ":" + horaLloguer.getSecond());
        System.out.println("\nTemps lloguer: " + tempsLloguer.getHour() + ":" + tempsLloguer.getMinute());
        System.out.println("\nTotal pagar: " + totalPagar);
        if (pagat) {
            System.out.println("\nPagat");
        } else {
            System.out.println("\nPendent de pagar");
        }
    }
}
