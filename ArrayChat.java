package pack;

public class ArrayChat {

        private Message[] messages;
        private int messageCount;
        private static final int MAX_MESSAGES = 1000;

        public ArrayChat() {
            messages = new Message[MAX_MESSAGES];
            messageCount = 0;
        }

        // Send message
        public void sendMessage(int senderId, int receiverId, String text) {
            if (messageCount >= MAX_MESSAGES) {
                System.out.println("Message limit reached!");
                return;
            }

            messages[messageCount++] = new Message(senderId, receiverId, text);
            System.out.println("Message sent successfully.");
        }
        public void displayMessageBetweenID(int user){
            for(int i=0;i<messageCount;i++){
                if(messages[i].senderId==user){
                    System.out.println();
                }
            }
        }
        // Edit last message sent by sender
        public void editLastMessage(int senderId, String newText) {
            for (int i = messageCount - 1; i >= 0; i--) {
                if (!messages[i].deleted && messages[i].senderId == senderId) {
                    messages[i].text = newText;
                    System.out.println("Last message edited successfully.");
                    return;
                }
            }
            System.out.println("No message found to edit.");
        }

        // Lazy deletion
        public void deleteMessage(int index) {
            if (index < 0 || index >= messageCount) {
                System.out.println("Invalid message index.");
                return;
            }

            if (messages[index].deleted) {
                System.out.println("Message already deleted.");
                return;
            }

            messages[index].deleted = true;
            System.out.println("Message deleted successfully.");
        }

        // View all messages
        public void viewMessages(int user) {
            if (messageCount == 0) {
                System.out.println("No messages available.");
                return;
            }

            for (int i = 0; i < messageCount; i++) {
                if(messages[i].senderId==user){
                    if (!messages[i].deleted) {
                        System.out.println(
                                "[" + i + "] From User " + messages[i].senderId +
                                        " to User " + messages[i].receiverId +
                                        ": " + messages[i].text
                        );
                    }
                }
            }
        }

        // Keyword search
        public void searchMessages(String keyword) {
            boolean found = false;

            for (int i = 0; i < messageCount; i++) {
                if (!messages[i].deleted && messages[i].text.contains(keyword)) {
                    System.out.println(
                            "[" + i + "] From User " + messages[i].senderId +
                                    " to User " + messages[i].receiverId +
                                    ": " + messages[i].text
                    );
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No messages found with keyword: " + keyword);
            }
        }
}

