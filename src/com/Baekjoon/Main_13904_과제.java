package com.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

class PQArr{
	public PriorityQueue<Integer> pq;
	
	public PQArr(){
		pq = new PriorityQueue<Integer>(Collections.reverseOrder());
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

class HomeWork implements Comparable<HomeWork>{
	public int d, w;
	public HomeWork(int d, int w) {
		this.d = d; this.w = w;
	}
	@Override
	public int compareTo(HomeWork o) {
		if(this.d == o.d) return -Integer.compare(this.w, o.w);
		return Integer.compare(this.d, o.d);
	}
}

public class Main_13904_과제 {
	static int n;
	static String str_tok[] = {};
	static PQArr pq[] = new PQArr[1001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int max_day = 0;
		for(int i=0; i<1001; i++) {
			pq[i] = new PQArr();
		}
		
		for(int i=0; i<n; i++) {
			str_tok = br.readLine().split(" ");
			int d = Integer.parseInt(str_tok[0]), w = Integer.parseInt(str_tok[1]);
			pq[d].push(w);
			max_day = Math.max(d, max_day);
		}
		int answer = 0;
		for(int i=max_day; i>= 1; i--) {
			int max_idx = 0, max_val = -1;
			if(!pq[i].empty()) {
				max_val = pq[i].top(); max_idx = i;
			}
			for(int j = i + 1; j <= max_day; j++) {
				if(!pq[j].empty() && max_val < pq[j].top()) {
					max_val = pq[j].top(); max_idx = j;
				}
			}
			if(max_val != -1) {
				answer += pq[max_idx].pop();
			}
		}
		System.out.println(answer);
	}

}
