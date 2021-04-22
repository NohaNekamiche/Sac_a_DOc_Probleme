package sample;

import java.util.ArrayList;

public class Solution {
    // liste des éléments à mettre dans le sac pour avoir le profit maximal
    public ArrayList<Element> elements;
    // valeur maximale possible
    public int profit;

    public Solution(){

    }
    public Solution(ArrayList<Element> elements, int profit) {
        this.elements = elements;
        this.profit = profit;
    }

    public void afficher() {
        if (elements != null  &&  !elements.isEmpty()){
            System.out.println("\nla solution du TP");
            System.out.println("Profit maximale = " + profit);
            System.out.println("les éléments à sélectionner :");

            for (Element element : elements) {
                System.out.println("- " + element.str());
            }
        }
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    public void setElements(ArrayList<Element> elements) {
        this.elements = elements;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }
}
