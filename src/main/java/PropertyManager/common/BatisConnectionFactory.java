package PropertyManager.common;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author JanJ
 */
public class BatisConnectionFactory {

    private static SqlSessionFactory sqlMapper;
    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("myBatis\\batisConfig.xml");
            sqlMapper = new SqlSessionFactoryBuilder().build(reader, "dev");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession() {
        return sqlMapper;
    }
    
}
