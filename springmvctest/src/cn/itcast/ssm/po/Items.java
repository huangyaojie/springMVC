package cn.itcast.ssm.po;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import cn.itcast.ssm.validategroup.ValidateGroup1;
import cn.itcast.ssm.validategroup.ValidateGroup2;

public class Items {
    private Integer itemId;

   @Size(min=1,max=30,message="{items.name.length.error}",groups={ValidateGroup2.class})
    private String itemName;

    private Float itemPrice;

    private String itemBrand;

  @NotNull(message="{items.createtime.is.notnull}",groups={ValidateGroup1.class})
    private Date itemCreateTime;

    private String itemDetail;

	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Float getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Float itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemBrand() {
		return itemBrand;
	}

	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}

	public Date getItemCreateTime() {
		return itemCreateTime;
	}

	public void setItemCreateTime(Date itemCreateTime) {
		this.itemCreateTime = itemCreateTime;
	}

	public String getItemDetail() {
		return itemDetail;
	}

	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}


}