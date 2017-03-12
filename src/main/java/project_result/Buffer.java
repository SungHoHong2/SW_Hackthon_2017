package project_result;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.JLabel;

public class Buffer {
	public static enum Instructions{
		
		FORWARD("FORWARD"),		
		BACKWARD("BACKWARD"),
		TURN_LEFT("TURN_LEFT"),
		TURN_RIGHT("TURN_RIGHT"),
		BRAKE("BRAKE"),
		LEFT_LIGHT_ON("LEFT_LIGHT_ON"),
		RIGHT_LIGHT_ON("RIGHT_LIGHT_ON"),
		LEFT_LIGHT_OFF("LEFT_LIGHT_OFF"),
	    RIGHT_LIGHT_OFF("RIGHT_LIGHT_OFF"),
		BOTH_LIGHTS_ON("BOTH_LIGHTS_ON"),		
		BOTH_LIGHTS_OFF("BOTH_LIGHTS_OFF"),
		HORN("HORN"),
		SENSORS("SENSORS");
		
	    private String value;
	    Instructions(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}
	     
    public static Stack<String> instructions = new Stack<String>();
    public static Queue<String> storyboard_instructions = new LinkedList<String>();
    public static Queue<JLabel> storybaord_timeline = new LinkedList<JLabel>(); 
    
    public static boolean start_the_storyboard = false;
    public static boolean pause_the_storyboard = false;
    
    public static int speed = 100;
    public static int duration = 500;
    
}



