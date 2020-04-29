package problems;

import java.util.Collections;
import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		 * int n=0;System.out.println("Enter size of the array: "); n = sc.nextInt();
		 */
		int array[] = new int[8];   //assuming size to be 8
		for(int i=0;i<8;i++) {
			array[i]=sc.nextInt();
		}
		for(int i=0 ; i<7 ;i++) {
			for(int j=i+1;j<8;j++) {
				if(array[i]==array[j]) {
					int t = array[j];
					int k=j;
					for(;k<7;k++) {
						array[k]=array[k+1];
					}
					array[k]=t;	
					
				}
				
			}
			for(int f=0;f<8;f++) {
				System.out.print(array[f]+" ");
			}
			System.out.println();
		}
		

		
	}

}
