package WordFrequencyAnalyzer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUtility {

    public static boolean createFile(String fileNameWithPath) {
        File file = new File(fileNameWithPath);
        boolean fileCreated = false;
        try {
            fileCreated=file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileCreated;
    }
    public static ArrayList<String> readAndPrintFile(String fname) {
        Scanner scan=null;
        ArrayList<String> sentences=new ArrayList<String>();
        try {
            File file=new File(fname);
            scan=new Scanner(file);
            while(scan.hasNext()){
                String line=scan.nextLine();
                // System.out.println(line);
                sentences.add(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(scan!=null)
                scan.close();
        }
        return sentences;
    }

    public static boolean writeToFile(String fname,String content){
        FileWriter fw =null;
        try {
            File file =new File(fname);
            if(!file.exists()){
                file.createNewFile();
            }
            fw = new FileWriter(file.getAbsoluteFile());
            fw.write(content);
            fw.close();
            System.out.println("Successfully written to file");
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean copyContent(String fname, String wname){
        FileWriter fw=null;
        try{
            File rfile =new File(fname);
            File wfile=new File(wname);
            fw=new FileWriter(wfile.getAbsoluteFile());
            Scanner scan=new Scanner(rfile);
            while(scan.hasNextLine()){
                String line= scan.nextLine();
                fw.write(line+"\n");

            }
            fw.close();
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean appendToFile(String fname,String content){
        try {
            FileWriter fw=new FileWriter(fname,true);
            fw.append(content);
            fw.append('\n');
            fw.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }



}
