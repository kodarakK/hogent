package cui;

import domein.DomeinController;

public class DobbelsteenApplicatie {
    private DomeinController dc;

    public DobbelsteenApplicatie(DomeinController dc) {
        this.dc = dc;
    }

    public void start() {
        // SSD lezen

        dc.startNieuwSpel();

        do {
            dc.rolDobbelstenen();
            System.out.printf("Aantal ogen is %d%n", dc.geefAantalOgen());
        } while (!dc.isEindeSpel());

        System.out.printf("Score is %d%n", dc.geefScore());
    }
}
