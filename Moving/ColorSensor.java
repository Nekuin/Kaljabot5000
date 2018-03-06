package Moving;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;

public class ColorSensor extends Thread{
	private EV3ColorSensor cs;
	private int color = 0;
	
	public ColorSensor(EV3ColorSensor sensor) {
		this.cs = sensor;
	}

	/**
	 * Reads a color and returns a value for line following.
	 * BLACK is forward, BLUE is left, RED is right, default is used for stopping the robot.
	 * @param cs
	 * @return int
	 */
	
	public void selection() {
		
		
		switch(cs.getColorID()) {		//reads a color and returns a value
		case Color.BLACK:
			color = 1;
			break;
		case Color.BLUE:
			color = 2;
			break;
		case Color.RED:
			color = 3;
			break;
		default:						//default color is used for stopping
			color = 4;
			break;
		}
		
	}
	
	public int getColor() {
		return color;
	}
}	
