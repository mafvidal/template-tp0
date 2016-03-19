package ar.fiuba.tdd.template.tp0;

public class QuantificationsRE {

    private boolean isQuantifications;
    private char sign;
    private int maxLength;

    public QuantificationsRE(){

        this.isQuantifications = false;

    }

    public void decide(char character) {

        this.sign = character;
        this.isQuantifications = (character == '+' || character == '*' || character == '?');

    }

    public int quantity() {

        switch (this.sign){

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

        if( this.isQuantifications )

            return Constants.INCREASE_QUANTIFICATIONS;

        else

            return 0;

    }

    public void setMax(int maxLength) {

        this.maxLength = maxLength;

    }

    private int quantityPlus() {

        return this.determineRandom(Constants.START_PLUS,this.maxLength);

    }

    private int quantityAsterisk() {

        return this.determineRandom(Constants.START_ASTERISK,this.maxLength);

    }

    private int quantityQuestion() {

        return this.determineRandom(Constants.START_QUESTION,Constants.END_QUESTION);

    }

    private int determineRandom(int start, int end) {

        return (int) (Math.random() * (end+1)) + start;

    }
}
