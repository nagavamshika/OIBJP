package sample;



/* Java game “Guess a Number” that allows user to guess a random number that has been generated.

*/

import javax.swing.*;

public class NumberGuessingGame {

public static void main(String[] args) {

int compNum = (int) (Math.random()*100 + 1);

int usernum = 0;

System.out.println("The correct guess would be " + compNum);

int count = 1;

while (usernum != compNum)

{

String response = JOptionPane.showInputDialog(null,

"Enter a guess between 1 and 100", "Guessing Game", 3);

usernum = Integer.parseInt(response);

JOptionPane.showMessageDialog(null, ""+ determineGuess(usernum, compNum, count));

count++;

}

}

public static String determineGuess(int usernum, int compNum, int count){

if (usernum <=0 || usernum >100) {

return"Your guess is invalid";

}

else if (usernum == compNum ){

return"Correct!\nThe number was: "+compNum+"\nTotal Guesses: " + count+"\nYour score is: "+(11-count)*10+" out of 100";

}

else if (usernum > compNum) {

return "Wrong number,guess a lower number.\nTry Number: " + count;

}

else if (usernum < compNum) {

return "Wrong number, guess a higher number.\nTry Number: " + count;

}

else {

return"Your guess is incorrect\nTry Number: " + count;

}

}

}
