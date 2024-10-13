/**
 * Represents a punctuation mark with a specific character value.
 * The {Punctuation} class encapsulates a single punctuation character 
 * and provides a method to represent it as a string.
 */
class Punctuation {
    private char value;

    /**
     * Constructs a {Punctuation} object with the specified character value.
     *
     * @param value the character value of the punctuation mark
     */
    public Punctuation(char value) {
        this.value = value;
    }

    /**
     * Returns a string representation of the punctuation mark.
     * This method converts the character value of the punctuation mark to a string.
     *
     * @return a string representation of the punctuation mark
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
