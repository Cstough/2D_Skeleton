package Simulator;

import com.framework.mystuff.Driver;

public class SimulatorDriver extends Driver {

    @Override
    public void create() {
        super.create();
        setScreen(new SimulatorScreen(this));
    }
}
