package com.snakenladders.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Board {

	private final Map<Integer, Tile> BOARD_MAP = new HashMap<Integer, Tile>();
	public final List<Snake> snakes = new ArrayList<Snake>();
	public final List<Ladder> ladders = new ArrayList<Ladder>();

	public static final int NUMBER_OF_TILES = 100;

	public static final int[] SNAKE_HEAD_COORDINATES = { 17, 54, 62, 64, 87, 92, 95, 98 };
	public static final int[] SNAKE_TAIL_COORDINATES = { 7, 34, 19, 60, 36, 73, 75, 79 };

	public static final int[] LADDER_HEAD_COORDINATES = { 38, 14, 31, 42, 84, 67, 91, 99 };
	public static final int[] LADDER_TAIL_COORDINATES = { 1, 4, 9, 21, 28, 51, 72, 80 };

	public static final int NUMBER_OF_SNAKES = SNAKE_HEAD_COORDINATES.length;
	public static final int NUMBER_OF_LADDERS = LADDER_HEAD_COORDINATES.length;
	public static final int[] SNAKE_LENGTHS = new int[NUMBER_OF_SNAKES];
	public static final int[] LADDER_LENGTHS = new int[NUMBER_OF_SNAKES];

	public Board() {
		int loopController = NUMBER_OF_SNAKES >= NUMBER_OF_LADDERS ? NUMBER_OF_SNAKES : NUMBER_OF_LADDERS;

		// Initializing the lengths of snakes
		for (int i = 0; i < loopController; i++) {
			if (i < NUMBER_OF_SNAKES)
				SNAKE_LENGTHS[i] = SNAKE_HEAD_COORDINATES[i] - SNAKE_TAIL_COORDINATES[i];
			if (i < NUMBER_OF_LADDERS)
				LADDER_LENGTHS[i] = LADDER_HEAD_COORDINATES[i] - LADDER_TAIL_COORDINATES[i];
		}

		// Board-Building
		for (int i = 0; i <= (NUMBER_OF_TILES + 5); i++) // 5 is added to that there's room if the player is at the end
															// of the board, and he ends up having points more than 100
															// (to avoid Null Pointer Exception)
		{
			Tile e = new Tile(i);
			check(i, e);
			BOARD_MAP.put(i, e);
		}
	}

	// Checking whether a tile has a snake and instantiating one when there is
	private void check(int i, Tile tile) {
		for (int j = 0; j < NUMBER_OF_SNAKES; j++) {
			if (i == SNAKE_HEAD_COORDINATES[j]) {
				Snake e = new Snake();
				e.setTiles(tile, BOARD_MAP.get((i - SNAKE_LENGTHS[j])));
				snakes.add(e);
			}

			if (i == LADDER_HEAD_COORDINATES[j]) {
				Ladder e = new Ladder();
				e.setTiles(tile, BOARD_MAP.get((i - LADDER_LENGTHS[j])));
				ladders.add(e);
			}
		}
	}

	public Map<Integer, Tile> getBoardMap() {
		return BOARD_MAP;
	}
}
