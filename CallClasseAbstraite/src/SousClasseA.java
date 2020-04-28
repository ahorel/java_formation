import java.util.List;

public class SousClasseA extends ClasseAbstraite{
	public List<String> traitement(List<String> list) {
		list.add("1er element");
		return list;
	}
}
