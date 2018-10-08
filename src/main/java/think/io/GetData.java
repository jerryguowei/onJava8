package think.io;

import java.nio.ByteBuffer;

public class GetData {
	public static final int BSIZE = 1024;

	public static void main(String[] args) {
       ByteBuffer bb = ByteBuffer.allocate(BSIZE);
       int i = 0;
       while(i++ < bb.limit())
    	   if(bb.get() !=0 )
    		   System.out.println("nonezero");
       System.out.println("i = " + i);
       
       bb.rewind();
       bb.asCharBuffer().put("Howday!");
       char c;
       while((c = bb.getChar()) !=0)
    	   System.out.print(c + " ");
       System.out.println();       
       bb.asShortBuffer().put((short)471142);
       
       
	}
}
