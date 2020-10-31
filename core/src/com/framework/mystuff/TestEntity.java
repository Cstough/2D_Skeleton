package com.framework.mystuff;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import org.w3c.dom.Text;

public class TestEntity extends EntityBase{

    public TestEntity() {
        this.spr = new Sprite(new Texture(Gdx.files.internal("badlogic.jpg")), 256, 256);
    }

    @Override
    public void OnCreate() {

    }

    @Override
    public void OnUpdate(float delta) {
        this.Move(new Vector2(delta * 10f, delta * 10f));
    }

    @Override
    public void OnDestroy() {
        super.OnDestroy();
    }
}
