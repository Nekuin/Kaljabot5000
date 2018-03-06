package Moving;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class Beacon extends Thread{

	private EV3IRSensor sensor;
	final SampleProvider sp = sensor.getSeekMode();
	private int distance;
	private int heading;
	
	public Beacon(EV3IRSensor sensor) {
		this.sensor = sensor;
		this.distance = 0;
		this.heading = 0;
		
	}
	
	public void run() {
		int beacon1Heading = 0;
		int beacon1Distance = 0;
		float[] sample = new float[sp.sampleSize()];
		
		while (!Button.ENTER.isDown()) {
			distance = beacon1Distance;
			heading = beacon1Heading;
			sp.fetchSample(sample, 0);
			beacon1Heading = (int) sample[0];
			beacon1Distance = (int) sample[1];
		}
	}
	
	public int getHeading() {
		
		return heading;
	}
	
	public int getDistance() {
		
		return distance;
	}
	
	
}
