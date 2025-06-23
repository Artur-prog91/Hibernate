package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        userService.dropUsersTable();

        userService.createUsersTable();

        userService.saveUser("Artur", "Shabaev", (byte)33);
        System.out.println("Пользователь с именем Artur добавлен в базу данных");
        userService.saveUser("Ivan", "Ivanov", (byte)42);
        System.out.println("Пользователь с именем Ivan добавлен в базу данных");
        userService.saveUser("Petr", "Petrov", (byte)25);
        System.out.println("Пользователь с именем Petr добавлен в базу данных");
        userService.saveUser("Andrey", "Seregin", (byte)30);
        System.out.println("Пользователь с именем Andrey добавлен в базу данных");

        userService.removeUserById(2);

        System.out.println(userService.getAllUsers());

        //userService.cleanUsersTable();

        //userService.dropUsersTable();

    }
}
