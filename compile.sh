#1/bin/bash
set -x

javac -d bin src/ItemType.java
javac -d bin -cp bin src/NodeType.java
javac -d bin -cp bin src/SortedLinkedList.java
javac -d bin -cp bin src/LinkedListDriver.java
java -cp bin LinkedListDriver input.txt
