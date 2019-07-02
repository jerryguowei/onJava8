package think.generics;

public class GenericArray<T> {
	private T[] array;
	
	@SuppressWarnings("unchecked")
	public GenericArray(int sz) {
		array = (T[]) new Object[sz];
	}
	public void put(int index, T item) {
		array[index] = item;
	}
	public T get(int index) {
		return array[index];
	}
	
	public T[] rep() {
		return array;
	}
	public static void main(String[] args) {
		GenericArray<Integer> gai = new GenericArray<>(10);
		gai.put(0, 2);
		
//	    Integer[] b = gai.rep();
		Object[] oa = gai.rep();
		Integer a = gai.get(0);
		System.out.println(a);
		
		Object[] ab = (Object[]) new Integer[10];
	}
	
}
