import java.util.Scanner;

public class age
 {
    public static void main(String[] args)

  {
           Scanner input=new Scanner(System.in);

            System.out.print("enter big name brother ");
            String bigname = input.next();

                  System.out.print("enter big age brother ");
                  int bigage = input.nextInt();

              System.out.print("enter small name brother ");
              String smallname = input.next();

                  System.out.print("enter small age brother ");
                  int smallage = input.nextInt();

  int diff = bigage - smallage;

       System.out.printf("\n your big brother %s (%d years) is %d years older than your small brother %s (%d years). \n"
       ,bigname,bigage,diff,smallname,smallage);

}
}
