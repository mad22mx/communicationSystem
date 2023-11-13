package finalExam.messagingSystem;

public class IDGenerator {
	//the id counter
	private int id = 0;
	//the singleton instance of the class
	private static final IDGenerator instance = new IDGenerator();
	
	private IDGenerator() {
		
	}
	
	public String getID() {
		//returns a string of the unique id by changing the int to str
		id++;
		return String.valueOf(id);
	}
	
	public static IDGenerator getInstance() {
		//returns the singleton instance of the class
		return instance;
	}
	
}
