package SingLinkedList;

/**
 * @author pengjw
 * @date 2019年04月16日 10:39
 * @description 单向链表的增删改查
 * @Version 1.0
 */

public class singLinkd {
    Node head = null;

    class Node {
        private Node next;
        private int data;

        //构造方法
        private Node(int data) {
            this.data = data;
        }
    }

    /**
     * @param data
     * @return void
     * @author pengjw
     * @date 2019/4/16 15:01
     * @description 单向链表尾部添加节点
     */
    public void addNode(int data) {
        Node newNode = new Node(data);
        //head为空也就是第一个节点
        if (head == null) {
            head = newNode;
            return;
        }
        //不是第一个元素，需要从head遍历开始，得到最后一个节点
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        //节点下个指向为空时，直接赋值
        temp.next = newNode;
    }

    /**
     * @param index
     * @param data
     * @return void
     * @author pengjw
     * @date 2019/4/16 20:39
     * @description 在节点中间添加节点
     */
    public Boolean addNodeByIndex(int index, int data) {
        Node newNode = new Node(data);
        //判断下标是否超出
        if (index < 0 || index > (length() + 1)) {
            return false;
        }
        // 添加的是第一个节点
        if (head == null) {
            head = newNode;
            return true;
        }
        //得到最后一个节点，并赋值

        if (index == (length() + 1)) {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            return true;
        } else {
            //在中间添加节点,先得到节点的上一个节点个下一个节点
            int preIndex = index;
            int endIndex = index + 1;
            int i = 1;
            int j = 1;
            Node pre = head;
            while (preIndex != i) {
                i++;
                pre = pre.next;
            }
            Node end = head;
            while (endIndex != j) {
                j++;
                end = end.next;
            }
            pre.next = newNode;
            newNode.next = end;
            return true;
        }

    }

    /**
     * @param index
     * @return void
     * @author pengjw
     * @date 2019/4/16 15:01
     * @description 删除知道节点位置的节点
     */
    public Boolean deleteNode(int index) {
        //判断下标是否超出
        if (index < 0 || index > length()) {
            return false;
        }
        if (index == 1) {
            head = head.next;
            return true;
        }
        int i = 2;
        Node preNode = head;
        Node curNode = head.next;
        while (curNode.next != null) {
            if (index == 1) {
                return false;
            } else if (i == index) {
                preNode.next = curNode.next;
                return true;
            } else {
                i++;
                preNode = curNode;
                curNode = curNode.next;
            }
        }
        return false;
    }

    /**
     * @param node
     * @return java.lang.Boolean
     * @author pengjw
     * @date 2019/4/16 17:08
     * @description 在不知道头指针的情况下删除指定节点
     */
    public Boolean deleteNodeByData(Node node) {
        if (node == null || node.next == null) {
            return false;
        }
        int temp = node.data;
        node.data = node.next.data; //当前节点赋值成下个节点的值
        // node.next.data=temp;    //可以图就ok
        node.next = node.next.next;
        System.out.println("头结点未知，删除成功！");
        return true;
    }

    /**
     * @return int
     * @author pengjw
     * @date 2019/4/16 17:06
     * @description 获取节点的长度
     */
    private int length() {
        int length = 1;
        if (head == null) {
            return length;
        }
        Node temp = head;
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        System.out.println("链表长度为：" + length);
        return length;
    }

    //链表遍历
    public void printList() {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data + "-->");
            tmp = tmp.next;
        }
        System.out.print("null");

    }

    /**
     * @param head
     * @param length
     * @return SingLinkedList.singLinkd.Node
     * @author pengjw
     * @date 2019/4/17 16:49
     * @description 链表排序
     */
    public Node sortNode(Node head, int length) {
        if (head == null || head.next == null) {
            return head;
        }
        for (int i = 0; i < length - 1; i++) {
            Node curNode = head;
            for (int j = 0; j < length - i - 1; j++) {
                if ((curNode.data > curNode.next.data)) {
                    int temp = curNode.data;
                    curNode.data = curNode.next.data;
                    curNode.next.data = temp;
                }
                curNode = curNode.next;
            }
            //System.out.println("第"+i+"次排序后":head);

        }


        return head;
    }


    public static void main(String[] args) {
        singLinkd list = new singLinkd();
        list.addNode(6);
        list.addNode(5);
        list.addNode(4);
        list.addNode(3);
        list.addNode(2);
        list.addNode(1);
        //System.out.println("linkLength:" + list.length());
        // System.out.println("head.data:" + list.head.data);
        list.printList();
        // list.deleteNode(3);
        //list.deleteNodeByData(new Node("4"));
        //System.out.println("After deleteNode(3):");
        //list.deleteNode(3);
        //list.addNodeByIndex(6,7);
        System.out.println("排序后.........");
        list.sortNode(list.head, list.length());
        list.printList();
    }
}
