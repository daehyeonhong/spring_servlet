package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member("Hong", 20);

        //when
        Member savedMember = this.memberRepository.save(member);

        //then
        assertThat(this.memberRepository.findById(savedMember.getId())).isEqualTo(savedMember);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 20);
        Member member3 = new Member("member3", 20);

        this.memberRepository.save(member1);
        this.memberRepository.save(member2);
        this.memberRepository.save(member3);

        //when
        List<Member> result = this.memberRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(3);
        assertThat(result).contains(member1, member2, member3);
    }

}
