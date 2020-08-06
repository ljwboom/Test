package com.ljw.linkedlist;


/**
 * @program: data-structure
 * @description: 单向链表
 * @author: linjw
 * @create: 2020-08-03 16:13
 */
public class SingleLinkedList {

    private HeroNode headNode = new HeroNode(0, "", "");


    /**
     * 插入链表节点
     *
     * @param newNode
     */
    public void add(HeroNode newNode) {
        HeroNode lastNode = headNode;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }

    /**
     * 按顺序插入单链表节点
     *
     * @param newNode
     */
    public void addByOrder(HeroNode newNode) {
        HeroNode temp = headNode;
        boolean isExist = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > newNode.no) {
                break;
            } else if (temp.next.no == newNode.no) {
                isExist = true;
                break;
            }
            temp = temp.next;
        }
        if (isExist) {
            System.out.printf("节点%s已经存在\n", newNode.no);
        } else {
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    //更新节点
    public void update(HeroNode updateNode) {
        HeroNode temp = headNode;
        boolean isExist = false;
        while (true) {
            if (temp == null) { //链表节点已经遍历完
                break;
            }
            if (temp.no == updateNode.no) {
                isExist = true;
                break;
            }
            temp = temp.next;
        }
        if (isExist) {
            temp.name = updateNode.name;
            temp.nickname = updateNode.nickname;
        } else {
            System.out.println("未查找到该节点");
        }
    }

    public void del(int no) {
        HeroNode temp = headNode;
        boolean isExist = false;
        while (true) {
            if (temp.next == null) { //遍历完所有节点
                break;
            }
            if (temp.next.no == no) { //因为是单向链表，需要找到删除节点的上一个节点
                isExist = true;
                break;
            }
            temp = temp.next;
        }
        if (isExist) {
            temp.next = temp.next.next;
        } else {
            System.out.println("删除节点不存在");
        }
    }

    //获取单链表的有效节点个数
    public int size() {
        HeroNode temp = headNode;
        int length = 0;
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 查找链表中倒数第K节点
     *
     * @param index
     * @return
     */
    public HeroNode findLastIndexNode(int index) {
        if (index > size() || index <= 0) {
            throw new RuntimeException("节点不存在");
        }
        HeroNode temp = headNode.next;
        for (int i = 0; i < size() - index; i++) {
            temp = temp.next;
        }
        return temp;
    }


    public void reverseList(HeroNode headNode){
        HeroNode temp = headNode.next;
        HeroNode reverseHead = new HeroNode(0,"","");
        while (temp != null){

        }
    }


    public void showList() {
        HeroNode cur = headNode.next;
        while (cur != null) {
            System.out.println(cur);
            cur = cur.next;
        }
    }


    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode heroNode1 = new HeroNode(1, "李白", "李太白");
        HeroNode heroNode2 = new HeroNode(2, "杜甫", "杜甫");
        HeroNode heroNode3 = new HeroNode(3, "白居易", "白居易");
/*        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode2);*/

        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode2);
        //展示链表
        singleLinkedList.showList();
        HeroNode updateNode = new HeroNode(6, "杜牧", "杜牧");
        singleLinkedList.update(updateNode);
        //展示链表
        System.out.println("修改后的节点数据");
        singleLinkedList.showList();
        //删除链表节点
        singleLinkedList.del(2);
        singleLinkedList.del(4);
        System.out.println("删除后的链表数据");
        singleLinkedList.showList();
        System.out.println("单链表有效节点个数=" + singleLinkedList.size());
        //找到倒数第K个节点
        System.out.println("这是倒数第k个节点"+singleLinkedList.findLastIndexNode(2));

    }

}


class HeroNode {

    public int no;

    public String name;

    public String nickname;

    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
