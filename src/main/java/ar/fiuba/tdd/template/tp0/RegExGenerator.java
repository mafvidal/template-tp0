package ar.fiuba.tdd.template.tp0;

import java.util.ArrayList;
import java.util.List;

public class RegExGenerator {

    private List<String> words;

    public RegExGenerator() {

        this.words = new ArrayList<>();

    }

    public List<String> generate(String regEx, int numberOfResults) {

        this.initializeList(numberOfResults);

        for (int index=0 ; index<regEx.length() ; index++) {

            if (regEx.charAt(index) == '/') {

                index = this.loadEscape(regEx, index+1, numberOfResults);

            } else if (regEx.charAt(index) == '[') {

                index = this.loadSet(regEx, index, numberOfResults);

            } else if (regEx.charAt(index) == '.') {

                index = this.loadPoint(regEx, index, numberOfResults);

            } else {

                index = this.loadEscape(regEx, index, numberOfResults);

            }

        }

        return this.words;

    }

    private int loadEscape(String regEx,int index,int numberOfResults) {

       EscapeRE escape = new EscapeRE(regEx, index, numberOfResults);

        this.save(escape.getCharacters());

        return escape.getNewIndex();

    }

    private int loadSet(String regEx,int index,int numberOfResults) {

        SetRE set = new SetRE(regEx, index, numberOfResults);

        this.save(set.getCharacters());

        return set.getNewIndex();

    }

    private int loadPoint(String regEx,int index,int numberOfResults) {

        PointRE point = new PointRE(regEx, index, numberOfResults);

        this.save(point.getCharacters());

        return point.getNewIndex();

    }

    private void save(List<String> characters) {

        for (int i=0;i<this.words.size();i++){

            this.words.set(i,this.words.get(i)+characters.get(i));

        }

    }

    private void initializeList(int numberOfResults){

        for (int i=0;i<numberOfResults;i++){

            this.words.add("");

        }

    }

}