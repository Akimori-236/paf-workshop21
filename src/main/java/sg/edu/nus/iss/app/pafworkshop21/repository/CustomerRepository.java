package sg.edu.nus.iss.app.pafworkshop21.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.app.pafworkshop21.model.Customer;

@Repository
public class CustomerRepository {

    @Autowired
    JdbcTemplate template;

    private String getAllSQL = """
            SELECT *, CONVERT(attachments USING utf8) attachmentString
            FROM customers
            LIMIT ? OFFSET ?
            """;

    public List<Customer> getAllCustomers(int limit, int offset) {
        return template.query(getAllSQL, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, limit);
                ps.setInt(2, offset);
            }
        }, BeanPropertyRowMapper.newInstance(Customer.class));
    }

    public byte[] getAttachment(Integer id) {
        String sql = "SELECT CONVERT(attachments USING utf8) FROM customers WHERE id=?";
        return template.queryForObject(sql, new Object[] { id }, (rs, rowNum) -> rs.getBytes("attachments"));
    }
}
