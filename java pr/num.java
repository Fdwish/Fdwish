import java.util.Scanner;

public class num
 {
    public static void main(String[] args)

  {
           Scanner input=new Scanner(System.in);

           System.out.println("enter x");
           int x=input.nextInt();
           System.out.print("enter y");
           int y=input.nextInt();


           if ( y % x == 0 && x != 0)
           System.out.printf("%d multiple of %d\n", y, x);

                     if (x > 0 || y++ > x)
                     System.out.printf("%d is also positive\n", y);
         }
       }
