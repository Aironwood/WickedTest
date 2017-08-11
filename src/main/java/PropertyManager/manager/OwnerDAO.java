package PropertyManager.manager;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.time.LocalDate;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import PropertyManager.common.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author JanJ
 */
public final class OwnerDAO {

    public static void create(Owner owner) throws SQLException {
        try (SqlSession session = BatisConnectionFactory.getSession().openSession()) {
            session.insert("ownerMapper.insert", owner);
            session.commit();
        }
    }

    public static Owner getById(Long id) throws SQLException {
        Owner own = Owner.builder().build();
        SqlSession session = BatisConnectionFactory.getSession().openSession();
        own = session.selectOne("ownerMapper.getById", id);
        session.close();

        return own;
    }

    public static List<Owner> getAll() throws SQLException {
        SqlSession session = BatisConnectionFactory.getSession().openSession();
        List<Owner> list = new ArrayList<>();
        list = session.selectList("ownerMapper.getAll");
        session.close();
        return list;
    }

    public static void delete(long id) throws SQLException {
        SqlSession session = BatisConnectionFactory.getSession().openSession();
        session.delete("ownerMapper.deleteById", id);
        session.commit();
        session.close();
    }

    public static void update(Owner owner) throws SQLException {
        SqlSession session = BatisConnectionFactory.getSession().openSession();
        session.update("ownerMapper.update", owner);
        session.commit();
        session.close();
    }

    public static List<Owner> getbySurname(String surname) throws SQLException {
        List<Owner> list = new ArrayList<Owner>();
        SqlSession session = BatisConnectionFactory.getSession().openSession();
        list = session.selectList("ownerMapper.getBySurname", surname);
        session.close();
        return list;
    }

}
