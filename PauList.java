public class PauList<ContentType> {

    private class ListNode {
        private ContentType content = null;
        private ListNode nextNode = null;
        public ListNode(ContentType pContent) {
            content = pContent;
            nextNode = null;
        }

        public void setNext(ListNode pNext) {
            nextNode = pNext;
        }

        public ListNode getNext() {
            return nextNode;
        }

        public ContentType getContent() {
            return content;
        }

        public void setContent(ContentType pContent) {
            content = pContent;
        }
    }

    private ListNode head;
    private ListNode tail;
    private ListNode current;

    public PauList() {
        head = null;
        tail = null;
        current = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean hasAccess() {
        return current != null;
    }

    public void toFirst() {
        current = head;
    }

    public void toLast() {
        current = tail;
    }

    public void next() {
        if(hasAccess()){
            current = current.getNext();
        }
    }

    public ContentType getContent() {
        if(hasAccess()){
            return current.getContent();
        }
        else{
            return null;
        }
    }

    public void setContent(ContentType pContent) {
        if(hasAccess() && pContent != null){
            current.setContent(pContent);
        }
    }

    public void append(ContentType pContent) {
        if (pContent == null){
            return;
        }
        
        ListNode newNode = new ListNode(pContent);
        if (this.isEmpty()){
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }
    
    public void insert(ContentType pContent){
        if(pContent == null){
            return;
        }
        if(!hasAccess()){
            if(isEmpty()){
               append(pContent); 
            }
            return;
        }
        
        ListNode newNode = new ListNode(pContent);
        if(current == head){
            head = newNode;
            newNode.setNext(current);
        }
        else{
            ListNode prev = head;
            while(prev.getNext() != current){
                prev = prev.getNext();
            }
            prev.setNext(newNode);
            newNode.setNext(current);
        }
    }
    
    public void remove(){
        if(!hasAccess()){
            return;
        }
        if(head == tail){
            head = null;
            tail = null;
            current = null;
            return;
        }
        if(current == head){
            current = current.getNext();
            head = current;
            return;
        }
        
        ListNode prev = head;
        while(prev.getNext() != current){
            prev = prev.getNext();
        }
        prev.setNext(current.getNext());
        if(current == tail){
            current = prev;
            tail = prev;
        }
        else{
            current = current.getNext();
        }
    }
    
    public void concat(PauList<ContentType> lst){
        if(lst == null){
            return;
        }
        lst.toFirst();
        while(lst.hasAccess()){
            this.append(lst.getContent());
            lst.next();
        }
    }
}
