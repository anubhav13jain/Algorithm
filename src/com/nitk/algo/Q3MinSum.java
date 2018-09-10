package com.nitk.algo;

import java.util.Scanner;

public class Q3MinSum {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		/*---User input---*/
		System.out.println("Enter array number space seperated:");
		String s= sc.nextLine();
		/*----------------------*/
		
		String sArr[]=s.split(" ");
		int array[]=new int[sArr.length];
		int q=0;
		for(String t: sArr){
			array[q++]=Integer.parseInt(t);
		}
		
		int minSum=array[0];
		
		// O(n*n) time complexity Algo for calculating min. contigious subarray sum  
	
		for(int i=0;i<array.length;i++){
			if(minSum>array[i])
				minSum=array[i];
			int sum=array[i];
			for(int j=i+1;j<array.length;j++){
				sum+=array[j];
				if(sum<minSum)
					minSum=sum;
			}
		}
		
		System.out.println("Minimum Sum of Contiguous Subarray is: "+minSum);
		
	}
}
