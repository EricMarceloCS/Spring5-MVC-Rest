package dev.ericmarcelo.mvc.rest.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import dev.ericmarcelo.mvc.rest.api.v1.model.VendorDTO;
import dev.ericmarcelo.mvc.rest.domain.Vendor;

@Mapper
public interface VendorMapper {

	VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);
	
	VendorDTO vendorToVendorDTO(Vendor vendor);
	
	Vendor VendorDTOToVendor(VendorDTO vendorDTO);
}
