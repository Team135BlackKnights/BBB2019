package org.usfirst.frc.team135.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team135.robot.RobotMap.SONARMAP;

import edu.wpi.first.wpilibj.*;

/**
 *
 */
public class UltrasonicSensor extends Subsystem {
 
    private static UltrasonicSensor instance;
	
    public Ultrasonic 
    rightSonar,
    leftSonar;
    
    public UltrasonicSensor()
    {
    	rightSonar = new Ultrasonic(SONARMAP.RIGHT_SONAR_TRIG_PORT, SONARMAP.RIGHT_SONAR_ECHO_PORT);
    	leftSonar = new Ultrasonic(SONARMAP.LEFT_SONAR_TRIG_PORT, SONARMAP.LEFT_SONAR_ECHO_PORT);
    	rightSonar.setAutomaticMode(true);
    	leftSonar.setAutomaticMode(true);
    	
    }
    
    public static UltrasonicSensor getInstance()
    {
    	if (instance == null)
    	{
    		instance = new UltrasonicSensor();
    	}
    	return instance;
    }
    
	public double getRightSonarValue() {
		double RightSonarDistance = rightSonar.getRangeInches();
		SmartDashboard.putNumber("Right Sonar Distance: ", RightSonarDistance);
		return RightSonarDistance;
	}

	public double getLeftSonarValue() {
		double LeftSonarDistance = leftSonar.getRangeInches();
		SmartDashboard.putNumber("Left Sonar Distance: ", LeftSonarDistance);
		return LeftSonarDistance;
	}
    
    public void periodic()
    {
    	System.out.println("Sonar: " + getLeftSonarValue() + ", " + getRightSonarValue());
    }

    public void initDefaultCommand() {
        
    }
}

