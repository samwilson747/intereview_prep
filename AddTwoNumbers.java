class AddTwoNumbers{
   /*
   Add LinkedList Integers represented in reverse order
   ex:
   Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
   Output: 7 -> 0 -> 8

   (342 + 465 = 807)
   */
   public class ListNode{
      int val;
      ListNode next;
      public ListNode(int val){
         this.val = val;
      }
   }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      //if a list is empty, return the other (a+0 = a)
        if(l1.val == 0) return l2;
        if(l2.val == 0) return l1;

        ListNode dummy_head = l1; //maintains connection to return list
        ListNode prev = dummy_head;
        int carry = 0; //binary value to indicate if previous operation > 10
        while(l1!=null && l2!=null) {
            int sum = (l1.val + l2.val + carry);
            l1.val = sum%10; //current value will never be over 10
            if(sum>=10) //indicate need for carry in next operation
               carry = 1;
            else
               carry = 0;
            prev = l1; //maintain connection to previous element for final carry case
            l1=l1.next;l2=l2.next; //increment place in both linked lists
        }
        if(carry ==1) prev.next = new ListNode(1); //ensures last carry value is accounted for
        //return pointer to head of altered list
        return dummy_head;
    }
}
