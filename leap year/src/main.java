import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main 
{
    public static void main(String[] args) 
    {
        try (Scanner sc = new Scanner(System.in)) 
        {
            System.out.println("Enter the year");
            printValidValue(sc, "[0-9]+");
        }
    }

    static void printValidValue(Scanner sc, String pattern) 
    {
        while (sc.hasNextLine()) 
        {
            try 
            {
                int n = Integer.parseInt(sc.next(pattern));
                    if (n % 4 == 0 && (n % 100 != 0) 
                    		|| (n % 400 == 0)) 
                    {
                        System.out.println("this is a leap year");
                    }
	                    else
	                    {
	                        System.out.println("this is not a leap year");
	                    }
                break;
            } 
            catch (InputMismatchException s) 
            {
                System.out.println("not the correct value");
                sc.nextLine();
            }
        }
    }
}