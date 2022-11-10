package edu.pacific.comp55.starter;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;
import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import acm.util.RandomGenerator;


public class _Powerups extends GraphicsProgram {
	private static final int MAX_HEALTH = 10;
	private RandomGenerator rgen;
	private double spawnX, spawnY;
	private Timer t;
	private boolean isActive;
	private GImage powerUp;
	
	private void powerUpSound(_PowerUpType p) {}
	
	private void setSpawn(double x, double y) {
		spawnX = x;
		spawnY = y;
	}
	
	public double getSpawnX(_Powerups p) {
		return p.spawnX;
	}
	
	private double getSpawnY(_Powerups p) {
		return p.spawnY;
	}
	
	private void updateShipSpeed(_BattleShip b) {
		b.updateSpeed(b.getSpeed() + 5);
	}
	
	private void updateShipBullets(_Bullet b) {}
	
	private void updateShipHealth(_BattleShip b) {
		if(b.getHealth() < MAX_HEALTH) {
			b.setHealth(b.getHealth() + 5);
		}
		else {
			b.setHealth(MAX_HEALTH);
		}
	}
		
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	}
	
}
