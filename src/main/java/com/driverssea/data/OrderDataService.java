package com.driverssea.data;

import com.driverssea.model.OrderModel;
import com.driverssea.model.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
@Primary
public class OrderDataService implements OrdersDataAccessInterface{

    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;

    public OrderDataService() {
    }

    @Override
    public OrderModel getById(long ID) {
        List<OrderModel> results = jdbcTemplate.query("SELECT * FROM ORDERS WHERE ID = ?", new OrdersMapper(), ID);
        if(results.size()>0) return results.get(0);
        else return null;
    }

    @Override
    public void Init() {

    }

    @Override
    public void Destroy() {

    }

    @Override
    public List<OrderModel> getOrders() {
        List<OrderModel> results =
        jdbcTemplate.query("SELECT * FROM ORDERS",new OrdersMapper());
        return results;
    }

    @Override
    public List<OrderModel> searchOrders(String term) {
        List<OrderModel> results = jdbcTemplate.query("SELECT * FROM ORDERS WHERE PRODUCT_NAME LIKE ?", new OrdersMapper(),"%"+term+"%");
        return results;
    }

    @Override
    public long addOne(OrderModel newOrder) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("ORDERS").usingGeneratedKeyColumns("ID");
        Map<String, Object> params = new HashMap<String, Object>();

        params.put("ORDER_NUMBER", newOrder.getOrderNo());
        params.put("PRODUCT_NAME", newOrder.getProductName());
        params.put("PRICE", newOrder.getPrice());
        params.put("QUANTITY", newOrder.getQuantity());

        Number result = insert.executeAndReturnKey(params);

        return result.longValue();
    }

    @Override
    public boolean deleteOne(long ID) {
        int results = jdbcTemplate.update("DELETE FROM ORDERS WHERE ID = ?", ID);
        if(results>0)
            return true;
        else return false;
    }

    @Override
    public OrderModel updateOne(long IDToUpdate, OrderModel updateOrder) {
        int results = jdbcTemplate.update(
                "UPDATE ORDERS SET ORDER_NUMBER = ?, PRODUCT_NAME = ?, PRICE = ?, QUANTITY = ? WHERE ID = ?",
                updateOrder.getOrderNo(),
                updateOrder.getProductName(),
                updateOrder.getPrice(),
                updateOrder.getQuantity(),
                IDToUpdate
        );
        if(results > 0)
            return updateOrder;
        else
            return null;
    }
}
