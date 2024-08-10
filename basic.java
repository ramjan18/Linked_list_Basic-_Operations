public class basic{
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public static void addFirst(int data){
        //create a new node
        Node newNode = new Node(data);
        size++;

        if(head==null){
            head=tail=newNode;
            
            return;
            
        }

        //link
        newNode.next=head;

        //update head
        head=newNode;
        
    }

    public static void addLast(int data){
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }

        //link
        tail.next = newNode;

        //update tail
        tail=newNode;
    }

    public static void addMiddle(int idx, int data){
        if(idx ==0 ){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp=head;
        int i=0;
        while(i < idx-1){
            temp = temp.next;
            i++;
        }

        //insert node into list
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public static void removeFirst(){
        if (head == null) {
            System.out.println("linked list is null");
            return;
        }

        if(head == tail){
            head = tail = null;
            size--;
            return;
        }

        
        head = head.next;
        
        size--;


    }
    
    public static void removeLast(){
        if(size == 0){
            System.out.println("List is empty");
            return;
        }
        if(size == 1){
            head = tail = null;
            size =0;
            return;
        }

        Node temp = head;
        for(int i = 0;i<size-2;i++){
            temp=temp.next;
        }

        temp.next=null;
        tail = temp ;
        size --;
    }
     
    public static int searchElement(int element){
        Node temp = head;

        for(int i=0;i<size;i++){
            if(temp.data == element){
                return i;
            }
            temp = temp.next;
        }

        return -1;
    }

    public static int helper(Node head , int key){
        //base condition
        if(head == null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }

        int idx = helper(head.next,key);
        if(idx == -1){

            return -1;
        }

        return idx+1;
    }

    public static int recSearch(int key){
    int idx = helper(head,key);
    if(idx == -1){
        System.out.println("key not found");
        return idx;
    }

    return idx;
    }

    public static void reverseList(){
        Node prev=null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }


    public static void removeFromEnd(int idx){
        Node temp = head;
        for (int i=0;i< size - idx-1 ;i++){
            temp = temp.next;
        }
        Node del = temp.next;
        temp.next = del.next;
    }

    public static void printList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String []args){
        basic ll=new basic();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(6);
        ll.addLast(7);
        ll.addMiddle(4,5);
        ll.addMiddle(0,0);
        ll.addLast(8);
        ll.printList();
        ll.removeFirst();

        ll.printList();
        ll.removeLast();
        ll.printList();
        ll.removeFromEnd(1);
        ll.printList();
        // System.out.println("index is =>" + ll.searchElement(1)) ;
        ll.reverseList();
        ll.printList();
        System.out.println("index is =>" + ll.recSearch(6));
        
        
        System.out.println("size -> " +  ll.size);
    }
}