package HomeWork4;

public class TestStack {

    public static void main(String[] args) throws StackException {
        StackImpl mystack1 = new StackImpl(5);
        try {

            mystack1.print();   // ����� ���� ��������� �����

            mystack1.addfour(); // ���������� ������� ���������

            mystack1.print();   // ����� ���� ��������� �����

            mystack1.delltwo(); // �������� ���� ���������

            mystack1.print();   // ����� ���� ��������� �����

            mystack1.addthree(); // ���������� ���� ���������

            mystack1.print();    // ����� ���� ��������� �����

         //   mystack1.push("E8");  // ������� �������� ������� � ������ ����

            mystack1.clear();       // ������� �����

            mystack1.print();    // ����� ���� ��������� �����

         // mystack1.pop(); // ������� ������� ������� �� �����

        } catch (StackException e){
            System.out.println(e);
        }
    }
}



 interface Stack {
    // adds an element to stack, throws exception if stack is full ("StackImpl is
    //full" message)
    void push(Object o) throws StackException;
    // returns top element from stack, throws exception if stack is empty ("StackImpl is empty" 	//message)
    Object pop() throws StackException;
    // clears the hole stack
    void clear();
    // prints all elements of stack to standart output
    void print();
}



class StackImpl implements Stack {
   private Object stck[];
   private int tos;

    StackImpl(int size){
        stck = new  Object[size] ;
        tos = -1;
    }

    //  ���������� ��������
    public void push(Object o) throws StackException {
        if(tos ==  stck.length-1){
            throw new StackException( "Stack is full");
        }else { stck[++tos] = o;}
    }


    //  �������� ��������
    public Object pop() throws StackException {
        if(tos < 0){
            throw new  StackException("Stack is empty");
        }else return stck[tos--] ;

    }


    // ������� �����
    public void clear() {
        for(int i = 0; i < 5; i++) stck[tos--] = null ;
    }


    // ����� ���� ��������� �����
    public void print(){
        for(int i = 0; i < 5; i++){
            System.out.print(" " + stck[i]);
        }
        System.out.println(" ");
    }


    // ���������� ������� ���������
    public  void addfour() throws StackException {
        for(int i = 1; i < 5; ++i){
            push("E" + i);
        }
    }

    // �������� ���� ���������
    public void delltwo() throws StackException {
        for(int i = 1; i < 5; i++) pop();
        for(int i = 1; i < 6; i++){
            switch (i){
                case 1: push(null); break;
                case 2: push(null); break;
                case 3: push("E3"); break;
                case 4: push("E4"); break;
                case 5: push(null); break;
                default: break;
            }
        }
    }


    // ���������� ���� ���������
    public  void addthree() throws StackException{
        for(int i = 1; i < 6; i++) pop();
        for(int i = 1; i < 6; i++){
            switch (i){
                case 1: push("E6"); break;
                case 2: push("E7"); break;
                case 3: push("E3"); break;
                case 4: push("E4"); break;
                case 5: push("E5"); break;
                default: break;
            }
        }
    }



}