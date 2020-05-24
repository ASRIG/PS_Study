package com.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2927_남극탐험 {
	
	static class My_Scanner{
		BufferedReader br;
		StringTokenizer st;
		
		public My_Scanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
	
	
	static int n, arr[], q, ST_MAX = 1, size, p[];
	static int par[];
	
	static int find(int num) {
		if(p[num] < 0) return num;
		return p[num] = find(p[num]);
	}
	
	static int merge(int aa, int bb) {
		aa = find(aa); bb = find(bb);
		if(aa == bb) return 1;
		return 0;
	}
	
	static void update(int i, int val, int ar[]) {
		i += size;
		ar[i] = val;
		while(i > 1) {
			i /= 2;
			ar[i] = Math.max(ar[i * 2], ar[i * 2 + 1]);
		}
	}
	
	static void construct(int ar[]){
		for(int i = size - 1; i > 0; i--) {
			ar[i] = Math.max(ar[i * 2], ar[i * 2 + 1]);
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		My_Scanner sc = new My_Scanner();
		n = sc.nextInt(); arr = new int[n]; p = new int[n + 1];
		for(int i=0; i<= n; i++) p[i] = -1;
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		} q = sc.nextInt();
		
		while(n > ST_MAX) {
			ST_MAX *= 2;
		}ST_MAX *= 2; size = ST_MAX / 2;
		par = new int[ST_MAX + 1];
		
		for(int i=0; i< n; i++) {
			par[size + i] = arr[i];
			
		}
		
		for(int quest = 1; quest <= q; quest++) {
			String cmd = sc.next();
			if(cmd.equals("excursion")) {
				
			}else if(cmd.equals("penguins")) {
				
			}else if(cmd.equals("bridge")) {
				
			}
		}
	}
}
