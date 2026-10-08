public class SortedLinkedList {

    private NodeType head;

    public SortedLinkedList() {
        head = null;
    } //constructor

    public int getLength() {
        int count = 0;
        NodeType current;
        current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    } //getLength

    public void insertItem(ItemType item) {
        NodeType newNode = new NodeType();
        newNode.info = item;
        newNode.next = null;

        // if empty, make new node the head
        if (head == null) {
            this.head = newNode;
            return;
        }

        //if it needs to inserted at the beginning
        if (item.compareTo(head.info) < 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        // general case
        NodeType current = head;
        while (current.next != null && item.compareTo(current.next.info) > 0) {
            current = current.next;
        } //iterating through linked list

        if (current.next != null && item.compareTo(current.next.info) == 0) {
            System.out.println("Item already exists");
            return;
        } //checks duplicates

        newNode.next = current.next;
        current.next = newNode;
    } //insertItem

    public void deleteItem(ItemType item) {
        // if the list is empty
        if (head == null) {
            System.out.println("You cannot delete from an empty list");
            return;
        }

        // if the item to be deleted is the head/only element
        if (item.compareTo(head.info) == 0) {
            head = head.next;
            return;
        }

        // general case
        NodeType current = head;
        NodeType previous = null;

        while (current != null && item.compareTo(current.info) != 0) {
            previous = current;
            current = current.next;
        }

        // if the item does not exist
        if (current == null) {
            System.out.println("The item is not present in the list");
            return;
        }

        // delete the node
        previous.next = current.next;
    } //deleteItem

    public int searchItem(ItemType item) {
        // Check if list is empty
        if (head == null) {
            System.out.println("The list is empty");
            return -1;
        }

        NodeType current = head;
        int index = 1;  // 1-indexed as per the spec

        while (current != null) {
            if (item.compareTo(current.info) == 0) {
                System.out.println("The item is present at index " + index);
                return index;  // Return index if item is found
            }
            current = current.next;
            index++;
        }

        System.out.println("Item is not present in the list");
        return -1;  // Return -1 if item is not found
    } //searchItem

    public void mergeList(SortedLinkedList otherList) {
        NodeType current1 = this.head;
        NodeType current2 = otherList.head;
        SortedLinkedList mergedList = new SortedLinkedList();

        // Traverse both lists and merge them
        while (current1 != null && current2 != null) {
            if (current1.info.compareTo(current2.info) < 0) {
                mergedList.insertItem(current1.info);  // Insert from list 1
                current1 = current1.next;
            } else if (current1.info.compareTo(current2.info) > 0) {
                mergedList.insertItem(current2.info);  // Insert from list 2
                current2 = current2.next;
            } else {
                // If they are equal, insert only one (to avoid duplicates)
                mergedList.insertItem(current1.info);
                current1 = current1.next;
                current2 = current2.next;
            }
        }

        // Insert remaining items from list 1, if any
        while (current1 != null) {
            mergedList.insertItem(current1.info);
            current1 = current1.next;
        }

        // Insert remaining items from list 2, if any
        while (current2 != null) {
            mergedList.insertItem(current2.info);
            current2 = current2.next;
        }

        // Make the current list the merged list
        this.head = mergedList.head;
    } //mergeList

    public void deleteAlternateNodes() {
        // If the list is empty or has only one node, nothing to delete
        if (head == null || head.next == null) {
            return;
        }

        NodeType current = head;

        // Traverse the list and delete alternate nodes
        // Skip first node, delete second, skip third, delete fourth, etc.
        while (current != null && current.next != null) {
            // The node to be deleted is current.next
            NodeType nodeToDelete = current.next;
            current.next = nodeToDelete.next;  // Bypass the node to delete it
            nodeToDelete = null;  // Optional: Help the garbage collector

            // Move to the next node to continue
            current = current.next;  // Skip to the next valid node
        }
    } //deleteAlternateNodes

    public SortedLinkedList intersection(SortedLinkedList otherList) {
        NodeType current1 = this.head;
        NodeType current2 = otherList.head;
        SortedLinkedList intersectedList = new SortedLinkedList();

        // Traverse both lists
        while (current1 != null && current2 != null) {
            if (current1.info.compareTo(current2.info) == 0) {
                // Add to the intersection list if values are equal
                intersectedList.insertItem(current1.info);
                current1 = current1.next;
                current2 = current2.next;
            } else if (current1.info.compareTo(current2.info) < 0) {
                current1 = current1.next;  // Move in the first list
            } else {
                current2 = current2.next;  // Move in the second list
            }
        }

        return intersectedList;  // Return the intersected list
    } //intersection

    // Print all elements in the list
    public void printList() {
        if (head == null) {
            System.out.println();  // Just print a newline if empty
            return;
        }

        NodeType current = head;
        while (current != null) {
            System.out.print(current.info.getValue() + " ");
            current = current.next;
        }
        System.out.println();  // Print a newline after printing all elements
    } //printList

} // SortedLinkedList
