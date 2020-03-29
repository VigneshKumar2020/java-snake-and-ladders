package com.snakenladders.board;

import com.snakenladders.game.Player;

public abstract class SnakeNLadders {
	// This class is only for convenience, to avoid writing same blocks of code in
	// Snake's and Ladders' classes
	Tile tileOnHead;
	Tile tileOnTail;

	void setTiles(Tile tileOnHead, Tile tileOnTail) {
		this.tileOnHead = tileOnHead;
		this.tileOnTail = tileOnTail;
	}

	public abstract void pull(Player p);
}