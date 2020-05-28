package com.swea;

import java.io.*;
import java.util.*;

public class Solution_1953_탈주범검거_ {
	final static int INF = 98765;
	static int N, M, T, R, C, L, mat[][] = new int[51][51], dist[][] = new int[51][51];
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, -1, 0, 1};
	static int dd[][] = {{}, {0,1,2,3}, {0, 2}, {1, 3}, {0, 3}, {2, 3}, {2, 1}, {0, 1}};
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); M = sc.nextInt(); R = sc.nextInt();
			C = sc.nextInt(); L = sc.nextInt();
			for(int i = 0; i < N; i++) for(int j = 0; j<M; j++) {
				mat[i][j] = sc.nextInt(); dist[i][j] = INF;
			}dist[R][C] = 1; int ans = 1;
			Deque<int[]> dq = new LinkedList<>(); dq.add(new int[] {R, C, 1});
			while(!dq.isEmpty()) {
				int[] cur = dq.pollFirst();
				if(dist[cur[0]][cur[1]] != cur[2] || cur[2] >= L) continue;
				for(int nxt : dd[mat[cur[0]][cur[1]]]) {
					boolean isTrue = false;
					int new_x = cur[0] + dx[nxt], new_y = cur[1] + dy[nxt];
					if(new_x < 0 || new_x >= N || new_y < 0 || new_y >= M) continue;
					for(int k : dd[mat[new_x][new_y]]) if(k == (nxt + 2) % 4) isTrue = true;
					if(isTrue && dist[new_x][new_y] > cur[2] + 1) {
						dist[new_x][new_y] = cur[2] + 1; ans++;
						dq.add(new int[] {new_x,new_y, cur[2] + 1});
					}
				}
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
