package com.example.luyentap_sof306.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DiemResponse {
    // liet ke tat ca cac thuoc tinh nhu yeu cau muon hien thi
//    Viết API hiển thị danh sách bảng Điểm gồm các trường sau:
//    ID, Mã điểm, Môn học, Điểm số, Mã sinh viên, Tên sinh viên  sử dụng method GET
    // phai dung kieu du lieu vs entity - Co the de kieu du lieu khac nhung tuy tinh huong
    // thong thuong se giong entiy
    private Integer id;

    private String ma;

    private String monHoc;

    private Double diemSo;

    private String maSinhVien;

    private String hoTen;

}
