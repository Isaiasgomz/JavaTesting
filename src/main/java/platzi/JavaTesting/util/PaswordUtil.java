package platzi.JavaTesting.util;

public class PaswordUtil {

    public enum SecurityLevel{
        WEAK,MEDIUM,STRONG
    }

    public static SecurityLevel assessParword (String pasword){
        if (pasword.length() < 8){
            return  SecurityLevel.WEAK;
        }

        if(pasword.matches("[a-zA-Z]+")){
            return SecurityLevel.WEAK;
        }

        if (pasword.matches("[a-zA-Z0-9]+")){
            return SecurityLevel.MEDIUM;
        }

        return SecurityLevel.STRONG;

    }
}
