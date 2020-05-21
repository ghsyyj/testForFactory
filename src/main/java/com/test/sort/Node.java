package com.test.sort;

public class Node {

	private Node left;
	private Node right;
	private int value;
	
	public Node(int value) {
		this.value = value;
	}
	
	public void add(int value) {
		
		if(value > this.value) {
			if(right != null) {
				right.add(value);
			} else {
				Node node = new Node(value);
				right = node;
			}
		} else {
			if(left != null) {
				left.add(value);
			} else {
				Node node = new Node(value);
				left = node;
			}
		}
	}
	
	public boolean find(int value) {
		
		if(value == this.value) {
			return true;
		} else if(value > this.value) {
			if(right == null) {
				return false;
			} else {
				return right.find(value);
			}
		} else {
			if(left == null) {
				return false;
			} else {
				return left.find(value);
			}
		}
	}
	
	public void display() {
		System.out.println(value);
		if(left != null) {
			left.display();
		}
		if(right != null) {
			right.display();
		}
	}
	
	public static boolean contains(int[] arr, int value) {
		
		for(int i = 0; i<arr.length ; i++) {
			if(arr[i] == value) {
				return true;
			} 
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] values = new int[8];
		for(int i = 0; i<8; i++) {
			int num = (int) (Math.random() * 15);
			if(!contains(values, num)) {
				values[i] = num;
			} else {
				i--;
			}
		}
	}
	
}
