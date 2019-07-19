import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;

class Hash
{
  int x;
  int y;
}

class Board
{
  public static char[][] board=new char[20][20];
  public final static void clearConsole()
  {
      try
      {
          new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      }
      catch ( Exception e)
      {
      //  Handle any exceptions.
      }
      //system("clear");
  }

  static void delay()
  {
      try
      {
          TimeUnit.SECONDS.sleep(1);
      }
      catch(Exception e)
      {

      }
  }
  static void make_board()
  {
      int i;
      for(i=0;i<20;i++)
          board[0][i]='*';
      for(i=0;i<20;i++)
          board[19][i]='*';
      for(i=0;i<20;i++)
          board[i][19]='*';
      for(i=0;i<20;i++)
          board[i][0]='*';

          //board[15][15]='#';
}
  static void makeBoardNull()
  {
  	for(int i=0;i<20;i++)
  	{
  		for(int j=0;j<20;j++)
  		{
  			board[i][j]=' ';
  		}
  	}
  }
  static void show_board()
  {
      int i,j,x;
      for(i=0;i<20;i++)
      {
          for(j=0;j<20;j++)
              {
                  System.out.print(board[i][j]);
              }
          System.out.println();
      }
  }
  static void clearBoard()
  {
      for(int i=1;i<19;i++)
      {
          for(int j=1;j<19;j++)
          {
              Board.board[i][j]=' ';
          }
      }
  }
}


class Shape
{
  static int move=1;
  public void make_shape_board(Hash point[])
  {
    for(int i=0;i<point.length;i++)
    {
        Board.board[point[i].x][point[i].y]='#';
    }
    Board.show_board();
  }
  void moveRight(Hash point[])
  {
    int c=0;
    for(int i=0;i<point.length;i++)
    {
        if(point[i].y>=18)
        {
          c=1;
          break;
        }
    }
    if(c==0)
    {
      for(int i=0;i<point.length;i++)
      {
        Board.board[point[i].x][point[i].y]=' ';
        //point[i].x++;
      }
      for(int i=0;i<point.length;i++)
      {
        if(Board.board[point[i].x][point[i].y+1]=='#')
        {
          c=2;
          break;
        }
      }
      if(c!=2)
      {
        for(int i=0;i<point.length;i++)
        {
          //Board.board[point[i].x][point[i].y]=' ';
          point[i].y++;
        }
      }
      if(c==2)
      {
        move=0;
      }
    }

      make_shape_board(point);
  }
  void moveDown(Hash point[])
  {
    int c=0;
    for(int i=0;i<point.length;i++)
    {
        if(point[i].x>=18)
        {
          c=1;
          break;
        }
    }
    if(c==0)
    {
      for(int i=0;i<point.length;i++)
      {
        Board.board[point[i].x][point[i].y]=' ';
        //point[i].x++;
      }
      for(int i=0;i<point.length;i++)
      {
        if(Board.board[point[i].x+1][point[i].y]=='#')
        {
          c=2;
          break;
        }
      }
      if(c!=2)
      {
        for(int i=0;i<point.length;i++)
        {
          //Board.board[point[i].x][point[i].y]=' ';
          point[i].x++;
        }
      }
      if(c==2)
      {
        move=0;
      }
    }

      make_shape_board(point);
  }
  void moveLeft(Hash point[])
  {
    int c=0;
    for(int i=0;i<point.length;i++)
    {
        if(point[i].y<=1)
        {
          c=1;
          break;
        }
    }
    if(c==0)
    {
      for(int i=0;i<point.length;i++)
      {
        Board.board[point[i].x][point[i].y]=' ';
        //point[i].x++;
      }
      for(int i=0;i<point.length;i++)
      {
        if(Board.board[point[i].x][point[i].y-1]=='#')
        {
          c=2;
          break;
        }
      }
      if(c!=2)
      {
        for(int i=0;i<point.length;i++)
        {
          //Board.board[point[i].x][point[i].y]=' ';
          point[i].y--;
        }
      }
      if(c==2)
      {
        move=0;
      }
    }
  make_shape_board(point);
  }


}

