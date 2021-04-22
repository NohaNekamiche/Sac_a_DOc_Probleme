package sample;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller implements Initializable{

    private ObservableList<String> objects,objetsfinal;
    static private ArrayList<Element> elements = new ArrayList<>();
    private Element e;
    private int indice=1;
    static  private  int poidsSac=0;

    @FXML
    private Button start_btn;
    @FXML
    private TextField capaciteSac;
    @FXML
    private TextField nbObjets;
    @FXML
    private TextField poidsObjet;
    @FXML
    private TextField gainObjet;
    @FXML
    private Button addObjet_btn;
    @FXML
    private Button creerSolution;
    @FXML
    private ListView<String> listObjets;
    @FXML
    private Label err_msg;
    @FXML
    private Button AfficherSolution;
    @FXML
    private TextField capaciteMax;
    @FXML
    private TextField profilMax;
    @FXML
    private ListView<String> listsol;

    public void goToSecondScene(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if(event.getSource()==start_btn){
        stage = (Stage) start_btn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("secondpage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();}
    }
    public void setObjet(ActionEvent event){
            String objet="Poids : "+poidsObjet.getText()+ "\n"+"Gain : "+gainObjet.getText();

            if(objects.size() < Integer.parseInt(nbObjets.getText())){
                e=new Element(indice,Integer.parseInt(gainObjet.getText()),Integer.parseInt(poidsObjet.getText()));
                System.out.println(e.str());
                elements.add(e);
                objects.add(objet);
                listObjets.setItems(objects);
                this.err_msg.setText("");
            }
            else{
                this.err_msg.setText("vous avez depasser le nombres \n maximales de votre objects >");
            }
    }

    public void creerSol(ActionEvent event) throws IOException{

        Stage stage;
        Parent root;
        poidsSac=Integer.parseInt(capaciteSac.getText());
        System.out.println("poids="+poidsSac);
        if(event.getSource()==creerSolution){
            stage = (Stage) creerSolution.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("solution.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
    }

    public void AfficherSolution(ActionEvent event) throws IOException{
        System.out.println("poids="+poidsSac);
        Algorithme algo=new Algorithme(elements,poidsSac);
        Solution sol =new Solution();
        sol= algo.resoudre();
        algo.afficher();
        sol.afficher();
        profilMax.setText(String.valueOf(sol.getProfit()));
        capaciteMax.setText(String.valueOf(algo.getCapacite()));
        int i=0;
        for(Element e:sol.getElements()){
            String objet="Poids : "+String.valueOf(e.getPoids())+ "\n"+"Gain : "+String.valueOf(e.getPoids());
            objetsfinal.add(objet);
        }
        listsol.setItems(objetsfinal);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        objects = FXCollections.observableArrayList();
        objetsfinal = FXCollections.observableArrayList();

    }
}
