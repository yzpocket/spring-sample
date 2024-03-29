//package com.example.demoapp.repository;
//
//import com.example.demoapp.domain.Member;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//public class JdbcTemplateMemberRepository implements MemberRepository{
//
//    private final JdbcTemplate jdbcTemplate;
//
//    public JdbcTemplateMemberRepository(DataSource dataSource) {
//        jdbcTemplate = new JdbcTemplate(dataSource);
//    }
//
//    @Override
//    public Member save(Member member) {
//        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
//        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");
//
//        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("name", member.getName());
//        // 위 SimpleJdbcInsert클래스를 통해 쿼리문 직접 작성 없이 쿼리가 작성됨.
//
//        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
//        member.setId(key.longValue());
//        return member;
//    }
//
//    @Override
//    public Optional<Member> findById(Long id) {
//        List<Member> result = jdbcTemplate.query("select * from member where id = ?", memberRowMapper(), id);
//        return result.stream().findAny();
//    }
//    //순수 JDBC보다 템플릿을 통해 많은 코드를 줄일 수 있다.
//
//    @Override
//    public Optional<Member> findByName(String name) {
//        List<Member> result = jdbcTemplate.query("select * from member where name = ?", memberRowMapper(), name);
//        return result.stream().findAny();
//    }
//
//    @Override
//    public List<Member> findAll() {
//        return jdbcTemplate.query("select * from member", memberRowMapper());
//    }
//
//    private RowMapper<Member> memberRowMapper(){
//        return (rs, rowNum) -> {
//            Member member = new Member();
//            member.setId(rs.getLong("id"));
//            member.setName(rs.getString("name"));
//            return member;
//        };
//    }
//}
