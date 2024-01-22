package br.com.fiap.fase4streamingvideos.adapter.repository;

import br.com.fiap.fase4streamingvideos.adapter.gateways.mapper.VideoJpaMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVideoRepository extends JpaRepository<VideoJpaMapper, Long> {
    Boolean existsByTitle(String title);

    Page<VideoJpaMapper> findAll(Pageable pageable);
}
