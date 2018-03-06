package Paaohjelma;
import Moving.*;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;
public class Paaohjelma {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EV3IRSensor sensor = new EV3IRSensor(SensorPort.S1);
		EV3ColorSensor csensor = new EV3ColorSensor(SensorPort.S2);
		EV3IRSensor beacon = new EV3IRSensor(SensorPort.S3);
		RegulatedMotor motor1 = new EV3LargeRegulatedMotor(MotorPort.A);
		RegulatedMotor motor2 = new EV3LargeRegulatedMotor(MotorPort.B);
		RegulatedMotor motor3 = new EV3LargeRegulatedMotor(MotorPort.C);
		RegulatedMotor motor4 = new EV3MediumRegulatedMotor(MotorPort.D);
		
		IRChecker checker = new IRChecker(sensor);
		LargeMove move = new LargeMove(motor1, motor2, motor3, motor4);
		ColorSensor c = new ColorSensor(csensor);
		Beacon b = new Beacon(beacon);
		
		move.start();
		checker.start();
		c.start();
		b.start();
		//push test
		
		int color = c.getColor();
		int grabstate = 2;
		
		while(!Button.ENTER.isDown()) {
			int command = checker.getCommand(); 	
			LCD.drawString("Remote command: " + command, 0, 0);
			Delay.msDelay(150);
			if(command == 0) {
				move.stopEngine();
			}
			if(command == 9) {
				if(grabstate % 2 == 0) {
					move.clawGrab();
					move.clawLift();
					grabstate++;
				} else {
					move.clawDown();
					move.clawRelease();
					grabstate++;
				}
				
			}
			if(command == 1) {
				move.moveForward();
			}
			if(command == 3) {
				move.moveBackwards();
			}
			if(command == 2) {
				move.turnLeft();
			}
			if(command == 4) {
				move.turnRight();
			}
			
		}

	}

}
