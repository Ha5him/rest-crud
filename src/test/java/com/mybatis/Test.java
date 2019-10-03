package com.mybatis;

import com.mybatis.mapper.ClassMapper;
import com.mybatis.model.ClassNum;
import com.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class Test {
    @org.junit.Test
    public void ml() {
        SqlSession sqlSession = MybatisUtil.getSession();

        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        ClassNum c = new ClassNum();
        c.setClassnum("Java1班");
        c.setTeacher("lihaiqing");
        c.setNumber(45);

        mapper.insert(c);
        sqlSession.commit();

        sqlSession.close();
    }
}







