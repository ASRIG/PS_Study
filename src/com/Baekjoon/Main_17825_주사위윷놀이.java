package com.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17825_주사위윷놀이 {
	static String st[] = {};
	static int cmd[] = new int[11];
	static int map[] = new int[101];
	static int ans = 0;
	
	static void dfs(int x1, int x2, int x3, int x4, int cnt, int score) {
		if(cnt == 10) {
			ans = Math.max(ans, score); return;
		}
		
		int x[] = new int[4];
		x[0] = x1; x[1] = x2; x[2] = x3; x[3] = x4;
		for(int i=0; i<4; i++) {
			if(x[i] == 21 || x[i] == 38 || x[i] == 57 || x[i] == 78) continue;
			int cur_x = x[i], tmpp = x[i];
			if(cur_x == 5) cur_x = 30;
			else if(cur_x == 10) cur_x = 50;
			else if(cur_x == 15) cur_x = 70;
			
			int tmp_x = cur_x + cmd[cnt];
			
			// �������� Ȯ��
			if(cur_x <= 20 && tmp_x >= 21) tmp_x = 21;
			else if((cur_x >= 30 && cur_x < 50) && tmp_x > 37) tmp_x = 38;
			else if((cur_x >= 50 && cur_x < 70) && tmp_x > 56) tmp_x = 57;
			else if((cur_x >= 70 && cur_x < 90) && tmp_x > 77) tmp_x = 78;
			
			// �̹� �ش��ϴ� ���� �����ϴ� �� Ȯ���ϱ�
			boolean false_sw = true;
			for(int ia=0; ia < 4; ia++) {
				if(ia == i) continue;
				if (tmp_x == 21 || tmp_x == 38 || tmp_x == 57 || tmp_x == 78) continue;
				
				if(tmp_x == 20 || tmp_x == 37 || tmp_x == 56 || tmp_x == 77) {
					if(x[ia] == 20 || x[ia] == 37 || x[ia] == 56 || x[ia] == 77) false_sw = false;
				}
				else if (tmp_x == 36 || tmp_x == 55 || tmp_x == 76) {
					if (x[ia] == 36 || x[ia] == 55 || x[ia] == 76) false_sw = false;
				}
				else if (tmp_x == 35 || tmp_x == 54 || tmp_x == 75) {
					if (x[ia] == 35 || x[ia] == 54 || x[ia] == 75) false_sw = false;
				}
				else if (tmp_x == 34 || tmp_x == 53 || tmp_x == 74) {
					if (x[ia] == 34 || x[ia] == 53 || x[ia] == 74) false_sw = false;
				}else if(tmp_x == x[ia]) {
					false_sw = false;
				}
			}
			if(!false_sw) continue;
			x[i] = tmp_x;
			dfs(x[0], x[1], x[2], x[3], cnt + 1, score + map[x[i]]);
			x[i] = tmpp;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = br.readLine().split(" ");
		for(int i=0; i<10; i++) cmd[i] = Integer.parseInt(st[i]);
		// ���� �����Ѵ�.
		for(int i=1; i<=20; i++) {
			map[i] = i * 2;
		}
		map[30] = 10; map[31] = 13; map[32] = 16; map[33] = 19; map[34] = 25;
		map[35] = 30; map[36] = 35; map[37] = 40;
		
		map[50] = 20; map[51] = 22; map[52] = 24; map[53] = 25; map[54] = 30;
		map[55] = 35; map[56] = 40;
		
		map[70] = 30; map[71] = 28; map[72] = 27; map[73] = 26; map[74] = 25;
		map[75] = 30; map[76] = 35; map[77] = 40;

		dfs(0, 0, 0, 0, 0, 0);
		System.out.println(ans);
	}

}
