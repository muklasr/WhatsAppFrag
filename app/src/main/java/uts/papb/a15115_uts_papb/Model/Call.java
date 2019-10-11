package uts.papb.a15115_uts_papb.Model;

public class Call {
    private String nama;
    private String waktu;
    private String foto;

    public Call(String nama, String waktu, String foto) {
        this.nama = nama;
        this.waktu = waktu;
        this.foto = foto;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
