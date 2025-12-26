package pack;
import java.util.*;
    public class MainMenu {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            ArrayChat arrayChat = new ArrayChat();
            LinkedListChat linkedChat = new LinkedListChat();

            while (true) {
                System.out.println("1. Array Chat System");
                System.out.println("2. LinkedList Chat System");
                System.out.println("3. Exit");
                System.out.print("Choose: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        arrayMenu(arrayChat, sc);
                        break;

                    case 2:
                        linkedListMenu(linkedChat, sc);
                        break;

                    case 3:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid option!");
                }
            }
        }

        public static void arrayMenu(ArrayChat chat, Scanner sc) {

            while (true) {
                System.out.println("\n--- Array Chat Menu ---");
                System.out.println("1. Send Message");
                System.out.println("2. Edit Last Message");
                System.out.println("3. Delete Message");
                System.out.println("4. View Messages");
                System.out.println("5. Search Message");
                System.out.println("6. Back");
                System.out.print("Choose: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Sender ID: ");
                        int sender = sc.nextInt();
                        System.out.print("Receiver ID: ");
                        int receiver = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Message: ");
                        String text = sc.nextLine();
                        chat.sendMessage(sender, receiver, text);
                        break;

                    case 2:
                        System.out.print("Sender ID: ");
                        int editSender = sc.nextInt();
                        sc.nextLine();
                        System.out.print("New Message: ");
                        String newText = sc.nextLine();
                        chat.editLastMessage(editSender, newText);
                        break;

                    case 3:
                        System.out.print("Message Index to Delete: ");
                        int index = sc.nextInt();
                        chat.deleteMessage(index);
                        break;

                    case 4:
                        System.out.print("Enter ID to Display Messages of User: ");
                        int user = sc.nextInt();
                        chat.viewMessages(user);
                        break;

                    case 5:
                        System.out.print("Enter keyword: ");
                        String keyword = sc.nextLine();
                        chat.searchMessages(keyword);
                        break;

                    case 6:
                        return;

                    default:
                        System.out.println("Invalid option!");
                }
            }
        }


        public static void linkedListMenu(LinkedListChat chat, Scanner sc) {

            while (true) {
                System.out.println("\n--- LinkedList Chat Menu ---");
                System.out.println("1. Send Message");
                System.out.println("2. Edit Last Message");
                System.out.println("3. Delete Message");
                System.out.println("4. View Messages");
                System.out.println("5. Search Message");
                System.out.println("6. Back to Main Menu");
                System.out.print("Choose: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Sender ID: ");
                        int sId = sc.nextInt();
                        System.out.print("Receiver ID: ");
                        int rId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Message: ");
                        String text = sc.nextLine();
                        chat.sendMessage(sId, rId, text);
                        break;

                    case 2:
                        System.out.print("Sender ID: ");
                        int editId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("New Message Text: ");
                        String newText = sc.nextLine();
                        chat.editLastMessage(editId, newText);
                        break;

                    case 3:
                        System.out.print("Message Index to Delete: ");
                        int index = sc.nextInt();
                        chat.deleteMessage(index);
                        break;

                    case 4:
                        chat.viewMessages();
                        break;

                    case 5:
                        System.out.print("Keyword: ");
                        String keyword = sc.nextLine();
                        chat.searchMessages(keyword);
                        break;

                    case 6:
                        return;

                    default:
                        System.out.println("Invalid option!");
                }
            }
        }
    }

