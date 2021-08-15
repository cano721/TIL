package jpql;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JpaMain {

    public static void main(String[] args){
//
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("" +
                "");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

            //반환타입 명확 TypeQuery
            TypedQuery<Member> query1 = em.createQuery("select m From Member m where m.id = 10", Member.class);
            //반환타입 명확하지 않음 Query
//            Query query2 = em.createQuery("select m.username,m.age From member m");

            //여러개의 반환값
//            List<Member> resultList = query1.getResultList();
//
//            for (Member member1 : resultList) {
//                System.out.println("member1 = " + member1);
//            }

            //한개의 반환값(결과는 정확하게 하나여야함. 아니면 에러)
            Member result = query1.getSingleResult();
            System.out.println("result = " + result);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }

}
