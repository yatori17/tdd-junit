package tddjunit.service;

import org.hibernate.QueryException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class QueryService {

//    @PersistenceContext(unitName = "exemplo")
//    private EntityManager exemploEntityManager;
//
//    public List<Object[]> findUltimoLancamento() throws QueryException {
//        try {
//            StringBuilder sql = new StringBuilder();
//            sql.append(" select * from Book b where b.author = :a");
//            Query query = exemploEntityManager.createNativeQuery(sql.toString());
//            query.setParameter("c", "SeiNao");
//
//            return query.getResultList();
//        } catch (Exception e) {
//            System.out.println("==============");
//        }
//        return null;
//    }
}
