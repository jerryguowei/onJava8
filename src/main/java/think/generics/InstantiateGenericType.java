package think.generics;

class ClassAsFactory<T> {
	T x;
	public ClassAsFactory(Class<T> kind) {
		try {
			x = kind.newInstance();
		}catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
class Employee {}
public class InstantiateGenericType {
	public static void main(String[] args) {
		ClassAsFactory<Employee> fe = new ClassAsFactory<>(Employee.class);
		System.out.println("ClassFactory<Employee> successed");
		try {
			ClassAsFactory<Integer> fi = new ClassAsFactory<>(Integer.class);
		}catch (Exception e) {
           System.out.println("ClassAsFactory(Integer> failed");
		}
	}

}
