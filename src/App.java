public class App {
    private static boolean isConsonant(Letter letter) {
        char c = letter.getValue();
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
        Sentence currentSentence = new Sentence(10);

        for (int i = 0; i < text.length(); i++) {
            Sentence sentence = text.getSentence(i);
            for (int j = 0; j < sentence.length(); j++) {
                Object element = sentence.getElement(j);
                if (element instanceof Word) {
                    Word currentWord = (Word) element;
                    if (!(currentWord.length() == wordLength && isConsonant(currentWord.getFirstLetter()))) {
                        currentSentence.addElement(currentWord);
                    }
                } else if (element instanceof Punctuation) {
                    currentSentence.addElement(element);
                }
            }
        }

        if (!currentSentence.isEmpty()) {
            result.addSentence(currentSentence);
        }

        return result;
    }

    private static Sentence parseInputText(String inputText) {
        Sentence sentence = new Sentence(10);
        Word currentWord = new Word(10);

        for (int i = 0; i < inputText.length(); i++) {
            char c = inputText.charAt(i);
            if (Character.isWhitespace(c)) {
                if (currentWord.length() > 0) {
                    sentence.addElement(currentWord);
                    currentWord = new Word(10);
                }
            } else if (".,!?".indexOf(c) != -1) {
                if (currentWord.length() > 0) {
                    sentence.addElement(currentWord);
                    currentWord = new Word(10);
                }
                sentence.addElement(new Punctuation(c));
            } else {
                currentWord.addLetter(new Letter(c));
            }
        }

        if (currentWord.length() > 0) {
            sentence.addElement(currentWord);
        }
        return sentence;
    }

    public static void main(String[] args) {
        try {
            String inputText = "lorem ipsum dolor sit amet consectetur adipiscing, sed diam, non commod tempor. Ut enim ad minim veniam, quis nostr? dolor in cupa, qui - officia";
            int wordLength = 4;

            if (inputText == null || inputText.trim().isEmpty()) {
                throw new IllegalArgumentException("Input text cannot be null or empty.");
            }

            Text text = new Text(10);
            Sentence sentence = parseInputText(inputText);

            if (!sentence.isEmpty()) {
                text.addSentence(sentence);
            }

            Text processedText = removeWords(text, wordLength);

            System.out.println("Original text: " + inputText);
            System.out.println("Filtered text: " + processedText.toString());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred in main method: " + e.getMessage());
        }
    }
}
