package com.Baekjoon;

import java.io.*;
import java.util.*;

public class Main_15686_치킨배달 {

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
		PAIR(int x, int y, int z){
			this.x = x; this.y = y; this.z = z;
		}
	}
	
	static int n, m, map[][], house_cnt = 0, chicken_cnt = 0, Ans = 0x7fffffff;
	static PAIR chicken[], house[];
	
	static int calc() {
		int ret = 0;
		for(int i=0; i< house_cnt; i++) {
			int tmp_d = 0x7fffffff;
			for(int j=0; j< chicken_cnt; j++) {
				if(chicken[j].z == 0) continue;
				int tmp =Math.abs((chicken[j].x - house[i].x)) + Math.abs((chicken[j].y - house[i].y));
				tmp_d = Math.min(tmp_d, tmp);
			}
			ret += tmp_d;
		}
		return ret;
	}
	
	static void dfs(int idx, int cnt) {
		
		if(cnt != 0 && cnt <= m) {
			Ans = Math.min(Ans, calc());
			if(cnt == m) return;
		}
		
		for(int i = idx; i < chicken_cnt; i++) {
			chicken[i].z = 1;
			dfs(i + 1, cnt + 1);
			chicken[i].z = 0;
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		MyScanner sc = new MyScanner();
		n = sc.nextInt(); m = sc.nextInt();
		map = new int[n][n]; house = new PAIR[2*n + 1]; chicken = new PAIR[14];
		for(int i=0; i<n; i++) for(int j=0; j<n; j++) {
			map[i][j] = sc.nextInt();
			if(map[i][j] == 1) {
				house[house_cnt++] = new PAIR(i, j, 1);
			}else if(map[i][j] == 2) {
				chicken[chicken_cnt++] = new PAIR(i, j, 0);
			}
		}dfs(0, 0);
		System.out.println(Ans);
	}

}
