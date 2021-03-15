package chap7;

public class ExceptionsTest {

	public static final int a=1;

	//static{
	{
		// Exception in initializer error
		System.out.println("init");
		int [] arr = {1,2};
		System.out.println(arr[5]);
	}

	public static void main(String[] args) {
		try {
			hesap();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{

		}
		new ExceptionsTest().a1();


	}

	static void hesap() throws Exception{
		//throw new Exception("s");
	}

	void a1(){
		a2();
	}
	void a2(){
		a1();
	}



}
