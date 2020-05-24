package com.Baekjoon;

import java.io.*;
import java.util.*;

public class Main_16924_십자가찾기 {

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
	
	static int n, m, tmp_map[][];
	static char map[][];	
	static boolean visited[][];
	final static int dx[] = {-1, 0, 1, 0};
	final static int dy[] = {0, 1, 0, -1};
	
	static boolean test() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == '*' && !visited[i][j]) return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		MyScanner sc = new MyScanner();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		Queue<Integer[]> q = new LinkedList<Integer[]>();
		n = sc.nextInt(); m = sc.nextInt();
		map = new char[n][m]; visited = new boolean[n][m]; tmp_map = new int[n][m];
		for(int i=0; i<n; i++) {
			map[i] = sc.br.readLine().toCharArray();
		}
		boolean is_true = false;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == '.') continue;
				int cur_x = i, cur_y = j, cross_size = 999999;
				for(int dir =0; dir <4; dir++) {
					int new_x = cur_x, new_y = cur_y, new_cnt = 0;
					while(true) {
						new_x += dx[dir]; new_y += dy[dir];
						if(new_x < 0 || new_x >= n || new_y < 0 || new_y >= m) break;
						if(map[new_x][new_y] == '.') break;
						new_cnt++;
					}
					cross_size = Math.min(new_cnt, cross_size);
				}
				
				if(cross_size > 0) {
					visited[cur_x][cur_y] = true;
					for(int dir =0; dir <4; dir++) {
						int new_x = cur_x, new_y = cur_y;
						for(int k=0; k < cross_size; k++) {
							new_x += dx[dir]; new_y += dy[dir];
							visited[new_x][new_y] = true;
						}
					}
				}
				tmp_map[i][j] = cross_size;
			}
		}
		
		is_true = test();
		
		if(!is_true) {out.println("-1");}
		else {
			int cntt = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(tmp_map[i][j] == 0) continue;
					cntt += 1;
				}
			}
			out.println(cntt);
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(tmp_map[i][j] == 0) continue;
					int cross_size = tmp_map[i][j];
					out.println((i + 1) + " " + (j + 1) + " " + cross_size);
				}
			}
			
		}
		out.flush();
	}

}
