package dev.ericmarcelo.mvc.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.ericmarcelo.mvc.rest.domain.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {

}
