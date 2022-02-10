package com.adduser.crud.model;

public class AddressModel {
	private Long id;
	
	private String addressNo;
	private long addressTypeId;
	private long provinceId;
	private long districtId;
	private long subDistrictId;
	private long userId;
	
	private String fullAddress;

	public AddressModel() {

	}


	public AddressModel(Long id, String addressNo, long addressTypeId, long provinceId, long districtId,
			long subDistrictId, long userId, String fullAddress) {
		super();
		this.id = id;
		this.addressNo = addressNo;
		this.addressTypeId = addressTypeId;
		this.provinceId = provinceId;
		this.districtId = districtId;
		this.subDistrictId = subDistrictId;
		this.userId = userId;
		this.fullAddress = fullAddress;
	}



	public long getUserId() {
		return userId;
	}



	public void setUserId(long userId) {
		this.userId = userId;
	}



	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddressNo() {
		return addressNo;
	}

	public void setAddressNo(String addressNo) {
		this.addressNo = addressNo;
	}

	public long getAddressTypeId() {
		return addressTypeId;
	}

	public void setAddressTypeId(long addressTypeId) {
		this.addressTypeId = addressTypeId;
	}

	public long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(long provinceId) {
		this.provinceId = provinceId;
	}

	public long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	public long getSubDistrictId() {
		return subDistrictId;
	}

	public void setSubDistrictId(long subDistrictId) {
		this.subDistrictId = subDistrictId;
	}

}
