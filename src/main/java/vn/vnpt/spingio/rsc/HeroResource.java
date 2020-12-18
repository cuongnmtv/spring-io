package vn.vnpt.spingio.rsc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.vnpt.spingio.model.Hero;
import vn.vnpt.spingio.svc.HeroService;
import vn.vnpt.spingio.util.ListUtil;
import vn.vnpt.spingio.util.ResponeUtil;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class HeroResource {

	@Autowired
	private HeroService heroService;

	@GetMapping("/heroes")
	public ResponseEntity<?> getHeroes() {
		List<Hero> heroes = null;
		try {
			heroes = heroService.getHeroes();
			if (ListUtil.isNotEmpty(heroes)) {
				return ResponseEntity.ok().body(new ResponeUtil(true, 1, "Lấy dữ liệu hero thành công", heroes));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new ResponeUtil(false, -1, e.getMessage(), null));
		}
		return ResponseEntity.ok().body(new ResponeUtil(false, 0, "Không tìm thấy dữ liệu hero", null));
	}
	
	@GetMapping("/heroes/{id}")
	public ResponseEntity<?> getHero(@PathVariable Long id) {
		Hero hero = null;
		try {
			hero = heroService.getHero(id);
			if (hero != null) {
				return ResponseEntity.ok().body(new ResponeUtil(true, 1, "Lấy dữ liệu hero thành công", hero));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new ResponeUtil(false, -1, e.getMessage(), null));
		}
		return ResponseEntity.ok().body(new ResponeUtil(false, 0, "Không tìm thấy dữ liệu hero", null));
	}

	@PostMapping("/heroes")
	public ResponseEntity<?> addHero(@RequestBody Hero hero) {
		if (hero.getId() != null) {
			return ResponseEntity.badRequest().body(new ResponeUtil(false, 0, "Đã xảy ra lỗi", null));
		}
		try {
			heroService.addHero(hero);
			return ResponseEntity.created(null).body(new ResponeUtil(true, 1, "Thêm hero thành công", hero));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new ResponeUtil(false, -1, e.getMessage(), null));
		}
	}
	
	@DeleteMapping("/heroes/{id}")
	public ResponseEntity<?> deleteHero(@PathVariable Long id) {
		if (id == null) {
			return ResponseEntity.badRequest().body(new ResponeUtil(false, 0, "Đã xảy ra lỗi", null));
		}
		heroService.deleteHero(id);
        return ResponseEntity.ok().body(new ResponeUtil(true, 1, "Xoá thành công hero", null));
	}
}
