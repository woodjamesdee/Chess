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
    private Piece rook;
    private Piece queen;
    private Piece king;

    @Test
    public void testPawnPossibleMoves() {
        pawn = new Piece(" ", "white", "d2");
        assertArrayEquals(new String[] {"e3", "d3", "c3"}, pawn.getPotentialMoves().get(0));
        pawn.setPosition("a2");
        assertArrayEquals(new String[] {"b3", "a3"}, pawn.getPotentialMoves().get(0));
        pawn.setPosition("h2");
        assertArrayEquals(new String[] {"h3", "g3"}, pawn.getPotentialMoves().get(0));
        pawn = new Piece(" ", "black", "e7");
        assertArrayEquals(new String[] {"f6", "e6", "d6"}, pawn.getPotentialMoves().get(0));
        pawn.setPosition("a7");
        assertArrayEquals(new String[] {"b6", "a6"}, pawn.getPotentialMoves().get(0));
        pawn.setPosition("h7");
        assertArrayEquals(new String[] {"h6", "g6"}, pawn.getPotentialMoves().get(0));
    }

    @Test
    public void testKnightPossibleMoves() {
        knight = new Piece("N", "white", "h1");
        assertArrayEquals(new String[] {"g3", "f2"}, knight.getPotentialMoves().get(0));
        knight.setPosition("a8");
        assertArrayEquals(new String[] {"b6", "c7"}, knight.getPotentialMoves().get(0));
        knight.setPosition("g2");
        assertArrayEquals(new String[] {"f4", "e3", "e1", "h4"}, knight.getPotentialMoves().get(0));
        knight.setPosition("e4");
        assertArrayEquals(new String[] {"d6", "c5", "c3", "d2", "f2", "g3", "g5", "f6"}, knight.getPotentialMoves().get(0));
    }

    @Test
    public void testBishopPossibleMoves() {
        bishop = new Piece("B", "white", "h1");
        assertArrayEquals(new String[] {}, bishop.getPotentialMoves().get(0));
        assertArrayEquals(new String[] {}, bishop.getPotentialMoves().get(1));
        assertArrayEquals(new String[] {}, bishop.getPotentialMoves().get(2));
        assertArrayEquals(new String[] {"g2", "f3", "e4", "d5", "c6", "b7", "a8"}, bishop.getPotentialMoves().get(3));
        bishop.setPosition("a8");
        assertArrayEquals(new String[] {"b7", "c6", "d5", "e4", "f3", "g2", "h1"}, bishop.getPotentialMoves().get(0));
        assertArrayEquals(new String[] {}, bishop.getPotentialMoves().get(1));
        assertArrayEquals(new String[] {}, bishop.getPotentialMoves().get(2));
        assertArrayEquals(new String[] {}, bishop.getPotentialMoves().get(3));
        bishop.setPosition("e4");
        assertArrayEquals(new String[] {"f3", "g2", "h1"}, bishop.getPotentialMoves().get(0));
        assertArrayEquals(new String[] {"f5", "g6", "h7"}, bishop.getPotentialMoves().get(1));
        assertArrayEquals(new String[] {"d3", "c2", "b1"}, bishop.getPotentialMoves().get(2));
        assertArrayEquals(new String[] {"d5", "c6", "b7", "a8"}, bishop.getPotentialMoves().get(3));
    }

    @Test
    public void testRookPossibleMoves() {
        rook = new Piece("R", "white", "h1");
        assertArrayEquals(new String[] {}, rook.getPotentialMoves().get(0));
        assertArrayEquals(new String[] {}, rook.getPotentialMoves().get(1));
        assertArrayEquals(new String[] {"h2", "h3", "h4", "h5", "h6", "h7", "h8"}, rook.getPotentialMoves().get(2));
        assertArrayEquals(new String[] {"g1", "f1", "e1", "d1", "c1", "b1", "a1"}, rook.getPotentialMoves().get(3));
        rook.setPosition("a8");
        assertArrayEquals(new String[] {"b8", "c8", "d8", "e8", "f8", "g8", "h8"}, rook.getPotentialMoves().get(0));
        assertArrayEquals(new String[] {"a7", "a6", "a5", "a4", "a3", "a2", "a1"}, rook.getPotentialMoves().get(1));
        assertArrayEquals(new String[] {}, rook.getPotentialMoves().get(2));
        assertArrayEquals(new String[] {}, rook.getPotentialMoves().get(3));
        rook.setPosition("e4");
        assertArrayEquals(new String[] {"f4", "g4", "h4"}, rook.getPotentialMoves().get(0));
        assertArrayEquals(new String[] {"e3", "e2", "e1"}, rook.getPotentialMoves().get(1));
        assertArrayEquals(new String[] {"e5", "e6", "e7", "e8"}, rook.getPotentialMoves().get(2));
        assertArrayEquals(new String[] {"d4", "c4", "b4", "a4"}, rook.getPotentialMoves().get(3));
    }

    @Test
    public void testKingPossibleMoves() {
        king = new Piece("K", "white", "h1");
        assertArrayEquals(new String[] {"h2", "g2", "g1"}, king.getPotentialMoves().get(0));
        king.setPosition("a8");
        assertArrayEquals(new String[] {"a7", "b7", "b8"}, king.getPotentialMoves().get(0));
        king.setPosition("e4");
        assertArrayEquals(new String[] {"d3", "e3", "f3", "f4", "f5", "e5", "d5", "d4"}, king.getPotentialMoves().get(0));
    }
}
