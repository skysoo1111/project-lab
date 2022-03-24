import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MainTest {
    @Test
    public void testCase() {
        var a = 0;
        var b = -1;
        var c = 0;

        Integer aa = 0;
        Integer bb = 0;
        Integer cc = 0;

        String regExp = "^[0]{1}$";

        boolean matches = Pattern.matches(regExp, String.valueOf(a));

//        assertThat((a & b & c) == 0).isEqualTo(true);
        assertThat(matches).isEqualTo(true);
    }
}
