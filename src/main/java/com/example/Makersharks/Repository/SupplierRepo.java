package com.example.Makersharks.Repository;

import com.example.Makersharks.Module.Supplier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepo extends CrudRepository<Supplier,Integer> {
    @Query("select m from Supplier m where m.location=:location")
    List<Supplier> findByLocation(@Param("location") String location);

    @Query("select m from Supplier m where m.nature_of_business=:nature")
    List<Supplier> findByNature(@Param("nature") String Nature);

    @Query("select m from Supplier m where m.manufacturing_processes=:process")
    List<Supplier> findByManufactureProcess(@Param("process") String Process);

    @Query("select m from Supplier m where m.location=:location AND m.nature_of_business=:nature_of_business AND m.manufacturing_processes=:manufacturing_process")
    List<Supplier> findByLocationAndNatureOfBusinessAndManufacturingProcesses(@Param("location") String location,@Param("nature_of_business") String nature_of_business,@Param("manufacturing_process") String manufacturing_process);

    @Query("SELECT m FROM Supplier m WHERE m.location = :location AND m.nature_of_business = :natureOfBusiness AND m.manufacturing_processes =:manufacturingProcesses")
    List<Supplier> findSuppliers(@Param("location") String location,
                                 @Param("natureOfBusiness") String natureOfBusiness,
                                 @Param("manufacturingProcesses") String manufacturingProcesses);


}