class IShape extends Shape
{
  Hash point[];
  int rot_version;
  IShape()
  {
    //super();
    rot_version=1;
    point=new Hash[4];

    for(int i=0;i<point.length;i++)
    {
        point[i]=new Hash();
    }
    int ypoint=random_generate();
    point[0].x=1;
    point[0].y=ypoint;

    point[1].x=2;
    point[1].y=ypoint;

    point[2].x=3;
    point[2].y=ypoint;

    point[3].x=4;
    point[3].y=ypoint;

  }
  int random_generate()
  {
  int y;
  Random rand = new Random();
   int rand_int1 = rand.nextInt(17);
   y=rand_int1;
   if(y<2)
   random_generate();
   return y;

  }

  Hash[] getCoordinates()
  {
    return point;
  }
  public void rotateclockwise()
  {
    rot_version++;
    if(rot_version==3)
    rot_version=1;
  //  rotateclockwise(point,rot_version);
  for(int i=0;i<point.length;i++)
  {
    Board.board[point[i].x][point[i].y]=' ';
  }

    if(rot_version==2)
    {
      point[0].x+=2;
      point[1].x+=1;
      point[3].x-=1;
      point[1].y++;
      point[2].y+=2;
      point[3].y+=3;
    }
    else
    {
      point[0].x-=2;
      point[1].x-=1;
      point[3].x+=1;
      point[1].y--;
      point[2].y-=2;
      point[3].y-=3;
    }
    make_shape_board(point);
  }
  public void rotateanticlockwise()
  {
    rot_version--;
    if(rot_version==0)
    rot_version=2;
    //rotateclockwise(point,rot_version);
    for(int i=0;i<point.length;i++)
    {
      Board.board[point[i].x][point[i].y]=' ';
    }

    if(rot_version==2)
    {
      point[0].x+=2;
      point[1].x+=1;
      point[3].x-=1;
      point[1].y++;
      point[2].y+=2;
      point[3].y+=3;
    }
    else
    {
      point[0].x-=2;
      point[1].x-=1;
      point[3].x+=1;
      point[1].y--;
      point[2].y-=2;
      point[3].y-=3;
    }
    make_shape_board(point);
  }

  public void moveDown()
  {

      moveDown(point);
  }
  public void moveRight()
  {
      moveRight(point);
  }
  public void moveLeft()
  {
      moveLeft(point);
  }
  void make_shape()
  {
    make_shape_board(point);
  }
}

class LShape extends Shape
{
  Hash point[];
  int rot_version;
  LShape()
  {
    //super();
    rot_version=1;
    point=new Hash[4];

    for(int i=0;i<point.length;i++)
    {
        point[i]=new Hash();
    }
    int ypoint=random_generate();
    point[0].x=1;
    point[0].y=ypoint;

    point[1].x=2;
    point[1].y=ypoint;

    point[2].x=3;
    point[2].y=ypoint;

    point[3].x=3;
    point[3].y=ypoint+1;

  }
  int random_generate()
  {
  int y;
  Random rand = new Random();
   int rand_int1 = rand.nextInt(17);
   y=rand_int1;
   if(y<2)
   random_generate();
   return y;

  }

