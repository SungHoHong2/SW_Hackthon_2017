package project_result;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
		SENSORS("SENSORS");
		
	    private String value;
	    Instructions(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	    	
	}

	     
    public static Queue<String> instructions = new LinkedList<String>();
}



