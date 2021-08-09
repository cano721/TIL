package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args){
//
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
//            Member member = new Member();
//            member.setUsername("A");
//            Member member2 = new Member();
//            member.setUsername("B");
//            Member member3 = new Member();
//            member.setUsername("C");
//
//
////            시퀀스
//            em.persist(member); // 1,51 미리 호출
//            em.persist(member2); // 메모리에서 가져옴
//            em.persist(member3); // 메모리에서 가져옴
//            System.out.println("member.getId() = " + member.getId());


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
