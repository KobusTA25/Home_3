package org.max.home;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.apache.commons.lang3.StringUtils;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class CompositePatternTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Component compositeRoot;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));

        Component leaf1 = new Leaf();
        Component leaf2 = new Leaf();

        Composite composite1 = new Composite();
        composite1.add(leaf1);
        composite1.add(leaf2);

        Component leaf3 = new Leaf();

        Composite composite2 = new Composite();
        composite2.add(leaf3);
        composite2.add(composite1);

        compositeRoot = composite2;
    }


    @Test
    public void testCompositePattern() {
        compositeRoot.operation();

        String expectedOutput = "Composite operation\nLeaf operation\nLeaf operation\nComposite operation\nLeaf operation\n";
        String actualOutput = outputStream.toString().trim();

        System.out.println("Expected Output:");
        System.out.println(expectedOutput);

        System.out.println("\nActual Output:");
        System.out.println(actualOutput);

        String difference = StringUtils.difference(expectedOutput, actualOutput);

        System.out.println("\nDifference:");
        System.out.println(difference);

        assertEquals(expectedOutput, actualOutput);
    }
}