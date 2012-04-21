package domain.enums;

public enum Terrain {
    Mountain(3),
    Forest(2),
    Plain(1),
    Lake(10); //TODO: find a better solution  now this just increases min knight to the point where nothing can be played on it

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
