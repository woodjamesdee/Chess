import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author woodjamesdee
 *
 * Models a playing piece from the game of Chess. Contains relevant data and methods pertaining to its use.
 */
public class Piece {

    public static final ArrayList<String> TYPES = new ArrayList<String>(Arrays.asList(new String[] {" ", "N", "B", "R", "Q", "K"}));
    public static final ArrayList<String> COLORS = new ArrayList<String>(Arrays.asList(new String[] {"white", "black"}));

    private String type;
    private String color;
    private String position;

    /**
     * Creates a new Piece with a given type, color, and position on the board.
     * @param type      the kind of piece, such as knight or rook
     * @param color     the color of the piece, white or black
     * @param position  the position of the piece on the board
     */
    public Piece(String type, String color, String position) {
        if(!Piece.TYPES.contains(type)) {
            throw new IllegalArgumentException(type + " is not a valid type.");
        }
        if(!Piece.COLORS.contains(color)) {
            throw new IllegalArgumentException(color + " is not a valid color.");
        }
        if(!Board.POSITIONS.contains(position)) {
            throw new IllegalArgumentException(position + " is not a valid position.");
        }
        this.type = type;
        this.color = color;
        this.position = position;
    }

    /**
     * Gets the kind of piece of this Piece object.
     * @return  the type of piece
     */
    public String getType() {
        return this.type;
    }

    /**
     * Allows for the modification of the type of piece, only useful for when pieces change during the game.
     * @param type  the new type of piece
     */
    public void setType(String type) {
        if(!Piece.TYPES.contains(type)) {
            throw new IllegalArgumentException(type + " is not a valid type.");
        }
        this.type = type;
    }

    /**
     * Gets the color of this Piece object.
     * @return  the color of the piece
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Gets the current board position of this Piece object.
     * @return  the board position
     */
    public String getPosition() {
        return this.position;
    }

    /**
     * Allows for the position of this piece to be modified.
     * @param position  the new position of the piece
     */
    public void setPosition(String position) {
        if(!Board.POSITIONS.contains(position) && !position.equals(" ")) {
            throw new IllegalArgumentException(position + " is not a valid position.");
        }
        this.position = position;
    }
}
