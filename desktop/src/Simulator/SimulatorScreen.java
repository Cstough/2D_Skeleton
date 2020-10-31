package Simulator;

import com.framework.mystuff.GameScreen;
import com.framework.mystuff.Driver;
import com.framework.mystuff.TestEntity;

public class SimulatorScreen extends GameScreen {
    public SimulatorScreen(Driver game) {
        super(game);
        AddEntity(new TestEntity());
    }
}
