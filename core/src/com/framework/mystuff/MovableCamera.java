package com.framework.mystuff;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class MovableCamera extends OrthographicCamera {

    public static float MoveSpeed = 5f, ZoomSpeed = 1f;
    public EntityBase followTarget = null;

    public void Move(float delta) {
        if(followTarget == null) {
            Vector2 move = new Vector2(0, 0);

            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                move.y += 1;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                move.x -= 1;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                move.y -= 1;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                move.x += 1;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
                if (this.zoom < 2f) {
                    this.zoom += delta * ZoomSpeed;
                }
            }
            if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
                if (this.zoom > 0.5f) {
                    this.zoom -= delta * ZoomSpeed;
                }
            }
            move = move.nor();
            move = move.scl(MoveSpeed);
            this.position.add(new Vector3(move, 0));
        }
        else {
            this.position.set(followTarget.getPosition(), 0);
        }
    }


}
