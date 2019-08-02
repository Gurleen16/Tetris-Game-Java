package essentials;
import java.util.Random;

public class Shapes{
        public enum shapes{Stick,TShape,Square,LShape,ZShape};
        public int coords[][];
        public int length,width,val,x,y,rotation;
        public int flag=1;
    
     public int x(int index) 
     { 
         return coords[index][0]; 
     }
    
    public int y(int index) {
        return coords[index][1]; 
    }
    
     private void setX(int index, int x) 
     { 
         coords[index][0] = x; 
     }
    
    private void setY(int index, int y) 
    { 
        coords[index][1] = y; 
    }
    
    public int setRandom(){
	rotation=0;
        Random r=new Random();
        int val=Math.abs(r.nextInt())%5;
        shapes[] values=shapes.values();
        System.out.println(val);
        System.out.println(values[val]);
        return val;
    }
    
    public void generate_Stick(int x,int y)
    {
	length=0;
	rotation=1;
        coords=new int[][]{
            {x,y},{x-1,y},{x-2,y},{x-3,y}
        };
	
    }
    
    public void generate_TShape(int x,int y)
    {
	length=0;
	width=2;
	rotation=1;
        coords=new int[][]{
            {x,y},{x-1,y-1},{x-1,y},{x-1,y+1}
        };
    }
    
    public void generate_Square(int x,int y)
    {
	length=1;
	width=1;
	rotation=1;
        coords=new int[][]{
            {x,y},{x+1,y},{x,y+1},{x+1,y+1}
        };
    }
    
    public void generate_ZShape(int x,int y)
    {
	length=1;
	width=2;

	rotation=1;
        coords=new int[][]{
            {x,y},{x,y+1},{x+1,y+1},{x+1,y+2}
        };
    }
    
   public void generate_LShape(int x,int y)
    {
	length=0;
	width=1;
	rotation=1;
        coords=new int[][]{
            {x,y},{x-1,y},{x-2,y},{x,y+1}
        };
    }
    
    
    public void call_Shape(int x,int y)
    {
        if(val==0)
            generate_Stick(x,y);
        else if(val==1)
            generate_TShape(x,y);
        else if(val==2)
            generate_Square(x,y);
        else if(val==3)
            generate_LShape(x,y);
        else if(val==4)
            generate_ZShape(x,y); 
    }
    
    public void make_Stick(int rotation){
        if(rotation==1)
            generate_Stick(x,y);
        else if(rotation==2)
            coords=new int[][]{
            {x,y},{x,y+1},{x,y+2},{x,y+3}
        };
        else if(rotation==3)
            coords=new int[][]{
            {x,y},{x+1,y},{x+2,y},{x+3,y}
        };
        else
            coords=new int[][]{
            {x,y},{x,y-1},{x,y-2},{x,y-3}
        };
        
          if(rotation==1 || rotation==3)
		{
			length=3;width=0;
		}
	else {length=0;width=3;}
    }
    
    public void make_TShape(int rotation){
        if(rotation==1)
            generate_TShape(x,y);
        else if(rotation==2)
            coords=new int[][]{
            {x,y},{x-1,y+1},{x,y+1},{x+1,y+1}
        };
        else if(rotation==3)
            coords=new int[][]{
            {x,y},{x+1,y-1},{x+1,y+1},{x+1,y}
        };
        else
            coords=new int[][]{
            {x,y},{x-1,y-1},{x,y-1},{x+1,y-1}
        };
        if(rotation==1){length=0;width=2;}
        else if(rotation==3){
            length=1;
            width=2;
        }
		else {length=2;width=1;}
    }
    
     public void make_LShape(int rotation){
        if(rotation==1)
            generate_LShape(x,y);
        else if(rotation==2)
            coords=new int[][]{
            {x,y},{x,y+1},{x,y+2},{x+1,y}
        };
        else if(rotation==3)
            coords=new int[][]{
            {x,y},{x+1,y},{x+2,y},{x,y-1}
        };
        else
            coords=new int[][]{
            {x,y},{x,y-1},{x,y-2},{x-1,y}
        };
         if(rotation==1){ length=0;width=1; }
        else if(rotation==2)
        {
            length=2;
            width=2;
        }
        else if(rotation==4){
            length=2;
            width=1;
        }
	else{length=1;width=2;}
    }
    
