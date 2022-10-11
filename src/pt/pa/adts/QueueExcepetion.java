package pt.pa.adts;

public class QueueExcepetion extends RuntimeException  {
    public QueueExcepetion() {
        super("Queue FUll");
    }


    public QueueExcepetion(String message) {
        super(message);
    }
}
