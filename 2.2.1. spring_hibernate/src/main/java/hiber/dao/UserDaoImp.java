package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   /**
    * Сделал что бы выводился один пользователь. Может же быть что у нескольких
    * пользователей одинакове машины
    * Может я не правильно понял что от меня требуется?
    */
   @Override
   @SuppressWarnings("unchecked")
   public User getUserByCar(String model, int series) {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User where car.model=:model and car.series=:series");
      query.setParameter("model",model);
      query.setParameter("series",series);

      for (User user : query.getResultList()) {
         return user;
      }
      return null;
   }



}
