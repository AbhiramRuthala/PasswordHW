//Name: Abhiram Ruthala
//Computing ID: kas4kj
//HW Name: HW 8 - Recursion
//Source Used: https://www.youtube.com/watch?v=k-7jJP7QFEM, Google AI, https://www.google.com/url?sa=i&url=https%3A%2F%2Fmedium.com%2F%40it20096298%2Frecursion-07d8005f1b40&psig=AOvVaw1yDsFIvbrahwzpjz1e_fhB&ust=1761872827098000&source=images&cd=vfe&opi=89978449&ved=0CAMQjB1qFwoTCPjX3PHdypADFQAAAAAdAAAAABAJ, ChatGPT 5 for Debugging

import java.util.Random;

public class Password {

    private String curPassword;

    public Password() {
        this.curPassword = "";
    }
    public Password(String curPassword) {
//        if(changePassword() == false)this.curPassword = curPassword;
//        if(numberOfDifferences(curPassword) >
        if(curPassword.contains("0") || curPassword.contains("1") || curPassword.contains("2") || curPassword.contains("3") || curPassword.contains("4") || curPassword.contains("5") || curPassword.contains("6") || curPassword.contains("7") || curPassword.contains("8") || curPassword.contains("9")) {
            this.curPassword = curPassword;
        } else {
            this.curPassword = "";
        }

    }
//
    public String getPassword() {
        return curPassword;
    }

    public boolean setPassword(String password) {
//        if(getPassword().length() > password.length()) {
//            for(int i = 0; i < (getPassword().length()-password.length()); i++) {
//                password = password + " ";
//            }
//        } else if (getPassword().length() < password.length()) {
//            for(int i = 0; i < (password.length()- getPassword().length()); i++) {
//                this.curPassword = this.curPassword + " ";
//            }
//        }
//
//        int counter = 0;
//        for(int i = 0; i < password.length(); i++) {
//            if (password.charAt(i) != curPassword.charAt(i)) {
//                counter++;
//            }
//        }

        if((password.contains("0") || password.contains("1") || password.contains("2") || password.contains("3") || password.contains("4") || password.contains("5") || password.contains("6") || password.contains("7") || password.contains("8") || password.contains("9")) && !(password.equals(this.curPassword)) && changePassword(this.curPassword, password)) {
            return true;
        } else{
            return false;
        }
    }

//    private boolean containsADigitRecursive(char number) {
//        if(curPassword.contains(String.valueOf(number))) {
//            return true;
//        } else {
//            containsADigitRecursive((char)(number+1));
//            return false;
//        }
//    }

    private boolean containsADigit(int index) {
        String[] sense = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        if(curPassword.contains(sense[index])) {
            return true;
        } else {
            return containsADigit(index+1);
        }
    }


//    recursive to see if it has at least 1 digit
//    private boolean containsCharacter(int index){
//
//
//        if(curPassword.contains("0")){
//            return true;
//        } else {
//            containsCharacter(2);
//        }
//
//
//        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
//        index = 0;
//        //int sense = digit.charValue();
//        if(index < 0 || index > 9){
//            return false;
//        } else {
//            if(curPassword.contains(numbers[index])) {
//                return true;
//            } else {
//                containsCharacter(index+1);
//            }
//        }
//
//        //should check false test case too.
//        return false;
//
//    }

    //other outlook to check if potential is equal to existing curPassword.
    private boolean checkIfPasswordIsEqualOrNot(String password, int index) {

        if(password.charAt(index) != getPassword().charAt(index)) {
            return false;
        } else {
            return checkIfPasswordIsEqualOrNot(password, index+1);
        }

    }

    private int checkNumberOfDifferences(String password, int index, int result) {
        if(getPassword().length() > password.length()) {
            for(int i = 0; i < (getPassword().length()-password.length()); i++) {
                password = password + " ";
            }
        } else if (getPassword().length() < password.length()) {
            for(int i = 0; i < (password.length()- getPassword().length()); i++) {
                this.curPassword = this.curPassword + " ";
            }
        }

        if(password.charAt(index) != getPassword().charAt(index)) {
            result+=1;
        }
        checkNumberOfDifferences(password, index+1, result);

        return result;
    }

//    //recursive - check number of differences between potential and new curPassword.
//    private int numberOfDifferences(String curPassword) {
//        int counter = 0;
//        for (int i = 0; i < curPassword.length(); i++) {
//            if (curPassword.charAt(i) != this.curPassword.charAt(i)) {
//                counter++;
//            }
//        }
//
//        return counter;
//    }


    private boolean checkDaDifferences(String password, int minimumDifferences) {
        int counter = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) != this.curPassword.charAt(i)) {
                counter++;
            }
        }

        if (counter < minimumDifferences) {
            return false;
        } else {
            return true;
        }
    }



    public boolean changePassword(String oldPassword, String newPassword){
        int counter = 0;
        int digitCount = 0;
//        String tempNewPassword = newPassword;
//        String tempOldPassword = oldPassword;
        String[] sense = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        if(newPassword.equals(oldPassword)){
            return false;
        }

        if(newPassword.length() - oldPassword.length() < 0) {
            for(int i = 0; i < (oldPassword.length() - newPassword.length()); i++) {
                newPassword = newPassword + " ";
            }

        } else if(newPassword.length() - oldPassword.length() > 0) {
            for(int i = 0; i < (newPassword.length() - oldPassword.length()); i++) {
                oldPassword = oldPassword + " ";
            }
        }

        for(int i = 0; i < newPassword.length(); i++){
            if(newPassword.charAt(i) != oldPassword.charAt(i)){
                counter++;
            }
        }
        for(int j = 0; j < newPassword.length(); j++){
            if(newPassword.contains(sense[j])){
                digitCount++;
            }
        }


//        if(Math.abs(newPassword.length()-oldPassword.length()) > oldPassword.length()/2 && digitCount > 0) {
//            return true;
//        } else if (counter > oldPassword.length()/2 && digitCount > 0) {
//            return true;
//        }

        if(counter > (oldPassword.length()/2) && digitCount > 0){
            return true;
        } else {
            return false;
        }

    }

    @Override
    public String toString() {
        Random rand = new Random();
        rand.nextInt();
        Character firstChar = curPassword.charAt(0);
        Character lastChar = curPassword.charAt(curPassword.length()-1);
        int newRandomValue = rand.nextInt(20);
        String passwordHide = "";
        for(int i = 0; i < newRandomValue; i++){
            passwordHide = passwordHide + "*";
        }
        String finalString = firstChar + passwordHide + lastChar;
        return finalString;
        //first and last characters of the curPassword alongside random asterisks and values.
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }
        if(obj instanceof Password){
            Password p2 = (Password)obj;
            if(p2.getPassword().equals(getPassword())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

}


//    //index value is reinstated every time we do the recursive. We need to change this.
//    private boolean checkPassword(String curPassword, int index){
//        index = 0;
//        int counter = 0;
//
//        if (curPassword.charAt(index) != this.curPassword.charAt(index)) {
//            return false;
//        }
//        if(counter > 0) {
//
//        }
//    }




