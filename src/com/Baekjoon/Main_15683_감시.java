package com.Baekjoon;

import java.io.*;
import java.util.*;

public class Main_15683_감시 {

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
	
	static class CCTV{
		int x, y, idx;
		CCTV(int x1, int y1, int idx1){
			x = x1; y = y1; idx = idx1;
		}
	}
	
	static int n, m, map[][], cctv_cnt = 0, Ans = 0x7fffffff;
	final static int ddir[] = {0, 4, 2, 4, 4, 1};
	final static int dx[] = {-1, 0, 1, 0};
	final static int dy[] = {0, 1, 0, -1};
	static CCTV cctv[] = new CCTV[10];
	
	static int sol() {
		int ret = 0;
		for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
			if(map[i][j] == 0) ret++;
		}
		return ret;
	}
	
	static void copy_map(int src[][], int dest[][]) {
		for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
			dest[i][j] = src[i][j];
		}
	}
	
	static void see(int a, int b, int dir) {
		int new_a = a, new_b = b;
		while(true) {
			new_a += dx[dir]; new_b += dy[dir];
			if(new_a < 0 || new_a >= n || new_b < 0 || new_b >= m) break;
			if(map[new_a][new_b] == 6) break;
			if(map[new_a][new_b] != 0) continue;
			map[new_a][new_b] = -1;
		}
	}
	
	static void dfs(int i) {
		if(i == cctv_cnt) {
			Ans = Math.min(Ans, sol());
			return;
		}
		
		int tmp_map[][] = new int[n][m];
		int cctv_idx = cctv[i].idx;
		
		for(int dd = 0; dd < ddir[cctv_idx]; dd++) {
			copy_map(map, tmp_map);
			if(cctv_idx == 1) {
				see(cctv[i].x, cctv[i].y, dd);
			}
			else if(cctv_idx == 2) {
				see(cctv[i].x, cctv[i].y, dd);
				see(cctv[i].x, cctv[i].y, (dd + 2) % 4);
			}
			
			else if(cctv_idx == 3) {
				see(cctv[i].x, cctv[i].y, dd);
				see(cctv[i].x, cctv[i].y, (dd + 1) % 4);
			}
			else if(cctv_idx == 4) {
				see(cctv[i].x, cctv[i].y, dd);
				see(cctv[i].x, cctv[i].y, (dd + 2) % 4);
				see(cctv[i].x, cctv[i].y, (dd + 1) % 4);
			}
			else if(cctv_idx == 5) {
				see(cctv[i].x, cctv[i].y, dd);
				see(cctv[i].x, cctv[i].y, (dd + 2) % 4);
				see(cctv[i].x, cctv[i].y, (dd + 3) % 4);
				see(cctv[i].x, cctv[i].y, (dd + 1) % 4);
			}
			dfs(i + 1);
			copy_map(tmp_map, map);
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		MyScanner sc = new MyScanner();
		n = sc.nextInt(); m = sc.nextInt();
		map = new int[n][m];
		for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] > 0 && map[i][j] != 6) {
					cctv[cctv_cnt++] = new CCTV(i, j, map[i][j]);
				}
		}
		dfs(0);
		
		System.out.println(Ans);
	}

}
