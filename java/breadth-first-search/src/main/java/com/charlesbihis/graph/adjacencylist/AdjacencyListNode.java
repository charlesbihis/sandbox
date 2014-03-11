package com.charlesbihis.graph.adjacencylist;

public class AdjacencyListNode {
	protected int id;
	protected String value;
	
	public AdjacencyListNode(int id, String value) {
		this.id = id;
		this.value = value;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return id + ": " + value;
	}
}
