package Moving;


import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
/**
 * 
 * @author Nekuin
 *
 */
public class IRChecker extends Thread {

	private EV3IRSensor infraredSensor;		//store sensor
	int remoteCommand;						//store command
/**
 * constructor, takes IRSensor as parameter
 * @param sensor
 */
	public IRChecker(EV3IRSensor sensor) {
		this.infraredSensor = sensor;
	}

/**
 * read IR command
 */
	public void run() {
		while (!Button.ENTER.isDown()) {
			remoteCommand = infraredSensor.getRemoteCommand(0);
			
		}

	}
	/**
	 * returns IR sensor remote command
	 * @return ir command
	 */
	public int getCommand() {
		return this.remoteCommand;
		
	}

}
