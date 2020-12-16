package vn.vnpt.spingio.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.vnpt.spingio.model.Hero;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long>{

}
