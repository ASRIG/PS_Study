package com.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1725_히스토그램 {

	static int arr[];
	static int n;
	
	static int histogram(int start, int end) {
		int mid = (start + end) / 2;
		if(start == end) return arr[start];
		int ret = Math.max(histogram(start, mid), histogram(mid + 1, end));
		
		int left = mid, right = mid, w = 1, h = arr[mid];
		
		while(right - left < end - start) {
			int p = (left > start ? Math.min(h, arr[left - 1]) : 0);
			int q = (right < end ? Math.min(h, arr[right + 1]) : 0);
			if(left > 0 && p * (w + 1) >= q * (w + 1)) {
				h = p; w += 1; left -= 1;
			}else {
				h = q; w += 1; right += 1;
			}
			ret = Math.max(ret, w * h); 
		}
		return ret;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); arr = new int[n + 1];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int answer = histogram(0, n - 1);
		System.out.println(answer);
	}

}
