package pt.pa.adts;

import java.util.List;

/**
 * TODO: Fornecer documentação da classe.
 *
 * @param <E>
 */
public class QueueLinkedList<E> implements Queue<E> {

    private ListNode header, trailer;
    private int size;
    private class ListNode {
        private E element;
        private ListNode next;
        private ListNode prev;

        public ListNode(E element, ListNode prev, ListNode next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
    public QueueLinkedList() {

        header = new ListNode(null,null,null);
        trailer = new ListNode(null,header,null);

        this.size = 0;
        header.next = trailer;

    }

    @Override
    public E enqueue(E e) {
        try {
            ListNode newNode = new ListNode(e,trailer.prev,trailer);
            /**ListNode curEnd = trailer.prev;

            newNode.element = e;
            newNode.next = trailer;
            newNode.prev = curEnd;

            trailer.prev = newNode;
            curEnd.next = newNode;

    */
            newNode.prev.next = trailer.prev = newNode;
            trailer.prev = newNode;
            size++;

        }catch(OutOfMemoryError outOfMemoryError){
            System.out.println(outOfMemoryError.getMessage());
        }

        return e;
    }

    @Override
    public E dequeue() {
        //if(isEmpty()){return throw new QueueExcepetion("vazio");}


        ListNode nodeToRemove = header.next;

        header.next = header.next.next;
        header.next.prev = header.next;

        size--;

        return nodeToRemove.element;
    }

    @Override
    public E front() {
        return header.next.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void clear() {
        header.next = trailer;
        trailer.prev = header;
        size=0;
    }

    //TODO: implementar métodos da interface à custa da estrutura de dados fornecida

}
