package com.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class PAIR{
	int x, y;
	PAIR(){}
	PAIR(int x1, int y1){
		x = x1; y = y1;
	}
}

public class Main_5427_불 {
	
	static int n, m, Ans;
	static char map[][] = new char[1001][1001];
	final static int dx[] = {-1, 1, 0, 0};
	final static int dy[] = {0, 0, -1, 1};
	static boolean visited[][] = new boolean[1001][1001], fire_visited[][] = new boolean[1001][1001];
	static Queue<PAIR> q = new LinkedList<PAIR>();
	static Queue<PAIR> nxt_q = new LinkedList<PAIR>();
	static Queue<PAIR> fire = new LinkedList<PAIR>();
	static Queue<PAIR> nxt_fire = new LinkedList<PAIR>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tes = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= tes; test_case++) {
			st = new StringTokenizer(br.readLine()); Ans = 0;
			m = Integer.parseInt(st.nextToken()); n = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<n; i++) {
				map[i] = br.readLine().toCharArray();
				for(int j=0; j< map[i].length; j++) {
					visited[i][j] = false; fire_visited[i][j] = false;
					if(map[i][j] == '*') {
						fire.add(new PAIR(i, j)); visited[i][j] = true;
					}else if(map[i][j] == '@') {
						q.add(new PAIR(i, j)); visited[i][j] = true;
					}
				}
			}
			
			
			int Ans = 0;
			break_tag : while(true) {
				if(q.isEmpty()) {
					Ans = 0x7fffffff; break break_tag;
				}
				Ans++;
				// �� ����
				while(!fire.isEmpty()) {
					PAIR cur = fire.poll();
					for(int dir = 0; dir < 4; dir++) {
						int new_x = cur.x + dx[dir], new_y = cur.y + dy[dir];
						if(new_x < 0 || new_x >= n || new_y < 0 || new_y >= m) continue;
						if(fire_visited[new_x][new_y] || map[new_x][new_y] == '#') continue;
						visited[new_x][new_y] = true; fire_visited[new_x][new_y] = true;
						nxt_fire.add(new PAIR(new_x, new_y));
					}
				}
				// ��� �̵�
				while(!q.isEmpty()) {
					PAIR cur = q.poll();
					for(int dir = 0; dir < 4; dir++) {
						int new_x = cur.x + dx[dir], new_y = cur.y + dy[dir];
						if(new_x < 0 || new_x >= n || new_y < 0 || new_y >= m) break break_tag;
						if(visited[new_x][new_y] || map[new_x][new_y] == '#') continue;
						visited[new_x][new_y] = true;
						nxt_q.add(new PAIR(new_x, new_y));
					}
				}
				while(!nxt_q.isEmpty()) q.add(nxt_q.poll());
				while(!nxt_fire.isEmpty()) fire.add(nxt_fire.poll());
			}
			
			if(Ans == 0x7fffffff) System.out.println("IMPOSSIBLE");
			else System.out.println(Ans);
			while(!q.isEmpty()) q.poll(); while(!nxt_q.isEmpty()) nxt_q.poll();
			while(!fire.isEmpty()) fire.poll(); while(!nxt_fire.isEmpty()) nxt_fire.poll();
		}
		
	}

}
