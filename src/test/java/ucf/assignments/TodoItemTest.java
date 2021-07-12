package ucf.assignments;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TodoItemTest {

    @Test
    void setName() { //ask the result of get() and input values

    }
    @Test
    void setDate() { //ask the result of get() and input values.
        TodoItem item = new TodoItem();
        LocalDate date = LocalDate.of(2002, 12, 3);
        item.setDate(date);
        assertEquals(date, item.getDate());
    }
    @Test
    void getDescription() {
        TodoItem item = new TodoItem();
        String desc = "Description";
        //when
        item.setDescription("Description");
        //then
        assertEquals(desc, item.getDescription());
    }

    @Test
    void setCompleteFlag() { //Create item and set complete to 'true'
        TodoItem item = new TodoItem();
        boolean status = true;
        item.setComplete(true);
        assertEquals(status, item.getComplete());

    }
/*    @Test
    void get() { //ask the result of get() and the input values

    }

    @Test
    void getIfComplete() { //call and work if the value is true.
    }*/
}