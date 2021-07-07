import java.util.Scanner;

public class num1
 {
    public static void main(String[] args)

  {
           Scanner input=new Scanner(System.in);

           System.out.println("enter num1");
           int num1=input.nextInt();

           System.out.println("enter num2");
           int num2=input.nextInt();
           System.out.println("enter num3");
           int num3=input.nextInt();

            int min;
        min=num1;
          if(min > num2)
          min=num2;
          if (min > num3)
          min=num3;

        System.out.printf("min = %d " ,min);

          }
        }
