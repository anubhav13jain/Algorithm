package com.nitk.algo;

import java.util.Scanner;

public class Q10CountingSort {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		/*---User input---*/
		System.out.print("Please enter range of number 0-K:");
		int k= sc.nextInt();
		System.out.print("Please enter number of element in Array:");
		int n=sc.nextInt();
		int inArr[]= new int[n];
		/*----------------------*/
		
		System.out.println("Enter array number:");
		for(int i=0;i<n;i++){
			 inArr[i]=sc.nextInt();
		}
		
		int cArr[]= new int[k];
		//int outArr[]= new int[k];
		for(int i=0;i<n;i++){
			cArr[inArr[i]]++;
		}

		int m= n/2;
		for(int i=0;i<k;i++){
			if(cArr[i]>m){
				System.out.println("Maximum Number:"+i);
				break;
			}
		}
		
	}

}
