import java.util.Arrays;

/**
 * Represents a collection of sentences.
 * The {Text} class encapsulates an array of {Sentence} objects 
 * and provides methods to manipulate and access these sentences.
 */
class Text {
    private Sentence[] sentences;
    private int size;

    /**
     * Constructs a {Text} object with a specified initial capacity.
     *
     * @param capacity the initial capacity of the text
     */
    public Text(int capacity) {
        this.sentences = new Sentence[capacity];
        this.size = 0;
    }

    /**
     * Adds a sentence to the text.
     * If the current capacity is reached, the capacity of the sentences array 
     * is doubled to accommodate the new sentence.
     *
     * @param sentence the sentence to be added to the text
     */
    public void addSentence(Sentence sentence) {
        if (size == sentences.length) {
            sentences = Arrays.copyOf(sentences, size * 2);
        }
        sentences[size++] = sentence;
    }

    /**
     * Returns the number of sentences in the text.
     *
     * @return the length of the text
     */
    public int length() {
        return size;
    }

    /**
     * Returns the sentence at the specified index.
     *
     * @param index the index of the sentence to be returned
     * @return the sentence at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public Sentence getSentence(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return sentences[index];
    }

    /**
     * Returns a string representation of the text.
     * This method concatenates all sentences in the text, ensuring that
     * appropriate spaces are placed between sentences.
     *
     * @return a string representation of the text
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(sentences[i].toString()).append(" ");
        }
        return sb.toString().trim();
    }
}
