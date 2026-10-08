ncb10741@uga.edu
CSCI 2720 - Assignment 1: Sorted Linked List

Student: Nathan Chance Brown
Email: ncb10741@uga.edu

COMPILATION/RUN:
javac -d bin src/ItemType.java
javac -d bin -cp bin src/NodeType.java
javac -d bin -cp bin src/SortedLinkedList.java
javac -d bin -cp bin src/LinkedListDriver.java
java -cp bin LinkedListDriver input.txt

FEATURES:
- Insert values while maintaining sorted order
- Delete values from the list
- Search for values (returns 1-indexed position)
- Merge two lists (removes duplicates)
- Find intersection of two lists
- Delete alternate nodes
- Print the list
- Show list length

COMPLEXITY:
Merge: O(m + n) - traverse both lists once
Intersection: O(m + n) - traverse both lists once
