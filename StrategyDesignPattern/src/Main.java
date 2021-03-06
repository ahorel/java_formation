import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/*
public class CallDiscounterFunctionalInterface implements Discounter {
	
	public void call() {
		Discounter.easterDiscounter();
		Discounter.christmasDiscounter();
		Discounter.newYearDiscounter();
	}
}*/

public class Main implements Interface1{

	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(1,"a");
		map.put(2,"b");
		map.put(3,"c");
		
		Iterator it1 = map.entrySet().iterator();
		Iterator it2 = map.keySet().iterator();
		
		while(it1.hasNext()) {
			Map.Entry str = (Map.Entry) it1.next();
			System.out.println( (String) str.getValue());
			System.out.println(str.getKey());

		}
		
		
		
		Discounter easterDiscounter = amount -> amount.multiply(BigDecimal.valueOf(0.5));
		Discounter christmasDiscounter = amount -> amount.multiply(BigDecimal.valueOf(0.8));
		
 		List<Discounter> list = Stream.of(easterDiscounter, christmasDiscounter)
			      .collect(Collectors.toList());
		
		/*
		List<Discounter> discounters = new ArrayList(
				  amount -> amount.multiply(BigDecimal.valueOf(0.9)),
				  amount -> amount.multiply(BigDecimal.valueOf(0.8)),
				  amount -> amount.multiply(BigDecimal.valueOf(0.5))
				);
		*/
		
		/*
		List<Discounter> discounters = new ArrayList() {{
				  add(amount -> amount.multiply(BigDecimal.valueOf(0.9)));
				  add(amount -> amount.multiply(BigDecimal.valueOf(0.8)));
				  add(amount -> amount.multiply(BigDecimal.valueOf(0.5)));
		}};
		*/
		

		
		Main main = new Main();
		Main.Inner inner = main.new Inner();		
		inner.log("chaine de caract�re");
				
	}
	
	
	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}
	

	/*
	@Override
	public void log(String str) {
		// TODO Auto-generated method stub
		Interface1.super.log(str);
	}
	*/
	
	//Appel de la m�thode log d�clar�e par l'interface 1, lorsque la clase Main n'impl�mente qu'une seule interface
	public void handler() {
		log("appel de la m�thode log depuis interface ?");
	}
	
	//Si plusieurs interfaces, diamond problem, on doit impl�menter la method log dans la classe d'implementation
	//De la mani�re suivante :
	/*public void log() {
		Interface1.super.log("appel de la m�thode log depuis interface 1");
	}
	*/
	
	//Cr�ation d'une classe Inner impl�mentant les deux interfaces
	public class Inner implements Interface1, Interface2{
		//Appel de la m�thode log d�clar�e par l'interface 1, lorsque la clase Main n'impl�mente qu'une seule interface
		public void handler() {
			Main.this.log("appel de la m�thode log depuis interface ?");
		}
		//T test = test -> test.create("","");
		//Si plusieurs interfaces, diamond problem, on doit impl�menter la method log dans la classe d'implementation
		//De la mani�re suivante :
		public void log() {
			Interface1.super.log("");
		}

		@Override
		public void method1() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public String method2() {
return "";			
		}
		
		//M�thode appel�e depuis la m�thode Main lorsque la inner class impl�mente plusieurs interfaces
		//Il est n�cessaire d'override la m�thode log.
		@Override
		public void log(String str) {
			Interface2.super.log(str);
		}
	}



}
