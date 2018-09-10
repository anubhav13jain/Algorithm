package com.nitk.algo;
import java.util.Scanner;

public class Q7DominatingPoint2 {

	// Calculating non-dominating points using D&C
	// First we sort X- axis element using merge sort in TC= O(n*log(n))
	// Then using D&C we will check y-axis element in TC= O(n*log(n))


	public static void dominating(int [] arr,int a,int c,int b){
		
		int l=c;
		int j=c+1;
		while(j<=b){
			if(arr[j]==Integer.MIN_VALUE){
				j++;
			}
			else
				break;
		}
		while(l>=a){
			if(arr[l]<=arr[j]){
				arr[l]=Integer.MIN_VALUE;
				l--;
			}
			else
				break;
		}

	}

	public static void split(int arr[],int i,int j) {
		if(i>=j)
			return;

		int mid= (i+j)/2;
		split(arr,i,mid);
		split(arr,mid+1,j);
		dominating(arr, i, mid, j);

	}


	public static void main(String[]a) {

		Scanner sc= new Scanner(System.in);
		/*---User input---*/
		System.out.println("Enter number of points:");
		int n=sc.nextInt();
		int [][]aArr=new int[2][n];
		int [][]bArr=new int[2][n];
		
		System.out.println("Enter comma seperated input points");
		for(int i=0;i<n;i++) {
			String ar=sc.next();
			aArr[0][i]=Integer.parseInt(ar.split(",")[0]);
			aArr[1][i]=Integer.parseInt(ar.split(",")[1]);
		}
		/*---------------------*/
		/*for(int i=0;i<2;i++) {
			System.out.println();
			for(int j=0;j<n;j++)
				System.out.println(aArr[i][j]+" ");
		}*/

		// Sorting the X-axis elements of array TC=O(n*log(n))
		MergeSort.splitArr(aArr, bArr, 0, n-1);
		int sol[]= new int[n];

		for(int i=0;i<n;i++) {
			sol[i]=bArr[1][i];
		}	
			
		//calling function to calculate dominating points
		split(sol,0,n-1);
		
		
		System.out.println("----Non Dominated points------");
		for(int i=0;i<n;i++) {
			if(sol[i]!=Integer.MIN_VALUE) {
				System.out.println(bArr[0][i]+","+bArr[1][i]);
			}
		}		
	}
}
