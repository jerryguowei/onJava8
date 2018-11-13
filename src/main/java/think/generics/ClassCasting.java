package think.generics;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class ClassCasting {
	public void f(String[] args) throws Exception{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
		@SuppressWarnings("unchecked")
		List<Widget> lw2 = List.class.cast(in.readObject());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
