package com.nitk.algo;

import java.util.Scanner;

public class Q8SubSetSum2 {

	public static boolean subSetSum(int []array, int n, int sum) {
		
		boolean set[][]= new boolean[n+1][sum+1];
		for(int i=0;i<=n;i++)
			set[i][0]=true;
		for(int i=1;i<=sum;i++) 
			set[0][i]=false;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=sum;j++) {
				set[i][j]= set[i-1][j];
				if(j>=array[i-1]&&!set[i][j]) {
					set[i][j]=set[i-1][j-array[i-1]];
				}
			}
		}
		
		return set[n][sum];
	}
	//3 34 4 12 5 2
	
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		/*------User input-------*/
		System.out.println("Enter array number space seperated:");
		String s= sc.nextLine();
		System.out.print("Enter number whoose sum to be matched:");
		int x= sc.nextInt();
		System.out.println();
		/*-----------------------*/
		String sArr[]=s.split(" ");
		int array[]=new int[sArr.length];
		int q=0;
		for(String t: sArr){
			array[q++]=Integer.parseInt(t);
		}
		
		boolean flag= subSetSum(array, q, x);
		
		if(flag){
			 System.out.println("There Exist Subset whoose sum is equal to "+x);
		}
		else{
			System.out.println("Subset whoose sum is equal to "+x+" does not Exist !!!!");
		}
	}

}
