package vn.vnpt.spingio.rsc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.vnpt.spingio.model.Hero;
import vn.vnpt.spingio.svc.HeroService;
import vn.vnpt.spingio.util.ListUtil;
import vn.vnpt.spingio.util.ResponeUtil;

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
}
