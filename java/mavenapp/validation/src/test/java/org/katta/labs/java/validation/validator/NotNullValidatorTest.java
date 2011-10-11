package org.katta.labs.java.validation.validator;

import org.junit.Assert;
import org.junit.Test;
import org.katta.labs.java.validation.validator.NotNullValidator;


public class NotNullValidatorTest {

    @Test
    public void validatesIfObjectIsNotNull() {
        org.katta.labs.java.validation.Validator validator = new NotNullValidator();
        org.katta.labs.java.validation.ValidationErrors errors = validator.validate(new Object());

        Assert.assertTrue(errors.isEmpty());

        errors = validator.validate(null);
        Assert.assertFalse(errors.isEmpty());
        Assert.assertEquals(1, errors.size());
        Assert.assertEquals("Object is null", errors.first().errorMessage());

    }
}