  Hash[] getCoordinates()
  {
    return point;
  }
  public void rotateclockwise()
  {
    rot_version++;
    if(rot_version==5)
    rot_version=1;
  //  rotateclockwise(point,rot_version);
  for(int i=0;i<point.length;i++)
  {
    Board.board[point[i].x][point[i].y]=' ';
  }

    if(rot_version==2)
    {
      point[0].x+=1;
      point[0].y+=2;
      point[1].y++;
      point[2].x-=1;
      point[3].y-=1;
    }
    else if(rot_version==3)
    {
      point[0].x+=1;
      point[0].y-=1;
      point[2].x-=1;
      point[2].y+=1;
      point[3].x-=2;
    }
    else if(rot_version==4)
    {
      point[0].y--;
      point[1].x++;
      point[2].x+=2;
      point[2].y++;
      point[3].x++;
      point[3].y+=2;
    }
    else
    {
      point[0].x-=2;
      point[1].x--;
      point[1].y--;
      point[2].y-=2;
      point[3].x++;
      point[3].y--;
    }
    make_shape_board(point);
  }
  public void rotateanticlockwise()
  {
    rot_version--;
    if(rot_version==0)
    rot_version=4;
    //rotateclockwise(point,rot_version);
    for(int i=0;i<point.length;i++)
    {
      Board.board[point[i].x][point[i].y]=' ';
    }

    if(rot_version==2)
    {
      point[0].x--;
      point[0].y++;
      point[2].x++;
      point[2].y--;
      point[3].x+=2;
    }
    else if(rot_version==3)
    {
      point[0].y++;
      point[1].x--;
      point[2].x-=2;
      point[2].y--;
      point[3].x--;
      point[3].y-=2;

    }
    else if(rot_version==4)
    {
      point[0].x+=2;
      point[1].x++;
      point[1].y++;
      point[2].y+=2;
      point[3].x--;
      point[3].y++;
    }
    else
    {
      point[0].x--;
      point[0].y-=2;
      point[1].y--;
      point[2].x++;
      point[3].y++;
    }
    make_shape_board(point);

  }

  public void moveDown()
  {
      moveDown(point);
  }
  public void moveRight()
  {
      moveRight(point);
  }
  public void moveLeft()
  {
      moveLeft(point);
  }
  void make_shape()
  {
    make_shape_board(point);
  }
}
class TShape extends Shape
{
  Hash point[];
  int rot_version;
  TShape()
  {
    //super();
    rot_version=1;
    point=new Hash[4];

    for(int i=0;i<point.length;i++)
    {
        point[i]=new Hash();
    }
    int ypoint=random_generate();
    point[0].x=1;
    point[0].y=ypoint-1;

    point[1].x=1;
    point[1].y=ypoint;

    point[2].x=1;
    point[2].y=ypoint+1;

    point[3].x=2;
    point[3].y=ypoint;

  }
  int random_generate()
  {
  int y;
  Random rand = new Random();
   int rand_int1 = rand.nextInt(17);
   y=rand_int1;
   if(y<2)
   random_generate();
   return y;

  }

  Hash[] getCoordinates()
  {
    return point;
  }
  public void rotateclockwise()
  {
    rot_version++;
    if(rot_version==5)
    rot_version=1;
  //  rotateclockwise(point,rot_version);
  for(int i=0;i<point.length;i++)
  {
    Board.board[point[i].x][point[i].y]=' ';
  }

    if(rot_version==2)
    {
      point[0].y++;
      point[1].x++;
      point[2].x+=2;
      point[2].y--;
      point[3].y--;
    }
    else if(rot_version==3)
    {
      point[0].x++;
      point[0].y++;
      point[2].x--;
      point[2].y--;
      point[3].x--;
      point[3].y++;
    }
    else if(rot_version==4)
    {
      point[0].x++;
      point[0].y-=2;
      point[1].y--;
      point[2].x--;
      point[3].x++;
    }
    else
    {
      point[0].x-=2;
      point[1].x--;
      point[1].y++;
      point[2].y+=2;
    }
    make_shape_board(point);
  }
  public void rotateanticlockwise()
  {
    rot_version--;
    if(rot_version==0)
    rot_version=4;
    //rotateclockwise(point,rot_version);
    for(int i=0;i<point.length;i++)
    {
      Board.board[point[i].x][point[i].y]=' ';
    }

    if(rot_version==2)
    {
      point[0].x--;
      point[0].y--;
      point[2].x++;
      point[2].y++;
      point[3].x++;
      point[3].y--;
    }
    else if(rot_version==3)
    {
      point[0].x--;
      point[0].y+=2;
      point[1].y++;
      point[2].x++;
      point[3].x--;
    }
    else if(rot_version==4)
    {
      point[0].x+=2;
      point[1].x++;
      point[1].y--;
      point[2].y-=2;
    }
    else
    {
      point[0].y--;
      point[1].x--;
      point[2].x-=2;
      point[2].y++;
      point[3].y++;
    }
    make_shape_board(point);

  }

