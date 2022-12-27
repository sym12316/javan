import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Float.parseFloat;

public class Main {

    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int n = 0;
        ArrayList<String> arr = new ArrayList<>();
        String tmp = "";
        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == '+' 
            		|| str.charAt(i) == '-' 
            		|| str.charAt(i) == '*' 
            		|| str.charAt(i) == '/')
            {
                   if(tmp != "") 
                   {
                       arr.add(tmp);
                       tmp = "";
                   }
                   arr.add(String.valueOf(str.charAt(i)));
            }
	            else
	            {
	                if(str.charAt(i) != ' ') 
	                {tmp += str.charAt(i);}
	            }
            
            if(i == str.length()-1)
            {
                arr.add(tmp);
            }
        }
///2*6.5
        float res = parseFloat(arr.get(0));

        for(int i = 0; i < arr.size(); i++)
        {
            if(i+1 < arr.size()){
                if(arr.get(i+1).equals("+"))
                {

                    if(i+2 < arr.size())
                    {
                        res += parseFloat(arr.get(i+2));

                    }
                }
                if(arr.get(i+1).equals("-"))
                {
                    if(arr.get(i+2)!=null)
                    {
                        res -= parseFloat(arr.get(i+2));
                    }
                }
                if(arr.get(i+1).equals("*"))
                {
                    if(arr.get(i+2)!=null)
                    {
                        res *= parseFloat(arr.get(i+2));
                    }
                }
                if(arr.get(i+1).equals("/"))
                {
                    if(arr.get(i+2)!=null)
                    {
                        res /= parseFloat(arr.get(i+2));
                    }
                }
            }
        }

        System.out.println(res);
    }
}