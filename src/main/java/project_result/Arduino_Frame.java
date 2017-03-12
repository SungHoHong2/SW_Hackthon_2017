package project_result;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import org.sintef.jarduino.AnalogPin;
import org.sintef.jarduino.DigitalPin;
import org.sintef.jarduino.DigitalState;
import org.sintef.jarduino.JArduino;
import org.sintef.jarduino.PWMPin;
import org.sintef.jarduino.PinMode;

import project_result.Buffer.Instructions;

interface Command {
    void runCommand(int motorSpeed);
}

public class Arduino_Frame extends JArduino{

    Map<String, Command> methodMap = new HashMap<String, Command>();
	
	public Arduino_Frame(String port) {
		super(port);
		
        methodMap.put(Instructions.FORWARD.getValue(), new Command() {
            public void runCommand(int motorSpeed) { 
            	System.out.println("FORWARD"); 	
      	        digitalWrite(DigitalPin.PIN_7, DigitalState.HIGH);
    		    digitalWrite(DigitalPin.PIN_12, DigitalState.HIGH);
    		    digitalWrite(DigitalPin.PIN_8, DigitalState.LOW);
    		    digitalWrite(DigitalPin.PIN_13, DigitalState.LOW);
    		    analogWrite(PWMPin.PWM_PIN_6, (byte)map(1023,0,1023,0,255)); 
    		    analogWrite(PWMPin.PWM_PIN_11, (byte)map(1023,0,1023,0,255));
            };
        });	       
         
        methodMap.put(Instructions.BACKWARD.getValue(), new Command() {
            public void runCommand(int motorSpeed) { 
              System.out.println("BACKWARD");
      		  digitalWrite(DigitalPin.PIN_7, DigitalState.LOW);
    		  digitalWrite(DigitalPin.PIN_12, DigitalState.LOW);
    		  digitalWrite(DigitalPin.PIN_8, DigitalState.HIGH);
    		  digitalWrite(DigitalPin.PIN_13, DigitalState.HIGH);
    		  analogWrite(PWMPin.PWM_PIN_6, (byte)motorSpeed);
    		  analogWrite(PWMPin.PWM_PIN_11, (byte)motorSpeed);              	
            };
        });	   
        
        methodMap.put(Instructions.TURN_LEFT.getValue(), new Command() {
            public void runCommand(int motorSpeed) { 
              System.out.println("TURN_LEFT");
      		  digitalWrite(DigitalPin.PIN_7, DigitalState.LOW);
    		  digitalWrite(DigitalPin.PIN_12, DigitalState.HIGH);
    		  digitalWrite(DigitalPin.PIN_8, DigitalState.HIGH);
    		  digitalWrite(DigitalPin.PIN_13, DigitalState.LOW);
    		  analogWrite(PWMPin.PWM_PIN_6, (byte)255);
    		  analogWrite(PWMPin.PWM_PIN_11, (byte)255);            	
            };
        });	   
     
        methodMap.put(Instructions.TURN_RIGHT.getValue(), new Command() {
            public void runCommand(int motorSpeed) { 
              System.out.println("TURN_RIGHT");
      		  digitalWrite(DigitalPin.PIN_7, DigitalState.HIGH);
    		  digitalWrite(DigitalPin.PIN_12, DigitalState.LOW);
    		  digitalWrite(DigitalPin.PIN_8, DigitalState.LOW);
    		  digitalWrite(DigitalPin.PIN_13, DigitalState.HIGH);
    		  analogWrite(PWMPin.PWM_PIN_6, (byte)255);
    		  analogWrite(PWMPin.PWM_PIN_11, (byte)255);	
            
            };
        });	   
        
        methodMap.put(Instructions.BRAKE.getValue(), new Command() {
            public void runCommand(int motorSpeed) { 
            	System.out.println("BRAKE");
            	  digitalWrite(DigitalPin.PIN_7, DigitalState.LOW);
            	  digitalWrite(DigitalPin.PIN_12, DigitalState.LOW);
            	  digitalWrite(DigitalPin.PIN_8, DigitalState.LOW);
            	  digitalWrite(DigitalPin.PIN_11, DigitalState.LOW);
            	  analogWrite(PWMPin.PWM_PIN_6, (byte)0);
            	  analogWrite(PWMPin.PWM_PIN_11, (byte)0);            	
            };
        });	   
        
        methodMap.put(Instructions.LEFT_LIGHT_ON.getValue(), new Command() {
            public void runCommand(int motorSpeed) { 
              System.out.println("LEFT_LIGHT_ON");
      		  analogWrite(PWMPin.PWM_PIN_9, (byte)100);

            };
        });	 

        methodMap.put(Instructions.RIGHT_LIGHT_ON.getValue(), new Command() {
            public void runCommand(int motorSpeed) { 
            	System.out.println("RIGHT_LIGHT_ON");
      		  analogWrite(PWMPin.PWM_PIN_10, (byte)100);

            };
        });	
        
        methodMap.put(Instructions.LEFT_LIGHT_OFF.getValue(), new Command() {
            public void runCommand(int motorSpeed) { 
              System.out.println("LEFT_LIGHT_OFF");
      		  analogWrite(PWMPin.PWM_PIN_9, (byte)100);

            };
        });	
        
        methodMap.put(Instructions.RIGHT_LIGHT_OFF.getValue(), new Command() {
            public void runCommand(int motorSpeed) { 
              System.out.println("RIGHT_LIGHT_OFF");
      		  analogWrite(PWMPin.PWM_PIN_10, (byte)100);

            };
        });	
        
        
        methodMap.put(Instructions.BOTH_LIGHTS_ON.getValue(), new Command() {
            public void runCommand(int motorSpeed) { 
              System.out.println("BOTH_LIGHTS_ON");
      		  analogWrite(PWMPin.PWM_PIN_10, (byte)100);
    		  analogWrite(PWMPin.PWM_PIN_9, (byte)100);
            };
        });	
        
        methodMap.put(Instructions.BOTH_LIGHTS_OFF.getValue(), new Command() {
            public void runCommand(int motorSpeed) { 
              System.out.println("BOTH_LIGHTS_OFF");
      		  analogWrite(PWMPin.PWM_PIN_10, (byte)0);
    		  analogWrite(PWMPin.PWM_PIN_9, (byte)0);
            };
        });	
        
        methodMap.put(Instructions.SENSORS.getValue(), new Command() {
            public void runCommand(int motorSpeed) { 
              System.out.println("SENSORS");
      		  digitalWrite(DigitalPin.PIN_2, DigitalState.HIGH);
    		  digitalWrite(DigitalPin.PIN_4, DigitalState.HIGH);
    		  delay(10);
    		  digitalWrite(DigitalPin.PIN_2, DigitalState.LOW);
    		  digitalWrite(DigitalPin.PIN_4, DigitalState.LOW);
    		  //frontTime = pulseIn(frontSensorIn, HIGH);
    		  // backTime = pulseIn(backSensorIn, HIGH);
    		  /// frontDistance = frontTime*0.034/2; // check this variable use java
    		  // backDistance = backTime*0.34/2; // this variable too!
    		  analogRead(AnalogPin.A_1); // this as well!!!
            };
        });	        
        
        methodMap.put(Instructions.HORN.getValue(), new Command() {
            public void runCommand(int motorSpeed) { 
              System.out.println("HORN");
            };
        });	             
	}

	
	protected void init_static(){
	  System.out.println("SHUT DOWN");
  	  digitalWrite(DigitalPin.PIN_7, DigitalState.LOW);
  	  digitalWrite(DigitalPin.PIN_12, DigitalState.LOW);
  	  digitalWrite(DigitalPin.PIN_8, DigitalState.LOW);
  	  digitalWrite(DigitalPin.PIN_11, DigitalState.LOW);
  	  analogWrite(PWMPin.PWM_PIN_6, (byte)0);
  	  analogWrite(PWMPin.PWM_PIN_11, (byte)0);  	
      analogWrite(PWMPin.PWM_PIN_10, (byte)0);
	  analogWrite(PWMPin.PWM_PIN_9, (byte)0);
	} 

