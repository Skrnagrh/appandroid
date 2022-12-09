package com.example.loginregister_mysql_volley;

public class Data {

    private String id, namaBarang, hargaBarang, supplier;

    Data(String id, String namaBarang, String hargaBarang, String supplier) {
        this.setId(id);
        this.setNamaBarang(namaBarang);
        this.setHargaBarang(hargaBarang);
        this.setSupplier(supplier);
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(String hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
