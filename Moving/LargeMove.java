package Moving;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class LargeMove extends Thread {
	private RegulatedMotor motor1;
	private RegulatedMotor motor2;
	private RegulatedMotor motor3;
	private RegulatedMotor motor4;
	private int mSpeed1;
	private int mSpeed2;
	private int mSpeed3;
	private int mSpeed4;
	
	/**
	 * Constructor with preset speed for all motors
	 */
	public LargeMove(RegulatedMotor motor1, RegulatedMotor motor2, RegulatedMotor motor3, RegulatedMotor motor4){
		this.motor1 = motor1;
		this.motor2 = motor2;
		this.motor3 = motor3;
		this.motor4 = motor4;
		this.motor1.setSpeed(mSpeed1);
		this.motor2.setSpeed(mSpeed2);
		this.motor1.synchronizeWith(new RegulatedMotor[] {motor2});
		this.motor3.setSpeed(250);
		this.motor4.setSpeed(1550);
		
	}
	
	public void run() {
		
	}
	
	/**
	 * Orders the robot to move forward
	 */	
	public void moveForward() {
		mSpeed1 = 500;
		mSpeed2 = 500;
		motor1.startSynchronization();
		motor1.forward();
		motor2.forward();
		motor1.setSpeed(mSpeed1);
		motor2.setSpeed(mSpeed2);
		motor1.endSynchronization();
	}
	
	/**
	 * Orders the robot to turn right
	 */
	public void turnRight() {
		motor1.backward();
		motor2.forward();
	}
	
	/**
	 * Orders the robot to turn left
	 */
	public void turnLeft() {		
		motor1.forward();
		motor2.backward();

	}
	
	/**
	 * Makes the Robot move backwards
	 */
	public void moveBackwards() {
		mSpeed1 = 500;
		mSpeed2 = 500;
		motor1.startSynchronization();
		motor1.backward();
		motor2.backward();
		motor1.setSpeed(mSpeed1);
		motor2.setSpeed(mSpeed2);
		motor1.endSynchronization();
	}
	
	public void stopEngine() {
		motor1.startSynchronization();
		motor1.stop();
		motor2.stop();
		motor1.endSynchronization();
	}
	
	/**
	 * Robot lifts an object
	 */
	public void clawLift() {
		motor3.forward();
		Delay.msDelay(950);
		motor3.stop();
	}
	
	/**
	 * Robot lowers the cargo
	 */
	public void clawDown() {
		motor3.backward();
		Delay.msDelay(950);
		motor3.stop();
	}
	
	/**
	 * Robot grabs an object
	 */
	public void clawGrab() {
		motor4.backward();
		Delay.msDelay(6250);
		motor4.stop();
	}
	/**
	 * Robot releases the object
	 */
	public void clawRelease() {
		motor4.forward();
		Delay.msDelay(6250);
		motor4.stop();
	}
	
	public void clawStop() {
		motor3.stop();
		motor4.stop();
	}
	
	/**
	 * Shuts down the motors
	 */
	public void shutDown() {
		this.motor1.close();
		this.motor2.close();
		this.motor3.close();
		this.motor4.close();
	}
}
