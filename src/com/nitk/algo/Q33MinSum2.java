package com.nitk.algo;

import java.util.Scanner;

public class Q33MinSum2 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		/*---User input---*/
		System.out.print("Enter array number space seperated:");
		String s= sc.nextLine();
		System.out.println();
		/*----------------------*/
		
		String sArr[]=s.split(" ");
		int array[]=new int[sArr.length];
		int q=0;
		for(String t: sArr){
			array[q++]=Integer.parseInt(t);
		}
		
		int minSum=array[0];
		int minTemp=array[0];
		
		// O(n) time complexity Algo for calculating min. contigious subarray sum  
		
		for(int i=1;i<array.length;i++){
			if(minTemp>0)
				minTemp=array[i];
			else
				minTemp=minTemp+array[i];
			
			minSum=minSum>minTemp?minTemp:minSum;
		}
		
		System.out.println("Minimum Sum of Contiguous Subarray is: "+minSum);
		
	}
}
