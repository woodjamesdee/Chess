import java.util.ArrayList;
import java.util.Arrays;

public class Board {

    public static final ArrayList<String> POSITIONS = new ArrayList<String>(Arrays.asList(new String[] {
                                        "h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8",
                                        "g1", "g2", "g3", "g4", "g5", "g6", "g7", "g8",
                                        "f1", "f2", "f3", "f4", "f5", "f6", "f7", "f8",
                                        "e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8",
                                        "d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8",
                                        "c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8",
                                        "b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8",
                                        "a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8"}));

    private Piece[] pieces;

    /**
     * Creates a new Board without any Piece objects contained within it.
     */
    public Board() {
        this.pieces = new Piece[32];
    }

    /**
     * Initializes this board with Piece objects located at their standard locations for the start
     * of the typical game of Chess.
     */
    public void generateDefaultStart() {
        this.pieces[0] = new Piece("R", "white", "h1");
        this.pieces[1] = new Piece("N", "white", "g1");
        this.pieces[2] = new Piece("B", "white", "f1");
        this.pieces[3] = new Piece("Q", "white", "e1");
        this.pieces[4] = new Piece("K", "white", "d1");
        this.pieces[5] = new Piece("B", "white", "c1");
        this.pieces[6] = new Piece("N", "white", "b1");
        this.pieces[7] = new Piece("R", "white", "a1");
        this.pieces[8] = new Piece(" ", "white", "h2");
        this.pieces[9] = new Piece(" ", "white", "g2");
        this.pieces[10] = new Piece(" ", "white", "f2");
        this.pieces[11] = new Piece(" ", "white", "e2");
        this.pieces[12] = new Piece(" ", "white", "d2");
        this.pieces[13] = new Piece(" ", "white", "c2");
        this.pieces[14] = new Piece(" ", "white", "b2");
        this.pieces[15] = new Piece(" ", "white", "a2");
        this.pieces[16] = new Piece(" ", "black", "h7");
        this.pieces[17] = new Piece(" ", "black", "g7");
        this.pieces[18] = new Piece(" ", "black", "f7");
        this.pieces[19] = new Piece(" ", "black", "e7");
        this.pieces[20] = new Piece(" ", "black", "d7");
        this.pieces[21] = new Piece(" ", "black", "c7");
        this.pieces[22] = new Piece(" ", "black", "b7");
        this.pieces[23] = new Piece(" ", "black", "a7");
        this.pieces[24] = new Piece("R", "black", "h8");
        this.pieces[25] = new Piece("N", "black", "g8");
        this.pieces[26] = new Piece("B", "black", "f8");
        this.pieces[27] = new Piece("Q", "black", "e8");
        this.pieces[28] = new Piece("K", "black", "d8");
        this.pieces[29] = new Piece("B", "black", "c8");
        this.pieces[30] = new Piece("N", "black", "b8");
        this.pieces[31] = new Piece("R", "black", "a8");
    }
}
