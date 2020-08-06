package com.ljw.linkedlist;

/**
 * @program: data-structure
 * @description: 双向链表
 * @author: linjw
 * @create: 2020-08-06 10:30
 */
public class DoubleLinkedListDemo {
}


class DoubleLinkedList{
    
}

class HeroNode2 {

    public int no;

    public String name;

    public String nickname;

    public HeroNode2 next; //指向下一个节点，默认为null

    public HeroNode2 pre; //指向前一个节点，默认为null

    public HeroNode2(int no, String name, String nickname) {
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
