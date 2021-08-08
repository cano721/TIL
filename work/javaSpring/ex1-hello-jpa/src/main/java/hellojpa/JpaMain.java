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

//            Member member = new Member(200L,"member200");
//            em.persist(member);
//            // flush를 해버리면 쓰기지연 sql 저장소에 있는 쿼리를 db에 보냄
//            em.flush();
//            System.out.println("========== = ");

            Member member = em.find(Member.class, 101L);
            member.setName("AAAAA");
//            특정 객체만 준영속처리
            em.detach(member);
//            영속성 컨텍스트 초기화
            em.clear();
//            영속성 컨텍스트 종료
            em.close();
            System.out.println(" ============== ");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
