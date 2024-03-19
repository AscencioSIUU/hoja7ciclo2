package uvg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileManager {
    public ArrayList<String> readTXTFile(String fileName) throws FileNotFoundException, IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName)));

        String line;
        ArrayList<String> arrayList = new ArrayList<String>();

        while (( line = reader.readLine()) != null){
            arrayList.add(line.toString());
        } 

        reader.close();
        return arrayList;
        
    }

    public void writeTXTFile(ArrayList<Integer> arrayList, String fileName, boolean isTest) throws IOException{
        String s = System.getProperty("java.class.path");
        String[] arr = s.split("target");
        String filePath;
        if(isTest){
            filePath = arr[0] + "src\\test\\resources\\" + fileName;
        }else{
            filePath = arr[0] + "src\\main\\resources\\" + fileName;
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

        for(Integer line : arrayList){
            String hi = line.toString();
            writer.write(line.toString()+"\n");
        }

        writer.close();
    }
}

