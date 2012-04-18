package domain.enums;

public enum Terrain {
    Mountain(1),
    Forest(2),
    Plain(3),
    Lake(0);

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
