package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args){
//
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Member member1 = new Member();
            member1.setUsername("member1");
            em.persist(member1);
            Member member2 = new Member();
            member2.setUsername("member2");
            em.persist(member2);


            em.flush();
            em.clear();

//            Member m1 = em.find(Member.class, member1.getId());
//            Member m2 = em.getReference(Member.class, member2.getId());
//
//            // == 비교하면 안됨 instance of 사용할것
//            logic(m1,m2);

            Member m2 = em.getReference(Member.class, member2.getId());
            System.out.println("m2.getClass() = " + m2.getClass()); // proxy
            //프록시 초기화 여부 확인
            System.out.println("emf.getPersistenceUnitUtil().isLoaded(m2) = " + emf.getPersistenceUnitUtil().isLoaded(m2));
            //프록시 강제초기화
            Hibernate.initialize(m2);

            //영속성 컨텍스트 비움
            //영속성 컨텍스트에 내용이 있으면 프록시를 반환하는게 아니라 맴버클래스 그대로 반환

//            Member findMember = em.find(Member.class, member.getId());
//            Member findMember = em.getReference(Member.class, member.getId());
//            System.out.println("findMember = " + findMember.getId());
//            System.out.println("findMember = " + findMember.getUsername());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }

    private static void logic(Member m1, Member m2) {
//        System.out.println("m1==m2: " + (m1.getClass() == m2.getClass())); 안됨
        System.out.println("m1==m2: " + (m1 instanceof Member));
        System.out.println("m1==m2: " + (m2 instanceof Member));
    }

    private static void printMember(Member member) {
        System.out.println("member = " + member.getUsername());
    }

    private static void printMemberAndTeam(Member member) {
        String username = member.getUsername();
        System.out.println("username = " + username);

        Team team = member.getTeam();
        System.out.println("team.getName()t = " + team.getName());

    }
}
