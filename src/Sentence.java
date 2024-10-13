import java.util.Arrays;

class Sentence {
    private Object[] elements;
    private int size;

    public Sentence(int capacity) {
        this.elements = new Object[capacity];
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object getLastElement() {
        if (isEmpty()) {
            return null;
        }
        return elements[size - 1];
    }

    public void addElement(Object element) {
        if (element instanceof Word || element instanceof Punctuation) {
            if (size == elements.length) {
                elements = Arrays.copyOf(elements, size * 2);
            }
            elements[size++] = element;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(elements[i].toString());
            if (elements[i] instanceof Word) {
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}