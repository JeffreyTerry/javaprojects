package Daniel;

import javax.swing.JOptionPane;

public class ErrorHandling {

	public static void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void catchError(String message, Exception e)
	{
		JOptionPane.showMessageDialog(null, message, "", JOptionPane.ERROR_MESSAGE);
		int choice = JOptionPane.showConfirmDialog(null, "Would you like to print the error stream?");
		if(choice==0)
			e.printStackTrace();
	}

}
