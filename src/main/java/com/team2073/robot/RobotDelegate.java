package com.team2073.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.REVPhysicsSim;
import com.team2073.common.robot.AbstractRobotDelegate;
import com.team2073.robot.subsystems.SimpleSubsystem;
import edu.wpi.first.math.system.plant.DCMotor;

public class RobotDelegate extends AbstractRobotDelegate {

    private ApplicationContext appCTX = ApplicationContext.getInstance(); //Gets the Application Context object

    private CANSparkMax motor = appCTX.getMotor(); //Gets the CANSparkMax object
    private SimpleSubsystem simpleSubsystem; //Declare SimpleSubsystem type variable

    private OperatorInterface oi = new OperatorInterface(); //Makes new OperatorInterface object

    /**
     * The loop rate that the code will runn i.e. if you put 0.02 seconds the periodic methods
     * will loop every 20 miliseconds such as robotPeriodic, simulationPeriodic, teleopPeriodicAsync,
     * autonomousPeriodic, and onPeriodicAsync
     * @param period (seconds)
     */
    public RobotDelegate(double period) {
        super(period); //Passes the period to parent (AbstractRobotDelegate) constructor
    }

    /**
     * Runs once when robot is turned on
     */
    @Override
    public void robotInit() {
        oi.init();
        simpleSubsystem = new SimpleSubsystem();
    }

    /**
     * Loops while robot is on
     */
    @Override
    public void robotPeriodic() { }

    /**
     * Runs once when teleop mode is activated
     */
    @Override
    public void teleopInit() { }

    /**
     * Loops while teleop mode is activated
     */
    @Override
    public void teleopPeriodic() { }

    /**
     * Runs once when autonomous is activated
     */
    @Override
    public void autonomousInit() { }

    /**
     * Loops while autonomous mode is activated
     */
    @Override
    public void autonomousPeriodic() { }

    /**
     * Runs once when simulations is activated
     */
    @Override
    public void simulationInit() {
        REVPhysicsSim.getInstance().addSparkMax(motor, DCMotor.getNEO(1));
    }

    /**
     * Loops while simulations is activated
     */
    @Override
    public void simulationPeriodic() {
        REVPhysicsSim.getInstance().run();
    }
}
