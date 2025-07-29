package com.algar.query_dlr_api.repository;

import com.algar.query_dlr_api.model.Dlr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DlrRepository extends
        JpaRepository<Dlr, String>,
        JpaSpecificationExecutor<Dlr> {

}
