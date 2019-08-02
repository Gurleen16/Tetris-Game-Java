package essentials;
import java.util.Random;

public class Board
{
    public char [][]screen=new char[20][20];
    public int []count=new int[20];
    public void generate_board(){
        
        for(int i=0;i<20;i++)
        {
            for(int j=0;j<20;j++)
            {
                if(j==19 || j==0)
                    screen[i][j]='|';
              else  if(i==0 || i==19)
                    screen[i][j]='-';
                else
                    screen[i][j]=' ';
            }
        }
        for(int i=0;i<20;i++)
            count[i]=0;
    }
    
    public int findandremove(){
        for(int i=1;i<=18;i++)
        {
            if(count[i]==18)
            {
                count[i]=0;
                for(int j=1;j<=18 ;j++)
                    screen[i][j]=' ';
                
                for(int k=i-1;k>=2;k--)
                {
                    count[k+1]=0;
                    for(int j=1;j<19;j++){
                    screen[k+1][j]=' ';
                        if(k!=18){
                            if(screen[k][j]!=' ')
                            count[k+1]++;
                        screen[k+1][j]=screen[k][j];
                        }
                    }
                }
               return 1;
                }
            }
       return 0;
        }
    
    
        public void make_board(){
        
        for(int i=0;i<20;i++)
        {
            for(int j=0;j<20;j++)
            {
                if(j==19 || j==0)
                    screen[i][j]='|';
              else  if(i==0 || i==19)
                    screen[i][j]='-';
            }
        }
    }
    
    public void setBoard(int mat[][])
    {
        
        for(int i=0;i<mat.length;i++)
        {
                screen[mat[i][0]][mat[i][1]]='#';
        }
        make_board();
    }
    
    public void display_board(){
        
        for(int i=0;i<20;i++)
        {
            for(int j=0;j<20;j++)
            {
                System.out.print(screen[i][j]);
            }
            System.out.println();
        }
    }
}


