package percent;

import java.util.Scanner;

public class main {
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        ///Числа, Процент, период
	        int num = scan.nextInt();
	        int percent = scan.nextInt();
	        int duration =  scan.nextInt();
        System.out.println(compoundInterest(num,percent,duration));
        System.out.println(compoundPercent(compoundInterest(num,percent,duration),num,duration));
    }
    public static double compoundInterest(double start, double percent, int duration) {
        return start * Math.pow(1 + percent/100, duration);
    }

    public static double compoundPercent(double start, int num, int duration) {
        return Math.round((Math.pow(start/num, 1.0 / duration)-1)*100);
    }
}