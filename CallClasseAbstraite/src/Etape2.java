
public class Etape2 extends EtapesAbstract{
	public void treatment() {
		System.out.println("On passe dans l'�tape 2");
	}
	
	public void previous(Etape etape) {
		etape.setState(new Etape1());
	}
	
	public void next(Etape etape) {
		System.out.println("Pas d'�tape suivante");
	}
}