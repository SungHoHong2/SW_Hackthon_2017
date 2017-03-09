package project_result;

import java.util.Stack;

import org.sintef.jarduino.DigitalPin;
import org.sintef.jarduino.DigitalState;
import org.sintef.jarduino.JArduino;
import org.sintef.jarduino.PinMode;

public class Arduino_Frame extends JArduino{

	public Arduino_Frame(String port) {
		super(port);
		// TODO Auto-generated constructor stub
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
