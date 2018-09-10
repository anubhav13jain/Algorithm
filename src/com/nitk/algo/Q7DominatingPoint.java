package com.nitk.algo;
import java.util.Scanner;

public class Q7DominatingPoint {

	// Calculating non-dominating points using D&C
	// First we sort X- axis element using merge sort in TC= O(n*log(n))
	// Then using D&C we will check y-axis element in TC= O(n)
	public static int dominating(int inArr[], int refArr[],int s,int l) {
		if(s==l) {
			return inArr[s];
		}
		int temp=dominating(inArr,refArr,s+1,l);
		if(inArr[s]<=temp) {
			refArr[s]=0;
			return temp;
		}
		else {
			refArr[s]=1;
			return inArr[s];
		}
	}
	
	
	public static void main(String[]a) {

		Scanner sc= new Scanner(System.in);
		/*---User input---*/
		System.out.println("Enter number of points:");
		int n=sc.nextInt();
		int [][]aArr=new int[2][n];
		int [][]bArr=new int[2][n];
		int []rArr=new int[n];
		System.out.println("Enter comma seperated input points");
		for(int i=0;i<n;i++) {
			String ar=sc.next();
			aArr[0][i]=Integer.parseInt(ar.split(",")[0]);
			aArr[1][i]=Integer.parseInt(ar.split(",")[1]);
		}
		/*---------------------*/
		for(int i=0;i<2;i++) {
			System.out.println();
			for(int j=0;j<n;j++)
				System.out.println(aArr[i][j]+" ");
		}
		
		// Sorting the X-axis elements of array TC=O(n*log(n))
		MergeSort.splitArr(aArr, bArr, 0, n-1);

		
		//calling function to calculate dominating points
		dominating(bArr[1],rArr,0,n-1);
		
		for(int i=0;i<n;i++) {
			System.out.print(" "+rArr[i]);
		}		
	}
}
