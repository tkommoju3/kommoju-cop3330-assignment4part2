package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListsTest {


        @Test
        void readFromFile() {
            Main lists = new Main();
            ArrayList<String> expected = new ArrayList<>();
            expected.add("brush  |  Incomplete |  2021-07-25 |");
            expected.add("wash face       |  Complete   |  2021-07-11 |");
            expected.add("drink water |  Complete   |  2021-07-19 |");
            assertEquals(expected, Lists.readFromFile(""));
        }
    }
/*
    @Test
    void addList() { //Add a list
    }
    @Test
    void removeList() { //Add a list, add a second list, then remove one
    }

    @Test
    void getLists() { //see outputs to added list
    }

    @Test
    void getListItems() { //add a list and items to it
    }

    @Test
    void getCompleteItems() { //Add a list with complete and incomplete items
    }
}*/
