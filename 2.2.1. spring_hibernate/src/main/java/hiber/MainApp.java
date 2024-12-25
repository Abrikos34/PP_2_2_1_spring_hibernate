package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      CarService carService = context.getBean(CarService.class);
      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("Toyota", 123);
      Car car2 = new Car("BMW", 456);

      carService.saveCar(car1);
      carService.saveCar(car2);

      User user1 = new User("Alice", "Brown", "alice@example.com", car1);
      User user2 = new User("Bob", "Smith", "bob@example.com", car2);

      userService.saveUser(user1);
      userService.saveUser(user2);

      List<User> users = userService.getAllUsers();
      users.forEach(System.out::println);

      context.close();
   }
}

