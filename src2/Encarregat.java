
import java.util.Scanner;

/**
 *
 * @author fta
 */

public class Encarregat {

    private String dni;
    private String nom;
    private String adreca;

    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe
     Accions:
     - Assignar als atributs els valors passats com a paràmetres
     */
    
    public Encarregat(String dni, String nom, String adreca) {
        this.dni = dni;
        this.nom = nom;
        this.adreca = adreca;
    }

    /*
     Mètodes accessors    
     */

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }
   
    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou encarregat de zona.
       Les dades a demanar són les que passem per paràmetre en el constructor.
     - També heu de tenir en compte que tant el nom com l'adreça, poden ser frases,
       per exemple, Francesc Xavier, o bé, c/ Pau Casals, 42.
     Retorn: El nou encarregat de zona creat.
     */
    
    public static Encarregat nouEncarregat() {
        Scanner kb = new Scanner(System.in);
        String Idni,Inom,Iadreca;
        System.out.print("DNI: ");
        Idni=kb.nextLine();
        System.out.print("Nom: ");
        Inom=kb.nextLine();
        System.out.print("Adreça: ");
        Iadreca=kb.nextLine(); 

        return new Encarregat(Idni,Inom,Iadreca);

    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
       i modificar els atributs corresponents d'aquest objecte.
     - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte
       actual, abans de modificar-los.
     Retorn: cap
     */
    
    public void modificarEncarregat() {
        Scanner kb = new Scanner(System.in);
        System.out.println("\n\n----Dades a canviar----");
        mostrarEncarregat();
        String Idni,Inom,Iadreca;
        System.out.println("\n\n----Inserisión de les noves dades----");
        System.out.print("Nou DNI: ");
        Idni=kb.nextLine();
        System.out.print("Nou nom: ");
        Inom=kb.nextLine();
        System.out.print("Nova adreça: ");
        Iadreca=kb.nextLine();
        dni = Idni;
        nom = Inom;
        adreca = Iadreca;
        System.out.println("\n\n----Noves dades----");
        mostrarEncarregat();
    }

    public  void mostrarEncarregat() {
        System.out.println("\nLes dades de l'encarregat amb dni " + dni + " són:");
        System.out.println("\nNom:" + nom);
        System.out.println("\nAdreça:" + adreca);
    }
       public static void main(String [ ] args){
           Encarregat enc = nouEncarregat();
           enc.mostrarEncarregat();
           enc.modificarEncarregat();
    }
}
