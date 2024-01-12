package br.com.fiap.fase4streamingvideos.adapter.repository;

import br.com.fiap.fase4streamingvideos.adapter.gateways.mapper.VideoJpaMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVideoRepository extends JpaRepository<VideoJpaMapper, Long> {
    public Boolean existsByTitle(String title);
}
