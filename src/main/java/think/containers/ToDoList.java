package think.containers;

import java.util.concurrent.PriorityBlockingQueue;

public class ToDoList extends PriorityBlockingQueue<ToDoList.ToDoItem>{

	private static final long serialVersionUID = -7034752644427360526L;

	static class ToDoItem implements Comparable<ToDoItem>{
        private char primary;
        private int secondary;
        private String item;
        public ToDoItem(String td, char pri, int sec) {
        	primary = pri;
        	secondary = sec;
        	item = td;
        }
		@Override
		public int compareTo(ToDoItem arg) {
			if(primary > arg.primary)
				return 1;
			if(primary == arg.primary)
				if(secondary > arg.secondary)
					return 1;
				else if (secondary == arg.secondary)
					return 0;
			return -1;
		}
		public String toString() {
			return Character.toString(primary) + secondary + item;
		}
		public static void main(String[] args) {
			
		}
	}

}
