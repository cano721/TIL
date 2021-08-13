package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.*;
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
            Address address = new Address("city", "street", "10000");

            Member member = new Member();
            member.setUsername("member1");
            member.setAddress(address);
            em.persist(member);

//            Member member2 = new Member();
//            member2.setUsername("member2");
//            member2.setAddress(copyAddress);
//            em.persist(member2);

            // 맴버1만 변경하고싶지만 2개다 변경되어버린다!...
            // 임베디드타입을 여러 엔티티에서 공유하면 위험한점.
            // setter 자체를 삭제해거나 private설정하여 불변으로 만들어줄것
            // member.getAddress().setCity("newCity");

            //통으로 변경
            Address copyAddress = new Address("NewCity", address.getStreet(), address.getZipcode());
            member.setAddress(copyAddress);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }

}
