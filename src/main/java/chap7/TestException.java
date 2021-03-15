package chap7;

public class TestException {
	public static void main(String[] args) {
		try{
			doTest();
		}
		catch(MyException me){
			//System.out.println(me);
			//me.printStackTrace();
			System.out.println(me.getMessage());
		}
	}

	static void doTest() throws MyException{
		int[] array = new int[10];
		array[10] = 1000;
		doAnotherTest();
	}

	static void doAnotherTest() throws MyException{
		throw new MyException("Exception from doAnotherTest");
	}
}
class MyException extends Exception {

	private static final long serialVersionUID = 5414848436830017585L;

	public MyException(String msg){
		super(msg);
	}
}
