import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.assertj.core.api.Assertions;

class PropertyBasedTests {

    @Property
    boolean absoluteValueOfAllNumbersIsPositive(@ForAll int anInteger) {
        return Math.abs(anInteger) >= 0;
    }

    @Property
    void lengthOfConcatenatedStringIsGreaterThanLengthOfEach(
            @ForAll String string1, @ForAll String string2
    ) {
        String conc = string1 + string2;
        Assertions.assertThat(conc.length()).isGreaterThan(string1.length());
        Assertions.assertThat(conc.length()).isGreaterThan(string2.length());
    }
}