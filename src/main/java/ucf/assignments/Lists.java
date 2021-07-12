/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Tanushka Kommoju
 */

package ucf.assignments;

import javafx.stage.FileChooser;
import java.io.*;
import java.util.ArrayList;

public class Lists {
    
    public static String openFile(){
        //prompts user for file to open
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(null);
        if (file != null){
            return file.getAbsolutePath();
        }
        return "";
    }

    public static String saveFile(){
        //prompts user to save file
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setTitle("Save File");
        File file = fileChooser.showSaveDialog(null);
        if (file != null){
            return file.getAbsolutePath();
        }
        return "";
    }

    public static void writeToFile(String path, TodoList list){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            String complete;
            for(int i=0; i<list.getSize(); i++){
                if (list.getItem(i).getComplete()){
                    complete = "Complete";
                } else {
                    complete = "Incomplete";
                }
                bw.write(String.format("%-10s %-2s %-10s %-2s %-10s %-2s \n",
                        list.getItem(i).getDescription(), "|",
                        complete, "|",
                        list.getItem(i).getDate(), "|"));
            }
            bw.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public static ArrayList<String> readFromFile(String path){
        //reads data from file
        ArrayList<String> ret = new ArrayList<>();
        try{
            BufferedReader br =  new BufferedReader(new FileReader(path));
            String line = br.readLine();
            while(line != null){
                ret.add(line);
                line = br.readLine();
            }
            br.close();
        } catch(IOException e){
            return new ArrayList<>();
        }
        return ret;
    }


/*    public void addList(String name){
        //Make a new list name
    }

    public void removeList(String name){
        //find and remove list name
    }

    public String getItems(String name){
        //Find the name by loop
        //Make items by calling and adding to return string
        return "";
    }
    public String getLists(String name){
        //Call with a new line and add to a return string
        //return the string list
        return "";
    }

    public String getAllItems(String name){
        //Call and add to return string
        return "";
    }

    public void exportList(String name){
        //Add  to a text file for name
    }

    public void exportAllLists(){
        //Add to a text file for every list
    }

    public void loadList(String name){
        //Loop through text file until name is found
        //Make a new object
        //Add items from the text file
        //Add object to allLists
    }

    public void loadAllLists(){
        //Loop through text file
        //Make a new object
        //Add items from the text file
        //Add object to allLists
        //Repeat until the end
    }*/
}