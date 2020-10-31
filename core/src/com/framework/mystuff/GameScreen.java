package com.framework.mystuff;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {

    Skeleton game;
    SpriteBatch batch;
    Viewport viewport;
    Camera camera;
    Sprite spr;

    public GameScreen(Skeleton game) {
        this.game = game;
        this.batch = game.batch;
        this.camera = new OrthographicCamera();
        this.viewport = new StretchViewport(800, 600, camera);
        this.viewport.apply();
        this.camera.position.set(0, 0, 0);
        spr = new Sprite(new Texture(Gdx.files.internal("badlogic.jpg")), 100, 100);
        Gdx.graphics.setTitle("GameScreen!");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Update(delta);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(spr.getTexture(), spr.getX(), spr.getY());
        batch.end();
    }

    private void Update(float delta) {

        Vector2 move = new Vector2(0, 0);

        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
            move.y+=1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            move.x-=1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)) {
            move.y-=1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            move.x+=1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.Q)) {
            if(((OrthographicCamera)camera).zoom < 2f) {
                ((OrthographicCamera)camera).zoom+=delta;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.Z)) {
            if(((OrthographicCamera)camera).zoom > 0.5f) {
                ((OrthographicCamera)camera).zoom-=delta;
            }
        }
        move = move.nor();
        move = move.scl(5.0f);
        camera.position.add(new Vector3(move, 0));
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
