package ua.djhans.dao;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.djhans.model.Book;
import ua.djhans.model.Writer;

import java.util.List;


/**
 * Created by Administrator on 09.12.2015.
 */
public class HibernateDAO {
    private static final Logger log = LoggerFactory.getLogger(HibernateDAO.class);
    private static ServiceRegistry serviceRegistry;
    private static SessionFactory sessionFactory;


    private static void init() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    private static void destroy() {
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }

    public static List<Book> getBooks(int authorId) {
        init();
        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();
        Criteria criteria = s.createCriteria(Book.class);
        if(authorId != 0) criteria.add(Restrictions.eq("writer.id", authorId));
        List<Book> books = criteria.list();
        s.getTransaction().commit();
        destroy();
        return books;
    }

    public static List<Writer> getWriters() {
        init();
        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();
        List<Writer> writers = s.createCriteria(Writer.class).list();
        s.getTransaction().commit();
        destroy();
        return writers;
    }

    public static void main(String[] args) {
        List<Book> books = getBooks(0);

        for (Book book : books) System.out.println(book);
    }
}
