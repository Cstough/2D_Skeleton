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

import java.util.ArrayList;

public class GameScreen implements Screen {

    Driver game;
    SpriteBatch batch;
    Viewport viewport;
    MovableCamera camera;
    ArrayList<EntityBase> entities;

    public GameScreen(Driver game) {
        this.entities = new ArrayList<EntityBase>();
        this.game = game;
        this.batch = game.batch;
        this.camera = new MovableCamera();
        this.viewport = new ExtendViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);
        this.viewport.apply();
        this.camera.position.set(0, 0,0);
        Gdx.graphics.setTitle("GameScreen!");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Update(delta);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        for(EntityBase entity : entities) {
            entity.OnRender(batch);
        }

        batch.end();
    }

    private void Update(float delta) {

        for(EntityBase entity : entities) {
            entity.OnUpdate(delta);
        }

        camera.Move(delta);
    }

    @Override
    public void resize(int width, int height) {
        this.camera.viewportWidth = width;
        this.camera.viewportHeight = height;
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
        for(EntityBase entity : entities) {
            entity.OnDestroy();
        }
    }

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~Entity~Management~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    protected void AddEntity(EntityBase e) {
        if(!this.entities.contains(e)) {
            this.entities.add(e);
            e.OnCreate();
        }
    }

    protected void RemoveEntity(EntityBase e) {
        if(this.entities.contains(e)) {
            e.OnDestroy();
            this.entities.remove(e);
        }
    }
}
