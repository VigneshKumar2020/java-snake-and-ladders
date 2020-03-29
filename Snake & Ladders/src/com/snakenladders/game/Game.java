package com.snakenladders.game;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.snakenladders.board.Board;
import com.snakenladders.board.BoardUtils;

public final class Game
{
	int numOfPlayers, numOfBots = 0;
	boolean wantsBot;
	boolean exceptionCaught = false;
	String name;
	List <Player> players = new ArrayList <Player>();
	List <String> names = new ArrayList <String>();
	
	Scanner sc = new Scanner(System.in);
	Player p;
	Board board = new Board();
	
	public Game()
	{
		intro();
		nameAllotment();
		game();
	}
	
	private void intro()
	{
		System.out.println("This is the classic Snake & Ladders");
		System.out.println("Do you want any bot player, they're just like other players with you?");
		String wantsBotStr = sc.next();
		
		wantsBot = (wantsBotStr.contains("y") || wantsBotStr.contains("Y"));
		
		botProgrammer();
		do
		{
			try
			{
				System.out.println("Alright, how many players are there" + (wantsBot ? ", other than the bots?" : "?"));
				numOfPlayers = sc.nextInt();
			}
			
			catch (InputMismatchException e)
			{
				System.out.println("Please enter correctly.");
				exceptionCaught = true;
			}
		}
		while (exceptionCaught);
	}
	
	private void botProgrammer()
	{
		if (wantsBot)
		{
			
			try
			{
				System.out.println("How many bots do you want? There're no limit to it.");
				numOfBots = sc.nextInt();
			}
			catch (InputMismatchException e)
			{
				System.out.println("Please enter correctly. How many bots do you want?");
				numOfBots = sc.nextInt();
			}
			
			System.out.println("As the host of this game, I'm proud to say you can name your bots");
			
			for (int i = 0; i < numOfBots; i++)
			{
				System.out.println("Enter the name of bot " + (i + 1));
				name = sc.next();
				players.add(new BotPlayer(name, board.getBoardMap().get(0)));
			}
		}
	}
	
	private void nameAllotment()
	{
		String name;
		
		for (int i = 0; i < numOfPlayers; i++)
		{
			System.out.println("Enter your name, player " + (i + 1));
			name = sc.next();
			Player e = new Player(name, board.getBoardMap().get(0));
			players.add(e);
			names.add(name);
		}
		
		numOfPlayers += numOfBots;
	}
	
	private void game()
	{
		outer:
		do
		{
			for (int j = 0; j < numOfPlayers; j++)
			{
				p = players.get(j);
				p.input();
				Judge.changeTile(p, board);
				
				if (Judge.getWon(p.getTile().tileCoordinate))
				{
					System.out.println(p.getName() + "! You won!");
					continue outer;
				}
				
				for (int k = 0; k < Board.NUMBER_OF_SNAKES; k++)
				{
					board.snakes.get(k).pull(p);
					board.ladders.get(k).pull(p);
				}
				
				BoardUtils.nearestSnakeAndLadder(p.getTile(), board.snakes, board.ladders, p.getName());
			}
		}
		while (!Judge.getWon(p.getTile().tileCoordinate));
		sc.close();
	}
}