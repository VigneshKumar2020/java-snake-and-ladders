package com.snakenladders.game;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.snakenladders.board.Tile;

public final class BotPlayer extends Player {
	String input = "";
	Random rand = new Random();

	static final int RANDOM_BOUND = 1;

	BotPlayer(final String name, Tile tile) {
		super(name, tile);
	}

	@Override
	void input() {
		try {
			System.out.println();
			System.out.println(name + "! Enter anything to roll");
			TimeUnit.MILLISECONDS.sleep(2000);
			System.out.println("e");
			output = rand.nextInt(DICE_BOUND) + 1;
			System.out.println(output);
		}

		catch (InterruptedException e) {
		}
		;
	}
}
