package bug.creator.studentmanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "subjects")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subject {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @Column(name = "name_sj", nullable = false)
    private String nameSj;

    @Column(name = "hedaotao")
    private String heDaoTao;

    @Column(name = "nhom_chuyen_mon")
    private String nhomChuyenMon;

    @Column(name = "so_tin_chi")
    private Integer soTinChi;

    @Column(name = "so_gio_lt")
    private Integer soGioLt;

    @Column(name = "so_gio_bt")
    private Integer soGioBt;

    @Column(name = "so_gio_th")
    private Integer soGioTh;

    @Column(name = "hinh_thuc_thi_ck")
    private String hinhThucThiCk;

    @Column(name = "ngay_tao")
    private LocalDateTime ngayTao;

    @Column(name = "ngay_update")
    private LocalDateTime ngayUpdate;

    @Column(name = "mo_ta_hp", columnDefinition = "TEXT")
    private String moTaHp;

    @Column(name = "tom_tat_hp", columnDefinition = "TEXT")
    private String tomTatHp;
}