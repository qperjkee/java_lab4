import java.util.Arrays;

class Word {
    private Letter[] letters;
    private int size;

    public Word(int capacity) {
        this.letters = new Letter[capacity];
        this.size = 0;
    }

    public void addLetter(Letter letter) {
        if (size == letters.length) {
            letters = Arrays.copyOf(letters, size * 2);
        }
        letters[size++] = letter;
    }

    public int length() {
        return size;
    }

    public Letter getFirstLetter() {
        return size > 0 ? letters[0] : null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(letters[i].toString());
        }
        return sb.toString();
    }
}
