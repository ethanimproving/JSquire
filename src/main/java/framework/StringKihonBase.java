package framework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class StringKihonBase {
    protected abstract String convertToUpperCase(String data);
    protected abstract String convertToLowerCase(String data);
    protected abstract String Combine_Parts_Of_A_Name(String firstName, String middleName, String lastName);
    protected abstract String Combine_Two_Strings(String a, String b);
    protected abstract int Determine_The_Length_Of_A_String(String data);
    protected abstract String Remove_All_Leading_Whitespace(String data);
    protected abstract String Remove_All_Trailing_Whitespace(String data);
    protected abstract String[] Split_A_String_Into_An_Array(String input, char divider);
    protected abstract String Join_An_Array_Into_A_String(String[] input, String divider);
    protected abstract boolean returnTrueIfAContainsB(String a, String b);
    protected abstract int determineThePositionOfAInB(String a, String b);
    protected abstract boolean returnTrueIfAStartsWithB(String a, String b);
    protected abstract boolean returnTrueIsAEndsWithB(String a, String b);
    protected abstract String returnTheFourthThroughSeventhCharactersOfInput(String input);

    @Test
    void convertToUpperCase() {
        // Arrange
        String data = "this is a Simple sTrInG";

        // Act
        String actual = convertToUpperCase(data);

        // Assert
        assertEquals(data.toUpperCase(), actual);
    }

    @Test
    public void convertToLowerCase()
    {
        // Arrange
        String data = "THIS IS A SHOUTING PERSON!";

        // Act
        String actual = convertToLowerCase(data);

        // Assert
        assertEquals(data.toLowerCase(), actual);
    }
    
    @Test
    public void determineThePositionOfAInB()
    {
        // Arrange
        String a = "summer";
        String b = "Now is the winter of our discontent, made glorious summer by the son of York.";

        // Act
        int actual = determineThePositionOfAInB(a, b);

        // Assert
        assertEquals(b.indexOf(a), actual);
    }

    @Test
    public void returnTrueIfAContainsB()
    {
        // Arrange
        String a = "This is a simple xyzzy exam";
        String b = "xyzzy";

        // Act
        boolean actual = returnTrueIfAContainsB(a, b);

        // Assert
        assertTrue(actual);
    }

    @Test
    public void returnTrueIfAStartsWithB()
    {
        // Arrange
        String a = "Fantastic Legendary Musciain";
        String b = "Fantastic Legen";

        // Act
        boolean actual = returnTrueIfAStartsWithB(a, b);

        // Assert
        assertTrue(actual);
    }

        @Test
    public void returnTrueIsAEndsWithB()
    {
        // Arrange
        String a = "This is a test";
        String b = "s a test";

        // Act
        boolean actual = returnTrueIsAEndsWithB(a,b);

        // Assert
        assertTrue(actual);
    }

    @Test
    public void returnTheFourthThroughSeventhCharactersOfInput()
    {
        // Arrange
        String input = "1234567890";

        // Act
        String actual = returnTheFourthThroughSeventhCharactersOfInput(input);

        // Assert
        assertEquals(input.substring(4,7), actual);
    }
}