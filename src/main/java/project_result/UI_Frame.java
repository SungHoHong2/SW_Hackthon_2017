package project_result;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Queue;
import java.util.Stack;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import project_result.Buffer;
import project_result.Buffer.Instructions;

public class UI_Frame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	public UI_Frame(){
	    setVisible(true);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);	
	    setTitle("UI Framework example");
	    setSize(700, 700);
	   
	    JPanel left_menu = new JPanel();
	    left_menu.setLayout(new BoxLayout(left_menu, BoxLayout.Y_AXIS));
	    
	    Button btn = new Button(Instructions.FORWARD.getValue());
	    btn.addActionListener(this);   
	    btn.setActionCommand(Instructions.FORWARD.getValue());
	    left_menu.add(btn);
	    
	    btn = new Button(Instructions.BACKWARD.getValue());
	    btn.addActionListener(this);   
	    btn.setActionCommand(Instructions.BACKWARD.getValue());
	    left_menu.add(btn);
	    
	    btn = new Button(Instructions.TURN_LEFT.getValue());
	    btn.addActionListener(this);   
	    btn.setActionCommand(Instructions.TURN_LEFT.getValue());
	    left_menu.add(btn);
	    
	    btn = new Button(Instructions.TURN_RIGHT.getValue());
	    btn.addActionListener(this);   
	    btn.setActionCommand(Instructions.TURN_RIGHT.getValue());
	    left_menu.add(btn);
	    
	    btn = new Button(Instructions.BRAKE.getValue());
	    btn.addActionListener(this);   
	    btn.setActionCommand(Instructions.BRAKE.getValue());
	    left_menu.add(btn);
	    
	    btn = new Button(Instructions.LEFT_LIGHT_ON.getValue());
	    btn.addActionListener(this);   
	    btn.setActionCommand(Instructions.LEFT_LIGHT_ON.getValue());
	    left_menu.add(btn);
	    
	    btn = new Button(Instructions.RIGHT_LIGHT_ON.getValue());
	    btn.addActionListener(this);   
	    btn.setActionCommand(Instructions.RIGHT_LIGHT_ON.getValue());
	    left_menu.add(btn);

	    btn = new Button(Instructions.LEFT_LIGHT_OFF.getValue());
	    btn.addActionListener(this);   
	    btn.setActionCommand(Instructions.LEFT_LIGHT_OFF.getValue());
	    left_menu.add(btn);
	    
	    btn = new Button(Instructions.RIGHT_LIGHT_OFF.getValue());
	    btn.addActionListener(this);   
	    btn.setActionCommand(Instructions.RIGHT_LIGHT_OFF.getValue());
	    left_menu.add(btn);
	    
	    btn = new Button(Instructions.BOTH_LIGHTS_ON.getValue());
	    btn.addActionListener(this);   
	    btn.setActionCommand(Instructions.BOTH_LIGHTS_ON.getValue());
	    left_menu.add(btn);
	    
	    btn = new Button(Instructions.BOTH_LIGHTS_OFF.getValue());
	    btn.addActionListener(this);   
	    btn.setActionCommand(Instructions.BOTH_LIGHTS_OFF.getValue());
	    left_menu.add(btn);
	    
	    btn = new Button(Instructions.SENSORS.getValue());
	    btn.addActionListener(this);   
	    btn.setActionCommand(Instructions.SENSORS.getValue());
	    left_menu.add(btn);
	    
	    
	    add(new Button("Topic: RTC Car Control"), BorderLayout.NORTH);
	    add(left_menu, BorderLayout.WEST);
	    add(new Button("Diagram Images"), BorderLayout.CENTER);
	    add(new Button("Save button & Save Submit"), BorderLayout.SOUTH);
	}
	
    public void actionPerformed(ActionEvent e) {
    	
    	     String cmd = e.getActionCommand();
    	     	     
    	     if(cmd.equals(Instructions.FORWARD.getValue())){
    	    	 	Queue<String> inst = Buffer.instructions;
    	    	 	inst.offer(Instructions.FORWARD.getValue());
    	     }	
    	     
    	     if(cmd.equals(Instructions.BACKWARD.getValue())){
 	    	 	Queue<String> inst = Buffer.instructions;
 	    	 	inst.offer(Instructions.BACKWARD.getValue());
    	     }	
    	     
    	     if(cmd.equals(Instructions.TURN_LEFT.getValue())){
 	    	 	Queue<String> inst = Buffer.instructions;
 	    	 	inst.offer(Instructions.TURN_LEFT.getValue());
    	     }	
    	     
    	     
    	     if(cmd.equals(Instructions.TURN_RIGHT.getValue())){
 	    	 	Queue<String> inst = Buffer.instructions;
 	    	 	inst.offer(Instructions.TURN_RIGHT.getValue());
    	     }	
    	     
    	     
    	     if(cmd.equals(Instructions.BRAKE.getValue())){
 	    	 	Queue<String> inst = Buffer.instructions;
 	    	 	inst.offer(Instructions.BRAKE.getValue());
    	     }	
    	     
    	     if(cmd.equals(Instructions.LEFT_LIGHT_ON.getValue())){
 	    	 	Queue<String> inst = Buffer.instructions;
 	    	 	inst.offer(Instructions.LEFT_LIGHT_ON.getValue());
    	     }	
    	     
    	     if(cmd.equals(Instructions.LEFT_LIGHT_OFF.getValue())){
 	    	 	Queue<String> inst = Buffer.instructions;
 	    	 	inst.offer(Instructions.LEFT_LIGHT_OFF.getValue());
    	     }	
    	     
    	     if(cmd.equals(Instructions.RIGHT_LIGHT_ON.getValue())){
 	    	 	Queue<String> inst = Buffer.instructions;
 	    	 	inst.offer(Instructions.RIGHT_LIGHT_ON.getValue());
    	     }	
    	     
    	     if(cmd.equals(Instructions.RIGHT_LIGHT_OFF.getValue())){
 	    	 	Queue<String> inst = Buffer.instructions;
 	    	 	inst.offer(Instructions.RIGHT_LIGHT_OFF.getValue());
    	     }	
    	     
    	     
    	     if(cmd.equals(Instructions.BOTH_LIGHTS_ON.getValue())){
 	    	 	Queue<String> inst = Buffer.instructions;
 	    	 	inst.offer(Instructions.BOTH_LIGHTS_ON.getValue());
    	     }	
    	     
    	     
    	     if(cmd.equals(Instructions.BOTH_LIGHTS_OFF.getValue())){
 	    	 	Queue<String> inst = Buffer.instructions;
 	    	 	inst.offer(Instructions.BOTH_LIGHTS_OFF.getValue());
    	     }	
    	     
    	     if(cmd.equals(Instructions.SENSORS.getValue())){
 	    	 	Queue<String> inst = Buffer.instructions;
 	    	 	inst.offer(Instructions.SENSORS.getValue());
    	     }	
    	     
    	     
    }
}
