package sample;

import java.util.ArrayList;

public class Algorithme {

    private ArrayList<sample.Element> elements;//elements de notre problème
    private int capacite ; //capcaite du sac

    public Algorithme(ArrayList<Element> elements, int capacite) {
        this.elements = elements;
        this.capacite = capacite;
    }

    // méthode qui va retourner la solution de notre problème
    public Solution resoudre()
    {   int w = capacite ;
        ArrayList<sample.Element> elementsSolution = new ArrayList<sample.Element>();
        int nbr_elts = elements.size();
        sample.Element elementTab[] = new sample.Element[nbr_elts];
        for (int i=0 ; i< nbr_elts ; i++)
        {
            elementTab[i] = elements.get(i);

        }

        // on utilise une matrice pour stocker le profit maximal à l'ajout de n-ième element
        int[][] matrice = new int[nbr_elts+1][capacite+1];
        // on va initialiser la première de la matrice à 0
        for (int i=0; i<= capacite ;i++)
        {
            matrice[0][i] = 0 ;

        }
        // we iterate on items
        for (int i=1; i <= nbr_elts ; i++)
        {  //we iterate on each capacity
            for (int j=0; j<= capacite; j++)
            {
                if (elementTab[i-1].getPoids()>j)
                    matrice[i][j] = matrice[i-1][j];
                else //on maximise le profit à ce rang dans la matrice
                    matrice[i][j]= Math.max(matrice[i-1][j],matrice[i-1][j-elementTab[i-1].getPoids()]
                            +elementTab[i-1].getValeur());
            }
            //Nous trouverons le profit maximal dans la case  matrice[nbr_elts][capacite]
            //Il nous reste à afficher la liste des elements selectionnés
            int res= matrice[nbr_elts][capacite];


            for (int k=nbr_elts ; k >0 && res > 0 ; k-- )
            {
                if (res != matrice[k-1][w]){
                    elementsSolution.add(elementTab[k-1]);
                    res -= elementTab[k-1].getValeur();
                    w -= elementTab[k-1].getPoids();
                }
            }

        }
        return new Solution(elementsSolution, matrice[nbr_elts][capacite]);
    }

    public void afficher ()
    {
        if (elements != null && elements.size() >0){
            System.out.println("les données");
            System.out.println ("Capacite : "+capacite);
            System.out.println("les elements :");

            for (sample.Element element : elements){
                System.out.println("- "+element.str());
            }
        }
    }
    public ArrayList<Element> getElements() {
        return elements;
    }

    public void setElements(ArrayList<Element> elements) {
        this.elements = elements;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite= capacite;
    }
}
