package sample;

public class Element {
    private int indice;
    private  int valeur;
    private  int poids;

    public Element(int indice, int valeur, int poids) {
        this.indice = indice;
        this.valeur = valeur;
        this.poids = poids;
    }

    public String str() {
        return "element numéro "+ this.indice + " [valeur = " + this.valeur + ", poids= " + this.poids + "]";
    }

    public int getIndice() {
        return this.indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public int getValeur() {
        return this.valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public int getPoids() {
        return this.poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

}
