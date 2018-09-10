package com.nitk.algo;

public class MergeSort {

	public static void splitArr(int [] arr,int [] barr,int a,int b){
		if(a>=b){
			return;
			
		}
		int c= (a+b)/2;
		splitArr(arr,barr, a, c);
		splitArr(arr,barr, c+1, b);
		merge(arr,barr,a,c,b);
		
	}
	//static int[]barr;
	public static void merge(int [] arr,int [] barr,int a,int c,int b){
		int i=a;
		int l=a;
		int j=c+1;
		while(i<=c&&j<=b){
			if(arr[i]<=arr[j]){
				barr[l++]=arr[i];
				i++;
			}
			else{
				barr[l++]=arr[j];
				j++;
			}
		}
		for(int k=i;k<=c;k++)
			barr[l++]=arr[k];
		for(int k=j;k<=b;k++)
			barr[l++]=arr[k];
		
		for(int k=a;k<=b;k++)
			arr[k]=barr[k];
		
	/*	System.out.println();
		for(int k=0;k<4;k++)
			System.out.print(barr[k]+" ");*/
		
	}
	
	
	public static void splitArr(int [][] arr,int [][] barr,int a,int b){
		if(a>=b){
			return;
			
		}
		int c= (a+b)/2;
		splitArr(arr,barr, a, c);
		splitArr(arr,barr, c+1, b);
		merge(arr,barr,a,c,b);
		
	}
	//static int[]barr;
	public static void merge(int [][] arr,int [][] barr,int a,int c,int b){
		//System.out.println(a+" "+b+" "+c);
		int i=a;
		int l=a;
		int j=c+1;
		while(i<=c&&j<=b){
			if(arr[0][i]<=arr[0][j]){
				barr[0][l]=arr[0][i];
				barr[1][l++]=arr[1][i];
				i++;
			}
			else{
				barr[0][l]=arr[0][j];
				barr[1][l++]=arr[1][j];
				j++;
			}
		}
		for(int k=i;k<=c;k++) {
			barr[0][l]=arr[0][k];
			barr[1][l++]=arr[1][k];
		}
		for(int k=j;k<=b;k++){
			barr[0][l]=arr[0][k];
			barr[1][l++]=arr[1][k];
		}
		
		for(int k=a;k<=b;k++) {
			arr[0][k]=barr[0][k];
			arr[1][k]=barr[1][k];
		}
	/*	System.out.println();
		for(int k=0;k<4;k++)
			System.out.print(barr[k]+" ");*/
		
	}
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		barr=new int[10];
		int []arr={10,4,99,87,34,21,44,67,43,29};
		splitArr(arr,barr,0,9);
		System.out.println();
		System.out.println("----------");
		for(int i=0;i<10;i++)
		System.out.print(barr[i]+" ");
	}
*/
}
