package com.example.luyentap_sof306.controller;

import com.example.luyentap_sof306.entity.Diem;
import com.example.luyentap_sof306.entity.SinhVien;
import com.example.luyentap_sof306.repository.DiemRespository;
import com.example.luyentap_sof306.repository.SinhVienRepository;
import com.example.luyentap_sof306.request.DiemRequest;
import com.example.luyentap_sof306.response.DiemResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiemController {
    // xml , json
    // @RestController => default json {} => tra ve kieu du lieu tuy y
//    <h1>
//    </h1>
//    {
//
//    }
//    {
//        sv:1,
//        ten:'anc'
//    }
//    <sv>1</sv>

    @Autowired
    private DiemRespository diemRespository;

    @Autowired
    private SinhVienRepository sinhVienRepository;

    // 4 HTTP method: get, post, put, delete
    // hien thi => GET
//    Viết API hiển thị danh sách bảng Điểm gồm các trường sau:
//    ID, Mã điểm, Môn học, Điểm số, Mã sinh viên, Tên sinh viên  sử dụng method GET

//    @GetMapping("/api/diem/hien-thi")
//    public List<Diem>getAll(){
//        return diemRespository.findAll();
//    }

    @GetMapping("/api/diem/hien-thi")
    public List<DiemResponse> getAll() {
        return diemRespository.layDanhSachDiemResponse();
    }

    @GetMapping("/api/diem/phan-trang")
    public List<DiemResponse> phanTrang(@RequestParam(value = "pageNo1",
            required = false, defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        return diemRespository.phanTrangDanhSachDiem(pageable).getContent();
    }

    // Add => Post
    // Update => Put
    // Delete => Delete
    @PostMapping("/api/diem/add")
    public String addDiemSinhVien(@RequestBody DiemRequest diemRequest) {
        // Co the validate tai day => Spring validate & hander expension
        // https://viblo.asia/p/xu-ly-exception-phat-sinh-trong-ung-dung-spring-boot-6J3ZgWkLZmB
        // Co: diemRequest can diem
        // => convert
        Diem diem = new Diem();
        BeanUtils.copyProperties(diemRequest, diem);
        // Sau dong 68: nhung thuoc tinh nao chung nhau thi se duoc tu dong mapping
        // LUU Y: TEN TRONG ENTITY PHAI TRUNG VOI TEN TRONG REQUEST
        // set thuoc tinh con lai ma chua set duoc
        // dang co: sinhVienID
        // can: Object sv
        SinhVien sv = sinhVienRepository.findById(diemRequest.getSinhVienID()).get();
        diem.setSinhVien(sv);
        diemRespository.save(diem);
        return "Them sv thanh cong";
    }

    @PutMapping("/api/diem/update/{id}")
    public String updateDiemSinhVien(@RequestBody DiemRequest diemRequest,
                                     @PathVariable("id") Integer id) {
        // Co the validate tai day => Spring validate & hander expension
        // https://viblo.asia/p/xu-ly-exception-phat-sinh-trong-ung-dung-spring-boot-6J3ZgWkLZmB
        // Co: diemRequest can diem
        // => convert
        Diem diem = new Diem();
        BeanUtils.copyProperties(diemRequest, diem);
        // Sau dong 68: nhung thuoc tinh nao chung nhau thi se duoc tu dong mapping
        // LUU Y: TEN TRONG ENTITY PHAI TRUNG VOI TEN TRONG REQUEST
        // set thuoc tinh con lai ma chua set duoc
        // dang co: sinhVienID
        // can: Object sv
        SinhVien sv = sinhVienRepository.findById(diemRequest.getSinhVienID()).get();
        diem.setSinhVien(sv);
        diem.setId(id);
        diemRespository.save(diem);
        return "Update sv thanh cong";
    }

//    @DeleteMapping("/api/diem/remove")
//    public String removeDiemSinhVien(@RequestParam("id") Integer id) {
//        diemRespository.deleteById(id);
//        return "Xoa sv thanh cong";
//    }
//
    @DeleteMapping("/api/diem/remove")
    public String removeDiemSinhVien(@RequestParam("id") String id) {
        diemRespository.removeDiemBangMa(id);
        return "Xoa sv thanh cong";
    }
    @GetMapping("/api/diem/detail")
    public DiemResponse detailDiemSinhVien(@RequestParam("id") Integer id) {
        return diemRespository.detailDiem(id);
    }
}