     public void make_ZShape(int rotation){
        if(rotation==1)
            generate_ZShape(x,y);
        else if(rotation==2)
            coords=new int[][]{
            {x,y},{x+1,y},{x+1,y-1},{x+2,y-1}
        };
        else if(rotation==3)
            coords=new int[][]{
            {x,y},{x,y+1},{x-1,y+1},{x-1,y+2}
        };
        else
            coords=new int[][]{
            {x,y},{x+1,y},{x+1,y+1},{x+2,y+1}
        };
         if(rotation==1){ length=1;width=2;}
    else if(rotation==3){
length=0;
    width=2;
    }
    else if(rotation==2){
        length=0;
        width=2;
    }
	else{ length=2;width=1;}
    }
    
    public int[][] generate_Shape()
    {
     val= setRandom();
         x=1;
        Random r=new Random();
        y=Math.abs(r.nextInt())%15+1; 
        System.out.println(x+" "+y);
          if(val==0){
              x+=3;
            generate_Stick(x,y);
          }
        else if(val==1){
            x+=1;
            generate_TShape(x,y);
        }
        else if(val==2)
            generate_Square(x,y);
        else if(val==3){
            x+=2;
            generate_LShape(x,y);
        }
        else if(val==4)
            generate_ZShape(x,y); 
        return coords;
    }
    
	public void setxofall(int a){
	for(int i=0;i<4;i++)
	coords[i][0]+=a;
	}	

	public void setyofall(int a){ 
	for(int i=0;i<4;i++)	
	coords[i][1]+=a;
	}
    
    public int check(int x1,int y1)
    {
        for(int i=0;i<4;i++)
        {
            if(coords[i][0]+x1==0 || coords[i][0]+x1==19)
                return 1;
            if(coords[i][1]+y1==0 || coords[i][1]+y1==19)
                return 1;
        }
        return 0;
    }

    public int [][] moveleft(char screen[][]){
            int newcoords[][]=new int[4][2];
        for(int i=0;i<4;i++)
        {
            newcoords[i][0]=coords[i][0];
            newcoords[i][1]=coords[i][1];
        }
         int c=0;
        if(check(0,-1)==0){
            flag=1;
            for(int i=0;i<4;i++)
            {
                    screen[coords[i][0]][coords[i][1]]=' ';
            }
            
            setyofall(-1);
                        y=y-1;
        
        }
        else
          { 
            flag=0;
            System.out.println("Unallowed Move");}
            for(int i=0;i<4;i++)
           {
               if(screen[coords[i][0]][coords[i][1]]!=' ')
                   c=1;
           }
         if(c==1)
             coords=newcoords;
         else
             newcoords=coords;
            return newcoords;
    }
    
    public int [][] moveright(char screen[][]){
            int newcoords[][]=new int[4][2];
        for(int i=0;i<4;i++)
        {
            newcoords[i][0]=coords[i][0];
            newcoords[i][1]=coords[i][1];
        }
        int c=0;
        if(check(0,1)==0){
            flag=1;
             for(int i=0;i<4;i++)
            {
                    screen[coords[i][0]][coords[i][1]]=' ';
            }
        setyofall(1);
            y=y+1;
        }
        else
        { 
            flag=0;
            System.out.println("Unallowed Move");}
            for(int i=0;i<4;i++)
           {
               if(screen[coords[i][0]][coords[i][1]]!=' ')
                   c=1;
           }
         if(c==1)
             coords=newcoords;
         else
             newcoords=coords;
            return newcoords;
    }
    
    public int [][] movedown(char screen[][]){
         int newcoords[][]=new int[4][2];
        for(int i=0;i<4;i++)
        {
            newcoords[i][0]=coords[i][0];
            newcoords[i][1]=coords[i][1];
        }
        int c=0;
        if(check(1,0)==0){
            flag=1;
             for(int i=0;i<4;i++)
            {
                    screen[coords[i][0]][coords[i][1]]=' ';
            }
        setxofall(1);
            x+=1;
        }
        else
        {
            flag=0;
            System.out.println("Boundary Reached");}
            for(int i=0;i<4;i++)
           {
               if(screen[coords[i][0]][coords[i][1]]!=' ')
                   c=1;
           }
         if(c==1)
             coords=newcoords;
         else if(c==0)
             newcoords=coords;
            return newcoords;
    }
    
