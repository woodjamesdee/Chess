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

    /**
     * Gets the status of this Piece.
     * @return  the captured status of the Piece
     */
    public boolean getCaptured() {
        return this.captured;
    }

    /**
     * Sets this piece to be captured. Also updates the position to " ".
     */
    public void setCaptured() {
        this.captured = true;
        this.position = " ";
    }

    /**
     * Generates an array of potential moves for this Piece based on the current Board position.
     * Does not take into account other Pieces, but does consider the boundaries of the board.
     * @return  the possible moves of this Piece
     */
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
            if(!this.position.contains("a") && !this.position.contains("h")) { //Not an edge case
                returnArray = new String[] {Board.POSITIONS.get(currentPositionIndex - 7), Board.POSITIONS.get(currentPositionIndex + 1), Board.POSITIONS.get(currentPositionIndex + 9)};
            } else if(this.position.contains("a")) { //In file a
                returnArray = new String[] {Board.POSITIONS.get(currentPositionIndex - 7), Board.POSITIONS.get(currentPositionIndex + 1)};
            } else { //In file h
                returnArray = new String[] {Board.POSITIONS.get(currentPositionIndex + 1), Board.POSITIONS.get(currentPositionIndex + 9)};
            }
        } else {
            if(!this.position.contains("a") && !this.position.contains("h")) { //Not an edge case
                returnArray = new String[] {Board.POSITIONS.get(currentPositionIndex - 9), Board.POSITIONS.get(currentPositionIndex - 1), Board.POSITIONS.get(currentPositionIndex + 7)};
            } else if(this.position.contains("a")) { //In file a
                returnArray = new String[] {Board.POSITIONS.get(currentPositionIndex - 9), Board.POSITIONS.get(currentPositionIndex - 1)};
            } else { //In file h
                returnArray = new String[] {Board.POSITIONS.get(currentPositionIndex - 1), Board.POSITIONS.get(currentPositionIndex + 7)};
            }
        }
        return returnArray;
    }

    private String[] getPotentialKnightMoves() {
        ArrayList<String> positions = new ArrayList<String>(); //Because the number of moves isn't determined at this point
        int currentPositionIndex = Board.POSITIONS.indexOf(this.position);
        int[] ranks = new int[] {2, 1, -1, -2, -2, -1, 1, 2}; //Possible combinations of moves from the current index
        int[] files = new int[] {1, 2, 2, 1, -1, -2, -2, -1};
        for(int i = 0; i < ranks.length; i++) {
            int index = currentPositionIndex + (ranks[i] + 8 * files[i]); //The new index of the Knight
            if(!(index < 0 || index >= Board.POSITIONS.size())) { //If the index is not out of bounds of the Board array
                if(!(index % 8 > currentPositionIndex % 8 + 2 || index % 8 < currentPositionIndex % 8 - 2 )) //If the index is not more than two squares away in any direction
                positions.add(Board.POSITIONS.get(index));
            }
        }
        return positions.toArray(new String[0]);
    }

    private String[] getPotentialBishopMoves() {
        ArrayList<String> positions = new ArrayList<String>();
        int currentPositionIndex = Board.POSITIONS.indexOf(this.position);
        boolean canUpLeft = true;
        boolean canUpRight = true;
        boolean canDownLeft = true;
        boolean canDownRight = true;
        for(int i = 1; i < 8; i++) {
            int upLeft = (-9) * i + currentPositionIndex;
            int upRight = (-7) * i + currentPositionIndex;
            int downLeft = 7 * i + currentPositionIndex;
            int downRight = 9 * i + currentPositionIndex;
            if(!(upLeft < 0 || Math.abs((upLeft % 8) - (currentPositionIndex % 8)) != i) && canUpLeft) {
                positions.add(Board.POSITIONS.get(upLeft));
                if((upLeft % 8) - 1 < 0) {
                    canUpLeft = false;
                }
            } else {
                canUpLeft = false;
            }
            if(!(upRight < 0 || Math.abs((upRight % 8) - (currentPositionIndex % 8)) != i) && canUpRight) {
                positions.add(Board.POSITIONS.get(upRight));
                if((upRight % 8) + 1 > 7) {
                    canUpRight = false;
                }
            } else {
                canUpRight = false;
            }
            if(!(downLeft >= Board.POSITIONS.size() || Math.abs((downLeft % 8) - (currentPositionIndex % 8)) != i) && canDownLeft) {
                positions.add(Board.POSITIONS.get(downLeft));
                if((downLeft % 8) - 1 < 0) {
                    canDownLeft = false;
                }
                System.out.println(Board.POSITIONS.get(downLeft));
                System.out.println(downLeft % 8);
            } else {
                canDownLeft = false;
            }
            if(!(downRight >= Board.POSITIONS.size() || Math.abs((downRight % 8) - (currentPositionIndex % 8)) != i) && canDownRight) {
                positions.add(Board.POSITIONS.get(downRight));
                if((downRight % 8) + 1 > 7) {
                    canDownRight = false;
                }
            } else {
                canDownRight = false;
            }

        }
        return positions.toArray(new String[0]);
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
