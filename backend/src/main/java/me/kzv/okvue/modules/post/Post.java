package me.kzv.okvue.modules.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.kzv.okvue.modules.common.BaseEntity;

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
//    private Account writer;

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
