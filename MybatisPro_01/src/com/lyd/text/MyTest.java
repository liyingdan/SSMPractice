package com.lyd.text;

import com.lyd.domain.Customer;
import com.lyd.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class MyTest {
    private SqlSession sqlSession = MybatisUtil.openSession();

    @Test
    public void test() throws IOException {
       /* //1.加载配置文件
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //2.读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMappingConfig.xml");
        //3.获取session工厂
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        //4.获取会话---JDBC连接
        SqlSession sqlSession = sessionFactory.openSession();*/

//       SqlSession sqlSession = MybatisUtil.openSession();
        //5.执行sql
        Customer customer = sqlSession.selectOne("queryCustomerById", 1);
        System.out.println(customer);
        //6.释放资源
        sqlSession.close();
    }

    @Test
    public void test2(){
//        SqlSession sqlSession = MybatisUtil.openSession();
        /*查询所有的用户*/
        List<Customer> queryAllCustomer = sqlSession.selectList("queryAllCustomers");
        for (Customer customer : queryAllCustomer) {
            System.out.println(customer);
        }
        sqlSession.close();

    }//        List<Customer> customers = sqlSession.selectList("queryCustomerByName", "李");


    @Test
    public void test3() {
        /*SELECT * from customer WHERE cust_name LIKE '%#{cust_name}%'： SELECT * from customer WHERE cust_name LIKE '%?%';
         SELECT * from customer WHERE cust_name LIKE '%${value}%':  SELECT * from customer WHERE cust_name LIKE '%李%'
        * */

        /*根据名字模糊查询*/
        List<Customer> customers = sqlSession.selectList("queryCustomerByName", "%李%");
        //List<Customer> customers = sqlSession.selectList("queryCustomerByName", "李");
        System.out.println(customers);
        sqlSession.close();

    }


    @Test
    public void insert(){
        Customer customer = new Customer();
        customer.setCust_name("公孙离");
        customer.setCust_profession("射手");
        customer.setCust_phone("12354488");
        customer.setEmail("2315666@163.com");
        sqlSession.insert("insertCustomer",customer);
        //当要改动数据库当中的记录时，执行sql时要自己提交事务
        //手动提交事务
        sqlSession.commit();
        System.out.println(customer);
        sqlSession.close();
    }

    @Test
    public void update(){
        Customer customer = sqlSession.selectOne("queryCustomerById", 12);
        customer.setCust_name("李元芳");
        customer.setEmail("3665599@163.com");
        sqlSession.update("updateCustomerById",customer);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void delete(){
        Customer customer = sqlSession.selectOne("queryCustomerById", 12);
        sqlSession.delete("deleteCustomer",customer);
        sqlSession.commit();
        sqlSession.close();
    }




}
