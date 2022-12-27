package Bubble;

public class main 
{
    public static void main(String[] args) 
    {
        int[] array = {
        		15, 20, 1, 3, 13, 9, 6, 14, 18, 16, 6, 8, 1,
        		19, 5, 8, 1, 5, 9, 15, 4, 10, 3, 19, 11, 10,  
        		5, 7, 4, 16, 14, 20, 19, 9, 11, 14, 4, 4, 5, 
        		10, 19, 14, 5, 15, 7, 12, 2, 10, 18, 8, 9, 
        		12, 2, 5, 12, 6, 4, 13, 4, 9, 14, 2, 11, 19,
        		11, 3, 3, 18, 20, 7, 19, 5, 13, 16, 12, 11,
        		2, 18, 8, 20, 19, 18, 6, 10, 13, 17, 4, 18,
        		13, 1, 16, 4, 18, 20, 1, 11, 2, 11, 20, 19,
        		1, 2, 1, 21, 1, 1, 4, 5, 3, 4, 8, 6};
        for (int out = array.length - 1; out >= 1; out--) 
        {
            for (int in = 0; in < out; in++) 
            {
                if (array[in] > array[in + 1]) 
                {
                    int tmp = array[in];
                    array[in] = array[in+1] ;
                    array[in+1] = tmp;
                }
            }
        }
        for(int i = 0;i<array.length;i++)
        	{System.out.println(array[i]);}
    }
}