package Riri;

import java.util.Random;

public class Ex_08_5 {
	public static void main(String[] args) {
		// さいころの目の最大値。
		int maxPips = 6;

		// さいころの数
		int diceCount = 2;

		// さいころを振る回数。
		int rollCount = 100;

		// 乱数器。
		Random rand = new Random();

		// 目ごとの出現回数。インデックス 0 は使わない。
		int[] pipCounts = new int[maxPips * diceCount + 1];

		// さいころを振って出目の回数を数える。
		for (int i = 0; i < rollCount; i++) {
			// さいころを振る。
			int pips = roll(rand, maxPips, diceCount);

			// 出目の数を増やす。
			pipCounts[pips]++;
		}

		// 結果を画面に出力する。
		for (int pips = 1; pips <= maxPips * diceCount; pips++) {
			// 出目の合計ごとの回数。
			int count = pipCounts[pips];

			// 回数の長さの文字列を作る。
			String countString = CreateCountString('*', count);

			// 画面に出力する。
			String line = String.format("目の合計が%3d: %5d回 %s", pips, count, countString);
			System.out.println(line);
		}
	}

	/**
	 * さいころを振る。
	 * @param rand 乱数器。
	 * @param maxPips 目の最大。
	 * @param diceCount さいころの数。
	 * @return さいころの出目の合計。
	 */
	private static int roll(Random rand, int maxPips, int diceCount) {
		int result = 0;

		for (int i = 0; i < diceCount; i++) {
			result += rand.nextInt(maxPips) + 1;
		}

		return result;
	}

	/**
	 * 指定した数の長さの文字列を返す。
	 * @param c 並べる文字。
	 * @param count 文字列の長さ。
	 * @return
	 */
	private static String CreateCountString(char c, int count) {
		StringBuilder sb = new StringBuilder(count);

		for (int i = 0; i < count; i++) {
			sb.append(c);
		}

		return sb.toString();
	}
}
