package com.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463_1로만들기 {

	static int n;
	static int dp[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];
		dp[1] = 0;
		for(int i=2; i<= n; i++) {
			int a = 999999, b = 999999;
			if(i % 2 == 0) a = dp[i / 2];
			if(i % 3 == 0) b = dp[i / 3];
			dp[i] = Math.min(a, Math.min(b, dp[i - 1])) + 1;
		}
		System.out.println(dp[n]);
	}

}
