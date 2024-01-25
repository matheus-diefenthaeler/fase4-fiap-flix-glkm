package br.com.fiap.fase4streamingvideos.adapter.repository;

import br.com.fiap.fase4streamingvideos.adapter.gateways.mapper.UserJpaMapper;
import br.com.fiap.fase4streamingvideos.adapter.gateways.mapper.VideoJpaMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserJpaMapper, String> {
    Boolean existsByEmail(String title);
}