  public void moveDown()
  {
      moveDown(point);
  }
  public void moveRight()
  {
      moveRight(point);
  }
  public void moveLeft()
  {
      moveLeft(point);
  }
  void make_shape()
  {
    make_shape_board(point);
  }
}
class SquareShape extends Shape
{
  Hash point[];
  int rot_version;
  SquareShape()
  {
    //super();
    rot_version=1;
    point=new Hash[4];

    for(int i=0;i<point.length;i++)
    {
        point[i]=new Hash();
    }
    int ypoint=random_generate();
    point[0].x=1;
    point[0].y=ypoint;

    point[1].x=1;
    point[1].y=ypoint+1;

    point[2].x=2;
    point[2].y=ypoint;

    point[3].x=2;
    point[3].y=ypoint+1;

  }
  int random_generate()
  {
  int y;
  Random rand = new Random();
   int rand_int1 = rand.nextInt(17);
   y=rand_int1;
   if(y<2)
   random_generate();
   return y;

  }

  Hash[] getCoordinates()
  {
    return point;
  }
  public void rotateclockwise()
  {
    make_shape_board(point);
  }
  public void rotateanticlockwise()
  {
    make_shape_board(point);

  }

  public void moveDown()
  {
      moveDown(point);
  }
  public void moveRight()
  {
      moveRight(point);
  }
  public void moveLeft()
  {
      moveLeft(point);
  }
  void make_shape()
  {
    make_shape_board(point);
  }
}

class HShape extends Shape
{
  Hash point[];
  int rot_version;
  HShape()
  {
    //super();
    rot_version=1;
    point=new Hash[4];

    for(int i=0;i<point.length;i++)
    {
        point[i]=new Hash();
    }
    int ypoint=random_generate();
    point[0].x=1;
    point[0].y=ypoint;

    point[1].x=2;
    point[1].y=ypoint;

    point[2].x=2;
    point[2].y=ypoint+1;

    point[3].x=3;
    point[3].y=ypoint+1;

  }
  int random_generate()
  {
  int y;
  Random rand = new Random();
   int rand_int1 = rand.nextInt(17);
   y=rand_int1;
   if(y<2)
   random_generate();
   return y;

  }

  Hash[] getCoordinates()
  {
    return point;
  }
  public void rotateclockwise()
  {
    rot_version++;
    if(rot_version==5)
    rot_version=1;
  //  rotateclockwise(point,rot_version);
  for(int i=0;i<point.length;i++)
  {
    Board.board[point[i].x][point[i].y]=' ';
  }

    if(rot_version==2)
    {
      point[0].y+=2;
      point[1].x--;
      point[1].y++;
      point[3].x--;
      point[3].y--;
    }
    else if(rot_version==3)
    {
      point[0].x+=2;
      point[0].y--;
      point[1].x++;
      point[2].y--;
      point[3].x--;
    }
    else if(rot_version==4)
    {
      point[0].x--;
      point[0].y--;
      point[2].x--;
      point[2].y++;
      point[3].y+=2;
    }
    else
    {
      point[0].x--;
      point[1].y--;
      point[2].x++;
      point[3].x+=2;
      point[3].y--;
    }
    make_shape_board(point);
  }
  public void rotateanticlockwise()
  {
    rot_version--;
    if(rot_version==0)
    rot_version=4;
    //rotateclockwise(point,rot_version);
    for(int i=0;i<point.length;i++)
    {
      Board.board[point[i].x][point[i].y]=' ';
    }

    if(rot_version==2)
    {
      point[0].x-=2;
      point[0].y++;
      point[1].x--;
      point[2].y++;
      point[3].x++;
    }
    else if(rot_version==3)
    {
      point[0].x++;
      point[0].y++;
      point[2].x++;
      point[2].y--;
      point[3].y-=2;
    }
    else if(rot_version==4)
    {
      point[0].x++;
      point[1].y++;
      point[2].x--;
      point[3].x-=2;
      point[3].y++;
    }
    else
    {
      point[0].y-=2;
      point[1].x++;
      point[1].y--;
      point[3].x++;
      point[3].y++;
    }
    make_shape_board(point);

  }

