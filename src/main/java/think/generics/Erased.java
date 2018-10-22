package think.generics;

public class Erased<T> {
   private final int SIZE = 100;
   public  void f(Object arg) {
	   //if(arg instanceof T) {}//
	 //  T var = new T();
	   //T[] array = new T[SIZE];
	   T[] array1=(T[]) new Object[SIZE];
   }
}
