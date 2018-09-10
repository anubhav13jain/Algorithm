package com.nitk.algo;

import java.util.Scanner;

public class Q9LongIncSeq2 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		/*------User input-------*/
		System.out.println("Enter array number space seperated:");
		String s= sc.nextLine();
		/*-----------------------*/
		System.out.println();

		String sArr[]=s.split(" ");
		int array[]=new int[sArr.length];
		int q=0;
		for(String t: sArr){
			array[q++]=Integer.parseInt(t);
		}

		int n=sArr.length;
		int list[] = new int[sArr.length]; 
		int max = 0; 


		for ( int i = 0; i < n; i++ ) 
			list[i] = 1; 


		for (int  i = 1; i < n; i++ ) 
			for ( int j = 0; j < i; j++ )  
				if ( array[i] > array[j] && list[i] < list[j] + 1) 
					list[i] = list[j] + 1; 

		for (int i = 0; i < n; i++ ) 
			if ( max < list[i] ) 
				max = list[i]; 

		//System.out.println("Longest Incresing seq is:"+mainList);
		System.out.println("Sequense size:"+max);

	}

}
