package com.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9997_폰트{

	static int n, Ans;
	static int arr[][];
	static int a[] = new int[26];
	
	static boolean test() {
		for(int k=0; k < 26; k++) {
			if(a[k] == 0) return false;
		}
		return true;
	}
	
	static void dfs(int idx) {
		if(test()) {
			Ans++;
		}
		
		for(int i=idx; i < n; i++) {
			for(int j=0; j<26; j++) {
				a[j] += arr[i][j];
			}
			dfs(i + 1);
			for(int j=0; j<26; j++) {
				a[j] -= arr[i][j];
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][26];
		for(int i=0; i<n; i++) {
			char ch[] = br.readLine().toCharArray();
			for(int j=0; j<ch.length; j++) {
				arr[i][ch[j] - 'a']++;
			}
		}
		
		dfs(0);
		System.out.println(Ans);
		
	}

}
