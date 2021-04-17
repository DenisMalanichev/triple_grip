package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Shtams implements Screen {
    private ScreenManager manager;
    private int a_shtam = 10000;
    private int b_shtam = 1000;
    private int c_shtam = 100;
    private float vaccineM = 0;
    private float vaccineB = 0;
    private float isol_percentA = 0;
    private float isol_percentB = 0;
    private float isol_percentC = 0;
    private float[] a_shtam_arr = new float[10];

    public Shtams(ScreenManager manager) {
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
        manager.shapeRenderer.setColor(new Color(0.5f,0.5f,0.5f,1));
        manager.shapeRenderer.rectLine(40, Gdx.graphics.getHeight()/2- 200, 960, Gdx.graphics.getHeight()/2 - 200, 2);
        manager.shapeRenderer.rectLine(40, Gdx.graphics.getHeight()/2 -200, 40, Gdx.graphics.getHeight() - 350, 2);


        for(int i =1; i < 11; ++i) {
            manager.shapeRenderer.setColor(new Color(0.3f, 0.3f, 0.3f, 1));
            manager.shapeRenderer.rectLine(40, Gdx.graphics.getHeight() / 2 - 200 + i * 35, 960, Gdx.graphics.getHeight() / 2 - 200 + i * 35, 2);
        }
        manager.shapeRenderer.setColor(1, 0, 0, 1);
        manager.shapeRenderer.rectLine(600, 930, 620, 930, 2);
        manager.shapeRenderer.setColor(1, 0.5f, 0, 1);
        manager.shapeRenderer.rectLine(600, 880, 620, 880, 2);
        manager.shapeRenderer.setColor(1, 1, 0, 1);
        manager.shapeRenderer.rectLine(600, 830, 620, 830, 2);

        int h = 0;
        int h1 = 0;
        int h2 = 0;
        int a_shtam_draw = a_shtam;
        int b_shtam_draw = b_shtam;
        int c_shtam_draw = c_shtam;
        for(int i =1; i<10;++i){
            float x1;
            float x2;
            float x11;
            float x21;
            float x12;
            float x22;



            /** a-shtam graph*/
            if(h ==0 && i == 1){
                manager.shapeRenderer.setColor(1, 0, 0, 1);
                x1 = (float) (a_shtam_draw*0.0001*57.5f + 40);
                a_shtam_draw = (int) (a_shtam_draw*(2-vaccineB)*(1-isol_percentA) + a_shtam_draw*isol_percentA/2);
                x2 = (float) (a_shtam_draw*0.0001*57.5f + 40);
                manager.shapeRenderer.rectLine(x1, i*35 + Gdx.graphics.getHeight()/2-200, x2, (i+1)*35 + Gdx.graphics.getHeight()/2-200, 2);
                ++h;
            }else if(h == 0){
                manager.shapeRenderer.setColor(1, 0, 0, 1);
                x1 = (float) (a_shtam_draw*0.0001*57.5f + 40);
                a_shtam_draw = (int) (a_shtam_draw*(2-vaccineB)*(1-isol_percentA) + a_shtam_draw*isol_percentA/2);
                x2 = (float) (a_shtam_draw*0.0001*57.5f + 40);
                manager.shapeRenderer.rectLine(x1, i*35 + Gdx.graphics.getHeight()/2-200, x2, (i+1)*35 + Gdx.graphics.getHeight()/2-200, 2);
                ++h;
            } else if(h == 1){
                manager.shapeRenderer.setColor(1, 0.5f, 0, 1);
                x1 = (float) (a_shtam_draw*0.0001*57.5f + 40);
                a_shtam_draw = (int) (a_shtam_draw*(2-vaccineM)*(1-isol_percentB) + a_shtam_draw*isol_percentB/2);
                x2 = (float) (a_shtam_draw*0.0001*57.5f + 40);
                manager.shapeRenderer.rectLine(x1, i*35 + Gdx.graphics.getHeight()/2-200, x2, (i+1)*35 + Gdx.graphics.getHeight()/2-200, 2);
                ++h;
            }else{
                manager.shapeRenderer.setColor(1, 1, 0, 1);
                x1 = (float) (a_shtam_draw*0.0001*57.5f + 40);
                a_shtam_draw = (int) (a_shtam_draw*(2-vaccineM)*(1-isol_percentC) + a_shtam_draw*isol_percentC/2);
                x2 = (float) (a_shtam_draw*0.0001*57.5f + 40);
                manager.shapeRenderer.rectLine(x1, i*35 + Gdx.graphics.getHeight()/2-200, x2, (i+1)*35 + Gdx.graphics.getHeight()/2-200, 2);
                h = 0;
            }

            /** b-shtam graph*/
            if(h1 ==0 && i == 1){
                manager.shapeRenderer.setColor(1, 0.5f, 0, 1);
                x11 = (float) (b_shtam_draw*0.0001*57.5f + 40);
                b_shtam_draw = (int) (b_shtam_draw*(2-vaccineM)*(1-isol_percentB) + b_shtam_draw*isol_percentB/2);
                x21 = (float) (b_shtam_draw*0.0001*57.5f + 40);
                manager.shapeRenderer.rectLine(x11, i*35 + Gdx.graphics.getHeight()/2-200, x21, (i+1)*35 + Gdx.graphics.getHeight()/2-200, 2);
                ++h1;
            }else if(h1 == 0){
                manager.shapeRenderer.setColor(1, 0.5f, 0, 1);
                x11 = (float) (b_shtam_draw*0.0001*57.5f + 40);
                b_shtam_draw = (int) (b_shtam_draw*(2-vaccineM)*(1-isol_percentB) + b_shtam_draw*isol_percentB/2);
                x21 = (float) (b_shtam_draw*0.0001*57.5f + 40);
                manager.shapeRenderer.rectLine(x11, i*35 + Gdx.graphics.getHeight()/2-200, x21, (i+1)*35 + Gdx.graphics.getHeight()/2-200, 2);
                ++h1;
            } else if(h1 == 1){
                manager.shapeRenderer.setColor(1, 1, 0, 1);
                x11 = (float) (b_shtam_draw*0.0001*57.5f + 40);
                b_shtam_draw = (int) (b_shtam_draw*(2-vaccineM)*(1-isol_percentC) + b_shtam_draw*isol_percentC/2);
                x21 = (float) (b_shtam_draw*0.0001*57.5f + 40);
                manager.shapeRenderer.rectLine(x11, i*35 + Gdx.graphics.getHeight()/2-200, x21, (i+1)*35 + Gdx.graphics.getHeight()/2-200, 2);
                ++h1;
            }else{
                manager.shapeRenderer.setColor(1, 0, 0, 1);
                x11 = (float) (b_shtam_draw*0.0001*57.5f + 40);
                b_shtam_draw = (int) (b_shtam_draw*(2-vaccineB)*(1-isol_percentA) + b_shtam_draw*isol_percentA/2);
                x21 = (float) (b_shtam_draw*0.0001*57.5f + 40);
                manager.shapeRenderer.rectLine(x11, i*35 + Gdx.graphics.getHeight()/2-200, x21, (i+1)*35 + Gdx.graphics.getHeight()/2-200, 2);
                h1 = 0;
            }

            /** c-shtam graph*/
            if(h2 ==0 && i == 1){
                manager.shapeRenderer.setColor(1, 1, 0, 1);
                x12 = (float) (c_shtam_draw*0.0001*57.5f + 40);
                c_shtam_draw = (int) (c_shtam_draw*(2-vaccineM)*(1-isol_percentC) + c_shtam_draw*isol_percentC/2);
                x22 = (float) (c_shtam_draw*0.0001*57.5f + 40);
                manager.shapeRenderer.rectLine(x12, i*35 + Gdx.graphics.getHeight()/2-200, x22, (i+1)*35 + Gdx.graphics.getHeight()/2-200, 2);
                ++h2;
            }else if(h2 == 0){
                manager.shapeRenderer.setColor(1, 1, 0, 1);
                x12 = (float) (c_shtam_draw*0.0001*57.5f + 40);
                c_shtam_draw = (int) (c_shtam_draw*(2-vaccineM)*(1-isol_percentC) + c_shtam_draw*isol_percentC/2);
                x22 = (float) (c_shtam_draw*0.0001*57.5f + 40);
                manager.shapeRenderer.rectLine(x12, i*35 + Gdx.graphics.getHeight()/2-200, x22, (i+1)*35 + Gdx.graphics.getHeight()/2-200, 2);
                ++h2;
            } else if(h2 == 1){
                manager.shapeRenderer.setColor(1, 0, 0, 1);
                x12 = (float) (c_shtam_draw*0.0001*57.5f + 40);
                c_shtam_draw = (int) (c_shtam_draw*(2-vaccineB)*(1-isol_percentA) + c_shtam_draw*isol_percentA/2);
                x22 = (float) (c_shtam_draw*0.0001*57.5f + 40);
                manager.shapeRenderer.rectLine(x12, i*35 + Gdx.graphics.getHeight()/2-200, x22, (i+1)*35 + Gdx.graphics.getHeight()/2-200, 2);
                ++h2;
            }else{
                manager.shapeRenderer.setColor(1, 0.5f, 0, 1);
                x12 = (float) (c_shtam_draw*0.0001*57.5f + 40);
                c_shtam_draw = (int) (c_shtam_draw*(2-vaccineM)*(1-isol_percentB) + c_shtam_draw*isol_percentB/2);
                x22 = (float) (c_shtam_draw*0.0001*57.5f + 40);
                manager.shapeRenderer.rectLine(x12, i*35 + Gdx.graphics.getHeight()/2-200, x22, (i+1)*35 + Gdx.graphics.getHeight()/2-200, 2);
                h2 = 0;
            }
        }

        manager.shapeRenderer.end();

        manager.batch.begin();
        manager.font.setColor(new Color(1,1,1,1));
        manager.font.getData().setScale(1.5f);
        manager.font.draw(manager.batch, "Enter strain a     (now " + a_shtam + " )", 40, 950);
        manager.font.draw(manager.batch, "Enter strain b     (now " + b_shtam + " )", 40, 900);
        manager.font.draw(manager.batch, "Enter strain c     (now " + c_shtam + " )", 40, 850);
        manager.font.draw(manager.batch, "Micer (now " + vaccineM + " )", 40, 800);
        manager.font.draw(manager.batch, "Beta-Nova (now " + vaccineB + " )", 350, 800);
        manager.font.draw(manager.batch, "(Concentration from 0 to 1.9)", 720, 800);
        manager.font.draw(manager.batch, "A strain % (now " + isol_percentA + ")", 40, 750);
        manager.font.draw(manager.batch, "B strain % (now " + isol_percentB + ")", 340, 750);
        manager.font.draw(manager.batch, "C strain % (now " + isol_percentC + ")", 640, 750);



        for(int i =0;i<=16;++i){
            manager.font.setColor(new Color(1,1,1,1));
            manager.font.getData().setScale(0.85f);
            manager.font.draw(manager.batch, ""+i*10000, 40 + i*57.5f,Gdx.graphics.getHeight()/2 - 220);
            if(i > 0 && i <= 10) {
                manager.font.draw(manager.batch, "" + i, 20, Gdx.graphics.getHeight()/2 -200  + i * 35);
            }
        } manager.font.getData().setScale(2);


        if(Gdx.input.getX() >= 500 && Gdx.input.getX() <= 550 && 1000 - Gdx.input.getY() >= 900 && 1000 - Gdx.input.getY() <= 950) {
            manager.font.setColor(0, 1, 1, 1);
            manager.font.draw(manager.batch, "enter", 500, 950);
            if(Gdx.input.isTouched()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final Input.TextInputListener textListener = new Input.TextInputListener()
                {
                    @Override
                    public void input(String input)
                    {
                        a_shtam = Integer.parseInt(input);
                    }

                    @Override
                    public void canceled()
                    {
                    }
                };

                Gdx.input.getTextInput(textListener, "Strain a: ", "1000", "");

            }
        }else{
            manager.font.setColor(0, 0, 1, 1);
            manager.font.draw(manager.batch, "enter", 500, 950);
        }
        if(Gdx.input.getX() >= 500 && Gdx.input.getX() <= 550 && 1000 - Gdx.input.getY() >= 850 && 1000 - Gdx.input.getY() <= 900) {
            manager.font.setColor(0, 1, 1, 1);
            manager.font.draw(manager.batch, "enter", 500, 900);
            if(Gdx.input.isTouched()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final Input.TextInputListener textListener = new Input.TextInputListener()
                {
                    @Override
                    public void input(String input)
                    {
                        b_shtam = Integer.parseInt(input);
                    }

                    @Override
                    public void canceled()
                    {
                    }
                };

                Gdx.input.getTextInput(textListener, "Strain b: ", "1000", "");

            }
        }else{
            manager.font.setColor(0, 0, 1, 1);
            manager.font.draw(manager.batch, "enter", 500, 900);
        }
        if(Gdx.input.getX() >= 500 && Gdx.input.getX() <= 550 && 1000 - Gdx.input.getY() >= 800 && 1000 - Gdx.input.getY() <= 850) {
            manager.font.setColor(0, 1, 1, 1);
            manager.font.draw(manager.batch, "enter", 500, 850);
            if(Gdx.input.isTouched()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final Input.TextInputListener textListener = new Input.TextInputListener()
                {
                    @Override
                    public void input(String input)
                    {
                        c_shtam = Integer.parseInt(input);
                    }

                    @Override
                    public void canceled()
                    {
                    }
                };

                Gdx.input.getTextInput(textListener, "Strain c: ", "1000", "");

            }
        }else{
            manager.font.setColor(0, 0, 1, 1);
            manager.font.draw(manager.batch, "enter", 500, 850);
        }
        if(Gdx.input.getX() >= 10 && Gdx.input.getX() <= 240 && Gdx.input.getY() >= 0 && 1000 - Gdx.input.getY() <= 50) {
            manager.font.setColor(0, 1, 1, 1);
            manager.font.getData().setScale(2);
            manager.font.draw(manager.batch, "Tentative forecast", 10, 40);
            if(Gdx.input.isTouched()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                manager.setScreen(new Illness_chart(manager));
            }
        }else{
            manager.font.setColor(0, 0, 1, 1);
            manager.font.getData().setScale(2);
            manager.font.draw(manager.batch, "Tentative forecast", 10, 40);
        }

        if(Gdx.input.getX() >= 750 && Gdx.input.getX() <= 950 && Gdx.input.getY() >= 0 && 1000 - Gdx.input.getY() <= 50) {
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

        if(Gdx.input.getX() >= 230 && Gdx.input.getX() <= 280 && 1000 - Gdx.input.getY() >= 750 && 1000 - Gdx.input.getY() <= 800) {
            manager.font.setColor(0, 1, 1, 1);
            manager.font.draw(manager.batch, "enter", 230, 800);
            if(Gdx.input.isTouched()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final Input.TextInputListener textListener = new Input.TextInputListener()
                {
                    @Override
                    public void input(String input)
                    {
                        float new_par = Float.parseFloat(input);
                        if(new_par < 1.9 && new_par >= 0){
                            vaccineM = new_par;
                        }
                    }

                    @Override
                    public void canceled()
                    {
                    }
                };

                Gdx.input.getTextInput(textListener, "Micer: ", "0.7", "");

            }
        }else{
            manager.font.setColor(0, 0, 1, 1);
            manager.font.draw(manager.batch, "enter", 230, 800);
        }
        if(Gdx.input.getX() >= 600 && Gdx.input.getX() <= 650 && 1000 - Gdx.input.getY() >= 750 && 1000 - Gdx.input.getY() <= 800) {
            manager.font.setColor(0, 1, 1, 1);
            manager.font.draw(manager.batch, "enter", 600, 800);
            if(Gdx.input.isTouched()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final Input.TextInputListener textListener = new Input.TextInputListener()
                {
                    @Override
                    public void input(String input)
                    {
                        float new_par = Float.parseFloat(input);
                        if(new_par < 1.9 && new_par >= 0){
                            vaccineB = new_par;
                        }
                    }

                    @Override
                    public void canceled()
                    {
                    }
                };

                Gdx.input.getTextInput(textListener, "Beta-Nova: ", "0.7", "");

            }
        }else{
            manager.font.setColor(0, 0, 1, 1);
            manager.font.draw(manager.batch, "enter", 600, 800);
        }
        if(Gdx.input.getX() >= 850 && Gdx.input.getX() <= 920 && 1000 - Gdx.input.getY() >= 700 && 1000 - Gdx.input.getY() <= 750) {
            manager.font.setColor(0, 1, 1, 1);
            manager.font.draw(manager.batch, "enter", 850, 750);
            if(Gdx.input.isTouched()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final Input.TextInputListener textListener = new Input.TextInputListener()
                {
                    @Override
                    public void input(String input)
                    {
                        float new_par = Float.parseFloat(input);
                        if(new_par < 1.9 && new_par >= 0){
                            isol_percentC = new_par;
                        }
                    }

                    @Override
                    public void canceled()
                    {
                    }
                };

                Gdx.input.getTextInput(textListener, "Strain c: ", "0.7", "");

            }
        }else{
            manager.font.setColor(0, 0, 1, 1);
            manager.font.draw(manager.batch, "enter", 850, 750);
        }
        if(Gdx.input.getX() >= 560 && Gdx.input.getX() <= 620 && 1000 - Gdx.input.getY() >= 700 && 1000 - Gdx.input.getY() <= 750) {
            manager.font.setColor(0, 1, 1, 1);
            manager.font.draw(manager.batch, "enter", 560, 750);
            if(Gdx.input.isTouched()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final Input.TextInputListener textListener = new Input.TextInputListener()
                {
                    @Override
                    public void input(String input)
                    {
                        float new_par = Float.parseFloat(input);
                        if(new_par < 1.9 && new_par >= 0){
                            isol_percentB = new_par;
                        }
                    }

                    @Override
                    public void canceled()
                    {
                    }
                };

                Gdx.input.getTextInput(textListener, "Strain b: ", "0.7", "");

            }
        }else{
            manager.font.setColor(0, 0, 1, 1);
            manager.font.draw(manager.batch, "enter", 560, 750);
        }
        if(Gdx.input.getX() >= 260 && Gdx.input.getX() <= 320 && 1000 - Gdx.input.getY() >= 700 && 1000 - Gdx.input.getY() <= 750) {
            manager.font.setColor(0, 1, 1, 1);
            manager.font.draw(manager.batch, "enter", 260, 750);
            if(Gdx.input.isTouched()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final Input.TextInputListener textListener = new Input.TextInputListener()
                {
                    @Override
                    public void input(String input)
                    {
                        float new_par = Float.parseFloat(input);
                        if(new_par < 1.9 && new_par >= 0){
                            isol_percentA = new_par;
                        }
                    }

                    @Override
                    public void canceled()
                    {
                    }
                };

                Gdx.input.getTextInput(textListener, "Strain a: ", "0.7", "");

            }
        }else{
            manager.font.setColor(0, 0, 1, 1);
            manager.font.draw(manager.batch, "enter", 260, 750);
        }
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
