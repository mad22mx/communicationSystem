# Communication System

A messaging system where different users can communicate with each other. The main components of the system are:

- **Center class:** Acts as the central hub for registering and storing users.
- **User interface:** Defines the behavior of users in the system.

Each user (e.g., Car, Cat, Cloud, and Cup) implements the User interface with unique characteristics.

### Center Class

The Center class maintains a map of registered users, providing methods for:

- Adding users
- Displaying the user list
- Sending messages between users
- Handling message storage in text files

The IDGenerator class ensures each user receives a unique ID upon registration. The primary data structure is a HashMap, where unique user IDs serve as keys, and user objects are values, enabling efficient user lookup.

### User Interface

The User interface defines methods like `sendMessage`, `saveMessage`, and `getRandomQuote`, implemented by user classes. These methods enable users to:

- Send messages to other users
- Save received messages
- Retrieve random quotes

Each user has a unique ID, communicating with others through the Center class. Messages exchanged are stored in text files for record-keeping.

Overall, this code creates a messaging system facilitating user interaction through message exchange, with the Center class managing communication and message storage.

