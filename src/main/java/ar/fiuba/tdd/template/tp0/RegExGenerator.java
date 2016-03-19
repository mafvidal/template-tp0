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

        for (int index = 0 ;index < regEx.length() ;index++) {

            if (regEx.charAt(index) == '\\') {

                index = this.loadLiteral(regEx, index + 1, numberOfResults);

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

    private int loadLiteral(String regEx,int index,int numberOfResults) {

        TypeRE type = new TypeRE(regEx,index,numberOfResults);

        this.save(type.literal());

        return type.getNewIndex();

    }

    private int loadSet(String regEx,int index,int numberOfResults) {

        TypeRE type = new TypeRE(regEx,index,numberOfResults);

        this.save(type.set());

        return type.getNewIndex();

    }

    private int loadPoint(String regEx,int index,int numberOfResults) {

        TypeRE type = new TypeRE(regEx,index,numberOfResults);

        this.save(type.point());

        return type.getNewIndex();

    }

    private void save(List<String> characters) {

        for (int i = 0;i < this.words.size();i++) {

            this.words.set(i,this.words.get(i) + characters.get(i));

        }

    }

    private void initializeList(int numberOfResults) {

        for (int i = 0;i < numberOfResults;i++) {

            this.words.add("");

        }

    }

}