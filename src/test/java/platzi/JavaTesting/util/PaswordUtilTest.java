package platzi.JavaTesting.util;

import org.junit.Assert;
import org.junit.Test;
import platzi.JavaTesting.util.PaswordUtil.SecurityLevel.*;

import static org.junit.Assert.*;
import static platzi.JavaTesting.util.PaswordUtil.SecurityLevel.*;

public class PaswordUtilTest {

    @Test
    public void weak_when_has_less_than_8_letters(){
        Assert.assertEquals(WEAK,PaswordUtil.assessParword("1234568"));
    }

    @Test
    public void weak_has_only_letters(){
        Assert.assertEquals(WEAK,PaswordUtil.assessParword("abcedefgijk"));
    }

    @Test
    public void medium_when_has_letters_and_numbers(){
        Assert.assertEquals(MEDIUM,PaswordUtil.assessParword("1234abcd"));
    }

    @Test
    public void strng_when_has_letters_numbers_and_symbols(){
        Assert.assertEquals(STRONG, PaswordUtil.assessParword("1234abcd!"));
    }



}