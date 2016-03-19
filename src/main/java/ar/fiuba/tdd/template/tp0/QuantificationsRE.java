package ar.fiuba.tdd.template.tp0;

public class QuantificationsRE {

    private boolean isQuantifications;
    private char sign;

    public QuantificationsRE(String word, int index) {

        this.isQuantifications = false;

        if ( index + 1 < word.length() ) {

            this.decide(word.charAt(index + 1));

        }

    }


    public void decide(char character) {

        this.sign = character;
        this.isQuantifications = (character == '+' || character == '*' || character == '?');

    }

    public int quantity() {

        switch (this.sign) {

            case '?' :

                return this.quantityQuestion();

            case '+' :

                return this.quantityPlus();

            case '*' :

                return this.quantityAsterisk();

            default  :

                return 1;

        }

    }

    public int newIndex() {

        if ( this.isQuantifications ) {

            return Constants.INCREASE_QUANTIFICATIONS;

        } else {

            return 0;

        }

    }

    private int quantityPlus() {

        return this.determineRandom(Constants.START_PLUS,Constants.MAX_LENGTH);

    }

    private int quantityAsterisk() {

        return this.determineRandom(Constants.START_ASTERISK,Constants.MAX_LENGTH);

    }

    private int quantityQuestion() {

        return this.determineRandom(Constants.START_QUESTION,Constants.END_QUESTION);

    }

    private int determineRandom(int start, int end) {

        int random = (int) (Math.random() * (end + 1)) + start;

        return random;

    }

}
