package customExceptions;

@SuppressWarnings("serial")
public class BigNumberException extends Exception{

	private int num;
	
	public BigNumberException(int n) {
		super("The number introduced is invalid. "+n + " is too big for capacity");
		num = n;
	}
	
	public int getNum() {
		return num;
	}
}
