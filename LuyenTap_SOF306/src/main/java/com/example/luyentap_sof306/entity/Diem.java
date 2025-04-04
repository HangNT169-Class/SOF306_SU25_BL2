package com.example.luyentap_sof306.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "diem")
@AllArgsConstructor
@NoArgsConstructor
public class Diem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ma_diem", length = 20)
    private String maDiem;

    @ManyToOne
    @JoinColumn(name = "sinh_vien_id", referencedColumnName = "id")
    private SinhVien sinhVien;

    @Nationalized
    @Column(name = "mon_hoc", length = 100)
    private String monHoc;

    @Column(name = "diem_so")
    private Double diemSo;

}