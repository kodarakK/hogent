package main;

import cui.DobbelsteenApplicatie;
import domein.DomeinController;

public class StartUp {
    
    public static void main(String[] args) {
        DomeinController domeinController = new DomeinController();
        DobbelsteenApplicatie applicatie = new DobbelsteenApplicatie(domeinController);
        applicatie.start();
    }
}
