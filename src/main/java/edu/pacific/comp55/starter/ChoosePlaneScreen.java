package edu.pacific.comp55.starter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import javafx.scene.layout.Border;

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

	public ChoosePlaneScreen(MainApplication app) {
		this.player1 = null;
		this.player2 = null;
		this.program = app;
		choosePlane = new GImage("media/Stats for airplanes (1).jpg", 0, 0);
		choosePlane.setSize(1550, 800);
		speedPlane = new GButton("SELECT SPEED SHIP", 1150, 600, 70, 50);
		tankPlane = new GButton("SELECT TANK SHIP", 700, 600, 70, 50);
		balancedPlane = new GButton("SELECT BALANCED SHIP", 200, 600, 70, 50);
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
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == enterGame && player1 != null && player2 != null) {
			program.setPlayerType(player1, player2);
			program.playButtonSound();
			program.switchToLevel();
		} else if (obj == menuReturn) {
			program.playButtonSound();
			program.switchToMenu();
		}

		if (obj == speedPlane) {
			program.playButtonSound();
			if (player1 == null) { 
				player1 = _ShipType.SHIP_SPEED;
			} else if (player2 == null) {
				player2 = _ShipType.SHIP_SPEED;
			}
		}	

		if (obj == balancedPlane) {
			program.playButtonSound();
			if (player1 == null) { 
				player1 = _ShipType.SHIP_BALANCED;
			} else if (player2 == null) {
				player2 = _ShipType.SHIP_BALANCED;
			}
		}
		
		if (obj == tankPlane) {
			program.playButtonSound();
			if (player1 == null) { 
				player1 = _ShipType.SHIP_TANK;
			} else if (player2 == null) {
				player2 = _ShipType.SHIP_TANK;
			}
		}
	}

	private void setPlayer1(_ShipType type) {
		player1 = type;
	}

	private void setPlayer2(_ShipType type) {
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

}
