package com.example.luyentap_sof306.repository;

import com.example.luyentap_sof306.entity.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien,Integer> {
}
