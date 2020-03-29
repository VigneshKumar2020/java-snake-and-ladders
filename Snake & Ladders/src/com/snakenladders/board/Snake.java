package com.snakenladders.board;

import com.snakenladders.game.Player;

public final class Snake extends SnakeNLadders
{
		
	@Override
	public void pull(Player p)
	{
		if (p.getTile().equals(tileOnHead))
		{
			System.out.println(p.getName() + " has gone down a snake.");
			p.setTile(tileOnTail);
		}
	}
}
