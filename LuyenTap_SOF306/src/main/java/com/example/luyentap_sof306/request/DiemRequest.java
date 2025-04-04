package com.example.luyentap_sof306.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiemRequest {

    // liet ke cac thuoc tinh muon add (de se phai cho)
    private String maDiem;

    private String monHoc;

    private Double diemSo;

    private Integer sinhVienID;

}
