package refactoring_av;
import java.util.ArrayList;

public class Client {
	private String nif;
    private String nom;
    private String telefon;
    private ArrayList<Lloguer> lloguers;

    public Client(String nif, String nom, String telefon) {
        this.nif = nif;
        this.nom = nom;
        this.telefon = telefon;
        this.lloguers = new ArrayList<Lloguer>();
    }

    public String getNif()     { return nif;     }
    public String getNom()     { return nom;     }
    public String getTelefon() { return telefon; }

    public void setNif(String nif) { this.nif = nif; }
    public void setNom(String nom) { this.nom = nom; }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public void afegeix(Lloguer lloguer) {
        if (! lloguers.contains(lloguer) ) {
            lloguers.add(lloguer);
        }
    }
    public void elimina(Lloguer lloguer) {
        if (lloguers.contains(lloguer) ) {
            lloguers.remove(lloguer);
        }
    }
    public boolean conte(Lloguer lloguer) {
        return lloguers.contains(lloguer);
    }
    /*
    public String informe() {
        String resultat = "Informe de lloguers del client " +
            getNom() + " (" + getNif() + ")\n";
        for (Lloguer lloguer: lloguers) {         	
            resultat += "\t" +
                lloguer.getVehicle().getMarca() +
                " " +
                lloguer.getVehicle().getModel() + ": " +
                (lloguer.quantitat() * 30) + "�" + "\n";
        }
        // afegeix informaci� final
        resultat += "Import a pagar: " + ImportTotal() + "�\n" +
            "Punts guanyats: " + bonificacionsTotals() + "\n";
        return resultat;
    }*/
    public String informe() {
    	return composaCapsalera() +
    			composaDetall() +
    			composaPeu();
    }
    public String composaCapsalera() {
    	 String resultat = "Informe de lloguers del client " + getNom() + " (" + getNif() + ")\n";
    	 return resultat;
    }
    public String composaDetall() {
    	String resultat = "";
    	for (Lloguer lloguer: lloguers) {         	
             resultat += "\t" +
                 lloguer.getVehicle().getMarca() +
                 " " +
                 lloguer.getVehicle().getModel() + ": " +
                 (lloguer.quantitat() * 30) + "�" + "\n";
         }
    	return resultat;
    }
    public String composaPeu() {
    	String resultat = ""; 
    	resultat += "Import a pagar: " + ImportTotal() + "�\n" +
    	            "Punts guanyats: " + bonificacionsTotals() + "\n";
    	return resultat;
    }
    //////////////////////////////////////////////
    public String informeHTML() {
    	return composaCapsaleraHTML() +
    			composaDetallHTML() +
    			composaPeuHTML();
    }
    public String composaCapsaleraHTML() {
    	 String resultat = "<h1>Informe de lloguers</h1>\n" +
    			 			"<p>Informe de lloguers del client <em>" + 
    			 			getNom() + "</em> (<strong>" + getNif() + "<strong>)</p>\n";
    	 return resultat;
    }
    public String composaDetallHTML() {
    	String resultat = "<table><tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr><tr><td>Tata</td><td>Vista</td><td>90.0�</td></tr><tr><td>Wolswagen</td><td>Passat</td><td>270.0�</td></tr><tr><td>Mercedes</td><td>SLK 2.0</td><td>360.0�</td></tr></table>";
    	for (Lloguer lloguer: lloguers) {         	
             resultat += "\t" +
                 lloguer.getVehicle().getMarca() +
                 " " +
                 lloguer.getVehicle().getModel() + ": " +
                 (lloguer.quantitat() * 30) + "�" + "\n";
         }
    	return resultat;
    }
    
    public String composaPeuHTML() {
    	String resultat = ""; 
    	resultat += "<p>Import a pagar: <em>" + ImportTotal() + "�<em></p>\n" +
    	            "Punts guanyats: <em>" + bonificacionsTotals() + "<em></p>\n";
    	return resultat;
    }
    
    
    ///////////////////////////////////////////////
    public double ImportTotal() {
    	double total = 0;
    	for (Lloguer lloguer: lloguers)
    		total += lloguer.quantitat() * 30;
    	return total;
    }
    
    public int bonificacionsTotals() {
    	int bonificacions = 0;
    	for (Lloguer lloguer: lloguers)      
          	bonificacions += lloguer.bonificacions();
        return bonificacions;
    }

}