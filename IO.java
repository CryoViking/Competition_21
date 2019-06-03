import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class IO
{
    public static String getString(String prompt)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        return sc.nextLine();
    }//END getString

    public static Map constructMapSize(String fileName)
    {
        FileInputStream fileStream = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        String line = null;
        int counter = 0;
        int width = 0;
        try
        {
            fileStream = new FileInputStream(fileName);
            rdr = new InputStreamReader(fileStream);
            bufRdr = new BufferedReader(rdr);
            line = bufRdr.readLine();
            width = line.length();
            while(line != null)
            {
                line = bufRdr.readLine();
                counter++;
            }//END WHILE
        }
        catch(IOException ex){/*Do nothing*/}//END CATCH
        finally{try{if(fileStream!=null)fileStream.close();}catch(IOException ex){/*Do Nothing*/}}
        Map map = new Map(width, counter);
        readInMap(fileName, map);
        return map;
    }//EBD constructMapSize

    public static void readInMap(String fileName, Map map)
    {
        FileInputStream fileStream = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        String line;
        try
        {
            fileStream = new FileInputStream(fileName);
            rdr = new InputStreamReader(fileStream);
            bufRdr = new BufferedReader(rdr);
            do
            {
                line = bufRdr.readLine();
                if(line!=null)
                    for(char c : line.toCharArray())
                        map.addNextTile(c);
            }while(line != null);//END WHILE
        }//END TRY
        catch(IOException ex){/*Do nothing*/}//END CATCH
        finally{try{if(fileStream!=null)fileStream.close();}catch(IOException ex){/*Do Nothing*/}}
    }//END readInMap
}//END class IO