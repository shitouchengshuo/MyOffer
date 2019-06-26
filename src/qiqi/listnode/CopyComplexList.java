package qiqi.listnode;

public class CopyComplexList {
    static class Node {
        int value;
        Node next;
        Node sbiling;

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("value = " + value);
            sb.append(", next = " + (next == null ? "null" : next.value));
            sb.append(", sbiling = " + (sbiling == null ? "null" : sbiling.value));
            return sb.toString();
        }
    }

    /**
     * 复制节点，形成 A-A'-B-B'-C-C'
     * @param head
     */
    public static void copyList(Node head){
        Node node = head;
        while(node != null){
            Node copyNode = new Node();
            copyNode.value = node.value;
            copyNode.next = node.next;
            copyNode.sbiling = null;

            node.next = copyNode;
            node = copyNode.next;
        }
    }
    /**
     * 复制随机指针
     * @param head
     */
    public static void setSbiling(Node head){
        Node node = head;
        while(node != null){
            Node copyNode = node.next;
            if(node.sbiling != null){
                copyNode.sbiling = node.sbiling.next;
            }
            node = copyNode.next;
        }
    }

    /**
     * 分离链表 A-B-C     A'-B'-C'
     * @param head
     * @return
     */
    public static Node disConnectList(Node head){
            // 当链表为空就直接返回空
            if (head == null) {
                return null;
            }
            // 用于记录复制链表的头节点
            Node copyHead = head.next;
            // 用于记录当前处理的复制节点
            Node copyNode = copyHead;
            // 被复制节点的next指向下一个被复制节点
            head.next = copyHead.next;
            // 指向新的被复制节点
            head = head.next;
            while (head != null) {
                // pointer指向复制节点
                copyNode.next = head.next;
                copyNode = copyNode.next;
                // head的下一个指向复制节点的下一个节点，即原来链表的节点
                head.next = copyNode.next;
                // head指向下一个原来链表上的节点
                head = copyNode.next;
            }
            // 返回复制链表的头节点
            return copyHead;

    }

    public static Node copy(Node head){
        copyList(head);
        setSbiling(head);

        return disConnectList(head);
    }

    public static void main(String[] args) {

        Node head = new Node();
        head.value = 1;
        Node node2 = new Node();
        node2.value = 2;
        Node node3 = new Node();
        node3.value = 3;
        Node node4 = new Node();
        node4.value = 4;
        Node node5 = new Node();
        node5.value = 5;
        head.next = node2;
        head.sbiling = node3;
        node2.next = node3;
        node2.sbiling = node5;
        node3.next = node4;
        node4.next = node5;
        node4.sbiling = node2;
        Node copyHead = copy(head);
        Node node = copyHead;
        while(node != null){
            System.out.println(node);
            node = node.next;
        }
    }

}

