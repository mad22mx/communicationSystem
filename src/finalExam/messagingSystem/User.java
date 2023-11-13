package finalExam.messagingSystem;
	
public interface User {
	// This interface is implemented by all communicators inorder to access them when sending messages and
	//to implement the methods below that are the same across all communicators
	public void sendMessage(Center c, String msg);
	public void saveMessage(Center c, String msg);
	public String getRandomQuote();
}