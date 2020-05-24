package com.Baekjoon;

import java.io.*;
import java.util.*;

public class Main_17471_게리맨더링 {

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
		private int test1() {
			return 0;
		}
	}
	
	static int n, people[], a, b, team[], Ans = 0x7fffffff;
	static LinkedList<Integer> l[];
	
	static void dfs(int idx, int cnt) {
		if(cnt < n) {
			boolean visited[] = new boolean[n];
			boolean visited2[] = new boolean[n];
			Queue<Integer> q = new LinkedList<Integer>();
			Queue<Integer> q2 = new LinkedList<Integer>();
			boolean is_team1_sw = false;
			for(int i=0; i<n; i++) {
				if(team[i] == 1) {
					is_team1_sw = true;
					q.add(i); visited[i] = true; break;
				}
			}
			for(int i=0; i<n; i++) {
				if(team[i] == 0) {
					q2.add(i); visited2[i] = true; break;
				}
			}
			
			if(is_team1_sw) {
				while(!q.isEmpty()) {
					int cur = q.poll();
					for(int k : l[cur]) {
						if(visited[k] || team[k] == 0) continue;
						visited[k] = true; q.add(k);
					}
				}
				while(!q2.isEmpty()) {
					int cur = q2.poll();
					for(int k : l[cur]) {
						if(visited2[k] || team[k] == 1) continue;
						visited2[k] = true; q2.add(k);
					}
				}
				
				boolean is_true = true;
				for(int i=0; i<n; i++) {
					if(team[i] == 1 && !visited[i]) {is_true = false; break;}
					if(team[i] == 0 && !visited2[i]) {is_true = false; break;}
				}
				
				if(is_true) {
					int team1 = 0, team2 = 0;
					for(int i=0; i < n; i++) {
						if(team[i] == 0) team2 += people[i];
						else team1 += people[i];
					}
					Ans = Math.min(Ans, Math.abs(team2 - team1));
				}
			}
			if(cnt == n-1) return;
		}
		
		for(int i=idx; i<n; i++) {
			team[i] = 1;
			dfs(i + 1, cnt + 1);
			team[i] = 0;
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		MyScanner sc = new MyScanner();
		n = sc.nextInt();
		l = new LinkedList[n]; people = new int[n]; team = new int[n];
		for(int i=0; i<n; i++) people[i] = sc.nextInt();
		for(int i=0; i<n; i++) {
			l[i] = new LinkedList<Integer>();
			int num = sc.nextInt();
			for(int j=0; j<num; j++) {
				a = sc.nextInt(); a--;
				l[i].add(a);
			}
		}dfs(0, 0);
		if(Ans == 0x7fffffff) Ans = -1;
		System.out.println(Ans);
	}

}
