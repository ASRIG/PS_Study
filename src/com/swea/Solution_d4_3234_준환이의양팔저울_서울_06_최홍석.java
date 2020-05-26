package com.swea;

import java.io.*;
import java.util.*;

public class Solution_d4_3234_준환이의양팔저울_서울_06_최홍석 {
	static int t, n, arr[] = new int[10], ans = 0;
	static boolean isright[];
	
	static void dfs(int cnt, int leftw, int rightw) {
		if(cnt == n) {ans++; return;}
		dfs(cnt + 1, leftw + arr[cnt], rightw);
		if(leftw >= rightw + arr[cnt]) dfs(cnt + 1, leftw, rightw + arr[cnt]);
	}
	static void dfs2(int cnt) {
		if(cnt == n) {dfs(0, 0, 0); return;}
		for(int i = cnt; i < n; i++) {
			swap(i, cnt); dfs2(cnt + 1); swap(i, cnt);
		}
	}
	static void swap(int ia, int ib) {
		int tmp = arr[ia]; arr[ia] = arr[ib]; arr[ib] = tmp;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine()); ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
			dfs2(0);
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
