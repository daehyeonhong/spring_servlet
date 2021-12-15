package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MemberRepository {

    private static final Map<Long, Member> store = new ConcurrentHashMap<>();
    private static final MemberRepository instance = new MemberRepository();
    private static AtomicLong sequence = new AtomicLong();

    private MemberRepository() {
    }

    public static MemberRepository getInstance() {
        return instance;
    }

    public Member save(Member member) {
        member.setId(sequence.incrementAndGet());
        this.store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return this.store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }

}
