package com.example.hipple.repository;

import com.example.hipple.domain.Member;
import com.example.hipple.dto.request.MemberDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberDaoImpl implements MemberDao {
    private final JdbcTemplate jdbcTemplate;

    public MemberDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Member> getAllMembers() {
        String sql = "SELECT * FROM members"; // members 테이블에서 모든 회원 정보를 가져오는 SQL 쿼리
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Member member = new Member();
            member.setId(rs.getLong("id"));
            member.setName(rs.getString("name"));
            member.setEmail(rs.getString("email"));
            // 필요한 필드에 대해 추가적인 설정
            return member;
        });
    }
}
