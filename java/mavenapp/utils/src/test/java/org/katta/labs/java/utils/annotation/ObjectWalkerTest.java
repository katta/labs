package org.katta.labs.java.utils.annotation;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class ObjectWalkerTest {

    private ObjectWalker objectWalker;

    @Before
    public void setUp() throws Exception {
        objectWalker = new ObjectWalker();
    }

    @Test
    public void shouldCollectAttributes() throws IllegalAccessException {
        RootObject rootObject = new RootObject();
        rootObject.setConfig1(5);
        rootObject.setConfig2("two");

        Attributes attributes = objectWalker.walk(rootObject);

        assertThat(attributes, Matchers.<Object>notNullValue());
        assertThat(attributes.size(), Matchers.is(2));
        assertThat(attributes, Matchers.hasItem(new Attribute("C1", "5")));
        assertThat(attributes, Matchers.hasItem(new Attribute("C2", "two")));
    }

    @Test
    public void shouldCollectAttributesFromNestedObjects() throws IllegalAccessException {
        RootObject rootObject = new RootObject();
        rootObject.setConfig1(5);
        rootObject.setConfig2("two");

        CustomObject customObject = new CustomObject();
        customObject.setConfig3(3L);
        customObject.setConfig4(true);
        customObject.setConfig5(55);

        rootObject.setCustomObject(customObject);

        Attributes attributes = objectWalker.walk(rootObject);

        assertThat(attributes, Matchers.<Object>notNullValue());
        assertThat(attributes.size(), Matchers.is(4));
        assertThat(attributes, Matchers.hasItem(new Attribute("C1", "5")));
        assertThat(attributes, Matchers.hasItem(new Attribute("C2", "two")));
        assertThat(attributes, Matchers.hasItem(new Attribute("C3", "3")));
        assertThat(attributes, Matchers.hasItem(new Attribute("C4", "true")));
    }
}

