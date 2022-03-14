package com.mikaelparsekyan.memberservice.service;

import com.mikaelparsekyan.memberservice.persistence.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;



}
