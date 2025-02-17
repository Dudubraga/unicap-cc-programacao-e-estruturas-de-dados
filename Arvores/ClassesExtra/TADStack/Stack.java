package ClassesExtra.TADStack;
public class Stack<T> {
    private StackNode<T> top;

    public boolean isEmpty() {
        return (this.top == null);
    }
    public void push(T value){
        StackNode<T> novo = new StackNode<T>(value); 
        novo.setProx(this.top);
        this.top = novo;
    }
    public T pop(){
        StackNode<T> aux = this.top;
        this.top = this.top.getProx();
        return aux.getInfo();
    }
    public T peek(){
        if(this.isEmpty()){
            System.out.println("Stack Vazia");
            return null;
        }
        return this.top.getInfo();
    }
}

