package com.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class PAIR2{
	int x, y, b, cnt;
	PAIR2(){}
	PAIR2(int x1, int y1, int b1, int c1){
		x = x1; y = y1; b = b1; cnt = c1;
	}
}

public class Main_2206_벽부수고이동하기{

	static int n, m;
	static char map[][];
	static int visited[][][];
	final static int dx[] = {-1, 1, 0, 0};
	final static int dy[] = {0, 0, -1, 1};
	static Queue<PAIR2> q = new LinkedList<PAIR2>(); 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		map = new char[n][m]; visited = new int[n][m][2];
		for(int i=0; i<n; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0; j<m; j++) {
				visited[i][j][0] = 0x7fffffff; visited[i][j][1] = 0x7fffffff;
			}
		}
		
		if(map[0][0] == '1') {
			q.add(new PAIR2(0, 0, 0, 1)); visited[0][0][0] = 0;
		}else {
			q.add(new PAIR2(0, 0, 1, 1)); visited[0][0][1] = 0;
		}
		int Ans = 0x7fffffff;
		while(!q.isEmpty()) {
			PAIR2 cur = q.poll();
			if(cur.cnt >= Ans) continue;
			if(cur.x == n - 1 && cur.y == m - 1) {
				Ans = Math.min(Ans, cur.cnt); continue;
			}
			
			for(int dir = 0; dir < 4; dir++) {
				int new_x = cur.x + dx[dir], new_y = cur.y + dy[dir];
				if(new_x < 0 || new_x >= n || new_y < 0 || new_y >= m) continue;
				if(map[new_x][new_y] == '1') {
					if(cur.b == 0) continue;
					int new_b = 0; 
					if(visited[new_x][new_y][new_b] > cur.cnt + 1) {
						visited[new_x][new_y][new_b] = cur.cnt + 1;
						q.add(new PAIR2(new_x, new_y, new_b, cur.cnt + 1));
					}
					
				}else {
					if(visited[new_x][new_y][cur.b] > cur.cnt + 1) {
						visited[new_x][new_y][cur.b] = cur.cnt + 1;
						q.add(new PAIR2(new_x, new_y, cur.b, cur.cnt + 1));
					}
				}
			}
		}
		if(Ans == 0x7fffffff) Ans = -1;
		System.out.println(Ans);
	}

}
