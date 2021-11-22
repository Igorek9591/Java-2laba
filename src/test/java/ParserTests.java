import org.junit.Assert;
import org.junit.Test;

public class ParserTests {
    private final MatchParser parser = new MatchParser();

    @Test
        public void testUncloseVars() throws Exception {
            String str = "(5+(10-5)";
            Throwable exc = Assert.assertThrows(ParserException.class, () -> parser.Parse(str));
            Assert.assertEquals("Error: not close bracket", exc.getMessage());
    }

    @Test
    public void testWrongVar() throws Exception {
        String str = "5+y";
        Throwable exc = Assert.assertThrows(ParserException.class, () -> parser.Parse(str));
        Assert.assertEquals("Error: Try get unexists variable 'y'", exc.getMessage());
    }

    @Test
    public void testWrongFunction() throws Exception {
        String str = "5+cototangens(5)";
        Throwable exc = Assert.assertThrows(ParserException.class, () -> parser.Parse(str));
        Assert.assertEquals("function 'cototangens' is not defined", exc.getMessage());
    }

}
