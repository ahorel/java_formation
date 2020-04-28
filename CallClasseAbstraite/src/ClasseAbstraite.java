import java.util.List;

	public abstract class ClasseAbstraite{
		public abstract List<String> traitement(List<String> list);
		public void traitementGlobal() {
			System.out.println("Traitement gllobal");
		}
	}

