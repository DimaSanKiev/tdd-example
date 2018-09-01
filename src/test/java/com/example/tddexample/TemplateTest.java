package com.example.tddexample;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TemplateTest {

    private Template template;

    @Before
    public void setUp() throws Exception {
        template = new Template("${one}, ${two}, ${three}");
        template.set("one", "1");
        template.set("two", "2");
        template.set("three", "3");
    }

    @Test
    public void oneVariable() throws Exception {
        Template template = new Template("Hello, ${name}");
        template.set("name", "Reader");
        assertEquals("Hello, Reader", template.evaluate());
    }

    @Test
    public void differentValue() throws Exception {
        Template template = new Template("Hello, ${name}");
        template.set("name", "someone else");
        assertEquals("Hello, someone else", template.evaluate());
    }

    @Test
    public void multipleVariables() throws Exception {
        assertTeamplateEvaluatesTo("1, 2, 3");
    }

    @Test
    public void unknownVariablesAreIgnored() throws Exception {
        template.set("doesnotexist", "whatever");
        assertTeamplateEvaluatesTo("1, 2, 3");
    }

    @Test(expected = MissingValueException.class)
    public void testMissingValueRaisesException() throws Exception {
        new Template("${foo}").evaluate();
    }

    private void assertTeamplateEvaluatesTo(String expected) {
        assertEquals(expected, template.evaluate());
    }
}
