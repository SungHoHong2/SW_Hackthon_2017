package project_result;
import java.util.List;
import java.util.Stack;

import org.sintef.jarduino.DigitalPin;
import org.sintef.jarduino.DigitalState;
import org.sintef.jarduino.JArduino;
import org.sintef.jarduino.PinMode;

import project_result.Buffer;


public class Main_Controller extends JArduino{

	public Main_Controller(String port) {
		super(port);
	}

	public static void main(String[] args) {
		UI_Frame ui_frame = new UI_Frame();		
        String serialPort = "/dev/cu.usbmodem1421";   
        JArduino arduino = new Main_Controller(serialPort);
        arduino.runArduinoProcess();		
	}

	@Override
	protected void loop() {      
		 Stack<String> inst = Buffer.instructions;		
		 if(!inst.isEmpty()){			 		     
			 digitalWrite(DigitalPin.PIN_12, DigitalState.HIGH);
			 
		     delay(1000); // wait for a second
		     digitalWrite(DigitalPin.PIN_12, DigitalState.LOW);
		     delay(1000); // wait for a second
		     System.out.println(inst.pop());
		     
		 }		
	}

	@Override
	protected void setup() {
		// TODO Auto-generated method stub
        pinMode(DigitalPin.PIN_12, PinMode.OUTPUT);

	}
	
}
