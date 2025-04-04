package com.example.luyentap_sof306.repository;

import com.example.luyentap_sof306.entity.Diem;
import com.example.luyentap_sof306.response.DiemResponse;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiemRespository extends JpaRepository<Diem,Integer> {
    // custom model

    @Query("""
        SELECT 
          new com.example.luyentap_sof306.response.DiemResponse
          (d.id,d.maDiem,d.monHoc,d.diemSo,d.sinhVien.maSinhVien,d.sinhVien.hoTen)
        FROM Diem d
    """)
    List<DiemResponse> layDanhSachDiemResponse();

    @Query("""
        SELECT 
          new com.example.luyentap_sof306.response.DiemResponse
          (d.id,d.maDiem,d.monHoc,d.diemSo,d.sinhVien.maSinhVien,d.sinhVien.hoTen)
        FROM Diem d
    """)
    Page<DiemResponse> phanTrangDanhSachDiem(Pageable pageable);

    // custom lai remove
    @Modifying // BAT BUOC KHI THUC HIEN TRUY VAN UPDATE HOAC DELETE
    @Transactional // CAN CO DE DAM BAO TRANSATION KHI THUC HIEN THAO THAY DOI DB => TOAN VEN
    @Query("DELETE FROM Diem  d WHERE d.maDiem = ?1")
    void removeDiemBangMa(String ma);

    @Query("""
        SELECT 
          new com.example.luyentap_sof306.response.DiemResponse
          (d.id,d.maDiem,d.monHoc,d.diemSo,d.sinhVien.maSinhVien,d.sinhVien.hoTen)
        FROM Diem d
        WHERE d.id = ?1
    """)
    DiemResponse detailDiem(Integer id);
}
