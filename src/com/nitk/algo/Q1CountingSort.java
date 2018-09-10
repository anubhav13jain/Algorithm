package com.nitk.algo;

import java.util.Scanner;

public class Q1CountingSort {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.print("Please enter range of number 0-K:");
		int k= sc.nextInt();
		System.out.print("Please enter number of element to sort:");
		int n=sc.nextInt();
		int inArr[]= new int[n];
		
		/*---User input---*/
		System.out.println("Enter array number:");
		for(int i=0;i<n;i++){
			 inArr[i]=sc.nextInt();
		}
		/*---------------*/
		
		/*---Counting occurrence of each number----*/
		int cArr[]= new int[k];
		int outArr[]= new int[k];
		for(int i=0;i<n;i++){
			cArr[inArr[i]]++;
		}
		/*---------------*/
		
		
		for(int i=2;i<k;i++){
			cArr[i]=cArr[i]+cArr[i-1];
		}
		
		for( int i=n-1;i>=0;i--){
			
			outArr[cArr[inArr[i]]]=inArr[i];
			cArr[inArr[i]]=cArr[inArr[i]]-1;
		}
		/*------Printing Outpput-------*/
		System.out.println("sorted Array: ");
		for(int i=0;i<k;i++){
			if(outArr[i]!=0)
				System.out.print(outArr[i]+" ");
		}
		/*---------------------*/
	}

}
