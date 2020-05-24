package com.goodAlgorithm;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class PQArr{
	public PriorityQueue<Integer> pq;
	
	public PQArr(){
		pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		pq = new PriorityQueue<Integer>(10, ((Integer a1, Integer a2) -> (a1 > a2) ? -1 : (a1 == a2) ? 0 : 1));
		pq = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		});
		
	}
	
	public void push(int val) {
		pq.add(val);
	}
	
	public int pop() {
		return pq.poll();
	}
	
	public int top() {
		if(!pq.isEmpty()) return pq.peek();
		return -1;
	}
	
	public boolean empty() {
		return pq.isEmpty();
	}
}

public class PRIORITY_QUEUE_ARRAY {

	static PQArr pq[] = new PQArr[1001];
	
	public static void main(String[] args) {
		int a = 10, b = 15, c = 5, d = 10;
		System.out.println(Integer.compare(a, b));	// a�� �� ���� �� ����
		System.out.println(Integer.compare(a, c));	// a�� �� Ŭ �� ���
		System.out.println(Integer.compare(a, d));	// a�� ���� �� 0
		
		for(int i=0; i<1001; i++) {
			pq[i] = new PQArr();
		}
		
		
		
		
	}

}
