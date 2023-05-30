public class doubleNodes {
    doubleNode head; // Первичный элемент Node
    doubleNode tail; // Конечный элемент Node

    private static class doubleNode {
        doubleNode next; // ссылка на следующий элемент Node
        doubleNode previous; // ссылка на предыдущий элемент Node
        int value; // Значение элемента Node
    }

    // Добавляем новый элемент в начало. head смещается на 2-ую позицию.
    public void addFirstElement(int value) {
        doubleNode newNode = new doubleNode();
        newNode.value = value;
        if (head != null) {
            newNode.next = head;
            head.previous = newNode;
        } else
            tail = newNode;
        head = newNode;
    }

    // Удаляем (обнуляем ссылку) на первый элемент. Второй смещается на первую.
    public void removeFirstElement() {
        if (head != null && head.next != null) {
            head = head.next;
            head.previous = null;
        } else {
            head = null;
            tail = null;
        }
    }

    // Ищем значение в списке, перебирая все элементы до первого нужного значения.
    public boolean findElement(int value) {
        doubleNode currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    // Добавление элемента в конец списка
    public void addEndElement(int value) {
        doubleNode newNode = new doubleNode();
        newNode.value = value;
        if (head == null) {
            head = newNode;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
        }
        tail = newNode;
    }

    // Удалиение элемента с конца списка
    public void removeEndElement() {
        if (tail != null && tail.previous != null) {
            tail = tail.previous;
            tail.next = null;
        } else {
            head = null;
            tail = null;
        }
    }

    // Сортировка пузырьком от меньшего к большему
    public void bubbleSort() {
        boolean flag = true;
        while (flag) {
            flag = false;
            doubleNode item = head;
            while (item != null && item.next != null) {
                if (item.value > item.next.value) {
                    int temp = item.value;
                    item.value = item.next.value;
                    item.next.value = temp;
                    flag = true;
                }
                item = item.next;
            }
        }
    }

    // Разворот двусвязного списка
    public void reverse() {
        if (head == null)
            return;

        doubleNode currentNode = head;
        doubleNode nextCurrentNode = null;
        doubleNode previousCurrentNode = null;

        while (currentNode != null) {
            nextCurrentNode = currentNode.next;
            currentNode.next = previousCurrentNode;
            currentNode.previous = nextCurrentNode;
            previousCurrentNode = currentNode;
            currentNode = nextCurrentNode;
        }

        currentNode = head;
        head = tail;
        tail = currentNode;
    }
}
