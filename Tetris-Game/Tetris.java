import essentials.*;
import java.util.Scanner;
import java.util.*;

class Tetris
{
    public static void clearscreen()
    {
        try{
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        }
        catch(Exception e)
        {
            
        }
    }
    public static void main(String []args)
    {
        Board b=new Board();
        b.generate_board();
        int fix=0;
        
        Undo u=new Undo();
        Undo r=new Undo();
        
        UndoShape us=new UndoShape();
        
        char [][]mapped =new char[][]{{'l','r'},{'r','l'},{'d','u'},{'c','a'},{'a','c'},{'s','p'}};
        int isgameover=0;
		
        while(true){
        isgameover=0;
           
        Shapes s=new Shapes();
        int coords[][]=s.generate_Shape();
		for(int i=0;i<4;i++)
		{
			if(b.screen[coords[i][0]][coords[i][1]]!=' '){
				isgameover=1;
				break;
			}
		}
			if(isgameover==1)
				break;
        b.setBoard(coords);
        clearscreen();
        b.display_board();
    
        Scanner sc=new Scanner(System.in);
        char ch;
        
        while(true){
            ch=sc.next().charAt(0);
            int br=0;
            for(int i=0;i<4;i++)
            {
                if(s.coords[i][0]+1==19)
                {
                    br=1;
                    break;
                }
            }
            if(br==1){
              
                  for(int i=0;i<coords.length;i++)
                { 
                    fix++;
                    b.count[coords[i][0]]++;
                }
                us.push(s.val,s.rotation,s.x,s.y);
                u.push('s');
                us.display();
                 if(b.findandremove()==1){
                  us.top1=null;
              }
                break;
            }
                int newcoords[][]=new int[4][2];
        for(int i=0;i<4;i++)
        {
            newcoords[i][0]=s.coords[i][0];
            newcoords[i][1]=s.coords[i][1];
        }
        if(ch=='l' || ch=='L')
            coords=s.moveleft(b.screen);
        else if(ch=='d' ||  ch=='D')
            coords=s.movedown(b.screen);
        else if(ch=='r' ||  ch=='R')
            coords=s.moveright(b.screen);
        else if(ch=='a' || ch=='A')
            coords=s.rotateleft(b.screen);
        else if(ch=='c' || ch=='C')
            coords=s.rotateright(b.screen);
        else if(ch=='u' || ch=='U')
        {
            if(!u.isEmpty())
            {
                System.out.println(u.peek());
                for(int i=0;i<6;i++)
                {
                    if(u.peek()==mapped[i][0])
                    {
                       
                        if(mapped[i][1]=='l')
                            coords=s.moveleft(b.screen);
                        else if(mapped[i][1]=='u')
                            coords=s.moveup(b.screen);
                        else if(mapped[i][1]=='r')
                            coords=s.moveright(b.screen);
                        else if(mapped[i][1]=='a')
                            coords=s.rotateleft(b.screen);
                        else if(mapped[i][1]=='c')
                            coords=s.rotateright(b.screen);
                        else if(mapped[i][1]=='d')
                            coords=s.movedown(b.screen);
                        else if(mapped[i][0]=='s')
                        {                 
                            for(int k=0;k<4;k++)
                                b.screen[s.coords[k][0]][s.coords[k][1]]=' ';
                        
                            s.rotation=us.getrotation();
                            s.val=us.getshape();
                            s.x=us.getx();
                            s.y=us.gety();
                            
                            if(s.val==0)
                                s.make_Stick(s.rotation);
                            else if(s.val==2)
                                s.generate_Square(s.x,s.y);
                            else if(s.val==1)
                                s.make_TShape(s.rotation);
                            else if(s.val==3)
                                s.make_LShape(s.rotation);
                            else 
                                s.make_ZShape(s.rotation);
                            for(int k=0;k<4;k++)
                                b.count[s.coords[k][0]]--;
                            coords=s.moveup(b.screen);
                             us.pop();
                        }
                        r.push(u.peek());
                       u.pop();
                        break;
                    }
                }
            }
        }
        else if(ch=='o' || ch=='O')
        {
            if(!r.isEmpty())
            {
                for(int i=0;i<6;i++)
                {
                    if(r.peek()==mapped[i][0])
                    {
                       
                        if(mapped[i][0]=='l')
                            coords=s.moveleft(b.screen);
                        else if(mapped[i][0]=='u')
                            coords=s.moveup(b.screen);
                        else if(mapped[i][0]=='r')
                            coords=s.moveright(b.screen);
                        else if(mapped[i][0]=='a')
                            coords=s.rotateleft(b.screen);
                        else if(mapped[i][0]=='c')
                            coords=s.rotateright(b.screen);
                        else if(mapped[i][0]=='d')
                            coords=s.movedown(b.screen);
                        else if(mapped[i][0]=='s'){
                            coords=s.movedown(b.screen);
                            us.push(s.val,s.rotation,s.x,s.y);
                        }
                        u.push(r.peek());
                        r.pop();
                        break;
                    }
                }
            }
        }
        else
        {
            ch='d';
            coords=s.movedown(b.screen);
        }
            
            int c=0;
            for(int i=0;i<4;i++)
            {
                if(coords[i][0]==newcoords[i][0] && coords[i][1]==newcoords[i][1])
                    c++;
            }
            
            b.setBoard(coords);
            clearscreen();
            b.display_board();
            if(c!=4 && ch!='u' && ch!='o')
            {
                u.push(ch);
            }
            if(c==4 && s.flag==1 && ch!='u' && ch!='o' && ch=='d'){
                 for(int i=0;i<coords.length;i++)
                { 
                    fix++;
                    b.count[coords[i][0]]++;
                }
                us.push(s.val,s.rotation,s.x,s.y);
                u.push('s');
              if(b.findandremove()==1){
                  us.top1=null;
              }
                break;
            }
        }
        }
        System.out.println("GAME OVER");
    }
}
