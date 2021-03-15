package chap4;

public class SystemArrayCopy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] scores1 = { 0, 1, 2, 3, 4};
        int scores2[] = { 5, 6, 7, 8, 9};
        
        System.arraycopy(scores1, 2, scores2, 0, 2);
        
        for(int i :  scores2) System.out.print(i);
        
        //System.arraycopy(scores1, 3, scores2, 0, 3); //ArrayIndexOutOfBoundsException
        //System.arraycopy(scores1, 3, scores2, 4, 2); //ArrayIndexOutOfBoundsException
        
        String ss = "erkan";
        System.out.println(ss.intern());
        System.out.println(ss.intern());
        String ss2 = "erkan";
        System.out.println(ss.intern());
        

	}

}
