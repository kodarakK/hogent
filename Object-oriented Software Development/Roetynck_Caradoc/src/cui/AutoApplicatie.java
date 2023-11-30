package cui;

import java.util.Scanner;

import domein.Auto;

public class AutoApplicatie {
    public static void main(String[] args) {
        new AutoApplicatie().start();
    }

    private Scanner sc = new Scanner(System.in);
    private static final int KEUZE1 = 1;
    private static final int KEUZE2 = 2;

    private void start() {

        Auto auto;
        double gem = 0;
        int aantalAutos = 0;
        boolean isAuto = false;
        double totVergoeding = 0;
        int aantalAutosMetVergoeding = 0;

        int keuze = geefKeuze();
        while (keuze != -1) {

            isAuto = true;

            switch (keuze) {
                case KEUZE1 -> {
                    auto = new Auto(false, geefAantalKilometers(), 1);
                }
                case KEUZE2 -> {
                    auto = new Auto(geefAantalKilometers(), geefVergoeding());
                }
                default -> {
                    auto = new Auto(geefVergoeding());
                }

            }
            if (auto.heeftExtraVergoeding())
                aantalAutosMetVergoeding++;

            totVergoeding += auto.berekenTotaleVergoeding();

            aantalAutos++;
            keuze = geefKeuze();
        }

        if (isAuto) {
            gem = totVergoeding / aantalAutos;
            System.out.printf("Er %s %d auto%s waar je recht hebt op extra vergoeding%n",
                    (aantalAutosMetVergoeding > 1) ? "zijn" : "is",
                    aantalAutosMetVergoeding,
                    (aantalAutosMetVergoeding > 1) ? "'s" : "");

            System.out.printf("Gemiddelde totale vergoeding is %.2f%n", gem);

        } else {
            System.out.println("Geen auto's ingegeven");
        }
    }

    private int geefVergoeding() {
        System.out.print("Geef vergoeding: ");
        return sc.nextInt();
    }

    private double geefAantalKilometers() {
        System.out.print("Geef aantal kilometers: ");
        return sc.nextDouble();
    }

    private int geefKeuze() {
        int keuze;
        boolean geldig;

        do {
            System.out.println("1: niet elektrische auto");
            System.out.println("2: elektrische auto met aantal kilometers en vergoeding");
            System.out.println("3: elektrische auto met vergoeding");
            System.out.println("-1: stoppen");
            keuze = sc.nextInt();
            geldig = keuze >= -1 && keuze <= 3 && keuze != 0;
        } while (!geldig);

        return keuze;
    }
}
