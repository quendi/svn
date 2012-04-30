package domain.enums;

import java.io.Serializable;

import javax.swing.*;

public enum Building implements Serializable{
	Village(2),
	Castle(1),
	Town(3),
	Nothing(0);

    int points;

    Building(int points){
        this.points = points;
    }
}
