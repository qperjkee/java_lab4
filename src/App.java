public class App {
    private static boolean isConsonant(char c) {
        return "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".indexOf(c) != -1;
    }

    public static Text removeWords(Text text, int wordLength) {
        if (text == null) {
            throw new IllegalArgumentException("Input text cannot be null.");
        }
        if (wordLength <= 0) {
            throw new IllegalArgumentException("Word length must be greater than 0.");
        }

        Text result = new Text(10);
        Word currentWord = new Word(10);
        Sentence currentSentence = new Sentence(10);

        StringBuffer textBuffer = new StringBuffer(text.toString());
        int start = 0;
        boolean inWord = false;

        for (int i = 0; i < textBuffer.length(); i++) {
            char c = textBuffer.charAt(i);
            if (Character.isWhitespace(c)) {
                if (inWord) {
                    processWord(textBuffer.substring(start, i), currentWord, currentSentence, result, wordLength);
                    inWord = false;
                }
            } else if (".,!?".indexOf(c) != -1) {
                if (inWord) {
                    processWord(textBuffer.substring(start, i), currentWord, currentSentence, result, wordLength);
                    inWord = false;
                }

                if (!currentSentence.isEmpty()) {
                    if (currentSentence.getLastElement() instanceof Word) {
                        Word lastWord = (Word) currentSentence.getLastElement();
                        lastWord.addLetter(new Letter(c));
                    } else {
                        currentSentence.addElement(new Punctuation(c));
                    }
                }
            } else {
                if (!inWord) {
                    start = i;
                    inWord = true;
                }
            }
        }

        if (inWord) {
            processWord(textBuffer.substring(start), currentWord, currentSentence, result, wordLength);
        }

        if (!currentSentence.isEmpty()) {
            result.addSentence(currentSentence);
        }

        return result;
    }

    private static void processWord(String word, Word currentWord, Sentence currentSentence, Text result, int wordLength) {
        currentWord = new Word(word.length());
        for (int j = 0; j < word.length(); j++) {
            currentWord.addLetter(new Letter(word.charAt(j)));
        }
        if (!(currentWord.length() == wordLength && isConsonant(currentWord.getFirstLetter().getValue()))) {
            currentSentence.addElement(currentWord);
        }
    }

    public static void main(String[] args) {

    }
}
