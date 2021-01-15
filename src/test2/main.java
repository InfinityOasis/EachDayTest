package test2;

public class main {
    public static void main(String[] args) {
        ListNode l13 = new ListNode(3,null);
        ListNode l12 = new ListNode(4,l13);
        ListNode l1 = new ListNode(2,l12);
        ListNode l23 = new ListNode(4,null);
        ListNode l22 = new ListNode(6,l23);
        ListNode l2 = new ListNode(5,l22);

        ListNode k = new Solution().addTwoNumbers(l1,l2);

        while(true){
            System.out.print(k.val+" ");
            k= k.next;
            if (k==null)
                break;
        }
    }
}

/**
 * Definition for singly-linked list.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //存放答案链表
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        //进位
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            //这里为了判断l1和l2的长度不一致时，要补0
            int l1val = l1 != null ? l1.val : 0;
            int l2val = l2 != null ? l2.val : 0;
            //相加
            int sum = l1val + l2val + carry;
            //判断是否有进位，两种写法都可以
            //carry = sum > 9 ? 1 : 0;
            carry = sum / 10;
            //用答案链表指向对的答案即可
            ListNode sumNode = new ListNode(sum % 10);
            cursor.next = sumNode;
            cursor = sumNode;
            //判空，继续往下走
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        //返回即可
        return root.next;
    }
}