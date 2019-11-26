package tudelft.ghappy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GHappyTest {

    @ParameterizedTest(name = "{0} - ({1}) = {2}")
    @CsvSource({
//            //Strings without g
//            "'No g string','', false", "'No g string','a', false", "'No g String','asdfhjtoe', false",
//            "'No g string','aofGks', false", "'No g string','aofGGks', false",

            // Only happy g
            "'Only happy g', 'asxggxsa', true", "'Only happy g', 'gg', true", "'Only happy g', 'aggxsagg', true",
            "'Only happy g', 'axgggxf', true", "'Only happy g', 'axgggggxfgg', true",

            // Only unhappy g
            "'Only unhappy g: one g', 'asxgxsa', false", "'Only unhappy g: single char string, one g', 'g', false", "'Only unhappy g: two g', 'agxsag', false",
            "'Only unhappy g: one g every tow char ', 'agsgdgfgGghgjg', false",

            //Happy and unhappy g
            "'Happy and unhappy g','agxggm', false", "'Happy and unhappy g','rgxgggx', false", "'Happy and unhappy g','aggxoigggjmg', false", "'Happy and unhappy g','aggloggningjigg', false",

    })
    public void testGHappy(String partition, String inputString, boolean expectedResult) {
        boolean result = new GHappy().gHappy(inputString);
        Assertions.assertEquals(expectedResult, result);
    }
}
