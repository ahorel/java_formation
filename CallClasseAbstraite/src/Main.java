import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	
	/*
	public static void main(String[] args) {
		ClasseAbstraite c = new SousClasseA();
		List<String> list = c.traitement(new ArrayList<String>());
		list.stream().forEach(System.out::println);
		c.traitementGlobal();
		
		
		Etape etape = new Etape();
		etape.setState(new Etape1());
		etape.getState().treatment();
		etape.setNext();
		etape.setState(new Etape2());
		etape.getState().treatment();
		
		
		Etape.InnerEtape innerEtape = new Etape.InnerEtape();
		innerEtape.treatment();
	
		
	}
	*/
	
	   public static void main(String args[]) {

		   Map<Integer,List<String>> map = new HashMap<Integer,List<String>>();
		   map.put(0, Arrays.asList("a","b","c","d"));
		   map.put(1, Arrays.asList("e","f","g","h"));
		   map.put(2,Arrays.asList("i","j","k","l"));
		   
		   //Retourn une liste de string map.values().stream():
		   
		   map.forEach((u,v) -> 
		   		v.stream().forEach(System.out::println));
				   
	   }
}

