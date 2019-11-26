package tudelft.caesarshift;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CaesarShiftCipherTest {

    @ParameterizedTest(name = "{0} - ({1}, {2}) = {3}")
    @CsvSource({
            //Invalid string
            "'Invalid String', 'G', 0, 'invalid'", "'Invalid String', '# ', 5, 'invalid'", "'Invalid String', 'T oiewubrigh', -20, 'invalid'",
            // Valid String positive shift
            "'Valid String and positive shift', '', 2, ''", "'Valid String and positive shift','a',3,'d' ",
            "'Valid String and positive shift','xyz', 3, 'abc'", "'Valid String and positive shift','abc',26,'abc'",
            "'Valid String and positive shift','abc',29,'def'",

            //Valid String null shift
            "'Valid String null shift', 'h',0,'h'", "'Valid String null shift', 'bhpx',0,'bhpx'", "'Valid String null shift', '',0,''",

            //Valid String negative shift
            "'Valid String negative shift', '', -2 ,''", "'Valid String negative shift', 'bhp', -2,'zfn'",
            "'Valid String negative shift', 'abc', -55,'xyz'", "'Valid String negative shift', 'xyz', -26,'xyz'"
    })
    public void testCaesarShiftCipher(String partition, String message, int shift, String expectedResult) {
        String result = new CaesarShiftCipher().CaesarShiftCipher(message, shift);
        Assertions.assertEquals(expectedResult, result);
    }

}
