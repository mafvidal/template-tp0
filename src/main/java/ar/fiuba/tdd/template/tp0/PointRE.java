package ar.fiuba.tdd.template.tp0;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by mafv on 19/03/16.
 */
public class PointRE {

    private int quantity;
    private QuantificationsRE quantifications;
    private int newIndex;

    public PointRE(String word, int index, int quantity){

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

        return  (char) (rnd.nextDouble() * Constants.MAX_ASCII );

    }

}
