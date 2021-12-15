package hello.servlet.domain.member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Member {

    Long id;

    String username;

    int age;

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }

}
