package ar.fiuba.tdd.template.tp0;

public class LiteralRE implements CharactersRE {

    private char character;

    LiteralRE(char character) {

        this.character = character;

    }

    public String getCharacters() {

        return String.valueOf(this.character);

    }

}
