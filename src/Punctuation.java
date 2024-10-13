class Punctuation {
    private char value;

    public Punctuation(char value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}