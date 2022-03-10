import org.jetbrains.annotations.NotNull;

public class checkpw {

    public boolean length(@NotNull String pw){          //PW needs to be between 8 and 26 characters
        if(pw.length() >= 8 && pw.length() <= 25){
            return true;
        }else{
            return false;
        }
    }

    public boolean isCaseSensitive(@NotNull String pw){     //PW needs to have both lower and upper case characters
        if(pw.equals(pw.toLowerCase()) || pw.equals(pw.toUpperCase())){
            return false;
        }else{
            return  true;
        }
    }

    public boolean isAlphaNumeric(@NotNull String pw){      //PW needs to have at least 1 number
        if(pw.matches(".*[0-9].*") && (pw.matches(".*[A-Z].*")||pw.matches(".*[a-z].*"))){
            return true;
        }else{
            return false;
        }
    }

    public boolean containsSpecialCharacter(String pw){     //PW needs to at least use one of those special character "()#$?!%/@"
        if(pw.matches(".*[()#$?!%/@].*")){
            return true;
        }else{
            return false;
        }
    }

    public boolean checkAscendingNums(String pw){          //PW isn't allowed to have ascending numbers like 123 or 456 or repetitive numbers like 333

        char[] pwArr = pw.toCharArray();
        int numCnt = 0;


        for(int i = 0; i < pw.length(); i++){
            if(pwArr[i] >= 48 && pwArr[i] <= 57){        //ASCII 1 to 9 is 48 to 57
                numCnt++;                                  //cnt for every consecutive number
                if(numCnt == 3){
                    if(pwArr[i] == (pwArr[i-1]+1) && (pwArr[i-2]+2) == (pwArr[i-1]+1)){ //check if ascending
                        return false;
                    }
                    numCnt = 0;
                    i = i - 2;
                }
            }else{
                numCnt = 0;         //reset cnt if next character is not a number
            }
        }
        return true;
    }


    public boolean checkConsecutiveNums(String pw){
        return false;
    }

    public boolean checkForAll(String pw){
        if(
                length(pw)
            &&  isCaseSensitive(pw)
            &&  isAlphaNumeric(pw)
            &&  containsSpecialCharacter(pw)
            &&  checkAscendingNums(pw)
            &&  checkConsecutiveNums(pw)
        ){
            return true;
        }else{
            return false;
        }
    }


}


