import org.jetbrains.annotations.NotNull;

public class Checkpw {

    public static boolean length(@NotNull String pw){          //PW needs to be between 8 and 25 characters
        if(pw.length() >= 8 && pw.length() <= 25){
            return true;
        }else{
            System.out.println("PW needs to have between 8 and 25 characters");
            return false;
        }
    }

    public static boolean isCaseSensitive(@NotNull String pw){     //PW needs to have both lower and upper case characters
        if(pw.equals(pw.toLowerCase()) || pw.equals(pw.toUpperCase())){
            System.out.println("PW needs to have lower and upper case characters");
            return false;
        }else{
            return  true;
        }
    }

    public static boolean isAlphaNumeric(@NotNull String pw){      //PW needs to have at least 1 number
        if(pw.matches(".*[0-9].*") && (pw.matches(".*[A-Z].*")||pw.matches(".*[a-z].*"))){
            return true;
        }else{
            System.out.println("PW needs to contain at least 1 number");
            return false;
        }
    }

    public static boolean containsSpecialCharacter(@NotNull String pw){     //PW needs to at least use one of those special character "()#$?!%/@"
        if(pw.matches(".*[()#$?!%/@].*")){
            return true;
        }else{
            System.out.println("PW needs to conatin at leats one of the following special characters: ()#$?!%/@");
            return false;
        }
    }

    public static boolean checkAscendingNums(@NotNull String pw){          //PW isn't allowed to have ascending numbers like 123 or 456 or repetitive numbers like 333

        char[] pwArr = pw.toCharArray();
        int numCnt = 0;


        for(int i = 0; i < pw.length(); i++){
            if(pwArr[i] >= 48 && pwArr[i] <= 57){        //ASCII 1 to 9 is 48 to 57
                numCnt++;                                  //cnt for every consecutive number
                if(numCnt == 3){
                    if(pwArr[i] == (pwArr[i-1]+1) && (pwArr[i-2]+2) == (pwArr[i-1]+1)){ //check if ascending
                        System.out.println("PW must not contain ascending numbers");
                        return false;
                    }
                    numCnt = 0;
                    i -= 2;
                }
            }else{
                numCnt = 0;         //reset cnt if next character is not a number
            }
        }
        return true;
    }

    public static boolean checkRepeatingNums(@NotNull String pw){
        char[] pwArr = pw.toCharArray();
        int numCnt = 0;

        for(int i = 0; i < pw.length(); i++){
            if(pwArr[i] >= 48 && pwArr[i] <= 57){       //ASCII 1 to 9 is 48 to 57
                numCnt++;
                if(numCnt == 4){
                    if(pwArr[i] == pwArr[i-1] && pwArr[i-1] == pwArr[i-2] && pwArr[i-2] == pwArr[i-3]){  //check if number repeats
                        System.out.println("PW must not contain repeating numbers");
                        return false;
                    }else{
                        numCnt = 0;
                        i -= 3;
                    }
                }
            }
        }
        return true;
    }

    public static boolean checkForAll(String pw){
        if(
                length(pw)
            &&  isCaseSensitive(pw)
            &&  isAlphaNumeric(pw)
            &&  containsSpecialCharacter(pw)
            &&  checkAscendingNums(pw)
            &&  checkRepeatingNums(pw)
        ){
            System.out.println("Your PW is secure!");
            return true;
        }else{
            System.out.println("Your PW is unsecure! Please try another!");
            return false;
        }
    }

}


