//package com.longhair.bloodrecovery.domain;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//import java.util.List;
//
//public class JpaMain {
//
//  public static void main(String[] args) {
//      EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//      EntityManager em = emf.createEntityManager();
//      EntityTransaction tx = em.getTransaction();
//      tx.begin();
//
//      try {
//
//            Card card = new Card();
//            card.setCode("111-22-333");
//            card.setImage("abc.jpg");
//            card.setUserid("userA");
////            card.changeUser(user);
//            em.persist(card);
//
//            user.addCard(card);
//
//            user.getCards().add(card);
//
//            User findUser = em.find(User.class, user.getId()); //1차캐시
//          List<Card> cards = findUser.getCards();
//
//
//
//            tx.commit();
//
//      }catch (Exception e){
//          tx.rollback();
//      }finally {
//          em.close();
//        }
//        emf.close();
//    }
//}
