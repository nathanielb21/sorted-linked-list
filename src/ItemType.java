public class ItemType {

    private int value;

    public ItemType(int num) {
        this.value = num;
    } //construcutor

    int getValue() {
        return this.value;
    } //getValue

    int compareTo(ItemType item) {
        if (this.value < item.getValue()) {
            return -1;
        } //new item is of less value

        if (this.value == item.getValue()) {
            return 0;
        } //items are of the same value

        else {
            return 1;
        } //new item is of greater value
    } //compareTo

} //ItemType