	@Override
	protected void setup() {
		  pinMode(DigitalPin.PIN_2, PinMode.OUTPUT);
		  pinMode(DigitalPin.PIN_3, PinMode.INPUT);
		  pinMode(DigitalPin.PIN_4, PinMode.OUTPUT);
		  pinMode(DigitalPin.PIN_5, PinMode.INPUT);
		  pinMode(DigitalPin.PIN_6, PinMode.OUTPUT);
		  pinMode(DigitalPin.PIN_7, PinMode.OUTPUT);
		  pinMode(DigitalPin.PIN_8, PinMode.OUTPUT);
		  pinMode(DigitalPin.PIN_11, PinMode.OUTPUT);
		  pinMode(DigitalPin.PIN_12, PinMode.OUTPUT);
		  pinMode(DigitalPin.PIN_13, PinMode.OUTPUT);
		  pinMode(DigitalPin.PIN_9, PinMode.OUTPUT);
		  pinMode(DigitalPin.PIN_10, PinMode.OUTPUT);
		  pinMode(DigitalPin.A_1, PinMode.INPUT);
	}	
	
	@Override
	protected void loop() {      
		 Stack<String> inst = Buffer.instructions;		
		 Queue<String> str_inst = Buffer.storyboard_instructions;
		 
		 if(Buffer.start_the_storyboard && !Buffer.pause_the_storyboard && !str_inst.isEmpty()){
			   methodMap.get(str_inst.remove()).runCommand(Buffer.speed);
			   
			   if(str_inst.size()==0){
				   init_static(); 
			    }
			   
			   delay(Buffer.duration); 			 
		 }
		 
		 
		 
		 if(!inst.isEmpty()){			 		     
			   methodMap.get(inst.pop()).runCommand(Buffer.speed);			   
			   delay(Buffer.duration*10); 			 
			   init_static(); 
		 }		
	}
	
}
