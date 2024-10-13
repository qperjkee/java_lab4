import java.util.Arrays;

class Text {
    private Sentence[] sentences;
    private int size;

    public Text(int capacity) {
        this.sentences = new Sentence[capacity];
        this.size = 0;
    }

    public void addSentence(Sentence sentence) {
        if (size == sentences.length) {
            sentences = Arrays.copyOf(sentences, size * 2);
        }
        sentences[size++] = sentence;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(sentences[i].toString()).append(" ");
        }
        return sb.toString().trim();
    }
}
