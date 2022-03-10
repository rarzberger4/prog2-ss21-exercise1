import org.jetbrains.annotations.NotNull;

public class checkpw {

    public boolean length(@NotNull String pw){
        if(pw.length() >= 8 && pw.length() <= 25){
            return true;
        }else{
            return false;
        }
    }

    public boolean isCaseSensitive(@NotNull String pw){
        if(pw.equals(pw.toLowerCase()) || pw.equals(pw.toUpperCase())){
            return false;
        }else{
            return  true;
        }
    }

    public boolean isAlphaNumeric(@NotNull String pw){
        if(pw.matches(".*[0-9].*") && (pw.matches(".*[A-Z].*")||pw.matches(".*[a-z].*"))){
            return true;
        }else{
            return false;
        }
    }

    public boolean containsSpecialCharacter(String pw){
        if(pw.matches(".*[()#$?!%/@].*")){
            return true;
        }else{
            return false;
        }
    }

    public boolean checkAscendingNums(String pw){
        return false;
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
        ){
            return true;
        }else{
            return false;
        }
    }


}


