package com.Baekjoon;

import java.io.*;
import java.util.*;

public class Main_15925_욱제는정치쟁이야 {

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
	
	static int N, C, mat[][] = new int[32][32];
	
	public static void main(String[] args) throws IOException{
		MyScanner sc = new MyScanner();
		N = sc.nextInt(); C = sc.nextInt();
		for(int i = 0; i < N; i++) for(int j = 0; j < N; j++) mat[i][j] = sc.nextInt();
		boolean isTrue = true, isUpdated = true;
		while(isUpdated) {
			isUpdated = false;
			for(int i = 0; i < N; i++) {
				int oneCnt1 = 0, oneCnt2 = 0;
				for(int j = 0; j < N; j++){
					oneCnt1 += (mat[i][j] == 1 ? 1 : 0); oneCnt2 += (mat[j][i] == 1 ? 1 : 0);
				}
				
				if(C == 1) {
					if(oneCnt1 > N - oneCnt1 && oneCnt1 != N) {
						isUpdated = true;
						for(int j = 0; j < N; j++) mat[i][j] = C;
					}
					if(oneCnt2 > N - oneCnt2 && oneCnt2 != N) {
						isUpdated = true;
						for(int j = 0; j < N; j++) mat[j][i] = C;
					}
				}else {
					if(oneCnt1 <= N - oneCnt1 && oneCnt1 != 0) {
						isUpdated = true;
						for(int j = 0; j < N; j++) mat[i][j] = C;
					}
					if(oneCnt2 <= N - oneCnt2 && oneCnt2 != 0) {
						isUpdated = true;
						for(int j = 0; j < N; j++) mat[j][i] = C;
					}
				}
			}
		}
		
		for(int i = 0; i < N; i++) for(int j = 0; j < N; j++) if(mat[i][j] != C) isTrue = false;
		
		System.out.println((isTrue ? 1 : 0));
	}

}
