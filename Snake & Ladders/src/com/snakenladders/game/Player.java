package com.snakenladders.game;

import java.util.Random;
import java.util.Scanner;

import com.snakenladders.board.Tile;

public class Player
{
	Tile tile;
	Random rand = new Random();
	final String name;
	int output = 0;
	public final int DICE_BOUND = 6;
	Scanner sc = new Scanner(System.in);
	
	Player(String name, Tile tile)
	{
		this.name = name;
		this.tile = tile;
	}
	
	void input()
	{
		System.out.println();
		System.out.println(name + "! Enter anything to roll your die.");
		sc.next();
		output = rand.nextInt(DICE_BOUND) + 1;
		System.out.println(output);
	}
	 
	int getOutput()
	{
		return output;
	}
	
	public void setTile(Tile tile)
	{
		this.tile = tile;
	}
	
	public Tile getTile()
	{
		return tile;
	}
	
	public String getName()
	{
		return name;
	}
}