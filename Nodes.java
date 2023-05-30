public class Nodes {
    Node head; // Первичный элемент Node

    private static class Node {
        Node next; // ссылка на следующий элемент Node
        int value; // Значение элемента Node
    }

    // Добавляем новый элемент в начало. head смещается на 2-ую позицию.
    public void addFirstElement(int value) {
        Node newNode = new Node();
        newNode.value = value;
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
    }

    // Удаляем (обнуляем ссылку) на первый элемент. Второй смещается на первую.
    public void removeFirstElement() {
        if (head != null) {
            head = head.next;
        }
    }

    // Ищем значение в списке, перебирая все элементы до первого нужного значения.
    public boolean findElement(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value)
                return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    // Добавление элемента в конец списка
    public void addEndElement(int value) {
        Node newNode = new Node();
        newNode.value = value;
        if (head == null)
            head = newNode;
        else {
            Node lastNode = head;
            while (lastNode.next != null)
                lastNode = lastNode.next;
            lastNode.next = newNode;
        }
    }

    // Удалиение элемента с конца списка
    public void removeEndElement() {
        if (head != null) {
            Node preLastElement = head;
            while (preLastElement.next != null) {
                if (preLastElement.next.next == null) {
                    preLastElement.next = null;
                    return;
                }
                preLastElement = preLastElement.next;
            }
            head = null;
        }
    }

    // Разворот односвязного списка
    public void reverse() {
        if (head == null)
            return;

        Node currentNode = head;
        Node previousCurrentNode = null;
        Node nextCurrentNode = null;

        while (currentNode != null) {
            nextCurrentNode = currentNode.next;
            currentNode.next = previousCurrentNode;
            previousCurrentNode = currentNode;
            currentNode = nextCurrentNode;
        }
        head = previousCurrentNode;
    }
}