package ClassesExtra.TADQueue;
public class Queue <T> {
    private QueueNode<T> first;
    private QueueNode<T> last;

    public boolean isEmpty(){
        return (this.first == null);
    }
    public void enQueue(T value) {
        QueueNode<T> novo = new QueueNode<>(value);
        if(this.isEmpty()){
            this.last = novo;
            this.first = novo;
        }else{
            this.last.setProx(novo);
            this.last = novo;
        }
    }
    public T deQueue() {
        QueueNode<T> aux = this.first;
        this.first = aux.getProx();
        if(this.first == null){
            this.last = null;
        }

        return aux.getInfo();
    }
}
