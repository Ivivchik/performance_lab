package Snake;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private List<Position> chains;
    private Directions directions;

    public Snake(List<Position> chains, Directions directions) {
        this.chains = chains;
        this.directions = directions;
    }

    public List<Position> getChains() {
        return chains;
    }

    public void setChains(List<Position> chains) {
        this.chains = chains;
    }

    public Directions getDirections() {
        return directions;
    }

    public void setDirections(Directions directions) {
        this.directions = directions;
    }


}
