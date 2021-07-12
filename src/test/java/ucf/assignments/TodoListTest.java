package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TodoListTest {

    @Test
    void addItem() { //Add an item, compare output to name and item
        TodoList actual = new TodoList();
        ArrayList<TodoItem> expected = new ArrayList<TodoItem>();
        TodoItem item = new TodoItem();
        actual.addItem(item);
        expected.add(item);
        assertEquals(expected.get(0).getDescription(), actual.getItem(0).getDescription());
    }


    @Test
    void removeItem() { //Remove the item, compare output to name
        TodoList actual = new TodoList();
        TodoItem item1 = new TodoItem();
        TodoItem item2 = new TodoItem();
        item1.setDescription("brush");
        item1.setComplete(false);
        item1.setDate(LocalDate.parse("2021-07-25"));
        item2.setDescription("wash face");
        item2.setComplete(true);
        item2.setDate(LocalDate.parse("2021-07-11"));
        ArrayList<TodoItem> expected = new ArrayList<TodoItem>();
        actual.addItem(item1);
        actual.addItem(item2);
        expected.add(item1);
        expected.add(item2);
        actual.removeItem(0);
        expected.remove(0);
        assertEquals(expected.get(0).getDescription(), actual.getItem(0).getDescription());
    }

    @Test
    void getItem() {
        TodoList actual = new TodoList();
        TodoItem item1 = new TodoItem();
        TodoItem item2 = new TodoItem();
        item1.setDescription("brush");
        item1.setComplete(false);
        item1.setDate(LocalDate.parse("2021-07-25"));
        item2.setDescription("wash face");
        item2.setComplete(true);
        item2.setDate(LocalDate.parse("2021-07-11"));
        ArrayList<TodoItem> expected = new ArrayList<TodoItem>();
        actual.addItem(item1);
        actual.addItem(item2);
        expected.add(item1);
        expected.add(item2);
        assertEquals(actual.getItem(0), expected.get(0));
    }

    @Test
    void isComplete() {
        TodoList actual = new TodoList();
        TodoItem item1 = new TodoItem();
        TodoItem item2 = new TodoItem();
        item1.setDescription("brush");
        item1.setComplete(false);
        item1.setDate(LocalDate.parse("2021-07-25"));
        item2.setDescription("wash face");
        item2.setComplete(true);
        item2.setDate(LocalDate.parse("2021-07-11"));
        ArrayList<String> expected = new ArrayList<String>();
        actual.addItem(item1);
        actual.addItem(item2);
        expected.add(" ");
        ArrayList<String> actualTitles = actual.isComplete();
        assertEquals(expected, actualTitles);
    }
    @Test
    void isIncomplete() {
        TodoList actual = new TodoList();
        TodoItem item1 = new TodoItem();
        TodoItem item2 = new TodoItem();
        item1.setDescription("brush");
        item1.setComplete(false);
        item1.setDate(LocalDate.parse("2021-07-25"));
        item2.setDescription("wash face");
        item2.setComplete(true);
        item2.setDate(LocalDate.parse("2021-07-11"));
        ArrayList<String> expected = new ArrayList<String>();
        actual.addItem(item1);
        actual.addItem(item2);
        expected.add("wash face");
        ArrayList<String> actualTitles = actual.isIncomplete();
        assertEquals(expected, actualTitles);
    }

}