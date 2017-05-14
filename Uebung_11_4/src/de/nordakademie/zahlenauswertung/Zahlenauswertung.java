package de.nordakademie.zahlenauswertung;

import javax.swing.*;
import java.util.ArrayList;

public class Zahlenauswertung {

    public static void main(String[] args) {
        ArrayList<Integer> zahlen = eingabe(new ArrayList<Integer>());

        double a = arithmetischesMittel(zahlen);
        ArrayList<Integer> zahlenImBereichUmMittelwert = zahlenImBereichUmWert(zahlen, a);

        System.out.println("Arithmetisches Mittel a         = " + a);
        System.out.println("Geometrisches Mittel g          = " + geometrischesMittel(zahlen));
        System.out.println("Anzahl eingegebener Zahlen      = " + zahlen.size());
        System.out.println("Zahlen zwischen 0,5*a und 1,5*a = " + zahlenImBereichUmMittelwert.size());
        System.out.println("Arithmetisches Mittel reduziert = " + arithmetischesMittel(zahlenImBereichUmMittelwert));
        System.out.println("Geometrisches Mittel reduziert  = " + geometrischesMittel(zahlenImBereichUmMittelwert));
    }

    private static ArrayList<Integer> eingabe(ArrayList<Integer> zahlen) {
        String eingabe = JOptionPane.showInputDialog("Bitte geben Sie eine ganze Zahl ein oder geben Sie nichts ein zum Beginn der Auswertung.");
        if ("".equals(eingabe) || eingabe == null) {
            return zahlen;
        } else {
            try {
                int zahl = Integer.valueOf(eingabe);
                zahlen.add(zahl);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Fehlerhafte Eingabe! Wert wird ignoriert!");
            }
            return eingabe(zahlen);
        }
    }

    private static double arithmetischesMittel(ArrayList<Integer> zahlen) {
        double summe = 0;
        for (int zahl : zahlen) {
            summe += zahl;
        }
        return summe / zahlen.size();
    }

    private static double geometrischesMittel(ArrayList<Integer> zahlen) {
        double produkt = 1;
        for (int zahl : zahlen) {
            produkt *= zahl;
        }
        return Math.pow(produkt, 1.0/zahlen.size());
    }

    private static ArrayList<Integer> zahlenImBereichUmWert(ArrayList<Integer> zahlen, double a) {
        ArrayList<Integer> zahlenImBereichUmWert = new ArrayList<>();
        for (int zahl : zahlen) {
            if (zahl >= 0.5*a && zahl <= 1.5*a) {
                zahlenImBereichUmWert.add(zahl);
            }
        }
        return zahlenImBereichUmWert;
    }

}
