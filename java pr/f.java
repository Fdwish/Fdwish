import java.util.*;

public class f
{
public static void main(String[]args)
{
 Scanner input=new Scanner (System.in);



  System.out.println("enter vale of radius");
  int r=input.nextInt();

  System.out.printf("diameter= %d\n",2*r);
  System.out.printf("circumference %f\n", 2*3.14159*r);
  System.out.printf("area= %f\n" ,3.14159*r*r);
}
}
