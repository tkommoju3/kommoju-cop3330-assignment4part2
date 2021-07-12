/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Tanushka Kommoju
 */

package ucf.assignments;


import java.time.LocalDate;
import java.util.ArrayList;

public class TodoList {

    private final ArrayList<TodoItem> items = new ArrayList<>();

    public int getSize(){
        return items.size();
    }
    public TodoItem getItem(int i){
        return items.get(i);
    }

    public void addItem(TodoItem item) {
        //add a new item
        this.items.add(item);
    }
    public void removeItem(int index) {
        //go through the items to find the requested item
        //Delete it
        this.items.remove(index);
    }

    public void clearList() {
        this.items.clear();
    }

    public ArrayList<String> getTitles() {
        //Loops through to do list of items
        //creates new list to display titles items
        ArrayList<String> titleList = new ArrayList<>();
        for (TodoItem item : items) {
            titleList.add(item.getDescription());
        }
        return titleList;
    }

    public ArrayList<LocalDate> getDates() {
        //Loops through to do list of items
        //creates new list to display dates of items
        ArrayList<LocalDate> dateList = new ArrayList<>();
        for (TodoItem item : items) {
            dateList.add(item.getDate());
        }
        return dateList;
    }
    public ArrayList<Boolean> getComplete() {
        //Loops through to do list of items and displays status\
        ArrayList<Boolean> completeList = new ArrayList<>();
        for (TodoItem item : items) {
            completeList.add(item.getComplete());
        }
        return completeList;
    }
    public ArrayList<String> isComplete() {
        //Loops through to do list of items and displays complete items
        ArrayList<String> titleList = new ArrayList<>();
        for (TodoItem item : items) {
            if (item.getComplete()) {
                titleList.add(item.getDescription());
            }
        }
        return titleList;
    }
    public ArrayList<String> isIncomplete() {
        //Loops through to do list of items and displays incomplete items
        ArrayList<String> titleList = new ArrayList<>();
        for (TodoItem item : items) {
            if (!item.getComplete()) {
                titleList.add(item.getDescription());
            }
        }
        return titleList;
    }

}