       public int [][] moveup(char screen[][]){
         int newcoords[][]=new int[4][2];
        for(int i=0;i<4;i++)
        {
            newcoords[i][0]=coords[i][0];
            newcoords[i][1]=coords[i][1];
        }
        int c=0;
        if(check(-1,0)==0){
            flag=1;
             for(int i=0;i<4;i++)
            {
                    screen[coords[i][0]][coords[i][1]]=' ';
            }
        setxofall(-1);
            x-=1;
        }
        else
        {
            flag=0;
            System.out.println("Boundary Reached");}
            for(int i=0;i<4;i++)
           {
               if(screen[coords[i][0]][coords[i][1]]!=' ')
                   c=1;
           }
         if(c==1)
             coords=newcoords;
         else if(c==0)
             newcoords=coords;
            return newcoords;
    }
    
    
    
    public void rotate_Stick(char ch)
    {
        if(rotation==1)
        {
            if(ch=='r'){
            if(y+3<19 ){
            coords=new int[][]{
                {x,y},{x,y+1},{x,y+2},{x,y+3}
            };
                rotation++;
            }
            else
                System.out.println("Cant rotate");
            }
            else
            {
                if(y-3>0){
                   coords=new int[][]{
                       
                       {x,y},{x,y-1},{x,y-2},{x,y-3}
                   };
                    rotation=4;
                }
                else
                System.out.println("Cant rotate");
            }
        }
        
        else   if(rotation==2 )
        {
            if(ch=='r'){
            if(x+3<19 ){
            coords=new int[][]{
                {x,y},{x+1,y},{x+2,y},{x+3,y}
            };
                rotation++;
            }
            else
                System.out.println("Cant rotate");
            }
            else
            {
                if(x-3>0){
                   coords=new int[][]{
                       
                       {x,y},{x-1,y},{x-2,y},{x-3,y}
                   };
                    rotation--;
                }
                else
                System.out.println("Cant rotate");
            }
        }
        else if(rotation==3)
        {
            if(ch=='r')
            {
                if(y-3>0)
                {
                    coords=new int[][]{
                      {x,y},{x,y-1},{x,y-2},{x,y-3}
                    };
                    rotation++;
                }
                 else
                System.out.println("Cant rotate");
            }
            else
            {
                if(y+3<19)
                {
                    coords=new int[][]{
                        {x,y},{x,y+1},{x,y+2},{x,y+3}
                    };
                    rotation--;
                }
                 else
                System.out.println("Cant rotate");
                    
            }
        }
        else if(rotation==4)
        {
            if(ch=='r')
            {
                if(x-3>0)
                {
                    coords=new int[][]{
                        {x,y},{x-1,y},{x-2,y},{x-3,y}
                    };
                    rotation=1;
                }
                 else
                System.out.println("Cant rotate");
            }
            else
            {
                
                 if(x+3<19)
                {
                    coords=new int[][]{
                        {x,y},{x+1,y},{x+2,y},{x+3,y}
                    };
                    rotation--;
                }
            }
        }
            if(rotation==1)
		{
			length=0;width=0;
		}
        else if(rotation==3)
        {
            length=3;
        }
	else {length=0;width=3;}
    }

