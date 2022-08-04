package com.team2073.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import static com.team2073.robot.AppConstants.*;

public class ApplicationContext {

    private static ApplicationContext instance;

    public static ApplicationContext getInstance() {
        if (instance == null) {
            instance = new ApplicationContext();
        }
        return instance;
    }
}
