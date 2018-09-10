package com.nitk.algo;

import java.util.Scanner;

public class Q22LongestSubSeq {


	/**
	 * This function is used to calculate longest common subsequence
	 * using Dynamic Programming methodology
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);

		/*---User input---*/
		System.out.println("Enter Ist array :");
		String s1= sc.nextLine();
		System.out.println("Enter 2nd array :");
		String s2= sc.nextLine();
		System.out.println();

		/*---------------*/


		char[] c1=s1.toCharArray();
		char[] c2=s2.toCharArray();

		int m=c2.length;
		int n=c1.length;

		// Creating a Matix of size M+1 X N+1 
		int mat[][]= new int[m+1][n+1];
		//Arrays.fill(mat, 0);

		//Using Dynamic programming Calculating longest common subsequence
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(c1[j]==c2[i]){
					mat[i+1][j+1]=mat[i][j]+1;
				}
				else{
					mat[i+1][j+1]=mat[i+1][j]>mat[i][j+1]?mat[i+1][j]:mat[i][j+1];
				}
			}

		}

		for(int k=0;k<m+1;k++){
			for(int j=0;j<n+1;j++){
				System.out.print(" "+mat[k][j]);
			}
			System.out.println();
		}

		System.out.println("Longest subsequence is:"+mat[m][n]);
		//backTrack(mat,c1, c2,m,n);
	}

	/*	public static void backTrack(int [][]mat,char[] c1, char []c2,int i,int j){
		if(i==0|| j==0){
			System.out.println();
			return;
			}
		if(c1[j-1]==c2[i-1]){

			backTrack(mat, c1, c2, i-1, j-1);
			System.out.print(c2[i-1]);
		}
		else{
			if(mat[i][j-1]>mat[i-1][j]){
				//System.out.println(c2[j-1]);
				backTrack(mat, c1, c2, i, j-1);
			}
			else if(mat[i][j-1]<mat[i-1][j]){
				//System.out.println(c2[j-1]);
				backTrack(mat, c1, c2, i-1, j);
			}
			else{
				backTrack(mat, c1, c2, i, j-1);
				backTrack(mat, c1, c2, i-1, j);
			}

		}
	}*/
}
