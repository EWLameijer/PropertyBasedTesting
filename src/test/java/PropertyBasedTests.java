import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.assertj.core.api.Assertions;

class PropertyBasedTests {

    @Property
    boolean absoluteValueOfAllNumbersIsPositive(@ForAll int anInteger) {
        try {
            return Math.absExact(anInteger) >= 0;
        } catch (ArithmeticException _) {
            return anInteger == Integer.MIN_VALUE;
        }
    }

    @Property
    void lengthOfConcatenatedStringIsGreaterThanLengthOfEach(
            @ForAll String string1, @ForAll String string2
    ) {
        String conc = string1 + string2;
        Assertions.assertThat(conc.length()).isGreaterThanOrEqualTo(string1.length());
        Assertions.assertThat(conc.length()).isGreaterThanOrEqualTo(string2.length());
    }
}