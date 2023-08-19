package com.driverssea.model;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdersMapper implements RowMapper<OrderModel> {

    @Override
    public OrderModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderModel order = new OrderModel(rs.getLong("ID"),rs.getString("ORDER_NUMBER"),
                rs.getString("PRODUCT_NAME"),rs.getFloat("PRICE"),rs.getInt("QUANTITY"));
        return order;
    }
}
