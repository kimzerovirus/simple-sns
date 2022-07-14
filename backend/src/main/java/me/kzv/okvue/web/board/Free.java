package me.kzv.okvue.web.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.kzv.okvue.web.common.BaseEntity;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Free extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String title;

    @Column(columnDefinition = "text")
    private String content;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private Account account;
}
