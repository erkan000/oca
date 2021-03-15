package chap4;

class ArrayTest{
	public static int[     ] getArray() {
		return null;
	}
	public static void main(String[] args){
		int index = 1;
		try{
			getArray()[index=2]++;
		}catch (Exception e){}

		System.out.println("index = " + index);


		int i=0, j=10;
		int count=0;
		while (i<j) {
			i++;
			j--; 
			count++;
		}
		System.out.println(i+" "+j+" "+count);



	}

	Object arr[][] = new Object[][] {new String[]{""}, {} };
	//Object arr2[] = new Object[] {new String[]{""}, {} };




}

interface I1{
	void setValue(String s);
	String getValue();
	String getValue = "";
}