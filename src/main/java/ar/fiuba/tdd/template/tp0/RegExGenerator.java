package ar.fiuba.tdd.template.tp0;

import java.util.ArrayList;
import java.util.List;

public class RegExGenerator {

    private int maxLength;
    private List<String> words;

    public RegExGenerator(int maxLength) {

        this.maxLength = maxLength;
        this.words = new ArrayList<>();

    }

    public List<String> generate(String regEx, int numberOfResults) {

        this.initializeList(numberOfResults);

        for (int index=0 ; index<regEx.length() ; index++) {

            if (regEx.charAt(index) == '/') {

                index = this.loadEscape(regEx, index, numberOfResults);

            } else if (regEx.charAt(index) == '[') {

                index = this.loadSet(regEx, index, numberOfResults);

            } else if (regEx.charAt(index) == '.') {

                index = this.loadPoint(regEx, index, numberOfResults);

            } else {

                index = this.loadLiteral(regEx, index, numberOfResults);

            }

        }

        return this.words;

    }

    private int loadEscape(String regEx,int index,int numberOfResults) {

       /* EscapeRE escape = new EscapeRE(regEx, index, numberOfResults);

        escape.SetMaxquantifications(this.maxLength);

        this.save(escape.getCharacters());

        return escape.getNewIndex();*/

        return 66;

    }

    private int loadSet(String regEx,int index,int numberOfResults) {

        SetRE set = new SetRE(regEx, index, numberOfResults);

        set.SetMaxquantifications(this.maxLength);

        this.save(set.getCharacters());

        return set.getNewIndex();

    }

    private int loadPoint(String regEx,int index,int numberOfResults) {

        PointRE point = new PointRE(regEx, index, numberOfResults);

        point.SetMaxquantifications(this.maxLength);

        this.save(point.getCharacters());

        return point.getNewIndex();

    }

    private int loadLiteral(String regEx,int index,int numberOfResults) {

       /* LiteralRE literal = new LiteralRE(regEx, index, numberOfResults);

        literal.SetMaxquantifications(this.maxLength);

        this.save(literal.getCharacters());

        return literal.getNewIndex();*/
        return 1;

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