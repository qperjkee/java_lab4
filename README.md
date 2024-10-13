# Project Description

This project implements a text processing application that defines classes for managing letters, words, sentences, and texts. The main class, `App`, provides functionality to parse input text, remove words of a specific length that start with a consonant, and display the filtered results. The project showcases an object-oriented approach to text manipulation, allowing for clear representation and handling of text components.

## Running the Project

To run the project, follow these steps:

1. Navigate to the `.\src\` directory:
    ```bash
    cd .\src\
    ```

2. Run the command to build and execute the program:
    ```bash
    .\buildrun.cmd App
    ```

## Classes Overview

1. **Letter**: Represents a single character with functionality to retrieve its value.
2. **Word**: Represents a collection of letters, allowing the addition of letters and retrieval of word length.
3. **Punctuation**: Represents punctuation marks as individual characters.
4. **Sentence**: Represents a sequence of words and punctuation, providing methods to add elements, retrieve them, and get the last element.
5. **Text**: Represents a collection of sentences, with methods for adding sentences and retrieving them.
6. **App**: The main class that orchestrates the text processing logic, including parsing input text and filtering words.


## Description of Actions

Upon execution of the program, the following actions will be performed:

- The program defines a sample input text for processing.
- It initializes a `Text` object and parses the input text into `Sentence` and `Word` objects.
- The program filters the words, removing those of a specified length that start with a consonant.
- It prints the original and filtered text to the console.