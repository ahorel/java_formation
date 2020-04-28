import java.util.List;

public class SousClasseB extends ClasseAbstraite {
	public List<String> traitement(List<String> list) {
		list.add("1er element");
		list.add("2eme element");
		return list;
	}
}

