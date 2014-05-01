package com.facebook;

/* Find the shortest path from source to dest using BFS*/
import java.util.*;
import java.io.*;

public class ShortestPath{
	private static ArrayList<Integer>[] adj;
	private static int vertices;
	private static int prev[];
	ShortestPath(int vertices){
		this.vertices = vertices;
		prev = new int[vertices];
		adj = new ArrayList[vertices];
		for(int i = 0; i < adj.length; i++)
			adj[i] = new ArrayList<Integer>();
	}
	public void addEdge(int a, int b){
		adj[a].add(b);
		adj[b].add(a);
	}
	public int getVertices(){
		return vertices;
	}

	public boolean findPath(int source,int dest){
		boolean visited[] = new boolean[getVertices()];
		Queue<Integer> queue = new PriorityQueue<Integer>();
		if(source == dest){
			return false;
		}
		queue.add(source);
		visited[source] = true;
		prev[source] = -1;
		while(!queue.isEmpty()){
			int node = queue.poll();
			for(int i : adj[node]){
				if(i == dest){
					prev[i] = node;
					return true;
				}
				if(!visited[i]){
					visited[i] = true;
					prev[i] = node;
					queue.add(i);
				}
			}
		}
		return false;
	}
	public static void main(String[] args){
		ShortestPath s = new ShortestPath(11);
		StringBuilder path = new StringBuilder();
		s.addEdge(1,2);
		s.addEdge(1,3);
		s.addEdge(1,4);
		s.addEdge(2,5);
		s.addEdge(3,6);
		s.addEdge(3,7);
		s.addEdge(3,8);
		s.addEdge(4,9);
		s.addEdge(4,10);
		if(s.findPath(1,5)){
			int i = 5;
			while(prev[i] != -1){
				path.append(i + "->");
				i = prev[i];
			}
			path.append(i);
			System.out.println("Path is :" + path);
		}
		else
			System.out.println("No path exists from given source to destination");
	}
}