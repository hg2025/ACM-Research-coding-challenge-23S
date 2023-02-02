import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class Stars {
    public static void main(String[] args) {
        String fileName = "C:\\temp\\Stars.csv";

        String [][] data = fileToArray(fileName,8);
        
        for(int i = 1; i < 12; i++)
            for(int j = 0; j < 7; j++)
            {
                if(Integer.valueOf(data[i][0]) > Integer.valueOf(data[i+1][0]))
                {
                    String [][] temp =  new String[12][7];
                    temp[i][j] = data[i][j];
                    data[i][j] = data[i+1][j];
                    data[i+1][j] = temp[i][j];
                }
            }

            
        for(int i = 0; i < 7; i++)
        {
            System.out.printf("| %-12s |" , data[0][i]);
        }

        System.out.println();
        System.out.printf("----------------------------------------------------------------------------------------------------------------%n");

        for(int i = 1; i < 12; i++)
        {
            for(int j = 0; j < 7; j++)
            {
                System.out.printf("| %-12s |" , data[i][j]);
            }
            System.out.println();
        }    
        
    }
    

public static String[][] fileToArray(String filePath, int cols) {
    List<String> list = new ArrayList<String>();

    String currentLine;
    String delimiter = ",";

    try{
        FileReader fRead = new FileReader(filePath);
        BufferedReader bRead = new BufferedReader(fRead);

        while((currentLine = bRead.readLine()) != null)
        {
            list.add(currentLine);
        }

        int count = list.size();

        String arrayReturned[][] = new String[count][cols];
        String[] data;

        for(int i = 0; i < count; i++)
        {
            data = list.get(i).split(delimiter);

            for(int j = 0; j < data.length; j++)
            {
                arrayReturned[i][j] = data[j];
            }
        }
        return arrayReturned;
    }
    catch(Exception e){
        System.out.println(e);
        return null;
    }
}

}
