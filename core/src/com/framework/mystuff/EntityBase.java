package com.framework.mystuff;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class EntityBase {

    protected Sprite spr;

    public void OnCreate() {

    }

    public void OnUpdate(float delta) {

    }

    public void OnRender(SpriteBatch batch) {
        spr.draw(batch);
    }

    public void OnDestroy() {
        spr = null;
    }

    public Vector2 getPosition() {
        return new Vector2(this.spr.getOriginX(), this.spr.getOriginY());
    }

    protected void Move(Vector2 move) {
        this.spr.setPosition(this.spr.getX() + move.x, this.spr.getY() + move.y);
    }
}
