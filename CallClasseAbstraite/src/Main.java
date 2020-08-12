import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
		   
		   Map<Integer, List<Etape>> map2 = listMain.stream()
		   .flatMap(m -> m.getEtapes().stream())
		   .collect(Collectors.groupingBy(Etape::getId));
		   
	}
	   
	   public static List<Main> listMain = new ArrayList<Main>(); 
	   public int id;
	   public List<Etape> listEtapes;
	   
	   public List<Etape> getEtapes(){
		   return listEtapes;
	   }
	   public int getId() {
		   return id;
	   }
	   
	   public void setId(int id) {
		   this.id = id;
	   }
	   
	   public List<Integer> getListeEntiers(){
		   List<Integer> list = new ArrayList<Integer>();
		   list.add(1);
		   list.add(2);
		   list.add(3);
		   list.add(4);
		   return list;
	   }
}

