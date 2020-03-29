package com.snakenladders.board;

import com.snakenladders.game.Player;

public final class Ladder extends SnakeNLadders
{
	
	@Override
	public void pull(Player p)
	{
		if (p.getTile() == tileOnTail)
		{
			System.out.println(p.getName() + " has climbed up a ladder");
			p.setTile(tileOnHead);
		}
	}
}
