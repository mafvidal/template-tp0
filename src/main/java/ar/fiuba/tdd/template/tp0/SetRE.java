package ar.fiuba.tdd.template.tp0;

import java.util.Random;

public class SetRE implements CharactersRE {

    private String word;

    SetRE(String word) {

        //this.word = word;
        this.word = word.replaceAll("\\\\", "");

    }

    public String getCharacters() {

        Random rnd = new Random();

        int position = rnd.nextInt(this.word.length());

        return String.valueOf(this.word.charAt(position));

    }

}
