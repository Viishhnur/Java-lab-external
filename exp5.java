/* 
5. Define a MyRectangle class with four public data members representing the x- and y-coordinates of the bottom-left vertex and top-right vertex of a rectangle, whose sides are parallel to 
the x- or y-axis.
For example, the statement new MyRectangle(20,80,30,90) creates a rectangle with bottom-left 
vertex at position (20,80), and top-right vertex at (30,90). 
(a) Write an area() method, which computes the area of a rectangle.
(b) Write the overlap(MyRectanglerect) method. This method returns a rectangle which is the 
overlapped region of two rectangles. In the event that there is no overlap, it should return a 
rectangle with both bottom-left vertex and top-right vertex at position (0,0).
(c) Using the overlap(MyRectanglerect) method written above, write the 
overlapAll(MyRectangle[] rectangles) method which returns the overlapped region of all the 
rectangles in the array. You may assume that there is at least one element in the array. Your 
method should be efficient in that the moment it finds that the overlapped region is empty, it 
should return a rectangle with both vertices at (0,0) immediately. 
(d) Write MySqaure.java, MySquare extends MyRectangle.
A square is defined by its bottom-left vertex and the length of its side. Complete the super( . . . ) 
statement in the constructor.
(e)Below is output of MySquare.java program when the user enters: 10 30 5.
Class MySquare: [(10,30); (15,35)] 
Area = 25
Override the toString() method in MyRectangle in order to get such output
*/

import java.util.Scanner;
class Rectangle{
    private int x1,y1,x2,y2;

    public Rectangle(int x1,int y1,int x2,int y2){
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
    }

    public int area(){
        return Math.abs((x2-x1)*(y2-y1));
    }

    // Now write a overlap method , takes a rectangle and returns a rectangle
    public Rectangle overlap(Rectangle r){
        int X1 = Math.max(x1,r.x1);
        int Y1 = Math.max(y1,r.y1);
        int X2 = Math.max(x2,r.x2);
        int Y2 = Math.max(y2,r.y2);

        if(X1>=X2 || Y1>=Y2){
            System.out.println("No overlap");
            return new Rectangle(0,0,0,0);
        }
        return new Rectangle(X1, Y1, X2, Y2);
        
    }

    public static Rectangle overlapAll(Rectangle[] rects){
        Rectangle res = rects[0];

        for(int i = 1 ; i < rects.length ; i++){
            res = res.overlap(rects[i]);
            if(res.area() == 0){
                return new Rectangle(0,0, 0, 0);
            }
        }
        return res;
    }
}

class Square extends Rectangle{
    int x,y,side;

    public Square(int x,int y,int side){
        super(x,y,x+1,y+1);
        this.x = x;
        this.y = y;
        this.side = side;
    }

    public int area(){
        return side * side;
    }

    public String toString(){
        return "Class MySquare : [(" + x + ","+ y + ") , (" + (x + side) + "," + (y+side) + ")]";
    }
}

public class exp5 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int side = sc.nextInt();

        Square sq = new Square(x, y, side);
        System.out.println(sq);
        System.out.println("Area = " + sq.area());

    }

}
