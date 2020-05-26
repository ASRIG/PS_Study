package com.Baekjoon;

import java.io.*;
import java.util.*;

public class Main_11967_불켜기 {

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
	
	static int N, M, x, y, a, b;
	static boolean visited[][];
	static LinkedList<Integer> arrList[] = new LinkedList[10001];
	static boolean isLight[] = new boolean[10001];
	final static int dx[] = {1, 0, -1, 0};
	final static int dy[] = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException{
		MyScanner sc = new MyScanner();
		N = sc.nextInt(); M = sc.nextInt();
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) for(int j = 0; j < N; j++) arrList[i * N + j] = new LinkedList<>();
		for(int i = 0; i < M; i++) {
			x = sc.nextInt() - 1; y = sc.nextInt() - 1; a = sc.nextInt() - 1; b = sc.nextInt() - 1;
			arrList[x * N + y].add(a * N + b);
		}
		
		
		int ans = 1;
		Deque<int[]> dq = new LinkedList<>();
		dq.add(new int[] {0, 0}); 
		visited[0][0] = true; isLight[0] =  true;
		
		while(!dq.isEmpty()) {
			int[] cur = dq.pollFirst();
			while(!arrList[cur[0] * N + cur[1]].isEmpty()) {
				int k = arrList[cur[0] * N + cur[1]].pollFirst();
				ans += (isLight[k] == false ? 1 : 0);
				isLight[k] = true;
				if(visited[k / N][k % N]) dq.add(new int[] {k / N, k % N});
			}
			
			for(int dir = 0; dir < 4; dir++) {
				int new_x = cur[0] + dx[dir], new_y = cur[1] + dy[dir];
				if(new_x < 0 || new_x >= N || new_y < 0 || new_y >= N) continue;
				if(visited[new_x][new_y]) continue;
				visited[new_x][new_y] = true;
				if(!isLight[new_x * N + new_y]) continue;
				dq.add(new int[] {new_x, new_y});
			}
		}
		System.out.println(ans);
	}

}
