package ar.fiuba.tdd.template.tp0;

import java.util.Random;

public class PointRE implements CharactersRE {

    public String getCharacters() {

        Random rnd = new Random();

        return String.valueOf((char) (rnd.nextInt(Constants.MAX_ASCII)));

    }

}