package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.Logic;
import ru.job4j.chess.OccupiedCellException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {

    @Test
    void whenPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.position()).isEqualTo(Cell.C1);
    }

    @Test
    void whenCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Figure newBishopBlack = bishopBlack.copy(Cell.D2);
        Cell expected = Cell.D2;
        Cell rsl = newBishopBlack.position();
        assertEquals(expected, rsl);
    }

    @Test
    void whenWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(bishopBlack.way(Cell.G5)).isEqualTo(expected);
    }

    @Test
    void whenNotDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class,
                () -> {
            bishopBlack.way(Cell.C5);
                });
    }

    @Test
    void whenNotFree() {
        Logic logic = new Logic();
        logic.add(new BishopBlack((Cell.D4)));
        logic.add(new BishopBlack(Cell.F6));
        OccupiedCellException exception = assertThrows(OccupiedCellException.class,
                () -> {
            logic.move(Cell.D4, Cell.H8);
                });
    }
}