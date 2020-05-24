package com.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class PAIR3{
	int x, y;
	PAIR3(){}
	PAIR3(int x1, int y1){
		x = x1; y = y1;
	}
}

public class Main_3197_백조의호수 {

	static int n, m;
	static char map[][];
	static PAIR3 p[] = new PAIR3[2];
	final static int dx[] = {-1, 1, 0, 0};
	final static int dy[] = {0, 0, -1, 1};
	static Queue<PAIR3> q = new LinkedList<PAIR3>();
	static Queue<PAIR3> water_q = new LinkedList<PAIR3>();
	static Queue<PAIR3> nxt_q = new LinkedList<PAIR3>();
	
	static boolean move() {
		Queue<PAIR3> q2 = new LinkedList<PAIR3>();  q2.clear();
		boolean visited[][] = new boolean[n][m];
		q2.add(new PAIR3(p[0].x, p[0].y)); visited[p[0].x][p[0].y] = true;
		int dest_x =  p[1].x, dest_y = p[1].y;
		while(!q2.isEmpty()) {
			PAIR3 cur = q2.poll();
			for(int dir =0 ; dir < 4; dir++) {
				int new_x = cur.x + dx[dir], new_y = cur.y + dy[dir];
				if(new_x < 0 || new_x >= n || new_y < 0 || new_y >= m) continue;
				if(visited[new_x][new_y] || map[new_x][new_y] == 'X') continue;
				if(new_x == dest_x && new_y == dest_y) return true;
				visited[new_x][new_y] = true;
				q2.add(new PAIR3(new_x, new_y));
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		map = new char[n][m]; int l_cnt = 0;
		for(int i=0; i<n; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0; j<m; j++) {
				if(map[i][j] == 'L') {
					p[l_cnt++] = new PAIR3(i, j); map[i][j] = '.';
				}else if(map[i][j] == 'X') q.add(new PAIR3(i, j));
			}
		}
		
		int day = 0;
		
		while(true) {
			// ���� �̵� �׽�Ʈ
			if(move()) break;
			// �� ���̱�
			boolean ice_sw = true;
			while(!q.isEmpty()) {
				PAIR3 cur = q.poll(); ice_sw = true;
				for(int dir =0 ; dir < 4; dir++) {
					int new_x = cur.x + dx[dir], new_y = cur.y + dy[dir];
					if(new_x < 0 || new_x >= n || new_y < 0 || new_y >= m) continue;
					if(map[new_x][new_y] == '.') {
						water_q.add(cur); ice_sw = false; break; 
					}
				}
				if(ice_sw) nxt_q.add(cur);
			}
			while(!nxt_q.isEmpty()) q.add(nxt_q.poll());
			while(!water_q.isEmpty()) {
				PAIR3 cur = water_q.poll();
				map[cur.x][cur.y] = '.'; 
			}
			day++;
		}
		System.out.println(day);
		
	}

}
