package blackjack.exceptions;

public class LeererKartenstapelException extends IllegalStateException {

    public LeererKartenstapelException() {
        super("Der Kartenstapel ist leer!");
    }

}
