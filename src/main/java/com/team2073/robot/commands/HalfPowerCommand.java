package com.team2073.robot.commands;

import com.team2073.common.command.AbstractLoggingCommand;
import com.team2073.robot.ApplicationContext;
import com.team2073.robot.subsystems.SimpleSubsystem;

public class HalfPowerCommand extends AbstractLoggingCommand {
    private ApplicationContext appCTX = ApplicationContext.getInstance();
    private SimpleSubsystem simpleSubsystem = appCTX.getSimpleSubsystem();

    /**
     * Runs while command is called
     */
    @Override
    protected void executeDelegate() {
        simpleSubsystem.setCurrentState(SimpleSubsystem.SimpleSubsystemState.HALF_POWER);
    }

    /**
     * Runs when command is over
     */
    @Override
    protected void endDelegate() {
        simpleSubsystem.setCurrentState(SimpleSubsystem.SimpleSubsystemState.AXIS);
    }

    @Override
    protected boolean isFinishedDelegate() {
        return false;
    }
}
