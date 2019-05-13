package com.geek.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UserCommentTask")
public class UserCommentTask implements Serializable {

    private static final long serialVersionUID = -4304389230803478681L;
    @Id
    @Column(name = "commitId")
    @GeneratedValue(generator = "IdStrategy")
    @GenericGenerator(name = "IdStrategy", strategy = "assigned")
    private String commitId;

    @Column(name = "taskId")
    private String taskId;


    @Column(name = "userId")
    private String userId;


    @Column(name = "comment")
    private String comment; // 报名原因

    @Column(name = "submitTime")
    private Date submitTime; // 报名时间
}
