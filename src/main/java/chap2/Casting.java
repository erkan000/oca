package chap2;

public class Casting {

	public static void main(String[] args) {
		
		byte b = 123;		//8 bit
		short s = b ;		//16 bit
		int i = 7735;		//32 bit
		char c = 'A';		//16 bit
		long l = c ;		//64 bit
		
		
		
		byte bb = 'm' ;
		System.out.println(l);
			
		c = (char)s ;
		s = (short)c ;
		
		l=b;
		b=(byte)l;
		
		//SONUÇ BÜYÜK KÜÇÜĞE CAST A GEREK YOK, TERSİNDE İSE GEREK VAR.
				//CHAR VE SHORT HARİÇ
				
				System.out.println(parseFloat("0.0"));
				
				//short sonuc = c;
				//System.out.println(sonuc);
				//sadece short char a dönüşmüyor, diğerlerinde sorun yok
				
				//short char'a dönüşmez!!!!!!!!!!!
				//short ss = 10;		// 1    
				//char cc = ss;		// 2
				//ss = cc;       		// 3 
		
	}
	
	public static float parseFloat( String s ){
		   float f = 0.0f;
		   try{
		      f = Float.valueOf( s ).floatValue();
		      return f ;
		   }
		   catch(NumberFormatException nfe){
		      f = Float.NaN ;
		      return f;
		   }
		   finally{
		      f = 10.0f;
		      return f;
		   }
		}

}
