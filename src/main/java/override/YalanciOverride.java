package override;

// Bu örnekte override yoktur!

class Polis {
	private void sucluYakala() {
		System.out.println("Polis.sucluYakala()");
	}
}

class SivilPolisT extends Polis {
	public void sucluYakala() {
		System.out.println("SivilPolis.sucluYakala()");
	}
}

public class YalanciOverride{
	public static void main(String[] args) {
		new SivilPolisT().sucluYakala();;
	}
}