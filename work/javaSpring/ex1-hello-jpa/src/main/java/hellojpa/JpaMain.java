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
            //비영속상태
//            Member member = new Member();
//            member.setId(101L);
//            System.out.println("====before ====");
//            member.setName("HelloJPA");
//            //영속상태
//            em.persist(member);
//            System.out.println("====after ====");
//            //준영속
//            em.detach(member);
//
//            //삭제
//            em.remove(member);


            //1차 캐시 체크
//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);


//            Member member1 = new Member(150L,"A");
//            Member member2 = new Member(160L,"B");
//
//            em.persist(member1);
//            em.persist(member2);

            Member member = em.find(Member.class, 101L);
            member.setName("ZZZZZ");

            //이때 db에 쿼리문이 날라감
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
