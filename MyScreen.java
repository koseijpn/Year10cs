package firsttry;

import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
public class MyScreen extends JFrame {
	/**
	 * MyScreen basic window for game, inherits properties and methods
	 * @param args
	 * @author kosei.satoh
	 * @since October 9th 2018
	 */
	
	public MyScreen() {
		this.setSize(1440,900);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
			MyScreen screen = new MyScreen();
			MyCanvas canvas = new MyCanvas();
			//PopupMenu menu = new PopupMenu();
			//StartMenu start = new StartMenu();
			screen.getContentPane().add(canvas);
			//start.getContentPane().add(menu);
			

			
	}

}
