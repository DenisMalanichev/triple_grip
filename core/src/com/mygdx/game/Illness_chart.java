package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Illness_chart implements Screen {
	private ScreenManager manager;


	public Illness_chart(ScreenManager manager) {
		this.manager = manager;
	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.15f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		manager.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

		manager.shapeRenderer.rectLine(40, Gdx.graphics.getHeight()/2, 728, Gdx.graphics.getHeight()/2, 2);
		manager.shapeRenderer.rectLine(40, Gdx.graphics.getHeight()/2, 40, Gdx.graphics.getHeight() - 130, 2);

		manager.shapeRenderer.setColor(1, 0, 0, 1);
		manager.shapeRenderer.rectLine(200, 300, 220, 300, 2);
		manager.shapeRenderer.setColor(1, 0.5f, 0, 1);
		manager.shapeRenderer.rectLine(500, 300, 520, 300, 2);
		manager.shapeRenderer.setColor(1, 1, 0, 1);
		manager.shapeRenderer.rectLine(800, 300, 820, 300, 2);


		manager.shapeRenderer.setColor(0, 0.7f, 0, 1);
		int h = 0;
		for(int i =1; i < 5; ++i){
			float x1 = (float) (1000*Math.pow(2, i-1)*0.001f*43f + 40);
			float x2 = (float) (1000*Math.pow(2, i)*0.001f*43f + 40);
			if(h ==0){
				manager.shapeRenderer.setColor(1, 0, 0, 1);
				++h;
			}else if(h == 1){
				manager.shapeRenderer.setColor(1, 0.5f, 0, 1);
				++h;
			}else{
				manager.shapeRenderer.setColor(1, 1, 0, 1);
				h = 0;
			}
			manager.shapeRenderer.rectLine(x1, i*37 + Gdx.graphics.getHeight()/2, x2, (i+1)*37 + Gdx.graphics.getHeight()/2, 2);
		}
		manager.shapeRenderer.setColor(0.5f, 0.5f, 0.5f, 1);

		manager.shapeRenderer.end();

		manager.batch.begin();

		for(int i =0;i<=16;++i){
			manager.font.setColor(new Color(1,1,1,1));
			manager.font.getData().setScale(0.85f);
			manager.font.draw(manager.batch, ""+i*1000, 40 + i*43,Gdx.graphics.getHeight()/2 - 20);
			if(i > 0 && i <= 10) {
				manager.font.draw(manager.batch, "" + i, 20, Gdx.graphics.getHeight()/2  + i * 37);
			}
		}

		if(Gdx.input.getX() >= 0 && Gdx.input.getX() <= 150 && Gdx.input.getY() >= 0 && 1000 - Gdx.input.getY() <= 50) {
			manager.font.setColor(0, 1, 1, 1);
			manager.font.getData().setScale(2);
			manager.font.draw(manager.batch, "Illness chart", 10, 40);
			if(Gdx.input.isTouched()){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				manager.setScreen(new Shtams(manager));
			}
		}else{
			manager.font.setColor(0, 0, 1, 1);
			manager.font.getData().setScale(2);
			manager.font.draw(manager.batch, "Illness chart", 10, 40);
		}

		if(Gdx.input.getX() >= 750 && Gdx.input.getX() <= 980 && Gdx.input.getY() >= 0 && 1000 - Gdx.input.getY() <= 50) {
			manager.font.setColor(0, 1, 1, 1);
			manager.font.getData().setScale(2);
			manager.font.draw(manager.batch, "Treatment pricing", 750, 40);
			if(Gdx.input.isTouched()){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				manager.setScreen(new Table(manager));
			}
		}else{
			manager.font.setColor(0, 0, 1, 1);
			manager.font.getData().setScale(2);
			manager.font.draw(manager.batch, "Treatment pricing", 750, 40);
		}

		manager.font.setColor(1, 1, 1, 1);
		manager.font.draw(manager.batch,  "Disease progression starting with 1000 a-strain holders" , 140, 930);

		manager.font.getData().setScale(1.5f);
		manager.font.draw(manager.batch,  "A-strain wave" , 40, 310);
		manager.font.draw(manager.batch,  "B-strain wave" , 340, 310);
		manager.font.draw(manager.batch,  "C-strain wave" , 640, 310);


		manager.batch.end();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {

	}
}
