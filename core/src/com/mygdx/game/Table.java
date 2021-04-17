package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

public class Table implements Screen {
    private ScreenManager manager;
    private ArrayList<Float> ans = new ArrayList<>();
    private int a_shtam;
    private int b_shtam;
    private int c_shtam;
    private float quarantine;

    public Table(ScreenManager manager) {
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
            manager.shapeRenderer.rectLine(40, 600, 940, 600, 2);
            manager.shapeRenderer.rectLine(40, 200, 940, 200, 2);
            manager.shapeRenderer.rectLine(40, 200, 40, 600, 2);
            manager.shapeRenderer.rectLine(940, 200, 940, 600, 2);

            manager.shapeRenderer.rectLine(40, 500, 940, 500, 2);
            manager.shapeRenderer.rectLine(40, 400, 940, 400, 2);
            manager.shapeRenderer.rectLine(40, 300, 940, 300, 2);
            manager.shapeRenderer.rectLine(265, 200,265, 600, 2);
            manager.shapeRenderer.rectLine(490, 200,490, 600, 2);
            manager.shapeRenderer.rectLine(715, 200,715, 600, 2);

        manager.shapeRenderer.end();
        manager.batch.begin();

        manager.font.setColor(1,1,1,1);
        manager.font.draw(manager.batch, "Enter strain a     (now " + a_shtam + " )", 40, 950);
        manager.font.draw(manager.batch, "Enter strain b     (now " + b_shtam + " )", 40, 900);
        manager.font.draw(manager.batch, "Enter strain c     (now " + c_shtam + " )", 40, 850);
        manager.font.draw(manager.batch, "Quarantine % (" + quarantine +")", 40, 750);

        manager.font.draw(manager.batch, "Quarantine 0.6", 45, 550);
        manager.font.draw(manager.batch, "Beta-Nova 1.9" , 270, 550);
        manager.font.draw(manager.batch, "Micer 0.6" , 495, 550);
        manager.font.setColor(1,1,0,1);
        manager.font.draw(manager.batch,  "Cost 198414$" , 720, 550);
        manager.font.setColor(1,1,1,1);

        manager.font.draw(manager.batch, "Quarantine 0.6", 45, 450);
        manager.font.draw(manager.batch, "Beta-Nova 0" , 270, 450);
        manager.font.draw(manager.batch, "Micer 1.9" , 495, 450);
        manager.font.setColor(1,1,0,1);
        manager.font.draw(manager.batch,  "Cost 362918$" , 720, 450);
        manager.font.setColor(1,1,1,1);

        manager.font.draw(manager.batch, "Quarantine 0.85", 45, 350);
        manager.font.draw(manager.batch, "Beta-Nova 1.4" , 270, 350);
        manager.font.draw(manager.batch, "Micer 0" , 495, 350);
        manager.font.setColor(1,1,0,1);
        manager.font.draw(manager.batch,  "Cost 19167$" , 720, 350);
        manager.font.setColor(1,1,1,1);

        manager.font.draw(manager.batch, "Quarantine 0.85", 45, 250);
        manager.font.draw(manager.batch, "Beta-Nova 0" , 270, 250);
        manager.font.draw(manager.batch, "Micer 0.8" , 495, 250);
        manager.font.setColor(1,1,0,1);
        manager.font.draw(manager.batch,  "Cost 67857$" , 720, 250);
        manager.font.setColor(1,1,1,1);

        manager.font.draw(manager.batch,  "*Defeating illness in 10 weeks variants" , 40, 150);
        if(ans.size() > 0 && ans.get(0) != 999999999) {
            manager.font.draw(manager.batch, "Optimal price is " + ans.get(0), 600, 750);
            manager.font.draw(manager.batch, "Optimal Beta-Nova is " + ans.get(1), 600, 700);
            manager.font.draw(manager.batch, "Optimal Micer is " + ans.get(2), 600, 650);
        }



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
        if(Gdx.input.getX() >= 700 && Gdx.input.getX() <= 750 && 1000 - Gdx.input.getY() >= 800 && 1000 - Gdx.input.getY() <= 850) {
            manager.font.setColor(0, 1, 1, 1);
            manager.font.draw(manager.batch, "Simulate", 700, 850);
            if(Gdx.input.isTouched()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                 ans = tests(a_shtam, b_shtam, c_shtam, quarantine);

            }
        }else{
            manager.font.setColor(0, 0, 1, 1);
            manager.font.draw(manager.batch, "Simulate", 700, 850);
        }
        if(Gdx.input.getX() >= 500 && Gdx.input.getX() <= 550 && 1000 - Gdx.input.getY() >= 700 && 1000 - Gdx.input.getY() <= 750) {
            manager.font.setColor(0, 1, 1, 1);
            manager.font.draw(manager.batch, "enter", 500, 750);
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
                           quarantine = new_par;
                        }
                    }

