package org.songdan.leetcode.easy;

/**
 * 合并2个有序链表
 * @author: Songdan
 * @create: 2020-05-01 15:29
 **/
public class MergeTwoList {


    public ListNode merge(ListNode l1,ListNode l2) {
        if(l1==null && l2==null){
            return null;
        }
        if(l1==null && l2!=null){
            return l2;
        }
        if(l2==null && l1!=null){
            return l1;
        }
        ListNode mergeNode = null;
        ListNode current = mergeNode;
        while(l1!=null && l2!=null){
            int val;
            if(l1.val>l2.val){
                val = l2.val;
                l2 = l2.next;
            }else{
                val = l1.val;
                l1 = l1.next;
            }
            ListNode node = new ListNode(val);
            if(current==null){
                current = node;
                mergeNode = current;
            }else{
                current.next = node;
                current = current.next;
            }
        }
        if(l1!=null){
            current.next = l1;
        }
        if(l2!=null){
            current.next = l2;
        }
        return mergeNode;
    }

    public ListNode mergeRecursive(ListNode l1,ListNode l2) {
        if(l1==null && l2==null){
            return null;
        }
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        int val;
        if(l1.val>l2.val){
            val = l2.val;
            l2 = l2.next;
        }else{
            val = l1.val;
            l1 = l1.next;
        }
        ListNode mergeNode = new ListNode(val);
        mergeNode.next = mergeRecursive(l1, l2);
        return mergeNode;
    }

    class ListNode{

        int val;
        ListNode next;
        ListNode(int x) { val = x; }

    }

}
