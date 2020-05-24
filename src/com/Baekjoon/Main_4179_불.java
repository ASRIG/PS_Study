package com.Baekjoon;

import java.io.*;
import java.util.*;

public class Main_4179_불 {

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
		int x, y, z;
		public PAIR(int x, int y, int z) {
			this.x = x; this.y = y; this.z = z;
		}
	}
	
	static Queue<PAIR> q = new LinkedList<PAIR>();
	static Queue<PAIR> nxt_q = new LinkedList<PAIR>();
	static Queue<PAIR> fire = new LinkedList<PAIR>();
	static Queue<PAIR> nxt_fire = new LinkedList<PAIR>();
	static int r, c, Ans = 0x7fffffff;
	static boolean visited[][];
	static char map[][];
	final static int dx[] = {-1, 0, 1, 0};
	final static int dy[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{
		MyScanner sc = new MyScanner();
		r = sc.nextInt(); c = sc.nextInt();
		map = new char[r][c]; visited = new boolean[r][c];
		
		for(int i=0; i<r; i++) {
			map[i] = sc.br.readLine().toCharArray();
			for(int j=0; j<c; j++) {
				if(map[i][j] == 'J') {
					map[i][j] = '.'; visited[i][j] = true;
					q.add(new PAIR(i, j, 0));
				}else if(map[i][j] == 'F') {
					visited[i][j] = true; fire.add(new PAIR(i, j, 0));
				}
			}
		}
		
		boolean is_dead = true;
		while(!q.isEmpty() && is_dead) {
			// ���� ���� ����.
			while(!fire.isEmpty()) {
				PAIR cur = fire.poll();
				for(int dir = 0; dir < 4; dir++) {
					int new_x = cur.x + dx[dir], new_y = cur.y + dy[dir];
					if(new_x < 0 || new_x >= r || new_y < 0 || new_y >= c) continue;
					if(map[new_x][new_y] == 'F' || map[new_x][new_y] == '#') continue;
					map[new_x][new_y] = 'F';
					nxt_fire.add(new PAIR(new_x,new_y, 0));
				}
			}
			
			while(!q.isEmpty()) {
				PAIR cur = q.poll();
				for(int dir = 0; dir < 4; dir++) {
					int new_x = cur.x + dx[dir], new_y = cur.y + dy[dir];
					if(new_x < 0 || new_x >= r || new_y < 0 || new_y >= c) {
						Ans = Math.min(Ans, cur.z + 1); is_dead = false; break;
					}
					if(map[new_x][new_y] == 'F' || map[new_x][new_y] == '#') continue;
					if(visited[new_x][new_y]) continue;
					visited[new_x][new_y] = true;
					nxt_q.add(new PAIR(new_x,new_y, cur.z + 1));
				}
			}
			
			while(!nxt_fire.isEmpty()) fire.add(nxt_fire.poll());
			while(!nxt_q.isEmpty()) q.add(nxt_q.poll());
		}
		if(Ans == 0x7fffffff) System.out.println("IMPOSSIBLE");
		else System.out.println(Ans);
		
		
	}

}
