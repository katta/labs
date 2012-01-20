package org.katta.labs.java.utils.annotation;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class ObjectWalkerTest {

    @Test
    public void shouldCollectAttributes() throws IllegalAccessException {
        ObjectWalker objectWalker = new ObjectWalker();

        RootObject rootObject = new RootObject();
        rootObject.setConfig1(5);
        rootObject.setConfig2("two");

        Attributes attributes = objectWalker.walk(rootObject);

        assertThat(attributes, Matchers.<Object>notNullValue());
        assertThat(attributes.size(), Matchers.is(2));
        assertThat(attributes, Matchers.hasItem(new Attribute("C1", "5")));
        assertThat(attributes, Matchers.hasItem(new Attribute("C2", "two")));
    }
}

