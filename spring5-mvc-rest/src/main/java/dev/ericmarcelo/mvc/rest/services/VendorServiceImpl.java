package dev.ericmarcelo.mvc.rest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ericmarcelo.mvc.rest.api.v1.model.VendorDTO;
import dev.ericmarcelo.mvc.rest.api.v1.model.VendorListDTO;
import dev.ericmarcelo.mvc.rest.domain.Customer;
import dev.ericmarcelo.mvc.rest.domain.Vendor;
import dev.ericmarcelo.mvc.rest.repositories.VendorRepository;
import dev.ericmarcelo.mvc.rest.v1.mapper.VendorMapper;

@Service
public class VendorServiceImpl implements VendorService {
	
	private final VendorRepository vendorRepository;
	private final VendorMapper vendorMapper;
	
	@Autowired
	public VendorServiceImpl(VendorRepository vendorRepository, VendorMapper vendorMapper) {
		super();
		this.vendorRepository = vendorRepository;
		this.vendorMapper = vendorMapper;
	}

	@Override
	public VendorListDTO getAllVendors() {
		
		VendorListDTO vendorListDTO = new VendorListDTO(vendorRepository
				.findAll()
				.stream()
				.map(vendorMapper::vendorToVendorDTO)
				.toList());
		
		return vendorListDTO;
	}

	@Override
	public VendorDTO getVendorById(Long id) {
		
		return vendorMapper.vendorToVendorDTO(vendorRepository.findById(id).orElseThrow());
	}

	@Override
	public VendorDTO createNewVendor(VendorDTO vendorDTO) {
		Vendor vendor = vendorMapper.VendorDTOToVendor(vendorDTO);
		Vendor savedVendor = vendorRepository.save(vendor);
		vendor.setId(savedVendor.getId());
		
		return vendorMapper.vendorToVendorDTO(savedVendor);
	}

	@Override
	public VendorDTO saveVendorByDTO(Long id, VendorDTO vendorDTO) {
		Vendor vendor = vendorMapper.VendorDTOToVendor(vendorDTO);
		vendor.setId(id);
		return vendorMapper.vendorToVendorDTO(vendorRepository.save(vendor));
	}

	@Override
	public void deleteVendorById(Long id) {
		Optional<Vendor> optionalVendor = vendorRepository.findById(id);
		if(optionalVendor.isEmpty()) {
			return;
		}
		vendorRepository.deleteById(id);
	}

}
