package HomeWork4;


public class TestStack {

    Stack mystack1 = new StackImpl(5);

    // ���������� ������� ���������
    public  void addfour() throws StackException {
        for(int i = 1; i < 5; ++i) {
            mystack1.push("E" + i);
        }
    }

    // �������� ���� ���������
    public  void delltwo() throws StackException {
        for(int i = 1; i < 5; i++) mystack1.pop();
        for(int i = 1; i < 6; i++){
            switch (i){
                case 1: mystack1.push(null);break;
                case 2: mystack1.push(null); break;
                case 3: mystack1.push("E3"); break;
                case 4: mystack1.push("E4"); break;
                case 5: mystack1.push(null); break;
                default: break;
            }
        }
    }

    // ���������� ���� ���������
    public  void addthree() throws StackException{
        for(int i = 1; i < 6; i++) mystack1.pop();
        for(int i = 1; i < 6; i++){
            switch (i){
                case 1: mystack1.push("E6"); break;
                case 2: mystack1.push("E7"); break;
                case 3: mystack1.push("E3"); break;
                case 4: mystack1.push("E4"); break;
                case 5: mystack1.push("E5"); break;
                default: break;
            }
        }
    }


    public static void main(String[] args) throws StackException {

        TestStack St = new TestStack();
        try {

            St.mystack1.print();   // ����� ���� ��������� �����

            St.addfour(); // ���������� ������� ���������

            St.mystack1.print();   // ����� ���� ��������� �����

            St.delltwo(); // �������� ���� ���������

            St.mystack1.print();   // ����� ���� ��������� �����

            St.addthree(); // ���������� ���� ���������

            St.mystack1.print();    // ����� ���� ��������� �����

            // St.mystack1.push("E8");  // ������� �������� ������� � ������ ����

            St.mystack1.clear();       // ������� �����

            St.mystack1.print();    // ����� ���� ��������� �����

            // St.mystack1.pop(); // ������� ������� ������� �� �����

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
    public  void push(Object o) throws StackException {
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
}


