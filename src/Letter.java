/**
 * Represents a letter with a specific character value.
 * The {Letter} class encapsulates a single character and provides
 * methods to access its value and represent it as a string.
 */
class Letter {
    private char value;

    /**
     * Constructs a {Letter} object with the specified character value.
     *
     * @param value the character value of the letter
     */
    public Letter(char value) {
        this.value = value;
    }

    /**
     * Returns the character value of this letter.
     *
     * @return the character value of this letter
     */
    public char getValue() {
        return value;
    }

    /**
     * Checks if the letter is a consonant.
     *
     * @return {true} if the letter is a consonant, {false} otherwise
     */
    public boolean isConsonant() {
        return contains("bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ", value);
    }

    /**
     * Checks if a character is contained in a given string.
     *
     * @param str the string to search within
     * @param c the character to search for
     * @return {true} if the character is found in the string; {false} otherwise
     */
    private boolean contains(String str, char c) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a string representation of the letter.
     * This method converts the character value of the letter to a string.
     *
     * @return a string representation of the letter
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
