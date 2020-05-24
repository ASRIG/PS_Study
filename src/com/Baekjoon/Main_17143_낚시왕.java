package com.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class SHARK implements Comparable<SHARK>{
	int x, y, s, d, z;
	boolean live_ = false;
	SHARK(){}
	SHARK(int x1, int y1, int s1, int d1, int z1, boolean l1){
		x = x1; y = y1; s = s1; d = d1; z = z1; live_ = l1;
	}
	@Override
	public int compareTo(SHARK o) {
		return -Integer.compare(this.z, o.z);
	}
}

public class Main_17143_낚시왕 {

	static String st[] = {};
	static int r, c, m, ans;
	static int map[][];
	static SHARK shark[];
	final static int dx[] = {-1, 0, 1, 0};
	final static int dy[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = br.readLine().split(" ");
		r = Integer.parseInt(st[0]); c = Integer.parseInt(st[1]); m = Integer.parseInt(st[2]);
		shark = new SHARK[m + 1]; map = new int[r + 1][c + 1];
		shark[0] = new SHARK(0,0,0,0, 0x7fffffff, false);
		for(int i=1; i<=m; i++) {
			st = br.readLine().split(" ");
			int sr = Integer.parseInt(st[0]) - 1, sc = Integer.parseInt(st[1]) - 1, ss = Integer.parseInt(st[2]);
			int sd = Integer.parseInt(st[3]) - 1, sz = Integer.parseInt(st[4]);
			
			if (sd == 1) sd = 2;
			else if (sd == 2) sd = 1;
			
			if (sd == 0 || sd == 2) ss %= (2 * (r - 1));
			else ss %= (2 * (c - 1));
			
			shark[i] = new SHARK(sr, sc, ss, sd, sz, true);
		} Arrays.sort(shark);
		
		
		for(int i=1; i<=m; i++) {
			map[shark[i].x][shark[i].y] = i; 
		}
		
		for(int p=0; p< c; p++) {
			for(int i=0; i<r; i++) {
				if(map[i][p] > 0) {
					shark[map[i][p]].live_ = false;
					ans += shark[map[i][p]].z; break;
				}
			}
			
			for(int j=1; j<=m; j++) {
				map[shark[j].x][shark[j].y] = 0;
			}
			
			for(int i=1; i<=m; i++) {
				if(!shark[i].live_) continue;
				int new_x = shark[i].x, new_y = shark[i].y;
				int dir = shark[i].d;
				
				boolean dir_change = false;
				if (dir == 0 && new_x == 0) dir_change = true;
				else if (dir == 1 && new_y == c - 1) dir_change = true;
				else if (dir == 2 && new_x == r - 1) dir_change = true;
				else if (dir == 3 && new_y == 0) dir_change = true;

				if (dir_change) {
					dir = (dir + 2) % 4;
					shark[i].d = dir;
				}
				
				for(int spd=0; spd < shark[i].s; spd++) {
					new_x += dx[dir]; new_y += dy[dir];
					if ((dir == 0 || dir == 2) && (new_x == 0 || new_x == r - 1)) {
						dir = (dir + 2) % 4;
						shark[i].d = dir;
					}
					if ((dir == 1 || dir == 3) && (new_y == 0 || new_y == c - 1)) {
						dir = (dir + 2) % 4;
						shark[i].d = dir;
					}
				}
				shark[i].x = new_x;  shark[i].y = new_y;
				if(map[new_x][new_y] > 0) {
					shark[i].live_ = false;
				}else {
					map[new_x][new_y] = i;
				}
			}
		}

		System.out.println(ans);
	}

}
