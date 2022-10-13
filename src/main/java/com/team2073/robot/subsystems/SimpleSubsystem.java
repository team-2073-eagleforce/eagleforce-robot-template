package com.team2073.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.team2073.common.periodic.AsyncPeriodicRunnable;
import com.team2073.robot.ApplicationContext;
import edu.wpi.first.wpilibj.Joystick;

public class SimpleSubsystem implements AsyncPeriodicRunnable {

    ApplicationContext appCTX = ApplicationContext.getInstance();
    private SimpleSubsystemState currentState = SimpleSubsystemState.AXIS;
    private CANSparkMax motor = appCTX.getMotor();
    private Joystick controller = appCTX.getController();
    private double output = 0;

    public SimpleSubsystem() {
        autoRegisterWithPeriodicRunner(); //adds onPeriodicAsync to periodic loops
    }

    /**
     * Loops at periodic rate set in Main method
     */
    @Override
    public void onPeriodicAsync() {
        switch(currentState) {
            case STOP:
                output = 0; //Sets 0 volts
                break;
            case HALF_POWER:
                output = 0.5; //Sets 6 volts
                break;
            case AXIS:
                output = getAxisOutput(); //Sets output to joystick
                break;
        }
        motor.setVoltage(output * 12); //Sets voltage of NEO in volts 0-12
    }


    /**
     * Usable by other classes to set the state of the subsystem\
     * Takes in SimpleSubsystemStates
     * @param currentState
     */
    public void setCurrentState(SimpleSubsystemState currentState) {
        this.currentState = currentState;
    }

    /**
     * Returns lefts joysticks output and inverts it
     * @return
     */
    private double getAxisOutput() { return -controller.getRawAxis(1); }

    /**
     * Enum to store the states
     */
    public enum SimpleSubsystemState {
        STOP,
        HALF_POWER,
        AXIS;
    }

}
