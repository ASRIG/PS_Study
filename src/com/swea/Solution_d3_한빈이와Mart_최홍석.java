package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_d3_한빈이와Mart_최홍석 {

	static int n, m;
	static String str_tok[] = {};
	static int arr[] = new int[1001];
	
	static void qsort(int start, int end) {
		if(start == end) return;
		
		int tmp = arr[start]; arr[start] = arr[(start + end) / 2];
		 arr[(start + end) / 2] = tmp;
		
		int pivot = start, left = start, right = end - 1;
		
		while(left <= right) {
			while(left <= right && arr[left] <= arr[pivot]) left++;
			while(left <= right && arr[right] >= arr[pivot]) right--;
			if(left <= right) {
				tmp = arr[left]; arr[left] = arr[right]; arr[right] = tmp;
			}
		}
		
		tmp = arr[right]; arr[right] = arr[pivot]; arr[pivot] = tmp;
		qsort(start, right); qsort(right + 1, end);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tes = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= tes; test_case++) {
			int ans = -1;
			String str = br.readLine(); str_tok = str.split(" "); 
			n = Integer.parseInt(str_tok[0]);  m = Integer.parseInt(str_tok[1]);
			str_tok = br.readLine().split(" ");
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(str_tok[i]);
			}qsort(0, n);
			for(int i=0; i<n; i++) {
				for(int j = i + 1; j < n; j++) {
					int weight_ = arr[i] + arr[j];
					if(weight_ > m) break;
					ans = Math.max(ans, weight_);
				}
			}
			System.out.println("#" + test_case + " " + ans);
		
		}
	}

}
