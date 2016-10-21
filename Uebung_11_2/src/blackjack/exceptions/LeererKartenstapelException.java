package blackjack.exceptions;

public class LeererKartenstapelException extends IllegalStateException {

	private static final long serialVersionUID = 1L;

	public LeererKartenstapelException() {
        super("Der Kartenstapel ist leer!");
    }

}
