package chap5;

public class LabelledBreakTest {

	public static void main(String[] args) {
		erkin : for (int i = 0; i < 10; i++) {
			ayse : for (int j = 0; j < 10; j++) {
				System.out.println("j:" + j);
				break erkin;
			}
			System.out.println("i:" + i);
		}
	System.out.println("devam");
	}

}
