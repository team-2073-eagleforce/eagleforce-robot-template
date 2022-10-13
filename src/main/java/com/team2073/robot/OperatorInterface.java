package com.team2073.robot;

import com.team2073.robot.commands.HalfPowerCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OperatorInterface {

    private ApplicationContext appCTX = ApplicationContext.getInstance(); //Gets the Application Context object
    private Joystick controller = appCTX.getController();  //Gets the Joystick object
    private JoystickButton a = new JoystickButton(controller, 1); //Makes a new Joystick Button connected to A on Xbox controller

    /**
     * Called in robotInit() to set the commands to the buttons
     */
    public void init() {
        a.whileHeld(new HalfPowerCommand()); //Calls HalfPowerCommand while A button is pressed and stops commands when released
    }
}
