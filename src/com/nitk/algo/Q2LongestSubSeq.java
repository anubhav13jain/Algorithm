package com.nitk.algo;


import java.util.Scanner;

public class Q2LongestSubSeq {
	/**
	 * Function used to calculate longest subsequence
	 * It is recursive method to calculate the same.	 
	 */
	static int subSeqfun(char[] c1,char[] c2,int n, int m){
		if(m==-1||n==-1){
			return 0;
		}
		if(c1[n]==c2[m])
			return 1+subSeqfun(c1,c2,n-1,m-1);
		else
			return maxFun(subSeqfun(c1,c2,n-1,m),subSeqfun(c1,c2,n,m-1));
		
	}
	
	//Function to find maximum of 2 number
	static int maxFun(int a, int b){
		return a>b?a:b;
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.print("Enter Ist array :");
		String s1= sc.nextLine();
	
		System.out.print("Enter IInd array :");
		String s2= sc.nextLine();
		
		System.out.println();
		
		char[] c1=s1.toCharArray();
		char[] c2=s2.toCharArray();
		
		System.out.println("Longest subsequence is:"+subSeqfun(c1,c2,c1.length-1,c2.length-1));
			
	}
}
