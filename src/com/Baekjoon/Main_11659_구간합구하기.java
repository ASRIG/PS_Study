package com.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11659_구간합구하기 {
	
	static int n, m;
	static String st[] = {};
	static int arr[], sum[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = br.readLine().split(" ");
		n = Integer.parseInt(st[0]); m = Integer.parseInt(st[1]);
		st = br.readLine().split(" ");
		arr = new int[n + 1]; sum = new int[n + 1];
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st[i - 1]);
			sum[i] = sum[i - 1] + arr[i];
		}
		
		for(int i=0; i<m; i++) {
			st = br.readLine().split(" ");
			int a = Integer.parseInt(st[0]), b = Integer.parseInt(st[1]);
			System.out.println(sum[b] - sum[a - 1]);
		}
		
		
		
	}

}
