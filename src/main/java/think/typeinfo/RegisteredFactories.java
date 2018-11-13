package think.typeinfo;

import java.util.ArrayList;
import java.util.List;

import think.typeinfo.factory.Factory;

class Part {
	public String toString() {
		return getClass().getSimpleName();
	}
	static List<Factory<? extends Part>> partFactories = new ArrayList<>();
}
public class RegisteredFactories {

}
