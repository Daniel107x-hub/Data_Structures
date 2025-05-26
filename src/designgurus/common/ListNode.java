package designgurus.common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val){
        this.val = val;
    }

    public ListNode(int val, ListNode next){
        this(val);
        this.next = next;
    }

    @Override
    public String toString(){
        return this.val +
                " -> " +
                (this.next == null ? "NIL" : this.next);
    }
}
