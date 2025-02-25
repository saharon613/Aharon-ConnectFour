package aharon.ConnectFour;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ConnectBoardTest {

    @Test
    void isFull() {
        //given
        ConnectBoard board1 = new ConnectBoard(7, 6);

        //when
        board1.insert(3, 1);
        board1.insert(3, 2);
        board1.insert(3, 1);
        board1.insert(3, 2);
        board1.insert(3, 1);
        board1.insert(3, 2);

        //then
        assertTrue(board1.isFull(3));
    }

    @Test
    void insert() {
        //given
        ConnectBoard board1 = new ConnectBoard(7, 6);
        //when
        board1.insert(3, 1);
        //then
        assertEquals(1, board1.getBoard()[5][3]);
    }

    @Test
    void calculateWinner() {
        ConnectBoard board1 = new ConnectBoard(7, 6);

        board1.insert(3, 1);
        board1.insert(3, 2);
        board1.insert(3, 2);
        board1.insert(4, 1);
        board1.insert(5, 1);
        board1.insert(6, 1);

        assertEquals(1, board1.calculateWinner());
    }
}