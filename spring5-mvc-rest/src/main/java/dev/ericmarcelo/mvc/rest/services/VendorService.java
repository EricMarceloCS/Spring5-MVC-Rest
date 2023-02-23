package dev.ericmarcelo.mvc.rest.services;

import dev.ericmarcelo.mvc.rest.api.v1.model.VendorDTO;
import dev.ericmarcelo.mvc.rest.api.v1.model.VendorListDTO;

public interface VendorService {

	VendorListDTO getAllVendors();

	VendorDTO getVendorById(Long id);

	VendorDTO createNewVendor(VendorDTO vendorDTO);

	VendorDTO saveVendorByDTO(Long id, VendorDTO vendorDTO);

	void deleteVendorById(Long id);

}
