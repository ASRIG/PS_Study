package com.Baekjoon;

import java.io.*;
import java.util.*;

public class Main_2457_공주님의정원 {

	static class MyScanner{
		BufferedReader br;
		StringTokenizer st;
		
		public MyScanner() {
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
	
	static class Flower implements Comparable<Flower>{
		int a, b;
		public Flower(int a, int b) {
			this.a = a; this.b = b;
		}
		@Override
		public int compareTo(Flower o) {
			if(this.a == o.a) return Integer.compare(this.b, o.b);
			return Integer.compare(this.a, o.a);
		}
	}
	
	final static int month[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	static int n, sum_month[] = new int[13], Ans, end_day;
	static Flower flower[];
	static boolean is_true = false;
	
	public static void main(String[] args) throws IOException{
		MyScanner sc = new MyScanner();
		n = sc.nextInt();
		
		flower = new Flower[n];
		for(int i=1; i<= 12; i++) {
			sum_month[i] += sum_month[i - 1] + month[i - 1];
		}
		Ans = n;
		for(int i=0; i<n; i++) {
			int a = sc.nextInt(); int b = sc.nextInt(); int c = sc.nextInt(); int d = sc.nextInt();
			flower[i] = new Flower(sum_month[a] + b, sum_month[c] + d);
		}Arrays.sort(flower);
		
		// ���� ����, �� ����
		int start = sum_month[3] + 1, end = sum_month[11] + 30;

		int cur_idx = 0, prev_idx = 0;
		boolean is_update = true;
		Ans = 0;
		while(is_update) {
			is_update = false;
			cur_idx = prev_idx;
			if(cur_idx == n) break; 
			while(cur_idx < n && flower[cur_idx].a <= start) {
				cur_idx++;
			}
			is_update = true; Ans++;
			int max_val = -1, max_idx = prev_idx;
			for(int i=prev_idx; i< cur_idx; i++) {
				if(max_val < flower[i].b) {
					max_val = flower[i].b; max_idx = i;
				}
			}
			if(max_val == -1) break;
			start = flower[max_idx].b;
			if(start > end) {
				is_true = true; break;
			}
			prev_idx = cur_idx;
		}
		
		if(is_true) System.out.println(Ans); 
		else System.out.println("0");
	}
}
