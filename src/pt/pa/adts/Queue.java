package pt.pa.adts;

/**
 * TODO: Fornecer documentação da interface.
 *
 * @param <E>
 */
public interface Queue<E> {

        E enqueue( E e);
        E dequeue();
        E front();
        int size();
        boolean isEmpty();
        void clear();
}
