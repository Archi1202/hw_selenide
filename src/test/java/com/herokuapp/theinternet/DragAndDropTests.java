package com.herokuapp.theinternet;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTests {

    @Test
    void dragAndDropSuccessTest(){
        open("https://the-internet.herokuapp.com/drag_and_drop");

        // Locate the rectangles
        SelenideElement columnA = $("#column-a");
        SelenideElement columnB = $("#column-b");

        // Perform drag and drop using Actions
        actions().dragAndDrop(columnA, columnB).perform();

        // Verify the rectangles are swapped
        columnA.shouldHave(text("B"));
        columnB.shouldHave(text("A"));
    }
}
