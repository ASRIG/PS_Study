package com.Baekjoon;

import java.io.*;
import java.util.*;

public class Main_1275_커피숍2 {

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
	
	static int N, Q, size_, MAX_SEGMENT = 1,a , b, c, d;
	static long arr[];
	
	public static long sum(int L, int R, int nodeNum, int nodeL, int nodeR) {
		if(R < nodeL || nodeR < L) return 0;
		if(L <= nodeL && R >= nodeR) return arr[nodeNum];
		int mid = (nodeL + nodeR) / 2;
		return sum(L, R, nodeNum * 2, nodeL, mid) + sum(L, R, nodeNum * 2 + 1, mid + 1, nodeR);
	}
	
	public static void update(int curIdx, int var) {
		curIdx += size_;
		arr[curIdx] = var;
		while(curIdx > 1) {
			curIdx /= 2;
			arr[curIdx] = arr[curIdx * 2] + arr[curIdx * 2 + 1];
		}
	}
	
	public static void makeTree() {
		for(int i = size_ - 1; i > 0; i--) arr[i] = arr[2 * i] + arr[2 * i + 1];
	}
	
	public static void main(String[] args) throws IOException{
		MyScanner sc = new MyScanner();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		N = sc.nextInt(); Q = sc.nextInt();
		while(N > (MAX_SEGMENT *= 2));
		MAX_SEGMENT *= 2;
		size_ = MAX_SEGMENT / 2; arr = new long[MAX_SEGMENT];
		for(int i = 0; i < N; i++) arr[size_ + i] = sc.nextInt();
		makeTree();
		for(int i = 0; i < Q; i++) {
			a =sc.nextInt() - 1; b =sc.nextInt() - 1; c = sc.nextInt() - 1; d = sc.nextInt();
			if(a > b) {
				int tmp = a; a = b; b = tmp;
			}
			out.println(sum(a, b, 1, 0, size_ - 1));
			update(c, d);
		}
		out.flush();
	}
}
