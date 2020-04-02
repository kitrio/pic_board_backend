package com.j.board.service;

import java.util.List;

import com.j.board.domain.BoardVO;
import com.j.board.domain.MemberVO;
import com.j.board.persistence.MemberMapper;
import com.j.board.security.CustomMember;
import org.apache.ibatis.javassist.bytecode.DuplicateMemberException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

  private final MemberMapper memberMapper;
  private final PasswordEncoder bCryptPasswordEncoder;

  public MemberServiceImpl(MemberMapper memberMapper, PasswordEncoder bCryptPasswordEncoder) {
    this.memberMapper = memberMapper;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  @Override
  public boolean signUpMember(MemberVO member) {
    boolean isSuccess;
    member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
    try {
      isSuccess =  memberMapper.signUpMember(member);
      } catch (Exception e) {
      e.printStackTrace();
        return false;
    }
    return isSuccess;
  }

  @Override
  public List<BoardVO> searchMemberContents(String nickname) {
    List<BoardVO> memberContents;
    try {
      memberContents = memberMapper.selectByMemberContent(nickname);
    } catch (Exception e) {
      return null;
    }
  return memberContents;
  }

  @Override
  public boolean modifyMember(MemberVO member) {
    return true;
  }

  @Override
  public MemberVO getMyInfo(CustomMember principal, String password) {
    String memberPassword = bCryptPasswordEncoder.encode(password);
    MemberVO member = null;
    if(principal.getPassword().equals(memberPassword)){
        member = memberMapper.selectMyInfo(principal.getUsername());
    }
    return member;
  }

  @Override
  public boolean deleteMember(String memberId) {
    return memberMapper.deleteMember(memberId) == 1;
  }


}