	public void rotate_LShape(char ch){
	        if(rotation==1 )
        {
            if(ch=='r'){
            if(y+2<19 && x+1<19){
            coords=new int[][]{
                {x,y},{x,y+1},{x,y+2},{x+1,y}
            };
                rotation++;
            }
            else
                System.out.println("Cant rotate");
            }
            else
            {
                if(x-1>0    &&  y-2>0){
                   coords=new int[][]{
                      
                       {x,y},{x,y-1},{x,y-2},{x-1,y}
                   };
                    rotation=4;
                }
                else
                System.out.println("Cant rotate");
            }
        }
        
        else   if(rotation==2 )
        {
            if(ch=='r'){
            if(x+2<19 && y-1>0){
            coords=new int[][]{
                {x,y},{x+1,y},{x+2,y},{x,y-1}
            };
                rotation++;
            }
            else
                System.out.println("Cant rotate");
            }
            else
            {
                if(x-2>19 && y+1<19){
                   coords=new int[][]{
                     {x,y},{x-1,y},{x-2,y},{x,y+1}
                   };
                    rotation--;
                }
                else
                System.out.println("Cant rotate");
            }
        }
        //
        else if(rotation==3)
        {
            if(ch=='r')
            {
                if(x-1>0 && y-2>0)
                {
			
                    coords=new int[][]{
                      {x,y},{x,y-1},{x,y-2},{x-1,y}
                    };
                    rotation++;
                }
                 else
                System.out.println("Cant rotate");
            }
            else
            {
                if(x+1<19 && y+2<19)
                {
                    coords=new int[][]{
                       {x,y},{x,y+1},{x,y+2},{x+1,y}
                    };
                    rotation--;
                }
                 else
                System.out.println("Cant rotate");
                    
            }
        }
        else if(rotation==4)
        {
            if(ch=='r')
            {
                if(x-2>0 && y+1<19)
                {
                  
                    coords=new int[][]{
                        {x,y},{x-1,y},{x-2,y},{x,y+1}
                    };
                    rotation=1;
                }
                 else
                System.out.println("Cant rotate");
            }
            else
            {
                if(y-1>0 && x+2<19)
                {
                    coords=new int[][]{
                        {x,y},{x+1,y},{x+2,y},{x,y-1}
                    };
                    rotation--;
                }
            }
        }
	if(rotation==1){ length=0;width=1; }
        else if(rotation==2)
        {
            length=2;
            width=2;
        }
        else if(rotation==3){
            length=2;
            width=1;
        }
	else{length=1;width=2;}
	}

public void rotate_ZShape(char ch){
      if(rotation==1 )
        {
            if(ch=='r'){
            if(y-1>0 && x+2<19){
            coords=new int[][]{
                
                {x,y},{x+1,y},{x+1,y-1},{x+2,y-1}
            };
                rotation++;
            }
            else
                System.out.println("Cant rotate");
            }
            else
            {
                if(y+1<19    &&  x+2<19){
                   coords=new int[][]{
                      
                       {x,y},{x+1,y},{x+1,y+1},{x+2,y+1}
                   };
                    rotation=4;
                }
                else
                System.out.println("Cant rotate");
            }
        }
        
        else   if(rotation==2 )
        {
            if(ch=='r'){
            if(x-1>0 && y+2<19){
            coords=new int[][]{
                {x,y},{x,y+1},{x-1,y+1},{x-1,y+2}
            };
                rotation++;
            }
            else
                System.out.println("Cant rotate");
            }
            else
            {
                if(x+1<19 &&  y+2<19){
                   coords=new int[][]{
                        {x,y},{x,y+1},{x+1,y+1},{x+1,y+2}
                   };
                    rotation--;
                }
                else
                System.out.println("Cant rotate");
            }
        }
        //
        else if(rotation==3)
        {
            if(ch=='r')
            {
                if(x+2<19 && y+1<19)
                {
			
                    coords=new int[][]{
                      {x,y},{x+1,y},{x+1,y+1},{x+2,y+1}
                    };
                    rotation++;
                }
                 else
                System.out.println("Cant rotate");
            }
            else
            {
                if(x+2<19 && y-1>0)
                {
                    coords=new int[][]{
                        {x,y},{x+1,y},{x+1,y-1},{x+2,y-1}
                    };
                    rotation--;
                }
                 else
                System.out.println("Cant rotate");
                    
            }
        }
        else if(rotation==4)
        {
            if(ch=='r')
            {
                if(x+1<19 && y+2<19)
                {
                  
                    coords=new int[][]{
                        {x,y},{x,y+1},{x+1,y+1},{x+1,y+2}
                    };
                    rotation=1;
                }
                 else
                System.out.println("Cant rotate");
            }
            else
            {
                if(y+2<19 && x-1>0)
                {
                    coords=new int[][]{
                        {x,y},{x,y+1},{x-1,y+1},{x-1,y+2}
                    };
                    rotation--;
                }
            }
        }
	if(rotation==1){ length=1;width=2;}
    else if(rotation==3){
length=0;
    width=2;
    }
    else if(rotation==2){
        length=0;
        width=2;
    }
	else{ length=2;width=1;}
}
    
