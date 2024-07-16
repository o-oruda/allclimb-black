package io.ooruda.allclimb.user.member.domain.entity;

import io.ooruda.allclimb.user.common.BaseTimeEntity;
import io.ooruda.allclimb.user.member.domain.constants.Role;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // Getter 생성
@NoArgsConstructor // Default 생성자
@Entity // Entity임을 명시
@Table(name = "users") // 테이블명 설정
public class Member extends BaseTimeEntity { // BaseTimeEntity 상속
    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Column(nullable = false) // nullable하지 않도록 설정
    private String name;
	
    @Column(nullable = false)
    private String email;
	
    @Column
    private String picture;
	
    @Enumerated(EnumType.STRING) // Enum 값 저장
    @Column(nullable = false)
    private Role role;
	
    @Builder // Builder Pattern 사용
    public Member(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }
	
    // update 함수 구현
    public Member update(String name, String picture) {
        this.name = name;
        this.picture = picture;
		
        return this;
    }
	
    public String getRoleKey() {
        return this.role.getKey();
    }
}