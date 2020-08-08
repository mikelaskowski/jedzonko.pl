package ApplicationTests;

import com.java25wro.Application;
import com.java25wro.model.Customer;
import com.java25wro.model.Meal;
import com.java25wro.model.Order;
import com.java25wro.model.OrderedMeals;
import com.java25wro.repository.OrderRepository;
import com.java25wro.service.emails.EmailService;
import org.hamcrest.core.StringContains;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;


@SpringBootTest(classes= Application.class )
public class EmailServiceTest {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private EmailService emailService;

    @Test
    @DisplayName("Test save Order and send email Success")
    public void testSaveExample() throws IOException, InterruptedException {

        // Given:
        Customer customer = new Customer("Dominik", "Urbanski", "Gajowicka", 123L, "Wroclaw",  122334566L, "jason.papa@gmail.com", false );

        Meal meal1 = new Meal("pierogi", BigDecimal.valueOf(1234), "super not delicious", "image1", "with gluten");

        Meal meal2 = new Meal("kluski", BigDecimal.valueOf(1234), "super not delicious", "image1", "with gluten");

        Meal meal3 = new Meal("nalesniki", BigDecimal.valueOf(1234), "super not delicious", "image1", "with gluten");

        OrderedMeals orderedMeal1 = new OrderedMeals(null,meal1, 1);

        OrderedMeals orderedMeal2 = new OrderedMeals(null,meal2, 1);

        OrderedMeals orderedMeal3 = new OrderedMeals(null,meal3, 1);

        Set<OrderedMeals> orderedMeals = new HashSet<>(Arrays.asList(orderedMeal1,orderedMeal2, orderedMeal3));

        Order order = new Order(orderedMeals, customer, false);
        order.setId(100L);

        // When:
        String greeting = "<p id=\"greeting\">Hello Dominik</p>";
        String orderId = "<p id=\"order-id\">Your order number: 100</p>";
        String testMeal1 = "<li class=\"meal\">pierogi</li>";
        String testMeal2 = "<li class=\"meal\">kluski</li>";
        String testMeal3 = "<li class=\"meal\">nalesniki</li>";

        //Then:
        String result = emailService.renderOrderConfirmationEmail(order);
        Assertions.assertTrue(result.contains(greeting));
        Assertions.assertTrue(result.contains(testMeal1));
        Assertions.assertTrue(result.contains(testMeal2));
        Assertions.assertTrue(result.contains(testMeal3));

        assertThat(result, StringContains.containsString(greeting) );
        assertThat(result, StringContains.containsString(orderId) );
        assertThat(result, StringContains.containsString(testMeal1) );
        assertThat(result, StringContains.containsString(testMeal2) );
        assertThat(result, StringContains.containsString(testMeal3) );
    }

}