    public void rotate_TShape(char ch)
    {
         if(rotation==1 )
        {
            if(ch=='r'){
            if(y+1<19 && x+1<19 && x-1>0){
            coords=new int[][]{
                
                {x,y},{x-1,y+1},{x,y+1},{x+1,y+1}
            };
                rotation++;
            }
            else
                System.out.println("Cant rotate");
            }
            else
            {
                if(x+1<19    &&  x-1>0 && y-1>0){
                   coords=new int[][]{
                      
                       {x,y},{x,y-1},{x-1,y-1},{x+1,y-1}
                   };
                    rotation=4;
                }
                else
                System.out.println("Cant rotate");
            }
        }
        
        else   if(rotation==2 )
        {
            if(ch=='r'){
            if(x+1<19 && y-1>0 && y+1<19 ){
            coords=new int[][]{
                {x,y},{x+1,y+1},{x+1,y},{x+1,y-1}
            };
                rotation++;
            }
            else
                System.out.println("Cant rotate");
            }
            else
            {
                if(x-1>0 &&  y+1<19 && y-1>0) {
                   coords=new int[][]{
                        {x,y},{x-1,y+1},{x-1,y},{x-1,y-1}
                   };
                    rotation--;
                }
                else
                System.out.println("Cant rotate");
            }
        }
        //
        else if(rotation==3)
        {
            if(ch=='r')
            {
                if(x+1<19 && y-1>0 && x-1>0)
                {
			
                    coords=new int[][]{
                      {x,y},{x+1,y-1},{x-1,y-1},{x,y-1}
                    };
                    rotation++;
                }
                 else
                System.out.println("Cant rotate");
            }
            else
            {
                if(x+1<19 && y+1<19 && x-1>0)
                {
                    coords=new int[][]{
                        {x,y},{x+1,y+1},{x-1,y+1},{x,y+1}
                    };
                    rotation--;
                }
                 else
                System.out.println("Cant rotate");
                    
            }
        }
        else if(rotation==4)
        {
            if(ch=='r')
            {
                if(x-1>0 && y+1<19 && y-1>0)
                {
                  
                    coords=new int[][]{
                        {x,y},{x-1,y+1},{x-1,y},{x-1,y-1}
                    };
                    rotation=1;
                }
                 else
                System.out.println("Cant rotate");
            }
            else
            {
                if(y+1<19 && x+1<19 && y-1>0)
                {
                    coords=new int[][]{
                        {x,y},{x+1,y+1},{x+1,y},{x+1,y-1}
                    };
                    rotation--;
                }
            }
        }
            if(rotation==1){length=0;width=2;}
        else if(rotation==3){
            length=1;
            width=2;
        }
		else {length=2;width=1;}
    }
    public int[][] rotateleft(char [][]screen){
        int previousrotation=rotation;
        if (val==2)
        {
            rotation++;
            flag=0;
            return coords;
        }
       else
       {
             int newcoords[][]=new int[4][2];
        for(int i=0;i<4;i++)
        {
            newcoords[i][0]=coords[i][0];
            newcoords[i][1]=coords[i][1];
        }
         int c=0;
           for(int i=0;i<4;i++)
            {
                    screen[coords[i][0]][coords[i][1]]=' ';
            }
            if(val==0)
                rotate_Stick('l');
           else if(val==1)
               rotate_TShape('l');
           else if(val==3)
               rotate_LShape('l');
           else if(val==4)
               rotate_ZShape('l');
              for(int i=0;i<4;i++)
           {
               if(screen[coords[i][0]][coords[i][1]]!=' ')
                   c=1;
           }
         if(c==1)
             coords=newcoords;
         else
             newcoords=coords;
                
       if(previousrotation==rotation)
           flag=0;
           else
               flag=1;
        return newcoords;
        }
   
    }
    
    public int[][] rotateright(char [][]screen){
        int previousrotation=rotation;
        if (val==2)
        {
            rotation++;
            flag=0;
           return coords; 
        }
     else
       {
         
           int newcoords[][]=new int[4][2];
        for(int i=0;i<4;i++)
        {
            newcoords[i][0]=coords[i][0];
            newcoords[i][1]=coords[i][1];
        }
         int c=0;
        for(int i=0;i<4;i++)
            {
                    screen[coords[i][0]][coords[i][1]]=' ';
            }
            if(val==0)
                rotate_Stick('r');
           else if(val==1)
               rotate_TShape('r');
           else if(val==3)
               rotate_LShape('r');
           else if(val==4)
               rotate_ZShape('r');
           for(int i=0;i<4;i++)
           {
               if(screen[coords[i][0]][coords[i][1]]!=' ')
               { 
                   c=1;
                break;
               }
           }
         if(c==1)
             coords=newcoords;
         else
             newcoords=coords;
         if(previousrotation==rotation)
             flag=0;
         else
             flag=1;
         return newcoords;
        }
        
    }

}