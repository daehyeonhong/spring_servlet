package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {
    private final static Map<Long, Member> store = new HashMap<>();
    private static long SEQUENCE = 0L;
    private static final MemberRepository INSTANCE = new MemberRepository();

    public static MemberRepository getInstance() {
        return INSTANCE;
    }

    private MemberRepository() {
    }

    public Member save(final Member member) {
        member.setId(++SEQUENCE);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(final Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
