package domain.enums;

import java.io.Serializable;

public enum Terrain implements Serializable{
    Mountain(3),
    Forest(2),
    Plain(1),
    Lake(10); 

    int knightRestriction;

    Terrain(int knightRestriction){
        this.knightRestriction = knightRestriction;
    }

    public int getKnightRestriction() {
        return knightRestriction;
    }

}
