package com.team2073.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.team2073.robot.subsystems.SimpleSubsystem;
import edu.wpi.first.wpilibj.Joystick;

import static com.team2073.robot.constants.AppConstants.*;

public class ApplicationContext {

    private static ApplicationContext instance;

    private CANSparkMax motor;
    private Joystick controller;
    private SimpleSubsystem simpleSubsystem;

    /**
     * Makes an ApplicationContext object if not made already (static implementation)
     * @return ApplicationContext object
     */
    public static ApplicationContext getInstance() {
        if (instance == null) {
            instance = new ApplicationContext();
        }
        return instance;
    }

    /**
     * Makes CANSparkMax object if not made already
     * @return CANSparkMax object
     */
    public CANSparkMax getMotor() {
        if (motor == null) {
            motor = new CANSparkMax(MOTOR_PORT, CANSparkMaxLowLevel.MotorType.kBrushless);
        }
        return motor;
    }

    public Joystick getController() {
        if (controller == null) {
            controller = new Joystick(CONTROLLER_PORT);
        }
        return controller;
    }

    public SimpleSubsystem getSimpleSubsystem() {
        if (simpleSubsystem == null) {
            simpleSubsystem = new SimpleSubsystem();
        }
        return simpleSubsystem;
    }
}
