package essentials;

interface stack1{
    public void push(char val);
    public void pop();
    public char peek();
    public boolean isEmpty();
}

class Link1{
    public char data;
    public Link1 next;
    public Link1(char d){
        data=d;
        next=null;
    }
}

public class Undo implements stack1
{   
    public Link1 top;
    public Undo(){
    top=null;
    }
    
     public boolean isEmpty()
    {
        return top == null;
    }
    
    public void push(char val){
        Link1 link=new Link1(val);
        link.next=top;
        top=link;
    }
    
    public void pop(){
    top=top.next;
    }
    
    public char peek(){
    if(!isEmpty())
    return top.data;
    
    return 'm';
    }
}

//public class Undo implements stack
//{   
//    public char operation[]=new char[50];
//    public int top=-1;
//    
//    public void push(char val){
//    if(top!=49){
//    top++;
//    operation[top]=val;
//    }
//    }
//    
//    public void pop(){
//    if(top!=-1)
//        top--;
//    }
//    
//    public char peek(){
//    if(top!=-1)
//    return operation[top];
//    
//    return 'm';
//    }
//}