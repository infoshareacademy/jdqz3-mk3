package generators;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static java.lang.Character.isUpperCase;
import static org.assertj.core.api.Assertions.assertThat;

public class AddressGeneratorUnitTests {

    private static AddressGenerator addressGenerator;

    @Before
    public void setUpAll() {
        addressGenerator = new AddressGenerator();

    }

    @Test
    public void isGeneratedAddressNotNull() {
        assertThat(addressGenerator).isNotNull();
    }

    @Test
    public void isCountryOnList(){
        // given

        // when
        String country = AddressGenerator.randomCountry();

        // then
        Assertions.assertThat(country)
                .isIn("Belgium", "Brazil",
                "Canada", "China", "Czech Republic", "France",
                "India", "Italy", "Switzerland", "United States");
    }

    @Test
    public void isStreetLengthBetween11To13() {
        int streetLength = AddressGenerator.streetGenerator().length();
        Assert.assertTrue(streetLength > 11);
        Assert.assertTrue(streetLength < 15);
    }

    @Test
    public void isFirstLetterInStreetCapital() {
        char firstLetter = AddressGenerator.streetGenerator().charAt(0);
        Assert.assertTrue(isUpperCase(firstLetter));
    }

    @Test
    public void isCityLength8() {
        Assert.assertEquals(8, AddressGenerator.cityGenerator().length());
    }

    @Test
    public void isFirstLetterInCityCapital() {
        char firstLetter = AddressGenerator.cityGenerator().charAt(0);
        Assert.assertTrue(isUpperCase(firstLetter));
    }

    @Test
    public void isDashSignInPostalCode() {
        String atSign = "-";
        Assert.assertTrue(AddressGenerator.postalCodeGenerator().contains(atSign));
    }

    @Test
    public void isStateLength8() {
        Assert.assertEquals(8, AddressGenerator.stateGenerator().length());
    }

    @Test
    public void isFirstLetterInStateCapital() {
        char firstLetter = AddressGenerator.stateGenerator().charAt(0);
        Assert.assertTrue(isUpperCase(firstLetter));
    }
}