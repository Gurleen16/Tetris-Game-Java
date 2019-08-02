package essentials;

interface stack{
    public void push(int val,int r,int x1,int y1);
    public void pop();
    public Link peek();
    public boolean isEmpty();
}

class Link{
    public int shape;
    public int rotation;
    public int x;
    public int y;
    public Link next;
    public Link(int d,int r,int x1,int y1){
        shape=d;
        rotation=r;
        x=x1;
        y=y1;
        next=null;
    }
}

public class UndoShape implements stack
{   
    public Link top1;
    public UndoShape(){
    top1=null;
    }
    
    public void display(){
    System.out.println(top1.shape);
    }
    
     public boolean isEmpty()
    {
        return top1 == null;
    }
    
    public void push(int val,int r,int x1,int y1){
        Link link=new Link(val,r,x1,y1);
        link.next=top1;
        top1=link;
    }
    
    public void pop(){
    top1=top1.next;
    }
    
    public Link peek(){
    if(!isEmpty())
    return top1;
    
    return null;
    }
    
    public int getshape(){
    return top1.shape;
    }
    
    public int getrotation(){
    return top1.rotation;
    }
    
    public int getx(){
    return top1.x;
    }
    
    public int gety(){
    return top1.y;
    }
}
