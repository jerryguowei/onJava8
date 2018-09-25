package onJava8.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finding {
   public static void main(String args[]) {
	   Matcher m = Pattern.compile("\\w+")
			       .matcher("Evening is full of the linnet's wings");
	   System.out.println(m.groupCount());
	   while(m.find())
		   System.out.print(m.group(0) + " ");
	   System.out.println();
	   int i = 0 ;
	   while (m.find(i)) {
        System.out.print(m.group() + " ");	
        i++;
	}
   }
}
