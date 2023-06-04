package com.example.backendstudy.domain.Repository;

import com.example.backendstudy.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}