package ar.fiuba.tdd.template.tp0;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SetRE {

    private String word;
    private int quantity;
    private QuantificationsRE quantifications;
    private int newIndex;

    public SetRE(String word, int index, int quantity) {

        int indexEnd = word.indexOf("]",index);

        this.newIndex = indexEnd;

        this.word = word.substring(index+1,indexEnd);
        this.quantity = quantity;

        this.quantifications = new QuantificationsRE();

        if( indexEnd+1 < word.length() ) {

            this.quantifications.decide(word.charAt(indexEnd+1));

            this.newIndex = this.newIndex + this.quantifications.newIndex();

        }

    }

    public List<String> getCharacters() {

        ArrayList<String> words = new ArrayList<String>();

        for (int i=0;i<this.quantity;i++){

            String wordResult = "";

            int count = this.quantifications.quantity();

            for(int j=0;j<count;j++){

                wordResult = wordResult + this.getCharacter();

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

    private char getCharacter(){

        Random rnd = new Random();

        int position = (int) (rnd.nextDouble() * (this.word.length()));

        return this.word.charAt(position);

    }

}
