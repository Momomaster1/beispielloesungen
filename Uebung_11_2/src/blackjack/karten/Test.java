package blackjack.karten;

public class Test {

    public static void main(String[] args) {

        Spielkartenstapel stapel = new Spielkartenstapel();

        for (int i=0; i<200; i++) {
            try {
                stapel.getObersteKarte();
            } catch (LeererKartenstapelException e) {
                System.out.println("*** Mische Kartenstapel ***");
                stapel.neuMischen();
                System.out.println(stapel.getTextdarstellung());
                stapel.getObersteKarte();
            }
            System.out.println(stapel.getTextdarstellung());
        }

    }

}
