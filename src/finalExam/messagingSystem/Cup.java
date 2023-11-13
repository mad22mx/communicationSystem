package finalExam.messagingSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Cup implements User {
	
	private String id = "";
	FileWriter fw;
	Center center = Center.getInstance(); 
	IDGenerator genID = IDGenerator.getInstance();
	
	String[][] quotes = {{"There are only 10 types of people in the world: those who understand binary and those who don't.",
	"I'm not lazy, I'm just on energy-saving mode."},{"The best thing about a boolean is even if you are wrong, you are only off by a bit.",
		"My code's so clean, it makes my laundry jealous."}};

	
	Cup() {
		id = genID.getID();
		
		center.addUser(id, this);
	}
	
	public String toString() {
		return "Cup";
	}
	
	@Override
	public void sendMessage(Center c, String msg) {
		String[] fromToMessage = msg.split(":");
		
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(this + "" + id + ".txt", true));
			
			pw.println("Message sent to: " + center.communicators.get(fromToMessage[1]) );
			pw.println("    " + fromToMessage[2]);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		center.sendMessage(msg);
	}


	@Override
	public void saveMessage(Center c, String msg) {
		String[] fromToMessage = msg.split(":");
		
		
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(new File(this + "" + id + ".txt"), true));
			
			pw.println("Message received from: " + center.communicators.get(fromToMessage[0]) );
			pw.println("    " + fromToMessage[2]);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String getRandomQuote() {
		Random random = new Random();
		int randomIndex = random.nextInt(2);
		int randomIndex2 = random.nextInt(2);
		return quotes[randomIndex][randomIndex2];
	}
	
	
}