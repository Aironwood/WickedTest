package PropertyManager.manager;

import PropertyManager.common.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author jan.jarabinec
 */
public final class PropertyDAO {

    public static void create(Property property) throws SQLException {
        try (SqlSession session = BatisConnectionFactory.getSession().openSession()) {
            session.insert("propertyMapper.insert", property);
            session.commit();
        }
    }

    public static void update(Property property) throws SQLException {
        SqlSession session = BatisConnectionFactory.getSession().openSession();
        session.update("propertyMapper.update", property);
        session.commit();
        session.close();
    }

    public static void delete(Long id) throws SQLException {
        SqlSession session = BatisConnectionFactory.getSession().openSession();
        session.delete("propertyMapper.deleteById", id);
        session.commit();
        session.close();
    }

    public static List<Property> getAll() throws SQLException {
        List<Property> list = new ArrayList();
        SqlSession session = BatisConnectionFactory.getSession().openSession();
        list = session.selectList("propertyMapper.getAll");
        session.close();
        return list;
    }

    public static Property getById(Long id) throws SQLException {
        Property property = Property.builder().build();
        SqlSession session = BatisConnectionFactory.getSession().openSession();
        property = session.selectOne("propertyMapper.selectById", id);
        session.close();
        return property;
    }
    
    public static List<Property> getByTown() throws SQLException{
        List<Property> list = new ArrayList();
        SqlSession session = BatisConnectionFactory.getSession().openSession();
        list = session.selectList("propertyMapper.getByTown");
        session.close();
        return list;
    }
}
