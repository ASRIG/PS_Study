package com.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2104_부분배열고르기 {

	static int n;
	static int arr[];
	
	static long test_div(int start, int end) {
		int mid = (start + end) / 2;
		if(start == end) return (long) arr[start] * arr[start];
		long answer = Math.max(test_div(start, mid), test_div(mid + 1, end));
		int left = mid, right = mid, min_num = arr[mid];
		long sum = arr[mid];
		
		while(right - left < end - start) {
			int p = (left > start) ? Math.min(min_num, arr[left - 1]) : 0;
			int q = (right < end) ? Math.min(min_num, arr[right + 1]) : 0;
			if(left - 1 >= 0 && p * (sum + arr[left - 1]) >= q * (sum + arr[right + 1])) {
				min_num = p; sum += arr[--left];
			}else {
				min_num = q; sum += arr[++right];
			}
			answer = Math.max(answer, sum * min_num);
		}
		return answer;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		String str_tok[] = br.readLine().split(" ");
		for(int i=0; i< n; i++) {
			arr[i] = Integer.parseInt(str_tok[i]);
		}
		long ans = test_div(0, n - 1);
		System.out.println(ans);
		
	}

}
