package finalExam.messagingSystem;

public class MessagingSystem {
	
	// This class contains the main method of the whole classes.
	// This class' functionality is creating the users(communicators) then allowing them to send messages as they like.

	public static void main(String[] args) {
		
		// Access the singleton instance of Center. took me hours to figure this out
		Center center = Center.getInstance(); 
		
		// Creating Users
		Car car = new Car();
		Cat cat = new Cat();
		Cup cup = new Cup();
		Cloud cloud = new Cloud();
		Cloud cloud2 = new Cloud();
		
		
		// To show the list of the users
		center.showUsersList();
		
		// Send Message from individual to another individual user
		car.sendMessage(center, "1:2:Hello my lovely cat!");
		cloud.sendMessage(center, "4:3:Testing");
		cat.sendMessage(center, "2:1:Meow meow...");
		
		// Sending Message to specific group 
		cloud2.sendMessage(center, "5:1,2:Let the cat in then drive");
		
		// Sending Message that has a random quote.
		cup.sendMessage(center, "3:4:" + cup.getRandomQuote());
		
		// Send Message from an individual communicator to everyone
		car.sendMessage(center, "1:all:Come on get in lets go");
		
	}

}


