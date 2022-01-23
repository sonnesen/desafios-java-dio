package com.sonnesen.dio.solucoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HeadOrTailChallenge {

	// URI 1329

	public static void main(String[] args) throws IOException {
		int n, x;
		int mary = 0, john = 0;

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());

			while (n > 0) {
				mary = 0;
				john = 0;

				st = new StringTokenizer(br.readLine());

				for (int i = 0; i < n; i++) {
					x = Integer.parseInt(st.nextToken());

					if (x == 0) {
						mary++;
					} else {
						john++;
					}
				}

				System.out.println("Mary won " + mary + " times and John won " + john + " times");

				st = new StringTokenizer(br.readLine());
				n = Integer.parseInt(st.nextToken());
			}

		}

	}
}