                    @Override
                    public void canceled()
                    {
                    }
                };

                Gdx.input.getTextInput(textListener, "Quarantine a: ", "0.7", "");

            }
        }else{
            manager.font.setColor(0, 0, 1, 1);
            manager.font.draw(manager.batch, "enter", 500, 750);
        }

        if(Gdx.input.getX() >= 750 && Gdx.input.getX() <= 980 && Gdx.input.getY() >= 0 && 1000 - Gdx.input.getY() <= 50) {
            manager.font.setColor(0, 1, 1, 1);
            manager.font.getData().setScale(2);
            manager.font.draw(manager.batch, "Tentative forecast", 750, 40);
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
            manager.font.draw(manager.batch, "Tentative forecast", 750, 40);
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
    public ArrayList<Float> tests(int ill_a, int ill_b, int ill_c, float quarantine1) {

        float quarantine = quarantine1;
        float beta;
        float micer;
        int h = 0;
        int h1 = 0;
        int h2 = 0;
        ArrayList<Float> ans = new ArrayList<>();
        int minPrice =999999999;
        float finalBeta = 0;
        float finalMicer = 0;
        for(int i =0; i < 20; ++i) {

            beta = i/10f;
            for (int m = 0; m < 20; ++m) {
                int a_shtam_draw = ill_a;
                int b_shtam_draw = ill_b;
                int c_shtam_draw = ill_c;

                micer = m/10f;
                int price = 0;
                for (int q = 1; q <= 10; ++q) {
                    /** a-shtam graph*/
                    if (h == 0 && i == 1) {
                        price += (float)a_shtam_draw*3*beta*(1-quarantine);
                        a_shtam_draw = (int) (a_shtam_draw * (2 - beta) * (1 - quarantine) + (float)a_shtam_draw * quarantine / 2);
                        ++h;
                    } else if (h == 0) {
                        price += (float)a_shtam_draw*3*beta*(1-quarantine);
                        a_shtam_draw = (int) (a_shtam_draw * (2 - beta) * (1 - quarantine) + (float)a_shtam_draw * quarantine / 2);
                        ++h;
                    } else if (h == 1) {
                        price += (float)a_shtam_draw*10*micer*(1-quarantine);
                        a_shtam_draw = (int) (a_shtam_draw * (2 - micer) * (1 - quarantine) + (float)a_shtam_draw * quarantine / 2);
                        ++h;
                    } else {
                        price += (float)a_shtam_draw*10*micer*(1-quarantine);
                        a_shtam_draw = (int) (a_shtam_draw * (2 - micer) * (1 - quarantine) + (float)a_shtam_draw * quarantine / 2);
                        h = 0;
                    }

                    /** b-shtam graph*/
                    if (h1 == 0 && i == 1) {
                        price += (float)b_shtam_draw*10*micer*(1-quarantine);
                        b_shtam_draw = (int) (b_shtam_draw * (2 - micer) * (1 - quarantine) + (float)b_shtam_draw * quarantine / 2);
                        ++h1;
                    } else if (h1 == 0) {
                        price += (float)b_shtam_draw*10*micer*(1-quarantine);
                        b_shtam_draw = (int) (b_shtam_draw * (2 - micer) * (1 - quarantine) + (float)b_shtam_draw * quarantine / 2);
                        ++h1;
                    } else if (h1 == 1) {
                        price += (float)b_shtam_draw*10*micer*(1-quarantine);
                        b_shtam_draw = (int) (b_shtam_draw * (2 - micer) * (1 - quarantine) + (float)b_shtam_draw * quarantine / 2);
                        ++h1;
                    } else {
                        price += (float)b_shtam_draw*3*beta*(1-quarantine);
                        b_shtam_draw = (int) (b_shtam_draw * (2 - beta) * (1 - quarantine) + (float)b_shtam_draw * quarantine / 2);
                        h1 = 0;
                    }

                    /** c-shtam graph*/
                    if (h2 == 0 && i == 1) {
                        price += (float)c_shtam_draw*10*micer*(1-quarantine);
                        c_shtam_draw = (int) (c_shtam_draw * (2 - micer) * (1 - quarantine) + (float)c_shtam_draw * quarantine / 2);
                        ++h2;
                    } else if (h2 == 0) {
                        price += (float)c_shtam_draw*10*micer*(1-quarantine);
                        c_shtam_draw = (int) (c_shtam_draw * (2 - micer) * (1 - quarantine) +(float) c_shtam_draw * quarantine / 2);
                        ++h2;
                    } else if (h2 == 1) {
                        price += (float)c_shtam_draw*3*beta*(1-quarantine);
                        c_shtam_draw = (int) (c_shtam_draw * (2 - beta) * (1 - quarantine) + (float)c_shtam_draw * quarantine / 2);
                        ++h2;
                    } else {
                        price += (float)c_shtam_draw*10*micer*(1-quarantine);
                        c_shtam_draw = (int) (c_shtam_draw * (2 - micer) * (1 - quarantine) +(float) c_shtam_draw * quarantine / 2);
                        h2 = 0;
                    }
                    System.out.println(a_shtam_draw + " " + b_shtam_draw + " " + c_shtam_draw + " "+ i + " "+ m+ " " + price);
                    if(a_shtam_draw < 150 && b_shtam_draw < 150 && c_shtam_draw < 150 && minPrice > price){
                        minPrice = price;
                        finalBeta = beta;
                        finalMicer = micer;
                    }
                }

            }

        }
        ans.add((float) minPrice);
        ans.add(finalBeta);
        ans.add(finalMicer);
        return ans;
    }
}
