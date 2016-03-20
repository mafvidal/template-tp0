package ar.fiuba.tdd.template.tp0;

import java.util.Random;

public class PointRE implements CharactersRE {

    public String getCharacters() {

        Random random = new Random();

        int randomNum = random.nextInt((Constants.MAX_ASCII - Constants.MIN_ASCII) + 1) + Constants.MIN_ASCII;

        return Character.toString((char) (randomNum));

    }

}