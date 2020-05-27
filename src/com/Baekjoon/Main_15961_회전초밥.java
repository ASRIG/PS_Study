package com.Baekjoon;

import java.io.*;
import java.util.*;

public class Main_15961_회전초밥 {

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
	
	static int N, d, k, c, arr[] = new int[3000001];
	static Deque<Integer> dq[] = new LinkedList[3001];
	
	public static void main(String[] args) throws IOException{
		MyScanner sc = new MyScanner();
		N = sc.nextInt(); d = sc.nextInt(); k = sc.nextInt(); c = sc.nextInt();
		for(int i = 0; i <= d; i++) dq[i] = new LinkedList<>();
		for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
		
		int startp = 0, kindof = 0, ans = 0;
		for(int i = 0; i < k; i++) {
			if(dq[arr[i]].isEmpty()) kindof += 1;
			dq[arr[i]].addLast(i);
		} 
		ans = kindof + (dq[c].isEmpty() ? 1 : 0);
		for(int i = k; i < N + k; i++) {
			int newi = i % N;
			dq[arr[startp]].pollFirst();
			if(dq[arr[startp]].isEmpty()) kindof -= 1;
			if(dq[arr[newi]].isEmpty()) kindof += 1;
			dq[arr[newi]].addLast(newi);
			ans = Math.max(ans, kindof + (dq[c].isEmpty() ? 1 : 0));
			startp++;
		}
		System.out.println(ans);
	}
}
