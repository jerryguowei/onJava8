package jerry.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class XmlToJson {

	public static void main(String[] args) {
	   String sqlFilePath = "C:" + File.separator + "temp" + File.separator + "accounting.json"; // TODO: change it according
	   
	   String textJson = "src/main/resources/accounting.xml";
      File inputFile =  new File(textJson);
      StringBuffer sb = new StringBuffer();
      
      try(BufferedReader  reader = new BufferedReader(new FileReader(inputFile))){
    	  String tempString;
    	  while((tempString = reader.readLine())!= null) {
    		  sb.append(tempString + "\n");
    	  }
//    	  JSONObject object = new JSONObject(sb.toString())
//    	  JSONObject object = XML.toJSONObject(sb.toString());
//    	  System.out.println(object);
//    	  object.write(new BufferedWriter(new FileWriter(new File("src/main/resources/accounting.json"))));
////System.out.println(sb.toString());
    	 ArrayList<ArrayList<String>> list = new ArrayList<>();
    	 list.add(new ArrayList<>());
    	 System.out.println(list.isEmpty());
    	 
      }catch (Exception e) {
		e.printStackTrace();
	}
      
      
	}

}
