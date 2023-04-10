import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenidTest {
    String meetingDay(int day) {
        return LocalDate.now().plusDays(day).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

    }

    @Test
    void shouldTestDeliveryCard() {
        open("http://localhost:9999/");
        $("[data-test-id='city'] input").setValue("Санкт-Петербург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id = 'date'] input").setValue(meetingDay(3));
        $("[data-test-id='name'] input").setValue("Иванов-Васильев Иван");
        $("[data-test-id='phone'] input").setValue("+79999999999");
        $("[data-test-id='agreement']").click();
        $(".button__content").click();
        $("[data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(15));


    }
}


