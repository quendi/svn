package domain.enums;

import javax.swing.*;

public enum Building {
	Village(2),
	Castle(1),
	Town(3),
	Nothing(0);

    int points;

    Building(int points){
        this.points = points;
    }
}
