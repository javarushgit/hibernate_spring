package org.example.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.example.entity.PlayerEntity;
import org.example.entity.TeamEntity;
import org.example.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TeamDao {

  public TeamEntity findByNameAndId1(String name) {
    Long id = 1L;
    TeamEntity team = null;
    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
      Transaction transaction = session.getTransaction();
      transaction.begin();
      System.out.println("000000000000000000");
      team = session.find(TeamEntity.class, id);
      System.out.println("000000000000000000");

      System.out.println(team.getPlayers());
      transaction.commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return team;
  }

  public Optional<TeamEntity> findByName(String name) {
    Optional<TeamEntity> team = Optional.empty();
    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
      Transaction transaction = session.getTransaction();
      transaction.begin();
      System.out.println("000000000000000000");
      team = session.createQuery("from TeamEntity where name = :name", TeamEntity.class)
          .setParameter("name", name)
          .uniqueResultOptional();

      System.out.println("000000000000000000");

      System.out.println(team.get().getPlayers().size());
      transaction.commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return team;
  }

  public Long save(TeamEntity teamEntity) {
    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
      Transaction transaction = session.getTransaction();
      transaction.begin();
      session.persist(teamEntity);
      transaction.commit();
    } catch (Exception e) {
        e.printStackTrace();
      }
    return teamEntity.getId();
  }

  public List<TeamEntity> findAll() {
    List<TeamEntity> list = new ArrayList<>();
    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
//      Transaction transaction = session.getTransaction();
//      transaction.begin();

      list = session.createQuery("from TeamEntity", TeamEntity.class).list();
      System.out.println("======================");
      for (TeamEntity team : list) {
        team.getPlayers().size();
      }
      //transaction.commit();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return list;
  }

  public Optional<TeamEntity> findById(Long id) {
    Optional<TeamEntity> teamEntity = Optional.empty();
    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
//      Transaction transaction = session.getTransaction();
//      transaction.begin();
      teamEntity =  Optional.ofNullable(session.find(TeamEntity.class, id));
      System.out.println("-------------");
      int size = teamEntity.get().getPlayers().size();
      System.out.println("size called higher ");
      for (int i = 0; i < size; i++) {
        System.out.println(teamEntity.get().getPlayers().get(1));
      }

      //transaction.commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return teamEntity;
  }



}
