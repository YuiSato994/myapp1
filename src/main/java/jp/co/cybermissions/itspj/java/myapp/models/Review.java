package jp.co.cybermissions.itspj.java.myapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // カテゴリー
    @Size(max=15)
    @Column(name="category")
    private String category;

    // 商品名
    @Size(max=15)
    @Column(name="itemname", nullable=true)
    private String itemname;

    // ユーザー名
    @Size(max=10)
    @Column(name="username", nullable=true)
    private String username;

    // 口コミ
    @Size(max=50)
    @Column(name="comment", nullable=true)
    private String comment;

    // 評価

}
