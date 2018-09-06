import org.junit.Test;
import org.junit.Before;



import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class TestPiece {

    private Piece pawn;
    private Piece knight;
    private Piece bishop;

    @Test
    public void testPawnPossibleMoves() {
        pawn = new Piece(" ", "white", "d2");
        assertArrayEquals(new String[] {"e3", "d3", "c3"}, pawn.getPotentialMoves());
        pawn.setPosition("a2");
        assertArrayEquals(new String[] {"b3", "a3"}, pawn.getPotentialMoves());
        pawn.setPosition("h2");
        assertArrayEquals(new String[] {"h3", "g3"}, pawn.getPotentialMoves());
        pawn = new Piece(" ", "black", "e7");
        assertArrayEquals(new String[] {"f6", "e6", "d6"}, pawn.getPotentialMoves());
        pawn.setPosition("a7");
        assertArrayEquals(new String[] {"b6", "a6"}, pawn.getPotentialMoves());
        pawn.setPosition("h7");
        assertArrayEquals(new String[] {"h6", "g6"}, pawn.getPotentialMoves());
    }

    @Test
    public void testKnightPossibleMoves() {
        knight = new Piece("N", "white", "h1");
        assertArrayEquals(new String[] {"g3", "f2"}, knight.getPotentialMoves());
        knight.setPosition("a8");
        assertArrayEquals(new String[] {"b6", "c7"}, knight.getPotentialMoves());
        knight.setPosition("g2");
        assertArrayEquals(new String[] {"f4", "e3", "e1", "h4"}, knight.getPotentialMoves());
        knight.setPosition("e4");
        assertArrayEquals(new String[] {"d6", "c5", "c3", "d2", "f2", "g3", "g5", "f6"}, knight.getPotentialMoves());
    }

    @Test
    public void testBishopPossibleMoves() {
        bishop = new Piece("B", "white", "h1");
        assertArrayEquals(new String[] {"g2", "f3", "e4", "d5", "c6", "b7", "a8"}, bishop.getPotentialMoves());
        bishop.setPosition("a8");
        assertArrayEquals(new String[] {"b7", "c6", "d5", "e4", "f3", "g2", "h1"}, bishop.getPotentialMoves());
        bishop.setPosition("e4");
        assertArrayEquals(new String[] {"f3", "f5", "d3", "d5", "g2", "g6", "c2", "c6", "h1", "h7", "b1", "b7", "a8"}, bishop.getPotentialMoves());
    }
}
