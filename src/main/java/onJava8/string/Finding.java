package onJava8.string;

import java.util.Calendar;

public class Finding {
   public static void main(String args[]) {
	   Calendar cal = Calendar.getInstance();
	   //cal.add(Calendar.DAY_OF_YEAR, -604);  //604-->2017-05-31
	   cal.add(Calendar.DAY_OF_YEAR, -269);  
	   System.out.println(cal.getTime());
	  
	   

   }
}
