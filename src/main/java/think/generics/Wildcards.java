package think.generics;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.ExtendedSSLSession;

public class Wildcards {
   static void rawArgs(Holder holder, Object arg) {
	   //holder.set(arg);
	   //holder.set(new Wildcards());
	   
	 //  T t = holder.get();
	   Object obj = holder.get();
   }
   static void unboundedArg(Holder<?> holder, Object arg) {
	   //holder.set(arg);
	   // holder.set(new Wildcards());
	   //T t = holder.get();
	   Object obj = holder.get();
   }
   static <T> T exact1(Holder<T> holder) {
	   T t = holder.get();
	   return t;
   }
   static <T> T exact2(Holder<T> holder, T arg) {
	   holder.set(arg);
	   T t = holder.get();
	   return t;
	   }
   static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
//	   holder.set(arg);
	   
	  T t= holder.get();
	  return t;
   }
   
   static <T> void wildSupertype(Holder<? super T> holder, T arg) {
	   holder.set(arg);
	 //  T t = holder.get();
	   Object obj  = holder.get();
   }
   public static void main(String[] args) {
	   Holder raw = new Holder<Long>();
	   raw = new Holder();
	   Holder<Long> qualified = new Holder<Long>();
	   Holder<?> unbouned = new Holder<Long>();
	   Holder<? extends Long> bounded = new Holder<Long>();
	   Long lng = 1L;
	   
	   rawArgs(raw, lng);
	   rawArgs(qualified, lng);
	   rawArgs(unbouned,lng);
	   rawArgs(bounded,lng);
	   
	   unboundedArg(raw, lng);
	   unboundedArg(qualified, lng);
	   unboundedArg(bounded, lng);
	   unboundedArg(bounded, lng);
	   
	   Object r1 = exact1(raw);
	   Long r2 = exact1(qualified);
	   Object r3 = exact1(unbouned);
	   Long r4 = exact1(bounded);                                                                                                                                                                                                                                                                                                                                             
	   
	   Long r5 =exact2(raw,lng);
	   
	   Long r6 = exact2(qualified, lng);
	   
//	   /Long r7 = exact2(unbouned, lng); vs r3
	   
//	   Long r8 = exact2(bounded, lng);
	   
	   Long r9 = wildSubtype(raw, lng);
	   Long r10 = wildSubtype(qualified, lng);
	   
	   Object r11 = wildSubtype(unbouned, lng);
	   
   }
}
