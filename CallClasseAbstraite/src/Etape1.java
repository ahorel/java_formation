
public class Etape1 extends EtapesAbstract{
	public void treatment() {
		System.out.println("On passe dans l'�tape 1");
	}
	
	public void next(Etape etape) {
		etape.setState(new Etape2());
	}
	
	public void previous(Etape etape) {
		System.out.println("Pas d'�tape pr�c�dente");
	}
}