package platzi.JavaTesting.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void repeat_string_once_time(){
        Assert.assertEquals("hola", StringUtil.repeat("hola",1));
    }

    @Test
    public void repeat_string_multiples_times(){
        Assert.assertEquals("holaholahola", StringUtil.repeat("hola",3));
    }

    @Test
    public void repeat_string_zero_times(){
        Assert.assertEquals("", StringUtil.repeat("hola",0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void repeat_string_negative_times(){
        StringUtil.repeat("hola", -1);
    }



    public static void main(String[] args) {
        String result = StringUtil.repeat("hola", 3);
        if (!result.equals("holaholahola")){
            System.out.println(result);
            System.out.println("ERROR");
        }


       String result2 = StringUtil.repeat("hola",1);
        if (!result2.equals("hola")){
            System.out.println("ERROR");
        }
    }




}