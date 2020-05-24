package com.Baekjoon;

import java.io.*;
import java.util.*;

public class Main_9019_DSLR {

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
	
	static int make_d(int num1) {
		return (num1 * 2) % 10000;
	}
	
	static int make_s(int num1) {
		if(num1 == 0) num1 = 10000;
		return num1 - 1;
	}
	
	static int make_l(int num1) {
		return (num1 % 1000) * 10 + num1 / 1000;
	}
	
	static int make_r(int num1) {
		return (num1 % 10) * 1000 + (num1 / 10);
	}
	
	static class PAIR{
		int num;
		String cmd;
		PAIR(){}
		PAIR(int num, String cmd){
			this.num = num; this.cmd = cmd;
		}
	}
	
	static int tes, a, b;
	static boolean visited[];
	static Queue<PAIR> q = new LinkedList<PAIR>();
	
	public static void main(String[] args) throws IOException{
		MyScanner sc = new MyScanner();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		
		tes = sc.nextInt();
		for(int test_case = 1; test_case <= tes; test_case++) {
			a = sc.nextInt(); b = sc.nextInt();
			visited = new boolean[10000];
			visited[a] = true;
			q.add(new PAIR(a, ""));
			
			while(!q.isEmpty()) {
				PAIR cur = q.poll();
				if(cur.num == b) {
					System.out.println(cur.cmd); break;
				}
				
				int d = make_d(cur.num), s = make_s(cur.num);
				int r = make_r(cur.num), l = make_l(cur.num);
				
				if(!visited[d]) {
					visited[d] = true;
					q.add(new PAIR(d, cur.cmd + "D"));
				}
				if(!visited[s]) {
					visited[s] = true;
					q.add(new PAIR(s, cur.cmd + "S"));
				}
				if(!visited[r]) {
					visited[r] = true;
					q.add(new PAIR(r, cur.cmd + "R"));
				}
				if(!visited[l]) {
					visited[l] = true;
					q.add(new PAIR(l, cur.cmd + "L"));
				}
			}
			
			q.clear();
			
		}
		
		
		
	}

}
