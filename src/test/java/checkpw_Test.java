import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class checkpw_Test {


    @DisplayName("check length <8 characters")
    @Test
    void test_checkLength_1(){
        Boolean actual = checkpw.length("xxxxxxx"); //7
        Boolean expected = false;
        assertEquals(expected, actual);
    }

    @DisplayName("check length >26 character")
    @Test
    void test_checkLength_2(){
        Boolean actual = checkpw.length("xxxxxxxxxxxxxxxxxxxxxxxxxx"); //27
        Boolean expected = false;
        assertEquals(expected, actual);
    }

    @DisplayName("check length 8 characters")
    @Test
    void test_checkLength_3(){
        Boolean actual = checkpw.length("xxxxxxxx"); //8
        Boolean expected = true;
        assertEquals(expected, actual);
    }

    @DisplayName("check length 26 characters")
    @Test
    void test_checkLength_4(){
        Boolean actual = checkpw.length("xxxxxxxxxxxxxxxxxxxxxxxxx"); //26
        Boolean expected = true;
        assertEquals(expected, actual);
    }

    @DisplayName("checkCaseSensitivity 1")
    @Test
    void test_checkCaseSensitivity_1(){
        Boolean actual = checkpw.isCaseSensitive("x");
        Boolean expected = false;
        assertEquals(expected, actual);
    }

    @DisplayName("checkCaseSensitivity 2")
    @Test
    void test_CaseSensitivity_2(){
        Boolean actual = checkpw.isCaseSensitive("xX");
        Boolean expected = true;
        assertEquals(expected, actual);
    }

    @DisplayName("checkCaseSensitivity 3")
    @Test
    void test_CaseSensitivity_3(){
        Boolean actual = checkpw.isCaseSensitive("xx1");
        Boolean expected = false;
        assertEquals(expected, actual);
    }

    @DisplayName("isAlphaNumeric 1")
    @Test
    void test_isAlphaNumeric_1(){
        Boolean actual = checkpw.isAlphaNumeric("password");
        Boolean expected = false;
        assertEquals(expected, actual);
    }

    @DisplayName("isAlphaNumeric 2")
    @Test
    void test_isAlphaNumeric_2(){
        Boolean actual = checkpw.isAlphaNumeric("password123");
        Boolean expected = true;
        assertEquals(expected, actual);
    }

    @DisplayName("specialChartacter 1")
    @Test
    void test_specialCharacter_1(){
        Boolean actual = checkpw.containsSpecialCharacter("a");
        Boolean expected = false;
        assertEquals(expected, actual);
    }

    @DisplayName("specialChartacter 2")
    @Test
    void test_specialCharacter_2(){
        Boolean actual = checkpw.containsSpecialCharacter("()#$?!%/@");
        Boolean expected = true;
        assertEquals(expected, actual);
    }

    @DisplayName("specialChartacter 3")
    @Test
    void test_specialCharacter_3(){
        Boolean actual = checkpw.containsSpecialCharacter("}][{=´`*+~'_<>|^°,.:;§");
        Boolean expected = false;
        assertEquals(expected, actual);
    }

    @DisplayName("Ascending Numbers 1")
    @Test
    void test_checkAscendingNums_1(){
        Boolean actual = checkpw.checkAscendingNums("112233445566");
        Boolean expected = true;
        assertEquals(expected, actual);
    }

    @DisplayName("Ascending Numbers 2")
    @Test
    void test_checkAscendingNums_2(){
        Boolean actual = checkpw.checkAscendingNums("password1321");
        Boolean expected = true;
        assertEquals(expected, actual);
    }

    @DisplayName("Ascending Numbers 3")
    @Test
    void test_checkAscendingNums_3(){
        Boolean actual = checkpw.checkAscendingNums("9876512364");
        Boolean expected = false;
        assertEquals(expected, actual);
    }

    @DisplayName("Consecutive Numbers 1")
    @Test
    void test_checkConsecutiveNums_1(){
        Boolean actual = checkpw.checkRepeatingNums("password1111");
        Boolean expected = false;
        assertEquals(expected, actual);
    }

    @DisplayName("Consecutive Numbers 2")
    @Test
    void test_checkConsecutiveNums_2(){
        Boolean actual = checkpw.checkRepeatingNums("password!111!!");
        Boolean expected = true;
        assertEquals(expected, actual);
    }

    @DisplayName("Check for all conditions 1")
    @Test
    void test_checkForAll_1(){
        Boolean actual = checkpw.checkForAll("Password111!");
        Boolean expected = true;
        assertEquals(expected, actual);
    }

    @DisplayName("Check for all conditions 2")
    @Test
    void test_checkForAll_2(){
        Boolean actual = checkpw.checkForAll("Password1111");
        Boolean expected = false;
        assertEquals(expected, actual);
    }

}
