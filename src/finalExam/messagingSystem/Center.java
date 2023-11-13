package finalExam.messagingSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Center {
	//Center class is the heart of this messaging system. It registers and stores communicators' addresses
	//facilitates sending messages from the sender to the receiver.
	
	// This Map is accessed by a singleton instance of this class and it is used to register the communicators(users)
	//and access the users when needed
	public Map<String, User> communicators;
	private static final Center instance = new Center(); //singleton instance of the class
	
	private Center() {
		//initializes the instance of the class by assigning the map to a hashmap
		communicators = new HashMap<>();
	}
	
	public static Center getInstance() {
		//a public && static method that returns the singleton instance of the center class
		
        return instance;
    }
	
	public void addUser(String s, User u) {
		//registers a user in the map when called
		communicators.put(s, u);
		this.sendMessage("center:all:A New user Named " + u + 
				" and with a unique id no. " + s + " has joined the communication system.");
	}
	
	public void showUsersList() {
		// it returns the whole list of users registered in the map
        System.out.println("List of users in the system:");
        for (Map.Entry<String, User> entry : communicators.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", User: " + entry.getValue());
        }
    }
    
	public void sendMessage(String msg) {
		//this message sends message to the receiver when called by splitting the string it is given when called
	    String[] fromToMessage = msg.split(":");
	    //this is a condition that becomes true when there are multiple receivers but not all.
	    if(fromToMessage[1].contains(",")) {
	    	String[] receivers = fromToMessage[1].split(",");
	    	for(String receiver : receivers) {
	    		User to = getUserById(receiver);
	    		to.saveMessage(this, msg);
	    	}
	    	saveMessage(this, msg);
	    	return;
	    }
	    //this is a condition that becomes true when all the users are the receivers
	    if (fromToMessage[1].equals("all")) {
	        for (String userId : communicators.keySet()) {
	        	if(getUserById(fromToMessage[0]) == getUserById(userId)) {
	        		continue;
	        	}
	        	User to = getUserById(userId);
	            to.saveMessage(this, msg);
	        }
	    } 
	    //this condition is for sending and receiving messages p2p
	    else if (getUserById(fromToMessage[0]) != null && !fromToMessage[1].equals("all")) {
	        User to = getUserById(fromToMessage[1]);
	        if (to != null) {
	            to.saveMessage(this, msg);
	        }
	    }
	    saveMessage(this, msg);
	}
	
	private User getUserById(String id) {
		//A method that is given a str and that str is a key in the map;
		//which will be used to find the address of the receiver and return the address to the caller
	    for (Entry<String, User> entry : communicators.entrySet()) {
	        if (entry.getKey().equals(id)) {
	            return entry.getValue();
	        }
	    }
	    return null;
	}
	
	public void saveMessage(Center c, String msg) {
		//when there is any kind of message sending and receiving happening; it will be saved in a file
		
		String[] fromToMessage = msg.split(":");
		
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(new File(this + "" + ".txt"), true));
			
			pw.println(c.communicators.get(fromToMessage[0]) + " sent a message to "
					 + c.communicators.get(fromToMessage[1]) + " that says: ");
			pw.println("    " + fromToMessage[2]);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//it changes the address string to 
	public String toString() {
		return "Center";
	}
	
}