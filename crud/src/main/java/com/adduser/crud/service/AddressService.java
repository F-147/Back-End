package com.adduser.crud.service;

import java.util.ArrayList;
import java.util.List;

import com.adduser.crud.Repository.AddressRepository;
import com.adduser.crud.Repository.AddressTypeRepository;
import com.adduser.crud.Repository.ThDistrictRepository;
import com.adduser.crud.Repository.ThProvinceRepository;
import com.adduser.crud.Repository.ThSubdistrictRepository;
import com.adduser.crud.Repository.UserRepository;
import com.adduser.crud.model.Address;
import com.adduser.crud.model.AddressModel;
import com.adduser.crud.model.AddressType;
import com.adduser.crud.model.ThDistrict;
import com.adduser.crud.model.ThProvince;
import com.adduser.crud.model.ThSubdistrict;
import com.adduser.crud.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
	@Autowired
	private AddressTypeRepository addressTypeRepository;
	@Autowired
	private ThProvinceRepository provinceRepository;
	@Autowired
	private ThDistrictRepository districtRepository;
	@Autowired
	private ThSubdistrictRepository subdistrictRepository;
	@Autowired
	private UserRepository userRepository;

    public List<ThProvince> getAllProvince() {
		return this.provinceRepository.findAll();
	}

	public List<ThDistrict> getAllDistrict() {
		return this.districtRepository.findAll();
	}

	
	public List<ThSubdistrict> getAllSubdistrict() {
		return this.subdistrictRepository.findAll();
	}

	public List<ThDistrict> getDistrict(Long provinceId) {
		return this.districtRepository.findByProvinceId(provinceId);
	}

	public ThDistrict getDistrictByName(String districtName) {
		return this.districtRepository.findByNameTh(districtName);
	}

	public ThDistrict searchDistrictByName(String districtName) {
		return this.districtRepository.searchNameTh(districtName);
	}

	// forward
	public List<ThSubdistrict> getSubDistrict(Long districtId) {
		return this.subdistrictRepository.findByDistrictId(districtId);
	}

	// Address
	public List<Address> findAddressAll() {
		return addressRepository.findAll();
	}

	public Address findAddressById(long id) {
		return addressRepository.findById(id);
	}
	
	public ThProvince getProvinceById(long id) {
		return provinceRepository.findById(id);
	}
	
	public ThDistrict getDistrictById(long id) {
		return districtRepository.findById(id);
	}
	public ThSubdistrict getSubdistrctById(long id) {
		return subdistrictRepository.findById(id);
	}

	// Entity to Model
	public List<AddressModel> findAddressModelAll() {
		List<AddressModel> AddressModelList = new ArrayList<AddressModel>();
		for (Address address : findAddressAll()) {

			AddressModel AddressModel = new AddressModel();

			AddressModel.setId(address.getId());
			AddressModel.setAddressNo(address.getAddressNo());
			AddressModel.setAddressTypeId(address.getAddressType().getId());
			AddressModel.setProvinceId(address.getProvinceId().getId());
			AddressModel.setDistrictId(address.getDistrictId().getId());
			AddressModel.setSubDistrictId(address.getSubDistrictId().getId());
			AddressModel.setFullAddress(address.getFullAddress());
			//AddressModel.setUserId(address.getUserId().getId());
			AddressModelList.add(AddressModel);
		}
		return AddressModelList;
	}

	// Entity to Model
	public AddressModel findAddressModelById(long id) {

		Address address = findAddressById(id);

		AddressModel AddressModel = new AddressModel();

		AddressModel.setId(address.getId());
		AddressModel.setAddressNo(address.getAddressNo());
		AddressModel.setAddressTypeId(address.getAddressType().getId());
		AddressModel.setProvinceId(address.getProvinceId().getId());
		AddressModel.setDistrictId(address.getDistrictId().getId());
		AddressModel.setSubDistrictId(address.getSubDistrictId().getId());
		AddressModel.setFullAddress(address.getFullAddress());
		

		return AddressModel;
	}

	// Model to Entity
	public Boolean InsertAddress(AddressModel AddressModel) {
		if (AddressModel != null) {
			Address AddressTb = new Address();

			AddressType addressTypeTb = addressTypeRepository.getById(AddressModel.getAddressTypeId());
			ThProvince provinceTb = provinceRepository.getById(AddressModel.getProvinceId());
			ThDistrict districtTb = districtRepository.getById(AddressModel.getDistrictId());
			ThSubdistrict subdistrictTb = subdistrictRepository.getById(AddressModel.getSubDistrictId());
			

			AddressTb.setAddressNo(AddressModel.getAddressNo());
			
			AddressTb.setAddressType(addressTypeTb);
			AddressTb.setProvinceId(provinceTb);
			AddressTb.setDistrictId(districtTb);
			AddressTb.setSubDistrictId(subdistrictTb);

			addressRepository.save(AddressTb);
			
			return true;
		}
		return false;

	}

	// Model to Entity
	public Boolean UpdateAddress(AddressModel AddressModel) {

		try {
			Address AddressTb = findAddressById(AddressModel.getId());
			if (AddressTb != null) {
				if (!ObjectUtils.isEmpty(AddressModel.getAddressNo())) {
					AddressTb.setAddressNo(AddressModel.getAddressNo());
				}

				if (!ObjectUtils.isEmpty(AddressModel.getAddressTypeId())) {
					AddressType addressTypeTb = addressTypeRepository.getById(AddressModel.getAddressTypeId());
					AddressTb.setAddressType(addressTypeTb);
				}

				if (!ObjectUtils.isEmpty(AddressModel.getProvinceId())) {
					ThProvince provinceTb = provinceRepository.getById(AddressModel.getProvinceId());
					AddressTb.setProvinceId(provinceTb);
				}

				if (!ObjectUtils.isEmpty(AddressModel.getDistrictId())) {
					ThDistrict districtTb = districtRepository.getById(AddressModel.getDistrictId());
					AddressTb.setDistrictId(districtTb);
				}

				if (!ObjectUtils.isEmpty(AddressModel.getSubDistrictId())) {
					ThSubdistrict subdistrictTb = subdistrictRepository.getById(AddressModel.getSubDistrictId());
					AddressTb.setSubDistrictId(subdistrictTb);
				}
				if (!ObjectUtils.isEmpty(AddressModel.getUserId())) {
					User userTb = userRepository.getById( AddressModel.getUserId());
				}
				addressRepository.save(AddressTb);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println("On Error: " + e);
			return false;
		}

	}

	public String deleteAddressById(long id) {
		try {
			addressRepository.deleteById(id);
			return "Address Deleted Successfully";
		} catch (Exception e) {
			return e + "";
		}
	}

    
}
