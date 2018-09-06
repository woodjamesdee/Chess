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
    private boolean captured;

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
        this.captured = false;
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
        if(!Board.POSITIONS.contains(position)) {
            throw new IllegalArgumentException(position + " is not a valid position.");
        }
        this.position = position;
    }

    public boolean getCaptured() {
        return this.captured;
    }

    public void setCaptured() {
        this.captured = true;
        this.position = " ";
    }

    public String[] getPotentialMoves() {
        if(this.captured) {
            return null;
        }
        String[] returnArray = null;
        switch(this.type) {
            case " ":
                returnArray = this.getPotentialPawnMoves();
                break;
            case "N":
                returnArray = this.getPotentialKnightMoves();
                break;
            case "B":
                returnArray = this.getPotentialBishopMoves();
                break;
            case "R":
                returnArray = this.getPotentialRookMoves();
                break;
            case "Q":
                returnArray = this.getPotentialQueenMoves();
                break;
            case "K":
                returnArray = this.getPotentialKingMoves();
                break;
        }
        return returnArray;
    }

    private String[] getPotentialPawnMoves() {
        String[] returnArray;
        int currentPositionIndex = Board.POSITIONS.indexOf(this.position);
        if(this.color.equals("white")) {
            if(!this.position.contains("a") && !this.position.contains("h")) {
                returnArray = new String[] {Board.POSITIONS.get(currentPositionIndex - 7), Board.POSITIONS.get(currentPositionIndex + 1), Board.POSITIONS.get(currentPositionIndex + 9)};
            } else if(this.position.contains("a")) {
                returnArray = new String[] {Board.POSITIONS.get(currentPositionIndex - 7), Board.POSITIONS.get(currentPositionIndex + 1)};
            } else {
                returnArray = new String[] {Board.POSITIONS.get(currentPositionIndex + 1), Board.POSITIONS.get(currentPositionIndex + 9)};
            }
        } else {
            if(!this.position.contains("a") && !this.position.contains("h")) {
                returnArray = new String[] {Board.POSITIONS.get(currentPositionIndex - 9), Board.POSITIONS.get(currentPositionIndex - 1), Board.POSITIONS.get(currentPositionIndex + 7)};
            } else if(this.position.contains("a")) {
                returnArray = new String[] {Board.POSITIONS.get(currentPositionIndex - 9), Board.POSITIONS.get(currentPositionIndex - 1)};
            } else {
                returnArray = new String[] {Board.POSITIONS.get(currentPositionIndex - 1), Board.POSITIONS.get(currentPositionIndex + 7)};
            }
        }
        return returnArray;
    }

    /**
     *
     * @return
     */
    private String[] getPotentialKnightMoves() {
        ArrayList<String> positions = new ArrayList<String>();
        int currentPositionIndex = Board.POSITIONS.indexOf(this.position);
        int[] ranks = new int[] {2, 1, -1, -2, -2, -1, 1, 2};
        int[] files = new int[] {1, 2, 2, 1, -1, -2, -2, -1};
        for(int i = 0; i < 8; i++) {
            int index = currentPositionIndex + (ranks[i] + 8 * files[i]);
            if(!(index < 0 || index >= Board.POSITIONS.size())) {
                if(!(index % 8 > currentPositionIndex % 8 + 2 || index % 8 < currentPositionIndex % 8 - 2 ))
                positions.add(Board.POSITIONS.get(index));
            }
        }
        return positions.toArray(new String[0]);
    }

    private String[] getPotentialBishopMoves() {
        return null;
    }

    private String[] getPotentialRookMoves() {
        return null;
    }

    private String[] getPotentialQueenMoves() {
        return null;
    }

    private String[] getPotentialKingMoves() {
        return null;
    }
}
