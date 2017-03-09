package project_result;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Stack;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import project_result.Buffer;

public class UI_Frame extends JFrame implements ActionListener{

	public UI_Frame(){
	    setVisible(true);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);	
	    setTitle("UI Framework example");
	    setSize(700, 700);
	    
	    
	    JPanel left_menu = new JPanel();
	    left_menu.setLayout(new BoxLayout(left_menu, BoxLayout.Y_AXIS));
	    
	    Button btn = new Button("Go Front");
	    btn.addActionListener(this);   
	    btn.setActionCommand("Go_Front");

	    left_menu.add(btn);
	    
	    left_menu.add(new Button("Go Backwards"));
	    left_menu.add(new Button("Turn Left"));
	    left_menu.add(new Button("Turn Right"));
	    left_menu.add(new Button("Blink Left"));
	    left_menu.add(new Button("Blink Right"));
	    left_menu.add(new Button("Both Blink"));	    
	    
	    add(new Button("Topic: RTC Car Control"), BorderLayout.NORTH);
	    add(left_menu, BorderLayout.WEST);
	    add(new Button("Diagram Images"), BorderLayout.CENTER);
	    add(new Button("Save button & Save Submit"), BorderLayout.SOUTH);
	}
	
    public void actionPerformed(ActionEvent e) {
    	
    	     String cmd = e.getActionCommand();

    	     
    	     if(cmd.equals("Go_Front")){
    	    	 	Stack inst = Buffer.instructions;
    	    	 	inst.push("howdy");
    	     }
        	
    }
	
}
