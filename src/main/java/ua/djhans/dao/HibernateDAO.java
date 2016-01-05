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
public class HibernateDAO implements DAO {
    private static HibernateDAO instance;
    private final Logger log = LoggerFactory.getLogger(HibernateDAO.class);
    private ServiceRegistry serviceRegistry;
    private SessionFactory sessionFactory;

    private HibernateDAO() {}

    public static HibernateDAO getDAO() {
        if (instance == null) instance = new HibernateDAO();
        return instance;
    }

    private void init() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    private void destroy() {
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }

    @Override
    public List<Book> getBooks(int authorId) {
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

    @Override
    public  List<Writer> getWriters() {
        init();
        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();
        List<Writer> writers = s.createCriteria(Writer.class).list();
        s.getTransaction().commit();
        destroy();
        return writers;
    }

    public static void main(String[] args) {
        List<Book> books = HibernateDAO.getDAO().getBooks(0);
        books.forEach(System.out::println);
    }
}
