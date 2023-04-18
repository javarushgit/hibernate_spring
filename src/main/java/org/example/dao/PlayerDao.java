package org.example.dao;

import java.util.Optional;
import org.example.entity.PlayerEntity;
import org.example.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;



@Component
public class PlayerDao {
  public Long save(PlayerEntity playerEntity) {
    Long id = null;
    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
      Transaction transaction = session.getTransaction();
      transaction.begin();
      session.persist(playerEntity);
      id = playerEntity.getId();
      transaction.commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return id;
  }

  // CGLIB Proxy
  public Optional<PlayerEntity> findById(Long id) {
    Optional<PlayerEntity> playerEntity = Optional.empty();
    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
      Transaction transaction = session.getTransaction();
      transaction.begin();
      playerEntity = Optional.ofNullable(session.createQuery("from PlayerEntity where id = :id", PlayerEntity.class)
          .setParameter("id", id)
              .setMaxResults(1)
                  .getSingleResultOrNull());
      System.out.println("--------");
      System.out.println(playerEntity.get().getTeam().getName());
      transaction.commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return playerEntity;
  }
}
