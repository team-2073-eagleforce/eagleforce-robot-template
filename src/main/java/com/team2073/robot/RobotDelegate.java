package com.team2073.robot;

import com.team2073.common.robot.AbstractRobotDelegate;

public class RobotDelegate extends AbstractRobotDelegate {

    private ApplicationContext appCTX = ApplicationContext.getInstance();

    private OperatorInterface oi = new OperatorInterface();

    public RobotDelegate(double period) {
        super(period);
    }

    @Override
    public void robotInit() {
        oi.init();
    }

    @Override
    public void robotPeriodic() { }

    @Override
    public void teleopInit() { }

    @Override
    public void autonomousInit() { }

    @Override
    public void autonomousPeriodic() { }

    @Override
    public void simulationInit() { }

    @Override
    public void simulationPeriodic() { }
}
