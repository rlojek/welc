package pl.brasswillow.spring;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@Configuration
@ComponentScan(basePackages = "pl.brasswillow.spring")
@ContextConfiguration(classes = {SpringMockitoManualTest.class})
public class SpringMockitoManualTest {

    public static final String ALA_MA_KOTA = "ala ma kota";
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Autowired
    private StringCapitaliser stringCapitaliser;

    @Mock
    private StringCapitaliser mock;

    @Test
    public void test1() throws Exception{
        String capitalise = stringCapitaliser.capitalise(ALA_MA_KOTA);
        assertThat(capitalise).isEqualTo("ala Ma Kota");
    }

    @Test
    public void test2() throws Exception{
        given(mock.capitalise(ALA_MA_KOTA)).willReturn("Ala Ma Kota");
        String capitalise = mock.capitalise(ALA_MA_KOTA);
        assertThat(capitalise).isEqualTo("Ala Ma Kota");
    }

}
