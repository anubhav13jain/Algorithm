package com.nitk.algo;

/* Prim's MST Algorithm implementation in java.
 * Input graph is in Adjacency List representation.
 * Time complexity is O((E+V)log v) => O(E log V)
 *  */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*This class store name of node as Id and weight*/
class Node{
	private Integer id;
	private Integer weight;
	public Node(Integer e, Integer w) {
		id=e;
		weight=w;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
}

/*-----------Main class-----------*/
public class PrimsAlgoImpl {
	
	private List<Node> graphArr[];
	//constructor to initialize adjacency list of graph 
	public PrimsAlgoImpl(Integer n) {
		graphArr= new List[n];
		for(int i=0;i<n;i++){
			graphArr[i]= new ArrayList<Node>();
		}
	}
	//Function to add edges to the undirected graph
	public void add(Integer s, Integer e, Integer w){
		graphArr[s].add(new Node(e,w));
		graphArr[e].add(new Node(s,w));
	}
	
	
	public  Map<Integer,Integer> prims(PrimsAlgoImpl pg, ArrayList<Node> heap,int n, Map<Integer, Integer> nodeIndexMap){
		Map<Integer,Integer> retMap= new LinkedHashMap<>();
		
		updateWeight(heap, 0,0, nodeIndexMap);
		
		
		boolean fixed[]= new boolean[n];
		Node delNode=null;
		while(!heap.isEmpty())
		{	
			delNode=delete(heap, nodeIndexMap);
			fixed[delNode.getId()]= true;
			for(Node nk:pg.graphArr[delNode.getId()]){
				
				if(fixed[nk.getId()]){
				}else{
					int index=nodeIndexMap.get(nk.getId());
					if(delNode.getWeight()+nk.getWeight()<heap.get(index).getWeight()){
						updateWeight(heap, index, delNode.getWeight()+nk.getWeight(), nodeIndexMap);
					}
				}
			}
			retMap.put(delNode.getId(), delNode.getWeight());
		}
		return retMap;
		
	}
	
	// This function will update(decrease the weight of specified function and accordingly heapify the graph.)
	public static void  updateWeight(ArrayList<Node> heap,int key,int w, Map<Integer, Integer> nodeIndexMap){
		int position=key;
		heap.get(position).setWeight(w);
		while (position>0){
			int parent= (position-1)/2;
			if(heap.get(parent).getWeight()>heap.get(position).getWeight())	{
				swap(heap.get(parent),heap.get(position));
				nodeIndexMap.put(heap.get(position).getId(),position );
				nodeIndexMap.put(heap.get(parent).getId(),parent );
				position=parent;
			}else{
				break;
			}
		}		
	}
	
	//removing an element from min heap.
	public static Node delete(ArrayList<Node> heap,Map<Integer, Integer> nodeIndexMap){
		//Removing node at index 0 in min heap and moving last node at 0th position.
		Node retNode= new Node(heap.get(0).getId(), heap.get(0).getWeight());
		nodeIndexMap.remove(heap.get(0).getId());
		int n= heap.size();
		Node node=heap.get(0);
		node.setWeight(heap.get(n-1).getWeight());
		node.setId(heap.get(n-1).getId());
		nodeIndexMap.put(node.getId(), 0);
			
		heap.remove(n-1);
		n--;
		
		//Performing Heapify operation at 0th node
		heapify(heap,0,nodeIndexMap);
		
		return retNode;
	}
	
	// to heapify the heap
	public static void heapify(ArrayList<Node> heap,int p, Map<Integer, Integer> nodeIndexMap){
		
		if((2*p+1)<heap.size() && heap.get(p).getWeight()>heap.get(2*p+1).getWeight()){
			swap(heap.get(p),heap.get(2*p+1));
			nodeIndexMap.put(heap.get(p).getId(),p);
			nodeIndexMap.put(heap.get(2*p+1).getId(),2*p+1);
			heapify(heap, 2*p+1, nodeIndexMap);
		}
		else if((2*p+2)<heap.size() && heap.get(p).getWeight()>heap.get(2*p+2).getWeight()){
			swap(heap.get(p),heap.get(2*p+2));
			nodeIndexMap.put(heap.get(p).getId(),p);
			nodeIndexMap.put(heap.get(2*p+2).getId(),2*p+2);
			heapify(heap, 2*p+2,  nodeIndexMap);
		}
		
	}
	
	//Function to swap data in heap
	public static void swap(Node a, Node b){
		Node temp= new Node(a.getId(), a.getWeight());
		temp.setId(a.getId());
		temp.setWeight(a.getWeight());
		a.setId(b.getId());
		a.setWeight(b.getWeight());
		b.setId(temp.getId());
		b.setWeight(temp.getWeight());
		
	}
	public static void main(String[]arg){
		int n=5;
		
		//Initialization Undirected graph.
		//Add(Source, Destination, weight to reach destination from source)
		PrimsAlgoImpl pg= new PrimsAlgoImpl(n);
		pg.add(0, 1, 3);
		pg.add(1, 2, 14);
		pg.add(2, 3, 9);
		pg.add(4, 3, 1);		
		pg.add(1, 4, 10);
		pg.add(4, 2, 3);
		
		// Heap initialization
		// Node->Id holds Name of Node
		// Node->Weight : min weight to reach that node
		ArrayList<Node>heap= new ArrayList<>();
		
		//nodeIndexMap used to keep track of each node and its position in heap(NodeId, position_in_heap)
		//While updating neighbor node weight, This helps us to find the position of node in heap in O(1) 
		Map<Integer,Integer>nodeIndexMap= new HashMap<>();
		
		//Initializing Heap and node-position mapping 
		for(int i=0; i< n;i++){
			heap.add(new Node(i, Integer.MAX_VALUE));
			nodeIndexMap.put(i, i);
		}

		//Calling Prims function
		Map<Integer,Integer> ans=pg.prims(pg, heap, n, nodeIndexMap);
		
		
		//Printing Mst weight of each node
		for(Integer k:ans.keySet()){
			System.out.println(k+"--"+ans.get(k));
		}
	}
	
}
