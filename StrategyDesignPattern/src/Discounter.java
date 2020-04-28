import java.math.BigDecimal;

//Functional interface car :
//Functional because BigDecimal has only one abstract non-Object method
public interface Discounter {
    BigDecimal applyDiscount(BigDecimal amount);  		  
    boolean equals(Object obj);
    
    //Remplace la méthode applyDiscount dans les classes d'implementations EasterDiscounter et ChrismtasDiscounter
    static Discounter christmasDiscounter() {
        return amount -> amount.multiply(BigDecimal.valueOf(0.9));
    }
 
    static Discounter newYearDiscounter() {
        return amount -> amount.multiply(BigDecimal.valueOf(0.8));
    }
 
    static Discounter easterDiscounter() {
        return amount -> amount.multiply(BigDecimal.valueOf(0.5));
    }
}


@FunctionalInterface
interface Square 
{ 
    int calculate(int x); 
} 
  
class Test 
{ 
    public static void main(String args[]) 
    { 
        int a = 5; 
  
        // lambda expression to define the calculate method 
        Square s = (int x)->x*x; 
  
        // parameter passed and return type must be 
        // same as defined in the prototype 
        int ans = s.calculate(a); 
        System.out.println(ans); 
    } 
} 
