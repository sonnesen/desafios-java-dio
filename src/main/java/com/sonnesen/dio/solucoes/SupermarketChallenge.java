package com.sonnesen.dio.solucoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SupermarketChallenge {

	// URI 2896

	public static void main(String[] args) throws IOException {

		int t, n, k = 0;

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken());

			while (t > 0) {
				st = new StringTokenizer(br.readLine());
				n = Integer.parseInt(st.nextToken());
				k = Integer.parseInt(st.nextToken());

				int result = (n % k) + (n / k);
				System.out.println(result);

				t--;
			}
		}

	}

}
