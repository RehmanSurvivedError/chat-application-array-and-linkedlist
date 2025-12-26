package pack;

public class Message {

        int senderId;
        int receiverId;
        String text;
        boolean deleted;

        public Message(int senderId, int receiverId, String text) {
            this.senderId = senderId;
            this.receiverId = receiverId;
            this.text = text;
            this.deleted = false;
        }
}
