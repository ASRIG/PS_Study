package com.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_1062_가르침_서울_06_최홍석 {
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
	
	static int n, k, ans = 0;
	static char str[][] = new char[50][26];
	static boolean isokay[] = new boolean[26];
	static char defaultchar[] = {'a', 'n', 't', 'c', 'i'};
	
	
	static void dfs(int idx, int cnt) {
		if(cnt == k) {
			int tmpans = 0;
			for(int i = 0; i < n; i++) {
				boolean okaychar = true;
				for(char j : str[i]) {
					if(!isokay[j - 'a']) {
						okaychar = false; break;
					}
				}
				if(okaychar) tmpans++;
			}
			ans = Math.max(ans,tmpans);
			return;
		}
		
		for(int i = idx; i < 26; i++) {
			if(i == 0 || i == 2 || i == 13 || i == 19 || i == 8) continue;
			isokay[i] = true;
			dfs(i + 1, cnt + 1);
			isokay[i] = false;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		MyScanner sc = new MyScanner();
		n = sc.nextInt(); k = sc.nextInt(); k -= 5;
		for(int i = 0; i < n; i++) {
			str[i] = sc.br.readLine().toCharArray();
		}
		for(char c : defaultchar) isokay[c - 'a'] = true;
		dfs(0, 0);
		System.out.println(ans);
	}

}
