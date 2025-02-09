package com.example.hipple.dto.request;
import com.example.hipple.domain.Member;
import java.util.List;
public interface MemberDao {
    List<Member> getAllMembers();
}
