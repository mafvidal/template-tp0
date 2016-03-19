package ar.fiuba.tdd.template.tp0;

import java.util.ArrayList;
import java.util.List;

public class TypeRE {

    private String word;
    private QuantificationsRE quantifications;
    private int index;
    private int quantity;
    private int newIndex;


    public TypeRE(String word, int index, int quantity) {

        this.word = word;
        this.index = index;
        this.quantity = quantity;
        this.quantifications = new QuantificationsRE(word,this.index);

    }

    public List<String> point() {

        PointRE point = new PointRE();

        this.determineNewIndex();

        return this.getCharacters(point);

    }

    public List<String> set() {

        int indexEnd = word.indexOf("]",this.index);

        this.quantifications = new QuantificationsRE(word,indexEnd);

        this.word = word.substring(this.index + 1,indexEnd);

        this.index = indexEnd;

        SetRE set = new SetRE(this.word);

        this.determineNewIndex();

        return this.getCharacters(set);

    }

    public List<String> literal() {

        char character = this.word.charAt(this.index);

        LiteralRE literal = new LiteralRE(character);

        this.determineNewIndex();

        return this.getCharacters(literal);

    }

    public int getNewIndex() {

        return this.newIndex;

    }


    private List<String> getCharacters(CharactersRE charactersRE) {

        ArrayList<String> words = new ArrayList<>();

        for (int i = 0 ;i < this.quantity;i++) {

            StringBuffer buffer = new StringBuffer();

            int count = this.quantifications.quantity();

            for (int j = 0;j < count;j++) {

                buffer.append(charactersRE.getCharacters());

            }

            String wordResult = buffer.toString();

            words.add(wordResult);

        }

        return words;

    }

    private void determineNewIndex() {

        this.newIndex = this.index + this.quantifications.newIndex();

    }

}
