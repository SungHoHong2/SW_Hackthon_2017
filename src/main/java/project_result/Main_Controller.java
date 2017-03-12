package project_result;
import java.awt.EventQueue;

import org.sintef.jarduino.JArduino;
import org.sintef.jarduino.comm.Serial4JArduino;

public class Main_Controller {

	public static void main(String[] args) {
		String serialPort = Serial4JArduino.selectSerialPort();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_Frame window = new UI_Frame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
       JArduino arduino = new Arduino_Frame(serialPort); // initialize the Arduino 
       arduino.runArduinoProcess(); // run the Arduino 		 
	
	}	
}


