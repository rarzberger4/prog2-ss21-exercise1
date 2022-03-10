public class main {




    public static void main(String[] args) {
        String pw = "A2";


        checkpw checkpw = new checkpw();

        if(checkpw.length(pw)){
            System.out.println("Password length ok!\n");
        }else{
            System.out.println("Password needs to be within 8 and 25 characters\n");
        }

        if(checkpw.isCaseSensitive(pw)){
            System.out.println("Password case-sensitivity is ok!\n");
        }else{
            System.out.println("Password needs to contain upper and lower case characters\n");
        }

        if(checkpw.isAlphaNumeric(pw)){
            System.out.println("Password is alphanumeric!\n");
        }else{
            System.out.println("Password needs to contain characters and numbers\n");
        }

    }
}
