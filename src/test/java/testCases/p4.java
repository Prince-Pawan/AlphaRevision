package testCases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class p4 {

	public static void main(String[] args) {
		
		String s="abccdefaa";
		char[] pi= s.toCharArray();
		
		int count=0;
		
		for(char c:pi)
		{
			for(int i=0;i<pi.length;i++)
			{
				if(c==pi[i])
				{
					count++;
				}
				
			}
			
				
			System.out.print(c +" repeated "+ count);
			count=0;
			System.out.println();
		}
		
		
		
		
		
		
	
		
	}

}
