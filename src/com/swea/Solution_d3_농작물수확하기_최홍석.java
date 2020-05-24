package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class CUR_LOC{
	int x, y;
	CUR_LOC(int x1, int y1){
		this.x = x1; this.y = y1;
	}
}

public class Solution_d3_농작물수확하기_최홍석 {
	
	static char map[][] = new char[50][50];
	static int tes;
	static final int dx[] = {1, 0, -1, 0};
	static final int dy[] = {0, -1, 0, 1};
	static boolean visited[][] = new boolean[50][50];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tes = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= tes; test_case++) {
			int n = Integer.parseInt(br.readLine());
			for(int i=0; i<n; i++) {
				String str = br.readLine(); map[i] = str.toCharArray();
				for(int j=0; j<n; j++) visited[i][j] = false;
			}
			
			int m = n / 2;
			Queue<CUR_LOC> q = new LinkedList<CUR_LOC>();
			Queue<CUR_LOC> nxt_q = new LinkedList<CUR_LOC>();
			q.add(new CUR_LOC(m, m)); visited[m][m] = true;
			int ans = (map[m][m] - '0');
			for(int i=0; i<m; i++) {
				while(!q.isEmpty()) {
					CUR_LOC cur = q.poll();
					for(int dir = 0; dir < 4; dir++) {
						int new_x = cur.x + dx[dir], new_y = cur.y + dy[dir];
						if(visited[new_x][new_y]) continue;
						visited[new_x][new_y] = true; ans += (map[new_x][new_y] - '0');
						nxt_q.add(new CUR_LOC(new_x, new_y));
					}
				}
				while(!nxt_q.isEmpty()) q.add(nxt_q.poll());
			}
			
			
			System.out.println("#" + test_case + " " + ans);
		
		}
		
	}

}
