package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "9yQp7@example.com", new Car("BMW", 5)));
      userService.add(new User("User2", "Lastname2", "123yQp7@example.com", new Car("Gaz", 2110)));
      userService.add(new User("User3", "Lastname3", "17@example.com", new Car("Volvo", 60)));
      userService.add(new User("User4", "Lastname4", "PffbV@example.com", new Car("Audi", 3)));
      userService.add(new User("User5", "Lastname5", "sobaka@example.com", new Car("HONDA", 1)));
      userService.add(new User("User6", "Lastname6", "soba@example.com", new Car("Gaz", 2110)));

      System.out.println(userService.getUserByCar("Volvo", 60));
//
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }

      context.close();
   }
}
