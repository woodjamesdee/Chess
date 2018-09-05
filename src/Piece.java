import java.util.ArrayList;
import java.util.Arrays;

public class Piece {

    public static final ArrayList<String> TYPES = new ArrayList<String>(Arrays.asList(new String[] {" ", "N", "B", "R", "Q", "K"}));
    public static final ArrayList<String> COLORS = new ArrayList<String>(Arrays.asList(new String[] {"white", "black"}));

    private String type;
    private String color;
    private String position;

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

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        if(!Piece.TYPES.contains(type)) {
            throw new IllegalArgumentException(type + " is not a valid type.");
        }
        this.type = type;
    }

    public String getColor() {
        return this.color;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        if(!Board.POSITIONS.contains(position)) {
            throw new IllegalArgumentException(position + " is not a valid position.");
        }
        this.position = position;
    }
}
