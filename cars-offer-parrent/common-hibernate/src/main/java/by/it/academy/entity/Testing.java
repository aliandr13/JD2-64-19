package by.it.academy.entity;

import by.it.academy.service.CarService;
import by.it.academy.service.UserService;
import by.it.academy.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
public class Testing {
    public static void main(String[] args) throws SQLException {


        CarService a = new CarService();
        UserService b = new UserService();
        Car car = new Car(1L, 200, 2015, "V2W24fh9100KLR3", null);
        Car car1 = new Car(null, 150, 2012, "1KG0B1FS6P2T349", null);
        Car car2 = new Car(null, 90, 2000, "JA4LX3169340JH5", null);
        Car car3 = new Car(null, 170, 2013, "SA1FA27B5876KL0", null);
        Car car4 = new Car(null, 120, 2004, "44SB89TK0V5LK96", null);
        Client client = new Client(null, "Рома", "Юрьевич", "Китурко", "+373(33)6541680",
                new Address("Гродно", "Дзержинского", "230005"));


        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
//
        Car car0 = session.find(Car.class, 7L);
        Model model = session.find(Model.class, 1L);
        car0.setModel(model);
        model.setCar(car0);
        session.saveOrUpdate(car0);


//        b.findUser("Паша","1212");
/* Как из сохраненного объекта в БД сделать объект
        Model model = new Model(null, "Vectra", null, null, null);
        Mark mark1 = session.find(Mark.class, 7L); // извлекаем объект из бд
        model.setMark(mark1);
        session.save(model);
*/
//
        session.getTransaction().commit();
        session.close();

    }
}
