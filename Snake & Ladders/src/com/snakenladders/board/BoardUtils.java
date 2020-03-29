package com.snakenladders.board;

import java.util.List;

public final class BoardUtils {
	static int currentPosition;

	private BoardUtils() {
		System.out.println("You can't instantiate BoardUtils");
		throw new AssertionError();
	}

	public static void nearestSnakeAndLadder(Tile tile, List<Snake> snakes, List<Ladder> ladders, String name) {
		currentPosition = tile.tileCoordinate;
		int nearest = 101;
		int dif;

		System.out.println(name + " is at Tile no. " + currentPosition);

		for (Snake i : snakes) {
			dif = i.tileOnHead.tileCoordinate;

			if ((dif < nearest) && ((dif - currentPosition) > 0))
				nearest = dif;
		}

		System.out.println(nearest != 101 ? name + "'s nearest snake is at " + nearest : "");
		nearest = 101;

		for (Ladder i : ladders) {
			dif = i.tileOnTail.tileCoordinate;

			if ((dif < nearest) && ((dif - currentPosition) > 0))
				nearest = dif;
		}

		System.out.println(nearest != 101 ? name + "'s nearest ladder is at " + nearest : "");
	}
}
