package com.attrabit.wellax.jwt_token.repo;

import com.attrabit.wellax.jwt_token.model.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TokenRepository extends JpaRepository<TokenEntity, UUID> {
    @Query(value = """
      select t from TokenEntity t inner join AppUserEntity u on t.user.id = u.id
      where u.id = :userId and (t.expired = false or t.revoked = false )
      """)
    List<TokenEntity> findAllValidTokenByUser(UUID userId);
    Optional<TokenEntity> findByToken(String token);
}

