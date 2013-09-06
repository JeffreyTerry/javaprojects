/**
 * 
 * @author jterry
 *
 */

public class DataSystemDriver
{
	public static void main(String args[]){
		DataSystemGUI app = new DataSystemGUI();
		for(int i = 0; i < args.length; i++)
			app.loadMagazines(args[i]);
		app.open();
	}
	
	public static void createMagazineList(int length){
		for(int i = 0; i < length; i++){
		}
	}
}
