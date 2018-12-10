package onJava8.functional;

class This {
	void two(int i, double d) {}
	void three(int i, double d, String s) {}
	void four(int i, double d, String s, char c) {}
}

interface TwoArgs{
	void  call2(This athis, int i, double d);
}
interface ThreeArgs{
	void call3(This athis, int i, double d, String s);
}
interface FourArgs{
	void call4(This athis, int i, double d, String s, char c);
}
public class MultiUnbound {
	public static void main(String[] args) {
		TwoArgs twoargs = This::two;
		ThreeArgs threeargs = This::three;
		FourArgs fourargs = This::four;
		twoargs.call2(new This(), 1, 11.2);
		new Thread(()->{}).start();
		
	}
}
