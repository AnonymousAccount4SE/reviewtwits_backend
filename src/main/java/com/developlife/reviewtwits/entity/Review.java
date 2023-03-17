package com.developlife.reviewtwits.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

/**
 * @author WhalesBob
 * @since 2023-03-13
 */

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id @GeneratedValue
    private long reviewId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ColumnDefault(value = "false")
    private boolean certificationFlag = false;

    @ColumnDefault(value = "true")
    private boolean exist = true;

    private String content;

    private String productUrl;

    private int score;

    @Transient
    @Setter
    private List<String> reviewImageNameList;
}