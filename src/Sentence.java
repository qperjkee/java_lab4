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

    public int length() {
        return size;
    }

    public Object getElement(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return elements[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(elements[i].toString());
            
            if (elements[i] instanceof Word) {

                if (i + 1 < size && !(elements[i + 1] instanceof Punctuation)) {
                    sb.append(" ");
                }
            } 

            else if (elements[i] instanceof Punctuation) {
                if (i + 1 < size) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString().trim();
    }
}
