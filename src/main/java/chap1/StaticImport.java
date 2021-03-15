package chap1;

import java.io.IOException;
import static java.lang.Integer.*;
import static java.lang.System.*;

public class StaticImport{ 

	public final static  void main(String[] args) {
		
		System.out.println(args.length);	//args asla null olmaz.
		System.out.println(MAX_VALUE);
		out.println("2");
		try {
			throw new IOException();
		} catch (IOException e) {
			
		}
		
	}
	
} 