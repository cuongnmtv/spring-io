package vn.vnpt.spingio.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.vnpt.spingio.model.Hero;
import vn.vnpt.spingio.repo.HeroRepository;

@Service
public class HeroService {

	@Autowired
	private HeroRepository heroRepository;

	public List<Hero> getHeroes() {
		return heroRepository.findAll();
	}
	
	public Hero getHero(Long id) {
		return heroRepository.getOne(id);
	}

	public void addHero(Hero hero) {
		heroRepository.save(hero);
	}
	
	public void deleteHero(Long id) {
		heroRepository.deleteById(id);
	}
}
