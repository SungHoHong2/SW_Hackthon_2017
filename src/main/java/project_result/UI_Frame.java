package project_result;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	    
	    Button btn = new Button("MOVE_FRONT");
	    btn.addActionListener(this);   
	    btn.setActionCommand(Instructions.MOVE_FRONT.getValue());
	    left_menu.add(btn);
	    
	    left_menu.add(new Button("MOVE_BACK"));
	    left_menu.add(new Button("TURN_RIGHT"));
	    left_menu.add(new Button("TURN_LEFT"));
	    left_menu.add(new Button("BLINK_RIGHT"));
	    left_menu.add(new Button("BLINK_LEFT"));	 
	    left_menu.add(new Button("BLINK_BOTH"));
	    
	    add(new Button("Topic: RTC Car Control"), BorderLayout.NORTH);
	    add(left_menu, BorderLayout.WEST);
	    add(new Button("Diagram Images"), BorderLayout.CENTER);
	    add(new Button("Save button & Save Submit"), BorderLayout.SOUTH);
	}
	
    public void actionPerformed(ActionEvent e) {
    	
    	     String cmd = e.getActionCommand();
    	     	     
    	     if(cmd.equals(Instructions.MOVE_FRONT.getValue())){
    	    	 	Stack<String> inst = Buffer.instructions;
    	    	 	inst.push(Instructions.MOVE_FRONT.getValue());
    	     }
        	
    }
	
}
