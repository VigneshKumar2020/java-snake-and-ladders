package com.snakenladders.game;

import com.snakenladders.board.Board;

public final class Judge
{
	private Judge()
	{
		System.out.println("You can't instantiate Judge!");
		throw new AssertionError();
	}
	static boolean getWon(int tileCoordinate)
	{
		return (tileCoordinate >= 100);
	}
	
	static void changeTile(Player p, Board b)
	{
		p.setTile(b.getBoardMap().get(p.getTile().tileCoordinate + p.getOutput()));
	}
}