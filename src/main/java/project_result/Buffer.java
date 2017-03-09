package project_result;
import java.util.Stack;

public class Buffer {
	public static enum Instructions{
		MOVE_FRONT("MOVE_FRONT"),
		MOVE_BACK("MOVE_BACK"),
		TURN_RIGHT("TURN_RIGHT"),
		TURN_LEFT("TURN_LEFT"),
		BLINK_RIGHT("BLINK_RIGHT"),
		BLINK_LEFT("BLINK_LEFT"),
		BLINK_BOTH("BLINK_BOTH");	
		
	    private String value;
	    Instructions(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	    	
	}

    public static Stack<String> instructions = new Stack<String>();
}

