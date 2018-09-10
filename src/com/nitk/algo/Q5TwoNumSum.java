package com.nitk.algo;

import java.util.Scanner;

public class Q5TwoNumSum {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		/*---User input---*/
		System.out.println("Enter array number space seperated:");
		String s= sc.nextLine();
		System.out.print("Enter number to be matched:");
		int x= sc.nextInt();
		System.out.println();
		/*----------------------*/

		String sArr[]=s.split(" ");
		int array[]=new int[sArr.length];
		int q=0;
		for(String t: sArr){
			array[q++]=Integer.parseInt(t);
		}
		
		// First we will sort the array using Either Merge sort or Quick Sort
		// Here I am using merge sort, The T.C.= O(n*log(n)) 
		
		int barr[]=new int[sArr.length];
		MergeSort.splitArr(array,barr,0,sArr.length-1);
		
		
		boolean flag=true;
		
		// O(n) time complexity Algo for calculating sum of two number equals to give number X
		for(int i=0, j=barr.length-1;i<j;){
			 if(barr[i]+barr[j]==x){
				 System.out.println("Number Exist:"+barr[i]+" + "+barr[j]+" = "+x);
				 flag=false;
				 i++;
				 j--;				 
			 }
			 else if(barr[i]+barr[j]<x){
				 i++;
			 }
			 else {
				 j--;
			 }
		}
		
		if(flag){
			 System.out.println("No such Numbers Exist!!!!!");
		}
	}
}
