package net.jhttp;

import org.testng.annotations.Test;

@Test(groups={"int"})
public class BasicIntegrationTest {
    @Test
    public void getGoogle() throws Exception {
        String b = Http.client().GET("http://www.google.co.uk/").responseBody();
        assert b != null;
        assert b.contains("Search");
    }

    @Test
    public void getGoogle404() throws Exception {
        String u = "http://www.google.com/thispagedoesnotexist/";
        int code = Http.client().GET(u).response().getStatusCode();
        assert 404 == code;
    }
}