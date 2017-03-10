package project_result;
import org.sintef.jarduino.JArduino;

public class Main_Controller {

	public static void main(String[] args) {
        String serialPort = "/dev/cu.usbmodem1411";   
		new UI_Frame();	// Run the UI Frame	
        JArduino arduino = new Arduino_Frame(serialPort); // initialize the Arduino 
        arduino.runArduinoProcess(); // run the Arduino 		
	}	
}
