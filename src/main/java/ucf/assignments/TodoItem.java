/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Tanushka Kommoju
 */

package ucf.assignments;

import java.time.LocalDate;
import java.util.ArrayList;

public class TodoItem {

    private static String name;
    private static String description;
    private static LocalDate date;
    private static boolean isComplete;

    TodoItem(){
        isComplete = false;
    }

    public void setName(String newName){
        name = newName;
    }

    public String getName(){
        return name;
    }

    public void setComplete(boolean isComplete){
        //use GUI to set status
        TodoItem.isComplete = isComplete;
    }

    public boolean getComplete(){
        return isComplete;
    }

    public void setDescription(String description){
        //use GUI to set description
        if (description.length() < 256){
            TodoItem.description = description;

        } else {
            TodoItem.description = description.substring(0, 256);
        }
    }

    public String getDescription(){
        return description;
    }

    public void setDate(LocalDate date){
        //use GUI to set date
        TodoItem.date = date;
    }

    public LocalDate getDate(){
        return date;
    }

    public void fileToItem(ArrayList<String> list, int i){
        String[] splitArray = list.get(i).split("\\|");
        setDescription(splitArray[0].trim());
        setComplete(splitArray[1].trim().equals("Complete"));
        setDate(LocalDate.parse(splitArray[2].trim()));
    }
}

