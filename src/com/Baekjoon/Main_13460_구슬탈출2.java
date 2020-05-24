package com.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class BALL{
	int r_x, r_y, b_x, b_y, dir, cnt;
	BALL(){}
	BALL(int r1, int r2, int b1, int b2, int dir1, int cnt1){
		r_x = r1; r_y = r2; 
		b_x = b1; b_y = b2; dir = dir1; cnt = cnt1;
	}
}


public class Main_13460_구슬탈출2 {

	static int n, m, answer = 100;
	static String st[] = {};
	static char map[][] = new char [11][11];
	static BALL ball_info;
	final static int dx[] = {1, 0, -1, 0};
	final static int dy[] = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = br.readLine().split(" ");
		n = Integer.parseInt(st[0]); m = Integer.parseInt(st[1]);
		ball_info = new BALL(); ball_info.dir = -1;
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
			for(int j=0; j<m; j++) {
				if(map[i][j] == 'B') {
					ball_info.b_x = i; ball_info.b_y = j; map[i][j] = '.';
				}else if(map[i][j] == 'R') {
					ball_info.r_x = i; ball_info.r_y = j; map[i][j] = '.';
				}
			}
		}
	
		Queue<BALL> q = new LinkedList<BALL>();
		q.add(ball_info);
		
		while(!q.isEmpty()) {
			BALL cur = q.poll();
			
			for(int dir = 0; dir < 4; dir++) {
				int red_ball_cnt = 0, blue_ball_cnt = 0;
				if(cur.dir != -1 && cur.dir % 2 == dir % 2) continue;
				int new_rx = cur.r_x, new_ry = cur.r_y, new_bx = cur.b_x, new_by = cur.b_y;

				boolean red_flag = false, blue_flag = false;
				// RED
				while(true) {
					new_rx += dx[dir]; new_ry += dy[dir]; red_ball_cnt++;
					if(map[new_rx][new_ry] == '#' || map[new_rx][new_ry] == 'O') break;
				}if(map[new_rx][new_ry] == '#') {
					red_ball_cnt--; new_rx -= dx[dir]; new_ry -= dy[dir];
				}else red_flag = true;
				
				// BLUE
				while(true) {
					new_bx += dx[dir]; new_by += dy[dir]; blue_ball_cnt++;
					if(map[new_bx][new_by] == '#' || map[new_bx][new_by] == 'O') break;
				}if(map[new_bx][new_by] == '#') {
					blue_ball_cnt--; new_bx -= dx[dir]; new_by -= dy[dir];
				}else blue_flag = true;

				if(red_flag && blue_flag) {
					// fail
				}else if(red_flag) {
					answer = Math.min(answer, cur.cnt + 1);
				}else if(blue_flag) {
					// fail
				}else{
					if(new_rx == new_bx && new_ry == new_by) {
						if(red_ball_cnt < blue_ball_cnt) {
							new_bx -= dx[dir]; new_by -= dy[dir];
						}else {
							new_rx -= dx[dir]; new_ry -= dy[dir];
						}
					}
					if(cur.cnt < 9) {
						q.add(new BALL(new_rx, new_ry, new_bx, new_by, dir, cur.cnt + 1));
					}
				}
			}
		}
		if(answer == 100) answer = -1;
		System.out.println(answer);
	
	}

}
