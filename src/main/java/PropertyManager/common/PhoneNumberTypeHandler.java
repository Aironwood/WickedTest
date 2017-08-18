package PropertyManager.common;

import org.apache.ibatis.type.TypeHandler;
import PropertyManager.manager.PhoneNumber;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

/**
 *
 * @author jan.jarabinec
 */
@MappedTypes(PhoneNumber.class)
public class PhoneNumberTypeHandler implements TypeHandler<PhoneNumber> {

    @Override
    public void setParameter(PreparedStatement ps, int i, PhoneNumber t, JdbcType jt) throws SQLException {
        ps.setString(i, t.toString());
    }

    @Override
    public PhoneNumber getResult(ResultSet rs, String collumnName) throws SQLException {
        final String rawFormat = rs.getString(collumnName);
        return rs.wasNull() ? null : new PhoneNumber(rawFormat);
    }

    @Override
    public PhoneNumber getResult(ResultSet rs, int collumnIndex) throws SQLException {
        final String rawFormat = rs.getString(collumnIndex);
        return rs.wasNull() ? null : new PhoneNumber(rawFormat);
    }

    @Override
    public PhoneNumber getResult(CallableStatement cs, int collumnIndex) throws SQLException {
        final String rawFormat = cs.getString(collumnIndex);
        return cs.wasNull() ? null : new PhoneNumber(rawFormat);
    }
    
}