  public void moveDown()
  {
      moveDown(point);
  }
  public void moveRight()
  {
      moveRight(point);
  }
  public void moveLeft()
  {
      moveLeft(point);
  }
  void make_shape()
  {
    make_shape_board(point);
  }
}

public class Tetris
{
  public static Boolean checkCoordinates(Hash[] point)
  {
      for(int i=0;i<point.length;i++)
      {
          if(/*point[i].x>=18 || */point[i].y>18 || point[i].y<1)
          {
              return false;
          }
      }
      return true;
  }
  static Boolean check_down(Hash[] point)
  {
    //int c=1;
    for(int i=0;i<point.length;i++)
    {
        if(point[i].x==18 || Shape.move==0)
        {
            return false;
        }
    }
    return true;
  }
  static int random_shape()
  {
  int sh;
  Random rand = new Random();
   int rand_int1 = rand.nextInt(5);
   sh=rand_int1;
   if(sh<1)
   random_shape();
   return sh;

  }

  public static void main(String args[])
  {
    //static int move=1;
    int c=0;
    int shape_no;
    Scanner input = new Scanner(System.in);
    Board.makeBoardNull();
    Board.make_board();
    Board.show_board();
    Board.clearBoard();

    shape_no=random_shape();
    while(true)
    {
      Shape.move=1;
      if(c==1)
      break;
      switch(shape_no)
      {//move=1;
        //Shape.move=1;
              case 1:
              {
                IShape is=new IShape();
                is.make_shape();

                while(checkCoordinates(is.getCoordinates()))
                {
                  if(c==1)
                  break;
                  if(check_down(is.getCoordinates()))
                  { //is.move=1;
                  switch(input.next().charAt(0))
                  {
                    case 'a':
                    {
                      is.moveLeft();
                      break;
                    }
                    case 's':
                    {
                      is.moveDown();
                      break;
                    }
                    case 'd':
                    {
                      is.moveRight();
                      break;
                    }
                    case 'c':
                    {
                      is.rotateclockwise();
                      break;
                    }
                    case 'v':
                    {
                      is.rotateanticlockwise();
                      break;
                    }
                    case 'w':
                    {
                      c=1;
                      break;
                    }
                  }
                }
                  else
                  {
                    c=2;
                    break;
                  }
                  Board.clearConsole();

                  //is.moveDown();
                  Board.show_board();
                  //Board.delay();
                  //Board.clearBoard();
                  //Board.clearConsole();

                }
                if(c==1||c==2)
                break;
                System.out.println("Reached End");

              }


              case 2:
              {
                LShape ls=new LShape();
                ls.make_shape();

                while(checkCoordinates(ls.getCoordinates()))
                {
                  if(c==1)
                  break;
                  if(check_down(ls.getCoordinates()))
                  {//ls.move=1;

                  switch(input.next().charAt(0))
                  {
                    case 'a':
                    {
                      ls.moveLeft();
                      break;
                    }
                    case 's':
                    {
                      ls.moveDown();
                      break;
                    }
                    case 'd':
                    {
                      ls.moveRight();
                      break;
                    }
                    case 'c':
                    {
                      ls.rotateclockwise();
                      break;
                    }
                    case 'v':
                    {
                      ls.rotateanticlockwise();
                      break;
                    }
                    case 'w':
                    {
                      c=1;
                      break;
                    }
                  }
                }
                  else
                  {
                    c=2;
                    break;
                  }
                  Board.clearConsole();

                  //is.moveDown();
                  Board.show_board();
                  //Board.delay();
                  //Board.clearBoard();
                  //Board.clearConsole();

                }
                if(c==1||c==2)
                break;
                System.out.println("Reached End");

              }
              case 3:
              {
                TShape ts=new TShape();
                ts.make_shape();

                while(checkCoordinates(ts.getCoordinates()))
                {
                  if(c==1)
                  break;
                  if(check_down(ts.getCoordinates()))
                  {//ts.move=1;
                    switch(input.next().charAt(0))
                  {
                    case 'a':
                    {
                      ts.moveLeft();
                      break;
                    }
                    case 's':
                    {
                      ts.moveDown();
                      break;
                    }
                    case 'd':
                    {
                      ts.moveRight();
                      break;
                    }
                    case 'c':
                    {
                      ts.rotateclockwise();
                      break;
                    }
                    case 'v':
                    {
                      ts.rotateanticlockwise();
                      break;
                    }
                    case 'w':
                    {
                      c=1;
                      break;
                    }
                  }
                }
                  else
                  {
                    c=2;
                    break;
                  }
                  Board.clearConsole();

                  //is.moveDown();
                  Board.show_board();
                  //Board.delay();
                  //Board.clearBoard();
                  //Board.clearConsole();

                }
                if(c==1||c==2)
                break;
                System.out.println("Reached End");

              }
              case 4:
              {
                HShape hs=new HShape();
                hs.make_shape();

                while(checkCoordinates(hs.getCoordinates()))
                {
                  if(c==1)
                  break;
                  if(check_down(hs.getCoordinates()))
                  {//hs.move=1;
                  switch(input.next().charAt(0))
                  {
                    case 'a':
                    {
                      hs.moveLeft();
                      break;
                    }
                    case 's':
                    {
                      hs.moveDown();
                      break;
                    }
                    case 'd':
                    {
                      hs.moveRight();
                      break;
                    }
                    case 'c':
                    {
                      hs.rotateclockwise();
                      break;
                    }
                    case 'v':
                    {
                      hs.rotateanticlockwise();
                      break;
                    }
                    case 'w':
                    {
                      c=1;
                      break;
                    }
                  }
                }
                  else
                  {
                    c=2;
                    break;
                  }
                  Board.clearConsole();

                  //is.moveDown();
                  Board.show_board();
                  //Board.delay();
                  //Board.clearBoard();
                  //Board.clearConsole();

                }
                if(c==1||c==2)
                break;
                System.out.println("Reached End");

              }
              case 5:
              {
                SquareShape sqs=new SquareShape();
                sqs.make_shape();

                while(checkCoordinates(sqs.getCoordinates()))
                {
                  if(c==1)
                  break;
                  if(check_down(sqs.getCoordinates()))
                  {//sqs.move=1;
                    switch(input.next().charAt(0))
                  {
                    case 'a':
                    {
                      sqs.moveLeft();
                      break;
                    }
                    case 's':
                    {
                      sqs.moveDown();
                      break;
                    }
                    case 'd':
                    {
                      sqs.moveRight();
                      break;
                    }
                    case 'c':
                    {
                      sqs.rotateclockwise();
                      break;
                    }
                    case 'v':
                    {
                      sqs.rotateanticlockwise();
                      break;
                    }
                    case 'w':
                    {
                      c=1;
                      break;
                    }
                  }
                }
                  else
                  {
                    c=2;
                    break;
                  }
                  Board.clearConsole();

                  //is.moveDown();
                  Board.show_board();
                  //Board.delay();
                  //Board.clearBoard();
                  //Board.clearConsole();

                }
                if(c==1||c==2)
                break;
                System.out.println("Reached End");

              }
      }
      if(c==2)
      {
        shape_no=random_shape();
        c=0;
      }

    }


  }
}
