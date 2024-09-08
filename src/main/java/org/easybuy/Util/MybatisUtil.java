package org.easybuy.Util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class MybatisUtil {
    private  static SqlSessionFactory sqlSessionFactory;

        static {
            try {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        public static SqlSession getSqlSessionFactory() {
            return sqlSessionFactory.openSession(true);
        }
}
