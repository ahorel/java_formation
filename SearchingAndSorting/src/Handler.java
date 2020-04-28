public class Handler {
	public String nonStaticVariable = "nonStaticVariable";
	public static String staticVariable = "staticVariable";
	
	public static void main(String[] args) {
		RankNode root = new RankNode(20);

		//Call inner class (non static nested)
		Handler outer = new Handler();
		Handler.InnerClass inner = outer.new InnerClass();
		
		//Call static nested class
		StaticNestedClass staticNested = new Handler.StaticNestedClass();
 		
		int rank = root.getRank(23);
	}
	
	public String treatmentWithLocalClass() {
		//Local Class : accès aux membres statiques et non statiques
		class LocalClass {
			Handler handler = new Handler();
				
				String localMethod() {
					handler.nonStaticVariable = "1";
					handler.staticVariable = "1";
					
					return handler.nonStaticVariable + handler.staticVariable;
				}
				
 		}
		
		LocalClass localClass = new LocalClass();
		return localClass.localMethod();
		
		
	}
	//Pour une inner Class
	public class InnerClass {
		//Acces aux membres non statiques uniquement 
		public String getOuterNonStaticVariable() {
			return Handler.this.nonStaticVariable;
		}
	}
	
	public static class StaticNestedClass {
		//Acces aux membres statiques et non statiques
		public String getOuterVariable() {
			Handler handler = new Handler();
			handler.nonStaticVariable = "1";
			handler.staticVariable = "1";
			return Handler.staticVariable;
		}
		
	}
	
	//Singleton  class
	private Handler() {}

	private static class SingletonHelper{
		private static final Handler instance = new Handler();
	}
	
	public static Handler getInstance() {
		return SingletonHelper.instance;
	}
}