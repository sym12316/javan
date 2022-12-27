import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class main {
    public static void main(String[] args) throws IOException {
     //   System.out.println("Hello world!");

      /*  String str = "hello   hello world world world world";
        String pat = "(?!)\\b(\\w+)(?:\\s+\\1\\b)+";
        String res = str.replaceAll(pat, "$1");
        System.out.println(res); // => hello world
*/
        FileInputStream fis=new FileInputStream("Original.txt");
        FileOutputStream fos=new FileOutputStream("compressed.txt");
        DeflaterOutputStream dos=new DeflaterOutputStream(fos);

        int data;
        while ((data=fis.read())!=-1)
        {
            dos.write(data);
        }

        String str1 = readFileAsString("Original.txt");


        ArrayList<String> str2 = new ArrayList<>();



        String tmp = "";
        for(int i = 0; i < str1.length(); i++)
        {


            if(str1.charAt(i) == ' ' || str1.charAt(i) == '\n')
            {
                if(tmp != " ") {
                    str2.add(tmp);
                    tmp = "";
                }
            }else{
                if(tmp != " ") {
                    tmp += str1.charAt(i);
                }
            }
        }

       int n = 0;
        for(int j=0;j<str2.size();j++) 
        {
            for (int i = 0; i < str2.size(); i++) 
            {
                if (str2.get(i) == str2.get(j)) 
                {
                    str2.remove(i);
                    n++;
                }
            }
        }

        for(int i = 0; i < str2.size(); i++){
            System.out.println(str2.get(i));
        }


        fis.close();
        dos.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter("Original.txt", true));
        writer.append("\nrepeats " + n);
        writer.flush();
        FileInputStream fis1=new FileInputStream("compressed.txt");
        FileOutputStream fos1=new FileOutputStream("unpacked.txt");
        InflaterInputStream iis=new InflaterInputStream(fis1);

        int data1;
        while((data1=iis.read())!=-1)
        {
            fos1.write(data1);
        }

        fos1.close();
        iis.close();
    }


    private static String readFileAsString(String filePath) throws IOException 
    {
        StringBuffer fileData = new StringBuffer();
        BufferedReader reader = new BufferedReader(
                new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead=0;
        while((numRead=reader.read(buf)) != -1)
        {
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        return fileData.toString();
    }

}