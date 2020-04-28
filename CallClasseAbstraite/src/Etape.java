
public class Etape {
	private  EtapesAbstract state = new Etape1();
	public void setState(EtapesAbstract state) {
		this.state = state;
	}
	
	public void setPrevious() {
		getState().previous(this);
	}
	
	public void setNext() {
		getState().next(this);
	}

	public  EtapesAbstract getState() {
		return state;
	}
	public static class InnerEtape{
		public int nombre = 0;
		public void treatment() {
			System.out.println("Traitement de la nested classe");
		}
		public int getNombre() {
			return this.nombre;
		}
	}
}