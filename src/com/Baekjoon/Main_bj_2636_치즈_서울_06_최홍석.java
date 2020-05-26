package com.Baekjoon;


import java.io.*;
import java.util.*;

public class Main_bj_2636_치즈_서울_06_최홍석 {
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
	
	static int n, m, ans, ans2, mat[][] = new int[102][102];
	static boolean visited[][] = new boolean[102][102];
	static Deque<int[]> dq = new LinkedList<>(), ndq = new LinkedList<>();
	final static int dx[] = {-1, 0, 1, 0};
	final static int dy[] = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException{
		MyScanner sc = new MyScanner();
		n = sc.nextInt(); m = sc.nextInt();
		for(int i = 0; i < n; i++) for(int j = 0; j < m; j++) {
			mat[i][j] = sc.nextInt();
		}dq.addLast(new int[] {0, 0});
		visited[0][0] = true;
		boolean startsw = true;
		while(!dq.isEmpty()) {
			int dqSize = dq.size();
			ans++; 
			if(!startsw) {ans2 = dqSize;}
			startsw = false;
			
			while(!dq.isEmpty()) {
				int[] cur = dq.pollFirst();
				for(int dir = 0; dir < 4; dir++) {
					int new_x = cur[0] + dx[dir], new_y = cur[1] + dy[dir];
					if(new_x < 0 || new_x >= n || new_y < 0 || new_y >= m) continue;
					if(visited[new_x][new_y]) continue;
					visited[new_x][new_y] = true;
					if(mat[new_x][new_y] == 0) dq.addLast(new int[] {new_x, new_y});
					else ndq.addLast(new int[] {new_x, new_y});
				}
			}
			
			while(!ndq.isEmpty()) {
				int[] cur = ndq.pollFirst();
				mat[cur[0]][cur[1]] = 0;
				dq.add(cur);
			}
		}
		System.out.println((ans - 1));
		System.out.println(ans2);
	}

}
