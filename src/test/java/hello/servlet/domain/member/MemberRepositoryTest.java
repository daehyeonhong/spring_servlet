package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRepositoryTest {
    private static final Logger logger = LoggerFactory.getLogger(MemberRepositoryTest.class);
    private static final MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void tearDown() {
        logger.info("memberRepository.clearStore()");
        memberRepository.clearStore();
    }

    @Test
    void save() {
        // given
        final Member member = new Member("hello", 20);

        // when
        final Member savedMember = memberRepository.save(member);

        // then
        final Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll() {
        // given
        final Member member1 = new Member("member1", 20);
        final Member member2 = new Member("member2", 30);
        memberRepository.save(member1);
        memberRepository.save(member2);

        // when
        final List<Member> result = memberRepository.findAll();
        // then
        assertThat(result).hasSize(2);
        assertThat(result).contains(member1, member2);
    }
}
