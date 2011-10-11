package org.katta.labs.java.validation.validator;

import org.junit.Assert;
import org.junit.Test;
import org.katta.labs.java.validation.ValidationErrors;
import org.katta.labs.java.validation.Validator;

public class NotNullOrEmptyValidatorTest {

    @Test
    public void validatesNotNull() {

        Validator<String> validator = new NotNullOrEmptyValidator();
        ValidationErrors errors = validator.validate(null);

        Assert.assertFalse(errors.isEmpty());
        Assert.assertEquals(1, errors.size());

        errors = validator.validate("not empty");
        Assert.assertTrue(errors.isEmpty());
    }

    @Test
    public void validatesNotEmpty() {
        Validator<String> validator = new NotNullOrEmptyValidator();
        ValidationErrors errors = validator.validate("");

        Assert.assertFalse(errors.isEmpty());
        Assert.assertEquals(1, errors.size());
        Assert.assertEquals("String is empty", errors.first().errorMessage());


        errors = validator.validate("not empty");
        Assert.assertTrue(errors.isEmpty());
    }

    @Test
    public void validatesNotEmptyForTrimmedString() {
        Validator<String> validator = new NotNullOrEmptyValidator();
        ValidationErrors errors = validator.validate("   ");

        Assert.assertFalse(errors.isEmpty());
        Assert.assertEquals(1, errors.size());
        Assert.assertEquals("String is empty", errors.first().errorMessage());
    }
}
