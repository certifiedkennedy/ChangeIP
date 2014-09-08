/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
 
package changeip;
 
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
 
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;
 
/* 
 * ButtonDemo.java requires the following files:
 *   images/right.gif
 *   images/middle.gif
 *   images/left.gif
 */
public class changeip extends JPanel
                        implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected JButton button_1, button_2, button_3, button_4, button_5;
	public static JLabel label_1, label_2, label_3, label_4, label_5;

	protected ImageIcon greenDark, greenBright, yellow, red;
	
	public static Image greenDarkPng = Toolkit.getDefaultToolkit().getImage(changeip.class.getResource("images/green_dark.png"));
	public static Image greenBrightPng = Toolkit.getDefaultToolkit().getImage(changeip.class.getResource("images/green_dark.png"));
	public static Image yellowPng = Toolkit.getDefaultToolkit().getImage(changeip.class.getResource("images/green_dark.png"));
	public static Image redPng = Toolkit.getDefaultToolkit().getImage(changeip.class.getResource("images/green_dark.png"));
	
	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
				return new ImageIcon(imgURL, description);
			} else {
				System.err.println("Couldn't find file: " + path);
				return null;
			}
		}
	
    public changeip() {
        //ImageIcon leftButtonIcon = createImageIcon("images/right.gif");
        //ImageIcon middleButtonIcon = createImageIcon("images/middle.gif");
        //ImageIcon rightButtonIcon = createImageIcon("images/left.gif");
    	//ImageIcon greenDark = createImageIcon("images/green_dark.png");
    	//ImageIcon greenBright = createImageIcon("images/green_bright.png");
    	//ImageIcon yellow = createImageIcon("images/yellow.png");
    	//ImageIcon red = createImageIcon("images/red.png");
    	
    	ImageIcon icon1 = new ImageIcon(greenDarkPng.getClass().getResource(getName()).getPath());
    	ImageIcon icon2 = new ImageIcon(greenDarkPng.getClass().getResource(getName()).getPath());
    	ImageIcon icon3 = new ImageIcon(greenDarkPng.getClass().getResource(getName()).getPath());
    	ImageIcon icon4 = new ImageIcon(greenDarkPng.getClass().getResource(getName()).getPath());
    	ImageIcon icon5 = new ImageIcon(greenDarkPng.getClass().getResource(getName()).getPath());

    	
    	String ip1 = "192.168.0.5";
		String ip2 = "192.168.1.5";
		String ip3 = "192.168.5.5";
		String ip4 = "192.168.8.5";
		String dhcp = "DHCP";
		
        button_1 = new JButton(ip1);//, leftButtonIcon);
        label_1.setIcon(icon1);

        button_1.setVerticalTextPosition(AbstractButton.CENTER);
        button_1.setHorizontalTextPosition(AbstractButton.LEADING);
        button_1.setPreferredSize(new Dimension(125, 25));
        button_1.setActionCommand("bid1" + "setIp" + ip1);

        button_2 = new JButton(ip2);//, middleButtonIcon);
        label_2.setIcon(greenDark);
        button_2.setVerticalTextPosition(AbstractButton.BOTTOM);
        button_2.setHorizontalTextPosition(AbstractButton.CENTER);
        button_2.setPreferredSize(new Dimension(125, 25));
        button_2.setActionCommand("bid2" + "setIp" + ip2);
 
        button_3 = new JButton(ip3);//, rightButtonIcon);
        label_3.setIcon(greenDark);
        button_3.setVerticalTextPosition(AbstractButton.BOTTOM);
        button_3.setHorizontalTextPosition(AbstractButton.CENTER);
        button_3.setPreferredSize(new Dimension(125, 25));
        button_3.setActionCommand("bid3" + "setIp" + ip3);
 
        button_4 = new JButton(ip4);
        label_4.setIcon(greenDark);
        button_4.setVerticalTextPosition(AbstractButton.CENTER);
        button_4.setHorizontalTextPosition(AbstractButton.LEADING);
        button_4.setPreferredSize(new Dimension(125, 25));
        button_4.setActionCommand("bid4" + "setIp" + ip4);
        
        button_5 = new JButton(dhcp);
        label_5.setIcon(greenDark);
        button_5.setVerticalTextPosition(AbstractButton.CENTER);
        button_5.setHorizontalTextPosition(AbstractButton.LEADING);
        button_5.setPreferredSize(new Dimension(125, 25));
        button_5.setActionCommand("bidDHCP" + "setDHCP");
        
        //Listen for actions on buttons 1 and 3.
        button_1.addActionListener(this);
        button_2.addActionListener(this);
        button_3.addActionListener(this);
        button_4.addActionListener(this);
        button_5.addActionListener(this);
        
//        button_1.setToolTipText("Click this button to disable the middle button.");
//        button_2.setToolTipText("This middle button does nothing when you click it.");
//        button_3.setToolTipText("Click this button to enable the middle button.");
 
        //Add Components to this container, using the default FlowLayout.
        add(button_1);
        add(label_1);
        
        add(button_2);
        add(label_2);
        
        add(button_3);
        add(label_3);
        
        add(button_4);
        add(label_4);
        
        add(button_5);
        add(label_5);
    }
 
    public void actionPerformed(ActionEvent e) {
    	String action = e.getActionCommand();
    	String button = action.substring(0, 4);
    	String command = action.substring(4, 9);
    	
    	if (command.equals("setIp")) {
    		String ip = action.substring(9);

	    	String mask="255.255.255.0";
	    	String[] command1 = { "netsh", "interface", "ip", "set", "address",
	    	"name=", "Local Area Connection" ,"source=static", "addr=",ip,
	    	"mask=", mask};
	    	
	    	//JOptionPane.showMessageDialog(null, command1);
	    	//JOptionPane.showMessageDialog(null, action);
			
	    	button_1.setEnabled(true);
			button_2.setEnabled(true);
			button_3.setEnabled(true);
			button_4.setEnabled(true);
			
	    	switch (button) {
	    		case "bid1":
	    			button_1.setEnabled(false);
	    			label_1.setIcon(yellow);
	    			break;
	    		case "bid2":
	    			button_2.setEnabled(false);
	    			label_2.setIcon(yellow);
	    			break;
	    		case "bid3":
	    			button_3.setEnabled(false);
	    			label_3.setIcon(yellow);
	    			break;
	    		case "bid4":
	    			button_4.setEnabled(false);
	    			label_4.setIcon(yellow);
	    			break;
	    	}
	    	
	    	try {
	    		String line;
				Process pp = java.lang.Runtime.getRuntime().exec(command1);
				BufferedReader input = 
						new BufferedReader
							(new InputStreamReader(pp.getInputStream()));
				while ((line = input.readLine()) !=null) {
					System.out.println(line);
				}
				input.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	
		} else if (action.contains("DHCP")) {
			String[] command1 = { "netsh", "interface", "ip", "set", "address",
					"name=", "Local Area Connection", "DHCP"
			};
			String[] command2 = { "netsh", "interface", "ip", "set", "dns",
					"name=", "Local Area Connection", "DHCP"
			};
			try {
				String line;
				Process pp1 = Runtime.getRuntime().exec(command1);
				Process pp2 = Runtime.getRuntime().exec(command2);
				BufferedReader input1 = 
						new BufferedReader
							(new InputStreamReader(pp1.getInputStream()));
				while ((line = input1.readLine()) !=null) {
					System.out.println(line);
				}
				input1.close();
				BufferedReader input2 = 
						new BufferedReader
							(new InputStreamReader(pp2.getInputStream()));
				while ((line = input2.readLine()) !=null) {
					System.out.println(line);
				}
				input2.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
    }
 
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = changeip.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
 
    /**
     * Create the GUI and show it.  For thread safety, 
     * this method should be invoked from the 
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
 
        //Create and set up the window.
        JFrame frame = new JFrame("ChangeIP");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        changeip newContentPane = new changeip();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.setSize(220, 400);
        frame.setLocation((int) (GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getWidth()-frame.getWidth()), 0);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }
}