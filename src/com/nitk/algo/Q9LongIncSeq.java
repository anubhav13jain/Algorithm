package com.nitk.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q9LongIncSeq {

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

		List<Integer>mainList= new ArrayList<>();
		List<Integer>tempList= new ArrayList<>();
		for(int i=0;i<array.length;i++){

			tempList.add(array[i]);
			for(int j=i+1;j<array.length;j++){
				if(array[j]>tempList.get(tempList.size()-1)){
					tempList.add(array[j]);
				}
			}
			if(mainList.size()<tempList.size()) {
				mainList.clear();
				mainList.addAll(tempList);
			}
			tempList.clear();

		}


		System.out.println("Longest Incresing seq is:"+mainList);
		System.out.println("Sequense size:"+mainList.size());

	}

}
