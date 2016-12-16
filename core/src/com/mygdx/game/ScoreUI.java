package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class ScoreUI {
	private ShapeRenderer renderer;
	private HpBar hpBar;
	private PauseButton pauseButton;
	private float x;
	private float y;
	private float width;
	private float height;
	private float centerX;
	private float centerY;

	private boolean debugMode = true;

	public ScoreUI(float x, float y, float width, float height){
		renderer = new ShapeRenderer();
		hpBar = new HpBar();
		pauseButton = new PauseButton();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.centerX = this.x + 80;
		this.centerY = this.y + (this.height/2);
	}

	public void drawShapeRenderer(){
		renderer.begin(ShapeType.Line);
		renderer.setColor(1f, 1f, 1f, 1);
		renderer.line(x, centerY, x + width, centerY);
		renderer.line(centerX, y + height/4, centerX, y + (height/4)*3);
		renderer.circle(centerX, centerY, 10f);
		renderer.end();

		hpBar.draw(renderer);
		pauseButton.draw(renderer);

		if(debugMode){
			renderer.begin(ShapeType.Line);
			renderer.setColor(0,1,0,1);
			renderer.rect(1, 0, Setting.LOGICAL_WIDTH-1, Setting.LOGICAL_HEIGHT-1);
			renderer.end();
		}

	}

	public void setDebugMode(){
		debugMode = !debugMode;
	}

	public ShapeRenderer getShapeRenderer(){
		drawShapeRenderer();
		return this.renderer;
	}

	public float getCenterX(){
		return centerX;
	}

	public float getCenterY(){
		return centerY;
	}

	public HpBar getHpBar(){
		return hpBar;
	}
}
