
package customExceptions;

@SuppressWarnings("serial")
public class EvenNumberException extends Exception{
	
		private int num;
		
		public EvenNumberException(int n) {
			super("The number introduced is invalid. "+n + " is an even number");
			num = n;
		}
		
		public int getNum() {
			return num;
		}
	}

