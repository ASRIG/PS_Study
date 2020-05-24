package com.Baekjoon;

import java.io.*;
import java.util.*;

public class Main_2638_치즈 {

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
	
	static class PAIR{
		int x, y, time;
		PAIR(int x, int y, int time){
			this.x = x; this.y = y; this.time = time;
		}
	}
	
	static int n, m, map[][], origin_map[][], max_val, ans_cnt = 0, cheese_cnt = 0;
	static Queue<PAIR> q = new LinkedList<PAIR>();
	static Queue<PAIR> nxt_q = new LinkedList<PAIR>();
	final static int dx[] = {-1, 0, 1, 0};
	final static int dy[] = {0, 1, 0, -1};
	
	static void zero_update(int tm) {
		for(int i=0; i < n; i++) for(int j=0; j<m; j++) origin_map[i][j] = -1;
		
		q.add(new PAIR(0, 0, tm)); origin_map[0][0] = tm;
		while(!q.isEmpty()) {
			PAIR cur = q.poll();
			for(int dir = 0; dir < 4; dir++) {
				int new_x = cur.x + dx[dir], new_y = cur.y + dy[dir];
				if(new_x < 0 || new_x >= n || new_y < 0 || new_y >= m) continue;
				if(origin_map[new_x][new_y] == -1 && map[new_x][new_y] == 0) {
					origin_map[new_x][new_y] = tm;
					q.add(new PAIR(new_x, new_y, 1));
				}
			}
		}
		
		for(int i=0; i < n; i++) for(int j=0; j<m; j++) {
			if(origin_map[i][j] != -1) q.add(new PAIR(i, j, tm));
		}
		
		
	}
	
	static void go() {
		int time_ = 0;
		while(cheese_cnt > 0) {
			time_++;
			while(!q.isEmpty()) {
				PAIR cur = q.poll();
				for(int dir = 0; dir < 4; dir++) {
					int new_x = cur.x + dx[dir], new_y = cur.y + dy[dir];
					if(new_x < 0 || new_x >= n || new_y < 0 || new_y >= m) continue;
					if(map[new_x][new_y] == 1) {
						// ������� ���� Ȯ��
						int zero_cnt = 0;
						for(int ddir = 0; ddir < 4; ddir++) {
							int new_x2 = new_x + dx[ddir], new_y2 = new_y + dy[ddir];
							if(new_x2 < 0 || new_x2 >= n || new_y2 < 0 || new_y2 >= m) continue;
							if(origin_map[new_x2][new_y2] >= 0) zero_cnt++;
						}
						if(zero_cnt > 1) {
							nxt_q.add(new PAIR(new_x, new_y, cur.time + 1));
							max_val = Math.max(max_val, cur.time + 1);
						}
					}
				}
			}
			
			while(!nxt_q.isEmpty()) {
				PAIR cur = nxt_q.poll();
				if(map[cur.x][cur.y] != 0) cheese_cnt--;
				map[cur.x][cur.y] = 0; //q.add(new PAIR(cur.x, cur.y, cur.time));
			}
			
			zero_update(time_);
//
//			System.out.println(cheese_cnt);
//			for(int i=0; i<n ; i++) {
//				for(int j=0; j<m; j++) {
//					System.out.printf("%d ", map[i][j]);
//				}System.out.println();
//			}System.out.println();
			
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		MyScanner sc = new MyScanner();
		n = sc.nextInt(); m = sc.nextInt();
		map = new int[n][m]; origin_map = new int[n][m];
		
		
		for(int i=0; i < n; i++) for(int j=0; j<m; j++) {
			map[i][j] = sc.nextInt();
			if(map[i][j] == 1) cheese_cnt++;
			//origin_map[i][j] = -1;
		}
		zero_update(0);
		go();
		System.out.println(max_val);
	}

}
