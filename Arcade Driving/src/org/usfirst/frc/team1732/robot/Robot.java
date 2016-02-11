// TO BE USED WITH SENSOR PROTOTYPE ROBOT, CHANGE PORTS TO MATCH DESIRED ROBOT

package org.usfirst.frc.team1732.robot;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;

public class Robot extends SampleRobot {
	Joystick controller;

	CANTalon left1; CANTalon left2; CANTalon left3;
	CANTalon right1; CANTalon right2; CANTalon right3;
	double y, x, left, right;

	public Robot() {
		// Sensor Prototyping robot: (one with the camera, left 3 and right 3 need to be negated)
		left1 = new CANTalon(11); left2 = new CANTalon(21); left3 = new CANTalon(22);
		right1 = new CANTalon(14); right2 = new CANTalon(12); right3 = new CANTalon(13);
		
		// Need to double check ports on these
		/*
		 * West Coast Robot: (also not sure which robot it is)
		 * left1 = new CANTalon(11); left2 = new CANTalon(21); left3 = new CANTalon(13);
		 * right1 = new CANTalon(14); right2 = new CANTalon(22); right3 = new CANTalon(12);
		 */
		
		/*
		 * Stronghold robot: (not sure which robot this is) left1 = new
		 * CANTalon(11); left2 = new CANTalon(15); left3 = new CANTalon(14);
		 * right1 = new CANTalon(16); right2 = new CANTalon(17); right3 = new
		 * CANTalon(12);
		 */
	}

	public void robotInit() {

	}

	public void operatorControl() {
		while (isOperatorControl() && isEnabled()) {
			// map this out right
			y = controller.getRawAxis(1); // y axis on left joy stick
			x = controller.getRawAxis(2); // x axis on right joy stick
			left = (y + x)/2.0;
			right = (y - x)/2.0;
			left1.set(left); left2.set(left); left3.set(-left);
			right1.set(right); right2.set(right); right3.set(-right);
		}
	}

}
