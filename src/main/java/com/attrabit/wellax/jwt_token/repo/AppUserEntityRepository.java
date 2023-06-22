package com.attrabit.wellax.jwt_token.repo;

import com.attrabit.wellax.jwt_token.model.AppUserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AppUserEntityRepository extends JpaRepository<AppUserEntity, UUID> {
    Optional<AppUserEntity> findByEmail (String email);
}