package pack;

public class LinkedListChat {
        private Node head;
        private Node tail;
        private int messageCount;

        public LinkedListChat() {
            head = null;
            tail = null;
            messageCount = 0;
        }

        // SEND MESSAGE (append at tail)
        public void sendMessage(int senderId, int receiverId, String text) {
            Message msg = new Message(senderId, receiverId, text);
            Node newNode = new Node(msg);

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            messageCount++;
            System.out.println("Message sent successfully.");
        }

        // EDIT LAST MESSAGE OF SENDER ONLY
        public void editLastMessage(int senderId, String newText) {
            Node current = head;
            Node lastNode = null;

            while (current != null) {
                if (current.data.senderId == senderId) {
                    lastNode = current;
                }
                current = current.next;
            }

            if (lastNode != null) {
                lastNode.data.text = newText;
                System.out.println("Last message edited successfully.");
            } else {
                System.out.println("No message found to edit.");
            }
        }

        // DELETE MESSAGE BY INDEX (NODE SKIP METHOD)
        public void deleteMessage(int index) {

            if (index < 0 || index >= messageCount) {
                System.out.println("Invalid message index.");
                return;
            }

            if (index == 0) {
                head = head.next;
                if (head == null) {
                    tail = null;
                }
                messageCount--;
                System.out.println("Message deleted successfully.");
                return;
            }

            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }

            Node toDelete = prev.next;
            prev.next = toDelete.next;

            if (toDelete == tail) {
                tail = prev;
            }

            messageCount--;
            System.out.println("Message deleted successfully.");
        }

        // VIEW ALL MESSAGES
        public void viewMessages() {
            if (head == null) {
                System.out.println("No messages to display.");
                return;
            }

            Node current = head;
            int index = 0;

            while (current != null) {
                Message msg = current.data;
                System.out.println(index + ". From " + msg.senderId +
                        " to " + msg.receiverId + ": " + msg.text);
                current = current.next;
                index++;
            }
        }

        // SEARCH MESSAGES BY KEYWORD
        public void searchMessages(String keyword) {
            Node current = head;
            int index = 0;
            boolean found = false;

            while (current != null) {
                if (current.data.text.toLowerCase().contains(keyword.toLowerCase())) {
                    System.out.println(index + ". From " + current.data.senderId +
                            " to " + current.data.receiverId + ": " + current.data.text);
                    found = true;
                }
                current = current.next;
                index++;
            }

            if (!found) {
                System.out.println("No messages found with keyword: " + keyword);
            }
        }
}

