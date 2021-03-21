package chap7;

public class SeninHatan extends Exception { 

	private static final long serialVersionUID = 4990761247481744529L;

	public SeninHatan() {
    }

    public SeninHatan(String aciklama) {
        super(aciklama); // dikkat
    }
}

