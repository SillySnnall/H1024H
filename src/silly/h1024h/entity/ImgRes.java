package silly.h1024h.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "img_res", schema = "h1024h")
public class ImgRes {
    private int irId;
    private String irUrl;
    private Integer irType = 0;// 封面id
    private Integer irCover = 0;// 是否是封面，1是，0不是
    private String irDetails;// 备注


    private int pageNum = 0;
    private int itemCount = 0;


    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    @Id
    @Column(name = "ir_id", nullable = false)
    public int getIrId() {
        return irId;
    }

    public void setIrId(int irId) {
        this.irId = irId;
    }

    @Basic
    @Column(name = "ir_url", nullable = true, length = 255)
    public String getIrUrl() {
        return irUrl;
    }

    public void setIrUrl(String irUrl) {
        this.irUrl = irUrl;
    }

    @Basic
    @Column(name = "ir_type", nullable = false)
    public int getIrType() {
        return irType;
    }

    public void setIrType(int irType) {
        this.irType = irType;
    }

    @Basic
    @Column(name = "ir_cover", nullable = false)
    public int getIrCover() {
        return irCover;
    }

    public void setIrCover(int irCover) {
        this.irCover = irCover;
    }

    @Basic
    @Column(name = "ir_details", nullable = true, length = 255)
    public String getIrDetails() {
        return irDetails;
    }

    public void setIrDetails(String irDetails) {
        this.irDetails = irDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImgRes imgRes = (ImgRes) o;
        return irId == imgRes.irId &&
                irType.equals(imgRes.irType) &&
                irCover.equals(imgRes.irCover) &&
                Objects.equals(irUrl, imgRes.irUrl) &&
                Objects.equals(irDetails, imgRes.irDetails);
    }

    @Override
    public int hashCode() {

        return Objects.hash(irId, irUrl, irType, irCover, irDetails);
    }

    public ImgRes(String irUrl, Integer irType, Integer irCover) {
        this.irUrl = irUrl;
        this.irType = irType;
        this.irCover = irCover;
    }

    public ImgRes() {
    }
}
