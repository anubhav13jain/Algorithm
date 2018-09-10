package com.nitk.algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Q4GraphCol {

	private LinkedList inList[];

	
	// Creating Graph in Adjacency List format using Linked List 
	Q4GraphCol(int n){
		inList=new LinkedList[n];
		for(int i=0;i<n;i++){
			inList[i]= new LinkedList<>();
		}
	}
	
	// this function add an edge to the graph between given vertices
	public void addEdge(int i, int j){
		inList[i].add(j);
		inList[j].add(i);
	}
	
	
	// Used to color the graph where no two adjacent nodes have same color 
	void colorGraph(int n){
		int colorArr[]=new int[n];
		//boolean colorflag[]=new boolean[n];
		Arrays.fill(colorArr, -1);

		colorArr[0]=0;
		// colorflag[0]=true;

		for(int i=0;i<n;i++){
			LinkedList<Integer> nodeList= inList[i];
			Set<Integer>notAvailableColor=new HashSet<>();
			for(Integer temp:nodeList){
				if(colorArr[temp]!=-1){
					notAvailableColor.add(colorArr[temp]);
				}
			}
			int l=0;
			for(int k=0;k<n;k++){

				if( !notAvailableColor.contains(k)){
					colorArr[i]=k;
					break;
				}
			}

		}
		for(int i=0;i<n;i++){
			System.out.println("color of "+i+"th node is:"+colorArr[i]);
		}

	}


	public static void main(String[] args) {
		Q4GraphCol g1 = new Q4GraphCol(8);
		
		
		
		g1.addEdge(0,4);
		g1.addEdge(0,5);
		g1.addEdge(0, 6);
		g1.addEdge(0, 7);
	
		g1.addEdge(1, 4);
		g1.addEdge(1, 5);
		g1.addEdge(1, 6);
		g1.addEdge(1, 7);
		
		g1.addEdge(2, 4);
		g1.addEdge(2, 5);
		g1.addEdge(2, 6);
		g1.addEdge(2, 7);
		
		g1.addEdge(3, 4);
		g1.addEdge(3, 5);
		g1.addEdge(3, 6);
		g1.addEdge(3, 7);
		
		/*g1.addEdge(0, 1);
		g1.addEdge(0, 2);
		g1.addEdge(1, 2);
		g1.addEdge(1, 3);
		g1.addEdge(2, 3);
		g1.addEdge(3, 4);*/
		System.out.println("Coloring of graph 1");
		g1.colorGraph(8);
	}

}
