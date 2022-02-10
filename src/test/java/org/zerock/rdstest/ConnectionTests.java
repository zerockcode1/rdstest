package org.zerock.rdstest;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@SpringBootTest
@Log4j2
public class ConnectionTests {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testConnection() {

        try(Connection connection = dataSource.getConnection()){

            log.info("--------------------------------------------");

            log.info(connection);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testTime() {

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select now()");
            ResultSet resultSet = preparedStatement.executeQuery();
        ){

            log.info("--------------------------------------------");

            resultSet.next();

            log.info(resultSet.getString(1));


        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
