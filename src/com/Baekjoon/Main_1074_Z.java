package com.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1074_Z {
	
	static String str_tok[] = {};
	static int n, cnt, r, c;
	static int ans;
	final static int dx[] = {0, 0, 1, 1};
	final static int dy[] = {0, 1, 0, 1};
	
	
	public static void Z(int idx1, int idy1, int size1) {
		if(ans > 0) return;
		if(size1 == 2) {
			for(int dir = 0; dir <4; dir++) {
				int new_x = idx1 + dx[dir], new_y = idy1 + dy[dir];
				if(new_x == r && new_y == c) ans = cnt;
				cnt++; 
			}
			return;
		}
		
		int tmp_size = size1 / 2;
		
		for(int i = idx1; i < idx1 + size1; i += tmp_size) {
			for(int j = idy1; j < idy1 + size1; j += tmp_size) {
				Z(i, j, tmp_size);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str_tok = br.readLine().split(" ");	
		n = Integer.parseInt(str_tok[0]); r = Integer.parseInt(str_tok[1]); c = Integer.parseInt(str_tok[2]);
		Z(0, 0, 1 << n);
		System.out.println(ans);
	}
}
