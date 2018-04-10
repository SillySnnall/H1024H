package silly.h1024h.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class ImgRes {
    private int irId;
    private String irUrl = "";
    private Integer irType = 0;
    private Integer irCover = 0;
    private int pageNum = 0;
    private int itemCount = 0;

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
    public Integer getIrType() {
        return irType;
    }

    public void setIrType(Integer irType) {
        this.irType = irType;
    }

    @Basic
    @Column(name = "ir_cover", nullable = false)
    public Integer getIrCover() {
        return irCover;
    }

    public void setIrCover(Integer irCover) {
        this.irCover = irCover;
    }




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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImgRes imgRes = (ImgRes) o;
        return irId == imgRes.irId &&
                Objects.equals(irUrl, imgRes.irUrl) &&
                Objects.equals(irType, imgRes.irType) &&
                Objects.equals(irCover, imgRes.irCover);
    }

    @Override
    public int hashCode() {
        return Objects.hash(irId, irUrl, irType, irCover);
    }

    public ImgRes(String irUrl, Integer irType, Integer irCover) {
        this.irUrl = irUrl;
        this.irType = irType;
        this.irCover = irCover;
    }

    public ImgRes() {
    }
}
