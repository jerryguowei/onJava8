package onJava8.functional;

class Dog {
	String name;
	int age = -1;
	Dog() {
		name = "stray";
	}
	Dog(String nm){
		name = nm;
	}
	Dog(String nm, int yrs){
		name =nm;
		age =yrs;
	}
}
interface MakeNoArgs  {
	Dog make();
}
interface Make1Arg {
	Dog make(String nm);
}
interface Make2Args{
	Dog make(String nm, int age);
}
public class CtorReference {
	public static void main(String[] args) {
		MakeNoArgs make0 = Dog::new;
		Make1Arg make1 = Dog::new;
		Make2Args make2 = Dog::new;

		Dog dog1 = make0.make();
		Dog dog2 = make1.make("Hi");
		Dog dog3 = make2.make("hi", 1);
		new Thread(()->{System.out.println(Thread.currentThread().getName());}).start();
	}
}
