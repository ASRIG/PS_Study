package com.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2212_센서 {
	
	static int n, k;
	static int sense[] = new int[10001];
	static String str_tok[] = {};
	
	static void qsort(int start, int end, int arr[]) {
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
		qsort(start, right, arr); qsort(right + 1, end, arr);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); k = Integer.parseInt(br.readLine());
		str_tok = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			sense[i] = Integer.parseInt(str_tok[i]);
		}qsort(0, n, sense);
		int diff[] = new int[10001];
		for(int i=0; i<n-1; i++) diff[i] = sense[i + 1] - sense[i];
		qsort(0, n-1, diff);
		int answer = 0;
		for(int i=0; i<n - k; i++) answer += diff[i];
		System.out.println(answer);
	}

}
