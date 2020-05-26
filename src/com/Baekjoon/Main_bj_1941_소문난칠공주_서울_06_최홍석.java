package com.Baekjoon;

import java.io.*;
import java.util.*;

public class Main_bj_1941_소문난칠공주_서울_06_최홍석 {
	static Queue<int[]> q = new LinkedList<>();
	static char tmp_map[][] = new char[5][5];
	static LinkedList<Integer> li = new LinkedList<Integer>();
	static boolean pick[] = new boolean[25];
	static boolean picked[][] = new boolean[5][5];
	static int ans = 0, map[][] = new int[5][5];
	final static int dx[] = {-1, 1, 0, 0};
	final static int dy[] = {0, 0, -1, 1};
	
	static void dfs(int idx, int cnt, int t) {
		if(7 - cnt + t < 4) return;
		if(cnt == 7) {
			for(int k : li) picked[k / 5][k % 5] = true;
			boolean visited[][] = new boolean[5][5];
			int fir_num = li.get(0);
			q.add(new int[] {fir_num/5, fir_num%5}); visited[fir_num/5][fir_num%5] = true;
			int cntt = 1;
			while(!q.isEmpty()) {
				int[] k = q.poll();
				int x = k[0], y = k[1];
				for(int dir = 0; dir < 4; dir++) {
					int new_x = x + dx[dir], new_y = y + dy[dir];
					if(new_x < 0 || new_x >= 5 || new_y < 0 || new_y >= 5) continue;
					if(!picked[new_x][new_y] || visited[new_x][new_y]) continue;
					visited[new_x][new_y] = true;
					q.add(new int[] {new_x, new_y}); cntt++;
				}
			}
			if(cntt == 7) ans++; 
			for(int k : li) picked[k / 5][k % 5] = false;
			return;
		}
		for(int i = idx; i < 25; i++) {
			li.add(i);
			dfs(i + 1, cnt + 1, t + map[i / 5][i % 5]);
			li.pollLast();
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 5; i++) {
			tmp_map[i] = br.readLine().toCharArray();
			for(int j = 0; j < 5; j++) {
				if(tmp_map[i][j] == 'Y') map[i][j] = 0;
				else map[i][j] = 1;
			}
		}
		for(int i = 0; i < 24; i++) {
			li.add(i);
			dfs(i + 1, 1, map[i/5][i%5]);
			li.pollLast();
		}
		System.out.println(ans);
	}

}