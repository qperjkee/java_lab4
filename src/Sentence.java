import java.util.Arrays;

/**
 * Represents a sentence composed of words and punctuation marks.
 * The {Sentence} class encapsulates an array of elements (words 
 * and punctuation) and provides methods to manipulate and access these elements.
 */
class Sentence {
    private Object[] elements;
    private int size;

    /**
     * Constructs a {Sentence} object with a specified initial capacity.
     *
     * @param capacity the initial capacity of the sentence
     */
    public Sentence(int capacity) {
        this.elements = new Object[capacity];
        this.size = 0;
    }

    /**
     * Checks if the sentence is empty.
     *
     * @return {true} if the sentence contains no elements; {false} otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the last element of the sentence.
     * If the sentence is empty, this method returns {null}.
     *
     * @return the last element of the sentence, or {null} if the sentence is empty
     */
    public Object getLastElement() {
        if (isEmpty()) {
            return null;
        }
        return elements[size - 1];
    }

    /**
     * Adds an element (word or punctuation) to the sentence.
     * If the current capacity is reached, the capacity of the elements array 
     * is doubled to accommodate the new element.
     *
     * @param element the element to be added to the sentence
     */
    public void addElement(Object element) {
        if (element instanceof Word || element instanceof Punctuation) {
            if (size == elements.length) {
                elements = Arrays.copyOf(elements, size * 2);
            }
            elements[size++] = element;
        }
    }

    /**
     * Returns the number of elements in the sentence.
     *
     * @return the length of the sentence
     */
    public int length() {
        return size;
    }

    /**
     * Returns the element at the specified index.
     *
     * @param index the index of the element to be returned
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public Object getElement(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return elements[index];
    }

    /**
     * Returns a string representation of the sentence.
     * This method concatenates all elements in the sentence, ensuring that
     * appropriate spaces are placed between words and punctuation marks.
     *
     * @return a string representation of the sentence
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(elements[i].toString());

            if (elements[i] instanceof Word) {
                if (i + 1 < size && !(elements[i + 1] instanceof Punctuation)) {
                    sb.append(" ");
                }
            } else if (elements[i] instanceof Punctuation) {
                if (i + 1 < size) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString().trim();
    }
}
