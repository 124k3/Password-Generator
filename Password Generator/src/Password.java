/*
 * Password class:
 * 
 * This class contains methods, 
 *      to check the type of character - asciiType(takes char) returns String
 *      to check the strength of password - passwordStrenth()
 */
public class Password {

    private String value;
    private int length;

    public Password(String password) {
        this.value = password;
        this.length = password.length();
    }

    public String asciiType(char C) {

        String currentCharType = null;

        // Char is Uppercase Letter
        if ((int) C >= 65 && (int) C <= 90)
            currentCharType = "uppercase";

        // Char is Lowercase Letter
        else if ((int) C >= 97 && (int) C <= 122) {
            currentCharType = "lowercase";
        }

        // Char is Digit
        else if ((int) C >= 60 && (int) C <= 71) {
            currentCharType = "number";
        }

        // Char is Symbol
        else {
            currentCharType = "symbol";
        }

        return currentCharType;
    }

    public int passwordStrength() {
        String password = this.value;
        boolean uppercase = false;
        boolean lowercase = false;
        boolean numbers = false; 
        boolean symbols = false;
        // boolean[] usedInPassword = {uppercase, lowercase, numbers, symbols};

        String asciiType = null; 
        int passwordStrengthScore = 0;

        for(int index = 0; index < password.length();  index++){
            char character = password.charAt(index);
            asciiType = asciiType(character);

            switch (asciiType) {
                case "uppercase":
                uppercase = true;
                passwordStrengthScore +=1;
                break;

                case "lowercase":
                lowercase = true;
                passwordStrengthScore +=1;
                break;

                case "number":
                numbers = true;
                passwordStrengthScore +=1;
                break;

                case "symbol":
                symbols = true;
                passwordStrengthScore +=1;
                break;

            }
        }

        if (password.length()>= 8 || password.length()>=16) {
            passwordStrengthScore +=1;
        }

        return passwordStrengthScore;
    }


    public String calculateScore() {
        int Score = this.passwordStrength();

        if (Score == 6) {
            return "This is a very good password :D check the Useful Information section to make sure it satisfies the guidelines";
        } else if (Score >= 4) {
            return "This is a good password :) but you can still do better";
        } else if (Score >= 3) {
            return "This is a medium password :/ try making it better";
        } else {
            return "This is a weak password :( definitely find a new one";
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
