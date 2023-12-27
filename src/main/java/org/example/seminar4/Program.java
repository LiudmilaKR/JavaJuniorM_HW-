package org.example.seminar4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Program {
    /*
    Создайте базу данных (например, SchoolDB).
В этой базе данных создайте таблицу Courses с полями id (ключ), title, и duration.
Настройте Hibernate для работы с вашей базой данных.
Создайте Java-класс Course, соответствующий таблице Courses, с необходимыми аннотациями Hibernate.
Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Courses.
Убедитесь, что каждая операция выполняется в отдельной транзакции.
     */
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory()) {
//            Создание сессии
            Session session = sessionFactory.getCurrentSession();
//            Начало транзакции
            session.beginTransaction();
            System.out.println("Начало транзакций");
//            Создание объекта
            for (int i = 0; i < 5; i++) {
                Course course = Course.create();
                session.save(course);
                System.out.printf("%d-ый курс создан успешно\n", i);
            }

//            Подтверждение сессии
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
