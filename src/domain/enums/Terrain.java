package domain.enums;

public enum Terrain {
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

    public void setKnightRestriction(int knightRestriction) {
        this.knightRestriction = knightRestriction;
    }
}
