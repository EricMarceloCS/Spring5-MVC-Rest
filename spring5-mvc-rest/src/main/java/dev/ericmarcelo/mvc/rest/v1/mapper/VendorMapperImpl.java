package dev.ericmarcelo.mvc.rest.v1.mapper;

import org.springframework.stereotype.Component;

import dev.ericmarcelo.mvc.rest.api.v1.model.VendorDTO;
import dev.ericmarcelo.mvc.rest.domain.Vendor;

@Component
public class VendorMapperImpl implements VendorMapper {

	@Override
	public VendorDTO vendorToVendorDTO(Vendor vendor) {
		VendorDTO vendorDTO = new VendorDTO();
		vendorDTO.setName(vendor.getName());
		return vendorDTO;
	}

	@Override
	public Vendor VendorDTOToVendor(VendorDTO vendorDTO) {
		Vendor vendor = new Vendor();
		vendor.setName(vendorDTO.getName());
		return vendor;
	}

}
