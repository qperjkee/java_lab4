import java.util.Arrays;

/**
 * Represents a word composed of letters.
 * The {Word} class encapsulates an array of {Letter} objects 
 * and provides methods to manipulate and access its letters.
 */
class Word {
    private Letter[] letters;
    private int size;

    /**
     * Constructs a {Word} object with a specified initial capacity.
     *
     * @param capacity the initial capacity of the word
     */
    public Word(int capacity) {
        this.letters = new Letter[capacity];
        this.size = 0;
    }

    /**
     * Adds a letter to the word.
     * If the current capacity is reached, the capacity of the letter array 
     * is doubled to accommodate the new letter.
     *
     * @param letter the letter to be added to the word
     */
    public void addLetter(Letter letter) {
        if (size == letters.length) {
            letters = Arrays.copyOf(letters, size * 2);
        }
        letters[size++] = letter;
    }

    /**
     * Returns the number of letters in the word.
     *
     * @return the length of the word
     */
    public int length() {
        return size;
    }

    /**
     * Returns the first letter of the word.
     * If the word is empty, this method returns {null}.
     *
     * @return the first letter of the word, or {null} if the word is empty
     */
    public Letter getFirstLetter() {
        return size > 0 ? letters[0] : null;
    }

    /**
     * Returns a string representation of the word.
     * This method concatenates all letters in the word to form a string.
     *
     * @return a string representation of the word
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(letters[i].toString());
        }
        return sb.toString();
    }
}
