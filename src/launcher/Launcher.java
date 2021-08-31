package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	
	private static Student estudiante;
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
        	public void run() {
				try {
					estudiante =  new Student(122950, "Carlos", "Antonio", "totocarlos0@outlook.com", "https://github.com/totoccar", "/images/mifoto.jpeg");
					SimplePresentationScreen window = new SimplePresentationScreen(estudiante);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    }
