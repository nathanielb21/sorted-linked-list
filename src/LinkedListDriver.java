import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinkedListDriver {
    public static void main(String[] args) {
        // Check if a filename is passed as a command-line argument
        if (args.length != 1) {
            System.out.println("Usage: java LinkedListDriver <input-file>");
            return;
        }

        String filename = args[0];
        SortedLinkedList list = new SortedLinkedList();  // Create an empty sorted linked list

        // Read the file and insert values into the sorted linked list
        try {
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);

            // Read integers from the file
            while (fileScanner.hasNextInt()) {
                int value = fileScanner.nextInt();
                ItemType item = new ItemType(value);
                list.insertItem(item);
            }

            fileScanner.close();  // Close the file scanner
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found");
            return;
        }

        // Start the command-line interface for user interaction
        Scanner scanner = new Scanner(System.in);
        char command = ' ';
        boolean firstRun = true;

        do {
            if (firstRun) {
                printMenu();  // Show the menu options only once at the beginning
                firstRun = false;
            }

            System.out.print("Enter a command: ");
            String input = scanner.next();

            // Check if input is valid
            if (input.length() == 0) {
                System.out.println("Invalid command, try again!");
                continue;
            }

            command = input.charAt(0);

            switch (command) {
            case 'i':  // Insert value
                System.out.print("Enter a number to insert: ");
                int insertValue = scanner.nextInt();
                ItemType insertItem = new ItemType(insertValue);
                System.out.print("Original list : ");
                list.printList();
                list.insertItem(insertItem);
                System.out.print("New list : ");
                list.printList();
                break;

            case 'd':  // Delete value
                System.out.print("Enter a number to delete: ");
                int deleteValue = scanner.nextInt();
                ItemType deleteItem = new ItemType(deleteValue);
                System.out.print("Original list : ");
                list.printList();
                list.deleteItem(deleteItem);
                System.out.print("New list : ");
                list.printList();
                break;

            case 's':  // Search value
                System.out.print("Enter a number to search: ");
                int searchValue = scanner.nextInt();
                ItemType searchItem = new ItemType(searchValue);
                System.out.print("Original list : ");
                list.printList();
                list.searchItem(searchItem);
                break;

            case 'a':  // Delete alternate nodes
                System.out.print("Original list: ");
                list.printList();
                list.deleteAlternateNodes();
                System.out.print("New list: ");
                list.printList();
                break;

            case 'm':  // Merge lists
                System.out.print("Enter the length of the new list: ");
                int mergeLength = scanner.nextInt();
                System.out.print("Enter the numbers: ");
                SortedLinkedList otherList = new SortedLinkedList();

                for (int i = 0; i < mergeLength; i++) {
                    int value = scanner.nextInt();
                    ItemType mergeItem = new ItemType(value);
                    otherList.insertItem(mergeItem);
                }

                System.out.print("list 1: ");
                list.printList();
                System.out.print("list 2: ");
                otherList.printList();
                list.mergeList(otherList);
                System.out.print("Merged list: ");
                list.printList();
                break;

            case 't':  // Find intersection
                System.out.print("Enter the length of the new list: ");
                int intersectLength = scanner.nextInt();
                System.out.print("Enter the numbers ");
                SortedLinkedList intersectList = new SortedLinkedList();

                for (int i = 0; i < intersectLength; i++) {
                    int value = scanner.nextInt();
                    ItemType intersectItem = new ItemType(value);
                    intersectList.insertItem(intersectItem);
                }

                System.out.print("list 1: ");
                list.printList();
                System.out.print("list 2: ");
                intersectList.printList();
                System.out.print("Intersection of lists: ");
                SortedLinkedList intersectionResult = list.intersection(intersectList);
                intersectionResult.printList();
                break;

            case 'p':  // Print all elements in the list
                System.out.print("The list is: ");
                list.printList();
                break;

            case 'l':  // Print the length of the list
                System.out.println("The length of the list is " + list.getLength());
                break;

            case 'q':  // Quit the program
                System.out.println("Exiting the program…");
                break;

            default:
                System.out.println("Invalid command, try again!");
                break;
            }

        } while (command != 'q');  // Keep running until the user quits

        scanner.close();  // Close the scanner
    }

    // Method to print the command menu
    public static void printMenu() {
        System.out.println("Commands:");
        System.out.println("(i) - Insert value");
        System.out.println("(d) - Delete value");
        System.out.println("(s) - Search value");
        System.out.println("(a) - Delete alternate nodes");
        System.out.println("(m) - Merge lists");
        System.out.println("(t) - Find intersection");
        System.out.println("(p) - Print list");
        System.out.println("(l) - Print length");
        System.out.println("(q) - Quit program");
    }
}
