package uts.papb.a15115_uts_papb.Model;

public class Chat {
    private String nama;
    private String isi;
    private String waktu;
    private String foto;

    public Chat(String nama, String isi, String waktu, String foto) {
        this.nama = nama;
        this.isi = isi;
        this.waktu = waktu;
        this.foto = foto;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
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
