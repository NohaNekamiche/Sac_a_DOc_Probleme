package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Hello World");
        //primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.setScene(scene);
        primaryStage.show();
       /* Element e1=new Element(0,15,25);
        Element e2=new Element(0,120,5);
        Element e3=new Element(0,19,30);
        Element e4=new Element(0,10,15);
        Element e5=new Element(0,26,8);
        Element e6=new Element(0,31,35);
        Element e7=new Element(0,25,3);
        Element e8=new Element(0,5,49);
        Element e9=new Element(0,1,32);
        ArrayList<Element> elements = new ArrayList<>();
        elements.add(e1);
        elements.add(e2);
        elements.add(e3);
        elements.add(e4);
        elements.add(e5);
        elements.add(e6);
        elements.add(e7);
        elements.add(e8);
        elements.add(e9);
        Algorithme algo=new Algorithme(elements,45);
        Solution sol =new Solution();


        sol= algo.resoudre();
        algo.afficher();
        sol.afficher();*/
    }


    public static void main(String[] args) {
        launch(args);
    }
}
