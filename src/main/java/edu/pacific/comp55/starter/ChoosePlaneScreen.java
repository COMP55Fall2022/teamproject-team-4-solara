package edu.pacific.comp55.starter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class ChoosePlaneScreen extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
	// all of the GraphicsProgram calls
	private GButton enterGame;
	private GImage choosePlane;
	private GButton menuReturn;
	private GButton speedPlane;
	private GButton tankPlane;
	private GButton balancedPlane;
	private ArrayList<_ShipType> shipList = new ArrayList<_ShipType>(0);
	private _ShipType player1;
	private _ShipType player2;
	private GLabel noSelect;

	public ChoosePlaneScreen(MainApplication app) {
		this.program = app;
		choosePlane = new GImage("media/Stats for airplanes (1).jpg", 0, 0);
		choosePlane.setSize(1550, 800);
		speedPlane = new GButton("SELECT SPEED_PLANE", 1150, 600, 50, 50);
		tankPlane = new GButton("SELECT TANK_PLANE", 700, 600, 50, 50);
		balancedPlane = new GButton("SELECT BALANCED PLANE", 200, 600, 50, 50);
		enterGame = new GButton("Enter Game", 840, 700, 210, 50);
		menuReturn = new GButton("Return", 350, 700, 210, 50);
		menuReturn.setColor(Color.GREEN);
		menuReturn.setFillColor(Color.BLACK);
		enterGame.setColor(Color.GREEN);
		enterGame.setFillColor(Color.BLACK);
		speedPlane.setColor(Color.GREEN);
		speedPlane.setFillColor(Color.BLACK);
		tankPlane.setColor(Color.GREEN);
		tankPlane.setFillColor(Color.BLACK);
		balancedPlane.setColor(Color.GREEN);
		balancedPlane.setFillColor(Color.BLACK);

		// plane button selector
	}

	@Override
	public void showContents() {
		program.add(choosePlane);
		program.add(speedPlane);
		program.add(balancedPlane);
		program.add(tankPlane);
		program.add(enterGame);
		program.add(menuReturn);
	}

	@Override
	public void hideContents() {
		program.remove(speedPlane);
		program.remove(balancedPlane);
		program.remove(tankPlane);
		program.remove(choosePlane);
		program.remove(enterGame);
		program.remove(menuReturn);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		player1 = null;
		player2 = null;
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == enterGame) {
			program.playButtonSound();
			program.switchToLevel();
		} else if (obj == menuReturn) {
			program.playButtonSound();
			program.switchToMenu();
		}

		if (shipList.size() > 2) {
			noSelect = new GLabel("You can't select more ships!!!", 500, 500);
			noSelect.setColor(Color.white);
			
			return;
		} else if (obj == speedPlane) {
			program.playButtonSound();
			if (shipList.size() == 0) {
				setPlayer1(_ShipType.SHIP_SPEED);
				shipList.add(player1);
				System.out.println("player 1 is " + player1);
			} else if (shipList.size() == 1) {
				setPlayer2(_ShipType.SHIP_SPEED);
				shipList.add(player2);
				System.out.println("player 2 is " + player2);
			}

		} else if (obj == tankPlane) {
			program.playButtonSound();
			if (shipList.size() == 0) {
				setPlayer1(_ShipType.SHIP_TANK);
				shipList.add(player1);
				System.out.println("player 1 is " + player1);
			} else if (shipList.size() == 1) {
				setPlayer2(_ShipType.SHIP_TANK);
				shipList.add(player2);
				System.out.println("player 2 is " + player2);
			}

		} else if (obj == balancedPlane) {
			program.playButtonSound();
			if (shipList.size() == 0) {
				setPlayer1(_ShipType.SHIP_BALANCED);
				shipList.add(player1);
				System.out.println("player 1 is " + player1);
			} else if (shipList.size() == 1) {
				setPlayer2(_ShipType.SHIP_BALANCED);
				shipList.add(player2);
				System.out.println("player 2 is " + player2);
			}
		}

		System.out.println("The array contains: " + shipList);
	}

	public void setPlayer1(_ShipType type) {
		player1 = type;
	}

	public void setPlayer2(_ShipType type) {
		player2 = type;
	}

	public _ShipType getPlayer1() {
		player1 = shipList.get(0);
		System.out.println("player 1 is " + player1);
		return player1;
	}

	public _ShipType getPlayer2() {
		player2 = shipList.get(1);
		System.out.println("player 2 is " + player2);
		return player2;
	}

//	if (obj == speedPlane) {
//	program.playButtonSound();
////	System.out.println("player 1 is the speed ship");
//	if (shipList.get(0) != null) {
//		player1 = _ShipType.SHIP_SPEED;
//		shipList.add(_ShipType.SHIP_SPEED);
//	} else if (shipList.get(1) != null) {
//		player2 = _ShipType.SHIP_SPEED;
//		shipList.add(_ShipType.SHIP_SPEED);
//	}
//} else if (obj == tankPlane) {
//	program.playButtonSound();
//	shipList.add(_ShipType.SHIP_TANK);
////	System.out.println("player is the tank ship");
//	player1 = _ShipType.SHIP_TANK;
//} else if (obj == balancedPlane) {
//	program.playButtonSound();
//	shipList.add(_ShipType.SHIP_BALANCED);
////	System.out.println("player 1 is the balanced ship");
//	player1 = _ShipType.SHIP_BALANCED;
//}
//System.out.println(shipList);
//getPlayer1();
//getPlayer2();
}
