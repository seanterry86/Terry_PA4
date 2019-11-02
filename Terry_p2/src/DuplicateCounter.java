import java.util.*;
import java.io.*;

public class DuplicateCounter {
    private int wordCounter;
    private Map<String, Integer> dataFileMap;
    public DuplicateCounter() {
        this.dataFileMap = new HashMap<String, Integer>();
    }

    public void count(String dataFile) throws FileNotFoundException {
        Scanner input = new Scanner(new File(dataFile));

        while (input.hasNext()) {
            String word = input.next();
            Integer count = dataFileMap.get(word);
            wordCounter++;
            if (count != null) {
                count = count + 1;
            } else {
                count = 1;
            }
            dataFileMap.put(word, count);
        }



    }

    public void write(String outputFile) throws IOException
    {
        FileWriter fw=new FileWriter(new File(outputFile));
        for (Map.Entry<String, Integer> map : dataFileMap.entrySet())
            fw.write(map.getKey() + " " + map.getValue()+"\n");

        fw.write("NO of words in the file :"+wordCounter+"\n");
        fw.close();

    }
}
