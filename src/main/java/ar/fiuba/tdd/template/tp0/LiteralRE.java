package ar.fiuba.tdd.template.tp0;

import java.util.ArrayList;
import java.util.List;

public class LiteralRE {

    private char character;
    private int quantity;
    private QuantificationsRE quantifications;
    private int newIndex;

    LiteralRE(String word, int index, int quantity){

        this.character = word.charAt(index);

        this.newIndex = index;

        this.quantity = quantity;

        this.quantifications = new QuantificationsRE();

        if( this.newIndex+1 < word.length() ) {

            this.quantifications.decide(word.charAt(this.newIndex+1));

            this.newIndex = this.newIndex + this.quantifications.newIndex();

        }

    }

    public List<String> getCharacters() {

        ArrayList<String> words = new ArrayList<String>();

        for (int i=0;i<this.quantity;i++){

            String wordResult = "";

            int count = this.quantifications.quantity();

            for(int j=0;j<count;j++){

                wordResult = wordResult + this.character;

            }

            words.add(wordResult);

        }

        return words;

    }

    public int getNewIndex() {

        return this.newIndex;

    }

    public void SetMaxquantifications(int maxLength){

        this.quantifications.setMax(maxLength);

    }

}
