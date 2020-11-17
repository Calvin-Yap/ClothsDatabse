
import javax.swing.JFrame;

/**
   This program allows the user to view font effects.
*/
public class clothsviewer
{  
	
   public static void main(String[] args)
   {  
      JFrame frame = new clothsmenu();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("Cloths DB");
      frame.setVisible(true);      
   }

}