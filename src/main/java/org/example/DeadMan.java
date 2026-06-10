package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DeadMan {
    List<String> words = List.of("house", "woman", "chair");
    String word;
    char[] userWord;
    int lives = 3;
    void Play(){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        word=words.get(random.nextInt(words.size()));
        userWord = new char[word.length()];
        Arrays.fill(userWord, '_');
        while(!EndGame()) {
            System.out.println(userWord);
            System.out.println("Give the letter");
            System.out.println("You have "+lives+" lives");
            char letter = scanner.nextLine().charAt(0);
            CheckLetters(letter);
        }
        System.out.println(userWord);
        if(lives==0){
            System.out.println("It was not it!");
        }
        else {
            System.out.println("Yes! You won!");
        }
        scanner.close();
    }

    private void CheckLetters(char letter){
        boolean found = false;
        for(int i=0; i<word.length(); i++){
            if(letter == word.charAt(i)){
                userWord[i]=letter;
                found = true;
            }
        }
        if(!found){
            lives--;
            System.out.println("This letter is not in the word!");
        }
    }
    private boolean EndGame(){
        return lives==0 || word.equals(String.valueOf(userWord));
    }

}
