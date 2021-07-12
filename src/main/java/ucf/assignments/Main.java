/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Tanushka Kommoju
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.ArrayList;



public class Main {

    private final TodoList itemList = new TodoList();
    @FXML
    private ListView<String> toDoListItems;
    @FXML
    private TextField itemDescription;
    @FXML
    private RadioButton isComplete;
    @FXML
    private DatePicker itemDue;
    @FXML
    private RadioButton showCompleteItems;
    @FXML
    private ListView<String> completeItems;
    @FXML
    private ListView<LocalDate> toDoListDates;

    public void addItemClick() {
        //creates an item and sets values from user input
        TodoItem item = new TodoItem();
        item.setDescription(itemDescription.getText());
        if (itemDue.getValue() != null) {
            item.setDate((itemDue.getValue()));
        } else {
            item.setDescription("ERROR, Input valid date");
        }
        item.setComplete(isComplete.isSelected());
        itemList.addItem(item);
        setListItems();
        resetInputs();
    }

    public void openItemClick() {
        //opens file from user input
        String path = Lists.openFile();
        ArrayList<String> fileList = Lists.readFromFile(path);
        if (!path.equals("")) {
            for (int i = 0; i < fileList.size(); i++) {
                TodoItem item = new TodoItem();
                item.fileToItem(fileList, i);
                itemList.addItem(item);
            }
        }
        setListItems();
    }

    public void clearItemClick() {
        //clears items from list
        itemList.clearList();
        toDoListItems.getItems().clear();
        completeItems.getItems().clear();
        toDoListDates.getItems().clear();
        resetInputs();
    }

    public void removeItemClick() {
        //remove item
        try {
            if (toDoListItems.getSelectionModel().isEmpty()) {
                itemList.removeItem(toDoListDates.getSelectionModel().getSelectedIndex());

            } else {
                itemList.removeItem(toDoListItems.getSelectionModel().getSelectedIndex());
            }

        } catch (IndexOutOfBoundsException e) {
            TodoItem item = new TodoItem();
            item.setDescription("ERROR, Select item to remove");
            itemList.addItem(item);
        }
        setListItems();
        resetInputs();
    }

    public void setItemStatus() {
        //user inputs item status
        if (showCompleteItems.isSelected()) {
            ObservableList<String> list = FXCollections.observableArrayList(itemList.isComplete());
            completeItems.setItems(list);
        } else {
            ObservableList<String> list = FXCollections.observableArrayList(itemList.isIncomplete());
            completeItems.setItems(list);
        }
    }


    public void setListItems() {
        ObservableList<String> titleList = FXCollections.observableArrayList(itemList.getTitles());
        toDoListItems.setItems(titleList);
        ObservableList<String> completeList = FXCollections.observableArrayList(itemList.isIncomplete());
        completeItems.setItems(completeList);
        ObservableList<LocalDate> dateList = FXCollections.observableArrayList(itemList.getDates());
        toDoListDates.setItems(dateList);
    }

    public void resetInputs() {
        //default display
        itemDescription.clear();
        itemDue.setValue(null);
        isComplete.setSelected(false);
        showCompleteItems.setSelected(false);
    }

    public void editItemClick() {
        //user selects and edits an item from list
        try {
            if (!toDoListItems.getSelectionModel().isEmpty()) {
                itemDescription.setText(toDoListItems.getSelectionModel().getSelectedItem());
                itemDue.setValue(itemList.getDates().get(toDoListItems.getSelectionModel().getSelectedIndex()));
                isComplete.setSelected(itemList.getComplete().get(toDoListItems.getSelectionModel().getSelectedIndex()));
                itemList.removeItem(toDoListItems.getSelectionModel().getSelectedIndex());
            }
            if (!toDoListDates.getSelectionModel().isEmpty()) {
                itemDescription.setText(itemList.getItem(toDoListDates.getSelectionModel().getSelectedIndex()).getDescription());
                itemDue.setValue(itemList.getItem(toDoListDates.getSelectionModel().getSelectedIndex()).getDate());
                isComplete.setSelected(itemList.getItem(toDoListDates.getSelectionModel().getSelectedIndex()).getComplete());
                itemList.removeItem(toDoListDates.getSelectionModel().getSelectedIndex());
            }
            if (!completeItems.getSelectionModel().isEmpty()) {
                itemDescription.setText(itemList.getItem(completeItems.getSelectionModel().getSelectedIndex()).getDescription());
                itemDue.setValue(itemList.getItem(completeItems.getSelectionModel().getSelectedIndex()).getDate());
                isComplete.setSelected(itemList.getItem(completeItems.getSelectionModel().getSelectedIndex()).getComplete());
                itemList.removeItem(completeItems.getSelectionModel().getSelectedIndex());
            }
        } catch (IndexOutOfBoundsException e) {
            TodoItem item = new TodoItem();
            item.setDescription("ERROR, Select item to edit");
            itemList.addItem(item);
        }

        setListItems();
    }

    public void saveItemClick() {
        //saves user input to a file
        String path = Lists.saveFile();
        if (!path.equals("")) {
            Lists.writeToFile(path, itemList);
        }

    }

}

